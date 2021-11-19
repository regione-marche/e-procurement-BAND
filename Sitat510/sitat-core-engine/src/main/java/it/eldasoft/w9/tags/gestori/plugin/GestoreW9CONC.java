/**
 * 
 */
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
 * Gestore di inizializzazione della scheda W9CONC - Fase di conclusione del contratto (A09) – appalto.
 * 
 * @author Luca.Giacomazzo
 */
public class GestoreW9CONC extends AbstractGestorePreload {

  public GestoreW9CONC(BodyTagSupportGene tag) {
    super(tag);
  }

  public void doAfterFetch(PageContext pageContext, String modoAperturaScheda)
      throws JspException {
  }

  public void doBeforeBodyProcessing(PageContext pageContext, String modoAperturaScheda)
      throws JspException {
    
    if (UtilityTags.SCHEDA_MODO_INSERIMENTO.equals(modoAperturaScheda)) {
      String key = UtilityTags.getParametro(pageContext, UtilityTags.DEFAULT_HIDDEN_KEY_TABELLA);
      
      DataColumnContainer dcc = new DataColumnContainer(key);
      Long codGara = (Long) (dcc.getColumnsBySuffix("CODGARA", true))[0].getValue().getValue();
      Long codLott = (Long) (dcc.getColumnsBySuffix("CODLOTT", true))[0].getValue().getValue();
      
      SqlManager sqlManager = (SqlManager) UtilitySpring.getBean("sqlManager", pageContext, SqlManager.class);
      
      try {
        // Estrazione dei campi DATA_VERB_INIZIO, DATA_TERMINE da W9INIZ per l'inizializzazione 
        // dei campi DATA_VERBALE_CONSEGNA e TERMINE_CONTRATTO_ULT di W9CONC
        Vector< ? > datiW9INIZ = sqlManager.getVector(
            "select DATA_VERBALE_DEF, DATA_TERMINE from W9INIZ where CODGARA=? and CODLOTT=? and NUM_INIZ=1",
            new Object[]{codGara, codLott});
        
        if (datiW9INIZ != null && datiW9INIZ.size() > 0) {
          Object obj = ((JdbcParametro) datiW9INIZ.get(0)).getValue(); 
          if (obj != null) {
            pageContext.setAttribute("dataVerbaleDef", UtilityDate.convertiData((Date) obj,
                UtilityDate.FORMATO_GG_MM_AAAA), PageContext.REQUEST_SCOPE);
          }
          obj = null;
          obj = ((JdbcParametro) datiW9INIZ.get(1)).getValue();
          if (obj != null) {
            pageContext.setAttribute("dataTermine", UtilityDate.convertiData((Date) obj, 
                UtilityDate.FORMATO_GG_MM_AAAA), PageContext.REQUEST_SCOPE);
          }
        }
        
        // Calcolo della somma dei giorni di proroga (Somma(W9AVAN.NUM_GIORNI_PROROGA)) per
        // l'inizializzazione del campo W9CONC.NUM_GIORNI_PROROGA
        Object sommaGiorniProroga = sqlManager.getObject(
            "select sum(" + sqlManager.getDBFunction("isnull", new String[] {"NUM_GIORNI_PROROGA", "0" }) + ") from W9AVAN where CODGARA=? and CODLOTT=? ",
            new Object[]{codGara, codLott});

        if (sommaGiorniProroga != null) {
          pageContext.setAttribute("sommaGiorniProroga", sommaGiorniProroga, PageContext.REQUEST_SCOPE);
        }
      } catch (SQLException e) {
        throw new JspException("Errore nell'inizializzazione della scheda W9CONC " +
        		"- Fase di conclusione del contratto (A09) – appalto", e);
      }
    }
  }

}