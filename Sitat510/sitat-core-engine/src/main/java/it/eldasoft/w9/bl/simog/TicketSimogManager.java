package it.eldasoft.w9.bl.simog;

import it.avlp.simog.massload.xmlbeans.ChiudiSessione;
import it.avlp.simog.massload.xmlbeans.ChiudiSessioneDocument;
import it.avlp.simog.massload.xmlbeans.ChiudiSessioneResponseDocument;
import it.avlp.simog.massload.xmlbeans.Login;
import it.avlp.simog.massload.xmlbeans.LoginDocument;
import it.avlp.simog.massload.xmlbeans.LoginResponse;
import it.avlp.simog.massload.xmlbeans.LoginResponseDocument;
import it.avlp.simog.massload.xmlbeans.ResponseCheckLogin;
import it.avlp.simog.massload.xmlbeans.ResponseChiudiSession;
import it.avlp.simog.massload.xmlbeans.SimogWSPDDServiceStub;
import it.eldasoft.gene.commons.web.domain.CostantiGenerali;
import it.eldasoft.utils.properties.ConfigManager;
import it.eldasoft.utils.sicurezza.CriptazioneException;
import it.eldasoft.utils.sicurezza.FactoryCriptazioneByte;
import it.eldasoft.utils.sicurezza.ICriptazioneByte;
import it.eldasoft.w9.common.CostantiSimog;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * Manager per la gestione del ticket necessario alle chiamate ai servizi Simog.
 * Se non dispone del ticket effettua login e ritorna il nuovo ticket.
 * Una volta terminato di usare il ticket chiamare il metodo rilasciaTicket.
 * 
 * @author Luca.Giacomazzo
 */
public class TicketSimogManager {

  /**
   * Questo manager e' usato solo in modalita' Regione dalla classe GeneraIdGaraCigManager
   */
  
  // SIMOGWS_WSSMANAGER_APP_18 errore simog in caso di sessione gia' aperta
  
  /**
   * Gli errori SIMOGWS_WSSMANAGER_APP_nn con nn 01,..,18 sono tutti errori relativi alla sessione.
   * 
   * Gli errori SIMOGWS_TICKETMANAGER* sono errori relativi al ticket o alle collaborazioni.
   */
  
  static Logger logger = Logger.getLogger(TicketSimogManager.class);
  
  private TicketSimogBean ticketSimogBean = null;
  
  /**
   * Numero di ticket distribuiti ai metodi che fanno accesso ai servizi SIMOG.
   */
  private int numeroTicketDistribuiti = 0;
  
  /**
   * Ritorna il ticket per l'accesso ai diversi metodi dei servizi SIMOG.
   * 
   * @return the ticket
   */
  public TicketSimogBean getTicket() {
    if (this.ticketSimogBean == null || this.numeroTicketDistribuiti < 1) {
    	this.ticketSimogBean = null;
    	this.numeroTicketDistribuiti = 0; 
      synchronized (this) {
    	if (this.ticketSimogBean == null || this.numeroTicketDistribuiti < 1) {
    	  this.ticketSimogBean = null;
    	  this.numeroTicketDistribuiti = 0;
    	  this.ticketSimogBean = this.eseguiLoginServiziSimog();
    	  if (this.ticketSimogBean.isSuccess()) {
            this.numeroTicketDistribuiti++;
          } else {
        	this.ticketSimogBean = null;
            this.numeroTicketDistribuiti = 0;
          }
          
          if (logger.isDebugEnabled()) {
            logger.debug("Numero Ticket Simog Distribuiti=" + this.numeroTicketDistribuiti);
          }
          
          return this.ticketSimogBean;
        } else {
          synchronized (this) {
            this.numeroTicketDistribuiti++;
            
            if (logger.isDebugEnabled()) {
              logger.debug("Numero Ticket Simog Distribuiti=" + this.numeroTicketDistribuiti);
            }
            
            return this.ticketSimogBean;
          }
        }
      }
    } else {
      synchronized (this) {
    	if (this.numeroTicketDistribuiti < 1) {
    	  if (logger.isDebugEnabled()) {
    	    logger.debug("Numero Ticket Simog Distribuiti e' minore di 1. Bisogna effettuare un nuovo login ai servizi SIMOG");
    	  }
    	  // Numero di ticket distribuiti minore di 1. Quindi bisogna effettuare di nuovo 
    	  // login ai servzi SIMOG per richiedere un nuovo ticket.
    	  this.ticketSimogBean = null;
    	  this.numeroTicketDistribuiti = 0;
    	  
    	  this.ticketSimogBean = this.eseguiLoginServiziSimog();
    	  if (this.ticketSimogBean.isSuccess()) {
            this.numeroTicketDistribuiti++;
          } else {
        	this.ticketSimogBean = null;
            this.numeroTicketDistribuiti = 0;
          }
    	  
    	  return null;
    	} else {
	      this.numeroTicketDistribuiti++;
	        
	      if (logger.isDebugEnabled()) {
	        logger.debug("Numero Ticket Simog Distribuiti=" + this.numeroTicketDistribuiti);
	      }
	        
	      return this.ticketSimogBean;
    	}
      }
    }
  }
  
  /**
   * Metodo per indicare al TicketSimogManager che si e' terminato di 
   * usare il ticket precedentemente fornito. 
   */
  public void rilasciaTicket() {
    synchronized(this) {
      if (this.numeroTicketDistribuiti > 0) {
        this.numeroTicketDistribuiti--;
      }
      
      if (this.numeroTicketDistribuiti == 0) {
        if (this.ticketSimogBean != null) {
          this.eseguiLogoutServiziSimog();
          this.ticketSimogBean = null;
        }
      }
      
      // Per evitare situazioni incoerenti si fanno due controlli ulteriori
      // su ticket e numeroTicketDistribuiti
      if (this.ticketSimogBean != null && this.numeroTicketDistribuiti == 0) {
        this.eseguiLogoutServiziSimog();
        this.ticketSimogBean = null;
      }
      
      if (this.ticketSimogBean == null && this.numeroTicketDistribuiti != 0) {
        this.numeroTicketDistribuiti = 0;
      }
      
      if (logger.isDebugEnabled()) {
        logger.debug("Numero Ticket Simog Distribuiti=" + this.numeroTicketDistribuiti);
      }
    }
  }
  
  /**
   * 
   */
  private TicketSimogBean eseguiLoginServiziSimog() {
    int tipoAccessoServiziSIMOG = 0;
    
    String a = ConfigManager.getValore(CostantiSimog.PROP_TIPO_ACCESSO);
    if (StringUtils.isNotEmpty(a)) {
      tipoAccessoServiziSIMOG = Integer.parseInt(a);
    }
    
    TicketSimogBean ticketBean = null;
    String msgError = null;
    
    // Gestione della connessione
    String urlServiziSimog = null;
    String loginServiziSimog = null;
    String passwordServiziSimog = null;
    
    a = ConfigManager.getValore(CostantiSimog.PROP_SIMOG_WS_URL);
    if (StringUtils.isNotEmpty(a)) {
      urlServiziSimog = a;
    } else {
      logger.error("L'indirizzo per la connessione alla PDD non e' definito");
    }
    
    a = ConfigManager.getValore(CostantiSimog.PROP_SIMOG_WS_LOGIN);
    if (StringUtils.isNotEmpty(a)) {
      loginServiziSimog = a;
    } else {
      logger.error("Login per la connessione ai servizi SIMOG non e' definita");
    }
    
    a = ConfigManager.getValore(CostantiSimog.PROP_SIMOG_WS_PASSWORD);
    if (StringUtils.isNotEmpty(a)) {
      try {
        ICriptazioneByte cript = FactoryCriptazioneByte.getInstance(
            ConfigManager.getValore(CostantiGenerali.PROP_TIPOLOGIA_CIFRATURA_DATI),
            a.getBytes(), ICriptazioneByte.FORMATO_DATO_CIFRATO);
        passwordServiziSimog = new String(cript.getDatoNonCifrato());
      } catch (CriptazioneException e) {
        logger.error("Errore nella decriptazione della password di accesso ai servizi SIMOG");
      }
    } else {
      logger.error("Password per la connessione ai servizi SIMOG non e' definita");
    }
    
    if (StringUtils.isNotEmpty(urlServiziSimog)
        && StringUtils.isNotEmpty(loginServiziSimog)
        && StringUtils.isNotEmpty(passwordServiziSimog)) {

      switch (tipoAccessoServiziSIMOG) {
      //case CostantiSimog.SA_CONSULTA_GARA_ACCESSO_VIA_WS:
      //case CostantiSimog.SA_CONSULTA_GARA_ACCESSO_INDIRETTO_VIA_WS:
      case CostantiSimog.ORT_CONSULTA_GARA_VIA_WS:
        try {
          //ticketBean = this.eseguiLoginServiziSimogWS(urlServiziSimog, loginServiziSimog, passwordServiziSimog);
          ticketBean = this.eseguiLoginServiziSimogPDD(urlServiziSimog, loginServiziSimog, passwordServiziSimog);
        } catch (RemoteException e1) {
          msgError = "";
        } catch (Throwable t) {
          logger.error("Errore inatteso durante l'operzione di login", t);
          msgError = "";
        } finally {
          if (msgError != null) {
            ticketBean = new TicketSimogBean();
            ticketBean.setSuccess(false);
            ticketBean.setMsgError(msgError);          
          }
        }
        break;
  
      //case CostantiSimog.SA_CONSULTA_GARA_ACCESSO_VIA_PDD:
      //case CostantiSimog.SA_CONSULTA_GARA_ACCESSO_INDIRETTO_VIA_PDD:
      case CostantiSimog.ORT_CONSULTA_GARA_VIA_PDD:
        try {
          ticketBean = this.eseguiLoginServiziSimogPDD(urlServiziSimog, loginServiziSimog, passwordServiziSimog);
        } catch (AxisFault af) {
          logger.error("Eccezione per un errore di tipo SOAP", af);
          msgError = "1";
        } catch (RemoteException re) {
          logger.error("Eccezione remota durante l'operazione di login ai servizi SIMOG", re);
          msgError = "2";
        } catch (CriptazioneException ce) {
      	  logger.error("Eccezione di criptazione durante l'operazione di login ai servizi SIMOG", ce);
          msgError = "3";
        } catch (Throwable t) {
          logger.error("Errore inatteso durante l'operazione di login", t);
          msgError = "4";
        } finally {
          if (msgError != null) {
            ticketBean = new TicketSimogBean();
            ticketBean.setSuccess(false);
            ticketBean.setMsgError("Errore inatteso durante l'operazione di login");          
          }
        }
        break;
      
      default:
        msgError = "Errore nella configurazione dell'applicazione: non e' stato " +
            "indicato il tipo di accesso ai servizi Simog";
        logger.error(msgError);
        ticketBean = new TicketSimogBean();
        ticketBean.setSuccess(false);
        ticketBean.setMsgError(msgError + ". Contattare un amministratore");
        
        break;
      }
    } else {
      String message = "Errore durante la connessione ai servizi SIMOG: i parametri di connessione "
        + "al server non sono specificati correttamente. Contattare un amministratore.";
      logger.error(message);
      
      ticketBean = new TicketSimogBean();
      ticketBean.setMsgError(message);
      ticketBean.setSuccess(false);
    }
    
    return ticketBean;
  }
  
  /**
   * Metodo per l'esecuzione dell'operazione chiudiSessione su Simog, con conseguente
   * invalidazione del ticket. Non interessa l'esito dell'operazione. A prescindere
   * dall'esito si prosegue come se fosse andato tutto bene.
   */
  private void eseguiLogoutServiziSimog() {
    
    int tipoAccessoServiziSIMOG = 0;
    String a = ConfigManager.getValore(CostantiSimog.PROP_TIPO_ACCESSO);
    if (StringUtils.isNotEmpty(a)) {
      tipoAccessoServiziSIMOG = Integer.parseInt(a);
    }

    String msgError = null;
    
    // Gestione della connessione
    String urlServiziSimog = null;
    
    a = ConfigManager.getValore(CostantiSimog.PROP_SIMOG_WS_URL);
    if (StringUtils.isNotEmpty(a)) {
      urlServiziSimog = a;
    } else {
      logger.error("L'indirizzo per la connessione alla PDD non e' definito");
    }
    
    switch (tipoAccessoServiziSIMOG) {
    case CostantiSimog.ORT_CONSULTA_GARA_VIA_WS:
      try {
        //this.eseguiLogoutServiziSimogWS(urlServiziSimog);
        this.eseguiLogoutServiziSimogPDD(urlServiziSimog);
      } catch (Throwable t) {
        logger.error("Errore inaspettato durante l'operazione chiudiSessione sui servizi Simog", t);
      }
      break;

    case CostantiSimog.ORT_CONSULTA_GARA_VIA_PDD:
      try {
        this.eseguiLogoutServiziSimogPDD(urlServiziSimog);
      } catch (Throwable t) {
        logger.error("Errore inaspettato durante l'operazione chiudiSessione sui servizi Simog", t);
      }
      break;
    
    default:
      msgError = "Errore nella configurazione dell'applicazione: non e' stato " +
          "indicato il tipo di accesso ai servizi Simog";
      logger.error(msgError);
      break;
    }
  }

  /**
   * Metodo che, dopo aver fatto login su Simog attraverso la PDD, restituisce un bean
   * contenente il ticket fornito da Simog e l'esito positivo dell'operazione se
   * l'operazione di login e' terminata con successo, oppure ritorna lo stesso bean
   * con il messaggio di errore e l'esito negativo dell'operazione.
   * In caso di eccezioni queste vengono riemesse.  
   * 
   * @param url
   * @param login
   * @param password
   * @return Ritorna TicketSimogBean con ticket valorizzato e success = true se l'operazione
   * di login e' terminata con successo, altrimenti ritorna TicketSimogBean con success = false,
   * ticket non valorizzato e il messaggio di errore di valorizzato.
   *   
   * @throws AxisFault
   * @throws RemoteException
   * @throws CriptazioneException
   */
  private TicketSimogBean eseguiLoginServiziSimogPDD(String url, String login, String password)
      throws AxisFault, RemoteException, CriptazioneException {
    
    if (logger.isDebugEnabled()) {
      logger.debug("eseguiLoginServiziSimogPDD: inizio metodo");
    }
    
    TicketSimogBean ticketBean = new TicketSimogBean();
    
    // Creazione della options contenente i parametri necessari alla basic authentication
    HttpTransportProperties.Authenticator basicAuth = null;
    try {
      basicAuth = this.getBasicAuthentication();
    } catch (CriptazioneException ce) {
      logger.error("Errore nella decriptazione della password per la Basic Authentication "
          + "alla PDD. Contattare un amministratore.", ce);
      throw ce;
    }

    SimogWSPDDServiceStub simogWsPddServiceStub = null;
    ResponseCheckLogin responseCheckLogin = null;

    if (basicAuth == null) {
      simogWsPddServiceStub = new SimogWSPDDServiceStub(url);
    } else {
      simogWsPddServiceStub = new SimogWSPDDServiceStub(url + "/login");
      simogWsPddServiceStub._getServiceClient().getOptions().setProperty(
          HTTPConstants.AUTHENTICATE, basicAuth);
    }
    
    LoginDocument loginDoc = LoginDocument.Factory.newInstance();
    Login loginIn = Login.Factory.newInstance();
    loginIn.setLogin(login);
    loginIn.setPassword(password);
    loginDoc.setLogin(loginIn);

    LoginResponseDocument loginResponseDoc = null; 
    
    try {
      if (logger.isInfoEnabled()) {
        logger.info("Invocazione metodo login verso i Servizi SIMOG");
      }
      
      String strTimeOut = ConfigManager.getValore(CostantiSimog.PROP_SITAT_CLIENT_TIMEOUT);
      if (StringUtils.isNotEmpty(strTimeOut)) {
        Integer timeOutClient = new Integer(strTimeOut);
        simogWsPddServiceStub._getServiceClient().getOptions().setProperty(
            HTTPConstants.SO_TIMEOUT, timeOutClient);
        simogWsPddServiceStub._getServiceClient().getOptions().setProperty(
            HTTPConstants.CONNECTION_TIMEOUT, timeOutClient);
      }
      
      logger.info("Invocazione il metodo login verso i Servizi SIMOG");
      loginResponseDoc = simogWsPddServiceStub.login(loginDoc);
      logger.info("Invocato il metodo login verso i Servizi SIMOG");
      
      if (logger.isInfoEnabled()) {
        logger.info("Invocato metodo login verso i Servizi SIMOG");
      }
    } catch (RemoteException re) {
      logger.error("Errore nell'interazione con la porta di dominio per l'accesso al "
          + "WS Simog per la chiamata consultaGara durante la funzione 'Carica lotto da "
          + "SIMOG' con codiceCIG='" + "'", re);
      throw re;
    }
    
    if (loginResponseDoc != null) {
      LoginResponse loginResponse = loginResponseDoc.getLoginResponse();
      
      if (loginResponse.isSetReturn() || loginResponse.getReturn() != null) {
        responseCheckLogin = loginResponse.getReturn();
        
        if (responseCheckLogin.getSuccess()) {
          ticketBean.setTicketSimog(responseCheckLogin.getTicket());
          ticketBean.setCollaborazioniPDD(responseCheckLogin.getColl());
          ticketBean.setSuccess(true);
          if (logger.isInfoEnabled()) {
            logger.info("Login ai servizi SIMOG eseguito con successo (Ticket=" + 
                responseCheckLogin.getTicket() + ")");
          }
        } else {
          logger.error("L'operazione di login su Simog e' terminata con il seguente errore: "
              + responseCheckLogin.getError());
          ticketBean.setSuccess(false);
          ticketBean.setMsgError(responseCheckLogin.getError());              
        }
      } else {
        logger.error("L'oggetto loginResponse ritornato da Simog non ha valorizzato l'oggetto ResponseCheckLogin");
        ticketBean.setSuccess(false);
        ticketBean.setMsgError("Errore durante l'operazione di login ai servizi Simog (1)");
      }
    } else {
      logger.error("L'oggetto loginResponseDoc ritornato da Simog non e' valorizzato");
      ticketBean.setSuccess(false);
      ticketBean.setMsgError("Errore durante l'operazione di login ai servizi Simog (2)");
    }
    
    if (logger.isDebugEnabled()) {
      logger.debug("eseguiLoginServiziSimogPDD: fine metodo");
    }
    
    return ticketBean;
  }
  
  /**
   * 
   * @param url
   * @param login
   * @param password
   * 
   * @return
   * @throws ServiceException 
   * @throws RemoteException 
   */
  /*private TicketSimogBean eseguiLoginServiziSimogWS(String url, String login, String password)
      throws ServiceException, RemoteException {
    
    TicketSimogBean ticketBean = new TicketSimogBean();
    
    if (logger.isDebugEnabled()) {
      logger.debug("eseguiLoginServiziSimogWS: inizio metodo");
    }

    SimogWSPDDProxy simogWsPddProxy = null;
    ResponseCheckLogin rispostaLogin = null;
      
    try {
      simogWsPddProxy = new SimogWSPDDProxy(url);
      
      Stub serviceStub = (Stub) simogWsPddProxy.getSimogWSPDD();
      
      String chiavePropUsername = CostantiSimog.PROP_PDD_BA_SIMOGWS_USERNAME;
      String chiavePropPassword = CostantiSimog.PROP_PDD_BA_SIMOGWS_PASSWORD;
      
      String passwordBasicAuthPDD = null;
      
      String usernameBasicAuthPDD = ConfigManager.getValore(chiavePropUsername);
      String tempPasswordBasicAuthPDD = ConfigManager.getValore(chiavePropPassword);
    
      if (StringUtils.isNotEmpty(tempPasswordBasicAuthPDD)) {
        ICriptazioneByte criptazione = FactoryCriptazioneByte.getInstance(
            ConfigManager.getValore(CostantiGenerali.PROP_TIPOLOGIA_CIFRATURA_DATI),
            tempPasswordBasicAuthPDD.getBytes(), ICriptazioneByte.FORMATO_DATO_CIFRATO);
        passwordBasicAuthPDD = new String(criptazione.getDatoNonCifrato());
      }
      
      if (StringUtils.isNotEmpty(usernameBasicAuthPDD) && StringUtils.isNotEmpty(passwordBasicAuthPDD)) {
        ((Stub) serviceStub)._setProperty(Call.USERNAME_PROPERTY, usernameBasicAuthPDD);
        ((Stub) serviceStub)._setProperty(Call.USERNAME_PROPERTY, passwordBasicAuthPDD);
      }
      
      rispostaLogin = simogWsPddProxy.login(login, password);

      if (rispostaLogin.isSuccess()) {
        ticketBean.setTicketSimog(new String(rispostaLogin.getTicket()));
        ticketBean.setCollaborazioniWS(rispostaLogin.getColl());
        ticketBean.setSuccess(true);
      } else {
        String message = "Errore durante la connessione ai servizi SIMOG: ";
        message += rispostaLogin.getError();
        logger.error("Il tentativo di connessione ha generato il seguente errore: "
            + rispostaLogin.getError());
        ticketBean.setMsgError(message);
        ticketBean.setSuccess(false);
        ticketBean.setTicketSimog(null);
      }
    /*} catch (ServiceException se) {
      logger.error("Errore durante l'istanziazione del client per accedere ai servizi SIMOG", se);
      throw se;*/
    /*} catch (RemoteException re) {
      logger.error("Errore durante l'operazione di login ai servizi SIMOG", re);
      throw re;
    } catch (CriptazioneException ce) {
      logger.error("Errore nella decifratura della passowrd per la BasicAuthentication di accesso ai servizi Simog ", ce);
    }
    
    if (logger.isDebugEnabled()) {
      logger.debug("eseguiLoginServiziSimogWS: fine metodo");
    }
    
    return ticketBean;
  }*/

  
  /**
   * Metodo per l'esecuzione dell'operazione chiudiSessione su Simog tramite Web Service,
   * con conseguente invalidazione del ticket.
   * 
   * @param urlServiziSimog
   */
  /*private void eseguiLogoutServiziSimogWS(String urlServiziSimog) {
    SimogWSPDD serviceSimogWS = null;
    ResponseChiudiSession rispostaChiudiSessione = null;
    
    try {
      SimogWSPDDServiceLocator wsLocator = new SimogWSPDDServiceLocator();
      wsLocator.setSimogWSPDDPortEndpointAddress(urlServiziSimog);
      serviceSimogWS = wsLocator.getSimogWSPDDPort();

      Stub serviceStub = (Stub) serviceSimogWS;
      
      String chiavePropUsername = CostantiSimog.PROP_PDD_BA_SIMOGWS_USERNAME;
      String chiavePropPassword = CostantiSimog.PROP_PDD_BA_SIMOGWS_PASSWORD;
      
      String passwordBasicAuthPDD = null;
      
      String usernameBasicAuthPDD = ConfigManager.getValore(chiavePropUsername);
      String tempPasswordBasicAuthPDD = ConfigManager.getValore(chiavePropPassword);
    
      if (StringUtils.isNotEmpty(tempPasswordBasicAuthPDD)) {
        ICriptazioneByte criptazione = FactoryCriptazioneByte.getInstance(
            ConfigManager.getValore(CostantiGenerali.PROP_TIPOLOGIA_CIFRATURA_DATI),
            tempPasswordBasicAuthPDD.getBytes(), ICriptazioneByte.FORMATO_DATO_CIFRATO);
        passwordBasicAuthPDD = new String(criptazione.getDatoNonCifrato());
      }
      
      if (StringUtils.isNotEmpty(usernameBasicAuthPDD) && StringUtils.isNotEmpty(passwordBasicAuthPDD)) {
        ((Stub) serviceStub)._setProperty(Call.USERNAME_PROPERTY, usernameBasicAuthPDD);
        ((Stub) serviceStub)._setProperty(Call.USERNAME_PROPERTY, passwordBasicAuthPDD);
      }
      
      logger.info("Invocazione del metodo chiudiSessione (Ticket:" + this.ticketSimogBean.getTicketSimog() + ")");
      rispostaChiudiSessione = serviceSimogWS.chiudiSessione(this.ticketSimogBean.getTicketSimog());
      logger.info("Invocato il metodo consultaGara (Ticket:" + this.ticketSimogBean.getTicketSimog() + ")");
    } catch (RemoteException re) {
      logger.error("Errore durante l'operazione di logout ai servizi SIMOG", re);
      rispostaChiudiSessione = null;
    } catch (Throwable t) {
      logger.error("Errore inaspettato durante l'operazione di logout ai servizi SIMOG", t);
      rispostaChiudiSessione = null;
    }

    if (rispostaChiudiSessione != null) {
      if (!rispostaChiudiSessione.getSuccess()) {
        logger.error("La chiusura della connessione identificata dal ticket "
            + this.ticketSimogBean.getTicketSimog()
            + " ha generato il seguente errore: "
            + rispostaChiudiSessione.getError());
      }
    }
  }*/
  
  /**
   * Metodo per l'esecuzione dell'operazione chiudiSessione su Simog tramite PDD,
   * con conseguente invalidazione del ticket.
   * 
   * @param urlServiziSimog
   * @throws CriptazioneException 
   * @throws RemoteException 
   */
  private void eseguiLogoutServiziSimogPDD(String urlServiziSimog)
      throws CriptazioneException, AxisFault, RemoteException {

    ChiudiSessione chiudiSessione = ChiudiSessione.Factory.newInstance();
    chiudiSessione.setTicket(this.ticketSimogBean.getTicketSimog());
  
    // Creazione della options contenente i parametri necessari alla basic authentication
    HttpTransportProperties.Authenticator basicAuth = null;
    try {
      basicAuth = this.getBasicAuthentication();
    } catch (CriptazioneException ce) {
      logger.error("Errore nella decriptazione della password per la Basic Authentication "
          + "alla PDD. Contattare un amministratore.", ce);
      throw ce;
    }
    
    ChiudiSessioneDocument chiudiSessioneDoc = ChiudiSessioneDocument.Factory.newInstance();
    chiudiSessioneDoc.setChiudiSessione(chiudiSessione);

    SimogWSPDDServiceStub simogWsPddServiceStub = null;
    
    if (basicAuth == null) {
      simogWsPddServiceStub = new SimogWSPDDServiceStub(urlServiziSimog);
    } else {
      simogWsPddServiceStub = new SimogWSPDDServiceStub(urlServiziSimog + "/chiudiSessione");
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
    
    logger.info("Invocazione metodo chiudiSessione verso i Servizi SIMOG (Ticket=" + this.ticketSimogBean.getTicketSimog() + ")");
    ChiudiSessioneResponseDocument chiudiSessioneResponseDoc = 
        simogWsPddServiceStub.chiudiSessione(chiudiSessioneDoc);
    logger.info("Invocato il metodo chiudiSessione verso i Servizi SIMOG (Ticket=" + this.ticketSimogBean.getTicketSimog() + ")");
    
    ResponseChiudiSession responseChiudiSessione =
      chiudiSessioneResponseDoc.getChiudiSessioneResponse().getReturn();
    
    if (!responseChiudiSessione.getSuccess()) {
      logger.error("La chiusura della connessione identificata dal ticket "
          + this.ticketSimogBean.getTicketSimog()
          + " ha generato il seguente errore: "
          + responseChiudiSessione.getError());
    } else {
      logger.error("Chiusura della connessione identificata dal ticket "
    	  + this.ticketSimogBean.getTicketSimog()
          + " terminata con successo");
    }
  }
  
  /**
   * Metodo per resettare l'oggetto ticket memorizzato al livello di application.
   * Questo modo impone di ripartire da una situazione pulita.
   * La situazione peggiore   
   */
  public void resetTicket() {
    synchronized(this) {
      this.numeroTicketDistribuiti  = 0;
      
      if (this.ticketSimogBean != null) {
        this.eseguiLogoutServiziSimog();
        this.ticketSimogBean = null;
      }
      
      if (logger.isDebugEnabled()) {
        logger.debug("Numero Ticket Simog Distribuiti=" + this.numeroTicketDistribuiti);
      }
    }
  }
  
  /**
   * Basic Authentication, solo se valorizzate le relative properties
   * 
   * @return Ritorna l'oggetto HttpTransportProperties.Authenticator con settate la 
   *         basic authentication se le properties sono valorizzate, null altrimenti 
   * @throws GestoreException 
   * @throws CriptazioneException 
   */
  public HttpTransportProperties.Authenticator getBasicAuthentication() throws CriptazioneException {
    HttpTransportProperties.Authenticator auth = null;
    
    String chiavePropUsername = CostantiSimog.PROP_PDD_BA_SIMOGWS_USERNAME;
    String chiavePropPassword = CostantiSimog.PROP_PDD_BA_SIMOGWS_PASSWORD;
    
    String passwordBasicAuthPDD = null;
    
    String usernameBasicAuthPDD = ConfigManager.getValore(chiavePropUsername);
    String tempPasswordBasicAuthPDD = ConfigManager.getValore(chiavePropPassword);
  
    if (StringUtils.isNotEmpty(tempPasswordBasicAuthPDD)) {
      ICriptazioneByte criptazione = FactoryCriptazioneByte.getInstance(
          ConfigManager.getValore(CostantiGenerali.PROP_TIPOLOGIA_CIFRATURA_DATI),
          tempPasswordBasicAuthPDD.getBytes(), ICriptazioneByte.FORMATO_DATO_CIFRATO);
      passwordBasicAuthPDD = new String(criptazione.getDatoNonCifrato());
    }

    if (StringUtils.isEmpty(usernameBasicAuthPDD)) {
      logger.warn("La login per la basic authentication alla PDD dei Servizi Simog non e' definita");
    }
    
    if (StringUtils.isEmpty(passwordBasicAuthPDD)) {
      logger.warn("La password per la basic authentication alla PDD dei Servizi Simog non e' definita");
    }
    
    if (StringUtils.isNotEmpty(usernameBasicAuthPDD) && StringUtils.isNotEmpty(passwordBasicAuthPDD)) {
      auth = new HttpTransportProperties.Authenticator();
      auth.setUsername(usernameBasicAuthPDD);
      auth.setPassword(passwordBasicAuthPDD);
      auth.setPreemptiveAuthentication(true);
    }
    
    return auth;
  }
  
}
