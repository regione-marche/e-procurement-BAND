package it.eldasoft.w9.tags.funzioni;

import it.eldasoft.gene.bl.SqlManager;
import it.eldasoft.gene.db.datautils.DataColumnContainer;
import it.eldasoft.gene.tags.utils.AbstractFunzioneTag;
import it.eldasoft.gene.tags.utils.UtilityTags;
import it.eldasoft.utils.spring.UtilitySpring;
import it.eldasoft.w9.common.CostantiW9;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.commons.lang.StringUtils;

/**
 * Classe per la determinazione se un utente puo' oppure no eliminare una gara.
 */
public class IsEliminabileFunction extends AbstractFunzioneTag {

  private static final String CANCELLA_NO                 = "no";
  private static final String CANCELLA_SI                 = "si";


  private static final String SQL_ESISTENZA_LOTTI               = "select codgara from W9LOTT where codgara = ? ";
  private static final String SQL_PROVENIENZA_GARA              = "select PROV_DATO from W9GARA where codgara = ? ";
  
  // select count()
  private static final String SQL_ESISTENZA_FLUSSI_GARA         = "select key01 from W9FLUSSI where area = 2 and key01 = ?";
  private static final String SQL_ESISTENZA_FLUSSI_PROGRAMMA    = "select key01 from W9FLUSSI where area = 4 and key01 = ?";
  private static final String SQL_ESISTENZA_FLUSSI_FASE_LOTTO   = "select key01 from W9FLUSSI where area = 1 and key01 = ? and key02 = ?";
  private static final String SQL_ESISTENZA_FLUSSI_FASESPECIFICA_LOTTO   = "select key01 from W9FLUSSI where area = 1 and key01 = ? and key02 = ? and key03 = ? and key04 = ?";
  private static final String SQL_ESISTENZA_FASI_LOTTO          = "select codlott from W9FASI where codgara = ? and codlott = ?";
  private static final String SQL_ESISTENZA_FLUSSI_GARA_ENTINAZ = "select key01 from W9FLUSSI where area = 5 and key01 = ?";
  
  /** Verifica RUP Lotto. */
  //private static final String SQL_UTENTE_RUP = "select RUP from W9LOTT where CODGARA = ? and CODLOTT = ? and RUP in (select CODTEC from TECNI where SYSCON = ? and CGENTEI = ?)";
  /** Verifica DEC Lotto. */
  //private static final String SQL_UTENTE_DEC = "select DEC from W9LOTT where CODGARA = ? and CODLOTT = ? and DEC in (select CODTEC from TECNI where SYSCON = ? and CGENTEI = ?)";
  /** Verifica se per il lotto esiste il DEC */
  //private static final String SQL_EXIST_DEC = "select DEC from W9LOTT where CODGARA = ? and CODLOTT = ?";
  
  public IsEliminabileFunction() {
    super(3, new Class[] { PageContext.class, String.class, String.class });
  }

  @Override
  public String function(PageContext pageContext, Object[] params)
  throws JspException {
    String cancellabile = CANCELLA_NO;

    try {
      SqlManager sqlManager = (SqlManager) UtilitySpring.getBean("sqlManager",
          pageContext, SqlManager.class);
      String key = params[1].toString();
      String entita = params[2].toString();
      if (key == null || key.equals("")) {
        key = UtilityTags.getParametro(pageContext, UtilityTags.DEFAULT_HIDDEN_KEY_TABELLA);
      }
      
      DataColumnContainer keys = new DataColumnContainer(key);
      if (entita.equals("PIATRI")) {
        Long contri = (keys.getColumnsBySuffix("CONTRI", true))[0].getValue().longValue();
        List< ? > flussiCollegati = sqlManager.getListVector(SQL_ESISTENZA_FLUSSI_PROGRAMMA, new Object[] { contri });

        if (flussiCollegati != null && flussiCollegati.size() == 0) {
          cancellabile = CANCELLA_SI;
        }
      }
      
      if (entita.equals("W9GARA")) {
        // Una fase non e' eliminabile se la fase stessa e' gia' stata inviata (cioe' se esiste in W9FLUSSI il relativo record).
        Long codgara = (keys.getColumnsBySuffix("CODGARA", true))[0].getValue().longValue();
        List< ? > lottiCollegati = sqlManager.getListVector(SQL_ESISTENZA_LOTTI, new Object[] { codgara });
        List< ? > flussiCollegati = sqlManager.getListVector(SQL_ESISTENZA_FLUSSI_GARA, new Object[] { codgara });
        Long provDato = (Long) sqlManager.getObject(SQL_PROVENIENZA_GARA, new Object[]{codgara});

        if ((flussiCollegati != null && flussiCollegati.size() == 0) && ((lottiCollegati != null && lottiCollegati.size() == 0) || new Long(4).equals(provDato))) {
          cancellabile = CANCELLA_SI;
        }
      }
      if (entita.equals("W9LOTT")) {
        // Una fase non e' eliminabile se la fase stessa e' gia' stata inviata (cioe' se esiste in W9FLUSSI il relativo record).
        Long codgara = (keys.getColumnsBySuffix("CODGARA", true))[0].getValue().longValue();
        Long codlott = (keys.getColumnsBySuffix("CODLOTT", true))[0].getValue().longValue();
        List< ? > fasiCollegate = sqlManager.getListVector(SQL_ESISTENZA_FASI_LOTTO, new Object[] { codgara, codlott });

        List< ? > flussiCollegatiFase = sqlManager.getListVector(SQL_ESISTENZA_FLUSSI_FASE_LOTTO, new Object[] { codgara, codlott});

        if ((flussiCollegatiFase != null && flussiCollegatiFase.size() == 0) && (fasiCollegate != null && fasiCollegate.size() == 0)) {
          cancellabile = CANCELLA_SI;
        }
      }
      if (entita.equals("W9FASI")) {
        // Una fase non e' eliminabile se la fase stessa e' gia' stata inviata (cioe' se esiste in W9FLUSSI il relativo record).
        Long codgara = (keys.getColumnsBySuffix("CODGARA", true))[0].getValue().longValue();
        Long codlott = (keys.getColumnsBySuffix("CODLOTT", true))[0].getValue().longValue();
        Long tipofase = (keys.getColumnsBySuffix("FASE_ESECUZIONE", true))[0].getValue().longValue();
        Long progfase = (keys.getColumnsBySuffix("NUM", true))[0].getValue().longValue();
        Long flussiCollegatiFaseSpecifica = (Long) sqlManager.getObject(
            "select count(*) from W9FLUSSI where AREA=1 and KEY01=? and KEY02=? and KEY03 = ? and KEY04 = ? and TINVIO2 > 0",
            new Object[] { codgara, codlott, tipofase, progfase });

        if (flussiCollegatiFaseSpecifica.longValue() == 0) {
        	cancellabile = CANCELLA_SI;
        
        	// Una fase non e' eliminabile se la fase stessa e' necessaria per l'abilitazione di una fase (gia' esistente, anche se non inviata). 
        	// Ad esempio: non puo' essere eliminata la fase di aggiudicazione se e' presente la fase iniziale.
        	String sqlEsistenzaFasiSuccessive = "select count(*) from W9FASI where CODGARA=? and CODLOTT=? and FASE_ESECUZIONE in (TO_REPLACE)";

        	String sqlToReplace = "";
        	Object[] sqlParams = null;
        	switch (tipofase.intValue()) {
        	case CostantiW9.COMUNICAZIONE_ESITO:
          
        		sqlToReplace = "?, ?, ?, ?, ?, ?, ?";
        		sqlParams = new Object[]{ codgara, codlott,
        				CostantiW9.STIPULA_ACCORDO_QUADRO, 
        				CostantiW9.INIZIO_CONTRATTO_SOPRA_SOGLIA, 
        				CostantiW9.FASE_SEMPLIFICATA_INIZIO_CONTRATTO,
        				CostantiW9.SUBAPPALTO,
        				CostantiW9.ISTANZA_RECESSO,
        				CostantiW9.ESITO_NEGATIVO_VERIFICA_TECNICO_PROFESSIONALE_IMPRESA_AGGIUDICATARIA,
        				CostantiW9.INADEMPIENZE_SICUREZZA_REGOLARITA_LAVORI};
        		break;

        	case CostantiW9.AGGIUDICAZIONE_SOPRA_SOGLIA:
          
        		sqlToReplace = "?, ?, ?, ?, ?, ?";
        		sqlParams = new Object[]{ codgara, codlott, 
        				CostantiW9.STIPULA_ACCORDO_QUADRO, 
        				CostantiW9.INIZIO_CONTRATTO_SOPRA_SOGLIA,
        				CostantiW9.SUBAPPALTO,
        				CostantiW9.ISTANZA_RECESSO,
        				CostantiW9.ESITO_NEGATIVO_VERIFICA_TECNICO_PROFESSIONALE_IMPRESA_AGGIUDICATARIA, 
        				CostantiW9.INADEMPIENZE_SICUREZZA_REGOLARITA_LAVORI};
        		break;

        	case CostantiW9.FASE_SEMPLIFICATA_AGGIUDICAZIONE:

        		sqlToReplace = "?, ?, ?, ?, ?";
        		sqlParams = new Object[]{ codgara, codlott, 
        				CostantiW9.STIPULA_ACCORDO_QUADRO,
        				CostantiW9.FASE_SEMPLIFICATA_INIZIO_CONTRATTO,
        				CostantiW9.SUBAPPALTO,
        				CostantiW9.ESITO_NEGATIVO_VERIFICA_TECNICO_PROFESSIONALE_IMPRESA_AGGIUDICATARIA,
        				CostantiW9.INADEMPIENZE_SICUREZZA_REGOLARITA_LAVORI};
        		break;

        	case CostantiW9.STIPULA_ACCORDO_QUADRO:
          
        		sqlToReplace = "?, ?";
        		sqlParams = new Object[]{ codgara, codlott,
              	CostantiW9.CONCLUSIONE_CONTRATTO_SOPRA_SOGLIA, 
              	CostantiW9.FASE_SEMPLIFICATA_CONCLUSIONE_CONTRATTO};
        		break;

        	case CostantiW9.ADESIONE_ACCORDO_QUADRO:
          
        		sqlToReplace = "?, ?, ?, ?, ?, ?";
        		sqlParams = new Object[]{ codgara, codlott,
        				CostantiW9.INIZIO_CONTRATTO_SOPRA_SOGLIA, 
        				CostantiW9.FASE_SEMPLIFICATA_INIZIO_CONTRATTO,
        				CostantiW9.SUBAPPALTO,
        				CostantiW9.ISTANZA_RECESSO,
        				CostantiW9.ESITO_NEGATIVO_VERIFICA_TECNICO_PROFESSIONALE_IMPRESA_AGGIUDICATARIA, 
        				CostantiW9.INADEMPIENZE_SICUREZZA_REGOLARITA_LAVORI};
        		break;
          
        	case CostantiW9.INIZIO_CONTRATTO_SOPRA_SOGLIA:
          
        		sqlToReplace = "?, ?, ?, ?, ?, ?";
        		sqlParams = new Object[]{ codgara, codlott,
        				CostantiW9.CONCLUSIONE_CONTRATTO_SOPRA_SOGLIA,
        				CostantiW9.SOSPENSIONE_CONTRATTO,
        				CostantiW9.ACCORDO_BONARIO,
        				CostantiW9.VARIANTE_CONTRATTO,
        				CostantiW9.SCHEDA_SEGNALAZIONI_INFORTUNI,
        				CostantiW9.APERTURA_CANTIERE};
        		break;

        	case CostantiW9.FASE_SEMPLIFICATA_INIZIO_CONTRATTO:
          
        		sqlToReplace = "?, ?, ?";
        		sqlParams = new Object[]{ codgara, codlott,
        				CostantiW9.FASE_SEMPLIFICATA_CONCLUSIONE_CONTRATTO, 
        				CostantiW9.SCHEDA_SEGNALAZIONI_INFORTUNI,
        				CostantiW9.APERTURA_CANTIERE};
        		break;
        	case CostantiW9.ANAGRAFICA_GARA_LOTTI:
        	case CostantiW9.CONCLUSIONE_CONTRATTO_SOPRA_SOGLIA:
        		sqlToReplace = "?";
        		sqlParams = new Object[]{ codgara, codlott, CostantiW9.COLLAUDO_CONTRATTO};
        		break;
        		
        	case CostantiW9.AVANZAMENTO_CONTRATTO_SOPRA_SOGLIA: // controllare
        	case CostantiW9.AVANZAMENTO_CONTRATTO_APPALTO_SEMPLIFICATO:// controllare
        	//W9FASI.CODGARA=N:578636;W9FASI.CODLOTT=N:1;W9FASI.FASE_ESECUZIONE=N:5;W9FASI.NUM=N:1
       		// select count(*) from W9FASI where CODGARA=578636 and CODLOTT=1 and FASE_ESECUZIONE inselect count(*) from W9FASI where CODGARA=578636 and CODLOTT=1 and FASE_ESECUZIONE in	
        		
        	case CostantiW9.ELENCO_IMPRESE_INVITATE_PARTECIPANTI:
        	case CostantiW9.FASE_SEMPLIFICATA_CONCLUSIONE_CONTRATTO:
        	case CostantiW9.COLLAUDO_CONTRATTO:
        	case CostantiW9.SOSPENSIONE_CONTRATTO:
        	case CostantiW9.VARIANTE_CONTRATTO:
        	case CostantiW9.ACCORDO_BONARIO:
        	case CostantiW9.SUBAPPALTO:
        	case CostantiW9.ISTANZA_RECESSO:
        	case CostantiW9.ESITO_NEGATIVO_VERIFICA_TECNICO_PROFESSIONALE_IMPRESA_AGGIUDICATARIA:
        	case CostantiW9.ESITO_NEGATIVO_VERIFICA_CONTRIBUTIVA_ASSICURATIVA:
        	case CostantiW9.INADEMPIENZE_SICUREZZA_REGOLARITA_LAVORI:
        	case CostantiW9.SCHEDA_SEGNALAZIONI_INFORTUNI:
        	case CostantiW9.APERTURA_CANTIERE:
        	default:
        		break;
        	}
        
        	if (sqlToReplace.length() > 0 && sqlParams != null) {
        		Long numeroFasiSuccessiveDipendenti = (Long) sqlManager.getObject(
        				StringUtils.replace(sqlEsistenzaFasiSuccessive, "TO_REPLACE", sqlToReplace), sqlParams);
        		if (numeroFasiSuccessiveDipendenti.longValue() > 0) {
        			cancellabile = CANCELLA_NO;
        		}
        	}
        }
      }

      if (entita.equals("W9GARA_ENTINAZ")) {
        // Una fase non e' eliminabile la fase stessa e' gia' stata inviata (cioe' se esiste in W9FLUSSI il relativo record).
        Long codgara = (keys.getColumnsBySuffix("CODGARA", true))[0].getValue().longValue();
        List< ? > flussiCollegati = sqlManager.getListVector(SQL_ESISTENZA_FLUSSI_GARA_ENTINAZ, new Object[]{codgara});

        if (flussiCollegati != null && flussiCollegati.size() == 0) {
          cancellabile = CANCELLA_SI;
        }
      }
    } catch (SQLException sqle) {
      throw new JspException(
          "Errore in fase di esecuzione della query per i controlli preventivi all'eliminazione del Programma, della Gara, del Lotto, o della Fase/evento",
          sqle);
    } catch (Exception exc) {
      throw new JspException(
          "Errore in fase di esecuzione della query per i controlli preventivi all'eliminazione del Programma, della Gara, del Lotto, o della Fase/evento",
          exc);
    }
    return cancellabile;
  }

}