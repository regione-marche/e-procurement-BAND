package it.eldasoft.w9.web.struts;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import it.eldasoft.gene.commons.web.struts.ActionBaseNoOpzioni;
import it.eldasoft.gene.commons.web.struts.CostantiGeneraliStruts;
import it.eldasoft.w9.bl.W9Manager;

/**
 * Action mper attribuire i permessi ad un gara.
 * 
 * @author Luca.Giacomazzo
 */
public class AttribuisciModelloAction extends ActionBaseNoOpzioni {

  /** Logger di classe. */
  private static Logger     logger = Logger.getLogger(AttribuisciModelloAction.class);
  
  private W9Manager w9Manager;
  
  public void setW9Manager(W9Manager w9Manager) {
    this.w9Manager = w9Manager;
  }
  
  @Override
  protected ActionForward runAction(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException {
    
    if (logger.isDebugEnabled()) {
      logger.debug("runAction: inizio metodo");
    }
    String target = CostantiGeneraliStruts.FORWARD_OK;
    Long codgara = new Long(request.getParameter("codgara"));

    try {
      w9Manager.updateAttribuzioneModello(codgara, new Long(1));
      
    } catch (SQLException sqle) {
      logger.error("Errore nell'attribuzione dei permessi alla gara con codgara=" + codgara, sqle);
      target = CostantiGeneraliStruts.FORWARD_ERRORE_GENERALE;
    }
    
    if (logger.isDebugEnabled()) {
      logger.debug("runAction: fine metodo");
    }
    
    return mapping.findForward(target);
  }

}
