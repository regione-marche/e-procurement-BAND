package it.eldasoft.w9.web.struts;

import it.eldasoft.gene.bl.GeneManager;
import it.eldasoft.gene.bl.SqlManager;
import it.eldasoft.gene.commons.web.domain.CostantiGenerali;
import it.eldasoft.gene.commons.web.domain.ProfiloUtente;
import it.eldasoft.gene.commons.web.struts.ActionBaseNoOpzioni;
import it.eldasoft.gene.commons.web.struts.CostantiGeneraliStruts;
import it.eldasoft.gene.db.datautils.DataColumnContainer;
import it.eldasoft.gene.db.sql.sqlparser.JdbcParametro;
import it.eldasoft.gene.web.struts.tags.gestori.GestoreException;
import it.eldasoft.utils.spring.UtilitySpring;
import it.eldasoft.w9.bl.W9Manager;
import it.eldasoft.w9.common.CostantiW9;
import it.eldasoft.w9.utils.UtilitySITAT;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Action per apertura della pagina di seleziona di una nuova fase.
 */
public class SelezionaNuovaFaseAction extends ActionBaseNoOpzioni {

  /** SqlManager. */
  private SqlManager    sqlManager;
  
  /** W9Manager. */
  private W9Manager     w9Manager;
  
  /** Logger di classe. */
  private static Logger logger = Logger.getLogger(SelezionaNuovaFaseAction.class);

  /** Estrazione del tabellato W3020 a meno di alcuni valori. */
  private static final String SQL_SELECT_FROM_TABELLATO    = "select tab1desc, tab1tip, tab1nord from tab1 where tab1cod = 'W3020' and tab1tip not in (999,992,991,990,989,988,983,13,901,982,981) and tab1nord > 0 order by tab1nord asc";
  /** Estrazione di TAB1TIP del tabellato W3020 a meno di alcuni valori. */
  private static final String SQL_SELECT_FROM_TABELLATO_ID = "select tab1tip from tab1 where tab1cod = 'W3020' and tab1tip not in (999,992,991,990,989,988,983,13,901,982,981) and tab1nord > 0 order by tab1nord asc";
  /** Estrazione dell'importo totale del lotto. */
  private static final String SQL_IMPORTO_LOTTO            = "select importo_tot from w9lott where codgara = ? and codlott = ?";
  /** Estrazione del tipo di contratto del lotto. */
  private static final String SQL_TIPO_CONTRATTO           = "select tipo_contratto from w9lott where codgara = ? and codlott = ?";
  /** Estrazione del contraente del lotto. */
  //private static final String SQL_ID_SCELTA_CONTRAENTE     = "select id_scelta_contraente from w9lott where codgara = ? and codlott = ?";
  /** Estrazione del campo MANOD del lotto. */
  //private static final String SQL_MANOD_LOTTO              = "select manod from w9lott where codgara = ? and codlott = ?";
  /** Estrazione del campo ART_E2 del lotto. */
  private static final String SQL_E2                       = "select art_e2 from w9lott where codgara = ? and codlott = ?";
  /** Estrazione del campo DAEXPORT del lotto. */
  private static final String SQL_DAEXPORT                 = "select daexport from w9lott where codgara = ? and codlott = ?";
  /** Verifica RUP Lotto. */
  //private static final String SQL_UTENTE_RUP = "select RUP from W9LOTT where CODGARA = ? and CODLOTT = ? and RUP in (select CODTEC from TECNI where SYSCON = ? and CGENTEI = ?)";
  /** Verifica DEC Lotto. */
  //private static final String SQL_UTENTE_DEC = "select DEC from W9LOTT where CODGARA = ? and CODLOTT = ? and DEC in (select CODTEC from TECNI where SYSCON = ? and CGENTEI = ?)";
  /** Verifica se per il lotto esiste il DEC. */
  //private static final String SQL_EXIST_DEC = "select DEC from W9LOTT where CODGARA = ? and CODLOTT = ?";
  

  /**
   * Set di sqlManager.
   * 
   * @param sqlManager SqlManager
   */
  public void setSqlManager(SqlManager sqlManager) {
    this.sqlManager = sqlManager;
  }

  /**
   * Set di w9Manager.
   * 
   * @param w9Manager W9Manager
   */
  public void setW9Manager(W9Manager w9Manager) {
    this.w9Manager = w9Manager;
  }  
  
  @Override
  protected ActionForward runAction(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    String target = CostantiGeneraliStruts.FORWARD_OK;
    try {
      String chiave = (String) request.getAttribute("key");
      DataColumnContainer key = new DataColumnContainer(chiave);
      Long codgara = (Long) (key.getColumnsBySuffix("CODGARA", true))[0].getValue().getValue();
      Long codlott = (Long) (key.getColumnsBySuffix("CODLOTT", true))[0].getValue().getValue();

      //boolean s1 = UtilitySITAT.isS1(codgara, codlott, sqlManager);
      boolean s2 = UtilitySITAT.isS2(codgara, codlott, sqlManager);
      boolean s3 = UtilitySITAT.isS3(codgara, codlott, sqlManager);
      boolean r =  UtilitySITAT.isR(codgara, codlott, sqlManager);
      boolean e1 = UtilitySITAT.isE1(codgara, codlott, sqlManager);
      boolean e2 = false;
      boolean saq = UtilitySITAT.isSAQ(codgara, sqlManager);
      boolean aaq = UtilitySITAT.isAAQ(codgara, sqlManager);
      boolean ea = UtilitySITAT.isEA(codgara, codlott, sqlManager);
      boolean aii = UtilitySITAT.isAII(codgara, sqlManager);
      boolean ord = UtilitySITAT.isOrd(codgara, sqlManager);
      boolean daexp = false;

      GeneManager geneManager = (GeneManager) UtilitySpring.getBean("geneManager",
          request.getSession().getServletContext(), GeneManager.class);
      String profilo = (String)request.getSession().getAttribute(CostantiGenerali.PROFILO_ATTIVO);
      
      List< ? > datiTabellatoList = sqlManager.getListVector(
          SQL_SELECT_FROM_TABELLATO, new Object[] {});
      List< ? > idTabellatoList = sqlManager.getListVector(
          SQL_SELECT_FROM_TABELLATO_ID, new Object[] {});
      List<String> enabledTabellatoList = new ArrayList<String>();
      List<String> visibleTabellatoList = new ArrayList<String>();

      Double importoLotto = (Double) sqlManager.getObject(SQL_IMPORTO_LOTTO, new Object[]{codgara, codlott});
      // Inizializzazione a fini di evitare il caso remoto in cui il campo W9LOTT.IMPORT_TOT sia null
      if (importoLotto == null) {
        importoLotto = new Double(0);
      }
      String tipoContratto = (String) sqlManager.getObject(SQL_TIPO_CONTRATTO, new Object[]{codgara, codlott});
      String artE2 = (String) sqlManager.getObject(SQL_E2, new Object[]{codgara, codlott});
      String daexport = (String) sqlManager.getObject(SQL_DAEXPORT, new Object[]{codgara, codlott});

      if (artE2 != null && StringUtils.equals("1", artE2.trim())) {
        e2 = true;
      }
      if (StringUtils.equals("1", daexport)) {
        daexp = true;
      }
      // Per la creazione delle fasi in Alice Vigilanza laddove è abilitato l'invio delle fasi a Simog non serve
      // controllare l'invio dell'anagrafica gara e la presenza della fase esito (A22)
      boolean invioSimogVigilanza = geneManager.getProfili().checkProtec(profilo, "FUNZ", "VIS", "ALT.W9.INVIISIMOG");
      if (invioSimogVigilanza) {
        daexp = false;
      }
      List< ? > datiTabellatoListOrdered = datiTabellatoList;
      List< ? > idTabellatoListOrdered = idTabellatoList;

      List<Object[]> datiTabellatoList1 = new ArrayList<Object[]>();
      for (int yy = 0; yy < datiTabellatoList.size(); yy++) {
        Vector< ? > vec1 = (Vector< ? >) datiTabellatoList.get(yy);
        Object[] obj1 = new Object[]{((JdbcParametro) vec1.get(0)).getValue(),
            ((JdbcParametro) vec1.get(1)).getValue(), ((JdbcParametro) vec1.get(2)).getValue()};
        datiTabellatoList1.add(obj1);
      }

      request.getSession().setAttribute("datiTabellatoList", datiTabellatoList1);
      request.getSession().setAttribute("idTabellatoList", idTabellatoListOrdered);
      
      // Verifico se l'utente attualmente collegato e' il RUP per il lotto in questione
      HttpSession sessione = request.getSession();
      String ufficioIntestatario = (String) sessione.getAttribute(CostantiGenerali.UFFICIO_INTESTATARIO_ATTIVO);
      ProfiloUtente profiloUtente = (ProfiloUtente) sessione.getAttribute(CostantiGenerali.PROFILO_UTENTE_SESSIONE);

      if (e2) {
        for (int o = 0; o < idTabellatoListOrdered.size(); o++) {
          enabledTabellatoList.add("0");
        }
      } else {
        // Ciclo per determinare quali fra tutte le possibili fasi sono selezionabili
        for (int i = 0; i < datiTabellatoListOrdered.size(); i++) {
          //continua = true;
          List< ? > elemento = (List< ? >) idTabellatoListOrdered.get(i);

          int codiceFaseEvento = Integer.parseInt(elemento.get(0).toString());

          Long permessoUtente = null;
          if ("A".equals(profiloUtente.getAbilitazioneStd()) || "C".equals(profiloUtente.getAbilitazioneStd())) {
            permessoUtente =  new Long(5);
          } else {
            permessoUtente = this.w9Manager.getPermessoUtente(codgara, codlott, new Long(profiloUtente.getId()),
                ufficioIntestatario, codiceFaseEvento);
          }
          if (permessoUtente == null || (permessoUtente != null && permessoUtente < 4)) {
            visibleTabellatoList.add("0");
            enabledTabellatoList.add("0");
          } else {
            switch (codiceFaseEvento) {
            case CostantiW9.COMUNICAZIONE_ESITO: // A22
              if (!aaq) {
                visibleTabellatoList.add("1");
                if (!daexp && !this.esistenzaFase(codgara, codlott, CostantiW9.A22)) {
                  enabledTabellatoList.add("1");
                  // Si controlla solo che la fase 'Comunicazione Esito' non esista gia', visto che:
                  // - per il l'anagrafica e bando non esistera' mai un record in W9FASI e quindi
                  //   non si puo' eseguire il esistenzaFase(codgara, codlott, CostantiW9.A03);
                  // - l'anagrafica e bando esiste sempre prima della fase 'Comunicazione esito';
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;

            case CostantiW9.ELENCO_IMPRESE_INVITATE_PARTECIPANTI:   //A24
              visibleTabellatoList.add("1");
              if (!daexp && !this.esistenzaFase(codgara, codlott, CostantiW9.ELENCO_IMPRESE_INVITATE_PARTECIPANTI)) {
                enabledTabellatoList.add("1");
              } else {
                enabledTabellatoList.add("0");
              }
              break;

            case CostantiW9.FASE_SEMPLIFICATA_AGGIUDICAZIONE:  // A04
              if ((e1 || !s2) && !aaq && ea) {
                visibleTabellatoList.add("1");
                if (!daexp && !this.esistenzaFase(codgara, codlott, CostantiW9.FASE_SEMPLIFICATA_AGGIUDICAZIONE) && !esistenzaW9APPA(codgara, codlott)) {
                  enabledTabellatoList.add("1");
                  // Si controlla solo che la fase 'Aggiudicazione semplificata' non esista gia', visto che:
                  // - per il l'anagrafica e bando non esistera' mai un record in W9FASI e quindi
                  //   non si puo' eseguire il esistenzaFase(codgara, codlott, CostantiW9.A03);
                  // - la comunicazione dell'esito puo' venire dopo l'aggiudicazione semplificata, ma
                  //   da quest'ultima vengono presi alcuni valori per inizializzare dei campi della
                  //   fase Comunicazione esito quando viene creata;
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;
            
            case CostantiW9.AGGIUDICAZIONE_SOPRA_SOGLIA:  // A05
              if (s2 && !e1 && !aaq && ea) {
                visibleTabellatoList.add("1");
                if (!daexp && !this.esistenzaFase(codgara, codlott, CostantiW9.AGGIUDICAZIONE_SOPRA_SOGLIA) && !esistenzaW9APPA(codgara, codlott)) {
                  // Si controlla solo che la fase 'Aggiudicazione sopra soglia' non esista gia', visto che:
                  // - per il l'anagrafica e bando non esistera' mai un record in W9FASI e quindi
                  //   non si puo' eseguire il esistenzaFase(codgara, codlott, CostantiW9.A03);
                  // - la comunicazione dell'esito puo' venire dopo l'aggiudicazione sopra soglia, ma
                  //   da quest'ultima vengono presi alcuni valori per inizializzare dei campi della
                  //   fase Comunicazione esito quando viene creata;
                  enabledTabellatoList.add("1");
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;

            case CostantiW9.INIZIO_CONTRATTO_SOPRA_SOGLIA:  // A06
              if (s2 && !e1 && !saq && ea && ord) {
                visibleTabellatoList.add("1");
                if (!daexp && !this.esistenzaFase(codgara, codlott, CostantiW9.INIZIO_CONTRATTO_SOPRA_SOGLIA) && !esistenzaW9INIZ(codgara, codlott)
                    && (((this.esistenzaFase(codgara, codlott, CostantiW9.A22) || invioSimogVigilanza)
                    && this.esistenzaFase(codgara, codlott, CostantiW9.A05))
                        || this.esistenzaFase(codgara, codlott, CostantiW9.A21))) {
                  enabledTabellatoList.add("1");
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;

            case CostantiW9.FASE_SEMPLIFICATA_INIZIO_CONTRATTO:  // A07
              if ((e1 || !s2 || !ord) && !saq && ea) {
                visibleTabellatoList.add("1");
                if (!daexp && !this.esistenzaFase(codgara, codlott, CostantiW9.FASE_SEMPLIFICATA_INIZIO_CONTRATTO) && !esistenzaW9INIZ(codgara, codlott)
                    && (((this.esistenzaFase(codgara, codlott, CostantiW9.A22) || invioSimogVigilanza)
                    && (this.esistenzaFase(codgara, codlott, CostantiW9.A04) || this.esistenzaFase(codgara, codlott, CostantiW9.A05)))
                        || this.esistenzaFase(codgara, codlott, CostantiW9.A21))) {
                  enabledTabellatoList.add("1");
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;
  
            case CostantiW9.AVANZAMENTO_CONTRATTO_SOPRA_SOGLIA:  // A08
              if ((s3 || aii) && !e1 && !saq && ea && ord) {
                visibleTabellatoList.add("1");
                if (!daexp && ((this.esistenzaFase(codgara, codlott, CostantiW9.A06)
                    || this.esistenzaFase(codgara, codlott, CostantiW9.A07)
                    || this.esistenzaFase(codgara, codlott, CostantiW9.A20)) 
                    && !this.esistenzaFase(codgara, codlott, CostantiW9.A11))) {
                  enabledTabellatoList.add("1");
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;
  
            case CostantiW9.CONCLUSIONE_CONTRATTO_SOPRA_SOGLIA:   // A09
              if (s2 && !e1 && ea && !saq && ord) {
                visibleTabellatoList.add("1");
                if (!daexp && !this.esistenzaFase(codgara, codlott, CostantiW9.CONCLUSIONE_CONTRATTO_SOPRA_SOGLIA) && !esistenzaW9CONC(codgara, codlott)
                    && (this.esistenzaFase(codgara, codlott, CostantiW9.A06)
                        || this.esistenzaFase(codgara, codlott, CostantiW9.A20))) {
                  enabledTabellatoList.add("1");
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;
  
            case CostantiW9.FASE_SEMPLIFICATA_CONCLUSIONE_CONTRATTO:  // A10
              if ((e1 || !s2 || !ord) && ea && !saq) {
                visibleTabellatoList.add("1");
                if (!daexp && !this.esistenzaFase(codgara, codlott, CostantiW9.FASE_SEMPLIFICATA_CONCLUSIONE_CONTRATTO) && !esistenzaW9CONC(codgara, codlott)
                    && (this.esistenzaFase(codgara, codlott, CostantiW9.A07)
                        || this.esistenzaFase(codgara, codlott, CostantiW9.A20))) {
                  enabledTabellatoList.add("1");
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;
  
            case CostantiW9.COLLAUDO_CONTRATTO:  // A11
              if (s2 && !e1 && !saq && ea && ord) {
                visibleTabellatoList.add("1");
                if (!daexp && !this.esistenzaFase(codgara, codlott, CostantiW9.COLLAUDO_CONTRATTO)
                    && this.esistenzaFase(codgara, codlott, CostantiW9.A09)) {
                  enabledTabellatoList.add("1");
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;

            case CostantiW9.SOSPENSIONE_CONTRATTO: // A12
              if (((s2 || aii) || r) && !e1 && !saq && ea && ord) {
                visibleTabellatoList.add("1");
                if (!daexp && ((this.esistenzaFase(codgara, codlott, CostantiW9.A06)
                    || this.esistenzaFase(codgara, codlott, CostantiW9.A07)
                    || this.esistenzaFase(codgara, codlott, CostantiW9.A20))
                    && !this.esistenzaFase(codgara, codlott, CostantiW9.A09)
                    && !this.esistenzaFase(codgara, codlott, CostantiW9.A10))) {
                  enabledTabellatoList.add("1");
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;
              
            case CostantiW9.VARIANTE_CONTRATTO:    // A13
              if ((s2 || aii) && !e1 && !saq && ea && ord) {
                visibleTabellatoList.add("1");
                if (!daexp &&  ((this.esistenzaFase(codgara, codlott, CostantiW9.A06)
                    || this.esistenzaFase(codgara, codlott, CostantiW9.A07)
                    || this.esistenzaFase(codgara, codlott, CostantiW9.A20))
                    && !this.esistenzaFase(codgara, codlott, CostantiW9.A11))
                    ) {
                  enabledTabellatoList.add("1");
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;
              
            case CostantiW9.ACCORDO_BONARIO:  // A14
              if (s2 && !e1 && !saq && ea && ord) {
                visibleTabellatoList.add("1");
                if (!daexp && (this.esistenzaFase(codgara, codlott, CostantiW9.A06)
                    || this.esistenzaFase(codgara, codlott, CostantiW9.A07)
                    || this.esistenzaFase(codgara, codlott, CostantiW9.A20))) {
                  enabledTabellatoList.add("1");
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;
  
            case CostantiW9.SUBAPPALTO:  // A15
              if ((s2 || aii) && (!e1) && ea && ord) {
                visibleTabellatoList.add("1");
                if (!daexp && (((this.esistenzaFase(codgara, codlott, CostantiW9.A22) || invioSimogVigilanza)
                    && (this.esistenzaFase(codgara, codlott, CostantiW9.A04)
                        || this.esistenzaFase(codgara, codlott, CostantiW9.A05)))
                        || this.esistenzaFase(codgara, codlott, CostantiW9.A21)
                    && !this.esistenzaFase(codgara, codlott, CostantiW9.A11))
                  ) {
                  enabledTabellatoList.add("1");
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;
  
            case CostantiW9.ISTANZA_RECESSO:  // A16
              if (tipoContratto != null && tipoContratto.indexOf("L") < 0) {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              } else {
                if ((s2 || aii) && !e1 && !saq && ea &&ord) {
                  visibleTabellatoList.add("1");
                  if (!daexp && ((((this.esistenzaFase(codgara, codlott, CostantiW9.A22) || invioSimogVigilanza)
                      && this.esistenzaFase(codgara, codlott, CostantiW9.A05))
                          || this.esistenzaFase(codgara, codlott, CostantiW9.A21))
                	  && !this.esistenzaFase(codgara, codlott, CostantiW9.A06)
                	  && !this.esistenzaFase(codgara, codlott, CostantiW9.A07))) {
                    enabledTabellatoList.add("1");
                  } else {
                    enabledTabellatoList.add("0");
                  }
                } else {
                  visibleTabellatoList.add("0");
                  enabledTabellatoList.add("0");
                }
              }
              break;

            case CostantiW9.STIPULA_ACCORDO_QUADRO:  // A20
              if (saq && ea) {
                visibleTabellatoList.add("1");
                if (!daexp && !this.esistenzaFase(codgara, codlott, CostantiW9.STIPULA_ACCORDO_QUADRO) && !esistenzaW9INIZ(codgara, codlott)
                    && (this.esistenzaFase(codgara, codlott, CostantiW9.A22) || invioSimogVigilanza)
                    && (this.esistenzaFase(codgara, codlott, CostantiW9.A05)
                        || this.esistenzaFase(codgara, codlott, CostantiW9.A04))) {
                  enabledTabellatoList.add("1");
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;
  
            case CostantiW9.ADESIONE_ACCORDO_QUADRO:  // A21
              if (aaq && ea) {
                visibleTabellatoList.add("1");
                if (!daexp && !this.esistenzaFase(codgara, codlott, CostantiW9.ADESIONE_ACCORDO_QUADRO) && !esistenzaW9APPA(codgara, codlott)) {
                  enabledTabellatoList.add("1");
                  // Si controlla solo che la fase 'Adesione accordo quadro' non esista gia', visto che:
                  // - per il l'anagrafica e bando non esistera' mai un record in W9FASI e quindi
                  //   non si puo' eseguire il esistenzaFase(codgara, codlott, CostantiW9.A03);
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;
  
            case CostantiW9.ESITO_NEGATIVO_VERIFICA_TECNICO_PROFESSIONALE_IMPRESA_AGGIUDICATARIA:  // B02
              if (!saq && ea) {
                visibleTabellatoList.add("1");
                if (!daexp && ((this.esistenzaFase(codgara, codlott, CostantiW9.A22) || invioSimogVigilanza)
                    && (this.esistenzaFase(codgara, codlott, CostantiW9.A05)
                        || this.esistenzaFase(codgara, codlott, CostantiW9.A04)))
                        || this.esistenzaFase(codgara, codlott, CostantiW9.A21)) {
                  enabledTabellatoList.add("1");
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;
  
            case CostantiW9.ESITO_NEGATIVO_VERIFICA_CONTRIBUTIVA_ASSICURATIVA:   // B03
              if (!saq && ea) {
                visibleTabellatoList.add("1");
                if (!daexp) {
                  enabledTabellatoList.add("1");
                  // Si controlla solo che la fase 'Comunicazione Esito' non esista gia', visto che:
                  // - per il l'anagrafica e bando non esistera' mai un record in W9FASI e quindi
                  //   non si puo' eseguire il esistenzaFase(codgara, codlott, CostantiW9.A03);
                  // - l'anagrafica e bando esiste sempre prima della fase 'Comunicazione esito';
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;
  
            /*case CostantiW9.MISURE_AGGIUNTIVE_SICUREZZA:   // B04
              if (r && !saq && ea) {
                visibleTabellatoList.add("1");
                if (!daexp && ((!this.esistenzaFase(codgara, codlott, CostantiW9.B04)) && (this.esistenzaFase(codgara, codlott, CostantiW9.A05) || this.esistenzaFase(codgara, codlott, CostantiW9.A04) || this.esistenzaFase(codgara, codlott, CostantiW9.A21)))) {
                  enabledTabellatoList.add("1");
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;*/

            case CostantiW9.INADEMPIENZE_SICUREZZA_REGOLARITA_LAVORI:   // B06
              if (r && !saq && ea) {
                visibleTabellatoList.add("1");
                if (!daexp && ((this.esistenzaFase(codgara, codlott, CostantiW9.A22) || invioSimogVigilanza)
                    && (this.esistenzaFase(codgara, codlott, CostantiW9.A05)
                        || this.esistenzaFase(codgara, codlott, CostantiW9.A04)))
                        || this.esistenzaFase(codgara, codlott, CostantiW9.A21)) {
                  enabledTabellatoList.add("1");
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;

            case CostantiW9.SCHEDA_SEGNALAZIONI_INFORTUNI:   // B07
              if (r && !saq && ea) {
                visibleTabellatoList.add("1");
                if (!daexp && (this.esistenzaFase(codgara, codlott, CostantiW9.A06)
                    || this.esistenzaFase(codgara, codlott, CostantiW9.A07))) {
                  enabledTabellatoList.add("1");
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;

            case CostantiW9.APERTURA_CANTIERE:   // B08
              if (r && !saq && ea) {
                visibleTabellatoList.add("1");
                
                // A22 and (A05 or A21)
                
                if (!daexp && ((this.esistenzaFase(codgara, codlott, CostantiW9.A22) || invioSimogVigilanza)
                    && this.esistenzaFase(codgara, codlott, CostantiW9.A05)) 
                        || this.esistenzaFase(codgara, codlott, CostantiW9.A21)) {
                  enabledTabellatoList.add("1");
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;
              
            case CostantiW9.AVANZAMENTO_CONTRATTO_APPALTO_SEMPLIFICATO:   // A25
              if (((!s3 && !aii) || e1 || !ord) && !saq && ea) {
                visibleTabellatoList.add("1");
                
                // A06 or A07 or A20  .. and not A11
                if (!daexp && ((this.esistenzaFase(codgara, codlott, CostantiW9.A06)
                      || this.esistenzaFase(codgara, codlott, CostantiW9.A07) 
                      || this.esistenzaFase(codgara, codlott, CostantiW9.A20))
                      && !this.esistenzaFase(codgara, codlott, CostantiW9.A11))) {
                  enabledTabellatoList.add("1");
                } else {
                  enabledTabellatoList.add("0");
                }
              } else {
                visibleTabellatoList.add("0");
                enabledTabellatoList.add("0");
              }
              break;

            default:
              break;
            }
          }
        }
      }

      request.setAttribute("visibleTabellatoList", visibleTabellatoList);
      request.setAttribute("enabledTabellatoList", enabledTabellatoList);
      
      if (daexp) {
        this.aggiungiMessaggio(request, "errors.creaNuovaFase.invioAnagraficaBando");
      }
      
    } catch (GestoreException ge) {
      logger.error("Errore nell\'elaborazione della lista di Fasi inseribili.", ge);
      aggiungiMessaggio(request, "errors.inserisciFase.recuperoDati");
      target = CostantiGeneraliStruts.FORWARD_ERRORE_GENERALE;
    } catch (SQLException e) {
      logger.error("Errore nell\'elaborazione della lista di Fasi inseribili.", e);
      aggiungiMessaggio(request, "errors.inserisciFase.recuperoDati");
      target = CostantiGeneraliStruts.FORWARD_ERRORE_GENERALE;
    } catch (ArrayIndexOutOfBoundsException e) {
      logger.error(
          "Errore in uno o piu' tra i campi: Importo Totale, Art E1, Art E2, Tipo Contratto, "
          + "Manodopera/Posa in Opera. Impossibile eseguire i controlli previsti per inserire nuova fase.",
          e);
      aggiungiMessaggio(request, "errors.inserisciFase.valoriNulli");
      target = CostantiGeneraliStruts.FORWARD_ERRORE_GENERALE;
    }

    return mapping.findForward(target);
  }
  
  /**
   * Determina l'esistenze di una fase (codiceFase).
   * 
   * @param codgara Codice della gara
   * @param codlott Codice del lotto
   * @param codiceFase Codice della fase
   * @return Ritorna true se la fase <i>codiceFase</i> esiste in DB, false altrimenti
   * @throws SQLException SQLException
   */
  private boolean esistenzaFase(Long codgara, Long codlott, int codiceFase) throws SQLException {
    boolean esiste = false;
    Long valore;
    try {
      valore = (Long) sqlManager.getObject(
          "select count(*) from w9fasi where codgara = ? and codlott = ? and fase_esecuzione = ?",
          new Object[]{codgara, codlott, new Long(codiceFase)});
      if (valore != null && valore.longValue() > 0) {
        esiste = true;
      }
    } catch (SQLException e) {
      logger.error("Errore nella verifica della pre-esistenza della fase", e);
      throw e;
    }
    return esiste;
  }
  
  /**
   * Determina l'esistenze di un record in W9APPA.
   * 
   * @param codgara Codice della gara
   * @param codlott Codice del lotto
   * @return Ritorna true se esiste un record in W9APPA, false altrimenti
   * @throws SQLException SQLException
   */
  private boolean esistenzaW9APPA(Long codgara, Long codlott) throws SQLException {
    boolean esiste = false;
    Long valore;
    try {
      valore = (Long) sqlManager.getObject(
          "select count(*) from w9appa where codgara = ? and codlott = ?",
          new Object[]{codgara, codlott});
      if (valore != null && valore.longValue() > 0) {
        esiste = true;
      }
    } catch (SQLException e) {
      logger.error("Errore nella verifica della pre-esistenza nella W9APPA", e);
      throw e;
    }
    return esiste;
  }
  
  /**
   * Determina l'esistenze di un record in W9INIZ.
   * 
   * @param codgara Codice della gara
   * @param codlott Codice del lotto
   * @return Ritorna true se esiste un record in W9INIZ, false altrimenti
   * @throws SQLException SQLException
   */
  private boolean esistenzaW9INIZ(Long codgara, Long codlott) throws SQLException {
    boolean esiste = false;
    Long valore;
    try {
      valore = (Long) sqlManager.getObject(
          "select count(*) from w9iniz where codgara = ? and codlott = ?",
          new Object[]{codgara, codlott});
      if (valore != null && valore.longValue() > 0) {
        esiste = true;
      }
    } catch (SQLException e) {
      logger.error("Errore nella verifica della pre-esistenza nella W9INIZ", e);
      throw e;
    }
    return esiste;
  }
  
  /**
   * Determina l'esistenze di un record in W9CONC.
   * 
   * @param codgara Codice della gara
   * @param codlott Codice del lotto
   * @return Ritorna true se esiste un record in W9CONC, false altrimenti
   * @throws SQLException SQLException
   */
  private boolean esistenzaW9CONC(Long codgara, Long codlott) throws SQLException {
    boolean esiste = false;
    Long valore;
    try {
      valore = (Long) sqlManager.getObject(
          "select count(*) from w9conc where codgara = ? and codlott = ?",
          new Object[]{codgara, codlott});
      if (valore != null && valore.longValue() > 0) {
        esiste = true;
      }
    } catch (SQLException e) {
      logger.error("Errore nella verifica della pre-esistenza nella W9CONC", e);
      throw e;
    }
    return esiste;
  }
}