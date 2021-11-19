package it.eldasoft.w9.tags.gestori.plugin;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.commons.lang.StringUtils;

import it.eldasoft.gene.bl.SqlManager;
import it.eldasoft.gene.db.datautils.DataColumnContainer;
import it.eldasoft.gene.tags.BodyTagSupportGene;
import it.eldasoft.gene.tags.utils.UtilityTags;
import it.eldasoft.gene.web.struts.tags.gestori.AbstractGestorePreload;
import it.eldasoft.utils.spring.UtilitySpring;

public class GestoreW9SUBA extends AbstractGestorePreload {

	private static final String SQL_ESTRAZIONE_DATI_W9SUBA = "select CODIMP, ID_CPV from W9SUBA where CODGARA = ? AND CODLOTT = ? AND NUM_SUBA = ?";
	private static final String SQL_ESTRAZIONE_IMPR        = "select NOMEST from IMPR where codimp = ? ";
	private static final String SQL_ESTRAZIONE_DATI_TABCPV_CPVDESC = "select CPVDESC from TABCPV where CPVCOD4 = ?";
	private static final String SQL_ESTRAZIONE_DATI_W9AGGI =
	  "SELECT i.CODIMP, i.NOMIMP, g.ID_TIPOAGG " +
	    "FROM W9AGGI g, IMPR i " +
	   "WHERE g.CODGARA=? and g.CODLOTT=? and g.NUM_APPA=1 and g.CODIMP=i.CODIMP and g.ID_TIPOAGG=3";  // id_tipoagg=3 <--> impresa singola
	
	
	public GestoreW9SUBA(BodyTagSupportGene tag) {
		super(tag);
	}

	public void doAfterFetch(PageContext arg0, String arg1) throws JspException {
	}

	public void doBeforeBodyProcessing(PageContext page, String modoAperturaScheda) throws JspException {
		SqlManager sqlManager = (SqlManager) UtilitySpring.getBean("sqlManager",
        page, SqlManager.class);

    String codice = "";
    DataColumnContainer key = null;
    Long codgara = null;
    Long codlott = null;
    Long numsuba = null;
    if (!UtilityTags.SCHEDA_MODO_INSERIMENTO.equals(modoAperturaScheda)) {
      codice = (String) UtilityTags.getParametro(page,
          UtilityTags.DEFAULT_HIDDEN_KEY_TABELLA);
      key = new DataColumnContainer(codice);
      codgara = (Long) (key.getColumnsBySuffix("CODGARA", true))[0].getValue().getValue();
      codlott = (Long) (key.getColumnsBySuffix("CODLOTT", true))[0].getValue().getValue();
      numsuba = (Long) (key.getColumnsBySuffix("NUM_SUBA", true))[0].getValue().getValue();

      try {
        List<?> datiList = sqlManager.getListVector(SQL_ESTRAZIONE_DATI_W9SUBA,
            new Object[]{codgara, codlott, numsuba});
        String codimpr = "";
        String nomeimpr = "";
        String cpvid = "";
        String cpvdescr = "";
        if (datiList.size() > 0) {
          codimpr = ((List<?>) datiList.get(0)).get(0).toString();
          cpvid = ((List<?>) datiList.get(0)).get(1).toString();
          if (codimpr != null && !codimpr.equals("")) {
            List<?> nomeimprList = sqlManager.getListVector(
                SQL_ESTRAZIONE_IMPR, new Object[] { codimpr });
            if (nomeimprList.size() > 0) {
              nomeimpr = ((List<?>) nomeimprList.get(0)).get(0).toString();
            }
          }
          if (cpvid != null && !cpvid.equals("")) {
            List<?> cpvList = sqlManager.getListVector(
                SQL_ESTRAZIONE_DATI_TABCPV_CPVDESC, new Object[] { cpvid });
            if (cpvList.size() > 0) {
              cpvdescr = ((List<?>) cpvList.get(0)).get(0).toString();
            }
          }
        }
        page.setAttribute("nomeimpr", nomeimpr, PageContext.REQUEST_SCOPE);
        page.setAttribute("cpvdescr", cpvdescr, PageContext.REQUEST_SCOPE);
        
        List<?> datiLista = sqlManager.getListVector(SQL_ESTRAZIONE_DATI_W9AGGI,
            new Object[] { codgara, codlott });
      
        if (datiList != null && datiList.size() > 0) {
          page.setAttribute("numImpreseAggiudicatarie", datiLista.size(), PageContext.REQUEST_SCOPE);
        }
        
      } catch (SQLException sqle) {
        throw new JspException(
            "Errore nell'esecuzione della query per l'estrazione dei dati relativi al Subappalto",
            sqle);
      } catch (Exception exc) {
        throw new JspException(
            "Errore nel caricamento dati relativi al Subappalto", exc);
      }
    } else {
      codice = (String) UtilityTags.getParametro(page, UtilityTags.DEFAULT_HIDDEN_KEY_TABELLA);
      key = new DataColumnContainer(codice);
      codgara = (Long) (key.getColumnsBySuffix("CODGARA", true))[0].getValue().getValue();
      codlott = (Long) (key.getColumnsBySuffix("CODLOTT", true))[0].getValue().getValue();
      try {
        List<?> datiList = sqlManager.getListVector(SQL_ESTRAZIONE_DATI_W9AGGI,
            new Object[] { codgara, codlott });
      
        if (datiList != null && datiList.size() > 0) {
          page.setAttribute("numImpreseAggiudicatarie", datiList.size(), PageContext.REQUEST_SCOPE);
        }

      } catch (SQLException sqle) {
        throw new JspException(
            "Errore nell'esecuzione della query per l'estrazione dei dati relativi al Subappalto",
            sqle);
      } catch (Exception exc) {
        throw new JspException(
            "Errore nel caricamento dati relativi al Subappalto", exc);
      }
    }
  }

}