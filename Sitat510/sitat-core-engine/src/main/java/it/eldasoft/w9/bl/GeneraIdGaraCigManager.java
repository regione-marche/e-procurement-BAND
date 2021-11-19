/*
 * Created on 24/giu/2010
 *
 * Copyright (c) EldaSoft S.p.A.
 * Tutti i diritti sono riservati.
 *
 * Questo codice sorgente e' materiale confidenziale di proprieta' di EldaSoft S.p.A.
 * In quanto tale non puo' essere distribuito liberamente ne' utilizzato a meno di
 * aver prima formalizzato un accordo specifico con EldaSoft.
 */
package it.eldasoft.w9.bl;

import it.avlp.simog.massload.xmlbeans.ConsultaGara;
import it.avlp.simog.massload.xmlbeans.ConsultaGaraDocument;
import it.avlp.simog.massload.xmlbeans.ConsultaGaraResponseDocument;
import it.avlp.simog.massload.xmlbeans.ConsultaNumeroGara;
import it.avlp.simog.massload.xmlbeans.ConsultaNumeroGaraDocument;
import it.avlp.simog.massload.xmlbeans.ConsultaNumeroGaraResponseDocument;
import it.avlp.simog.massload.xmlbeans.GaraType;
import it.avlp.simog.massload.xmlbeans.LottoType;
import it.avlp.simog.massload.xmlbeans.ResponseConsultaGara;
import it.avlp.simog.massload.xmlbeans.SchedaType;
import it.avlp.simog.massload.xmlbeans.SimogWSPDDServiceStub;
import it.eldasoft.gene.db.datautils.DataColumnContainer;
import it.eldasoft.gene.web.struts.tags.gestori.GestoreException;
import it.eldasoft.utils.properties.ConfigManager;
import it.eldasoft.utils.sicurezza.CriptazioneException;
import it.eldasoft.w9.bl.simog.TicketSimogBean;
import it.eldasoft.w9.bl.simog.TicketSimogManager;
import it.eldasoft.w9.common.CostantiSimog;

import java.rmi.RemoteException;
import java.util.HashMap;

import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * @author Stefano.Cestaro
 */
public class GeneraIdGaraCigManager {

  /**
   * Logger della classe.
   */
  private static Logger logger = Logger.getLogger(GeneraIdGaraCigManager.class);


  /**
   * Manager del ticket sui servizi Simog.
   */
  private TicketSimogManager ticketSimogManager;

  /**
   * Set setTicketSimogManager
   * @param ticketSimogManager
   */
  public void setTicketSimogManager(final TicketSimogManager ticketSimogManager) {
    this.ticketSimogManager = ticketSimogManager;
  }

  /**
   * Generazione di IdAvGara via WS SIMOG.
   * 
   * @param dataColumnContainer DataColumnContainer
   * @return Ritorna la HashMap stringa-valore con il risultato dell'operazione
   * 
   * @throws GestoreException GestoreException.
   */
  public HashMap<String, Object> generaIdGara(final DataColumnContainer dataColumnContainer)
  throws GestoreException {

    if (logger.isDebugEnabled()) {
      logger.debug("generaIdGara: inizio metodo");
    }
    HashMap<String , Object> risultato = new HashMap<String, Object>();

    /*
    try {
      // Gestione della connessione
      String url = ConfigManager.getValore(PROP_SIMOG_WS_URL);
      if (url == null || "".equals(url)) {
        logger.error("L'indirizzo per la connessione al web service SIMOG non e' definito");
      }

      String login = dataColumnContainer.getString("LOGIN");
      if (login == null || "".equals(login)) {
        logger.error("La login per la connessione al web service SIMOG non e' definita");
      }

      String password = dataColumnContainer.getString("PASSWORD");
      if (password == null || "".equals(password)) {
        logger.error("La password per la connessione al web service SIMOG non e' definita");
      }

      if (StringUtils.isNotEmpty(url)
          && StringUtils.isNotEmpty(login)
          && StringUtils.isNotEmpty(password)) {

        // Verifica i parametri di connessione al WS SIMOG in https e via proxy
        //this.verificaParametriConnessioneWS();

        SimogWSServiceLocator wsLocator = new SimogWSServiceLocator();
        wsLocator.setSimogWSEndpointAddress(url);
        
        SimogWS serviceSimogWS = wsLocator.getSimogWS();
        ResponseCheckLogin rispostaLogin = serviceSimogWS.login(login, password);

        if (rispostaLogin.isSuccess()) {
          String ticketSessionId = rispostaLogin.getTicket();

          logger.error("--- DEBUG ACCESSO SIMOG ---");
          logger.error("Utente SIMOG: " + login);
          logger.error("Password SIMOG: " + password);
          logger.error("--- DEBUG ACCESSO SIMOG ---");

          logger.error("--- DEBUG ACCESSO SIMOG ---");
          logger.error("--- SessionID (ticket): " + ticketSessionId);
          logger.error("--- DEBUG ACCESSO SIMOG ---");

          // Per accordi con Regione Toscana e SIMOG le collaborazioni non vengono popolate.
          // Al momento l'istruzione rispostaLogin.getColl() non deve essere usata.
          // Per il valore da assegnare all'index, si seguono le indicazioni
          // degli accordi menzionati: l'index viene sempre settato a ''
          //String index = "";

          Collaborazioni collaborazioni = rispostaLogin.getColl();
          if (collaborazioni != null) {
            if (collaborazioni.getCollaborazioni() != null && collaborazioni.getCollaborazioni().length > 0) {
              Collaborazione[] arrayColl = collaborazioni.getCollaborazioni();

              logger.error("--- DEBUG ACCESSO SIMOG ---");
              logger.error("--- Numero Collaborazioni: " + arrayColl.length + "---");
              for (int ij = 0; ij < arrayColl.length; ij++) {
                Collaborazione collaborazione = arrayColl[ij];
                if (collaborazione != null) {
                  logger.error("Collaborazione n. " + (ij + 1) + ": "
                      + "Azienda_codiceFiscale = '" + collaborazione.getAzienda_codiceFiscale() + "', "
                      + "Azienda_denominazione = " + collaborazione.getAzienda_denominazione() + "', "
                      + "IdOsservatorio = '" + collaborazione.getIdOsservatorio() + "', "
                      + "Ufficio_denominazione = '" + collaborazione.getUfficio_denominazione() + "', "
                      + "Ufficio_id = '" + collaborazione.getUfficio_id() + "', "
                      + "Ufficio_profilo = '" + collaborazione.getUfficio_profilo() + "', "
                      + "Indice di collaborazione = '" + collaborazione.getIndex() + "'.");
                } else {
                  logger.error("Collaborazione n. " + (ij + 1) + ": null.");
                }
              }

              logger.error("--- DEBUG ACCESSO SIMOG ---");
            }
          }

          // Richiesta generazione del codice identificativo della gara al
          // servizio SIMOG attraverso il metodo inserisciGara del WS
          boolean isCollaudo = false;

          // Se l'url del WS SIMOG in uso e' quella di collaudo, allora si valorizzano i campi IDSTAZIONEAPPALTANTE e
          // DENOMSTAZIONEAPPALTANTE dell'oggetto DatiGataType con due stringhe casuali, giusto per superare
          // la validazione del XML richiesto. Questo perche' l'utente Bertocchini e' un utente di sola
          // consultazione dei dati SIMOG, privo di collaborazioni.
          if (url.toLowerCase().indexOf("collaudosimog") >= 0) {
            isCollaudo = true;
          }

          //this.richiestaIdAvgaraSIMOG(serviceSimogWS, ticketSessionId, collaborazioni, dataColumnContainer, risultato, isCollaudo);
          // Chiusura della connessione
          ResponseChiudiSession rispostaChiudiSessione = serviceSimogWS.chiudiSessione(ticketSessionId);
          if (!rispostaChiudiSessione.isSuccess()) {
            if (logger.isInfoEnabled()) {
              logger.info("La chiusura della connessione identificata dal ticket "
                  + ticketSessionId + " ha generato il seguente errore: "
                  + rispostaChiudiSessione.getError());
            }
            risultato.put("ESITO", "KO");
            risultato.put("ERRORE", rispostaChiudiSessione.getError());
            risultato.put("OPERAZIONE", "chiusuraSessioneSimog");

          }
        } else {
          String message = "Errore durante la connessione al web service SIMOG: ";
          message += rispostaLogin.getError();
          if (logger.isInfoEnabled()) {
            logger.info("Il tentativo di connessione ha generato il seguente errore: "
                + rispostaLogin.getError());
          }
          risultato.put("ESITO", "KO");
          risultato.put("ERRORE", rispostaLogin.getError());
          risultato.put("OPERAZIONE", "aperturaSessioneSimog");

        }
      }
    } catch (SQLException s) {
      throw new GestoreException("Si e' verificato un errore nell'estrazione dei dati necessari alla richiesta di "
          + "inserimento nuova gara in SIMOG attraverso il WS",
          "generaidgaracig.simog.ws.sqlw9gara", s);
    } catch (RemoteException e) {
      throw new GestoreException(
          "Si e' verificato un errore durante la connessione al web service SIMOG",
          "generaidgaracig.simog.ws.error", e);

    } catch (ServiceException e) {
      throw new GestoreException(
          "Si e' verificato un errore durante la connessione al web service SIMOG",
          "generaidgaracig.simog.ws.error", e);
    }
    
    */
    if (logger.isDebugEnabled()) {
      logger.debug("generaIdGara: fine metodo");
    }
    return risultato;
  }

  /**
   * Generazione del codice CIG del lotto via WS SIMOG.
   * 
   * @param dataColumnContainer DataColumnContainer
   * @return Ritorna una HashMap stringa-valore con il risultato dell'operazione
   * @throws GestoreException GestoreException
   */
  public HashMap<String , Object> generaCig(final DataColumnContainer dataColumnContainer)
  throws GestoreException {
    if (logger.isDebugEnabled()) {
      logger.debug("generaCig: inizio metodo");
    }
    HashMap<String , Object> risultato = new HashMap<String, Object>();

    if (logger.isDebugEnabled()) {
      logger.debug("generaIdGaraCig: fine metodo");
    }

    return risultato;
  }

  /**
   * Metodo per invocare il WS consultaGara di SIMOG con ingresso
   * il codice CIG che identifica la gara.
   * 
   * @param codiceCIG Codice CIG del lotto
   * @param idGara Numero della gara
   * @param cfrup CF del RUP
   * @param cfsa CF della S.A.
   * @param eseguiControlliPreliminari 
   * @return Ritorna l'xml contenente le informazioni di dettaglio della gara
   * @throws RemoteException RemoteException
   */
  public it.toscana.rete.rfc.sitatort.ResponseConsultaGara consultaGaraORT(
      final String codiceCIG, final String idGara, final String cfrup,
      final String cfsa, boolean eseguiControlliPreliminari) throws RemoteException {

    it.toscana.rete.rfc.sitatort.ResponseConsultaGara resultXML = 
        new it.toscana.rete.rfc.sitatort.ResponseConsultaGara();

    if (logger.isDebugEnabled()) {
      logger.debug("consultaGaraORT: inizio metodo");
    }

    // Valore di default per il tipo di accesso ai servizi Simog
    int tipoAccessoWSSimog = 0;

    String a = ConfigManager.getValore(CostantiSimog.PROP_TIPO_ACCESSO);
    
    if (StringUtils.isNotEmpty(a)) {
      tipoAccessoWSSimog = Integer.parseInt(a);
    }
    
    switch (tipoAccessoWSSimog) {
      
    case CostantiSimog.ORT_CONSULTA_GARA_VIA_WS:
      this.consultaGaraViaPDD(codiceCIG, idGara, cfrup, cfsa, resultXML, eseguiControlliPreliminari);
      break;

    case CostantiSimog.ORT_CONSULTA_GARA_VIA_PDD:
      this.consultaGaraViaPDD(codiceCIG, idGara, cfrup, cfsa, resultXML, eseguiControlliPreliminari);
      break;
    
    default:
      String msgError = "Errore nella configurazione dell'applicazione: non e' stato " +
          "indicato il tipo di accesso ai servizi SIMOG per la funzione 'Consulta gara'";
      logger.error(msgError);
      
      resultXML.setSuccess(Boolean.FALSE);
      resultXML.setError(msgError + ". Contattare un amministratore");
      break;
    }

    if (logger.isDebugEnabled()) {
      logger.debug("consultaGaraORT: fine metodo");
    }

    return resultXML;
  }

  private void consultaGaraViaPDD(final String codiceCIG, final String idGara,
      final String cfrup, final String cfsa, 
      it.toscana.rete.rfc.sitatort.ResponseConsultaGara resultXML, boolean eseguiControlliPreliminari) {
    
    if (logger.isDebugEnabled()) {
      logger.debug("consultaGaraViaPDD: inizio metodo");
    }
    
    // Inizializzazione dell'esito della risposta
    resultXML.setSuccess(false);

    // Gestione della connessione
    String urlPDD = ConfigManager.getValore(CostantiSimog.PROP_SIMOG_WS_URL);
    
    boolean continua = true;
   
    // Creazione della options contenente i parametri necessari alla basic authentication
    HttpTransportProperties.Authenticator basicAuth = null;
    try {
      basicAuth = this.ticketSimogManager.getBasicAuthentication();
    } catch (CriptazioneException ce) {
      logger.error("Errore nella decriptazione di username o password per la Basic Authentication "
          + "alla PDD. Contattare un amministratore.", ce);
      resultXML.setSuccess(Boolean.FALSE);
      resultXML.setError("Errore inaspettato nella configurazione precedente "
          + "alla Porta di dominio per accedere ai servizi SIMOG (Decript PDD). "
          + "Contattare un amministratore.");
      resultXML.setGaraXML(null);

      basicAuth = null;
      continua = false;
    }
    	
    if (continua) {
      if (StringUtils.isNotEmpty(urlPDD)) {
        
        SimogWSPDDServiceStub simogWsPddServiceStub = null;
        ResponseConsultaGara responseConsultaGara = null;
        
        // Richiesta del ticket all'oggetto per la gestione centralizzata della login ai servizi SIMOG
        TicketSimogBean ticketSimogBean = this.ticketSimogManager.getTicket();
        if (ticketSimogBean != null) {
          if (ticketSimogBean.isSuccess()) {
            String ticket = ticketSimogBean.getTicketSimog();
            //Collaborazioni collaborazioniPdd = ticketSimogBean.getCollaborazioniPDD();
            
            try {
              String schede = "3.04.2.0";
              
              if (StringUtils.isEmpty(codiceCIG)) {
                ConsultaNumeroGaraDocument consultaNumeroGaraDoc = ConsultaNumeroGaraDocument.Factory.newInstance();
                ConsultaNumeroGara consultaNumeroGara = ConsultaNumeroGara.Factory.newInstance();
                consultaNumeroGara.setIdGara(idGara);
                consultaNumeroGara.setSchede(schede);
                consultaNumeroGara.setTicket(ticket);
                
                consultaNumeroGaraDoc.setConsultaNumeroGara(consultaNumeroGara);
                
                if (basicAuth == null) {
                  simogWsPddServiceStub = new SimogWSPDDServiceStub(urlPDD);
                } else {
                  simogWsPddServiceStub = new SimogWSPDDServiceStub(urlPDD + "/consultaNumeroGara");
                  simogWsPddServiceStub._getServiceClient().getOptions().setProperty(
                      HTTPConstants.AUTHENTICATE, basicAuth);
                }
                
                String strTimeOut = ConfigManager.getValore(CostantiSimog.PROP_SITAT_CLIENT_TIMEOUT);
                if (StringUtils.isNotEmpty(strTimeOut)) {
                  Integer timeOutClient = new Integer(strTimeOut);
                  simogWsPddServiceStub._getServiceClient().getOptions().setProperty(
                      HTTPConstants.SO_TIMEOUT, timeOutClient);
                  simogWsPddServiceStub._getServiceClient().getOptions().setProperty(
                      HTTPConstants.CONNECTION_TIMEOUT, timeOutClient);
                }
                logger.info("Invocazione metodo consultaNumeroGara verso i Servizi SIMOG (Ticket="
                    + ticket + ", IdGara=" + idGara + ")");
                ConsultaNumeroGaraResponseDocument consultaNumeroGaraResponseDoc =
                    simogWsPddServiceStub.consultaNumeroGara(consultaNumeroGaraDoc);
                logger.info("Invocato metodo consultaNumeroGara verso i Servizi SIMOG (Ticket="
                    + ticket + ", IdGara=" + idGara + ")");
                
                if (consultaNumeroGaraResponseDoc.getConsultaNumeroGaraResponse().isSetReturn()) {
                  if (consultaNumeroGaraResponseDoc.getConsultaNumeroGaraResponse().getReturn().getSuccess()) {
                    if (consultaNumeroGaraResponseDoc.getConsultaNumeroGaraResponse().getReturn().getSchedaGaraCig() != null) {
                      
                      resultXML.setSuccess(Boolean.TRUE);
                      resultXML.setError(null);
                      resultXML.setGaraXML(consultaNumeroGaraResponseDoc.xmlText());
  
  							    } else {
                      // La risposta del metodo consultaNumeroGara non ha valorizzatto l'oggetto SchedaGaraCig.
                      logger.error("Errore nella risposta al metodo consultaNumeroGara di SIMOG, perche' priva "
                          + "dell'oggetto che dovrebbe contenere l'array dei CIG della gara con IDGARA="
                          + idGara);
                    }
                  } else {
                    // Il metodo consultaNumeroGara non e' terminato con successo.
                    String msg = "Il metodo consultaNumeroGara di SIMOG e' fallito alla richiesta dei CIG della "
                      + "gara con IDGARA=" + idGara;
                    if (consultaNumeroGaraResponseDoc.getConsultaNumeroGaraResponse().getReturn().getError() != null) {
                      msg = msg.concat(". Dettaglio dell'errore: "
                          + consultaNumeroGaraResponseDoc.getConsultaNumeroGaraResponse().getReturn().getError());
                    }
                    logger.error(msg);
                  }
                } else {
                  // La risposta del metodo consultaNumeroGara non ha valorizzatto l'oggetto Return.
                  logger.error("Errore nella risposta al metodo consultaNumeroGara di SIMOG, perche' priva "
                      + "dell'oggetto che dovrebbe rappresentare la risposta della chiamata relativa alla "
                      + "gara con IDGARA=" + idGara);
                }
              } else {
                ConsultaGaraDocument consultaGaraDoc = ConsultaGaraDocument.Factory.newInstance();
                ConsultaGara consultaGara = ConsultaGara.Factory.newInstance();
                consultaGara.setTicket(ticket);
                consultaGara.setSchede(schede);
                consultaGara.setCIG(codiceCIG);
                consultaGaraDoc.setConsultaGara(consultaGara);
                
                if (basicAuth == null) {
                  simogWsPddServiceStub = new SimogWSPDDServiceStub(urlPDD);
                } else {
                  simogWsPddServiceStub = new SimogWSPDDServiceStub(urlPDD + "/consultaGara");
                  simogWsPddServiceStub._getServiceClient().getOptions().setProperty(
                      HTTPConstants.AUTHENTICATE, basicAuth);
                }
                
                String strTimeOut = ConfigManager.getValore(CostantiSimog.PROP_SITAT_CLIENT_TIMEOUT);
                if (StringUtils.isNotEmpty(strTimeOut)) {
                  Integer timeOutClient = new Integer(strTimeOut);
                  simogWsPddServiceStub._getServiceClient().getOptions().setProperty(
                      HTTPConstants.SO_TIMEOUT, timeOutClient);
                  simogWsPddServiceStub._getServiceClient().getOptions().setProperty(
                      HTTPConstants.CONNECTION_TIMEOUT, timeOutClient);
                }
                
                logger.info("Invocazione metodo consultaGara verso i Servizi SIMOG (Ticket=" + ticket + ", CIG=" + codiceCIG);
                ConsultaGaraResponseDocument consultaGaraResponseDoc = simogWsPddServiceStub.consultaGara(consultaGaraDoc);
                logger.info("Invocato il metodo consultaGara verso i Servizi SIMOG (Ticket=" + ticket + ", CIG=" + codiceCIG);
    
                responseConsultaGara = consultaGaraResponseDoc.getConsultaGaraResponse().getReturn();
                if (responseConsultaGara != null) {
                  if (responseConsultaGara.getSuccess()) {
                    if (eseguiControlliPreliminari) {
                      if (this.controlliPreliminariDati_ViaPDD(responseConsultaGara, codiceCIG, idGara, cfrup, cfsa, resultXML)) {
                        if (StringUtils.isNotEmpty(responseConsultaGara.getError())) {
                          resultXML.setError(responseConsultaGara.getError());
                        } else {
                          resultXML.setError(null);
                        }
                        resultXML.setSuccess(true);
                        if (responseConsultaGara.getGaraXML() != null) {
                          resultXML.setGaraXML(consultaGaraResponseDoc.xmlText());
                        } else {
                          resultXML.setGaraXML(null);
                        }
                      }
                    } else {
                      if (responseConsultaGara.getError() != null) {
                        resultXML.setError(responseConsultaGara.getError());
                      } else {
                        resultXML.setError(null);
                      }
                      resultXML.setSuccess(true);
                      if (responseConsultaGara.getGaraXML() != null) {
                        resultXML.setGaraXML(consultaGaraResponseDoc.xmlText());
                      } else {
                        resultXML.setGaraXML(null);
                      }
                    }
                  } else {
                    if (StringUtils.isNotEmpty(responseConsultaGara.getError())) {
                      logger.error("La richiesta consultaGara con codice CIG pari a '" + codiceCIG
                          + "' e' terminata con esito negativo, fornendo il seguente messaggio: "
                          + responseConsultaGara.getError());
                      resultXML.setError(responseConsultaGara.getError());
                    } else {
                      logger.error("La richiesta consultaGara con codice CIG pari a '" + codiceCIG
                          + "' e' terminata con esito negativo, ma non e' stato fornito un messaggio di errore");
                      resultXML.setError("Errore non indicato dai servizi SIMOG");
                    }
                    resultXML.setSuccess(false);
                    resultXML.setGaraXML(null);
                  }
                } else {
                  logger.error("La richiesta consultaGara con codice CIG pari a '"
                      + codiceCIG + "' terminata con esito negativo a causa dell'oggetto "
                      + "it.avlp.simog.pdd.massload.xmlbeans.ResponseConsultaGara non valorizzato.");
                  
                  resultXML.setError("Errore non previsto durante l'operazione accesso ai dati dei servizi SIMOG");
                  resultXML.setSuccess(false);
                  resultXML.setGaraXML(null);
                }
              }
            } catch (RemoteException re) {
              logger.error("Errore nell'interazione con la porta di dominio per l'accesso ai "
                  + "servizi SIMOG per la chiamata consultaGara con codiceCIG='" + codiceCIG + "'", re);
            } catch (Throwable t) {
              logger.error("Errore inaspettato. Contattare un amministratore.", t);
            } finally {
              if (!resultXML.isSuccess() && StringUtils.isEmpty(resultXML.getError())) {
                resultXML.setError("Il servizio SIMOG e' momentaneamente non disponibile o non risponde correttamente. " +
                		"Riprovare piu' tardi. Se il problema persiste, segnalarlo all'amministratore di sistema.");
              }
              // Alla fine dell'interazione con i servizi Simog si rilascia il ticket usato
              // (all'oggetto TicketSimogManager si segnala semplicemente che si e' terminato
              // di usare il ticket)
              this.ticketSimogManager.rilasciaTicket();
            }
          } else {
            // il ticketSimogManager non e' riuscito a fornire un ticket... 
            this.ticketSimogManager.resetTicket();
            
            if (StringUtils.isNotEmpty(ticketSimogBean.getMsgError())) {
              resultXML.setError(ticketSimogBean.getMsgError());
            } else {
              resultXML.setError("Errore non indicato nell'operazione di login ai servizi SIMOG");
            }

            resultXML.setSuccess(false);
            resultXML.setGaraXML(null);
          }
        
        } else {
          // il ticketSimogManager non e' riuscito a fornire un ticket,
          // probabilmente perché è rimasta una sessione aperta 
          this.ticketSimogManager.resetTicket();
          
          resultXML.setError("Errore nell'operazione di login ai servizi SIMOG");
          resultXML.setSuccess(false);
          resultXML.setGaraXML(null);
        }
        
      } else {
        // Errore nella configurazione URL
        String message = "Errore durante la connessione ai servizi SIMOG: i parametri di connessione "
            + "non sono specificati correttamente. Contattare un amministratore.";
        logger.error("Il tentativo di connessione ha generato il seguente errore: " + message);
  
        resultXML.setError(message);
        resultXML.setSuccess(false);
        resultXML.setGaraXML(null);
      }
    }
    
    if (logger.isDebugEnabled()) {
      logger.debug("consultaGaraViaPDD: fine metodo");
    }
  }
  
	/*private void consultaGaraViaWS(String codiceCIG, final String idGara, final String cfrup,
      final String cfsa, it.toscana.rete.rfc.sitatort.ResponseConsultaGara resultXML, 
          boolean eseguiControlliPreliminari) throws RemoteException {

    if (logger.isDebugEnabled()) {
      logger.debug("consultaGaraViaWS: inizio metodo");
    }
    
    // Gestione della connessione
    String url = ConfigManager.getValore(CostantiSimog.PROP_SIMOG_WS_URL);

    if (StringUtils.isNotEmpty(url)) {
      TicketSimogBean ticketSimogBean = this.ticketSimogManager.getTicket();
      
      if (ticketSimogBean.isSuccess()) {
        String ticket = ticketSimogBean.getTicketSimog();
        String schede = "3.03.3.0";

        try {
          SimogWSPDDServiceStub simogWsPDDServiceStub = new SimogWSPDDServiceStub(url);
          
          org.apache.axis.client.Stub stubClient = (Stub) simogWsPDDServiceStub._getServiceClient();
          
          if (logger.isDebugEnabled()) {
            logger.debug("Prima. Default timeout: " + HTTPConstants.SO_TIMEOUT + "=" + 
                stubClient._getProperty(HTTPConstants.SO_TIMEOUT) + " ." + 
                HTTPConstants.CONNECTION_TIMEOUT + "=" + stubClient._getProperty(
                    HTTPConstants.CONNECTION_TIMEOUT));
          }
          
          String strTimeOut = ConfigManager.getValore(CostantiSimog.PROP_SITAT_CLIENT_TIMEOUT);
          if (StringUtils.isNotEmpty(strTimeOut)) {
            stubClient.setTimeout(new Integer(strTimeOut).intValue());
          }
          
          if (logger.isDebugEnabled()) {
            logger.debug("Dopo. Default timeout: " + HTTPConstants.SO_TIMEOUT + "=" + 
                stubClient._getProperty(HTTPConstants.SO_TIMEOUT) + " ." + 
                HTTPConstants.CONNECTION_TIMEOUT + "=" + stubClient._getProperty(
                    HTTPConstants.CONNECTION_TIMEOUT) + " . stubClient.getTimeout()=" +
                    stubClient.getTimeout());
          }

          // Lettura dei parametri per la Basic Authentication
          String chiavePropUsername = CostantiSimog.PROP_PDD_BA_SIMOGWS_USERNAME;
          String chiavePropPassword = CostantiSimog.PROP_PDD_BA_SIMOGWS_PASSWORD;

          String a = ConfigManager.getValore(chiavePropUsername);
          String b = ConfigManager.getValore(chiavePropPassword);
          
          String usernameBasicAuthPDD = null;
          String passwordBasicAuthPDD = null;
          
          if (StringUtils.isNotEmpty(a)) {
            usernameBasicAuthPDD = a;
          }
        
          if (StringUtils.isNotEmpty(b)) {
            ICriptazioneByte criptazione = FactoryCriptazioneByte.getInstance(
                ConfigManager.getValore(CostantiGenerali.PROP_TIPOLOGIA_CIFRATURA_DATI),
                b.getBytes(), ICriptazioneByte.FORMATO_DATO_CIFRATO);
            passwordBasicAuthPDD = new String(criptazione.getDatoNonCifrato());
          }
          
          // Sei parametri per la Basic Authentication sono valorizzati, allora la si setta nella richiesta
          if (StringUtils.isNotEmpty(usernameBasicAuthPDD) && StringUtils.isNotEmpty(passwordBasicAuthPDD)) {
            stubClient._setProperty(Call.USERNAME_PROPERTY, usernameBasicAuthPDD);
            stubClient._setProperty(Call.PASSWORD_PROPERTY, passwordBasicAuthPDD);
          }          
          
          ResponseConsultaGara responseConsultaGara = null;
          ResponseConsultaNumeroGara responseConsultaNumeroGara = null;
          if (StringUtils.isEmpty(codiceCIG)) {
            logger.info("Invocazione del metodo consultaGara (Ticket:" + ticket + ", IdGara=" + idGara + ", CFRUP=" + cfrup + ", CFSA=" + cfsa + ")");
            responseConsultaNumeroGara = simogWsPDDServiceStub.consultaNumeroGara(ticket, schede, idGara );
            logger.info("Invocato il metodo consultaGara (Ticket:" + ticket + ", IdGara=" + idGara + ", CFRUP=" + cfrup + ", CFSA=" + cfsa + ")");
            
            if (responseConsultaNumeroGara != null) {
              if (responseConsultaNumeroGara.getSuccess()) {
                if (eseguiControlliPreliminari) {
                  if (this.controlliPreliminariDati_ViaWS(responseConsultaNumeroGara,
                      idGara, cfrup, cfsa, resultXML)) {
                    resultXML.setError(responseConsultaNumeroGara.getError());
                    resultXML.setSuccess(responseConsultaNumeroGara.getSuccess());
                    resultXML.setGaraXML(responseConsultaNumeroGara.getSchedaGaraCig().toString());
                  }
                } else {
                  resultXML.setError(responseConsultaNumeroGara.getError());
                  resultXML.setSuccess(responseConsultaNumeroGara.getSuccess());
                  resultXML.setGaraXML(responseConsultaNumeroGara.getSchedaGaraCig().toString());
                }
              } else {
                logger.error("La richiesta consultaGara con codice CIG pari a '" + codiceCIG + "' e' terminata "
                    + "con esito negativo, fornendo il seguente messaggio: " + responseConsultaGara.getError());
    
                resultXML.setError(responseConsultaGara.getError());
                resultXML.setSuccess(responseConsultaGara.getSuccess());
                resultXML.setGaraXML(null);
              }
            } else {
              logger.error("La richiesta consultaGara con codice CIG pari a '" + codiceCIG + "' e' terminata "
                  + "con esito negativo, in quanto l'oggetto ritornato (responseConsultaGara) e' null");

              resultXML.setError("Errore inaspettato: la richiesta ha ottenuto una risposta non valorizzata");
              resultXML.setSuccess(false);
              resultXML.setGaraXML(null); 
            }
            
          } else {
            logger.info("Invocazione del metodo consultaGara (Ticket:" + ticket + ", CIG=" + codiceCIG + ", CFRUP=" + cfrup + ", CFSA=" + cfsa + ")");
            responseConsultaGara = simogWsPddProxy.consultaGara(ticket, schede, codiceCIG);
            logger.info("Invocato il metodo consultaGara (Ticket:" + ticket + ", CIG=" + codiceCIG + ", CFRUP=" + cfrup + ", CFSA=" + cfsa + ")");
          }

          if (responseConsultaGara != null) {
            if (responseConsultaGara.getSuccess()) {
              if (eseguiControlliPreliminari) {
                if (this.controlliPreliminariDati_ViaWS(responseConsultaGara,
                    idGara, cfrup, cfsa, resultXML)) {
                  resultXML.setError(responseConsultaGara.getError());
                  resultXML.setSuccess(responseConsultaGara.getSuccess());
                  resultXML.setGaraXML(responseConsultaGara.getGaraXML().toString());
                }
              } else {
                resultXML.setError(responseConsultaGara.getError());
                resultXML.setSuccess(responseConsultaGara.getSuccess());
                resultXML.setGaraXML(responseConsultaGara.getGaraXML().toString());
              }
            } else {
              logger.error("La richiesta consultaGara con codice CIG pari a '" + codiceCIG + "' e' terminata "
                  + "con esito negativo, fornendo il seguente messaggio: " + responseConsultaGara.getError());
  
              resultXML.setError(responseConsultaGara.getError());
              resultXML.setSuccess(responseConsultaGara.getSuccess());
              resultXML.setGaraXML(null);
            }
          } else {
            logger.error("La richiesta consultaGara con codice CIG pari a '" + codiceCIG + "' e' terminata "
                + "con esito negativo, in quanto l'oggetto ritornato (responseConsultaGara) e' null");

            resultXML.setError("Errore inaspettato: la richiesta ha ottenuto una risposta non valorizzata");
            resultXML.setSuccess(false);
            resultXML.setGaraXML(null); 
          }
            
        } catch (RemoteException re) {
          logger.error("Errore durante l'operazione consultaGara sui servizi SIMOG", re);
          resultXML.setError("Errore durante l'operazione di consultazione dati sui servizi SIMOG");
          resultXML.setSuccess(false);
          resultXML.setGaraXML(null);

        } catch (Throwable t) {
          logger.error("Errore inaspettato durante l'operazione consultaGara sui servizi SIMOG", t);
          resultXML.setError("Errore inaspettato durante l'operazione di consultazione dati sui servizi SIMOG");
          resultXML.setSuccess(false);
          resultXML.setGaraXML(null);
        } finally {
          // Alla fine dell'interazione con i servizi Simog si rilascia il ticket usato
          // (all'oggetto TicketSimogManager si segnala semplicemente che si e' terminato
          // di usare il ticket) 
          this.ticketSimogManager.rilasciaTicket();
        }
      } else {
        // il ticketSimogManager non e' riuscito a fornire un ticket... 
        this.ticketSimogManager.resetTicket();
        
        // richiesta del ticket terminata con errore
        logger.error("Errore durante l'operazione di login ai servizi Simog");
        resultXML.setError("Errore durante l'operazione di login ai servizi SIMOG");
        resultXML.setSuccess(false);
        resultXML.setGaraXML(null);
      }
    } else {
      String message = "Errore durante la connessione ai servizi SIMOG: i parametri di connessione "
        + "al server non sono specificati correttamente. Contattare un amministratore.";
      logger.error(message);

      resultXML.setError(message);
      resultXML.setSuccess(false);
      resultXML.setGaraXML(null);
    }
    
    if (logger.isDebugEnabled()) {
      logger.debug("consultaGaraViaWS: fine metodo");
    }
  }*/


  /**
   * Controlli preliminari della gara e dei lotti ricevuti da SIMOG con accesso 
   * indiretto via web service.
   * 
   * @param hmResponseConsultaGara
   * @param idAvGara
   * @param codUffInt
   * @param syscon
   * @param resultMap
   * @return Ritorna true se i controlli sono andati a buon fine, false altrimenti
   */
  /*private boolean controlliPreliminariDati_ViaWS (
      final ResponseConsultaGara responseConsultaGara, final String codiceCIG,
        final String cfrup, final String cfsa, it.toscana.rete.rfc.sitatort.ResponseConsultaGara resultXML) {
    
    if (logger.isDebugEnabled()) {
      logger.debug("controlliPreliminariDati_ViaWS: inizio metodo");
    }
    boolean result = true;

    GaraType garaType = null;
    SchedaType schedaType = null;
    StringBuffer msgErroreGara = new StringBuffer("");
    
    // Se codiceCIG e' valorizzato, allora SIMOG risponde con i dati della gara
    // e del lotto associato al CIG indicato
    schedaType = responseConsultaGara.getGaraXML();
    garaType = schedaType.getDatiGara().getGara();
    String abilitaControlloRup = ConfigManager.getValore(CostantiSimog.PROP_SITAT_CONSULTA_GARA_CONTROLLO_RUP);
    
    if (!garaType.getCFAMMINISTRAZIONE().equals(cfsa)) {
    	msgErroreGara.append("stazione appaltante della gara diversa da quelli indicata");
    } else if ((abilitaControlloRup == null || abilitaControlloRup.equals("1")) && !garaType.getCFUTENTE().equalsIgnoreCase(cfrup)) {
		msgErroreGara.append("RUP della gara diverso da quello indicato");
    }
  
    if (schedaType != null) {
      if (schedaType.getDatiGara().getLotto() != null) {
        LottoType lottoType = schedaType.getDatiGara().getLotto();

        if (lottoType.getDATAPUBBLICAZIONE() == null) {
          if (msgErroreGara.length() > 0) {
            msgErroreGara.append(" e ");
          }
          msgErroreGara.append(" lotto non e' perfezionato");
        }
      } else {
        if (msgErroreGara.length() > 0) {
          msgErroreGara.append(" e ");
        }
        msgErroreGara.append(" lotto non e' perfezionato");
      }
    }
  
    if (msgErroreGara.length() > 0) {
      StringBuffer msgErrore = new StringBuffer(
          "Non sono stati superati i controlli preliminari sui dati ricevuti da SIMOG: ");

      if (StringUtils.isNotEmpty(msgErroreGara.toString())) {
        msgErrore.append(msgErroreGara);
      }

      resultXML.setSuccess(Boolean.FALSE);
      resultXML.setError(msgErrore.toString());

      logger.error(msgErrore.toString());
      result = false;
    }

    if (logger.isDebugEnabled()) {
      logger.debug("controlliPreliminariDati_ViaWS: fine metodo");
    }
    
    return result;
  }*/
  
  
  /*private boolean controlliPreliminariDati_ViaWS (
      final ResponseConsultaNumeroGara responseConsultaNumeroGara, final String idAvGara,
          final String cfrup, final String cfsa,
              it.toscana.rete.rfc.sitatort.ResponseConsultaGara resultXML) {
    
    if (logger.isDebugEnabled()) {
      logger.debug("controlliPreliminariDati_ViaWS: inizio metodo");
    }
    boolean result = true;

    GaraType garaType = null;
    SchedaGaraCig schedaGaraCigType = null;
    StringBuffer msgErroreGara = new StringBuffer("");

    schedaGaraCigType = responseConsultaNumeroGara.getSchedaGaraCig();
    garaType = schedaGaraCigType.getGara();
    if (!garaType.getCFAMMINISTRAZIONE().equals(cfsa)) {
      msgErroreGara.append("stazione appaltante diversa da quella indicata");
    }
   
    if (msgErroreGara.length() > 0) {
      StringBuffer msgErrore = new StringBuffer(
          "Non sono stati superati i controlli preliminari sui dati ricevuti da SIMOG: ");
  
      if (StringUtils.isNotEmpty(msgErroreGara.toString())) {
        msgErrore.append(msgErroreGara);
      }
  
      resultXML.setSuccess(Boolean.FALSE);
      resultXML.setError(msgErrore.toString());

      logger.error(msgErrore.toString());
      result = false;
    }

    if (logger.isDebugEnabled()) {
      logger.debug("controlliPreliminariDati_ViaWS: fine metodo");
    }
    
    return result;
  }*/
  
  
  /**
   * Controlli preliminari della gara e dei lotti ricevuti da SIMOG con accesso 
   * via PDD.
   * 
   * @param responseConsultaGara
   * @param idAvGara
   * @param codUffInt
   * @param syscon
   * @param resultMap
   * @return Ritorna true se i controlli sono andati a buon fine, false altrimenti
   */
  private boolean controlliPreliminariDati_ViaPDD (
      final ResponseConsultaGara responseConsultaGara,
      final String codiceCIG, final String idAvGara, final String cfrup, final String cfsa,
      it.toscana.rete.rfc.sitatort.ResponseConsultaGara resultXML) {
    
    if (logger.isDebugEnabled()) {
      logger.debug("controlliPreliminariDati_ViaPDD: inizio metodo");
    }

    boolean result = true;
    StringBuffer msgErroreGara = new StringBuffer("");
   
    SchedaType schedaType = responseConsultaGara.getGaraXML();
    GaraType garaType = schedaType.getDatiGara().getGara();
    
    String garaTypeCfUtente = garaType.getCFUTENTE();
    String datiComuniCfRup = null;
    String codiceFiscaleRUP = null;
    if (schedaType.isSetDatiScheda() &&
        StringUtils.isNotEmpty(schedaType.getDatiScheda().getDatiComuni().getCFRUP())) {
      datiComuniCfRup = schedaType.getDatiScheda().getDatiComuni().getCFRUP();
    }
    
    if (StringUtils.isNotEmpty(datiComuniCfRup)) {
      codiceFiscaleRUP = new String(datiComuniCfRup);
    } else {
      codiceFiscaleRUP = new String(garaTypeCfUtente);
    }
    
    if (!garaType.getCFAMMINISTRAZIONE().equalsIgnoreCase(cfsa) &&
        !codiceFiscaleRUP.equalsIgnoreCase(cfrup)) {
      msgErroreGara.append("stazione appaltante e RUP della gara diversi da quelli indicati");
    } else {
      String abilitaControlloRup = ConfigManager.getValore(CostantiSimog.PROP_SITAT_CONSULTA_GARA_CONTROLLO_RUP);
      if (!garaType.getCFAMMINISTRAZIONE().equalsIgnoreCase(cfsa)) {
      	msgErroreGara.append("stazione appaltante della gara diversa da quelli indicata");
      } else if ((abilitaControlloRup == null || abilitaControlloRup.equals("1")) &&
  	    !codiceFiscaleRUP.equalsIgnoreCase(cfrup)) {
        if (msgErroreGara.length() > 0) {
          msgErroreGara.append(", ");
        }
        msgErroreGara.append("RUP della gara diverso da quello indicato");
      }
    }
    
    if (schedaType.getDatiGara().getLotto() != null) {
      LottoType lottoType = schedaType.getDatiGara().getLotto();

      if (lottoType.getDATAPUBBLICAZIONE() == null) {
        if (msgErroreGara.length() > 0) {
          msgErroreGara.append(" e ");
        }
        msgErroreGara.append(" lotto non e' perfezionato");
      }
    } else {
      if (msgErroreGara.length() > 0) {
        msgErroreGara.append(" e ");
      }
      msgErroreGara.append(" lotto non e' perfezionato");
    }
    
    if (msgErroreGara.length() > 0) {
      StringBuffer msgErrore = new StringBuffer(
          "Non sono stati superati i controlli preliminari sui dati ricevuti da SIMOG: ");
  
      if (StringUtils.isNotEmpty(msgErroreGara.toString())) {
        msgErrore.append(msgErroreGara);
      } 
  
      resultXML.setSuccess(Boolean.FALSE);
      resultXML.setError(msgErrore.toString());

      logger.error(msgErrore.toString());
      result = false;
    }

    if (logger.isDebugEnabled()) {
      logger.debug("controlliPreliminariDati_ViaPDD: fine metodo");
    }
    
    return result;
  }
  
}