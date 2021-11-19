package it.eldasoft.w9.tags.funzioni;

import it.eldasoft.gene.bl.SqlManager;
import it.eldasoft.gene.db.datautils.DataColumnContainer;
import it.eldasoft.gene.tags.utils.AbstractFunzioneTag;
import it.eldasoft.gene.web.struts.tags.gestori.GestoreException;
import it.eldasoft.utils.spring.UtilitySpring;
import it.eldasoft.w9.common.SituazioneGaraLotto;

import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

/**
 * @author Roberto
 */
public class VerificaPermessiFasiFlussiFunction extends AbstractFunzioneTag {

  public VerificaPermessiFasiFlussiFunction() {
    super(2, new Class[] { PageContext.class, String.class });
  }

  @Override
  public String function(PageContext pageContext, Object[] params)
  throws JspException {
    // preparazione sqlManager
    SqlManager sqlManager = (SqlManager) UtilitySpring.getBean("sqlManager", pageContext, SqlManager.class);
    boolean e2 = false;
    String result = "true";
    
    try {
      String chiave = (String) pageContext.getRequest().getAttribute("key");
      DataColumnContainer key = new DataColumnContainer(chiave);
      Long codgara = (key.getColumnsBySuffix("CODGARA", true))[0].getValue().longValue();
      Long codlott = (key.getColumnsBySuffix("CODLOTT", true))[0].getValue().longValue();

      String artE2 = (String) sqlManager.getObject("select art_e2 from w9lott where codgara=? and codlott=?",
          new Object[]{codgara, codlott});

      if (artE2 != null && "1".equals(artE2)) {
        e2 = true;
      }
      if (e2) {
        result = "false";
      }
      
      // controllo la situazione
      Long situazioneLotto = (Long) sqlManager.getObject("select situazione from w9lott where codgara=? and codlott=? ",
          new Object[]{codgara, codlott});
      if (situazioneLotto != null && SituazioneGaraLotto.SITUAZIONE_COLLAUDATO.getSituazione() == situazioneLotto.intValue()){
    	  pageContext.getRequest().setAttribute("situazioneCollaudo", true); 
      }

    } catch (SQLException e) {
      throw new JspException(
          "Errore nel controllo dei flussi propedeutici necessari all'invio del flusso selezionato.", e);
    } catch (GestoreException g) {
      throw new JspException("Errore nel determinare i valori di COGDARA e CODLOTT", g);
    }
    return result;
  }

}