package it.eldasoft.w9.bl.simog;

import it.avlp.simog.massload.xmlbeans.Collaborazione;

/**
 * Bean per contenere l'esito dell'operazione di login sui servizi SIMOG. 
 * 
 * @author Luca.Giacomazzo
 */
public class TicketSimogBean {

  private boolean success;
  private String ticketSimog;
  //private it.avlp.simog.massload.xmlbeans.Collaborazione[] collaborazioniWS;
  private it.avlp.simog.massload.xmlbeans.Collaborazioni collaborazioniPDD;
  private String msgError;
  
  public TicketSimogBean() {
    this.success = false;
    this.ticketSimog = null;
    //this.collaborazioniWS = null;
    this.collaborazioniPDD = null;
    this.msgError = null;
  }

  /**
   * @return the success
   */
  public boolean isSuccess() {
    return success;
  }

  /**
   * @param success the success to set
   */
  public void setSuccess(boolean success) {
    this.success = success;
  }

  /**
   * @return the ticketSimog
   */
  public String getTicketSimog() {
    return ticketSimog;
  }

  /**
   * @param ticketSimog the ticketSimog to set
   */
  public void setTicketSimog(String ticketSimog) {
    this.ticketSimog = ticketSimog;
  }

  /**
   * @return the msgError
   */
  public String getMsgError() {
    return msgError;
  }

  /**
   * @param msgError the msgError to set
   */
  public void setMsgError(String msgError) {
    this.msgError = msgError;
  }

  /**
   * @return the collaborazioniWS
   */
  /*public Collaborazione[] getCollaborazioniWS() {
    return collaborazioniWS;
  }*/

  /**
   * @param collaborazioniWS the collaborazioniWS to set
   */
  /*public void setCollaborazioniWS(Collaborazione[] collaborazioniWS) {
    this.collaborazioniWS = collaborazioniWS;
  }*/

  /**
   * @return the collaborazioniPDD
   */
  public it.avlp.simog.massload.xmlbeans.Collaborazioni getCollaborazioniPDD() {
    return collaborazioniPDD;
  }

  /**
   * @param collaborazioniPDD the collaborazioniPDD to set
   */
  public void setCollaborazioniPDD(
      it.avlp.simog.massload.xmlbeans.Collaborazioni collaborazioniPDD) {
    this.collaborazioniPDD = collaborazioniPDD;
  }
  
}
