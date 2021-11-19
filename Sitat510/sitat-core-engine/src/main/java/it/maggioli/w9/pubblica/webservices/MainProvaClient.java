package it.maggioli.w9.pubblica.webservices;


import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.AppaltiLiguriaWebServiceProxy;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.CheckFaultBean;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Aggiudicatario;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CategoriaType;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Categorie;
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
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiResponsabile;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiVariante;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Finanziamenti;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagEsitoCollaudoType;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagRitardoType;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSOType;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSingoloCommissioneType;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagVarianteType;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.MotiviVariante;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Pubblicazione;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneAccordiBonari;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneAggiudicazione;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneCollaudo;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneConclusione;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneInizio;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSAL;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneVarianti;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoFinanziamentoType;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoSchedaType;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoStrumentoType;

import java.io.ByteArrayOutputStream;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

public class MainProvaClient {

  /**
   * @param args
   * @throws RemoteException 
   * @throws CheckFaultBean 
   */
  public static void main(String[] args) throws CheckFaultBean, RemoteException {

    String urlServizio = "http://apitest.comune.genova.it:8280/ligdig_infoappalti/";
    //urlServizio = "http://192.168.153.92:8280/ligdig_infoappalti/";
    //String urlServizio = "http://192.168.153.92:8280/ligdig_infoappalti/";
    //urlServizio = "http://192.168.1.105:8088/mockAppaltiLiguriaWebServiceSoapBinding/AppaltiLiguriaWebServiceSoapBinding";
    
    urlServizio = "http://127.0.0.1:8088/mockAppaltiLiguriaWebServiceSoapBinding/";
    
    AppaltiLiguriaWebServiceProxy proxy = new AppaltiLiguriaWebServiceProxy(urlServizio);
    Contratto contratto = new Contratto();
    
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
    DatiEnte DATI_ENTE=new DatiEnte();
    DATI_ENTE.setCODICE_FISCALE("00856930102");   
    DATI_ENTE.setID_USER_ENTE("ComuneGenova");//Questo DEVE ESISTERE nel DB associato all'Ente
    contratto.setDATI_ENTE(DATI_ENTE);
    
    DatiGeneraliContratto datiGeneraliContratto = new DatiGeneraliContratto();
    
    datiGeneraliContratto.setCONTROLLO_INVIO("1");//Accetto SOLO questo!
    DatiComuni datiComuni = new DatiComuni();
    datiComuni.setCODICE_UFFICIO("UFF001");
    datiComuni.setDESCR_UFFICIO("DESCRIZIONE UFFICIO");
    datiComuni.setOGGETTO_GARA("OGG");
    datiComuni.setID_GARA("111133");
    datiComuni.setNUM_LOTTI(1);
    datiComuni.setFLAG_ENTE(FlagSOType.O);
    datiComuni.setMODO_REALIZZAZIONE("1");
    datiComuni.setFLAG_SA_AGENTE(FlagSNType.N);
    datiGeneraliContratto.setDATI_COMUNI(datiComuni);
    
    DatiComuniEstesi datiComuniEstesi = new DatiComuniEstesi();
    datiComuniEstesi.setCIG("6475757BB8"); //"6945813A341");
    datiComuniEstesi.setOGGETTO("OGG");
    datiComuniEstesi.setFLAG_SOMMA_URGENZA(FlagSNType.N);
    datiComuniEstesi.setCPV("32984328489-222");
    datiComuniEstesi.setID_SCELTA_CONTRAENTE("1");
    datiComuniEstesi.setCAT_PREVALENTE(CategoriaType.value10);
    datiComuniEstesi.setFLAG_POSA(FlagSNType.S);
    datiComuniEstesi.setFLAG_LOTTO_DERIVANTE(FlagSNType.N);
    datiComuniEstesi.setTIPO_APPALTO(TipoSchedaType.L);
    datiComuniEstesi.setFLAG_TIPO_SETTORE(FlagSOType.O);
    datiComuniEstesi.setID_MODO_GARA("1");
    datiComuniEstesi.setLUOGO_ISTAT("11111");
    datiComuniEstesi.setID_TIPO_PRESTAZIONE("1");
    datiComuniEstesi.setFLAG_1632006_1(FlagSNType.S);
    datiComuniEstesi.setFLAG_1632006_2(FlagSNType.S);
    
    DatiResponsabile responsabile=new DatiResponsabile();
    responsabile.setCODICE_FISCALE("329874832");
    responsabile.setCODICE_ISTAT_COMUNE("1111");
    responsabile.setCOGNOME("aaa");
    responsabile.setCODICE_STATO("IT");
    responsabile.setALBO_PROFESSIONALE(FlagSNType.S);
    datiComuniEstesi.setResponsabile(responsabile);
    
    datiGeneraliContratto.setDATI_COMUNI_ESTESI(datiComuniEstesi);
    
    
    SezioneAggiudicazione sezioneAggiudicazione = new SezioneAggiudicazione();
    DatiAggiudicazione datiAggiudicazione = new DatiAggiudicazione();
    datiAggiudicazione.setFIN_REGIONALE(FlagSNType.S);
    datiAggiudicazione.setFLAG_IMPORTI(FlagImportiType.C);
    datiAggiudicazione.setFLAG_SICUREZZA(FlagImportiType.C);
    datiAggiudicazione.setPERC_OFF_AUMENTO(12.56f);
    datiAggiudicazione.setFLAG_LIVELLO_PROGETTUALE("3290");
    datiAggiudicazione.setVERIFICA_CAMPIONE(FlagSNType.S);
    datiAggiudicazione.setDATA_VERB_AGGIUDICAZIONE(calendar);
    datiAggiudicazione.setASTA_ELETTRONICA(FlagSNType.N);
    datiAggiudicazione.setPROCEDURA_ACC(FlagSNType.N);
    datiAggiudicazione.setPREINFORMAZIONE(FlagSNType.S);
    datiAggiudicazione.setTERMINE_RIDOTTO(FlagSNType.S);
    datiAggiudicazione.setDATA_SCADENZA_PRES_OFFERTA(calendar);
    datiAggiudicazione.setFLAG_RICH_SUBAPPALTO(FlagSNType.N);
    datiAggiudicazione.setCOD_STRUMENTO(TipoStrumentoType.A02);
    datiAggiudicazione.setOPERE_URBANIZ_SCOMPUTO(FlagSNType.S);
    sezioneAggiudicazione.setDATI_AGGIUDICAZIONE(datiAggiudicazione);
    
    Finanziamenti[] listaFinanziamenti= new Finanziamenti[1];          
    Finanziamenti finanziamento=new Finanziamenti();
    finanziamento.setID_FINANZIAMENTO(TipoFinanziamentoType.C01);
    finanziamento.setIMPORTO_FINANZIAMENTO(123.36);         
    listaFinanziamenti[0]=finanziamento;
    sezioneAggiudicazione.setLISTA_FINANZIAMENTI(listaFinanziamenti);
    
    Pubblicazione pubblicazione = new Pubblicazione();
    pubblicazione.setPROFILO_COMMITTENTE(FlagSNType.N);
    pubblicazione.setSITO_MINISTERO_INF_TRASP(FlagSNType.N);
    pubblicazione.setSITO_OSSERVATORIO_CP(FlagSNType.N);
        
    Categorie[] listaCategorie=new Categorie[0];
    sezioneAggiudicazione.setLISTA_CATEGORIE(listaCategorie);
    sezioneAggiudicazione.setPUBBLICAZIONE_AGGIUDICAZIONE(pubblicazione);
    Aggiudicatario[] listaAggiudicatari = new Aggiudicatario[1];
    
    Aggiudicatario aggiudicatario=new Aggiudicatario();           
    aggiudicatario.setTIPOLOGIA_SOGGETTO("1");            
    DatiAggiudicatari datiAggiudicatario=new DatiAggiudicatari();
    datiAggiudicatario.setCODICE_FISCALE("AAABBB0001112223");//NON OBBLIGATORIO 
    datiAggiudicatario.setPARTITA_IVA("AAABBB0001112223");//NON OBBLIGATORIO
    datiAggiudicatario.setINPS("121121");
    datiAggiudicatario.setDENOMINAZIONE("DENOM");
    datiAggiudicatario.setCODICE_STATO("IT");
    datiAggiudicatario.setNCCIAA("8232388");
    datiAggiudicatario.setNATURA_GIURIDICA("3");
    datiAggiudicatario.setTIPOLOGIA_SOGGETTO("aaa");
    aggiudicatario.setAggiudicatario(datiAggiudicatario);
    listaAggiudicatari[0]=aggiudicatario;
    
    sezioneAggiudicazione.setLISTA_AGGIUDICATARI(listaAggiudicatari);
    
    DatiSoggettiEstesi[] listaDatiSoggettiEstesiAgg = new DatiSoggettiEstesi[2]; 
    DatiSoggettiEstesi datiSoggetti=new DatiSoggettiEstesi();
    datiSoggetti.setID_RUOLO("1");
    datiSoggetti.setDATA_AFF_PROG_ESTERNA(calendar);
    datiSoggetti.setDATA_CONS_PROG_ESTERNA(calendar);
    datiSoggetti.setResponsabile(responsabile);
    listaDatiSoggettiEstesiAgg[0]=datiSoggetti;
    
    datiSoggetti=new DatiSoggettiEstesi();
    datiSoggetti.setID_RUOLO("2");
    datiSoggetti.setDATA_AFF_PROG_ESTERNA(calendar);
    datiSoggetti.setDATA_CONS_PROG_ESTERNA(calendar);
    datiSoggetti.setResponsabile(responsabile);
    listaDatiSoggettiEstesiAgg[1]=datiSoggetti;
    
    sezioneAggiudicazione.setLISTA_DATI_SOGGETTI_ESTESI_AGG(listaDatiSoggettiEstesiAgg);
    datiGeneraliContratto.setSEZIONE_AGGIUDICAZIONE(sezioneAggiudicazione);
    
    //Provo una sezione NON OBBLIGATORIA (FASE INIZIALE)
    SezioneInizio sezioneInizio = new SezioneInizio();
    DatiInizio datiInizio = new DatiInizio();
    datiInizio.setDATA_STIPULA(calendar);
    datiInizio.setFLAG_RISERVA(FlagSNType.N);
    datiInizio.setDATA_ESECUTIVITA(calendar);
    datiInizio.setIMPORTO_CAUZIONE(125.9999);
    datiInizio.setFLAG_FRAZIONATA(FlagSNType.S);
    datiInizio.setDATA_VERBALE_DEF(calendar);
    sezioneInizio.setDATI_INIZIO(datiInizio);
    sezioneInizio.setPUBBLICAZIONE_INIZIO(pubblicazione );
    
    //Minimo 0
    DatiSoggettiEstesi[] LISTA_DATI_SOGGETTI_ESTESI_INIZIO=new DatiSoggettiEstesi[0]; 
    sezioneInizio.setLISTA_DATI_SOGGETTI_ESTESI_INIZIO(LISTA_DATI_SOGGETTI_ESTESI_INIZIO);
    datiGeneraliContratto.setSEZIONE_INIZIO(sezioneInizio);
    
    //Provo una sezione MULTIPLA NON OBBLIGATORIA (SAL)
    SezioneSAL sezioneSAL = new SezioneSAL();
    DatiAvanzamento[] datiSAL = new DatiAvanzamento[2];
    
    DatiAvanzamento datiAvanzamento=new DatiAvanzamento();
    datiAvanzamento.setSUBAPPALTI(FlagSNType.N);
    datiAvanzamento.setIMPORTO_CERTIFICATO(125);
    datiAvanzamento.setFLAG_RITARDO(FlagRitardoType.A);
    datiAvanzamento.setFLAG_PAGAMENTO("N");
    datiAvanzamento.setDATA_RAGGIUNGIMENTO(calendar);
    datiAvanzamento.setIMPORTO_SAL(58);
    datiSAL[0]=datiAvanzamento;
    
    datiAvanzamento=new DatiAvanzamento();
    datiAvanzamento.setSUBAPPALTI(FlagSNType.S);
    datiAvanzamento.setIMPORTO_CERTIFICATO(3333);
    datiAvanzamento.setFLAG_RITARDO(FlagRitardoType.P);
    datiAvanzamento.setFLAG_PAGAMENTO("S");
    datiAvanzamento.setDATA_RAGGIUNGIMENTO(calendar);
    datiAvanzamento.setIMPORTO_SAL(223);
    datiSAL[1]=datiAvanzamento;
    
    sezioneSAL.setDATI_SAL(datiSAL);
    
    datiGeneraliContratto.setSEZIONE_SAL(sezioneSAL);
    
    
    //Provo una sezione MULTIPLA NON OBBLIGATORIA (VARIANTE)    
    
    DatiVariante[] id_DatiVariante = new DatiVariante[1];
    DatiVariante datiVariante=new DatiVariante();
    datiVariante.setFLAG_VARIANTE(FlagVarianteType.A);    
    datiVariante.setQUINTO_OBBLIGO(FlagSNType.N);
    datiVariante.setFLAG_IMPORTI(FlagImportiType.C);
    datiVariante.setFLAG_SICUREZZA(FlagImportiType.C);
    datiVariante.setDATA_VERB_APPR(calendar);
    datiVariante.setIMPORTO_RIDETERMINATO(123.32);//Campo x il futuro......
    id_DatiVariante[0] = datiVariante;    
   
    
    MotiviVariante[] lista_motivi_variante = new MotiviVariante[1];//Unica!
    MotiviVariante listaMotiviVariante=new MotiviVariante();
    listaMotiviVariante.setID_MOTIVO_VAR("AAA");
    lista_motivi_variante[0] = listaMotiviVariante;
    datiVariante.setLISTA_MOTIVI_VARIANTE(lista_motivi_variante);

    
    
    //ListaDatiVariante DATI_VARIANTI = LISTA_DATI_VARIANTI;
    
    SezioneVarianti SEZIONE_VARIANTI=new SezioneVarianti();
    SEZIONE_VARIANTI.setDATI_VARIANTI(id_DatiVariante);
    
    datiGeneraliContratto.setSEZIONE_VARIANTI(SEZIONE_VARIANTI);
    
    //Provo un Contenzioso
    SezioneAccordiBonari SEZIONE_ACCORDI_BONARI=new SezioneAccordiBonari();
    
    DatiAccordo[] DATI_ACCORDI_BONARI=new DatiAccordo[1];
    DatiAccordo datiAccordi=new DatiAccordo();
    datiAccordi.setDATA_ACCORDO(calendar);
    datiAccordi.setDATA_INIZIO_ACC(calendar);
    datiAccordi.setDATA_FINE_ACC(calendar);
    
    DATI_ACCORDI_BONARI[0]=datiAccordi;
    SEZIONE_ACCORDI_BONARI.setDATI_ACCORDI_BONARI(DATI_ACCORDI_BONARI);
    
    datiGeneraliContratto.setSEZIONE_ACCORDI_BONARI(SEZIONE_ACCORDI_BONARI);
    
    
    SezioneConclusione SEZIONE_CONCLUSIONE=new SezioneConclusione();
    
    DatiConclusione DATI_CONCLUSIONE=new DatiConclusione();
    DATI_CONCLUSIONE.setFLAG_INTERR_ANTICIPATA(FlagSNType.N);
    DATI_CONCLUSIONE.setDATA_RISOLUZIONE(calendar);
    DATI_CONCLUSIONE.setFLAG_POLIZZA(FlagSNType.S);
    DATI_CONCLUSIONE.setDATA_VERB_CONSEGNA_AVVIO(calendar);
    DATI_CONCLUSIONE.setDATA_TERMINE_CONTRATTUALE(calendar);
    DATI_CONCLUSIONE.setDATA_ULTIMAZIONE(calendar);
    SEZIONE_CONCLUSIONE.setDATI_CONCLUSIONE(DATI_CONCLUSIONE);
    
    //Provo una sezione NON OBBLIGATORIA (FASE CONCLUSIONE)
    datiGeneraliContratto.setSEZIONE_CONCLUSIONE(SEZIONE_CONCLUSIONE);
    
    
    //Provo una sezione NON OBBLIGATORIA (FASE COLLAUDO)
    SezioneCollaudo SEZIONE_COLLAUDO=new SezioneCollaudo();
    DatiCollaudo DATI_COLLAUDO=new DatiCollaudo();
    DATI_COLLAUDO.setFLAG_SINGOLO_COMMISSIONE(FlagSingoloCommissioneType.S);
    DATI_COLLAUDO.setDATA_APPROVAZIONE(calendar);
    DATI_COLLAUDO.setFLAG_IMPORTI(FlagImportiType.C);
    DATI_COLLAUDO.setFLAG_SICUREZZA(FlagImportiType.C);
    DATI_COLLAUDO.setFLAG_SUBAPPALTATORI(FlagSNType.N);
    DATI_COLLAUDO.setMODO_COLLAUDO("A");
    DATI_COLLAUDO.setDATA_NOMINA_COLL(calendar);
    DATI_COLLAUDO.setESITO_COLLAUDO(FlagEsitoCollaudoType.N);
    DATI_COLLAUDO.setIMP_DISPOSIZIONE(885.55);
    DATI_COLLAUDO.setIMPORTO_SUBTOTALE(858);
    DATI_COLLAUDO.setIMPORTO_FINALE(232);
    DATI_COLLAUDO.setIMPORTO_CONSUNTIVO(222);
    SEZIONE_COLLAUDO.setDATI_COLLAUDO(DATI_COLLAUDO);
    //Minimo 0
    DatiSoggettiEstesi[] LISTA_DATI_SOGGETTI_ESTESI_COLL = new DatiSoggettiEstesi[2];
    datiSoggetti=new DatiSoggettiEstesi();
    datiSoggetti.setID_RUOLO("1");
    datiSoggetti.setDATA_AFF_PROG_ESTERNA(calendar);
    datiSoggetti.setDATA_CONS_PROG_ESTERNA(calendar);
    datiSoggetti.setResponsabile(responsabile);
    LISTA_DATI_SOGGETTI_ESTESI_COLL[0]=datiSoggetti;
    
    datiSoggetti=new DatiSoggettiEstesi();
    datiSoggetti.setID_RUOLO("3");
    datiSoggetti.setDATA_AFF_PROG_ESTERNA(calendar);
    datiSoggetti.setDATA_CONS_PROG_ESTERNA(calendar);
    datiSoggetti.setResponsabile(responsabile);
    LISTA_DATI_SOGGETTI_ESTESI_COLL[1]=datiSoggetti;
    
    SEZIONE_COLLAUDO.setLISTA_DATI_SOGGETTI_ESTESI_COLL(LISTA_DATI_SOGGETTI_ESTESI_COLL);
    
    datiGeneraliContratto.setSEZIONE_COLLAUDO(SEZIONE_COLLAUDO);
    
    contratto.setDATI_GENERALI_CONTRATTO(datiGeneraliContratto);

    String contrattoXml = null;
    
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      JAXBContext context = JAXBContext.newInstance(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Contratto.class);                                             
      Marshaller marshaller = context.createMarshaller();                                   
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);                                           
      marshaller.marshal( contratto, baos);
      
      if (baos != null && baos.size() > 0) {
        contrattoXml = baos.toString();
      }
      
      System.out.println(contrattoXml);
      
    } catch (PropertyException pe) {
      System.out.println("Errore nella creazione del XMl dell'oggetto contratto da inviare a Liguria Digitale (1)");
    } catch (JAXBException je) {
      System.out.println("Errore nella creazione del XMl dell'oggetto contratto da inviare a Liguria Digitale (2)");
    }
    
    
    String rispostaWs = proxy.invioContratto(contratto);
    
    System.out.println(rispostaWs);

  }

}
