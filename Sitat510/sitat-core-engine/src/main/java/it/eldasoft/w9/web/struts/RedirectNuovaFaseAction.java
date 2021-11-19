package it.eldasoft.w9.web.struts;

import it.eldasoft.gene.commons.web.struts.ActionBaseNoOpzioni;
import it.eldasoft.gene.commons.web.struts.CostantiGeneraliStruts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 
 */
public class RedirectNuovaFaseAction extends ActionBaseNoOpzioni {

  static Logger               logger         = Logger.getLogger(RedirectNuovaFaseAction.class);

  /**
   * @see it.eldasoft.gene.commons.web.struts.ActionBase#runAction(org.apache.struts.action.ActionMapping,
   *      org.apache.struts.action.ActionForm,
   *      javax.servlet.http.HttpServletRequest,
   *      javax.servlet.http.HttpServletResponse)
   */
  protected ActionForward runAction(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    String target = CostantiGeneraliStruts.FORWARD_OK;
    String chiave = (String) request.getParameter("keyatt"); 
    String chosen = (String) request.getParameter("chosen"); 
    
    request.getSession().setAttribute("key", chiave);
    
    target = chosen;
    
    return mapping.findForward(target);
  }

}
