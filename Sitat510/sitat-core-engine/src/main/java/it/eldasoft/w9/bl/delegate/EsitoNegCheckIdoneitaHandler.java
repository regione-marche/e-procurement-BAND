package it.eldasoft.w9.bl.delegate;

import it.eldasoft.gene.db.datautils.DataColumn;
import it.eldasoft.gene.db.datautils.DataColumnContainer;
import it.eldasoft.gene.db.sql.sqlparser.JdbcParametro;
import it.eldasoft.gene.web.struts.tags.gestori.GestoreException;
import it.eldasoft.w9.common.CostantiFlussi;
import it.eldasoft.w9.common.StatoComunicazione;
import it.eldasoft.w9.common.CostantiW9;
import it.toscana.rete.rfc.sitat.types.FaseEstesaType;
import it.toscana.rete.rfc.sitat.types.RichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneitaDocument;
import it.toscana.rete.rfc.sitat.types.Tab11Type;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;

/**
 * ConcreteHandler del Design Pattern "Chain of Responsibility".<br>
 * E' l'handler per la gestione dell'esito negativo della verifica idoneita'
 * tecnico professionale
 * 
 * @author Stefano.Sabbadin - Eldasoft S.p.A. Treviso
 */
public class EsitoNegCheckIdoneitaHandler extends AbstractRequestHandler {

  Logger logger = Logger.getLogger(EsitoNegCheckIdoneitaHandler.class);

  @Override
  protected String getNomeFlusso() {
    return "Esito negativo idoneita' tecnico-professionale impresa aggiudicataria";
  }

  @Override
  protected String getMainTagRequest() {
    return CostantiFlussi.MAIN_TAG_RICHIESTA_ESITO_NEG_CHECK_IDONEITA;
  }

  @Override
  protected XmlObject getXMLDocument(String xmlEvento) throws XmlException {
    return RichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneitaDocument.Factory.parse(xmlEvento);
  }

  @Override
  protected boolean isTest(XmlObject documento) {
    RichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneitaDocument doc = (RichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneitaDocument) documento;
    return doc.getRichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneita().getTest();
  }

  @Override
  protected FaseEstesaType getFaseInvio(XmlObject documento) {
    RichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneitaDocument doc = (RichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneitaDocument) documento;
    return doc.getRichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneita().getFase();
  }

  @Override
  protected void managePrimoInvio(XmlObject documento,
      DataColumnContainer datiAggiornamento, boolean ignoreWarnings)
  throws GestoreException, SQLException {
    RichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneitaDocument doc = (RichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneitaDocument) documento;
    FaseEstesaType fase = doc.getRichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneita().getFase();

    // Non esiste un lotto di gara col CIG specificato
    if (!this.existsLotto(fase)) {
      logger.error("La richiesta di primo invio non ha un lotto con questo cig ("
          + fase.getW3FACIG()
          + ") ");
      this.setEsito(datiAggiornamento, StatoComunicazione.STATO_ERRATA.getStato(),
      "Primo invio di una Esito negativo idoneita' tecnico-professionale con lotto non esistente in banca dati");
      return;
    }

    //if (this.existsIdoneita(fase)) {
    if (this.existsFase(fase.getW3FACIG(), CostantiW9.ESITO_NEGATIVO_VERIFICA_TECNICO_PROFESSIONALE_IMPRESA_AGGIUDICATARIA, fase.getW3NUM5())) {
      logger.error("La richiesta di primo invio ha un num_trpo("
          + fase.getW3NUM5()
          + ")  gia presente sul DB");
      this.setEsito(datiAggiornamento, StatoComunicazione.STATO_ERRATA.getStato(),
      "Primo invio di Esito negativo idoneita' tecnico-professionale e' gia' presente in banca dati");
      // si termina con questo errore
      return;
    }

    /*if (!ignoreWarnings) {
      boolean isGaraStipulaAccordoQuadro = this.isLottoStipulaAccordoQuadro(fase);
      if (isGaraStipulaAccordoQuadro) {
        logger.error("La richiesta di primo invio e' relativa ad una stipula accordo quadro");
        this.setEsito(datiAggiornamento, CostantiStatoComunicazione.STATO_WARNING,
        "Primo invio di Esito negativo idoneita' tecnico-professionale relativo ad una stipula accordo quadro");
        // si termina con questo errore
        return;
      }
    }*/

    this.insertDatiFlusso(doc, datiAggiornamento, true);
  }

  @Override
  protected void manageRettifica(XmlObject documento,
      DataColumnContainer datiAggiornamento, boolean ignoreWarnings)
  throws GestoreException, SQLException {
    RichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneitaDocument doc = (RichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneitaDocument) documento;
    FaseEstesaType fase = doc.getRichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneita().getFase();

    if (!this.existsLotto(fase)) {
      logger.error("La richiesta di rettifica non ha un lotto con questo cig ("
          + fase.getW3FACIG()
          + ") ");
      this.setEsito(datiAggiornamento, StatoComunicazione.STATO_ERRATA.getStato(),
      "Rettifica di Esito negativo idoneita' tecnico-professionale con lotto non esistente in banca dati");
      return;
    }

    //if (!this.existsIdoneita(fase)) {
    if (!this.existsFase(fase.getW3FACIG(), CostantiW9.ESITO_NEGATIVO_VERIFICA_TECNICO_PROFESSIONALE_IMPRESA_AGGIUDICATARIA, fase.getW3NUM5())) {
      logger.error("La richiesta di rettifica ha un num_trpo("
          + fase.getW3NUM5()
          + ")  non presente sul DB");
      this.setEsito(datiAggiornamento, StatoComunicazione.STATO_ERRATA.getStato(),
      "Rettifica di Esito negativo idoneita' tecnico-professionale non presente in banca dati");
      // si termina con questo errore
      return;
    }

    /*if (!ignoreWarnings) {
      boolean isGaraStipulaAccordoQuadro = this.isLottoStipulaAccordoQuadro(fase);
      if (isGaraStipulaAccordoQuadro) {
        logger.error("La richiesta di rettifica e' relativa ad una stipula accordo quadro");
        this.setEsito(datiAggiornamento, CostantiStatoComunicazione.STATO_WARNING,
        "Rettifica di Esito negativo idoneita' tecnico-professionale relativo ad una stipula accordo quadro");
        // si termina con questo errore
        return;
      }
    }*/

    this.manageIntegrazioneORettifica(doc, datiAggiornamento);
  }

  private void manageIntegrazioneORettifica(
      RichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneitaDocument doc,
      DataColumnContainer datiAggiornamento) throws SQLException,
      GestoreException {
    this.deleteDatiFlusso(doc.getRichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneita().getFase());
    this.insertDatiFlusso(doc, datiAggiornamento, false);
  }

  private void insertDatiFlusso(
      RichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneitaDocument doc,
      DataColumnContainer datiAggiornamento, boolean primoInvio) throws SQLException,
      GestoreException {
    Tab11Type tab11 = doc.getRichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneita().getTab11();
    FaseEstesaType fase = doc.getRichiestaRichiestaRispostaSincronaEsitoNegCheckIdoneita().getFase();

    Long[] longArray = this.getCodGaraCodLottByCIG(fase.getW3FACIG());
    Long codGara = longArray[0];
    Long codLott = longArray[1];
    String pkUffint = this.getCodiceUfficioIntestatario(fase.getW9FLCFSA());

    this.updateW9Fasi(codGara, codLott, fase, datiAggiornamento, primoInvio);

    // predisposizione dati W9TECPRO (tab13): i dati facoltativi vengono testati
    // con il metodo .isSetXXX per verificare se nel tracciato sono valorizzati
    DataColumnContainer dccTecpro = new DataColumnContainer(new DataColumn[] {
        new DataColumn("W9TECPRO.CODGARA", new JdbcParametro(
            JdbcParametro.TIPO_NUMERICO, codGara)),
            new DataColumn("W9TECPRO.CODLOTT", new JdbcParametro(
                JdbcParametro.TIPO_NUMERICO, codLott)),
                new DataColumn("W9TECPRO.NUM_TPRO", new JdbcParametro(
                    JdbcParametro.TIPO_NUMERICO, new Long(fase.getW3NUM5()))) });

    String pkImpresa = this.gestioneImpresa(tab11.getArch3(), pkUffint);

    dccTecpro.addColumn("W9TECPRO.CODIMP", JdbcParametro.TIPO_TESTO, pkImpresa);

    dccTecpro.addColumn("W9TECPRO.DESCARE", JdbcParametro.TIPO_TESTO,
        tab11.getW3TPDESCARE().toString());

    dccTecpro.addColumn("W9TECPRO.DATAUNI", JdbcParametro.TIPO_DATA,
        tab11.getW3TPDATAUNI().getTime());

    if (tab11.isSetW3TPINIDO1()) {
      dccTecpro.addColumn("W9TECPRO.INIDO1", JdbcParametro.TIPO_TESTO,
          this.getFlagSNDB(tab11.getW3TPINIDO1()).toString());
    }
    if (tab11.isSetW3TPINIDO2()) {
      dccTecpro.addColumn("W9TECPRO.INIDO2", JdbcParametro.TIPO_TESTO,
          this.getFlagSNDB(tab11.getW3TPINIDO2()).toString());
    }
    if (tab11.isSetW3TPINIDO3()) {
      dccTecpro.addColumn("W9TECPRO.INIDO3", JdbcParametro.TIPO_TESTO,
          this.getFlagSNDB(tab11.getW3TPINIDO3()).toString());
    }
    if (tab11.isSetW3TPINIDO4()) {
      dccTecpro.addColumn("W9TECPRO.INIDO4", JdbcParametro.TIPO_TESTO,
          this.getFlagSNDB(tab11.getW3TPINIDO4()).toString());
    }
    if (tab11.isSetW3TPINIDO5()) {
      dccTecpro.addColumn("W9TECPRO.INIDO5", JdbcParametro.TIPO_TESTO,
          this.getFlagSNDB(tab11.getW3TPINIDO5()).toString());
    }
    if (tab11.isSetW3TPINIDO6()) {
      dccTecpro.addColumn("W9TECPRO.INIDO6", JdbcParametro.TIPO_TESTO,
          this.getFlagSNDB(tab11.getW3TPINIDO6()).toString());
    }
    if (tab11.isSetW3TPINIDO7()) {
      dccTecpro.addColumn("W9TECPRO.INIDO7", JdbcParametro.TIPO_TESTO,
          tab11.getW3TPINIDO7().toString());
    }
    dccTecpro.insert("W9TECPRO", this.sqlManager);

    // se la procedura di aggiornamento e' andata a buon fine, si aggiorna lo
    // stato dell'importazione
    this.setEsito(datiAggiornamento, StatoComunicazione.STATO_IMPORTATA.getStato(), null);
  }

  /**
   * Cancellazione dei dati del flusso.
   * 
   * @param fase FaseEstesaType
   * @throws SQLException SQLException
   * @throws GestoreException GestoreException
   */
  private void deleteDatiFlusso(final FaseEstesaType fase) throws SQLException, GestoreException {
    Long[] longArray = this.getCodGaraCodLottByCIG(fase.getW3FACIG());
    Long codGara = longArray[0];
    Long codLott = longArray[1];

    this.sqlManager.update(
        "delete from w9tecpro where codgara = ? and codlott = ? and num_tpro = ?",
        new Object[] { codGara, codLott, fase.getW3NUM5() }, 1);
  }

}