package it.eldasoft.w9.web.struts;

import it.eldasoft.gene.bl.SqlManager;
import it.eldasoft.gene.commons.web.domain.CostantiGenerali;
import it.eldasoft.gene.commons.web.domain.ProfiloUtente;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Stefano.Cestaro
 * 
 */
public class GetListaCIGEsitiAction extends Action {

  /**
   * Manager per la gestione delle interrogazioni di database.
   */
  private SqlManager sqlManager;

  /**
   * @param sqlManager
   *        the sqlManager to set
   */
  public void setSqlManager(SqlManager sqlManager) {
    this.sqlManager = sqlManager;
  }

  public final ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request,
      final HttpServletResponse response) throws Exception {
    response.setHeader("cache-control", "no-cache");
    response.setContentType("text/text;charset=utf-8");
    PrintWriter out = response.getWriter();

    String codUffInt = (String) request.getSession().getAttribute(
            CostantiGenerali.UFFICIO_INTESTATARIO_ATTIVO);
    int syscon = ((ProfiloUtente) request.getSession().getAttribute(
            CostantiGenerali.PROFILO_UTENTE_SESSIONE)).getId();
    String abilitazioneStd = ((ProfiloUtente) request.getSession().getAttribute(
            CostantiGenerali.PROFILO_UTENTE_SESSIONE)).getAbilitazioneStd();
    
    String query = "";
    String cig = request.getParameter("cig");
    String gara = request.getParameter("gara");
    String esito = request.getParameter("esito");
    
    if (cig != null) {
    	cig = cig.trim();
        cig = cig.replaceAll("'", "''");
    	query = "select W9LOTT.oggetto, W9LOTT.NLOTTO, W9LOTT.CIG, W9LOTT.TIPO_CONTRATTO, W9LOTT.CODGARA, W9LOTT.CODLOTT from W9LOTT left join W9GARA on W9LOTT.CODGARA = W9GARA.CODGARA where cig like '" + cig + "%' and W9GARA.CODEIN = '" + codUffInt + "'";
    	if (abilitazioneStd.equals("U")) {
    		query += " and W9GARA.SYSCON = " + syscon;
    	}
        if (esito.equals("true")) {
        	query += " and NOT EXISTS (select w9publotto.codgara, w9publotto.codlott from w9publotto left join w9pubblicazioni on w9publotto.codgara = w9pubblicazioni.codgara and w9publotto.num_pubb = w9pubblicazioni.num_pubb left join w9cf_pubb on w9pubblicazioni.tipdoc=w9cf_pubb.id where (w9cf_pubb.tipo='E' or w9cf_pubb.tipo='A' or w9cf_pubb.tipo='D') and w9publotto.codgara = W9LOTT.CODGARA and w9publotto.codlott=W9LOTT.CODLOTT) ";
        }
        query += " order by W9LOTT.CODGARA";
    }
    

    if (gara != null) {
    	gara = gara.trim();
        gara = gara.replaceAll("'", "''");
        query = "select DISTINCT W9GARA.codgara, W9GARA.oggetto, W9GARA.IMPORTO_GARA from W9LOTT left join W9GARA on W9LOTT.CODGARA = W9GARA.CODGARA where (cig like '" + gara + "%' or UPPER(W9GARA.oggetto) like UPPER('%" + gara + "%')) and W9GARA.CODEIN = '" + codUffInt + "'";
        if (abilitazioneStd.equals("U")) {
    		query += " and W9GARA.SYSCON = " + syscon;
    	}
        if (esito.equals("true")) {
        	query += " and NOT EXISTS (select w9publotto.codgara, w9publotto.codlott from w9pubblicazioni ";
        	query += " join w9gara on w9pubblicazioni.CODGARA=w9gara.CODGARA and W9GARA.CODEIN = '" + codUffInt + "'";
        	query += " join w9publotto on w9pubblicazioni.CODGARA=w9publotto.CODGARA and w9pubblicazioni.NUM_PUBB=w9publotto.NUM_PUBB ";
        	query += " join w9cf_pubb on w9pubblicazioni.tipdoc=w9cf_pubb.id where (tipo='E' or tipo='A' or tipo='D') and w9publotto.codgara = W9LOTT.CODGARA and w9publotto.codlott=W9LOTT.CODLOTT) ";
        }
        query += " order by W9GARA.CODGARA";
    }
    
    List<?> datiLista = null;
    if (cig != null || gara != null) {
    	datiLista = sqlManager.getListVector(query, new Object[]{});
    } 
    if (datiLista != null && datiLista.size() > 0) {
      JSONArray jsonArrayCIG = JSONArray.fromObject(datiLista.toArray());
      out.println(jsonArrayCIG);
    }

    out.flush();
    return null;
  }

}
