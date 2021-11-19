package it.eldasoft.w9.web.struts;

import it.eldasoft.gene.commons.web.domain.CostantiGenerali;
import it.eldasoft.gene.commons.web.domain.ProfiloUtente;
import it.eldasoft.gene.commons.web.struts.CostantiGeneraliStruts;
import it.eldasoft.gene.commons.web.struts.DispatchActionBaseNoOpzioni;
import it.eldasoft.gene.web.struts.tags.gestori.GestoreException;
import it.eldasoft.w9.bl.ConsultaGaraLottiBean;
import it.eldasoft.w9.bl.ConsultaLottoBean;
import it.eldasoft.w9.bl.EsportazioneXMLSIMOGManager;
import it.eldasoft.w9.bl.RichiestaIdGaraCigManager;
import it.eldasoft.w9.common.CostantiW9;
import it.eldasoft.w9.utils.UtilitySITAT;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Action per la consultazione del metodo getGaraXML dal WS di ORT.
 * 
 * @author Luca.Giacomazzo
 */
public class ConsultaGaraAction extends DispatchActionBaseNoOpzioni {

  /** Logger di classe. */
  private static Logger     logger = Logger.getLogger(ConsultaGaraAction.class);

  /**
   * Manager per gestione della logica di business e delle transazioni sul db.
   */
  private RichiestaIdGaraCigManager richiestaIdGaraCigManager;

  /**
   * Manager per la gestione della logica di esportazione XML verso SIMOG.
   */
  private EsportazioneXMLSIMOGManager exportXmlSimogManager;
  
  /**
   * @param richiestaIdGaraCigManager
   *        richiestaIdGaraCigManager da settare internamente alla classe.
   */
  public void setRichiestaIdGaraCigManager(RichiestaIdGaraCigManager richiestaIdGaraCigManager) {
    this.richiestaIdGaraCigManager = richiestaIdGaraCigManager;
  }
  
  /**
   * @param exportXmlSimogManager the esportXmlSimogManager to set.
   */
  public void setEsportazioneXMLSIMOGManager(
      EsportazioneXMLSIMOGManager exportXmlSimogManager) {
    this.exportXmlSimogManager = exportXmlSimogManager;
  }
  
  public ActionForward inizializza(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
          throws IOException, ServletException {
    
    if (logger.isDebugEnabled()) {
      logger.debug("inizializza: inizio metodo");
    }
   
    String target = CostantiGeneraliStruts.FORWARD_OK + "Inizializza";
    
    boolean isUserTecnicoDellaSA = ((Boolean) request.getSession().getAttribute(
        CostantiW9.IS_USER_TECNICO_SA)).booleanValue();
    boolean isUserConCfNoTecnico = ((Boolean) request.getSession().getAttribute(
        CostantiW9.IS_USER_CONCF_NO_TECNICO_SA)).booleanValue();
    
    if (!isUserTecnicoDellaSA && !isUserConCfNoTecnico) {
      // L'utente loggato non puo' eseguire l'operazione, perche' non e' ne' RUP della SA 
      // attualmente in uso, ne' e' un utente con il codice fiscale valorizzato
      this.aggiungiMessaggio(request, "errors.consultaGara.userNoTecnicoSANoCf");
      request.setAttribute("bloccaOperazione", "true");
    }
    
    // Qualora esista in sessione l'attributo per la gestione dell'importazione
    // di gare con piu' lotti, lo si va rimuovere
    request.getSession().removeAttribute("sessionConsultaGaraLottiBean");
    
    if (logger.isDebugEnabled()) {
      logger.debug("inizializza: fine metodo");
    }
    
    return mapping.findForward(target);
  }
  
  public ActionForward verificaDati(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
          throws IOException, ServletException {
    if (logger.isDebugEnabled()) {
      logger.debug("verificaDati: inizio metodo");
    }

    String target = CostantiGeneraliStruts.FORWARD_OK + "VerificaDati";
    String codiceCIG = null;
    String idAvGara = null;
    String existCredenziali = null;
    String memorizza = null;
    String simoguser = null;
    String simogpass = null;
    String recuperauser = null;
    String recuperapassword = null;
    
    if (request.getParameter("codiceCIG") != null) {
    	codiceCIG = request.getParameter("codiceCIG");
    }
    if (request.getParameter("codiceGara") != null) {
    	idAvGara = request.getParameter("codiceGara");
    }
    
    if (request.getParameter("existCredenziali") != null) {
      existCredenziali = request.getParameter("existCredenziali");
      if ("no".equals(existCredenziali)) {
        memorizza = request.getParameter("memorizza");
        simoguser = request.getParameter("simoguser");
        simogpass = request.getParameter("simogpass");
        recuperauser = request.getParameter("recuperauser");
        recuperapassword = request.getParameter("recuperapassword");
      }
    }
    
    int syscon = ((ProfiloUtente) request.getSession().getAttribute(
        CostantiGenerali.PROFILO_UTENTE_SESSIONE)).getId();
    String codUffInt = (String) request.getSession().getAttribute(
        CostantiGenerali.UFFICIO_INTESTATARIO_ATTIVO);

    boolean isUserTecnicoDellaSA = ((Boolean) request.getSession().getAttribute(
        CostantiW9.IS_USER_TECNICO_SA)).booleanValue();
    boolean isUserConCfNoTecnico = ((Boolean) request.getSession().getAttribute(
        CostantiW9.IS_USER_CONCF_NO_TECNICO_SA)).booleanValue();
    
    if (isUserTecnicoDellaSA || isUserConCfNoTecnico) {
      try {
        if (!codiceCIG.equals("*")) {
          if (UtilitySITAT.isCigValido(codiceCIG)) {
            if(this.richiestaIdGaraCigManager.getEsistenzaCodiceCIG(new String[] { codiceCIG })) {
              this.aggiungiMessaggio(request, "errors.consultaGara.codiceCigEsistente");
              target = "erroreNoCIG";
            } else {
              request.setAttribute("richiestaConfermaCreaNuovaGara", "2");
              request.setAttribute("newMetodo", "aggiornaSchedaGara");

              request.setAttribute("valoreCodiceCIG", codiceCIG);
              request.setAttribute("valoreCodiceGara", idAvGara);
              request.setAttribute("valoreMemorizza", memorizza);
              request.setAttribute("valoreSimogUser", simoguser);
              request.setAttribute("valoreSimogPass", simogpass);
              request.setAttribute("valoreRecuperaUser", recuperauser);
              request.setAttribute("valoreRecuperaPassword", recuperapassword);
            }
          } else {
            this.aggiungiMessaggio(request, "errors.consultaGara.codiceCigNonValido");
            target = "erroreNoCIG";
          }
        } else {
          if (UtilitySITAT.isIdGaraValido(idAvGara)) {
            if (!this.richiestaIdGaraCigManager.isGaraEsistente(idAvGara)) {
      				request.setAttribute("richiestaConfermaCreaNuovaGara", "2");
      				request.setAttribute("newMetodo", "aggiornaSchedaGara");
        
      				request.setAttribute("valoreCodiceCIG", codiceCIG);
      				request.setAttribute("valoreCodiceGara", idAvGara);
      				request.setAttribute("valoreMemorizza", memorizza);
      				request.setAttribute("valoreSimogUser", simoguser);
      				request.setAttribute("valoreSimogPass", simogpass);
      				request.setAttribute("valoreRecuperaUser", recuperauser);
      				request.setAttribute("valoreRecuperaPassword", recuperapassword);
            } else {
      				// Nel caso la gara esista bisogna controllare che l'utente che esegue l'operazione
      				// consultaGara appartenga allo stesso RUP a cui appartiene la gara, cioe' che il
      				// TECNI.CODTEC associato all'utente che esegue l'operazione dalla S.A. scelta alla login
      				// sia uguale al valore della del campo W9GARA.RUP della gara selezionata
      				if (this.richiestaIdGaraCigManager.isUserRupDellaGara(idAvGara, codUffInt, syscon)) {
      				  request.setAttribute("richiestaConfermaCreaNuovaGara", "2");
      				  request.setAttribute("newMetodo", "aggiornaSchedaGara");
      	  
      				  request.setAttribute("valoreCodiceCIG", codiceCIG);
      				  request.setAttribute("valoreCodiceGara", idAvGara);
      				  request.setAttribute("valoreMemorizza", memorizza);
      				  request.setAttribute("valoreSimogUser", simoguser);
      				  request.setAttribute("valoreSimogPass", simogpass);
      				  request.setAttribute("valoreRecuperaUser", recuperauser);
      				  request.setAttribute("valoreRecuperaPassword", recuperapassword);
      				  
      				  Long lottiPresentiNellaGara = this.richiestaIdGaraCigManager.countLottifromIdGara(idAvGara);
      				  if (lottiPresentiNellaGara > 0) {
      					  // devo avvertire l'utente che ci sono gia' dei lotti caricati nella gara
      					  request.setAttribute("valoreNumeroLottiCaricati", lottiPresentiNellaGara.toString());
      					  target = "chiediInterventoUtente";
      				  }
      				  
      				} else {
      				  this.aggiungiMessaggio(request, "errors.consultaGara.codiceRup");
      				  target = "erroreRup";
      				}
            }
          } else {
            this.aggiungiMessaggio(request, "errors.consultaGara.idGaraNonValido");
            target = "erroreNoCIG";
          }  
        }
      } catch (SQLException e) {
        target = CostantiGeneraliStruts.FORWARD_ERRORE_GENERALE;
        logger.error("Errore nei controlli preliminari all'operazione di caricamento dei dati di un lotto da SIMOG.");
      }
    } else {
      this.aggiungiMessaggio(request, "errors.consultaGara.userNoTecnicoSANoCf");
      target = "erroreRup";
    }
    
    if (logger.isDebugEnabled()) {
      logger.debug("verificaDati: fine metodo");
    }

    return mapping.findForward(target);
  }

  public ActionForward aggiornaSchedaGara(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
          throws IOException, ServletException, GestoreException {
    
    if (logger.isDebugEnabled()) {
      logger.debug("aggiornaSchedaGara: inizio metodo");
    }

    String target = CostantiGeneraliStruts.FORWARD_OK + "AggiornaGara";
    String messageKey = null;
    String codiceCIG = null;
    String idAvGara = null;
    String existCredenziali = null;
    HashMap<String, Object> result = null;

    int syscon = ((ProfiloUtente) request.getSession().getAttribute(
        CostantiGenerali.PROFILO_UTENTE_SESSIONE)).getId();
    String codUffInt = (String) request.getSession().getAttribute(
        CostantiGenerali.UFFICIO_INTESTATARIO_ATTIVO);
    
    try {
    
      if (request.getSession(). getAttribute("sessionConsultaGaraLottiBean") == null) {
      
        if (request.getParameter("codiceCIG") != null) {
          codiceCIG = request.getParameter("codiceCIG");
        }
        
        if (request.getParameter("codiceGara") != null) {
          idAvGara = request.getParameter("codiceGara");
        }
        
        if (request.getParameter("existCredenziali") != null) {
        	existCredenziali = request.getParameter("existCredenziali");
        }
        
      	String simoguser = null;
        String simogpass = null;
          
        if (existCredenziali != null && existCredenziali.equals("no")) {
          String recuperaUser = request.getParameter("recuperauser");
          String recuperaPassword = request.getParameter("recuperapassword");
          String memorizza = request.getParameter("memorizza");
  
          // Leggo le eventuali credenziali memorizzate
  
          HashMap<String, String> hMapSIMOGLAUserPass = new HashMap<String, String>();
          hMapSIMOGLAUserPass = this.exportXmlSimogManager.recuperaSIMOGLAUserPass(new Long(syscon));
  
          // Gestione USER
          if ("1".equals(recuperaUser)) {
            simoguser = ((String) hMapSIMOGLAUserPass.get("simoguser"));
          } else {
            simoguser = request.getParameter("simoguser");
          }
  
          // Gestione PASSWORD
          if ("1".equals(recuperaPassword)) {
            simogpass = ((String) hMapSIMOGLAUserPass.get("simogpass"));
          } else {
            simogpass = request.getParameter("simogpass");
          }
          // Gestione memorizzazione delle credenziali o eventuale cancellazione (se richiesta)
          this.exportXmlSimogManager.gestioneWsSimogLoaderAppaltoUserPass(new Long(syscon),
              simoguser, simogpass, memorizza != null);
        }
  
        if ("*".equals(codiceCIG)) {
          ConsultaGaraLottiBean consultaGaraLottiBean = new ConsultaGaraLottiBean(codiceCIG, idAvGara, simoguser, simogpass);
          request.getSession().setAttribute("sessionConsultaGaraLottiBean", consultaGaraLottiBean);
          
          result = this.richiestaIdGaraCigManager.consultaGara(idAvGara, codUffInt,
              syscon, consultaGaraLottiBean, simoguser, simogpass);
        } else {
          result = this.richiestaIdGaraCigManager.consultaLotto(codiceCIG, idAvGara, codUffInt,
            syscon, simoguser, simogpass);
        }
        
        if (result != null) {
          Boolean esito = (Boolean) result.get("esito");
          if (esito.booleanValue()) {
            
            // Oggetto di ritorno dalla chiamata richiestaIdGaraCigManager.consultaLotto nel caso
            // che idAvGara e cig arrivino valorizzati dal form, per caricare una gara con un
            // singolo lotto (cioe' cig != *)
            ConsultaLottoBean consultaLottoBean = null;
            
            // Oggetto di ritorno dalla chiamata richiestaIdGaraCigManager.consultaGara nel caso
            // che idAvGara e cig arrivino valorizzati dal form, per caricare una gara con un
            // piu' lotti (cioe' cig = *)
            ConsultaGaraLottiBean consultaGaraLottiBean = null;
            
            if (result.containsKey("consultaLottoBean")) {
              consultaLottoBean = (ConsultaLottoBean) result.get("consultaLottoBean");
            }
            
            if (request.getSession().getAttribute("sessionConsultaGaraLottiBean") != null) {
              consultaGaraLottiBean = (ConsultaGaraLottiBean) 
                  request.getSession().getAttribute("sessionConsultaGaraLottiBean");
            }
            
            if (consultaLottoBean != null) {
              if (consultaGaraLottiBean != null) {
                if (consultaLottoBean.isCaricato()) {
                  consultaGaraLottiBean.incrementaNumeroLottiImportati();
                  if (logger.isDebugEnabled()) {
                    logger.debug("Importazione del lotto terminato con esito positivo (IdAvGara='"
                      + idAvGara + "', CIG='" + codiceCIG + "' da parte dell'utente con SYSCON=" + syscon
                      + " per conto della SA con CODUFFINT=" + codUffInt + ")");
                  }
                } else if (consultaLottoBean.isEsistente()) {
                  consultaGaraLottiBean.incrementaNumeroLottiEsistenti();
                  if (logger.isDebugEnabled()) {
                    logger.debug("Importazione del lotto non eseguito perche' esistente in base dati (IdAvGara='"
                      + idAvGara + "', CIG='" + codiceCIG + "' da parte dell'utente con SYSCON=" + syscon
                      + " per conto della SA con CODUFFINT=" + codUffInt + ")");
                  }
                } else {
                  consultaGaraLottiBean.incrementaNumeroLottiNonImportati();
                  if (logger.isDebugEnabled()) {
                    logger.debug("Importazione del lotto terminato con esito negativo. Dettaglio errore: "
                      + consultaLottoBean.getMsg() + " (IdAvGara='" + idAvGara + "', CIG='" + codiceCIG
                      + "' da parte dell'utente con SYSCON=" + syscon + 
                      " per conto della SA con CODUFFINT=" + codUffInt + ")");
                  }
                }
                target = CostantiGeneraliStruts.FORWARD_OK + "AggiornaLotto";
              } else {
                if (consultaLottoBean.isCaricato()) {
                  if (logger.isDebugEnabled()) {
                    logger.debug("Importazione del lotto terminato con esito positivo (IdAvGara='"
                      + idAvGara + "', CIG='" + codiceCIG + "' da parte dell'utente con SYSCON=" + syscon
                      + " per conto della SA con CODUFFINT=" + codUffInt + ")");
                  }
                } else if (consultaLottoBean.isEsistente()) {
                  if (logger.isDebugEnabled()) {
                    logger.debug("Importazione del lotto non eseguito perche' esistente in base dati (IdAvGara='"
                      + idAvGara + "', CIG='" + codiceCIG + "' da parte dell'utente con SYSCON=" + syscon
                      + " per conto della SA con CODUFFINT=" + codUffInt + ")");
                  }
                } else {
                  if (logger.isDebugEnabled()) {
                    logger.debug("Importazione del lotto terminato con esito negativo. Dettaglio errore: "
                      + consultaLottoBean.getMsg() + " (IdAvGara='" + idAvGara + "', CIG='" + codiceCIG
                      + "' da parte dell'utente con SYSCON=" + syscon + 
                      " per conto della SA con CODUFFINT=" + codUffInt + ")");
                  }
                }
                target = CostantiGeneraliStruts.FORWARD_OK + "AggiornaGara";
              }

            } else {
              if (logger.isDebugEnabled()) {
                logger.debug("Importazione della lista CIG della gara (IdAvGara='" + idAvGara + "', CIG='" + codiceCIG
                  + "' da parte dell'utente con SYSCON=" + syscon + " per conto della SA con CODUFFINT=" + codUffInt + ")");
              }
              // Avviare la procedura di importazione dei CIG
              target = CostantiGeneraliStruts.FORWARD_OK + "AggiornaLotto";
            }
            
          } else {
            target = "erroreAggiornaGara";
            if (logger.isDebugEnabled()) {
              logger.debug("Aggiornamento della gara e dei relativi lotti terminato con esito negativo (CODGARA='"
                + idAvGara + "', CIG='" + codiceCIG + "' da parte dell'utente con SYSCON=" + syscon
                + " per conto della SA con CODUFFINT=" + codUffInt + ")");
            }
            this.aggiungiMessaggio(request, "errors.consultaGara.erroreWS", ((String) result.get("errorMsg")));
            if (result.containsKey("errorMsg")) {
              request.setAttribute("errorMsgDettaglio", result.get("errorMsg"));
            }
          }
        } else {
          target = CostantiGeneraliStruts.FORWARD_ERRORE_GENERALE;
          logger.error("Errore inaspettato: il metodo w9Manager.consultaGara ha restituito un oggetto null, "
              + "mentre era atteso una HashMap con almeno un oggetto Boolean indicante l'esito positivo/negativo dell'operazione.");
        }
        
      } else {
        
        ConsultaGaraLottiBean consultaGaraLottiBean = (ConsultaGaraLottiBean) request.getSession().getAttribute("sessionConsultaGaraLottiBean");
        
        if (consultaGaraLottiBean.getListaCig() != null && consultaGaraLottiBean.getListaCig().size() > 0) {
          codiceCIG = consultaGaraLottiBean.getListaCig().pop();
          idAvGara= consultaGaraLottiBean.getIdAvGara();

          result = this.richiestaIdGaraCigManager.consultaLotto(codiceCIG, idAvGara, codUffInt,
              syscon, consultaGaraLottiBean.getSimogUser(), consultaGaraLottiBean.getSimogPassword());
          
          if (result != null) {
            Boolean esito = (Boolean) result.get("esito");
            if (esito.booleanValue()) {
              
              // Oggetto di ritorno dalla chiamata richiestaIdGaraCigManager.consultaLotto nel caso
              // che idAvGara e cig arrivino valorizzati dal form, per caricare una gara con un
              // singolo lotto (cioe' cig != *)
              ConsultaLottoBean consultaLottoBean = null;
              
              if (result.containsKey("consultaLottoBean")) {
                consultaLottoBean = (ConsultaLottoBean) result.get("consultaLottoBean");
              }
              
              if (consultaLottoBean.isCaricato()) {
                consultaGaraLottiBean.incrementaNumeroLottiImportati();
                if (logger.isDebugEnabled()) {
                  logger.debug("Importazione del lotto terminato con esito positivo (IdAvGara='"
                    + idAvGara + "', CIG='" + codiceCIG + "' da parte dell'utente con SYSCON=" + syscon
                    + " per conto della SA con CODUFFINT=" + codUffInt + ")");
                }
              } else if (consultaLottoBean.isEsistente()) {
                consultaGaraLottiBean.incrementaNumeroLottiEsistenti();
                if (logger.isDebugEnabled()) {
                  logger.debug("Importazione del lotto non eseguito perche' esistente in base dati (IdAvGara='"
                    + idAvGara + "', CIG='" + codiceCIG + "' da parte dell'utente con SYSCON=" + syscon
                    + " per conto della SA con CODUFFINT=" + codUffInt + ")");
                }
              } else {
                consultaGaraLottiBean.incrementaNumeroLottiNonImportati();
                if (logger.isDebugEnabled()) {
                  logger.debug("Importazione del lotto terminato con esito negativo. Dettaglio errore: "
                    + consultaLottoBean.getMsg() + " (IdAvGara='" + idAvGara + "', CIG='" + codiceCIG
                    + "' da parte dell'utente con SYSCON=" + syscon + 
                    " per conto della SA con CODUFFINT=" + codUffInt + ")");
                }
              }
              // Continuare la procedura di importazione dei CIG
              target = CostantiGeneraliStruts.FORWARD_OK + "AggiornaLotto";
            } else {
              target = "erroreAggiornaGara";
              logger.info("Aggiornamento della gara e dei relativi lotti terminato con esito negativo (CODGARA='"
                  + idAvGara + "', CIG='" + codiceCIG + "' da parte dell'utente con SYSCON=" + syscon
                  + " per conto della SA con CODUFFINT=" + codUffInt + ")");
              this.aggiungiMessaggio(request, "errors.consultaGara.erroreWS", ((String) result.get("errorMsg")));
              if (result.containsKey("errorMsg")) {
                request.setAttribute("errorMsgDettaglio", result.get("errorMsg"));
              }
            }
          } else {
            target = CostantiGeneraliStruts.FORWARD_ERRORE_GENERALE;
            logger.error("Errore inaspettato: il metodo w9Manager.consultaGara ha restituito un oggetto null, "
                + "mentre era atteso una HashMap con almeno un oggetto Boolean indicante l'esito positivo/negativo dell'operazione.");
          }
          
        } else {
          // La lista dei CIG e' stata ciclato in tutti i suoi elementi, quindi e'
          // terminata l'operazione di importazione di tutti i lotti della gara
          target = CostantiGeneraliStruts.FORWARD_OK + "AggiornaGara";
          
        }
      }

    } catch (SQLException e) {
      target = CostantiGeneraliStruts.FORWARD_ERRORE_GENERALE;
      messageKey = "errors.database.dataAccessException";
      logger.error(this.resBundleGenerale.getString(messageKey), e);
      this.aggiungiMessaggio(request, messageKey);
    } catch (Throwable t) {
      target = CostantiGeneraliStruts.FORWARD_ERRORE_GENERALE;
      messageKey = "errors.applicazione.inaspettataException";
      logger.error(this.resBundleGenerale.getString(messageKey), t);
      this.aggiungiMessaggio(request, messageKey);
    }
    
    if (logger.isDebugEnabled()) {
      logger.debug("aggiornaSchedaGara: fine metodo");
    }
    return mapping.findForward(target);
  }

  public ActionForward riallineaDatiSIMOG(ActionMapping mapping, ActionForm form,
      HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    
    if (logger.isDebugEnabled()) {
      logger.debug("riallineaDatiSIMOG: inizio metodo");
    }

    String target = CostantiGeneraliStruts.FORWARD_OK + "RiallineaSIMOG";
    String messageKey = null;
    String codiceCIG = null;
    String codiceGara = null;
    String existCredenziali = null;
    
    if (request.getParameter("codiceCIG") != null) {
      codiceCIG = (String) request.getParameter("codiceCIG");
    }
    if (request.getParameter("codiceGara") != null) {
      codiceGara = (String) request.getParameter("codiceGara");
    }
    if (request.getParameter("existCredenziali") != null) {
    	existCredenziali = request.getParameter("existCredenziali");
    }
    
    long codGara = Long.parseLong(codiceGara);
    
    int syscon = ((ProfiloUtente) request.getSession().getAttribute(
        CostantiGenerali.PROFILO_UTENTE_SESSIONE)).getId();
    String codUffInt = (String) request.getSession().getAttribute(
        CostantiGenerali.UFFICIO_INTESTATARIO_ATTIVO);

    HashMap<String, Object> result = null;
    
    Boolean isUserTecnicoDellaSA = ((Boolean) request.getSession().getAttribute(
        CostantiW9.IS_USER_TECNICO_SA));
    Boolean isUserConCfNoTecnico = ((Boolean) request.getSession().getAttribute(
        CostantiW9.IS_USER_CONCF_NO_TECNICO_SA));
    
    try {
      if (isUserTecnicoDellaSA || isUserConCfNoTecnico) {
        String simoguser = null;
        String simogpass = null;
          
        if (existCredenziali != null && existCredenziali.equals("no")) {
        	String recuperaUser = request.getParameter("recuperauser");
          String recuperaPassword = request.getParameter("recuperapassword");
          String memorizza = request.getParameter("memorizza");
  
          // Leggo le eventuali credenziali memorizzate
          HashMap<String, String> hMapSIMOGLAUserPass = new HashMap<String, String>();
          hMapSIMOGLAUserPass = this.exportXmlSimogManager.recuperaSIMOGLAUserPass(new Long(syscon));
          
          // Gestione USER
          if (recuperaUser != null && "1".equals(recuperaUser)) {
        	  simoguser = ((String) hMapSIMOGLAUserPass.get("simoguser"));
          } else {
        	  simoguser = request.getParameter("simoguser");
          }
  
          // Gestione PASSWORD
          if (recuperaPassword != null && "1".equals(recuperaPassword)) {
        	  simogpass = ((String) hMapSIMOGLAUserPass.get("simogpass"));
          } else {
        	  simogpass = request.getParameter("simogpass");
          }
          // Gestione memorizzazione delle credenziali o eventuale cancellazione (se richiesta)
          this.exportXmlSimogManager.gestioneWsSimogLoaderAppaltoUserPass(new Long(syscon), 
              simoguser, simogpass, memorizza != null);
        }

        result = this.richiestaIdGaraCigManager.riallineaDatiSimog(codiceCIG, codGara, codUffInt,
            syscon, simoguser, simogpass);
  
        if (result != null) {
          Boolean esito = (Boolean) result.get("esito");
          if (esito.booleanValue()) {
            logger.info("Allineamento della gara e del relativo lotto terminato con esito positivo (CODGARA='"
                + codiceGara + "', CIG='" + codiceCIG + "' da parte dell'utente con SYSCON=" + syscon
                + " per conto della SA con CODUFFINT=" + codUffInt + ")");
            request.setAttribute("RISULTATO", "OK");
          } else {
            target = "erroreRiallineaSIMOG";
            logger.info("Allineamento della gara e del relativo lotto terminato con esito negativo (CODGARA='"
                + codiceGara + "', CIG='" + codiceCIG + "' da parte dell'utente con SYSCON=" + syscon
                + " per conto della SA con CODUFFINT=" + codUffInt + ")");
            this.aggiungiMessaggio(request, "errors.consultaGara.erroreWS", ((String) result.get("errorMsg")));
            request.setAttribute("RISULTATO", "KO");
          }
        } else {
          target = CostantiGeneraliStruts.FORWARD_ERRORE_GENERALE;
          logger.error("Errore inaspettato: il metodo w9Manager.riallineaDatiSimog ha restituito un oggetto null, "
              + "mentre era atteso una HashMap con almeno un oggetto Boolean indicante l'esito positivo/negativo dell'operazione.");
        }
      }  else {
        request.setAttribute("richiestaConfermaCreaNuovaGara", "2");
        request.setAttribute("metodo", "riallineaDatiSIMOG");

        logger.error("Operazione lanciata da un utente che non e' ne' tecnico della S.A. attiva, ne' un " +
        		"utente con codice fiscale valorizzato. (Dettagli: "
                + codiceGara + "', CIG='" + codiceCIG + "' da parte dell'utente con SYSCON=" + syscon
                + " per conto della SA con CODUFFINT=" + codUffInt + ")");
        request.setAttribute("RISULTATO", "KO");
        this.aggiungiMessaggio(request, "errors.consultaGara.userNoTecnicoSANoCf");
        target = "erroreRiallineaSIMOG";
      }
      
    } catch (SQLException e) {
      target = CostantiGeneraliStruts.FORWARD_ERRORE_GENERALE;
      messageKey = "errors.database.dataAccessException";
      logger.error(this.resBundleGenerale.getString(messageKey), e);
      this.aggiungiMessaggio(request, messageKey);
    } catch (Throwable t) {
      target = CostantiGeneraliStruts.FORWARD_ERRORE_GENERALE;
      messageKey = "errors.applicazione.inaspettataException";
      logger.error(this.resBundleGenerale.getString(messageKey), t);
      this.aggiungiMessaggio(request, messageKey);
    }

    if (logger.isDebugEnabled()) {
      logger.debug("riallineaDatiSIMOG: fine metodo");
    }
    return mapping.findForward(target);
  }
  
}