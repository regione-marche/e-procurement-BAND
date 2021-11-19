package it.eldasoft.w9.tags.funzioni;

import it.eldasoft.gene.bl.GeneManager;
import it.eldasoft.gene.bl.SqlManager;
import it.eldasoft.gene.commons.web.domain.CostantiGenerali;
import it.eldasoft.gene.db.datautils.DataColumnContainer;
import it.eldasoft.gene.tags.utils.AbstractFunzioneTag;
import it.eldasoft.gene.tags.utils.UtilityTags;
import it.eldasoft.utils.spring.UtilitySpring;
import it.eldasoft.w9.common.CostantiW9;

import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.commons.lang.StringUtils;

/**
 * Classe per la determinazione se un utente puo' oppure no eliminare una fase.
 */
public class IsFaseSimogEliminabileFunction extends AbstractFunzioneTag {

  private static final String CANCELLA_NO                 = "no";
  private static final String CANCELLA_SI                 = "si";

    
  public IsFaseSimogEliminabileFunction() {
    super(2, new Class[] { PageContext.class, String.class});
  }

  @Override
  public String function(PageContext pageContext, Object[] params) throws JspException {
    String cancellabile = CANCELLA_NO;

    try {
    	GeneManager geneManager = (GeneManager) UtilitySpring.getBean("geneManager", pageContext, GeneManager.class);
      String profilo = (String)this.getRequest().getSession().getAttribute(CostantiGenerali.PROFILO_ATTIVO);
        
    	boolean invioSimogVigilanza = geneManager.getProfili().checkProtec(profilo, "FUNZ", "VIS", "ALT.W9.INVIISIMOG");
        
      SqlManager sqlManager = (SqlManager) UtilitySpring.getBean("sqlManager",
          pageContext, SqlManager.class);
      String key = params[1].toString();
      if (key == null || key.equals("")) {
        key = UtilityTags.getParametro(pageContext, UtilityTags.DEFAULT_HIDDEN_KEY_TABELLA);
      }
       
      DataColumnContainer keys = new DataColumnContainer(key);
      
      // Una fase non e' eliminabile se la fase stessa e' gia' stata inviata (cioe' se esiste in W9FLUSSI il relativo record).
      Long codgara = (keys.getColumnsBySuffix("CODGARA", true))[0].getValue().longValue();
      Long codlott = (keys.getColumnsBySuffix("CODLOTT", true))[0].getValue().longValue();
      Long tipofase = (keys.getColumnsBySuffix("FASE_ESECUZIONE", true))[0].getValue().longValue();
      Long progfase = (keys.getColumnsBySuffix("NUM", true))[0].getValue().longValue();
        
     	cancellabile = CANCELLA_SI;
        
    	// Una fase non e' eliminabile se la fase stessa e' necessaria per l'abilitazione di una fase (gia' esistente, anche se non inviata). 
    	// Ad esempio: non puo' essere eliminata la fase di aggiudicazione se e' presente la fase iniziale.
    	//String sqlEsistenzaFasiSuccessive = "select count(*) from W9FASI where CODGARA=? and CODLOTT=? and FASE_ESECUZIONE in (TO_REPLACE)";
    	String sqlEsistenzaFasiSuccessive = "select count(*) from W9FLUSSI where KEY01=? and KEY02=? and KEY03 in (TO_REPLACE)";
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
        	
      // Verifica cancellazione per configurazione Sitat
      if (!invioSimogVigilanza) {
        // Verifico il tipo di invio per l'ultimo invio effettuato per la fase in esame (tipofase e progfase)
        Long tipoInvio = (Long) sqlManager.getObject(
           "select TINVIO2 from W9FLUSSI where KEY01=? and KEY02=? and KEY03=? and KEY04=? and IDFLUSSO=(" +
               "select max(IDFLUSSO) from W9FLUSSI where KEY01=? and KEY02=? and KEY03=? and KEY04=?)",
           new Object[] { codgara, codlott, tipofase, progfase, codgara, codlott, tipofase, progfase });
        if (tipoInvio == null || (tipoInvio != null && tipoInvio.longValue() > 0)) {
          cancellabile = CANCELLA_SI;
        } else {
          cancellabile = CANCELLA_NO;
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