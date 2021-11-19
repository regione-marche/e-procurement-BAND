package it.eldasoft.sil.pt.tags.gestori.plugin;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import it.eldasoft.gene.bl.SqlManager;
import it.eldasoft.gene.db.datautils.DataColumnContainer;
import it.eldasoft.gene.tags.BodyTagSupportGene;
import it.eldasoft.gene.tags.utils.UtilityTags;
import it.eldasoft.gene.web.struts.tags.gestori.AbstractGestorePreload;
import it.eldasoft.utils.spring.UtilitySpring;

public class GestoreINTTRI extends AbstractGestorePreload {

  private final String SQL_ESTRAZIONE_DATI_INTTRI1  = "select INTTRI.CODCPV, TABCPV.CPVDESC from TABCPV, INTTRI where TABCPV.CPVCOD4 = INTTRI.CODCPV AND INTTRI.CONTRI = ? and INTTRI.CONINT = ?";
  private final String SQL_ESTRAZIONE_DATI_INTTRI2 = "select INTTRI.AVCPV, TABCPV.CPVDESC from TABCPV, INTTRI where TABCPV.CPVCOD4 = INTTRI.AVCPV AND INTTRI.CONTRI = ? and INTTRI.CONINT = ?";
  private final String SQL_ESTRAZIONE_DATI_INTTRI3 = "select INTTRI.MRCPV, TABCPV.CPVDESC from TABCPV, INTTRI where TABCPV.CPVCOD4 = INTTRI.MRCPV AND INTTRI.CONTRI = ? and INTTRI.CONINT = ?";
  private final String SQL_ESTRAZIONE_DATI_TECNI  = "select NOMTEC from TECNI,INTTRI where TECNI.CODTEC=INTTRI.CODRUP and INTTRI.CONTRI =? and INTTRI.CONINT =?";
  private final String SQL_ESTRAZIONE_DATI_CATINT = "select INTERV, CATINT from INTTRI where INTTRI.CONTRI =? and INTTRI.CONINT =?";

  public GestoreINTTRI(BodyTagSupportGene tag) {
    super(tag);
  }

  public void doAfterFetch(PageContext arg0, String arg1) throws JspException {

  }

  public void doBeforeBodyProcessing(PageContext page, String modoAperturaScheda)
      throws JspException {
    SqlManager sqlManager = (SqlManager) UtilitySpring.getBean("sqlManager",
        page, SqlManager.class);
    
    String codice = "";
    DataColumnContainer key = null;
    Long contri = null;
    Long conint = null;

    try {
      if (!UtilityTags.SCHEDA_MODO_INSERIMENTO.equals(modoAperturaScheda)) {
    	codice = (String) UtilityTags.getParametro(page, UtilityTags.DEFAULT_HIDDEN_KEY_TABELLA);
        key = new DataColumnContainer(codice);
   	    contri = (key.getColumnsBySuffix("CONTRI", true))[0].getValue().longValue();
   	    conint = (key.getColumnsBySuffix("CONINT", true))[0].getValue().longValue();
    	
        List<?> datiListInttri = sqlManager.getListVector(
            this.SQL_ESTRAZIONE_DATI_INTTRI1, new Object[] { contri, conint });
        String codcpv = "";
        String cpvdescr = "";
        String comune = "";
        String provincia = "";
        String nomeTecnico = "";
        if (datiListInttri.size() > 0) {
          codcpv = ((List<?>) datiListInttri.get(0)).get(0).toString();
          cpvdescr = ((List<?>) datiListInttri.get(0)).get(1).toString();
        }

        datiListInttri = sqlManager.getListVector(
                this.SQL_ESTRAZIONE_DATI_INTTRI2, new Object[] { contri, conint });
        String avcpv = "";
        String avcpvdescr = "";
        if (datiListInttri.size() > 0) {
          avcpv = ((List<?>) datiListInttri.get(0)).get(0).toString();
          avcpvdescr = ((List<?>) datiListInttri.get(0)).get(1).toString();
        }
        
        datiListInttri = sqlManager.getListVector(
                this.SQL_ESTRAZIONE_DATI_INTTRI3, new Object[] { contri, conint });
        String mrcpv = "";
        String mrcpvdescr = "";
        if (datiListInttri.size() > 0) {
          mrcpv = ((List<?>) datiListInttri.get(0)).get(0).toString();
          mrcpvdescr = ((List<?>) datiListInttri.get(0)).get(1).toString();
        }
        
        String SQL_ESTRAZIONE_DATI_COMUNE = "select tb1.tabcod3, tabsche.tabdesc from tabsche, tabsche tb1, inttri where tabsche.tabcod='S2003' and tabsche.tabcod1='09' and tb1.tabcod='S2003' and tb1.tabcod1='07' and inttri.comint=tabsche.tabcod3 and " + sqlManager.getDBFunction("substr",new String[] {"tabsche.tabcod3","4","3"}) + " = " + sqlManager.getDBFunction("substr",new String[] {"tb1.tabcod2","2","3"}) + " and tabsche.tabcod3=inttri.comint and inttri.contri=? and inttri.conint=?";
        List<?> datiListComune = sqlManager.getListVector(
            SQL_ESTRAZIONE_DATI_COMUNE, new Object[] { contri, conint });
        if (datiListComune.size() > 0) {
          comune = ((List<?>) datiListComune.get(0)).get(1).toString();
          provincia = ((List<?>) datiListComune.get(0)).get(0).toString();
        }

        List<?> datiListTecni = sqlManager.getListVector(
            this.SQL_ESTRAZIONE_DATI_TECNI, new Object[] { contri, conint });
        if (datiListTecni.size() > 0) {
          nomeTecnico = ((List<?>) datiListTecni.get(0)).get(0).toString();
        }

        String valoreCatint = "";
        List<?> datiListCatint = sqlManager.getListVector(
            this.SQL_ESTRAZIONE_DATI_CATINT, new Object[] { contri, conint });
        if (datiListCatint.size() > 0) {
          List<?> rigoListCatint = (List<?>) datiListCatint.get(0);
          if (rigoListCatint.get(0) != null
              && !rigoListCatint.get(0).toString().equals("")
              && rigoListCatint.get(1) != null
              && !rigoListCatint.get(1).toString().equals("")) {
            valoreCatint = rigoListCatint.get(0) + "-" + rigoListCatint.get(1);
          }
        }

        page.setAttribute("codcpv", codcpv, PageContext.REQUEST_SCOPE);
        page.setAttribute("cpvdescr", cpvdescr, PageContext.REQUEST_SCOPE);
        
        page.setAttribute("avcpv", avcpv, PageContext.REQUEST_SCOPE);
        page.setAttribute("avcpvdescr", avcpvdescr, PageContext.REQUEST_SCOPE);
        
        page.setAttribute("avcpv", mrcpv, PageContext.REQUEST_SCOPE);
        page.setAttribute("mrcpvdescr", mrcpvdescr, PageContext.REQUEST_SCOPE);
        
        page.setAttribute("comune", comune, PageContext.REQUEST_SCOPE);
        page.setAttribute("provincia", provincia, PageContext.REQUEST_SCOPE);
        page.setAttribute("nomeTecnico", nomeTecnico, PageContext.REQUEST_SCOPE);
        page.setAttribute("valoreCatint", valoreCatint, PageContext.REQUEST_SCOPE);
      } else {
    	codice = (String) UtilityTags.getParametro(page, UtilityTags.DEFAULT_HIDDEN_KEY_TABELLA_PARENT);
    	key = new DataColumnContainer(codice);
   	    contri = (key.getColumnsBySuffix("CONTRI", true))[0].getValue().longValue();
      }
      
      Long tiprog = (Long) sqlManager.getObject("select TIPROG from PIATRI where CONTRI =?", new Object[] { contri });
      
 	  if (tiprog != null) {
 	    page.setAttribute("tiprog", tiprog, PageContext.REQUEST_SCOPE);
 	  }
    } catch (SQLException sqle) {
      throw new JspException(
          "Errore nell'esecuzione della query per l'estrazione dei dati dell'intervento", sqle);
    } catch (Exception exc) {
      throw new JspException("Errore nel caricamento dati dell'Intervento", exc);
    }
    
  }

}
