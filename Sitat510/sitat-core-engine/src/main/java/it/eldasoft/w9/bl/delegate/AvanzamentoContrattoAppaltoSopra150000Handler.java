package it.eldasoft.w9.bl.delegate;

import it.eldasoft.gene.db.datautils.DataColumn;
import it.eldasoft.gene.db.datautils.DataColumnContainer;
import it.eldasoft.gene.db.sql.sqlparser.JdbcParametro;
import it.eldasoft.gene.web.struts.tags.gestori.GestoreException;
import it.eldasoft.w9.common.CostantiFlussi;
import it.eldasoft.w9.common.StatoComunicazione;
import it.eldasoft.w9.common.CostantiW9;
import it.eldasoft.w9.utils.UtilitySITAT;
import it.toscana.rete.rfc.sitat.types.FaseEstesaType;
import it.toscana.rete.rfc.sitat.types.RichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000Document;
import it.toscana.rete.rfc.sitat.types.Tab20Type;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;

/**
 * ConcreteHandler del Design Pattern "Chain of Responsibility".<br>
 * E' l'handler per la gestione dell'avanzamento contratto appalto sopra 150000.
 * 
 * @author Stefano.Sabbadin - Eldasoft S.p.A. Treviso
 */
public class AvanzamentoContrattoAppaltoSopra150000Handler extends
AbstractRequestHandler {

  Logger logger = Logger.getLogger(AvanzamentoContrattoAppaltoSopra150000Handler.class);

  @Override
  protected String getNomeFlusso() {
    return "Fase di esecuzione e avanzamento del contratto";
  }

  @Override
  protected String getMainTagRequest() {
    return CostantiFlussi.MAIN_TAG_RICHIESTA_AVANZAMENTO_CONTRATTO_APPALTO_SOPRA_150000;
  }

  @Override
  protected XmlObject getXMLDocument(String xmlEvento) throws XmlException {
    return RichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000Document.Factory.parse(xmlEvento);
  }

  @Override
  protected boolean isTest(XmlObject documento) {
    RichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000Document doc = (RichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000Document) documento;
    return doc.getRichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000().getTest();
  }

  @Override
  protected FaseEstesaType getFaseInvio(XmlObject documento) {
    RichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000Document doc = (RichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000Document) documento;
    return doc.getRichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000().getFase();
  }

  @Override
  protected void managePrimoInvio(XmlObject documento,
      DataColumnContainer datiAggiornamento, boolean ignoreWarnings)
  throws GestoreException, SQLException {
    RichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000Document doc = (RichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000Document) documento;
    FaseEstesaType fase = doc.getRichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000().getFase();

    if (!this.existsLotto(fase)) {
      logger.error("La richiesta di primo invio ha un cig ("
          + fase.getW3FACIG()
          + ") di un lotto non presente in DB");
      this.setEsito(datiAggiornamento, StatoComunicazione.STATO_ERRATA.getStato(),
      "Primo invio di avanzamento contratto di un lotto non presente in banca dati");
      // si termina con questo errore
      return;
    }

    if (!this.existsAppalto(fase)) {
      logger.error("La richiesta di primo invio ha un cig ("
          + fase.getW3FACIG()
          + ") di un lotto non appaltato sul DB");
      this.setEsito(datiAggiornamento, StatoComunicazione.STATO_ERRATA.getStato(),
        "Primo invio di avanzamento contratto di un lotto non appaltato in banca dati");
        // si termina con questo errore
      return;
    }

    if (!this.existsAggiudicatari(fase)) {
      logger.error("La richiesta di primo invio ha un cig ("
          + fase.getW3FACIG()
          + ") di un lotto non aggiudicato sul DB");
      this.setEsito(datiAggiornamento, StatoComunicazione.STATO_ERRATA.getStato(),
        "Primo invio di avanzamento contratto di un lotto non aggiudicato in banca dati");
      // si termina con questo errore
      return;
    }

    //if (!this.existsInizio(fase)) {
    if (!(this.existsFase(fase.getW3FACIG(), CostantiW9.INIZIO_CONTRATTO_SOPRA_SOGLIA)
        || this.existsFase(fase.getW3FACIG(), CostantiW9.FASE_SEMPLIFICATA_INIZIO_CONTRATTO)
        || this.existsFase(fase.getW3FACIG(), CostantiW9.STIPULA_ACCORDO_QUADRO))) {
      logger.error("La richiesta di primo invio ha un cig ("
          + fase.getW3FACIG()
          + ") di un lotto senza fase inziale o stipula accordo quadro sul DB");
      this.setEsito(datiAggiornamento, StatoComunicazione.STATO_ERRATA.getStato(),
        "Primo invio di avanzamento contratto di un lotto senza fase inziale" +
        " o stipula accordo quadro in banca dati");
      // si termina con questo errore
      return;
    }

    //if (this.existsAvanzamento(fase)) {
    if (this.existsFase(fase.getW3FACIG(), CostantiW9.AVANZAMENTO_CONTRATTO_SOPRA_SOGLIA, fase.getW3NUM5())) {
      logger.error("La richiesta di primo invio ha un avanzamento ("
          + fase.getW3FACIG()
          + ") con indici gia' presenti sul DB");
      this.setEsito(datiAggiornamento, StatoComunicazione.STATO_ERRATA.getStato(),
        "Primo invio di avanzamento contratto di un lotto con un avanzamento con indici gia' presenti in banca dati");
      // si termina con questo errore
      return;
    }

    // Warnings
    if (!ignoreWarnings) {
      boolean isS3 = UtilitySITAT.isS3(fase.getW3FACIG(), this.sqlManager);
      boolean isSAQ = UtilitySITAT.isSAQ(fase.getW3FACIG(), this.sqlManager);
      boolean isE1 = UtilitySITAT.isE1(fase.getW3FACIG(), this.sqlManager);
      boolean isAII = UtilitySITAT.isAII(fase.getW3FACIG(), this.sqlManager);
      boolean isOrd = UtilitySITAT.isOrd(fase.getW3FACIG(), this.sqlManager);
      
      if ((!isS3 && !isAII) || isE1 || isSAQ || !isOrd) {
        logger.error("La richiesta di primo invio di avanzamento contratto non previsto per il lotto CIG=" + fase.getW3FACIG());
        this.setEsito(datiAggiornamento, StatoComunicazione.STATO_WARNING.getStato(),
          "Primo invio di avanzamento contratto non previsto");
        // si termina con questo errore
        
        if (!isS3 && !isAII) {
          logger.error("La richiesta di primo invio ha il lotto non superiore a 500000 e non e' una ricostruzione per alluvione Lunigiana e Elda");
        }
        if (isE1) {
          logger.error("La richiesta di primo invio ha il lotto escluso");
        }
        if (isSAQ) {
          logger.error("La richiesta di integrazione di una stipula accordo quadro");
        }
        if (!isOrd) {
          logger.error("La richiesta di integrazione ha il lotto senza settori ordinari");
        }
        return;
      }
    }
    // SE SI ARRIVA QUI, ALLORA I CONTROLLI SONO ANDATI A BUON FINE PER CUI SI
    // AGGIORNA IL DB
    this.insertDatiFlusso(doc, datiAggiornamento, true);
  }

  @Override
  protected void manageRettifica(XmlObject documento,
      DataColumnContainer datiAggiornamento, boolean ignoreWarnings)
  throws GestoreException, SQLException {
    RichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000Document doc = (RichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000Document) documento;
    FaseEstesaType fase = doc.getRichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000().getFase();

    if (!this.existsLotto(fase)) {
      logger.error("La richiesta di rettifica ha un cig ("
          + fase.getW3FACIG()
          + ") di un lotto non presente in DB");
      this.setEsito(datiAggiornamento, StatoComunicazione.STATO_ERRATA.getStato(),
      "Rettifica di avanzamento contratto di un lotto non presente in banca dati");
      // si termina con questo errore
      return;
    }

    if (!this.existsAppalto(fase)) {
      logger.error("La richiesta di rettifica ha un cig ("
          + fase.getW3FACIG()
          + ") di un lotto non appaltato sul DB");
      this.setEsito(datiAggiornamento, StatoComunicazione.STATO_ERRATA.getStato(),
      "Rettifica di avanzamento contratto di un lotto non appaltato in banca dati");
      // si termina con questo errore
      return;
    }

    if (!this.existsAggiudicatari(fase)) {
      logger.error("La richiesta di rettifica ha un cig ("
          + fase.getW3FACIG()
          + ") di un lotto non aggiudicato sul DB");
      this.setEsito(datiAggiornamento, StatoComunicazione.STATO_ERRATA.getStato(),
      "Rettifica di avanzamento contratto di un lotto non aggiudicato in banca dati");
      // si termina con questo errore
      return;
    }

    //if (!this.existsInizio(fase)) {
    if (!(this.existsFase(fase.getW3FACIG(), CostantiW9.INIZIO_CONTRATTO_SOPRA_SOGLIA)
        || this.existsFase(fase.getW3FACIG(), CostantiW9.FASE_SEMPLIFICATA_INIZIO_CONTRATTO)
        || this.existsFase(fase.getW3FACIG(), CostantiW9.STIPULA_ACCORDO_QUADRO))) {
      logger.error("La richiesta di rettifica ha un cig ("
          + fase.getW3FACIG()
          + ") di un lotto senza fase inziale o stipula accordo quadro sul DB");
      this.setEsito(datiAggiornamento, StatoComunicazione.STATO_ERRATA.getStato(),
          "Rettifica di avanzamento contratto di un lotto senza fase inziale" +
          " o stipula accordo quadro in banca dati");
      // si termina con questo errore
      return;
    }

    //if (!this.existsAvanzamento(fase)) {
    if (!this.existsFase(fase.getW3FACIG(), CostantiW9.AVANZAMENTO_CONTRATTO_SOPRA_SOGLIA, fase.getW3NUM5())) {
      logger.error("La richiesta di rettifica non ha un avanzamento ("
          + fase.getW3FACIG()
          + ") con indici gia' presenti sul DB");
      this.setEsito(datiAggiornamento, StatoComunicazione.STATO_ERRATA.getStato(),
          "Rettifica di avanzamento contratto di un lotto senza un avanzamento con indici gia' presenti in banca dati");
      // si termina con questo errore
      return;
    }

    // Warnings
    if (!ignoreWarnings) {
      boolean isS3 = UtilitySITAT.isS3(fase.getW3FACIG(), this.sqlManager);
      boolean isSAQ = UtilitySITAT.isSAQ(fase.getW3FACIG(), this.sqlManager);
      boolean isE1 = UtilitySITAT.isE1(fase.getW3FACIG(), this.sqlManager);
      boolean isAII = UtilitySITAT.isAII(fase.getW3FACIG(), this.sqlManager);
      boolean isOrd = UtilitySITAT.isOrd(fase.getW3FACIG(), this.sqlManager);
      
      if ((!isS3 && !isAII) || isE1 || isSAQ || !isOrd) {

        logger.error("La richiesta di rettifica di avanzamento contratto non previsto per il lotto CIG=" + fase.getW3FACIG());
        this.setEsito(datiAggiornamento, StatoComunicazione.STATO_WARNING.getStato(),
          "Rettifica di avanzamento contratto non previsto");
        // si termina con questo errore
        
        if (!isS3 && !isAII) {
          logger.error("La richiesta di rettifica ha il lotto non superiore a 500000 e non e' una ricostruzione per alluvione Lunigiana e Elda");
        }
        if (isE1) {
          logger.error("La richiesta di rettifica ha il lotto escluso");
        }
        if (isSAQ) {
          logger.error("La richiesta di integrazione di una stipula accordo quadro");
        }
        if (!isOrd) {
          logger.error("La richiesta di integrazione ha il lotto senza settori ordinari");
        }
        return;
      }
    }
    // SE SI ARRIVA QUI, ALLORA I CONTROLLI SONO ANDATI A BUON FINE PER CUI SI
    // AGGIORNA IL DB
    this.manageIntegrazioneORettifica(doc, datiAggiornamento);
  }

  /**
   * Centralizza la gestione dei casi Integrazione e Rettifica in quanto da
   * analisi allo stato attuale non c'e' alcuna differenza.
   * 
   * @param documento
   * @param datiAggiornamento
   * @return
   * @throws GestoreException
   * @throws SQLException
   */
  private void manageIntegrazioneORettifica(
      RichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000Document doc,
      DataColumnContainer datiAggiornamento) throws GestoreException,
      SQLException {
    this.deleteDatiFlusso(doc.getRichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000().getFase());
    this.insertDatiFlusso(doc, datiAggiornamento, false);
  }

  /**
   * Elimina tutte le occorrenze dal DB dei dati da aggiornare (W9AVAN).
   * 
   * @param fase
   *        elemento fase del flusso
   * @throws SQLException
   */
  private void deleteDatiFlusso(FaseEstesaType fase) throws SQLException, GestoreException {
    Long[] longArray = this.getCodGaraCodLottByCIG(fase.getW3FACIG());
    Long codGara = longArray[0];
    Long codLott = longArray[1];

    this.sqlManager.update(
        "delete from w9avan where codgara = ? and codlott = ? and num_avan = ? ",
        new Object[] { codGara, codLott, fase.getW3NUM5() });
  }

  /**
   * Effettua l'inserimento vero e proprio dei dati presenti nel flusso.
   * 
   * @param doc
   *        documento XML della richiesta
   * @param datiAggiornamento
   *        container con i dati del flusso
   * @throws SQLException
   * @throws GestoreException
   */
  private void insertDatiFlusso(
      RichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000Document doc,
      DataColumnContainer datiAggiornamento, boolean primoInvio)
  throws SQLException, GestoreException {

    Tab20Type tab20 = doc.getRichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000().getTab20();
    FaseEstesaType fase = doc.getRichiestaRichiestaRispostaSincronaAvanzamentoContrattoSopra150000().getFase();

    Long[] longArray = this.getCodGaraCodLottByCIG(fase.getW3FACIG());
    Long codGara = longArray[0];
    Long codLott = longArray[1];

    this.updateW9Fasi(codGara, codLott, fase, datiAggiornamento, primoInvio);

    // predisposizione dati W9AVAN (tab20): i dati facoltativi vengono testati
    // con il metodo .isSetXXX per verificare se nel tracciato sono valorizzati
    DataColumnContainer dccAvanzamento = new DataColumnContainer(
        new DataColumn[] {
            new DataColumn("W9AVAN.CODGARA", new JdbcParametro(
                JdbcParametro.TIPO_NUMERICO, codGara)),
                new DataColumn("W9AVAN.CODLOTT", new JdbcParametro(
                    JdbcParametro.TIPO_NUMERICO, codLott)),
                    new DataColumn("W9AVAN.NUM_AVAN", new JdbcParametro(
                        JdbcParametro.TIPO_NUMERICO, new Long(fase.getW3NUM5()))) });

    if (tab20.isSetW3DATACER()) {
      dccAvanzamento.addColumn("W9AVAN.DATA_CERTIFICATO",
          JdbcParametro.TIPO_DATA, tab20.getW3DATACER().getTime());
    }
    dccAvanzamento.addColumn("W9AVAN.IMPORTO_CERTIFICATO",
        JdbcParametro.TIPO_DECIMALE, tab20.getW3ICERTIF());
    dccAvanzamento.addColumn("W9AVAN.FLAG_RITARDO", JdbcParametro.TIPO_TESTO,
        tab20.getW3FLAGRIT().toString());
    if (tab20.isSetW3NUMGIO1()) {
      dccAvanzamento.addColumn("W9AVAN.NUM_GIORNI_SCOST",
          JdbcParametro.TIPO_NUMERICO, new Long(tab20.getW3NUMGIO1()));
    }
    if (tab20.isSetW3NUMGIO2()) {
      dccAvanzamento.addColumn("W9AVAN.NUM_GIORNI_PROROGA",
          JdbcParametro.TIPO_NUMERICO, new Long(tab20.getW3NUMGIO2()));
    }
    dccAvanzamento.addColumn("W9AVAN.FLAG_PAGAMENTO",
        JdbcParametro.TIPO_NUMERICO, new Long(tab20.getW3FLAGPAG().toString()));
    if (tab20.isSetW3DATAANT()) {
      dccAvanzamento.addColumn("W9AVAN.DATA_ANTICIPAZIONE",
          JdbcParametro.TIPO_DATA, tab20.getW3DATAANT().getTime());
    }
    if (tab20.isSetW3IANTICI()) {
      dccAvanzamento.addColumn("W9AVAN.IMPORTO_ANTICIPAZIONE",
          JdbcParametro.TIPO_DECIMALE, tab20.getW3IANTICI());
    }
    //if (tab20.isSetW3DATARAG())
    dccAvanzamento.addColumn("W9AVAN.DATA_RAGGIUNGIMENTO",
        JdbcParametro.TIPO_DATA, tab20.getW3DATARAG().getTime());
    if (tab20.isSetW3AVANDENO()) {
      dccAvanzamento.addColumn("W9AVAN.DENOM_AVANZAMENTO",
          JdbcParametro.TIPO_TESTO, tab20.getW3AVANDENO());
    }
    dccAvanzamento.addColumn("W9AVAN.IMPORTO_SAL", JdbcParametro.TIPO_DECIMALE, tab20.getW3ISAL());
    dccAvanzamento.insert("W9AVAN", this.sqlManager);
    
    this.aggiornaStatoExportLotto(codGara, codLott);
        
    // se la procedura di aggiornamento e' andata a buon fine, si aggiorna lo
    // stato dell'importazione
    this.setEsito(datiAggiornamento, StatoComunicazione.STATO_IMPORTATA.getStato(), null);
  }

}
