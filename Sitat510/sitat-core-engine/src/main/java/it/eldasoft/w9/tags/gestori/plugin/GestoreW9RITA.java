package it.eldasoft.w9.tags.gestori.plugin;

import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import it.eldasoft.gene.bl.SqlManager;
import it.eldasoft.gene.db.datautils.DataColumnContainer;
import it.eldasoft.gene.db.sql.sqlparser.JdbcParametro;
import it.eldasoft.gene.tags.BodyTagSupportGene;
import it.eldasoft.gene.tags.utils.UtilityTags;
import it.eldasoft.gene.web.struts.tags.gestori.AbstractGestorePreload;
import it.eldasoft.utils.spring.UtilitySpring;
import it.eldasoft.utils.utility.UtilityDate;

/**
 * Gestore inizializzazione della scheda W9RITA
 * 
 * @author Luca.Giacomazzo
 */
public class GestoreW9RITA extends AbstractGestorePreload {

  public GestoreW9RITA(BodyTagSupportGene tag) {
    super(tag);
  }

  public void doAfterFetch(PageContext page, String modoAperturaScheda)
      throws JspException {
  }

  public void doBeforeBodyProcessing(PageContext pageContext, String modoAperturaScheda)
      throws JspException {
    SqlManager sqlManager = (SqlManager) UtilitySpring.getBean("sqlManager", pageContext, SqlManager.class);

    String key = (String) UtilityTags.getParametro(pageContext, UtilityTags.DEFAULT_HIDDEN_KEY_TABELLA);
    
    DataColumnContainer dcc = new DataColumnContainer(key);
    
    Long codGara = (Long) (dcc.getColumnsBySuffix("CODGARA", true))[0].getValue().getValue();
    Long codLott = (Long) (dcc.getColumnsBySuffix("CODLOTT", true))[0].getValue().getValue();
    
    try {
      // Estrazione dei campi W9INIZ.DATA_VERBALE_DEF, se valorizzato, altrimenti con W9INIZ.DATA_VERBALE_CONS
      
      Vector<?> datiW9INIZ = sqlManager.getVector(
          "select DATA_VERBALE_DEF, DATA_VERBALE_CONS from W9INIZ where CODGARA=? and CODLOTT=? and NUM_INIZ=1",
          new Object[]{codGara, codLott});
      
      if(datiW9INIZ != null && datiW9INIZ.size() > 0){
        Object obj = ((JdbcParametro)datiW9INIZ.get(0)).getValue(); 
        if(obj != null)
          pageContext.setAttribute("initDataConsegna", UtilityDate.convertiData((Date)obj, UtilityDate.FORMATO_GG_MM_AAAA),
              PageContext.REQUEST_SCOPE);
        else {
          obj = ((JdbcParametro)datiW9INIZ.get(1)).getValue();
          if(obj != null)
            pageContext.setAttribute("initDataConsegna", UtilityDate.convertiData((Date)obj, UtilityDate.FORMATO_GG_MM_AAAA),
                PageContext.REQUEST_SCOPE);
        }
      }

    } catch (SQLException e) {
      throw new JspException("Errore nell'inizializzazione della scheda W9CONC " +
              "- Fase di conclusione del contratto (A09) – appalto", e);
    }
  }

}