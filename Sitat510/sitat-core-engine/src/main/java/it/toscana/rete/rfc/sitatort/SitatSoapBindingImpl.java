/**
 * SitatSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.toscana.rete.rfc.sitatort;

import it.eldasoft.utils.spring.SpringAppContext;
import it.eldasoft.w9.bl.GeneraIdGaraCigManager;
import it.eldasoft.w9.bl.ort.OsservatorioManager;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SitatSoapBindingImpl implements it.toscana.rete.rfc.sitatort.WsOsservatorio_PortType{

    public it.toscana.rete.rfc.sitatort.ResponseConsultaGara getGaraXML(
		java.lang.String codiceCIG, java.lang.String idGara,
		java.lang.String cfrup, java.lang.String cfsa, boolean controlliPreliminari)
		throws java.rmi.RemoteException {
        
		    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(
        SpringAppContext.getServletContext());
    GeneraIdGaraCigManager generaIdGaraCigManager =
        (GeneraIdGaraCigManager) ctx.getBean("generaIdGaraCigManager");

    return generaIdGaraCigManager.consultaGaraORT(codiceCIG, idGara, cfrup, cfsa, controlliPreliminari);
    }

    public it.toscana.rete.rfc.sitatort.ResponseElencoFeedback getElencoFeedback(
    java.lang.String cig, java.lang.String idgara, java.lang.String cfrup, java.lang.String cfsa,
    it.toscana.rete.rfc.sitatort.TipoFeedbackType tipoFeedBack,
    it.toscana.rete.rfc.sitatort.FaseEsecuzioneType faseEsecuzione)
	    throws java.rmi.RemoteException {
    
    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(
        SpringAppContext.getServletContext());
    OsservatorioManager osservatorioManager =
        (OsservatorioManager) ctx.getBean("osservatorioManager");

    return osservatorioManager.getElencoFeedback(cig, idgara, cfrup, cfsa, tipoFeedBack, faseEsecuzione);

  }

  public it.toscana.rete.rfc.sitatort.ResponseElencoSchedeType getElencoSchede(
      java.lang.String cig, java.lang.String idgara, java.lang.String cfrup,
      java.lang.String cfsa) throws java.rmi.RemoteException {
    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(
        SpringAppContext.getServletContext());
    OsservatorioManager osservatorioManager =
        (OsservatorioManager) ctx.getBean("osservatorioManager");

    return osservatorioManager.getElencoSchede(cig, idgara, cfrup, cfsa);
  }

  public it.toscana.rete.rfc.sitatort.ResponseSchedaType getScheda(
    java.lang.String cig, java.lang.String idgara, java.lang.String cfrup,
    java.lang.String cfsa, it.toscana.rete.rfc.sitatort.FaseEsecuzioneType faseEsecuzione)
        throws java.rmi.RemoteException {

    ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(
        SpringAppContext.getServletContext());
    OsservatorioManager osservatorioManager =
        (OsservatorioManager) ctx.getBean("osservatorioManager");

    return osservatorioManager.getScheda(cig, idgara, cfrup, cfsa, faseEsecuzione);

  }

}
