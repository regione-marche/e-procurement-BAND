package it.eldasoft.w9.bl.sa;

import it.avlp.simog.massload.xmlbeans.ConsultaGaraResponseDocument;
import it.avlp.simog.massload.xmlbeans.GaraType;
import it.eldasoft.gene.bl.GenChiaviManager;
import it.eldasoft.gene.bl.GeneManager;
import it.eldasoft.gene.bl.SqlManager;
import it.eldasoft.gene.commons.web.domain.ProfiloUtente;
import it.eldasoft.gene.db.datautils.DataColumn;
import it.eldasoft.gene.db.datautils.DataColumnContainer;
import it.eldasoft.gene.web.struts.tags.gestori.GestoreException;
import it.eldasoft.utils.properties.ConfigManager;
import it.eldasoft.utils.sicurezza.CriptazioneException;
import it.eldasoft.w9.bl.RichiestaIdGaraCigManager;
import it.eldasoft.w9.bl.W9Manager;
import it.eldasoft.w9.common.CostantiSimog;
import it.eldasoft.w9.common.bean.GaraSABean;
import it.eldasoft.w9.common.bean.MigrazioneBean;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;

/**
 * Manager per la gestione dell'operazione di migrazione di una S.A.
 * 
 * @author Luca.Giacomazzo
 */
public class MigrazioneSaManager {

  /**
   * Logger della classe.
   */
  private static Logger logger = Logger.getLogger(MigrazioneSaManager.class);
  
  private SqlManager sqlManager;
  
  private W9Manager w9Manager;
  
  private RichiestaIdGaraCigManager richiestaIdGaraCigManager;
  
  private GeneManager geneManager;
  
  private GenChiaviManager genChiaviManager;

  /**
   * Set SqlManager.
   * @param sqlMan the sqlManager to set
   */
  public void setSqlManager(SqlManager sqlMan) {
    this.sqlManager = sqlMan;
  }
  
  /**
   * Set W9Manager.
   * 
   * @param w9Manager the w9Manager to set
   */
  public void setW9Manager(final W9Manager w9Manager) {
    this.w9Manager = w9Manager;
  }
  
  public void setRichiestaIdGaraCigManager(RichiestaIdGaraCigManager richiestaIdGaraCigManager) {
    this.richiestaIdGaraCigManager = richiestaIdGaraCigManager;
  }
  
  /**
   * Set GeneManager.
   * 
   * @param geneManager the geneManger to set
   */
  public void setGeneManager(final GeneManager geneManager) {
    this.geneManager = geneManager;
  }

  public void setGenChiaviManager(final GenChiaviManager genChiaviManager) {
    this.genChiaviManager = genChiaviManager;
  }
  
  /**
   * Valorizzazione degli attributi dell'oggetto GaraSABean passato come argomento del metodo stesso.
   * 
   * @param codiceGara
   * @param syscon
   * @param codUffint
   * @return
   * @throws CriptazioneException
   * @throws SQLException
   * @throws GestoreException
   */
  public GaraSABean valorizzaGaraSABean(long codiceGara, long syscon, String codUffint) throws SQLException {
    boolean continua = true;
    
    GaraSABean garaSaBean = this.getDatiGara(codiceGara);

    // Recupero da Simog dei codici Cig dei lotti della gara a partire dal numero gara
    HashMap<String, Object> hm1 = this.richiestaIdGaraCigManager.getCigGaraSimog(
        garaSaBean.getIdAvGara(), syscon, codUffint);
    
    if (((Boolean) hm1.get("esito")).booleanValue() ) {
      garaSaBean.setCodiciCigInSimog((String[]) hm1.get("codiciCig"));
    } else {
      garaSaBean.setOk(false);
      garaSaBean.setDescrErrore((String) hm1.get("msgErr"));
      continua = false;
    }
    
    if (continua) {
      if (garaSaBean.getCodiciCig() != null && garaSaBean.getCodiciCig().length > 0) {
        HashMap<String, Object> hm2 = this.richiestaIdGaraCigManager.getXmlSimog(
            garaSaBean.getCodiceCig(0), syscon, codUffint);

        if (((Boolean) hm2.get("esito")).booleanValue() ) {
          String garaXml = (String) hm2.get("garaXml");
          garaSaBean.setXmlSimog(garaXml);
        } else {
          garaSaBean.setOk(false);
          garaSaBean.setDescrErrore((String) hm2.get("msgErr"));
          continua = false;
        }
      }
    }
    
    return garaSaBean;
  }
  
  /**
   * Controllo preliminari per la gara 
   * 
   * @param codiceGara
   * @param syscon
   * @param codUffint
   * @param garaSaBean
   * @return
   * @throws SQLException
   * @throws GestoreException
   */
  public HashMap<String, Object> controlloDatiGaraSABean(MigrazioneBean mb,
      String codiceFiscaleStazAppDestinazione, long syscon) throws GestoreException {
    
    if (logger.isDebugEnabled()) {
      logger.debug("controlloDatiGaraSABean: inizio metodo");
    }
    
    boolean result = true;
    // Valore di default per il tipo di accesso ai servizi Simog
    int tipoAccessoWSSimog = 0;
    String a = ConfigManager.getValore(CostantiSimog.PROP_TIPO_ACCESSO);
    
    if (StringUtils.isNotEmpty(a)) {
      tipoAccessoWSSimog = Integer.parseInt(a);
    }

    boolean continua = true;
    HashMap<String, Object> hm = new HashMap<String, Object>();
    
    while (mb.getNumeroGareControllate() < mb.getNumeroGareDaMigrare() && continua) {
      try {
        if (mb.getNumeroGareControllate() == 0) {
          mb.resetGaraInElaborazione();
        } else if (mb.getNumeroGareControllate() == 1) {
          // Valorizzazione del CF, CODEIN, NOMEIN della SA di destinazione nell'oggetto
          // MigrazioneBean per poi controllare che tutte le gare vengano migrate
          // verso la stessa S.A.
          mb.setCodiceFiscaleStazAppDestinazione(mb.getGaraSABeanInElaborazione().getCfsaDestinazione());
          mb.setCodiceStazAppDestinazione(mb.getGaraSABeanInElaborazione().getCodeinDestinazione());
          mb.setNomeStazAppDestinazione((String) this.sqlManager.getObject(
              "select NOMEIN from UFFINT where CFEIN=?", 
              new Object[] { mb.getGaraSABeanInElaborazione().getCodeinDestinazione() }));
        }
        mb.passaAllaGaraSuccessiva();
    
        GaraSABean garaSaBean = mb.getGaraSABeanInElaborazione();
        
        switch (tipoAccessoWSSimog) {
        case CostantiSimog.SA_CONSULTA_GARA_ACCESSO_INDIRETTO_VIA_WS:
          result = this.controlloDatiGaraSABeanWS(garaSaBean, codiceFiscaleStazAppDestinazione, syscon);
          hm.put("esito", result);
          break;
    
        case CostantiSimog.SA_CONSULTA_GARA_ACCESSO_INDIRETTO:
          result = this.controlloDatiGaraSABeanPDD(garaSaBean, codiceFiscaleStazAppDestinazione, syscon);
          hm.put("esito", result);
          break;
    
        default:
          String msgError = "Errore nella configurazione dell'applicazione: non e' stato " +
              "indicato il tipo di accesso ai servizi Simog per la funzione di migrazione " +
              "delle stazioni appaltanti. Contattare un amministratore";
          logger.error(msgError);
    
          hm.put("esito", Boolean.FALSE);
          hm.put("msgErr", "errors.migrazioneSA.noConfigurazione");
          break;
        }
    
      } catch (XmlException xe) {
        logger.error("Errore nel parsing del Xml ricevuto da Simog nel recupero " +
            "dei dati della gara in fase esecuzione dei controlli preliminari", xe);

        continua = false;
      } catch (SQLException se) {
        logger.error("Errore inaspettato nel recupero dei dati della gara " +
            "in fase esecuzione dei controlli preliminari", se);

        continua = false;
      } finally {
        if (continua == false) {
          throw new GestoreException("Errore inaspettato nel controllo dei dati della gara con numero gara pari a "
              + mb.getGaraSABeanInElaborazione().getIdAvGara(), null);
        } else {
          mb.incrementaNumeroGareControllate();
        }
      }
    }

    if (logger.isDebugEnabled()) {
      logger.debug("controlloDatiGaraSABean: fine metodo");
    }
    
    return hm;
  }

  
  private boolean controlloDatiGaraSABeanWS(GaraSABean garaSaBean, String codiceFiscaleStazAppDestinazione,
      long syscon) throws XmlException, SQLException {

    if (logger.isDebugEnabled()) {
      logger.debug("controlloDatiGaraSABeanWS: inizio metodo");
    }

    boolean result = true;
    
    // Rimappatura dell'oggetto ResponseConsultaGara nell'oggetto SchedaDocument per
    // evitare problemi di namespace fra i WS tra SA e ORT e tra ORT e SIMOG
    ConsultaGaraResponseDocument consultaGaraResponseDocument = ConsultaGaraResponseDocument.Factory.parse(garaSaBean.getXmlSimog());
    
    GaraType garaType = consultaGaraResponseDocument.getConsultaGaraResponse().getReturn().getGaraXML().getDatiGara().getGara();
    
    if (garaType.getCFAMMINISTRAZIONE().equalsIgnoreCase(garaSaBean.getCfsaOrigine())) {
      // Errore: la gara in Simog non e' stata migrata nella nuova SA
      logger.error("Impossibile completare l'operazione di migrazione della gara con IdAvGAra=" +
          garaType.getIDGARA() + " da parte dell'utente SYSCON=" + syscon + " per la SA CODEIN="
          + garaSaBean.getCodeinOrigine() + " perche' CFSA in Simog e' uguale al CFSA in Sitat." +
          		" L'operazione deve essere effettuata prima in SIMOG.");
      
      garaSaBean.setOggettoGara(garaType.getOGGETTO());
      garaSaBean.setIdAvGara("" + garaType.getIDGARA());
      
      garaSaBean.setIdStazAppaltanteSimog(garaType.getIDSTAZIONEAPPALTANTE());
      garaSaBean.setDenomStazAppaltanteSimog(garaType.getDENOMSTAZIONEAPPALTANTE());
      
      garaSaBean.setOk(false);
      garaSaBean.setDescrErrore("errors.migrazioneSA.migrareGaraInSimog");

      result = false;
    } else {
      if (StringUtils.isNotEmpty(codiceFiscaleStazAppDestinazione) &&
          ! StringUtils.equalsIgnoreCase(codiceFiscaleStazAppDestinazione, 
              garaType.getCFAMMINISTRAZIONE())) {
        // Errore: le gare da migrare non riferiscono tutte alla stessa stazione appaltante
        logger.error("Impossibile completare l'operazione di migrazione della gara con IdAvGAra=" +
            garaType.getIDGARA() + " da parte dell'utente SYSCON=" + syscon + " per la SA CODEIN="
            + garaSaBean.getCodeinOrigine() + " perche' la gara in Simog e' associata ad una " +
            		"stazione appaltante diversa dalle altre gare");

        garaSaBean.setOggettoGara(garaType.getOGGETTO());
        garaSaBean.setIdAvGara("" + garaType.getIDGARA());
        
        garaSaBean.setIdStazAppaltanteSimog(garaType.getIDSTAZIONEAPPALTANTE());
        garaSaBean.setDenomStazAppaltanteSimog(garaType.getDENOMSTAZIONEAPPALTANTE());
        
        garaSaBean.setOk(false);
        garaSaBean.setDescrErrore("errors.migrazioneSA.gareSaDiverseInSimog");
        //"Le gare in SIMOG appartengono a piu' stazioni appaltanti. Impossibile procedere";

        result = false;
      } else {
        garaSaBean.setCfsaDestinazione(garaType.getCFAMMINISTRAZIONE());
        
        garaSaBean.setIdStazAppaltanteSimog(garaType.getIDSTAZIONEAPPALTANTE());
        garaSaBean.setDenomStazAppaltanteSimog(garaType.getDENOMSTAZIONEAPPALTANTE());
      }
    }
    
    if (result) {
      String cfSaDest = garaType.getCFAMMINISTRAZIONE();
      
      Long numeroSA = (Long) this.sqlManager.getObject(
          "select count(*) from UFFINT where UPPER(CFEIN)=?",
          new Object[] { cfSaDest });
      
      if (numeroSA.intValue() == 1) {
        Long numero = (Long) this.sqlManager.getObject(
            "select count(*) from USR_EIN where SYSCON=? AND UPPER(CODEIN)=(select CODEIN from UFFINT where UPPER(CFEIN)=?)",
            new Object[] { new Long(syscon), cfSaDest });

        if (numero.intValue() < 1) {
          // l'utente che ha richiesto la migrazione della la gara in accesso
          // non ha accesso alla SA di destinazione
          logger.error("Impossibile completare l’operazione di migrazione della gara con IdAvGAra=" +
              garaType.getIDGARA() + " da parte dell'utente SYSCON=" + syscon + " dalla SA con CF=" +
              garaSaBean.getCfsaOrigine() + " ( CODEIN=" + garaSaBean.getCodeinOrigine()
              + ") perche' l'utente non ha permesso di accedere alla SA di destinazione (CFSA=" + cfSaDest + ")");
          
          garaSaBean.setOggettoGara(garaType.getOGGETTO());
          garaSaBean.setIdAvGara("" + garaType.getIDGARA());
          garaSaBean.setOk(false);
          garaSaBean.setDescrErrore("errors.migrazioneSA.noAccessoSaDestinazione"); 
          //"Attenzione. L’utente non ha permesso di accedere alla " +
          //"stazione appaltante " + schedaDocument.getScheda().getDatiScheda().getDatiComuni().getDENSA()
          //+ " (CF= " + cfSaDest + "). Contattare un amministratore del sistema");

          result = false;
        } else {
          // l'utente che ha richiesto la migrazione della la gara
          // in accesso ha accesso alla SA di destinazione
          garaSaBean.setCfsaDestinazione(garaType.getCFAMMINISTRAZIONE());
          garaSaBean.setCodeinDestinazione((String) this.sqlManager.getObject(
              "select CODEIN from UFFINT where UPPER(CFEIN)=?", new Object[] { cfSaDest }));

          result = true;
        }
      } else if (numeroSA.intValue() < 1) {
        // Non esiste la SA con il CF indicato
        logger.error("Impossibile completare l’operazione di migrazione della gara con IdAvGAra=" +
            garaType.getIDGARA() + " da parte dell'utente SYSCON=" + syscon + " per la SA CODEIN="
            + garaSaBean.getCodeinOrigine() + " perche' in Sitat non esiste la SA con CFEIN="
            + cfSaDest.toUpperCase());
        
        result = false;
        
        garaSaBean.setOggettoGara(garaType.getOGGETTO());
        garaSaBean.setIdAvGara("" + garaType.getIDGARA());
        garaSaBean.setOk(false);
        garaSaBean.setDescrErrore("errors.migrazioneSA.noSaDestinazione");
        //"La stazione appaltante di destinazione non e' presente nell'archivio " +
        //"dell'applicativo. Contattare un amministratore del sistema");
        
      } else {
        // Più SA con lo stesso CF
        logger.error("Impossibile completare l’operazione di migrazione della gara con IdAvGAra=" +
            garaType.getIDGARA() + " da parte dell'utente SYSCON=" + syscon + " dalla SA CODEIN="
            + garaSaBean.getCodeinOrigine() + " perche' in Sitat esiste piu' volte la SA con CFEIN="
            + cfSaDest.toUpperCase());
        
        garaSaBean.setOggettoGara(garaType.getOGGETTO());
        garaSaBean.setIdAvGara("" + garaType.getIDGARA());
        garaSaBean.setOk(false);
        garaSaBean.setDescrErrore("errors.migrazioneSA.noUnicaSaDestinazione"); 
          //"La stazione appaltante di destinazione e' presente piu' volte nell'archivio " +
          //"dell'applicativo. Contattare un amministratore del sistema");

        result = false;
      }
    }

    if (logger.isDebugEnabled()) {
      logger.debug("controlloDatiGaraSABeanWS: fine metodo");
    }
    
    return result;
  }
  
  
  private boolean controlloDatiGaraSABeanPDD(GaraSABean garaSaBean, String codiceFiscaleStazAppDestinazione,
      long syscon) throws XmlException, SQLException {

    if (logger.isDebugEnabled()) {
      logger.debug("controlloDatiGaraSABeanWS: inizio metodo");
    }

    boolean result = true;

    // Rimappatura dell'oggetto ResponseConsultaGara nell'oggetto SchedaDocument per
    // evitare problemi di namespace fra i WS tra SA e ORT e tra ORT e SIMOG
    ConsultaGaraResponseDocument consultaGaraResponseDocument = ConsultaGaraResponseDocument.Factory.parse(garaSaBean.getXmlSimog());
    
    GaraType garaType = consultaGaraResponseDocument.getConsultaGaraResponse().getReturn().getGaraXML().getDatiGara().getGara();
    
    if (garaType.getCFAMMINISTRAZIONE().equalsIgnoreCase(garaSaBean.getCfsaOrigine())) {
      // Errore: la gara in Simog non e' stata migrata nella nuova SA
      logger.error("Impossibile completare l’operazione di migrazione della gara con IdAvGAra=" +
          garaType.getIDGARA() + " da parte dell'utente SYSCON=" + syscon + " per la SA CODEIN="
          + garaSaBean.getCodeinOrigine() + " perche' CFSA in Simog e' uguale al CFSA in Sitat." +
              " L'operazione deve essere effettuata prima in SIMOG. ");
      
      garaSaBean.setOggettoGara(garaType.getOGGETTO());
      garaSaBean.setIdAvGara("" + garaType.getIDGARA());
      
      garaSaBean.setIdStazAppaltanteSimog(garaType.getIDSTAZIONEAPPALTANTE());
      garaSaBean.setDenomStazAppaltanteSimog(garaType.getDENOMSTAZIONEAPPALTANTE());
      
      garaSaBean.setOk(false);
      garaSaBean.setDescrErrore("errors.migrazioneSA.migrareGaraInSimog");
      
      result = false;
    } else {
      if (StringUtils.isNotEmpty(codiceFiscaleStazAppDestinazione) &&
          ! StringUtils.equalsIgnoreCase(codiceFiscaleStazAppDestinazione, 
              garaType.getCFAMMINISTRAZIONE())) {
        // Errore: le gare da migrare non riferiscono tutte alla stessa stazione appaltante
        logger.error("Impossibile completare l'operazione di migrazione della gara con IdAvGAra=" +
            garaType.getIDGARA() + " da parte dell'utente SYSCON=" + syscon + " per la SA CODEIN="
            + garaSaBean.getCodeinOrigine() + " perche' la gara in Simog e' associata ad una " +
                "stazione appaltante diversa dalle altre gare");

        garaSaBean.setOggettoGara(garaType.getOGGETTO());
        garaSaBean.setIdAvGara("" + garaType.getIDGARA());
        
        garaSaBean.setIdStazAppaltanteSimog(garaType.getIDSTAZIONEAPPALTANTE());
        garaSaBean.setDenomStazAppaltanteSimog(garaType.getDENOMSTAZIONEAPPALTANTE());
        
        garaSaBean.setOk(false);
        garaSaBean.setDescrErrore("errors.migrazioneSA.gareSaDiverseInSimog");
        //"Le gare in SIMOG appartengono a piu' stazioni appaltanti. Impossibile procedere";

        result = false;
      } else {
        garaSaBean.setCfsaDestinazione(garaType.getCFAMMINISTRAZIONE());
        
        garaSaBean.setIdStazAppaltanteSimog(garaType.getIDSTAZIONEAPPALTANTE());
        garaSaBean.setDenomStazAppaltanteSimog(garaType.getDENOMSTAZIONEAPPALTANTE());
      }
    }
    
    if (result) {
      String cfSaDest = garaType.getCFAMMINISTRAZIONE();
      
      Long numeroSA = (Long) this.sqlManager.getObject(
          "select count(*) from UFFINT where UPPER(CFEIN)=?",
          new Object[] { cfSaDest.toUpperCase() });
      
      if (numeroSA.intValue() == 1) {
        Long numero = (Long) this.sqlManager.getObject(
            "select count(*) from USR_EIN where SYSCON=? AND UPPER(CODEIN)=(select CODEIN from UFFINT where UPPER(CFEIN)=?)",
            new Object[] { new Long(syscon), cfSaDest.toUpperCase() });

        if (numero.intValue() < 1) {
          // l'utente che ha richiesto la migrazione della gara
          // non ha accesso alla SA di destinazione
          logger.error("Impossibile completare l’operazione di migrazione della gara con IdAvGAra=" +
              garaType.getIDGARA() + " da parte dell'utente SYSCON=" + syscon + " dalla SA con CF=" +
              garaSaBean.getCfsaOrigine() + " ( CODEIN=" + garaSaBean.getCodeinOrigine()
              + ") perche' l'utente non ha permesso di accedere alla SA di destinazione (CFSA=" + cfSaDest + ")");
          
          garaSaBean.setOggettoGara(garaType.getOGGETTO());
          garaSaBean.setIdAvGara("" + garaType.getIDGARA());
          garaSaBean.setOk(false);
          garaSaBean.setDescrErrore("errors.migrazioneSA.noAccessoSaDestinazione"); 
          //"Attenzione. L’utente non ha permesso di accedere alla " +
          //"stazione appaltante " + schedaDocument.getScheda().getDatiScheda().getDatiComuni().getDENSA()
          //+ " (CF= " + cfSaDest + "). Contattare un amministratore del sistema");
          
          
          result = false;
        } else {
          // l'utente che ha richiesto la migrazione della la gara
          // in accesso ha accesso alla SA di destinazione
          garaSaBean.setCfsaDestinazione(garaType.getCFAMMINISTRAZIONE());
          garaSaBean.setCodeinDestinazione((String) this.sqlManager.getObject(
              "select CODEIN from UFFINT where UPPER(CFEIN)=?", new Object[] { cfSaDest }));

          result = true;
        }
      } else if (numeroSA.intValue() < 1) {
        // Non esiste la SA con il CF indicato
        logger.error("Impossibile completare l’operazione di migrazione della gara con IdAvGAra=" +
            garaType.getIDGARA() + " da parte dell'utente SYSCON=" + syscon + " per la SA CODEIN="
            + garaSaBean.getCodeinOrigine() + " perche' in Sitat non esiste la SA con CFEIN="
            + cfSaDest.toUpperCase());
        
        result = false;
        
        garaSaBean.setOggettoGara(garaType.getOGGETTO());
        garaSaBean.setIdAvGara("" + garaType.getIDGARA());
        garaSaBean.setOk(false);
        garaSaBean.setDescrErrore("errors.migrazioneSA.noSaDestinazione");
        //"La stazione appaltante di destinazione non e' presente nell'archivio " +
        //"dell'applicativo. Contattare un amministratore del sistema");
      } else {
        // Più SA con lo stesso CF
        logger.error("Impossibile completare l’operazione di migrazione della gara con IdAvGAra=" +
            garaType.getIDGARA() + " da parte dell'utente SYSCON=" + syscon + " dalla SA CODEIN="
            + garaSaBean.getCodeinOrigine() + " perche' in Sitat esiste piu' volte la SA con CFEIN="
            + cfSaDest.toUpperCase());
        
        garaSaBean.setOggettoGara(garaType.getOGGETTO());
        garaSaBean.setIdAvGara("" + garaType.getIDGARA());
        garaSaBean.setOk(false);
        garaSaBean.setDescrErrore("errors.migrazioneSA.noUnicaSaDestinazione"); 
          //"La stazione appaltante di destinazione e' presente piu' volte nell'archivio " +
          //"dell'applicativo. Contattare un amministratore del sistema");

        result = false;
      }
    }

    if (logger.isDebugEnabled()) {
      logger.debug("controlloDatiGaraSABeanWS: fine metodo");
    }
    
    return result;
  }
  
  /**
   * Aggiornamento della stazione appaltante, del RUP, degli archivi imprese,
   * legali rappresentanti per la gara passata come argomento.
   * 
   * @param garaSaBean
   * @param profiloUtente
   * @throws GestoreException
   * @throws SQLException
   */
  public synchronized boolean updateStazioneAppaltante(MigrazioneBean mb,
      ProfiloUtente profiloUtente) throws GestoreException, SQLException, Throwable {

    if (logger.isDebugEnabled()) {
      logger.debug("updateStazioneAppaltante: inizio metodo");
    }
    
    boolean continua = true;
    
    while (mb.getNumeroGareMigrate() < mb.getNumeroGareDaMigrare() && continua) {
      if (mb.getNumeroGareMigrate() == 0) {
        mb.resetGaraInElaborazione();
      }
      mb.passaAllaGaraSuccessiva();
      
      GaraSABean garaSaBean = mb.getGaraSABeanInElaborazione();
      
      try {
        Long codiceGara = garaSaBean.getCodiceGara();
        Long codiceLotto = null;
        
        //String codeinSaSorgente = this.w9Manager.getCodein(garaSaBean.getCfsaOrigine());
        String codeinSaDestinazione = this.w9Manager.getCodein(garaSaBean.getCfsaDestinazione());
        
        String codiceTecnicoSorgente = (String) this.sqlManager.getObject(
            "select RUP from W9GARA where CODGARA=?",
            new Object[] { codiceGara });
        String codiceTecnicoDestinazione = null;
        if (StringUtils.isNotEmpty(codiceTecnicoSorgente)) {
          codiceTecnicoDestinazione = (String) this.sqlManager.getObject(
              "select CODTEC from TECNI where CGENTEI=? and CFTEC=(select CFTEC from TECNI where CODTEC=?)",
              new Object[] { codeinSaDestinazione, codiceTecnicoSorgente });
          if (StringUtils.isEmpty(codiceTecnicoDestinazione)) {
            // Non esiste il tecnico associato alla nuova Stazione appaltante.
            // Si provvede ad inserirne uno, copaiando i dati dal tecnico sorgente
            
            DataColumnContainer dccTecni = new DataColumnContainer(this.sqlManager, "TECNI",
                "select CODTEC, CGENTEI, CFTEC, CITTEC, COGTEI, NOMETEI, NOMTEC, INDTEC, NCITEC, LOCTEC, CAPTEC, TELTEC, " +
                "FAXTEC, EMATEC, PROTEC, SYSCON from TECNI where CODTEC=? ", new Object[] { codiceTecnicoSorgente });
      
            this.copiaValori(dccTecni);
            dccTecni.getColumn("TECNI.CODTEC").setChiave(true);
            codiceTecnicoDestinazione = this.geneManager.calcolaCodificaAutomatica("TECNI", "CODTEC");
            dccTecni.getColumn("TECNI.CODTEC").setObjectValue(codiceTecnicoDestinazione);
            dccTecni.getColumn("TECNI.CGENTEI").setObjectValue(codeinSaDestinazione);
            dccTecni.insert("TECNI", this.sqlManager);
          }
        }
        
        Long idCentroCosto = (Long) this.sqlManager.getObject(
            "select IDCENTRO from CENTRICOSTO where UPPER(CODCENTRO)=? and CODEIN=?",
            new Object[] { garaSaBean.getIdStazAppaltanteSimog().toUpperCase(), codeinSaDestinazione });
        
        if (idCentroCosto == null) {
          Long maxIdCentroCosto = (Long) this.sqlManager.getObject("select max(IDCENTRO)+1 from CENTRICOSTO", 
              new Object[]{});
          if (maxIdCentroCosto == null) {
            idCentroCosto = new Long(1);
          } else {
            idCentroCosto = maxIdCentroCosto;
          }
          
          this.sqlManager.update("INSERT INTO CENTRICOSTO (IDCENTRO,CODEIN,CODCENTRO,DENOMCENTRO) VALUES (?,?,?,?)",
              new Object[] { idCentroCosto, codeinSaDestinazione, garaSaBean.getIdStazAppaltanteSimog(),
                  garaSaBean.getDenomStazAppaltanteSimog() } );
        }
        
        // Aggiornamento della Gara: RUP e CODEIN.
        this.sqlManager.update("update W9GARA set RUP=?, CODEIN=?, IDCC=? where CODGARA=?", 
            new Object[] { codiceTecnicoDestinazione, codeinSaDestinazione, idCentroCosto, codiceGara } );
        
        // Aggiornamento del RUP e del DAEXPORT per tutti i lotti della gara. Il campo DAEXPORT
        // viene impostato a 1 per imporre l'invio dell'anagrafica gara-lotto a OR
        this.sqlManager.update("update W9LOTT set RUP=?, DAEXPORT='1' where CODGARA=? ",
            new Object[] { codiceTecnicoDestinazione, codiceGara  } );
        
        // Gestione degli incarichi professionali diversi dal RUP.
        List< ? > listaIncaricati = this.sqlManager.getListVector(
            "select CODTEC from W9INCA where CODGARA=?", new Object[] { codiceGara } );  
        
        if (listaIncaricati != null && listaIncaricati != null) {
          for (int ui=0; ui < listaIncaricati.size(); ui++) {
            Vector< ? > incaricato = (Vector< ? >) listaIncaricati.get(ui);
            
            if (incaricato != null && incaricato.get(0) != null) {
              String codiceTec = incaricato.get(0).toString();
              
              String codTecDest = (String) this.sqlManager.getObject(
                  "select CODTEC from TECNI where CGENTEI=? and CFTEC=(select CFTEC from TECNI where CODTEC=?)",
                  new Object[] { codeinSaDestinazione, codiceTec });
              if (StringUtils.isEmpty(codTecDest)) {
                // Non esiste il tecnico associato alla nuova Stazione appaltante.
                // Si provvede ad inserirne uno, copaiando i dati dal tecnico sorgente
                
                DataColumnContainer dccTecni = new DataColumnContainer(this.sqlManager, "TECNI",
                    "select CODTEC, CGENTEI, CFTEC, CITTEC, COGTEI, NOMETEI, NOMTEC, INDTEC, NCITEC, LOCTEC, CAPTEC, TELTEC, " +
                    "FAXTEC, EMATEC, PROTEC, SYSCON from TECNI where CODTEC=? ", new Object[] { codiceTec });
    
                this.copiaValori(dccTecni);
                dccTecni.getColumn("TECNI.CODTEC").setChiave(true);
                codTecDest = this.geneManager.calcolaCodificaAutomatica("TECNI", "CODTEC");
                dccTecni.getColumn("TECNI.CODTEC").setObjectValue(codTecDest);
                dccTecni.getColumn("TECNI.CGENTEI").setObjectValue(codeinSaDestinazione);
                dccTecni.insert("TECNI", this.sqlManager);
              }
              
              this.sqlManager.update("update W9INCA set CODTEC=? where CODGARA=? and CODTEC=?", 
                  new Object[] { codTecDest, codiceGara, codiceTec });
            }
          }
        }
        
        // Gestione delle imprese associate alla gara: W9AGGI, W9SUBA, W9CANTIMP, W9IMPRESE,
        // W9INASIC, W9INFOR, W9MISSCI, W9SIC, W9REGCON e dei legali rappresentanti.
        String[] arrayTabelleImpresa = new String[] { "W9AGGI", "W9AGGI", "W9SUBA", "W9SUBA", 
            "W9CANTIMP", "W9IMPRESE", "W9INASIC", "W9INFOR", "W9MISSIC", "W9SIC", "W9REGCON" };
        String[] arrayNomiCampiImpresa = new String[] { "CODIMP,NUM_AGGI", "CODIMP_AUSILIARIA,NUM_AGGI",
            "CODIMP,NUM_SUBA", "CODIMP_AGGIUDICATRICE,NUM_SUBA", "CODIMP,NUM_CANT", "CODIMP,NUM_IMPR", 
            "CODIMP,NUM_INAD", "CODIMP,NUM_INFOR", "CODIMP,NUM_MISS", "CODIMP,NUM_SIC", "CODIMP,NUM_REGO" };
        
        for (int i=0; i < arrayTabelleImpresa.length; i++) {
          List< ? > listaImprese = this.sqlManager.getListVector(
              "select CODLOTT," + arrayNomiCampiImpresa[i] + " from " + arrayTabelleImpresa[i] +
                " where CODGARA=? order by CODLOTT asc ", new Object[] { codiceGara });
          
          Long progressivo = null;
          if (listaImprese != null && listaImprese.size() > 0) {
            for (int i1=0; i1 < listaImprese.size(); i1++) {
              Vector< ? > impresa = (Vector< ? >) listaImprese.get(i1);
              if (impresa != null && (impresa.size() == 2 && impresa.get(0) != null && impresa.get(1) != null)
                  || (impresa.size() == 3 && impresa.get(0) != null && impresa.get(1) != null && impresa.get(2) != null))  {
                codiceLotto = new Long(impresa.get(0).toString());
                String codiceImpresaOrigine  = impresa.get(1).toString();
                
                if (impresa.size() == 3) {
                  progressivo = new Long(impresa.get(2).toString());
                } else {
                  progressivo = null;
                }
    
                String codiceImpresaDestinazione = null;
                if (StringUtils.isNotEmpty(codiceImpresaOrigine)) {
                  codiceImpresaDestinazione = (String) this.sqlManager.getObject(
                      "select CODIMP from IMPR where CGENIMP=? and (CFIMP=(select CFIMP from IMPR where CODIMP=?) " +
                      "or PIVIMP=(select PIVIMP from IMPR where CODIMP=?))",
                      new Object[] { codeinSaDestinazione, codiceImpresaOrigine, codiceImpresaOrigine });
                  
                  if (StringUtils.isEmpty(codiceImpresaDestinazione)) {
                    // Copia dell'impresa nella Stazione appalatante di destinazione...
                    codiceImpresaDestinazione = this.geneManager.calcolaCodificaAutomatica("IMPR", "CODIMP");
                    
                    DataColumnContainer dccIMPR = new DataColumnContainer(sqlManager, "IMPR",
                        "select IMPR.CODIMP, IMPR.CGENIMP, IMPR.NOMEST, IMPR.NOMIMP, IMPR.NAZIMP, " +
                               "IMPR.CFIMP, IMPR.TIPIMP, IMPR.PIVIMP, IMPR.INDIMP, IMPR.NCIIMP, " +
                               "IMPR.PROIMP, IMPR.CAPIMP, IMPR.LOCIMP, IMPR.CODCIT,IMPR.TELIMP, " +
                               "IMPR.FAXIMP, IMPR.TELCEL, IMPR.EMAIIP, IMPR.EMAI2IP, IMPR.INDWEB, " +
                               "IMPR.NCCIAA, IMPR.NATGIUI from IMPR where CODIMP=?", new Object[] { codiceImpresaOrigine } );
                    this.copiaValori(dccIMPR);
                    
                    dccIMPR.getColumn("IMPR.CODIMP").setChiave(true);
                    dccIMPR.setValue("IMPR.CODIMP", codiceImpresaDestinazione);
                    dccIMPR.setValue("IMPR.CGENIMP", codeinSaDestinazione);
                    dccIMPR.insert("IMPR", this.sqlManager);

                    // Gestione dei legali rappresentanti dell'impresa (IMPLEG, TEIM)
                    // Si crea l'occorrenza in IMPLEG, copiandola dall'impresa 
                    // di origine ed aggiornando i campi CODIMP2 e CODLEG di IMPLEG.
                    List< ? > listaImpleg = this.sqlManager.getListVector(
                        "select CODLEG from IMPLEG where CODIMP2=?", new Object[] { codiceImpresaOrigine });
                    String codiceTEIM = codiceImpresaDestinazione;
                    
                    if (listaImpleg != null && listaImpleg.size() > 0) {
                      for (int j = 0; j < listaImpleg.size(); j++) {
                        Vector< ? > obj = (Vector< ? >) listaImpleg.get(j);
                        if (obj != null && obj.size() == 1 && obj.get(0) != null) {
                          String codImpLeg = obj.get(0).toString();
                          
                          // Copia del tecnico d'impresa nella nuova stazione appaltante
                          DataColumnContainer dccTEIM = new DataColumnContainer(this.sqlManager, "TEIM",
                              "select CODTIM, COGTIM, NOMETIM, NOMTIM, CFTIM, CGENTIM from TEIM where CODTIM=?", 
                              new Object[] { codImpLeg });
                            
                          this.copiaValori(dccTEIM);
                          dccTEIM.getColumn("TEIM.CODTIM").setChiave(true);
                          dccTEIM.setValue("TEIM.CODTIM", codiceTEIM);
                          dccTEIM.setValue("TEIM.CGENTIM", codeinSaDestinazione);
                          dccTEIM.insert("TEIM", this.sqlManager);

                          // IMPLEG:
                          // Copiare il record di IMPLEG e cambiare i campi CODIMP2 e CODLEG per creare 
                          // l'associazione tra l'impresa ed il legale rappresentante
                          DataColumnContainer dccIMPLEG = new DataColumnContainer(this.sqlManager, "IMPLEG",
                              "select ID, CODIMP2, CODLEG, NOMLEG from IMPLEG " +
                               "where CODIMP2=? and CODLEG=?",
                              new Object[] { codiceImpresaOrigine, codImpLeg });
                          this.copiaValori(dccIMPLEG);
                          int nextId = this.genChiaviManager.getNextId("IMPLEG");
                          dccIMPLEG.setValue("IMPLEG.ID", new Long(nextId));
                          dccIMPLEG.getColumn("IMPLEG.ID").setChiave(true);
                          dccIMPLEG.setValue("IMPLEG.CODIMP2", codiceImpresaDestinazione);
                          dccIMPLEG.setValue("IMPLEG.CODLEG", codiceTEIM);
                          dccIMPLEG.insert("IMPLEG", this.sqlManager);
                        }
                      }
                    }
                  }
                }
                  
                if (progressivo == null) {
                  this.sqlManager.update("update " + arrayTabelleImpresa[i] + " set "
                      + arrayNomiCampiImpresa[i].split(",")[0] + "=? where CODGARA=? and CODLOTT=?",
                      new Object[] { codiceImpresaDestinazione, codiceGara, codiceLotto });
                } else {
                  this.sqlManager.update("update " + arrayTabelleImpresa[i] + " set "
                      + arrayNomiCampiImpresa[i].split(",")[0] + "=? where CODGARA=? and CODLOTT=? and "
                      + arrayNomiCampiImpresa[i].split(",")[1] + "=?",
                      new Object[] { codiceImpresaDestinazione, codiceGara, codiceLotto, progressivo });
                }
              }
            }
          }
        }
        
        mb.incrementaNumeroGareMigrate();
      } catch (GestoreException e) {
        logger.error("Errore inaspettato nell'aggiornamento della gara con IdAvGara=" + garaSaBean.getIdAvGara()
            + " da parte dell'utente " + profiloUtente.getNome() + " USRSYS.SYSCON=" + profiloUtente.getId()
            + " nel migrare la gara dalla S.A. con CF=" + garaSaBean.getCfsaOrigine()
            + " alla S.A. con CF=" + garaSaBean.getCfsaDestinazione(), e);
        garaSaBean.setOk(false);

        // in caso di errore
        mb.setErrore("updatesa");
        continua = false;
      } catch (SQLException e) {
        logger.error("Errore inaspettato nell'aggiornamento della gara con IdAvGara=" + garaSaBean.getIdAvGara()
            + " da parte dell'utente " + profiloUtente.getNome() + " USRSYS.SYSCON=" + profiloUtente.getId()
            + " nel migrare la gara dalla S.A. con CF=" + garaSaBean.getCfsaOrigine()
            + " alla S.A. con CF=" + garaSaBean.getCfsaDestinazione(), e);
        garaSaBean.setOk(false);

        // in caso di errore
        mb.setErrore("updatesa");
        continua = false;
      } catch (Throwable t) {
        logger.error("Errore inaspettato nell'aggiornamento della gara con IdAvGara=" + garaSaBean.getIdAvGara()
            + " da parte dell'utente " + profiloUtente.getNome() + " USRSYS.SYSCON=" + profiloUtente.getId()
            + " nel migrare la gara dalla S.A. con CF=" + garaSaBean.getCfsaOrigine()
            + " alla S.A. con CF=" + garaSaBean.getCfsaDestinazione(), t);
        garaSaBean.setOk(false);

        // in caso di errore
        mb.setErrore("updatesa");
        continua = false;
      } finally {
        
        if (continua == false) {
          throw new GestoreException("Errore inaspettato durante l'operazione di migrazione ", null);
        }
        
      }
    }
    
    // E' terminata la fase di migrazione delle gara.
    // Si puo' terminare la procedura.
    mb.resetGaraInElaborazione();
    
    if (logger.isDebugEnabled()) {
      logger.debug("updateStazioneAppaltante: fine metodo");
    }
    
    return continua;
  }

  private void copiaValori(DataColumnContainer dcc) throws GestoreException {
    HashMap<String, DataColumn> hm = dcc.getColonne();
    Set<String> set = hm.keySet();
    Iterator<String> iter = set.iterator();
    while(iter.hasNext()) {
      String tmp = iter.next();
      dcc.setValue(tmp, dcc.getColumn(tmp).getOriginalValue().getValue());
      dcc.getColumn(tmp).setObjectOriginalValue(null);
    }
  }

  /**
   * Valorizzazione di codiceGara, IdAvGara, Oggetto, codici CIG in SA e codici CIG da Simog
   * nell'oggetto GaraSABean passato come argomento del metodo stesso.
   * 
   * @param codiceGara
   * @param garaSaBean
   * @throws SQLException
   */
  private GaraSABean getDatiGara(Long codiceGara) throws SQLException {
    Vector< ? > datiGara = this.sqlManager.getVector(
        "select g.IDAVGARA, g.OGGETTO, g.CODEIN, u.CFEIN from W9GARA g, UFFINT u " +
        " where g.CODGARA=? and g.CODEIN=u.CODEIN",
        new Object[] { codiceGara } );

    GaraSABean garaSaBean = new GaraSABean(codiceGara);
    garaSaBean.setIdAvGara(SqlManager.getValueFromVectorParam(datiGara, 0).getStringValue());
    garaSaBean.setOggettoGara(SqlManager.getValueFromVectorParam(datiGara, 1).getStringValue());
    garaSaBean.setCodeinOrigine(SqlManager.getValueFromVectorParam(datiGara, 2).getStringValue());
    garaSaBean.setCfsaOrigine(SqlManager.getValueFromVectorParam(datiGara, 3).getStringValue());
    
    List< ? > listaCodiciCIG =  this.sqlManager.getListVector(
        "select CIG from W9LOTT where CODGARA=? order by CODLOTT asc",
        new Object[] { codiceGara } );
    
    if (listaCodiciCIG != null && listaCodiciCIG.size() > 0) {
      String[] arrayCodiciCig = new String[listaCodiciCIG.size()];
      
      for (int i=0; i < listaCodiciCIG.size(); i++) {
        Vector< ? > riga = (Vector< ? >)listaCodiciCIG.get(i);
        arrayCodiciCig[i] = SqlManager.getValueFromVectorParam(riga, 0).getStringValue();
      }
      garaSaBean.setCodiciCig(arrayCodiciCig);
    }
    
    return garaSaBean;
  }
  
}
