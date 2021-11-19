package it.eldasoft.w9.tags.gestori.plugin;

import it.eldasoft.gene.bl.SqlManager;
import it.eldasoft.gene.db.datautils.DataColumnContainer;
import it.eldasoft.gene.db.sql.sqlparser.JdbcParametro;
import it.eldasoft.gene.tags.BodyTagSupportGene;
import it.eldasoft.gene.tags.utils.UtilityTags;
import it.eldasoft.gene.web.struts.tags.gestori.AbstractGestorePreload;
import it.eldasoft.utils.spring.UtilitySpring;
import it.eldasoft.utils.utility.UtilityDate;
import it.eldasoft.utils.utility.UtilityNumeri;
import it.eldasoft.w9.utils.UtilitySITAT;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.commons.lang.StringUtils;


public class GestoreW9APPA extends AbstractGestorePreload {

  /** Query per lotto flag ente speciale. */
  private static final String SQL_DATI_LOTTO 		= "select FLAG_ENTE_SPECIALE, ID_SCELTA_CONTRAENTE from W9LOTT where CODGARA=? AND CODLOTT=?";
  /** Query per data verbale aggiudicazione e importo aggiudicazione dalla fase Comunicazione esito. */
  private static final String SQL_W9ESITO           = "select DATA_VERB_AGGIUDICAZIONE, IMPORTO_AGGIUDICAZIONE from W9ESITO where CODGARA=? AND CODLOTT=?";
  /** Recupero il valore iva tabellato*/
  private static final String SQL_IVA            	= "select TAB1DESC from TAB1 where TAB1COD = 'W9013' AND TAB1TIP = 1";
  private static final String SQL_AGGIUDICAZIONE_LOTTI_GARE   = "select DATA_VERB_AGGIUDICAZIONE, DATA_STIPULA, DURATA_CON, TIPO_ATTO, DATA_ATTO, NUMERO_ATTO from W9APPA where CODGARA=?";
  
  /**
   * Costruttore.
   * 
   * @param tag Tag
   */
  public GestoreW9APPA(BodyTagSupportGene tag) {
    super(tag);
  }

  public void doAfterFetch(PageContext arg0, String arg1) throws JspException {
  }

  public void doBeforeBodyProcessing(PageContext page, String modoAperturaScheda) throws JspException {
    SqlManager sqlManager = (SqlManager) UtilitySpring.getBean("sqlManager", page, SqlManager.class);
    String codice = "";
    DataColumnContainer key = null;
    Long codgara = null;
    Long codlott = null;

    try {
      codice = (String) UtilityTags.getParametro(page, UtilityTags.DEFAULT_HIDDEN_KEY_TABELLA);
      //codice = codice.substring(0, codice.indexOf("&keyW9APPA"));
      key = new DataColumnContainer(codice);

      codgara = (key.getColumnsBySuffix("CODGARA", true))[0].getValue().longValue();
      codlott = (key.getColumnsBySuffix("CODLOTT", true))[0].getValue().longValue();
      
      boolean isSAQ = UtilitySITAT.isSAQ(codgara, sqlManager);
      page.setAttribute("isSAQ", isSAQ, PageContext.REQUEST_SCOPE);
      
      Vector<?> datiLotto = sqlManager.getVector(SQL_DATI_LOTTO, new Object[] {codgara, codlott });

      String flagEnteSpeciale = null;
      Long idSceltaContraente = null;
      
      if (datiLotto != null) {
        JdbcParametro jdbcFlagEnteSpeciale = ((JdbcParametro) datiLotto.get(0));
        JdbcParametro jdbcIdSceltaContraente = ((JdbcParametro) datiLotto.get(1));
        
        flagEnteSpeciale = jdbcFlagEnteSpeciale.getStringValue();
        idSceltaContraente = jdbcIdSceltaContraente.longValue();
      }
      
      if ("S".equalsIgnoreCase(flagEnteSpeciale)) {
        page.setAttribute("isFlagEnteSpeciale", true, PageContext.REQUEST_SCOPE);
      } else {
        page.setAttribute("isFlagEnteSpeciale", false, PageContext.REQUEST_SCOPE);
      }
      
      if (idSceltaContraente != null) {
        page.setAttribute("idSceltaContraente", idSceltaContraente, PageContext.REQUEST_SCOPE);
      }
      
      //Ricavo il valore dell'iva
      Vector<?> datiIva = sqlManager.getVector(SQL_IVA, new Object[] { });
      if (datiIva != null) {
    	  double iva = Double.parseDouble(((JdbcParametro) datiIva.get(0)).getStringValue());
    	  page.setAttribute("iva", iva, PageContext.REQUEST_SCOPE);
      }
      
      if ("NUOVO".equals(modoAperturaScheda)) {
    	
        Vector< ? > datiEsito =  sqlManager.getVector(SQL_W9ESITO, new Object[] {codgara, codlott });
        List< ? > listaLotti = sqlManager.getListVector(SQL_AGGIUDICAZIONE_LOTTI_GARE, new Object[] { codgara });

        if (datiEsito != null && datiEsito.size() == 2) {
          JdbcParametro dataVerbAggiu = (JdbcParametro) datiEsito.get(0);
          JdbcParametro importoAggiudicazione = (JdbcParametro) datiEsito.get(1);
          
          if (dataVerbAggiu.getValue() != null) {
            page.setAttribute("initDataVerbAggiu", dataVerbAggiu.getStringValue(), PageContext.REQUEST_SCOPE);
          }
          if (importoAggiudicazione.getValue() != null) {
            page.setAttribute("initImportoAggiu", UtilityNumeri.convertiDouble((Double)
                importoAggiudicazione.getValue(), UtilityNumeri.FORMATO_DOUBLE_CON_PUNTO_DECIMALE, 2),
                PageContext.REQUEST_SCOPE);
          }
        } else {
        	//Se la gara ha altri lotti con gia' inserita la scheda aggiudicazione, e tutte le schede aggiudicazione 
        	//della gara hanno lo stesso valore per la data di aggiudicazione, valorizzare il campo con questo valore
        	Date dataAggiudicazione = null, dataAggiudicazioneLotto = null;
        	boolean isEqualDateAggiudicazione = true;
          if (listaLotti != null && listaLotti.size() > 0) {
          	for (int i = 0; i < listaLotti.size(); i++) {
           		//data aggiudicazione
           		dataAggiudicazioneLotto = (Date) SqlManager.getValueFromVectorParam(listaLotti.get(i), 0).getValue();
           		if (dataAggiudicazioneLotto != null) {
           			if (isEqualDateAggiudicazione && (dataAggiudicazione == null || dataAggiudicazioneLotto.equals(dataAggiudicazione))) {
             			dataAggiudicazione = dataAggiudicazioneLotto;
             		} else {
             		  isEqualDateAggiudicazione = false;
             		}
           		}
          	}
            if (isEqualDateAggiudicazione) {
            	String dataStr = UtilityDate.convertiData((Date) dataAggiudicazione, UtilityDate.FORMATO_GG_MM_AAAA);
                   page.setAttribute("initDataVerbAggiu", dataStr, PageContext.REQUEST_SCOPE);
            }
          }
        }
        
        //Se la gara ha altri lotti con gia' inserita la scheda aggiudicazione, e tutte le schede aggiudicazione 
        //della gara hanno lo stesso valore per la data di stipula contratto, valorizzare il campo con questo valore
        Date dataStipula = null, dataStipulaLotto = null, dataAtto = null, dataAttoLotto = null;
        Long durataContratto = null, durataContrattoLotto = null, tipoAtto = null, tipoAttoLotto = null;
        String numeroAtto = null, numeroAttoLotto = null;
        
        boolean isEqualDateStipula = true;
        boolean isEqualDurataContratto = true;
        boolean isEqualTipoAtto = true;
        boolean isEqualDataAtto = true;
        boolean isEqualNumeroAtto = true;
        
        if (listaLotti != null && listaLotti.size() > 0) {
        	for (int i = 0; i < listaLotti.size(); i++) {
        		//data stipula
        		dataStipulaLotto = (Date) SqlManager.getValueFromVectorParam(listaLotti.get(i), 1).getValue();
        		if (dataStipulaLotto != null) {
        			if (isEqualDateStipula && (dataStipula == null || dataStipulaLotto.equals(dataStipula))) {
            		dataStipula = dataStipulaLotto;
            	} else {
            		isEqualDateStipula = false;
            	}
        		}
        		//durata contratto
        		durataContrattoLotto = (Long) SqlManager.getValueFromVectorParam(listaLotti.get(i), 2).getValue();
        		if (durataContrattoLotto != null) {
            	if (isEqualDurataContratto && (durataContratto == null || durataContrattoLotto.equals(durataContratto))) {
            		durataContratto = durataContrattoLotto;
            	} else {
            		isEqualDurataContratto = false;
            	}
        		}
        		// Tipo atto
        		tipoAttoLotto = (Long) SqlManager.getValueFromVectorParam(listaLotti.get(i), 3).getValue();
        		if (tipoAttoLotto != null) {
        		  if (isEqualTipoAtto && (tipoAtto == null || tipoAttoLotto.equals(tipoAtto))) {
        		    tipoAtto = tipoAttoLotto;
        		  } else {
        		    isEqualTipoAtto = false;
        		  }
        		}
        		// Data atto
        		dataAttoLotto = (Date) SqlManager.getValueFromVectorParam(listaLotti.get(i), 4).getValue();
        		if (dataAttoLotto != null) {
        		  if (isEqualDataAtto && (dataAtto == null || dataAttoLotto.equals(dataAtto))) {
        		    dataAtto = dataAttoLotto;
        		  } else {
        		    isEqualDataAtto = false;
        		  }
        		}
        		// Numero atto
        		numeroAttoLotto = (String) SqlManager.getValueFromVectorParam(listaLotti.get(i), 5).getValue();
        		if (numeroAttoLotto != null) {
        		  if (isEqualNumeroAtto && (numeroAtto == null || numeroAttoLotto.equals(numeroAtto))) {
                numeroAtto = numeroAttoLotto;
              } else {
                isEqualNumeroAtto = false;
              }
        		}
        	}
        	
        	if (isEqualDateStipula) {
        		String dataStr = UtilityDate.convertiData((Date) dataStipula, UtilityDate.FORMATO_GG_MM_AAAA);
            page.setAttribute("initDataStipula", dataStr, PageContext.REQUEST_SCOPE);
        	}
        	if (isEqualDurataContratto) {
            page.setAttribute("initDurataContratto", durataContratto, PageContext.REQUEST_SCOPE);
        	}
        	
        	if(isEqualTipoAtto && tipoAtto != null) {
        	  page.setAttribute("initTipoAtto", tipoAtto, PageContext.REQUEST_SCOPE);
        	}
        	if (isEqualDataAtto && dataAtto != null) {
        	  String dataStr = UtilityDate.convertiData((Date) dataAtto, UtilityDate.FORMATO_GG_MM_AAAA);
        	  page.setAttribute("initDataAtto", dataStr, PageContext.REQUEST_SCOPE);
        	}
        	if (isEqualNumeroAtto && StringUtils.isNotEmpty(numeroAtto)) {
        	  page.setAttribute("initNumeroAtto", numeroAtto, PageContext.REQUEST_SCOPE);
          }
        }
      }
    } catch (Exception exc) {
      throw new JspException("Errore nel caricamento dati dell/'Appalto", exc);
    }
  }

}
