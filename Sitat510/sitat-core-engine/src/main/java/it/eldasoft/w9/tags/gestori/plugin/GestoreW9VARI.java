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
import it.eldasoft.w9.utils.UtilitySITAT;

public class GestoreW9VARI extends AbstractGestorePreload {

  private static final String SQL_ESTRAZIONE_DATI_TAB1_FORN = "select TAB1TIP, TAB1DESC, TAB1MOD, TAB1NORD from TAB1 where TAB1COD like '%W3018%' order by TAB1TIP";
  private static final String SQL_ESTRAZIONE_DATI_TAB1_LAV  = "select TAB1TIP, TAB1DESC, TAB1MOD, TAB1NORD from TAB1 where TAB1COD like '%W3017%' order by TAB1TIP";
  private static final String SQL_ESTRAZIONE_DATI_W9LOTT    = "select TIPO_CONTRATTO from W9LOTT where CODGARA = ? AND CODLOTT = ?";

  /** Costruttore. */
  public GestoreW9VARI(BodyTagSupportGene tag) {
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
    Long numVari = null;
	
    String tipoContratto = "";
    int versioneSimog = 1;
    if (UtilityTags.getParametro(page, UtilityTags.DEFAULT_HIDDEN_KEY_TABELLA) != null
        && !UtilityTags.getParametro(page, UtilityTags.DEFAULT_HIDDEN_KEY_TABELLA).equals("")) {
      codice = (String) UtilityTags.getParametro(page, UtilityTags.DEFAULT_HIDDEN_KEY_TABELLA);
    } else {
      codice = (String) UtilityTags.getParametro(page, UtilityTags.DEFAULT_HIDDEN_KEY_TABELLA_PARENT);
    }
    
    key = new DataColumnContainer(codice);
    try {
      codgara = (key.getColumnsBySuffix("CODGARA", true))[0].getValue().longValue();
      codlott = (key.getColumnsBySuffix("CODLOTT", true))[0].getValue().longValue();
      if (!UtilityTags.SCHEDA_MODO_INSERIMENTO.equals(modoAperturaScheda)) {
        numVari = (key.getColumnsBySuffix("NUM_VARI", true))[0].getValue().longValue();
      }
      
      tipoContratto = UtilitySITAT.getTipoContrattoLotto(codgara, codlott, sqlManager);
      versioneSimog = UtilitySITAT.getVersioneSimog(sqlManager, codgara);
    } catch (SQLException sqle) {
      throw new JspException("Errore nell'esecuzione della query per l'estrazione dei dati ", sqle);
    } catch (Exception exc) {
      throw new JspException("Errore nel caricamento dati ", exc);
    }
    
    // estrazione dei valori dei tabellati W3017 o W3018
    try {
      List< ? > datiTabellatoList = null;
      if (versioneSimog == 1) {
        if (StringUtils.isNotEmpty(tipoContratto) 
              && ("L".equals(tipoContratto.toUpperCase()) || "CL".equals(tipoContratto.toUpperCase()))) {
          datiTabellatoList = sqlManager.getListVector(
              "select TAB1TIP, TAB1DESC, TAB1MOD, TAB1NORD from TAB1 where TAB1COD='W3017' and TAB1TIP<=13 order by TAB1TIP",
              new Object[] {});
        } else {
          datiTabellatoList = sqlManager.getListVector(
              "select TAB1TIP, TAB1DESC, TAB1MOD, TAB1NORD from TAB1 where TAB1COD='W3018' order by TAB1TIP",
              new Object[] {});
        }
      } else {
        datiTabellatoList = sqlManager.getListVector(
            "select TAB1TIP, TAB1DESC, TAB1MOD, TAB1NORD from TAB1 where TAB1COD='W3017' and TAB1ARC is null order by TAB1TIP",
            new Object[] {});
      }
      page.setAttribute("datiTabellatoList", datiTabellatoList, PageContext.REQUEST_SCOPE);
      page.setAttribute("versioneSimog", new Long(versioneSimog), PageContext.REQUEST_SCOPE);

      if (!UtilityTags.SCHEDA_MODO_INSERIMENTO.equals(modoAperturaScheda)) {
        Long motivoVariante18 = (Long) sqlManager.getObject(
          "select count(*) from W9MOTI where CODGARA=? and CODLOTT=? and NUM_VARI=? and ID_MOTIVO_VAR=18", 
          new Object[]{ codgara, codlott, numVari });
        if (motivoVariante18 != null && motivoVariante18.longValue() > 0) {
          page.setAttribute("motivoVariante18", "1", PageContext.REQUEST_SCOPE);
        }
      }
    } catch (SQLException sqle) {
      throw new JspException(
          "Errore nell'esecuzione della query per l'estrazione dei dati dei tabellati ", sqle);
    } catch (Exception exc) {
      throw new JspException("Errore nel caricamento dati dei tabellati", exc);
    }

  }
}
