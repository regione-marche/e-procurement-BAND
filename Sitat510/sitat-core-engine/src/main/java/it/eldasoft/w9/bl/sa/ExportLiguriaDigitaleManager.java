package it.eldasoft.w9.bl.sa;

import it.eldasoft.commons.beans.ResultBean;
import it.eldasoft.gene.bl.GenChiaviManager;
import it.eldasoft.gene.bl.SqlManager;
import it.eldasoft.gene.commons.web.domain.ProfiloUtente;
import it.eldasoft.utils.properties.ConfigManager;
import it.eldasoft.w9.common.CostantiW9;
import it.eldasoft.w9.dao.ibatis.SqlMapExportLiguriaDigitaleDao;
import it.eldasoft.w9.dao.vo.ImpresaAggiudicataria;
import it.eldasoft.w9.utils.UtilitySITAT;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.AppaltiLiguriaWebServiceProxy;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.CheckFaultBean;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Aggiudicatario;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CPVSecondari;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Categorie;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Condizioni;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Contratto;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAccordo;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicazione;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAvanzamento;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiCollaudo;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiComuni;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiComuniEstesi;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiConclusione;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiEnte;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiGeneraliContratto;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiInizio;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiLegaleRappresentante;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiRecesso;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiResponsabile;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSospensione;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSubappalto;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiVariante;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Finanziamenti;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagCollaudatoreType;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.MotiviVariante;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Offerente;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Pubblicazione;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneAccordiBonari;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneAggiudicazione;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneCollaudo;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneConclusione;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneInizio;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneRitardiRecessi;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSAL;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSospensioni;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSubappalti;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneVarianti;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipologiaFS;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipologiaL;

import java.io.ByteArrayOutputStream;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * Manager per l'esportazione dei dati della gara verso Liguria Digitale.
 * 
 * @author Luca.Giacomazzo
 */
public class ExportLiguriaDigitaleManager {

  /** Logger. */
  static Logger logger = Logger.getLogger(ExportLiguriaDigitaleManager.class);
  
  private SqlManager sqlManager;
  
  private GenChiaviManager genChiaviManager;
  
  private SqlMapExportLiguriaDigitaleDao sqlMapExportLiguriaDigitaleDao;
  
  public void setSqlManager(SqlManager sqlManager) {
    this.sqlManager = sqlManager;
  }
  
  public SqlManager getSqlManager() {
    return this.sqlManager;
  }
  
  public void setGenChiaviManager(GenChiaviManager genChiaviManager) {
    this.genChiaviManager = genChiaviManager;
  }
  
  public void setSqlMapExportLiguriaDigitaleDao(SqlMapExportLiguriaDigitaleDao sqlMapExportLiguriaDigitaleDao) {
    this.sqlMapExportLiguriaDigitaleDao = sqlMapExportLiguriaDigitaleDao;
  }
  
  public ResultBean exportXml(long codiceGara, long codiceLotto, ProfiloUtente profiloUtente) throws SQLException {
  
    if (logger.isDebugEnabled()) {
      logger.debug("exportXml: inizio metodo");
    }
    
    String codiceCIG = UtilitySITAT.getCIGLotto(codiceGara, codiceLotto, this.sqlManager);
    
    ResultBean result = new ResultBean();
    result.setOk(Boolean.TRUE);
    
    String urlServizio = ConfigManager.getValore("it.eldasoft.appaltiLiguria.wsUrl");
    String nomeHttpHeaderToken = ConfigManager.getValore("it.eldasoft.appaltiLiguria.httpHeader.tokenName");
    String valoreHttpHeaderToken = ConfigManager.getValore("it.eldasoft.appaltiLiguria.httpHeader.tokenValue");
    String codiceFiscaleEnte = ConfigManager.getValore("it.eldasoft.appaltiLiguria.datiEnte.codiceFiscale");
    String idUserEnte = ConfigManager.getValore("it.eldasoft.appaltiLiguria.datiEnte.idUserEnte");
    
    if (StringUtils.isNotEmpty(urlServizio)
          && StringUtils.isNotEmpty(nomeHttpHeaderToken)
            && StringUtils.isNotEmpty(valoreHttpHeaderToken)
              && StringUtils.isNotEmpty(codiceFiscaleEnte)
                && StringUtils.isNotEmpty(idUserEnte)) {
      
      // Valorizzazione dell'oggetto contratto per il lotto indicato con tutte le
      // sezioni possibili, cioe' se esistono i dati nella base dati
      Contratto contratto = new Contratto();
      DatiEnte datiEnte = new DatiEnte();
      datiEnte.setCODICE_FISCALE(codiceFiscaleEnte);
      datiEnte.setID_USER_ENTE(idUserEnte);
      contratto.setDATI_ENTE(datiEnte);
      
      DatiGeneraliContratto datiGeneraliContratto = new DatiGeneraliContratto();
      datiGeneraliContratto.setCONTROLLO_INVIO("1");
      HashMap<String,Long> hmParam = new HashMap<String,Long>();
      hmParam.put("codiceGara", codiceGara);
      hmParam.put("codiceLotto", codiceLotto);
      
      this.setDatiComuni(hmParam, datiGeneraliContratto);
      this.setDatiComuniEstesi(hmParam, datiGeneraliContratto);
      this.setListaOfferenti(hmParam, datiGeneraliContratto);
      this.setSezioneAggiudicazione(hmParam, datiGeneraliContratto);
      this.setSezioneInizio(hmParam, datiGeneraliContratto);
      this.setSezioneSAL(hmParam, datiGeneraliContratto);
      this.setSezioneVarianti(hmParam, datiGeneraliContratto);
      this.setSezioneSospensioni(hmParam, datiGeneraliContratto);
      this.setSezioneConclusione(hmParam, datiGeneraliContratto);
      this.setSezioneCollaudo(hmParam, datiGeneraliContratto);
      this.setSezioneSubappalti(hmParam, datiGeneraliContratto);
      this.setSezioneRitardiRecessi(hmParam, datiGeneraliContratto);
      this.setSezioneAccordiBonari(hmParam, datiGeneraliContratto);
      contratto.setDATI_GENERALI_CONTRATTO(datiGeneraliContratto);
      
      String contrattoXml = null;
      
      try {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        JAXBContext context = JAXBContext.newInstance(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Contratto.class);                                             
        Marshaller marshaller = context.createMarshaller();                                   
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);                                           
        marshaller.marshal(contratto, baos);
        
        if (baos != null && baos.size() > 0) {
          contrattoXml = baos.toString();
        }
        
      } catch (PropertyException pe) {
        logger.error("Errore nella creazione del XMl dell'oggetto contratto da inviare a Liguria Digitale", pe);
      } catch (JAXBException je) {
        logger.error("Errore nella creazione del XMl dell'oggetto contratto da inviare a Liguria Digitale", je);
      } 
      
      if (StringUtils.isNotEmpty(contrattoXml)) {
        logger.debug("Contratto in invio a Liguria Digitale:\n" + contrattoXml );
      }
      
      try {
        // Invio del contratto
        AppaltiLiguriaWebServiceProxy proxy = new AppaltiLiguriaWebServiceProxy(urlServizio);
        String rispostaWs = proxy.invioContratto(contratto);
        
        if (StringUtils.isNotEmpty(rispostaWs)) {
          if (StringUtils.contains(rispostaWs, "ERR_") || StringUtils.contains(rispostaWs, "SAL/VARIANTI/SOSPENSIONI/CONTENSIOSI")) {
            logger.error("L'invio dei dati del lotto con CIG = " + codiceCIG
                + " e' terminato con errore. Questo il messaggio di ritorno dal servizio: "
                + rispostaWs
                + " (Riferimento al lotto: CODGARA=" + codiceGara + ", CODLOTT=" + codiceLotto 
                + ". Rifermiento all'utente esecutore: SYSCON=" + profiloUtente.getId() + ")" );
            result.setOk(Boolean.FALSE);
            result.setMessaggi(new String[] { "" });
          }
        }
        
        // Creazione del record in W9FLUSSI
        synchronized (contratto) {
          int w9FlussiId = this.genChiaviManager.getNextId("W9FLUSSI");
          
          this.sqlManager.update("insert into W9FLUSSI (IDFLUSSO,AREA,KEY01,KEY02,TINVIO2,DATINV,XML,CFSA,CODOGG,CODCOMP,AUTORE) values (?,?,?,?,?,?,?,?,?,?,?)",
              new Object[] { w9FlussiId, 1, codiceGara, codiceLotto, 1, new Timestamp(new GregorianCalendar().getTimeInMillis()),  
              contrattoXml, codiceFiscaleEnte, codiceCIG, profiloUtente.getId(), profiloUtente.getNome() });
        }
        
      } catch (CheckFaultBean cfb) {
        StringBuffer strBuffer = new StringBuffer("Errore inaspettato durante l'interazione con il servizio");
        if (StringUtils.isNotEmpty(cfb.getMessage1())) {
          strBuffer.append(". Message: ");
          strBuffer.append(cfb.getMessage1());
        }
        logger.error(strBuffer.toString(), cfb);

        result.setOk(Boolean.FALSE);
        result.setMessaggi(new String[] { cfb.getMessage1() });
        
      } catch (it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.JAXBException je) {
        StringBuffer strBuffer = new StringBuffer("Errore inaspettato durante l'interazione con il servizio");
        if (StringUtils.isNotEmpty(je.getMessage())) {
          strBuffer.append(". Message: ");
          strBuffer.append(je.getMessage());
        }
        logger.error(strBuffer.toString(), je);

        result.setOk(Boolean.FALSE);
        result.setMessaggi(new String[] { je.getMessage() });
        
      } catch (RemoteException re) {
        logger.error("Errore remoto inaspettato durante l'interazione con il servizio", re);
        
        result.setOk(Boolean.FALSE);
        String str = "Errore remoto inaspettato durante l'invio dei dati";
        if (StringUtils.isNotEmpty(re.getLocalizedMessage())) {
          str = str.concat(" (".concat(re.getLocalizedMessage()).concat(")"));
        } else if (StringUtils.isNotEmpty(re.getMessage())) {
          str = str.concat(" (".concat(re.getMessage()).concat(")"));
        }
        result.setMessaggi(new String[] { str });
      }

    } else {
      logger.error("Valorizzare tutte le properties della sezione 'Comune di Genova - Osservatorio Regione Liguria'");
      
      result.setOk(Boolean.FALSE);
      result.setMessaggi(new String[] { "Configurazione per la connessione all'Osservatorio Regionale incompleta. " });
    }
    
    if (logger.isDebugEnabled()) {
      logger.debug("exportXml: fine metodo");
    }
    
    return result;
  }
  
  /**
   * Ritorna il numero di fasi presenti nella W9FASI per il lotto.
   * 
   * @param codiceGara
   * @param codiceLotto
   * @param faseEsecuzione
   * @return Ritorna il numero di fasi presenti nella W9FASI
   * @throws SQLException
   */
  private long getNumeroFasi(long codiceGara, long codiceLotto, int faseEsecuzione) throws SQLException {
    Long result = (Long) this.sqlManager.getObject(
        "select count(*) from W9FASI where CODGARA=? and CODLOTT=? and FASE_ESECUZIONE=?",
        new Object[] { codiceGara, codiceLotto, faseEsecuzione } ); 
    if (result != null) {
      return result.longValue();
    } else {
      return 0L;
    }
  }
  
  /**
   * Valorizzazione dell'oggetto DatiComuni che contiene i dati dell'anagrafica di gara.
   * 
   * @param codiceGara
   * @param codiceLotto
   * @param datiGeneraliContratto
   * @throws SQLException
   */
  private void setDatiComuni(HashMap<String,Long> hmParam, DatiGeneraliContratto datiGeneraliContratto) {
    
    if (logger.isDebugEnabled()) {
      logger.debug("setDatiComuni: inizio metodo");
    }

    DatiComuni datiComuni = this.sqlMapExportLiguriaDigitaleDao.getDatiComuni(hmParam);
    if (datiComuni != null) {
      datiGeneraliContratto.setDATI_COMUNI(datiComuni);
    }
    
    if (logger.isDebugEnabled()) {
      logger.debug("setDatiComuni: fine metodo");
    }
  }
  
  /**
   * Valorizzazione dell'oggetto DatiComuniEstesi che contiene i dati dell'anagrafica del lotto.
   * 
   * @param codiceGara
   * @param codiceLotto
   * @param datiGeneraliContratto
   * @throws SQLException
   */
  private void setDatiComuniEstesi(HashMap<String,Long> hmParam, DatiGeneraliContratto datiGeneraliContratto) throws SQLException {
    
    if (logger.isDebugEnabled()) {
      logger.debug("setDatiComuniEstesi: inizio metodo");
    }

    DatiComuniEstesi datiComuniEstesi = this.sqlMapExportLiguriaDigitaleDao.getDatiComuniEstesi(hmParam);
    if (datiComuniEstesi != null) {

      Long codiceGara = hmParam.get("codiceGara");
      Long codiceLotto = hmParam.get("codiceLotto");
      
      String codiceRUP = (String) this.sqlManager.getObject("select RUP from W9LOTT where CODGARA=? and CODLOTT=?",
          new Object[] { codiceGara, codiceLotto } );
      
      if (StringUtils.isNotEmpty(codiceRUP)) {
        DatiResponsabile datiResponsabile = this.sqlMapExportLiguriaDigitaleDao.getDatiResponsabile(codiceRUP);
        datiResponsabile.setALBO_PROFESSIONALE(FlagSNType.N);
        datiComuniEstesi.setResponsabile(datiResponsabile);
      }

      // Valorizzazione lista tipologia forniture sevizi
      List<Long> listaTipologiaFornitureServizi = 
        this.sqlMapExportLiguriaDigitaleDao.getListaTipologiaFornitureServizi(hmParam);
      if (listaTipologiaFornitureServizi != null && listaTipologiaFornitureServizi.size() > 0) {
        List<TipologiaFS> listaTipoligiaFS = new ArrayList<TipologiaFS>();
        for (int i=0; i < listaTipologiaFornitureServizi.size(); i++) {
          Long tmp = listaTipologiaFornitureServizi.get(i);
          if (tmp != null) {
            listaTipoligiaFS.add(new TipologiaFS(tmp.toString()));
          }
        }
        datiComuniEstesi.setListaId_TipologiaFS(listaTipoligiaFS.toArray(new TipologiaFS[0]));
      }
      
      // Valorizzazione lista tipologia lavori
      List<Long> listaTipologiaLavoriDb = 
        this.sqlMapExportLiguriaDigitaleDao.getListaTipologiaLavori(hmParam);
      if (listaTipologiaLavoriDb != null && listaTipologiaLavoriDb.size() > 0) {
        List<TipologiaL> listaTipoligiaL = new ArrayList<TipologiaL>();
        for (int i=0; i < listaTipologiaLavoriDb.size(); i++) {
          Long tmp = listaTipologiaLavoriDb.get(i);
          if (tmp != null) {
            listaTipoligiaL.add(new TipologiaL(tmp.toString()));
          }
        }
        datiComuniEstesi.setListaId_TipologiaL(listaTipoligiaL.toArray(new TipologiaL[0]));
      }

      // Valorizzazione lista condizioni
      List<Long> listaCondizioniDb = 
        this.sqlMapExportLiguriaDigitaleDao.getListaCondizioni(hmParam);
      if (listaCondizioniDb != null && listaCondizioniDb.size() > 0) {
        List<Condizioni> listaCondizioni = new ArrayList<Condizioni>();
        for (int i=0; i < listaCondizioniDb.size(); i++) {
          Long tmp = listaCondizioniDb.get(i);
          if (tmp != null) {
            listaCondizioni.add(new Condizioni(tmp.toString()));
          }
        }
        datiComuniEstesi.setListaID_Condizioni(listaCondizioni.toArray(new Condizioni[0]));
      }
      
      // Valorizzazione lista cpv secondari
      List<String> listaCpvSecondariDb = 
        this.sqlMapExportLiguriaDigitaleDao.getListaCpvSecondari(hmParam);
      if (listaCpvSecondariDb != null && listaCpvSecondariDb.size() > 0) {
        List<CPVSecondari> listaCpvSecondari = new ArrayList<CPVSecondari>();
        for (int i=0; i < listaCpvSecondariDb.size(); i++) {
          listaCpvSecondari.add(new CPVSecondari(listaCpvSecondariDb.get(i)));
        }
        datiComuniEstesi.setListaID_CPVSecondari(listaCpvSecondari.toArray(new CPVSecondari[0]));
      }

    }

    // Lista degli incarichi professionali
    List<DatiSoggettiEstesi> listaDatiSoggettiEstesiDb =
        this.sqlMapExportLiguriaDigitaleDao.getDatiSoggettiEstesi(hmParam);
    if (listaDatiSoggettiEstesiDb != null && listaDatiSoggettiEstesiDb.size() > 0) {
      datiComuniEstesi.setListaDatiSoggettiEstesi(listaDatiSoggettiEstesiDb.toArray(new DatiSoggettiEstesi[0]));
    }

    List<String> listaCodiceTecniciSoggettiEstesi = 
        this.sqlMapExportLiguriaDigitaleDao.getCodiceTecniciSoggettiEstesi(hmParam);
    if (listaCodiceTecniciSoggettiEstesi != null && listaCodiceTecniciSoggettiEstesi.size() > 0) {
      for (int i=0; i < listaCodiceTecniciSoggettiEstesi.size(); i++) {
        String codiceTecnico = listaCodiceTecniciSoggettiEstesi.get(i);
        if (StringUtils.isNotEmpty(codiceTecnico)) {
          DatiResponsabile datiResponsabile = this.sqlMapExportLiguriaDigitaleDao.getDatiResponsabile(codiceTecnico);
          if (datiResponsabile != null) {
            datiComuniEstesi.getListaDatiSoggettiEstesi(i).setResponsabile(datiResponsabile);
          }
        }
      }
    }
    datiGeneraliContratto.setDATI_COMUNI_ESTESI(datiComuniEstesi);
    
    if (logger.isDebugEnabled()) {
      logger.debug("setDatiComuniEstesi: fine metodo");
    }
  }
  
  /**
   * Valorizzazione della lista degli offerenti, che in Sitat e' rappresentata
   * dalla lista delle imprese partecipanti.
   *  
   * @param codiceGara
   * @param codiceLotto
   * @param datiGeneraliContratto
   * @throws SQLException
   */
  private void setListaOfferenti(HashMap<String,Long> hmParam, DatiGeneraliContratto datiGeneraliContratto) {

    if (logger.isDebugEnabled()) {
      logger.debug("setListaOfferenti: inizio metodo");
    }
    
    List<Offerente> listaOfferentiDb = this.sqlMapExportLiguriaDigitaleDao.getListaOfferenti(hmParam);
    if (listaOfferentiDb != null && listaOfferentiDb.size() > 0) {
      datiGeneraliContratto.setLISTA_OFFERENTI(listaOfferentiDb.toArray(new Offerente[0]));
    }
    
    List<String> listaCodiceImpresaListaOfferenti = 
      this.sqlMapExportLiguriaDigitaleDao.getCodiceImpreseListaOfferenti(hmParam);
    
    if (listaCodiceImpresaListaOfferenti != null && listaCodiceImpresaListaOfferenti.size() > 0) {
      for (int i=0; i < listaCodiceImpresaListaOfferenti.size(); i++) {
        String codiceImpresa = listaCodiceImpresaListaOfferenti.get(i);
        DatiAggiudicatari datiAggiudicatario =
            this.sqlMapExportLiguriaDigitaleDao.getDatiAggiudicatario(codiceImpresa);
        
        DatiLegaleRappresentante legaleRappresentanteDb = 
            this.sqlMapExportLiguriaDigitaleDao.getDatiLegaleRappresentante(codiceImpresa);
        if (legaleRappresentanteDb != null) {
          datiAggiudicatario.setListaLegaleRappresentante(new DatiLegaleRappresentante[] { legaleRappresentanteDb });
        }
        if (datiAggiudicatario != null) {
          datiGeneraliContratto.getLISTA_OFFERENTI()[i].setAggiudicatario(datiAggiudicatario);
        }
      }
    }
    
    if (logger.isDebugEnabled()) {
      logger.debug("setListaOfferenti: fine metodo");
    }
  }
    
  /**
   * 
   * @param codiceGara
   * @param codiceLotto
   * @param datiGeneraliContratto
   * @throws SQLException
   */
  private void setSezioneAggiudicazione(HashMap<String,Long> hmParam, DatiGeneraliContratto datiGeneraliContratto) throws SQLException {
    
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneAggiudicazione: inizio metodo");
    }
    
    Long codiceGara = (Long) hmParam.get("codiceGara");
    Long codiceLotto = (Long) hmParam.get("codiceLotto");
    
    long numeroAggiudicazione = this.getNumeroFasi(codiceGara, codiceLotto, CostantiW9.AGGIUDICAZIONE_SOPRA_SOGLIA) + 
        this.getNumeroFasi(codiceGara, codiceLotto, CostantiW9.FASE_SEMPLIFICATA_AGGIUDICAZIONE) +
        this.getNumeroFasi(codiceGara, codiceLotto, CostantiW9.ADESIONE_ACCORDO_QUADRO);
    
    if (numeroAggiudicazione > 0) {
      DatiAggiudicazione datiAggiudicazione = this.sqlMapExportLiguriaDigitaleDao.getDatiAggiudicazione(hmParam);
      if (datiAggiudicazione != null) {
        SezioneAggiudicazione sezioneAggiudicazione = new SezioneAggiudicazione();
        sezioneAggiudicazione.setDATI_AGGIUDICAZIONE(datiAggiudicazione);
        
        List<Finanziamenti> listaFinanziamentiDb = this.sqlMapExportLiguriaDigitaleDao.getListaFinanziamenti(hmParam);
        if (listaFinanziamentiDb != null && listaFinanziamentiDb.size() > 0) {
          sezioneAggiudicazione.setLISTA_FINANZIAMENTI(listaFinanziamentiDb.toArray(new Finanziamenti[0]));
        }
        List<Categorie> listaCategorieDb = this.sqlMapExportLiguriaDigitaleDao.getListaCategorie(hmParam);
        if (listaCategorieDb != null && listaCategorieDb.size() > 0) {
          sezioneAggiudicazione.setLISTA_CATEGORIE(listaCategorieDb.toArray(new Categorie[0]));
        }

        List<ImpresaAggiudicataria> listaCampiChiaveAggiudicatariDb =
            this.sqlMapExportLiguriaDigitaleDao.getListaCampiAggiudicatari(hmParam);
        if (listaCampiChiaveAggiudicatariDb != null && listaCampiChiaveAggiudicatariDb.size() > 0) {
          
          List<Aggiudicatario> listaAggiudicatari = new ArrayList<Aggiudicatario>();
          for (int i=0; i < listaCampiChiaveAggiudicatariDb.size(); i++) {
            ImpresaAggiudicataria campiImpresaAggiudicataria = listaCampiChiaveAggiudicatariDb.get(i);
            hmParam.put("numAppalto", campiImpresaAggiudicataria.getNumAppalto());
            hmParam.put("numeroAggiudicataria", campiImpresaAggiudicataria.getNumeroAggiudicataria());
            
            Aggiudicatario aggiudicatario =  this.sqlMapExportLiguriaDigitaleDao.getAggiudicatario(hmParam);
            if (StringUtils.isNotEmpty(campiImpresaAggiudicataria.getCodiceImpresa())) {
              DatiAggiudicatari datiAggiudicatario = this.sqlMapExportLiguriaDigitaleDao.getDatiAggiudicatario(
                  campiImpresaAggiudicataria.getCodiceImpresa());
              if (datiAggiudicatario != null) {
                DatiLegaleRappresentante legaleRappresentante = this.sqlMapExportLiguriaDigitaleDao.getDatiLegaleRappresentante(
                    campiImpresaAggiudicataria.getCodiceImpresa());
                if (legaleRappresentante != null) {
                  datiAggiudicatario.setListaLegaleRappresentante(new DatiLegaleRappresentante[] { legaleRappresentante } ); 
                }
                aggiudicatario.setAggiudicatario(datiAggiudicatario);
              }
            }
            
            if (StringUtils.isNotEmpty(campiImpresaAggiudicataria.getCodiceImpresaAusiliaria())) {
              DatiAggiudicatari datiAggiudicatarioAusiliario = this.sqlMapExportLiguriaDigitaleDao.getDatiAggiudicatario(
                  campiImpresaAggiudicataria.getCodiceImpresaAusiliaria());
              if (datiAggiudicatarioAusiliario != null) {
                DatiLegaleRappresentante legaleRappresentanteAvv = this.sqlMapExportLiguriaDigitaleDao.getDatiLegaleRappresentante(
                    campiImpresaAggiudicataria.getCodiceImpresaAusiliaria());
                if (legaleRappresentanteAvv != null) {
                  datiAggiudicatarioAusiliario.setListaLegaleRappresentante(new DatiLegaleRappresentante[] { legaleRappresentanteAvv} ); 
                }
                aggiudicatario.setAggiudicatario_avv(datiAggiudicatarioAusiliario);
              }
            }
            listaAggiudicatari.add(aggiudicatario);
          }

          if (listaAggiudicatari != null && listaAggiudicatari.size() > 0) {
            sezioneAggiudicazione.setLISTA_AGGIUDICATARI(listaAggiudicatari.toArray(new Aggiudicatario[0]));
          }
        }

        // Lista degli incarichi professionali
        List<DatiSoggettiEstesi> listaDatiSoggettiEstesiDb =
            this.sqlMapExportLiguriaDigitaleDao.getDatiSoggettiEstesiAggiudicazione(hmParam);
        if (listaDatiSoggettiEstesiDb != null && listaDatiSoggettiEstesiDb.size() > 0) {
          sezioneAggiudicazione.setLISTA_DATI_SOGGETTI_ESTESI_AGG(    
              listaDatiSoggettiEstesiDb.toArray(new DatiSoggettiEstesi[0]));
        }

        List<String> listaCodiceTecniciSoggettiEstesi = 
            this.sqlMapExportLiguriaDigitaleDao.getCodiceTecniciSoggettiEstesiAggiudicazione(hmParam);
        if (listaCodiceTecniciSoggettiEstesi != null && listaCodiceTecniciSoggettiEstesi.size() > 0) {
          for (int i=0; i < listaCodiceTecniciSoggettiEstesi.size(); i++) {
            String codiceTecnico = listaCodiceTecniciSoggettiEstesi.get(i);
            if (StringUtils.isNotEmpty(codiceTecnico)) {
              DatiResponsabile datiResponsabileDb = this.sqlMapExportLiguriaDigitaleDao.getDatiResponsabile(codiceTecnico);
              if (datiResponsabileDb != null) {
                sezioneAggiudicazione.getLISTA_DATI_SOGGETTI_ESTESI_AGG()[i].setResponsabile(datiResponsabileDb);
              }
            }
          }
        }
        
        Pubblicazione pubblicazione = this.sqlMapExportLiguriaDigitaleDao.getPubblicazione(hmParam);
        if (pubblicazione != null) {
          sezioneAggiudicazione.setPUBBLICAZIONE_AGGIUDICAZIONE(pubblicazione);
        } else {
          pubblicazione = new Pubblicazione();
          pubblicazione.setPROFILO_COMMITTENTE(FlagSNType.fromString("N"));
          pubblicazione.setSITO_MINISTERO_INF_TRASP(FlagSNType.fromString("N"));
          pubblicazione.setSITO_OSSERVATORIO_CP(FlagSNType.fromString("N"));
          sezioneAggiudicazione.setPUBBLICAZIONE_AGGIUDICAZIONE(pubblicazione);
        }
        datiGeneraliContratto.setSEZIONE_AGGIUDICAZIONE(sezioneAggiudicazione);
      }
    }
    
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneAggiudicazione: fine metodo");
    }
  }
  
  private void setSezioneInizio(HashMap<String,Long> hmParam, DatiGeneraliContratto datiGeneraliContratto) throws SQLException {
    
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneInizio: inizio metodo");
    }
    
    Long codiceGara = (Long) hmParam.get("codiceGara");
    Long codiceLotto = (Long) hmParam.get("codiceLotto");
    
    long numeroInizio = this.getNumeroFasi(codiceGara, codiceLotto, CostantiW9.INIZIO_CONTRATTO_SOPRA_SOGLIA) + 
        this.getNumeroFasi(codiceGara, codiceLotto, CostantiW9.FASE_SEMPLIFICATA_INIZIO_CONTRATTO) +
        this.getNumeroFasi(codiceGara, codiceLotto, CostantiW9.STIPULA_ACCORDO_QUADRO);
    
    if (numeroInizio > 0) {
      SezioneInizio sezioneInizio = new SezioneInizio();
      DatiInizio datiInizio = this.sqlMapExportLiguriaDigitaleDao.getDatiInizio(hmParam);
      if (datiInizio != null) {
        sezioneInizio.setDATI_INIZIO(datiInizio);
      }
      Pubblicazione pubblicazioneInizio = this.sqlMapExportLiguriaDigitaleDao.getPubblicazione(hmParam);
      if (pubblicazioneInizio != null) {
        sezioneInizio.setPUBBLICAZIONE_INIZIO(pubblicazioneInizio);
      }
      
      List<DatiSoggettiEstesi> listaDatiSoggettiEsetesiDb = this.sqlMapExportLiguriaDigitaleDao.getDatiSoggettiEstesiInizio(hmParam);
      if (listaDatiSoggettiEsetesiDb != null && listaDatiSoggettiEsetesiDb.size() > 0) {
        sezioneInizio.setLISTA_DATI_SOGGETTI_ESTESI_INIZIO(listaDatiSoggettiEsetesiDb.toArray(new DatiSoggettiEstesi[0]));
      
        List<String> listaCodiceTecniciSoggettiEsetesi = this.sqlMapExportLiguriaDigitaleDao.getCodiceTecniciSoggettiEstesiInizio(hmParam);
        if (listaCodiceTecniciSoggettiEsetesi != null && listaCodiceTecniciSoggettiEsetesi.size() > 0) {
          for (int i=0; i < listaCodiceTecniciSoggettiEsetesi.size(); i++) {
            String codiceTecnico = listaCodiceTecniciSoggettiEsetesi.get(i);
            if (StringUtils.isNotEmpty(codiceTecnico)) {
              DatiResponsabile datiResponsabile = this.sqlMapExportLiguriaDigitaleDao.getDatiResponsabile(codiceTecnico);
              if (datiResponsabile != null) {
                sezioneInizio.getLISTA_DATI_SOGGETTI_ESTESI_INIZIO()[i].setResponsabile(datiResponsabile);
              }
            }
          }
        }
      }
      datiGeneraliContratto.setSEZIONE_INIZIO(sezioneInizio);
    }
    
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneInizio: fine metodo");
    }
  }
  
  private void setSezioneSAL(HashMap<String,Long> hmParam, DatiGeneraliContratto datiGeneraliContratto) throws SQLException {
    
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneSAL: inizio metodo");
    }
    
    Long codiceGara = (Long) hmParam.get("codiceGara");
    Long codiceLotto = (Long) hmParam.get("codiceLotto");
    
    // Se esiste almeno un SAL
    long numeroSAL = this.getNumeroFasi(codiceGara, codiceLotto, CostantiW9.AVANZAMENTO_CONTRATTO_SOPRA_SOGLIA) + 
        this.getNumeroFasi(codiceGara, codiceLotto, CostantiW9.AVANZAMENTO_CONTRATTO_APPALTO_SEMPLIFICATO);
    
    if (numeroSAL > 0) {
      SezioneSAL sezioneSAL = new SezioneSAL();
      List<DatiAvanzamento> listaAvanzamentiDb = this.sqlMapExportLiguriaDigitaleDao.getListaDatiAvanzamento(hmParam);
      if (listaAvanzamentiDb != null && listaAvanzamentiDb.size() > 0) {
        sezioneSAL.setDATI_SAL(listaAvanzamentiDb.toArray(new DatiAvanzamento[0]));
      }
      datiGeneraliContratto.setSEZIONE_SAL(sezioneSAL);
    }
    
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneSAL: fine metodo");
    }
  }
  
  private void setSezioneVarianti(HashMap<String,Long> hmParam, DatiGeneraliContratto datiGeneraliContratto) throws SQLException {
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneVarianti: inizio metodo");
    }
    
    SezioneVarianti sezioneVarianti = null;
    
    Long codiceGara = (Long) hmParam.get("codiceGara");
    Long codiceLotto = (Long) hmParam.get("codiceLotto");
    
    // Se esiste almeno una variante
    long numeroVarianti = this.getNumeroFasi(codiceGara, codiceLotto, CostantiW9.VARIANTE_CONTRATTO);
    if (numeroVarianti > 0) {
      List<Long> listaProgressivoVarianti = this.sqlMapExportLiguriaDigitaleDao.getListaCampiChiaveVarianti(hmParam);
      if (listaProgressivoVarianti != null && listaProgressivoVarianti.size() > 0) {
        DatiVariante[] arrayDatiVariante = new DatiVariante[listaProgressivoVarianti.size()];
        for (int i=0; i < listaProgressivoVarianti.size(); i++) {
          hmParam.put("numeroVariante", listaProgressivoVarianti.get(i));
          DatiVariante datiVariante = this.sqlMapExportLiguriaDigitaleDao.getDatiVarianti(hmParam);
          List<String> listaMotiviVarianteDb = this.sqlMapExportLiguriaDigitaleDao.getListaMotiviVariante(hmParam);
          if (listaMotiviVarianteDb != null && listaMotiviVarianteDb.size() > 0) {
            // Come indicato dal Manuale di riferimento, WS accetta solo un motivo.
            // Arbitrariamente viene passato il primo.
            MotiviVariante[] arrayMotiviVariante = new MotiviVariante[] {new MotiviVariante(listaMotiviVarianteDb.get(0))};
            datiVariante.setLISTA_MOTIVI_VARIANTE(arrayMotiviVariante);
          }
          arrayDatiVariante[i] = datiVariante;
        }
        sezioneVarianti = new SezioneVarianti(arrayDatiVariante);
        datiGeneraliContratto.setSEZIONE_VARIANTI(sezioneVarianti);
      }
    }
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneVarianti: fine metodo");
    }
  }
  
  private void setSezioneSospensioni(HashMap<String,Long> hmParam, DatiGeneraliContratto datiGeneraliContratto) throws SQLException {
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneSospensioni: inizio metodo");
    }
    
    Long codiceGara = (Long) hmParam.get("codiceGara");
    Long codiceLotto = (Long) hmParam.get("codiceLotto");
    
    // Se esiste almeno una sospensione
    long numeroSospensioni = this.getNumeroFasi(codiceGara, codiceLotto, CostantiW9.SOSPENSIONE_CONTRATTO);
    if (numeroSospensioni > 0) {
      List<DatiSospensione> listaDatiSospensioniDb = 
          this.sqlMapExportLiguriaDigitaleDao.getListaDatiSospensioni(hmParam);
      if (listaDatiSospensioniDb != null && listaDatiSospensioniDb.size() > 0) {
        SezioneSospensioni sezioneSospensioni = new SezioneSospensioni();
        sezioneSospensioni.setDATI_SOSPENSIONI(listaDatiSospensioniDb.toArray(new DatiSospensione[0]));
        datiGeneraliContratto.setSEZIONE_SOSPENSIONI(sezioneSospensioni);
      }
    }
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneSospensioni: fine metodo");
    }
  }

  private void setSezioneConclusione(HashMap<String,Long> hmParam, DatiGeneraliContratto datiGeneraliContratto) throws SQLException {
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneConclusione: inizio metodo");
    }
    
    Long codiceGara = (Long) hmParam.get("codiceGara");
    Long codiceLotto = (Long) hmParam.get("codiceLotto");
    
    // Se esiste almeno un tipo di conclusione
    long numeroConclusioni = this.getNumeroFasi(codiceGara, codiceLotto, CostantiW9.CONCLUSIONE_CONTRATTO_SOPRA_SOGLIA) + 
        this.getNumeroFasi(codiceGara, codiceLotto, CostantiW9.FASE_SEMPLIFICATA_CONCLUSIONE_CONTRATTO);
    if (numeroConclusioni > 0) {
      SezioneConclusione sezioneConclusione = new SezioneConclusione();
      DatiConclusione datiConclusione = this.sqlMapExportLiguriaDigitaleDao.getDatiConclusione(hmParam);
      if (datiConclusione != null) {
        sezioneConclusione.setDATI_CONCLUSIONE(datiConclusione);
        datiGeneraliContratto.setSEZIONE_CONCLUSIONE(sezioneConclusione);
      }
    }
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneConclusione: fine metodo");
    }
  }

  private void setSezioneCollaudo(HashMap<String,Long> hmParam, DatiGeneraliContratto datiGeneraliContratto) throws SQLException {
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneCollaudo: inizio metodo");
    }
    
    Long codiceGara = (Long) hmParam.get("codiceGara");
    Long codiceLotto = (Long) hmParam.get("codiceLotto");
    
    // Se esiste almeno un tipo di conclusione
    long numeroCollaudo = this.getNumeroFasi(codiceGara, codiceLotto, CostantiW9.COLLAUDO_CONTRATTO);
    if (numeroCollaudo > 0) {
      SezioneCollaudo sezioneCollaudo = null;
      DatiCollaudo datiCollaudo = this.sqlMapExportLiguriaDigitaleDao.getDatiCollaudo(hmParam);
      if (datiCollaudo != null) {
        
        sezioneCollaudo = new SezioneCollaudo();
        sezioneCollaudo.setDATI_COLLAUDO(datiCollaudo);
        
        List<DatiSoggettiEstesi> listaDatiSoggetiEstesiCollaudoDb =
          this.sqlMapExportLiguriaDigitaleDao.getDatiSoggettiEstesiCollaudo(hmParam);
        if (listaDatiSoggetiEstesiCollaudoDb != null && listaDatiSoggetiEstesiCollaudoDb.size() > 0) {
          // TODO: tutti i collaudatori vengono definiti collaudatori interni
          for (Iterator<DatiSoggettiEstesi> iterator = listaDatiSoggetiEstesiCollaudoDb.iterator(); iterator.hasNext();) {
            DatiSoggettiEstesi datiSoggettiEstesi = iterator.next();
            datiSoggettiEstesi.setFLAG_COLLAUDATORE(FlagCollaudatoreType.I);
            datiSoggettiEstesi.setIMPORTO_COLLAUDATORE(new Double(0));
          }
          sezioneCollaudo.setLISTA_DATI_SOGGETTI_ESTESI_COLL(
              listaDatiSoggetiEstesiCollaudoDb.toArray(new DatiSoggettiEstesi[0]));
        }
        
        List<String> listaCodiceTecniciSoggettiEsetesi = 
          this.sqlMapExportLiguriaDigitaleDao.getCodiceTecniciSoggettiEstesiCollaudo(hmParam);
        if (listaCodiceTecniciSoggettiEsetesi != null && listaCodiceTecniciSoggettiEsetesi.size() > 0) {
          for (int i=0; i < listaCodiceTecniciSoggettiEsetesi.size(); i++) {
            String codiceTecnico = listaCodiceTecniciSoggettiEsetesi.get(i);
            if (StringUtils.isNotEmpty(codiceTecnico)) {
              DatiResponsabile datiResponsabileDb = this.sqlMapExportLiguriaDigitaleDao.getDatiResponsabile(codiceTecnico);
              if (datiResponsabileDb != null) {
                sezioneCollaudo.getLISTA_DATI_SOGGETTI_ESTESI_COLL()[i].setResponsabile(datiResponsabileDb);
              }
            }
          }
        }
        datiGeneraliContratto.setSEZIONE_COLLAUDO(sezioneCollaudo);
      }
    }
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneCollaudo: fine metodo");
    }
  }
  
  private void setSezioneSubappalti(HashMap<String,Long> hmParam, DatiGeneraliContratto datiGeneraliContratto) throws SQLException {
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneSubappalti: inizio metodo");
    }

    SezioneSubappalti sezioneSubappalti = null;
    Long codiceGara = (Long) hmParam.get("codiceGara");
    Long codiceLotto = (Long) hmParam.get("codiceLotto");
    
    // Se esiste almeno un subappalto
    long numeroSubappalti = this.getNumeroFasi(codiceGara, codiceLotto, CostantiW9.SUBAPPALTO);
    if (numeroSubappalti > 0) {
      sezioneSubappalti = new SezioneSubappalti();
      
      List<ImpresaAggiudicataria> listaCampiSubappalti = 
          this.sqlMapExportLiguriaDigitaleDao.getListaCampiSubappalti(hmParam);
      if (listaCampiSubappalti != null && listaCampiSubappalti.size() > 0) {
        DatiSubappalto[] arrayDatiSubappalto = new DatiSubappalto[listaCampiSubappalti.size()];
        
        for (int i=0; i < listaCampiSubappalti.size(); i++) {
          ImpresaAggiudicataria campiImpresaAggiudicataria = listaCampiSubappalti.get(i);
          hmParam.put("numeroSubappalto", campiImpresaAggiudicataria.getNumAppalto());
          
          DatiSubappalto datiSubappalto = this.sqlMapExportLiguriaDigitaleDao.getDatiSubappalto(hmParam);
          if (StringUtils.isNotEmpty(campiImpresaAggiudicataria.getCodiceImpresa())) {
            DatiAggiudicatari datiAggiudicatario = this.sqlMapExportLiguriaDigitaleDao.getDatiAggiudicatario(
                campiImpresaAggiudicataria.getCodiceImpresa());
            DatiLegaleRappresentante legaleRappresentante = this.sqlMapExportLiguriaDigitaleDao.getDatiLegaleRappresentante(
                campiImpresaAggiudicataria.getCodiceImpresa());
            datiAggiudicatario.setListaLegaleRappresentante(new DatiLegaleRappresentante[] { legaleRappresentante });
            datiSubappalto.setAggiudicatario(datiAggiudicatario);
          }
          if (StringUtils.isNotEmpty(campiImpresaAggiudicataria.getCodiceImpresaAusiliaria())) {
            DatiAggiudicatari datiAggiudicatarioAusiliario = this.sqlMapExportLiguriaDigitaleDao.getDatiAggiudicatario(
                campiImpresaAggiudicataria.getCodiceImpresaAusiliaria());
            DatiLegaleRappresentante legaleRappresentante = this.sqlMapExportLiguriaDigitaleDao.getDatiLegaleRappresentante(
                campiImpresaAggiudicataria.getCodiceImpresaAusiliaria());
            datiAggiudicatarioAusiliario.setListaLegaleRappresentante(new DatiLegaleRappresentante[] { legaleRappresentante });
            datiSubappalto.setArch3_impagg(datiAggiudicatarioAusiliario);
          } else {
            // L'oggetto Arch3_impagg e' obbligatorio per Liguria Digitale, quindi nel caso non sia valorizzato
            // il campo W9SUBA.CODIMP_AGGIUDICATICE, si considera il campo W9AGGI.CODIMP
            String codiceImpresa = (String) this.sqlManager.getObject(
                "select CODIMP from W9AGGI where CODGARA=? and CODLOTT=? and NUM_APPA=1 and NUM_AGGI=1",
                new Object[] { codiceGara, codiceLotto });
            if (StringUtils.isNotEmpty(codiceImpresa)) {
              DatiAggiudicatari datiAggiudicatarioAusiliario =
                  this.sqlMapExportLiguriaDigitaleDao.getDatiAggiudicatario(codiceImpresa);
              DatiLegaleRappresentante legaleRappresentante = 
                  this.sqlMapExportLiguriaDigitaleDao.getDatiLegaleRappresentante(codiceImpresa);
              datiAggiudicatarioAusiliario.setListaLegaleRappresentante(new DatiLegaleRappresentante[] { legaleRappresentante });
              datiSubappalto.setArch3_impagg(datiAggiudicatarioAusiliario);
            }
          }
          arrayDatiSubappalto[i] = datiSubappalto;
        }
        sezioneSubappalti.setDATI_SUBAPPALTI(arrayDatiSubappalto);
      }
      datiGeneraliContratto.setSEZIONE_SUBAPPALTI(sezioneSubappalti);
    }
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneSubappalti: fine metodo");
    }
  }

  private void setSezioneRitardiRecessi(HashMap<String,Long> hmParam, DatiGeneraliContratto datiGeneraliContratto) throws SQLException {
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneRitardiRecessi: inizio metodo");
    }
    SezioneRitardiRecessi sezioneRitardiRecessi = null;
    
    Long codiceGara = (Long) hmParam.get("codiceGara");
    Long codiceLotto = (Long) hmParam.get("codiceLotto");
    
    // Se esiste almeno un recesso
    long numeroRitardiRecessi = this.getNumeroFasi(codiceGara, codiceLotto, CostantiW9.ISTANZA_RECESSO);
    if (numeroRitardiRecessi > 0) {
      sezioneRitardiRecessi = new SezioneRitardiRecessi();
      List<DatiRecesso> listaRecessi = this.sqlMapExportLiguriaDigitaleDao.getListaDatiRecessi(hmParam);
      if (listaRecessi != null && listaRecessi.size() > 0) {
        sezioneRitardiRecessi.setDATI_RITARDI_RECESSI(listaRecessi.toArray(new DatiRecesso[0]));
      }
      datiGeneraliContratto.setSEZIONE_RITARDI_RECESSI(sezioneRitardiRecessi);
    }
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneRitardiRecessi: fine metodo");
    }
  }
  
  private void setSezioneAccordiBonari(HashMap<String,Long> hmParam, DatiGeneraliContratto datiGeneraliContratto) throws SQLException {
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneAccordiBonari: inizio metodo");
    }
    SezioneAccordiBonari sezioneAccordiBonari = null;
    
    Long codiceGara = (Long) hmParam.get("codiceGara");
    Long codiceLotto = (Long) hmParam.get("codiceLotto");
    
    // Se esiste almeno un accordo bonario
    long numeroAccordiBonari = this.getNumeroFasi(codiceGara, codiceLotto, CostantiW9.ACCORDO_BONARIO);
    if (numeroAccordiBonari > 0) {
      sezioneAccordiBonari = new SezioneAccordiBonari();
      List<DatiAccordo> listaAccordiBonari = this.sqlMapExportLiguriaDigitaleDao.getListaDatiAccordiBonari(hmParam);
      if (listaAccordiBonari != null && listaAccordiBonari.size() > 0) {
        sezioneAccordiBonari.setDATI_ACCORDI_BONARI(listaAccordiBonari.toArray(new DatiAccordo[0]));
      }
      datiGeneraliContratto.setSEZIONE_ACCORDI_BONARI(sezioneAccordiBonari);
    }
    if (logger.isDebugEnabled()) {
      logger.debug("setSezioneAccordiBonari: fine metodo");
    }
  }
  
}
