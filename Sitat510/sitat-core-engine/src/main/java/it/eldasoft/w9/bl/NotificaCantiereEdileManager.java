/*
 * Created on 07/nov/12
 *
 * Copyright (c) EldaSoft S.p.A.
 * Tutti i diritti sono riservati.
 *
 * Questo codice sorgente e' materiale confidenziale di proprieta' di EldaSoft S.p.A.
 * In quanto tale non puo' essere distribuito liberamente ne' utilizzato a meno di 
 * aver prima formalizzato un accordo specifico con EldaSoft.
 */

package it.eldasoft.w9.bl;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.rpc.ServiceException;

import it.eldasoft.gene.bl.SqlManager;
import it.eldasoft.gene.db.sql.sqlparser.JdbcParametro;
import it.eldasoft.gene.db.datautils.DataColumnContainer;
import it.eldasoft.gene.web.struts.tags.gestori.GestoreException;
import it.eldasoft.utils.properties.ConfigManager;
import it.eldasoft.w9.common.CostantiSitatORT;
import it.toscana.regione.sisrt.notifiche.CommittenteType;
import it.toscana.regione.sisrt.notifiche.DatiAnagraficiType;
import it.toscana.regione.sisrt.notifiche.DatiCantiereType;
import it.toscana.regione.sisrt.notifiche.DatiNotificaType;
import it.toscana.regione.sisrt.notifiche.DatiOperaType;
import it.toscana.regione.sisrt.notifiche.ElencoImpreseType;
import it.toscana.regione.sisrt.notifiche.GestioneFlussoInvioSitatType;
import it.toscana.regione.sisrt.notifiche.GestioneFlussoRispostaSISPCType;
import it.toscana.regione.sisrt.notifiche.AccettazioneNotificaPreliminareDocument;
import it.toscana.regione.sisrt.notifiche.IDFiscaledittaType;
import it.toscana.regione.sisrt.notifiche.InvioNuovaNotificaSitatType;
import it.toscana.regione.sisrt.notifiche.ModificaNotificaPreliminareDocument;
import it.toscana.regione.sisrt.notifiche.ModificaNotificaSITATType;
import it.toscana.regione.sisrt.notifiche.NomeType;
import it.toscana.regione.sisrt.notifiche.NuovaNotificaPreliminareDocument;
import it.toscana.regione.sisrt.notifiche.RiferimentiType;
import it.toscana.regione.sisrt.notifiche.SceltaType;

import org.apache.axis.message.SOAPBody;
import org.apache.axis.message.SOAPEnvelope;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openspcoop.pdd.services.SPCoopException;
import org.openspcoop.pdd.services.SPCoopMessage;

/**
 * Classe di utilita' per l'invio e la ricezione di eventi al e dal CART di regione toscana
 * 
 * @author Mirco.Franzoni
 * 
 */
public class NotificaCantiereEdileManager {

  static Logger               logger               = Logger.getLogger(NotificaCantiereEdileManager.class);

  private SqlManager          sqlManager;

  private enum TipoNotifica {Ev001NuovaNotificaPreliminare, Ev002ModificaNotificaPreliminare};
  
  private String selectW9CANT = "select * from w9cant where daexport = '1'";
  private String selectW9LOTT = "select * from w9lott where codgara = ? and codlott = ?";
  private String selectW9FLUSSI = "select * from w9flussi where key01 = ? and key02 = ? and key03 = 998 and key04 = ? and tinvio2 = 1";
  private String selectW9CANTDEST = "select * from w9cantdest where codgara = ? and codlott = ? and num_cant = ?";
  private String selectTECNIResponsabile = "select * from tecni where codtec = ?";
  private String selectTECNICoordinatore = "select * from tecni left join w9inca on tecni.codtec = w9inca.codtec where w9inca.codgara = ? and w9inca.codlott = ? and w9inca.sezione='NP' and w9inca.id_ruolo = ?";
  private String selectW9CANTIMP = "select i.nomest, i.cfimp, i.indimp, i.codcit, i.telimp, i.emaiip, w.cipdurc, w.protdurc, w.datdurc from impr i left join  w9cantimp w on i.codimp = w.codimp where w.codgara = ? and w.codlott = ? and w.num_cant = ?";
  private String selectImportoLavori = "select importo_lavori from w9appa where codgara = ? and codlott = ?";
  private String selectW9FINA = "select id_finanziamento from w9fina where codgara = ? and codlott = ?";
  private String updateW9CANT = "update w9cant set daexport = '2' where codgara = ? and codlott = ? and num_cant = ?";
  private String updateW9CANT_ID_SISPC = "update w9cant set idsispc = ?, idcant = ? where codgara = ? and codlott = ? and num_cant = ?";

  /**
   * 
   * @return
   */
  public SqlManager getSqlManager() {
    return this.sqlManager;
  }

  /**
   * 
   * @param sqlManager
   */
  public void setSqlManager(SqlManager sqlManager) {
    this.sqlManager = sqlManager;
  }

  /**
   * Invia al CART le nuove notifiche preliminari
   * 
   * @throws GestoreException
   */
  public void InvioNotifichePreliminari() throws GestoreException {

    if (logger.isDebugEnabled()) {
    	logger.debug("InvioNuoveNotifichePreliminari: inizio metodo");
    }
    	
    if (logger.isInfoEnabled()) {
    	logger.info("Avvio della procedura per l'invio delle nuove notifiche preliminari al CART");
    }
    TipoNotifica tipoNotifica;
	String azione = "";
	String messaggio = "";
    String idSitat = "";

    try {
    	//Lrggo prima le notifiche di accettazione
    	LetturaAccettazioneNotifichePreliminari();
    	//Configurazione CART Regione Toscana
    	String url = ConfigManager.getValore(CostantiSitatORT.RFC210_URL);
        String username = ConfigManager.getValore(CostantiSitatORT.RFC210_USER);
        String password = ConfigManager.getValore(CostantiSitatORT.RFC210_PASS);
        String portaDelegata = ConfigManager.getValore(CostantiSitatORT.RFC210_PORTA_DELEGATA);
        String servizio = ConfigManager.getValore(CostantiSitatORT.RFC210_SERVIZIO);
        String tipoServizio = ConfigManager.getValore(CostantiSitatORT.RFC210_TIPO_SERVIZIO);
        
        IntegrationManagerUtility integrationManagerUtility = new IntegrationManagerUtility(url, username, password);
        
    	integrationManagerUtility.setPortaDelegata(portaDelegata);
    	integrationManagerUtility.setServizio(servizio);
    	integrationManagerUtility.setTipoServizio(tipoServizio);
    	//verifica eventuali nuove notifiche da inviare
    	List< ? > nuoveNotifiche = this.sqlManager.getListHashMap(selectW9CANT, new Object[] {});
		if (nuoveNotifiche != null && nuoveNotifiche.size() > 0) {
			for (int i = 0; i < nuoveNotifiche.size(); i++) {
				try {
					DataColumnContainer cantiere = new DataColumnContainer(this.sqlManager, "W9CANT", selectW9CANT, new Object[] {});
					cantiere.setValoriFromMap((HashMap< ?, ? >) nuoveNotifiche.get(i), true);
					
					tipoNotifica = (cantiere.getLong("IDSISPC") == null)?TipoNotifica.Ev001NuovaNotificaPreliminare:TipoNotifica.Ev002ModificaNotificaPreliminare;
					
					switch (tipoNotifica) {
					case Ev001NuovaNotificaPreliminare:
						azione = "Ev001NuovaNotificaPreliminare";
						messaggio = this.getMessaggioNuovaNotificaPreliminare(cantiere);
						break;
						
					case Ev002ModificaNotificaPreliminare:
						azione = "Ev002ModificaNotificaPreliminare";
						messaggio = this.getMessaggioModificaNotificaPreliminare(cantiere);
						break;
						
					}
		        	
					if (!messaggio.equals("")) {
						try {
							SPCoopMessage msg = integrationManagerUtility.sendCartMessage(messaggio, azione);
							//aggiorno il flag nella w9cant
							this.sqlManager.update(updateW9CANT, new Object[] {cantiere.getLong("CODGARA"), cantiere.getLong("CODLOTT"), cantiere.getLong("NUM_CANT")});
							if (logger.isInfoEnabled()) {
						    	logger.info("Nuova notifica preliminare inviata con successo id_gov = " + msg.getSpcoopHeaderInfo().getID());
						    }
						} catch (Exception ex) {
							logger.error("Errore durante l'invio del messaggio di nuova notifica preliminare Ev001 - NuovaNotificaPreliminare con idSistat = " + idSitat, ex);
						}
					}
					
				} catch (Exception ex) {
					logger.error("Errore durante la creazione del messaggio di nuova notifica preliminare Ev001 - NuovaNotificaPreliminare con idSistat = " + idSitat, ex);
				}
			}
		} else {
			if (logger.isInfoEnabled()) {
		    	logger.info("Nessuna nuova notifica preliminare da inviare al CART");
		    }
		}
    } catch (Exception e) {
    	logger.error(e);
    }

    if (logger.isDebugEnabled()) {
    	logger.debug("InvioNotifichePreliminari: fine metodo");
    }
  }

  /**
   * Legge dal CART le accettazioni delle notifiche preliminari
   * 
   * @throws GestoreException
   */
  public void LetturaAccettazioneNotifichePreliminari() throws GestoreException {

    if (logger.isDebugEnabled()) {
    	logger.debug("LetturaAccettazioneNotifichePreliminari: inizio metodo");
    }
    	
    if (logger.isInfoEnabled()) {
    	logger.info("Avvio della procedura per la lettura delle accettazioni notifiche preliminari dal CART");
    }
    Long codgara, codlott, num_cant;
    int idSitatLength;
	String azione = "Ev003accettazioneNotificaPreliminare";

    boolean messaggiLetti = false;
    
    
    try {
    	//Configurazione CART Regione Toscana
    	String url = ConfigManager.getValore(CostantiSitatORT.RFC210_URL);
        String username = ConfigManager.getValore(CostantiSitatORT.RFC210_USER_EROGATORE);
        String password = ConfigManager.getValore(CostantiSitatORT.RFC210_PASS_EROGATORE);
        String servizio = ConfigManager.getValore(CostantiSitatORT.RFC210_SERVIZIO);
        String tipoServizio = ConfigManager.getValore(CostantiSitatORT.RFC210_TIPO_SERVIZIO);
        
        IntegrationManagerUtility integrationManagerUtility = new IntegrationManagerUtility(url, username, password);
        
    	integrationManagerUtility.setServizio(servizio);
    	integrationManagerUtility.setTipoServizio(tipoServizio);
    	//verifica eventuali nuove notifiche da inviare
    	
    	// lettura messaggi
        Map<String, SPCoopMessage> messaggi = integrationManagerUtility.getCartMessages(tipoServizio, servizio, azione);
        messaggiLetti = true;
        Set<String> elencoIdEgov = messaggi.keySet();
        
        for (Iterator< ? > iterator = elencoIdEgov.iterator(); iterator.hasNext();) {
            String idEgov = (String) iterator.next();
            if (logger.isDebugEnabled()) {
              logger.debug("Lettura del messaggio con idEgov = " + idEgov);
            }
            GestioneFlussoRispostaSISPCType accettazione = this.getAccettazione(messaggi.get(idEgov));
            if (accettazione != null) {
            	//elaboro l'accettazione
				//faccio l'update della notifica solo se l'accettazione e' positiva
				if (accettazione.getEsitoAccettazione() == 0) {
					//aggiorno l'ID_SISPC
	            	idSitatLength = accettazione.getIDSitat().length();
	            	codgara = new Long(accettazione.getIDSitat().substring(0,idSitatLength - 6));
	            	codlott = new Long(accettazione.getIDSitat().substring(idSitatLength - 6, idSitatLength - 3));
	            	num_cant = new Long(accettazione.getIDSitat().substring(idSitatLength - 3));
	            	Long idSispc = new Long(accettazione.getIDSispc().longValue());
	            	Long idCant = new Long(accettazione.getCodiceIdentificazioneCantiere());
					this.sqlManager.update(updateW9CANT_ID_SISPC, new Object[] {idSispc, idCant, codgara, codlott, num_cant});
				} else {
					logger.info("Ev003accettazioneNotificaPreliminare - ID Sitat = " + accettazione.getIDSitat() + ", Note esito: " + accettazione.getNoteEsitoAccettazione());
				}
            	//al termine cancello messaggio dalla coda
            	integrationManagerUtility.deleteCartMessageById(idEgov);
            } else {
            	
            	//booo vedremo il da farsi
            	;
            }
        }
        
    } catch (SPCoopException e) {
        if ("CART_406".equalsIgnoreCase(e.getCodiceEccezione())) {
          logger.info(e.getDescrizioneEccezione());
        } else {
          String msg = null;
          // Eccezione legata a problemi relativi all'infrastruttura CART
          if (!messaggiLetti) {
            msg = "Errore durante la lettura della richiesta mediante Integration Manager: ";
          } else {
            msg = "Errore durante l'eliminazione di una richiesta mediante Integration Manager: ";
          }
          logger.error(msg + e.getDescrizioneEccezione(), e);
        }
      } catch (RemoteException e) {
        logger.error("Errore nella chiamata all'Integration Manager", e);
      } catch (ServiceException e) {
        logger.error("Errore durante la connessione all'Integration Manager", e);
      }	catch (Exception e) {
    	logger.error(e);
      }

    if (logger.isDebugEnabled()) {
    	logger.debug("LetturaAccettazioneNotifichePreliminari: fine metodo");
    }
  }
  
  /**
   * Estrae l'elemento accettazione della notifica.
   * 
   * @param message
   * @return Ritorna l'elemento accettazione della notifica
   * 
   * @throws SPCoopException SPCoopException
   * @throws RemoteException RemoteException
   * @throws ServiceException ServiceException
   */
	public GestioneFlussoRispostaSISPCType getAccettazione(final SPCoopMessage message) throws SPCoopException,
			RemoteException, ServiceException {
		GestioneFlussoRispostaSISPCType accettazione = null;
		// estrazione dell'XML della busta di eGov
		byte[] soapMessage = message.getMessage();
		// estrazione dell'accettazione contenuta nel body della busta SOAP
		String xmlEvento = null;
		try {
			SOAPEnvelope envelope = new SOAPEnvelope(new ByteArrayInputStream(soapMessage));
			SOAPBody body = (SOAPBody) envelope.getBody();
			java.util.Iterator<?> it = body.getChildElements();
			if (it.hasNext()) {
				org.apache.axis.message.MessageElement bodyElement = (org.apache.axis.message.MessageElement) it.next();
				xmlEvento = bodyElement.getAsString();
				AccettazioneNotificaPreliminareDocument documento = AccettazioneNotificaPreliminareDocument.Factory.parse(xmlEvento);
			    accettazione = documento.getAccettazioneNotificaPreliminare();
			}
		} catch (XmlException e) {
		    logger.error("Errore inaspettato in fase di interpretazione del messaggio XML ricevuto", e);
		} catch (Exception e) {
			logger.error("La richiesta non corrisponde ad una busta SOAP", e);
		}
		return accettazione;
	}
  
  /**
   * 
   * @param cantiere
   * @return
   */
  private String getMessaggioNuovaNotificaPreliminare(DataColumnContainer cantiere) {
	  String messaggio = "";
	  String idSitat = "";
	  try {
		  	DataColumnContainer lotto, flusso, responsabile, coordinatore, coordEsecuzioneLavori;
		  	//recupero i dati del lotto
		  	try{
		  		lotto = new DataColumnContainer(this.sqlManager, "W9LOTT", selectW9LOTT, new Object[] {cantiere.getLong("CODGARA"), cantiere.getLong("CODLOTT")});
		  	} catch (Exception ex) {
		  		throw new Exception("Non esiste il LOTTO per la GARA = " + cantiere.getLong("CODGARA") + ", LOTTO = " + cantiere.getLong("CODLOTT"));
		  	}
			//recupero i dati del flusso
		  	try{
		  		flusso = new DataColumnContainer(this.sqlManager, "W9FLUSSI", selectW9FLUSSI, new Object[] {cantiere.getLong("CODGARA"), cantiere.getLong("CODLOTT"), cantiere.getLong("NUM_CANT")});
		  	} catch (Exception ex) {
		  		throw new Exception("Non esiste il FLUSSO per la GARA = " + cantiere.getLong("CODGARA") + ", LOTTO = " + cantiere.getLong("CODLOTT"));
		  	}
			//recupero i dati del responsabile
			try{
				responsabile = new DataColumnContainer(this.sqlManager, "TECNI", selectTECNIResponsabile, new Object[] {lotto.getString("RUP")});
			} catch (Exception ex) {
		  		throw new Exception("Non esiste il RESPONSABILE con CODICE RUP = " + lotto.getString("RUP"));
		  	}
			//recupero i dati del coordinatore
			try{
				coordinatore = new DataColumnContainer(this.sqlManager, "TECNI", selectTECNICoordinatore, new Object[] {cantiere.getLong("CODGARA"), cantiere.getLong("CODLOTT"), 6});
			} catch (Exception ex) {
		  		throw new Exception("Non esiste il COORDINATORE per la GARA = " + cantiere.getLong("CODGARA") + ", LOTTO = " + cantiere.getLong("CODLOTT"));
		  	}
			//recupero i dati del coordinatore esecutore lavori
			try{
				coordEsecuzioneLavori = new DataColumnContainer(this.sqlManager, "TECNI", selectTECNICoordinatore, new Object[] {cantiere.getLong("CODGARA"), cantiere.getLong("CODLOTT"), 7});
			} catch (Exception ex) {
		  		throw new Exception("Non esiste il COORDINATORE ESECUTORE LAVORI per la GARA = " + cantiere.getLong("CODGARA") + ", LOTTO = " + cantiere.getLong("CODLOTT"));
		  	}
			
		  	NuovaNotificaPreliminareDocument doc = NuovaNotificaPreliminareDocument.Factory.newInstance();
		  	doc.documentProperties().setEncoding("UTF-8");
		  	InvioNuovaNotificaSitatType notifica = doc.addNewNuovaNotificaPreliminare();
		  	//Chiave Invio Nuova Notifica
			GestioneFlussoInvioSitatType chiave = notifica.addNewChiaveInvioNuovaNotificaSitat();
			idSitat = "" + ((1000000 * cantiere.getLong("CODGARA")) + (1000 * cantiere.getLong("CODLOTT")) + cantiere.getLong("NUM_CANT"));
			chiave.setIDSitat(idSitat);
			chiave.setVersione(0);
			chiave.setIDSispc(new BigInteger("0"));
			
			notifica.setNumeroDiaConcessione("-");
			notifica.setCodiceidentificativogaraCIG(lotto.getString("CIG").substring(0,6));
			GregorianCalendar dataIn = null;
			if (flusso.getData("DATINV") != null) {
				dataIn = new GregorianCalendar();
				dataIn.setTime(flusso.getData("DATINV"));
				notifica.setDatainserimento(dataIn);
			}
			notifica.setDelegaCommittenteTecnico(SceltaType.NO);
			
			//Dati Notifica Sitat
			DatiNotificaType datiNotifica = notifica.addNewDatiNotificaSitat();
			if (flusso.getData("DATINV") != null) {
				datiNotifica.setDatainvio(dataIn);
			}
			this.getDestinatari(datiNotifica, cantiere);
			//Dati Cantiere
			DatiCantiereType datiCantiereSitat = notifica.addNewDatiCantireSitat();
			this.getDatiCantiere(datiCantiereSitat, cantiere);
			//Committente
			CommittenteType committente = notifica.addNewCommittente();
			this.getCommittente(committente, responsabile, cantiere.getString("MAILRIC"));
			//Dati Opera Sitat
			DatiOperaType datiOperaSitat = notifica.addNewDatiOperaSitat();
			this.getDatiOpera(datiOperaSitat, lotto, cantiere);
			//Responsabile Lavori
			DatiAnagraficiType responsabileLavori = notifica.addNewResponsabileLavori();
			this.getResponsabileLavori(responsabileLavori, responsabile);
			//Coordinatore Progettazione
			DatiAnagraficiType coordinatoreProgettazione = notifica.addNewCoordinatoreProgettazione();
			this.getCoordinatoreProgettazione(coordinatoreProgettazione, coordinatore);
			//Coordinatore Esecuzione LAvori
			DatiAnagraficiType coordinatoreesecuzioneLavori = notifica.addNewCoordinatoreesecuzioneLavori();
			this.getCoordinatoreesecuzioneLavori(coordinatoreesecuzioneLavori, coordEsecuzioneLavori);
			//Elenco Imprese
			List< ? > imprese = this.sqlManager.getListHashMap(selectW9CANTIMP, new Object[] {cantiere.getLong("CODGARA"), cantiere.getLong("CODLOTT"), cantiere.getLong("NUM_CANT")});
			if (imprese != null && imprese.size() > 0) {
				for (int j = 0; j < imprese.size(); j++) {
					DataColumnContainer impresa = new DataColumnContainer(this.sqlManager, "W9CANT", selectW9CANTIMP, new Object[] {cantiere.getLong("CODGARA"), cantiere.getLong("CODLOTT"), cantiere.getLong("NUM_CANT")});
					impresa.setValoriFromMap((HashMap< ?, ? >) imprese.get(j), true);
					ElencoImpreseType elencoImprese = notifica.addNewElencoimprese();
					this.getImpresa(elencoImprese, impresa);
				}
			}
			
			//procediamo alla validazione del document
			ArrayList<Object> validationErrors = new ArrayList<Object>();
		    XmlOptions validationOptions = new XmlOptions();
		    validationOptions.setErrorListener(validationErrors);
		      	
			if (!doc.validate(validationOptions)) {
				String listaErroriValidazione = "";
		      	Iterator< ? > iter = validationErrors.iterator();
		      	while (iter.hasNext()) {
		      		listaErroriValidazione += iter.next() + "\n";
		      	}
		      	logger.error("Nuova scheda cantiere non valida, IDISTAT = " + idSitat + " Errori : " + listaErroriValidazione);
			} else {
				messaggio = doc.toString();
			}
	  } catch (Exception ex) {
		  logger.error("Errore durante la creazione del messaggio di nuova notifica preliminare Ev001 - NuovaNotificaPreliminare con idSistat = " + idSitat, ex);
	  }
	  return messaggio;
  }
  
  /**
   * 
   * @param cantiere
   * @return
   */
  private String getMessaggioModificaNotificaPreliminare(DataColumnContainer cantiere) {
	  String messaggio = "";
	  String idSitat = "";
	  try {
		  	DataColumnContainer lotto, flusso, responsabile, coordinatore, coordEsecuzioneLavori;
		  	//recupero i dati del lotto
			try{
		  		lotto = new DataColumnContainer(this.sqlManager, "W9LOTT", selectW9LOTT, new Object[] {cantiere.getLong("CODGARA"), cantiere.getLong("CODLOTT")});
		  	} catch (Exception ex) {
		  		throw new Exception("Non esiste il LOTTO per la GARA = " + cantiere.getLong("CODGARA") + ", LOTTO = " + cantiere.getLong("CODLOTT"));
		  	}
			///recupero i dati del flusso
		  	try{
		  		flusso = new DataColumnContainer(this.sqlManager, "W9FLUSSI", selectW9FLUSSI, new Object[] {cantiere.getLong("CODGARA"), cantiere.getLong("CODLOTT"), cantiere.getLong("NUM_CANT")});
		  	} catch (Exception ex) {
		  		throw new Exception("Non esiste il FLUSSO per la GARA = " + cantiere.getLong("CODGARA") + ", LOTTO = " + cantiere.getLong("CODLOTT"));
		  	}
			//recupero i dati del responsabile
			try{
				responsabile = new DataColumnContainer(this.sqlManager, "TECNI", selectTECNIResponsabile, new Object[] {lotto.getString("RUP")});
			} catch (Exception ex) {
		  		throw new Exception("Non esiste il RESPONSABILE con CODICE RUP = " + lotto.getString("RUP"));
		  	}
			//recupero i dati del coordinatore
			try{
				coordinatore = new DataColumnContainer(this.sqlManager, "TECNI", selectTECNICoordinatore, new Object[] {cantiere.getLong("CODGARA"), cantiere.getLong("CODLOTT"), 6});
			} catch (Exception ex) {
		  		throw new Exception("Non esiste il COORDINATORE per la GARA = " + cantiere.getLong("CODGARA") + ", LOTTO = " + cantiere.getLong("CODLOTT"));
		  	}
			//recupero i dati del coordinatore esecutore lavori
			try{
				coordEsecuzioneLavori = new DataColumnContainer(this.sqlManager, "TECNI", selectTECNICoordinatore, new Object[] {cantiere.getLong("CODGARA"), cantiere.getLong("CODLOTT"), 7});
			} catch (Exception ex) {
		  		throw new Exception("Non esiste il COORDINATORE ESECUTORE LAVORI per la GARA = " + cantiere.getLong("CODGARA") + ", LOTTO = " + cantiere.getLong("CODLOTT"));
		  	}
			
			ModificaNotificaPreliminareDocument doc = ModificaNotificaPreliminareDocument.Factory.newInstance();
		  	doc.documentProperties().setEncoding("UTF-8");
		  	ModificaNotificaSITATType notifica = doc.addNewModificaNotificaPreliminare();
		  	//Chiave Invio Nuova Notifica
			GestioneFlussoInvioSitatType chiave = notifica.addNewGestioneFlussoModificaSITAT();
			idSitat = "" + ((1000000 * cantiere.getLong("CODGARA")) + (1000 * cantiere.getLong("CODLOTT")) + cantiere.getLong("NUM_CANT"));
			chiave.setIDSitat(idSitat);
			chiave.setVersione(Integer.parseInt(cantiere.getObject("VERSNOT").toString()));
			chiave.setIDSispc(new BigInteger(cantiere.getObject("IDSISPC").toString()));
			
			GregorianCalendar dataIn = null;
			notifica.setCodiceIdentificativogaraCIG(lotto.getString("CIG").substring(0,6));
			if (flusso.getData("DATINV") != null) {
				dataIn = new GregorianCalendar();
				dataIn.setTime(flusso.getData("DATINV"));
				notifica.setDataInserimento(dataIn);
			}
			notifica.setCodiceIdentificativoCantiere(cantiere.getLong("IDCANT").toString());
			//Dati Notifica Sitat
			DatiNotificaType datiNotifica = notifica.addNewDatiNotifica();
			if (flusso.getData("DATINV") != null) {
				datiNotifica.setDatainvio(dataIn);
			}
			this.getDestinatari(datiNotifica, cantiere);
			//Dati Cantiere
			DatiCantiereType datiCantiereSitat = notifica.addNewDatiCantiere();
			this.getDatiCantiere(datiCantiereSitat, cantiere);
			//Committente
			CommittenteType committente = notifica.addNewCommittente();
			this.getCommittente(committente, responsabile, cantiere.getString("MAILRIC"));
			//Dati Opera Sitat
			DatiOperaType datiOperaSitat = notifica.addNewDatiopera();
			this.getDatiOpera(datiOperaSitat, lotto, cantiere);
			//Responsabile Lavori
			DatiAnagraficiType responsabileLavori = notifica.addNewResponsabilelavori();
			this.getResponsabileLavori(responsabileLavori, responsabile);
			//Coordinatore Progettazione
			DatiAnagraficiType coordinatoreProgettazione = notifica.addNewCoordinatorprogettazione();
			this.getCoordinatoreProgettazione(coordinatoreProgettazione, coordinatore);
			//Coordinatore Esecuzione LAvori
			DatiAnagraficiType coordinatoreesecuzioneLavori = notifica.addNewCoordinatoreesecuzionelavori();
			this.getCoordinatoreesecuzioneLavori(coordinatoreesecuzioneLavori, coordEsecuzioneLavori);
			//Elenco Imprese
			List< ? > imprese = this.sqlManager.getListHashMap(selectW9CANTIMP, new Object[] {cantiere.getLong("CODGARA"), cantiere.getLong("CODLOTT"), cantiere.getLong("NUM_CANT")});
			if (imprese != null && imprese.size() > 0) {
				for (int j = 0; j < imprese.size(); j++) {
					DataColumnContainer impresa = new DataColumnContainer(this.sqlManager, "W9CANT", selectW9CANTIMP, new Object[] {cantiere.getLong("CODGARA"), cantiere.getLong("CODLOTT"), cantiere.getLong("NUM_CANT")});
					impresa.setValoriFromMap((HashMap< ?, ? >) imprese.get(j), true);
					ElencoImpreseType elencoImprese = notifica.addNewImprese();
					this.getImpresa(elencoImprese, impresa);
				}
			}
			//Causale modifica
			notifica.setCausaleModifica(1);
			//procediamo alla validazione del document
			ArrayList<Object> validationErrors = new ArrayList<Object>();
		    XmlOptions validationOptions = new XmlOptions();
		    validationOptions.setErrorListener(validationErrors);
		      	
			if (!doc.validate(validationOptions)) {
				String listaErroriValidazione = "";
		      	Iterator< ? > iter = validationErrors.iterator();
		      	while (iter.hasNext()) {
		      		listaErroriValidazione += iter.next() + "\n";
		      	}
		      	logger.error("Modifica scheda cantiere non valida, IDISTAT = " + idSitat + " Errori : " + listaErroriValidazione);
			} else {
				messaggio = doc.toString();
			}
	  } catch (Exception ex) {
		  logger.error("Errore durante la creazione del messaggio di nuova notifica preliminare Ev001 - NuovaNotificaPreliminare con idSistat = " + idSitat, ex);
	  }
	  return messaggio;
  }
  
  private void getDestinatari(DatiNotificaType datiNotifica, DataColumnContainer cantiere) throws Exception {
	  	//Destinatari
		List< ? > destinatari = this.sqlManager.getListHashMap(selectW9CANTDEST, new Object[] {cantiere.getLong("CODGARA"), cantiere.getLong("CODLOTT"), cantiere.getLong("NUM_CANT")});
		int[] destinatariArray = null;
		if (destinatari != null && destinatari.size() > 0) {
			destinatariArray = new int[destinatari.size()];
			for (int j = 0; j < destinatari.size(); j++) {
				HashMap< ? , ? > destinatario = (HashMap < ? , ? >) destinatari.get(j);
				destinatariArray[j] = Integer.parseInt(((JdbcParametro)destinatario.get("W9CANTDEST.DEST")).getStringValue());
			}
		}
		datiNotifica.setDestinatariArray(destinatariArray);
  }
  
  private void getDatiCantiere(DatiCantiereType datiCantiereSitat, DataColumnContainer cantiere) throws Exception {
	  	//Dati cantiere
	    datiCantiereSitat.setIndirizzo((cantiere.getString("INDCAN")!= null)?cantiere.getString("INDCAN") :"" );
		if (cantiere.getString("CIVICO")!=null) {
			datiCantiereSitat.setNumerocivico(cantiere.getString("CIVICO"));
		}
		String codiceIstat = cantiere.getString("COMUNE");
		if (codiceIstat != null && codiceIstat.length() == 9) {
			datiCantiereSitat.setComune(codiceIstat.substring(3));
			datiCantiereSitat.setProvincia(codiceIstat.substring(3,6));
		} else {
			datiCantiereSitat.setComune("000000");
			datiCantiereSitat.setProvincia("000");
		}
		datiCantiereSitat.setCoordX(cantiere.getLong("COORD_X"));
		datiCantiereSitat.setCoordY(cantiere.getLong("COORD_Y"));
		datiCantiereSitat.setCoordLat(new BigDecimal(cantiere.getDouble("LATIT").toString()));
		datiCantiereSitat.setCoordLong(new BigDecimal(cantiere.getDouble("LONGIT").toString()));
		
		if (cantiere.getData("DINIZ") != null) {
			GregorianCalendar dataIn = new GregorianCalendar();
			dataIn.setTime(cantiere.getData("DINIZ"));
			datiCantiereSitat.setDataInizio(dataIn);
		}
		datiCantiereSitat.setDurataGiorni(Integer.parseInt(cantiere.getObject("DLAV").toString()));
		datiCantiereSitat.setNumeroMaxLavoratori(Integer.parseInt(cantiere.getObject("NUMLAV").toString()));
		datiCantiereSitat.setNumeroImprese(Integer.parseInt(cantiere.getObject("NUMIMP").toString()));
		datiCantiereSitat.setNumeroLavoratoriAutonomi(Integer.parseInt(cantiere.getObject("LAVAUT").toString()));
  }
  
  private void getCommittente(CommittenteType committente, DataColumnContainer responsabile, String mailRic) throws Exception {
	  	//Committente
	  	RiferimentiType riferimenti = committente.addNewRiferimenti();
		NomeType nome = riferimenti.addNewNome();
		nome.setNome(responsabile.getString("NOMETEI"));
		nome.setCognome(responsabile.getString("COGTEI"));
		nome.setIdFiscale(responsabile.getString("CFTEC"));
		committente.setIndirizzoCommittente((responsabile.getString("INDTEC")!= null)?responsabile.getString("INDTEC"):"N.D.");
		String codiceIstat = responsabile.getString("CITTEC");
		if (codiceIstat != null && codiceIstat.length() == 9) {
			committente.setComuneCommittente(codiceIstat.substring(3));
			committente.setProvinciaCommittente(codiceIstat.substring(3,6));
		} else {
			committente.setComuneCommittente("000000");
			committente.setProvinciaCommittente("000");
		}
		committente.setTelefonoCommitente((responsabile.getString("TELTEC") != null)?responsabile.getString("TELTEC"):"N.D.");
		String emailReferente = (mailRic != null)?mailRic:responsabile.getString("EMATEC");
		committente.setEmailCommittente((emailReferente != null)?emailReferente:"N.D.");
  }
  
  private void getDatiOpera(DatiOperaType datiOperaSitat, DataColumnContainer lotto, DataColumnContainer cantiere) throws Exception {
	  	//Dati opera
		datiOperaSitat.setTipoOpera((cantiere.getObject("TIPOPERA") != null)?Integer.parseInt(cantiere.getObject("TIPOPERA").toString()):0); //datiOperaSitat.setTipoOpera(1);
		datiOperaSitat.setDescrizioneOpera(lotto.getString("OGGETTO"));
		datiOperaSitat.setTipologiaIntervento((cantiere.getObject("TIPINTERV") != null)?Integer.parseInt(cantiere.getObject("TIPINTERV").toString()):0);//datiOperaSitat.setTipologiaIntervento(4);
		datiOperaSitat.setTipologiaCostruttiva((cantiere.getObject("TIPCOSTR") != null)?Integer.parseInt(cantiere.getObject("TIPCOSTR").toString()):0);//datiOperaSitat.setTipologiaCostruttiva(1);
		Double importoLavori = (Double) this.sqlManager.getObject( selectImportoLavori, new Object[] { cantiere.getLong("CODGARA"), cantiere.getLong("CODLOTT") });
		datiOperaSitat.setAmmontareLavori((importoLavori != null)?new BigDecimal(importoLavori.toString()):new BigDecimal(0));
		datiOperaSitat.setFinanziamentoFondiPubblici(SceltaType.NO);
		datiOperaSitat.setFinanziamentofondiRegionali(SceltaType.NO);
		List < ? > listaFinanziamenti = this.sqlManager.getListHashMap(selectW9FINA, new Object[]{cantiere.getLong("CODGARA"), cantiere.getLong("CODLOTT")});
		if (listaFinanziamenti != null && listaFinanziamenti.size() > 0) {
			for (int i = 0; i < listaFinanziamenti.size(); i++) {
				HashMap< ? , ? > finanziamento = (HashMap< ? , ? >) listaFinanziamenti.get(i);
				String idFinanziamento = (String) ((JdbcParametro) finanziamento.get("W9FINA.ID_FINANZIAMENTO")).getValue();
				if (idFinanziamento.equalsIgnoreCase("C01") || idFinanziamento.equalsIgnoreCase("C02") || idFinanziamento.equalsIgnoreCase("C04") || idFinanziamento.equalsIgnoreCase("C05")) {
					datiOperaSitat.setFinanziamentoFondiPubblici(SceltaType.SI);
				} else if (idFinanziamento.equalsIgnoreCase("C03")) {
					datiOperaSitat.setFinanziamentofondiRegionali(SceltaType.SI);
				}
			}
		}
  }
  
  private void getResponsabileLavori(DatiAnagraficiType responsabileLavori, DataColumnContainer responsabile) throws Exception {
	  	//Responsabile Lavori
	  	responsabileLavori.setNome(responsabile.getString("NOMETEI"));
		responsabileLavori.setCognome(responsabile.getString("COGTEI"));
		responsabileLavori.setIdFiscale(responsabile.getString("CFTEC"));
		responsabileLavori.setIndirizzo((responsabile.getString("INDTEC")!= null)?responsabile.getString("INDTEC"):"N.D.");
		String codiceIstat = responsabile.getString("CITTEC");
		if (codiceIstat != null && codiceIstat.length() == 9) {
			responsabileLavori.setComune(codiceIstat.substring(3));
			responsabileLavori.setProvincia(codiceIstat.substring(3,6));
		} else {
			responsabileLavori.setComune("000000");
			responsabileLavori.setProvincia("000");
		}
		responsabileLavori.setTelefono((responsabile.getString("TELTEC") != null)?responsabile.getString("TELTEC"):"N.D.");
		responsabileLavori.setEmail((responsabile.getString("EMATEC") != null)?responsabile.getString("EMATEC"):"N.D.");
  }

  private void getCoordinatoreProgettazione(DatiAnagraficiType coordinatoreProgettazione, DataColumnContainer coordinatore) throws Exception {
	  	//Coordinatore Progettazione
	  	coordinatoreProgettazione.setNome(coordinatore.getString("NOMETEI"));
		coordinatoreProgettazione.setCognome(coordinatore.getString("COGTEI"));
		coordinatoreProgettazione.setIdFiscale(coordinatore.getString("CFTEC"));
		coordinatoreProgettazione.setIndirizzo((coordinatore.getString("INDTEC") != null)?coordinatore.getString("INDTEC"):"N.D.");
		String codiceIstat = coordinatore.getString("CITTEC");
		if (codiceIstat != null && codiceIstat.length() == 9) {
			coordinatoreProgettazione.setComune(codiceIstat.substring(3));
			coordinatoreProgettazione.setProvincia(codiceIstat.substring(3,6));
		} else {
			coordinatoreProgettazione.setComune("000000");
			coordinatoreProgettazione.setProvincia("000");
		}
		coordinatoreProgettazione.setTelefono((coordinatore.getString("TELTEC") != null)?coordinatore.getString("TELTEC"):"N.D.");
		coordinatoreProgettazione.setEmail((coordinatore.getString("EMATEC") != null)?coordinatore.getString("EMATEC"):"N.D.");
  }

  private void getCoordinatoreesecuzioneLavori(DatiAnagraficiType coordinatoreesecuzioneLavori, DataColumnContainer coordEsecuzioneLavori) throws Exception {
	  	//Coordinatore esecuzione Lavori
	  	coordinatoreesecuzioneLavori.setNome(coordEsecuzioneLavori.getString("NOMETEI"));
	  	coordinatoreesecuzioneLavori.setCognome(coordEsecuzioneLavori.getString("COGTEI"));
	  	coordinatoreesecuzioneLavori.setIdFiscale(coordEsecuzioneLavori.getString("CFTEC"));
	  	coordinatoreesecuzioneLavori.setIndirizzo((coordEsecuzioneLavori.getString("INDTEC") != null)?coordEsecuzioneLavori.getString("INDTEC"):"N.D." );
	  	String codiceIstat = coordEsecuzioneLavori.getString("CITTEC");
	  	if (codiceIstat != null && codiceIstat.length() == 9) {
	  		coordinatoreesecuzioneLavori.setComune(codiceIstat.substring(3));
	  		coordinatoreesecuzioneLavori.setProvincia(codiceIstat.substring(3,6));
	  	} else {
	  		coordinatoreesecuzioneLavori.setComune("000000");
	  		coordinatoreesecuzioneLavori.setProvincia("000");
	  	}
	  	coordinatoreesecuzioneLavori.setTelefono((coordEsecuzioneLavori.getString("TELTEC") != null)?coordEsecuzioneLavori.getString("TELTEC"):"N.D.");
	  	coordinatoreesecuzioneLavori.setEmail((coordEsecuzioneLavori.getString("EMATEC") != null)?coordEsecuzioneLavori.getString("EMATEC"):"N.D.");
  }
  
  private void getImpresa(ElencoImpreseType elencoImprese, DataColumnContainer impresa) throws Exception {
	  	//Impresa
	  	elencoImprese.setRagioneSociale(impresa.getString("NOMEST"));
		IDFiscaledittaType idFiscale = elencoImprese.addNewIdFiscale();
		idFiscale.setCF11(impresa.getString("CFIMP"));
		elencoImprese.setIndirizzoImpresa((impresa.getString("INDIMP") != null)?impresa.getString("INDIMP"):"N.D.");
		String codiceIstat = impresa.getString("CODCIT");
		if (codiceIstat != null && codiceIstat.length() == 9) {
			elencoImprese.setComuneImpresa(codiceIstat.substring(3));
			elencoImprese.setProvinciaImpresa(codiceIstat.substring(3,6));
		} else {
			elencoImprese.setComuneImpresa("000000");
			elencoImprese.setProvinciaImpresa("000");
		}
		elencoImprese.setTelefono((impresa.getString("TELIMP") != null)?impresa.getString("TELIMP"):"N.D.");
		elencoImprese.setEmail((impresa.getString("EMAIIP") != null)?impresa.getString("EMAIIP"):"N.D.");
		elencoImprese.setCIPDurc((impresa.getString("CIPDURC") != null)?impresa.getString("CIPDURC"):"");
		elencoImprese.setProtDurc((impresa.getString("PROTDURC") != null)?impresa.getString("PROTDURC"):"");
		if (impresa.getData("DATDURC") != null) {
			GregorianCalendar dataIn = new GregorianCalendar();
			dataIn.setTime(impresa.getData("DATDURC"));
			elencoImprese.setDataDurc(dataIn);
		}
  }
}
