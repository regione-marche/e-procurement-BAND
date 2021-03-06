package it.eldasoft.w9.bl.delegateImport;

import it.eldasoft.gene.db.datautils.DataColumn;
import it.eldasoft.gene.db.datautils.DataColumnContainer;
import it.eldasoft.gene.db.sql.sqlparser.JdbcParametro;
import it.eldasoft.gene.web.struts.tags.gestori.GestoreException;
import it.eldasoft.w9.common.CostantiFlussi;
import it.eldasoft.w9.common.StatoComunicazione;
import it.eldasoft.w9.common.CostantiW9;
import it.eldasoft.w9.utils.UtilitySITAT;
import it.toscana.rete.rfc.sitat.types.FaseEstesaType;
import it.toscana.rete.rfc.sitat.types.FaseType;
import it.toscana.rete.rfc.sitat.types.RichiestaRichiestaRispostaSincronaInizioContrattoSotto150000Document;
import it.toscana.rete.rfc.sitat.types.Tab101Type;
import it.toscana.rete.rfc.sitat.types.Tab13Type;
import it.toscana.rete.rfc.sitat.types.Tab41Type;
import it.toscana.rete.rfc.sitat.types.Tab8Bis2Type;
import it.toscana.rete.rfc.sitat.types.Tab8BisType;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;

/**
 * ConcreteHandler del Design Pattern "Chain of Responsibility".<br>
 * E' l'handler per la gestione dell'inizio contratto appalto sotto 150000.
 * 
 * @author Stefano.Sabbadin - Eldasoft S.p.A. Treviso
 */
public class InizioContrattoAppaltoSotto150000Handler extends AbstractRequestHandler {

	Logger logger = Logger.getLogger(InizioContrattoAppaltoSotto150000Handler.class);

	@Override
	protected String getNomeFlusso() {
		return "Fase semplificata di inizio esecuzione appalto";
	}

	@Override
	protected String getMainTagRequest() {
		return CostantiFlussi.MAIN_TAG_RICHIESTA_INIZIO_CONTRATTO_APPALTO_SOTTO_150000;
	}

	@Override
	protected XmlObject getXMLDocument(String xmlEvento) throws XmlException {
		return RichiestaRichiestaRispostaSincronaInizioContrattoSotto150000Document.Factory.parse(xmlEvento);
	}

	@Override
	protected boolean isTest(XmlObject documento) {
		RichiestaRichiestaRispostaSincronaInizioContrattoSotto150000Document doc = (RichiestaRichiestaRispostaSincronaInizioContrattoSotto150000Document) documento;
		return doc.getRichiestaRichiestaRispostaSincronaInizioContrattoSotto150000().getTest();
	}

	@Override
	protected FaseType getFaseInvio(XmlObject documento) {
		RichiestaRichiestaRispostaSincronaInizioContrattoSotto150000Document doc = (RichiestaRichiestaRispostaSincronaInizioContrattoSotto150000Document) documento;
		return doc.getRichiestaRichiestaRispostaSincronaInizioContrattoSotto150000().getFase();
	}

	@Override
	protected void managePrimoInvio(XmlObject documento, DataColumnContainer datiAggiornamento, boolean ignoreWarnings) throws GestoreException, SQLException {
		RichiestaRichiestaRispostaSincronaInizioContrattoSotto150000Document doc = (RichiestaRichiestaRispostaSincronaInizioContrattoSotto150000Document) documento;
		FaseEstesaType fase = doc.getRichiestaRichiestaRispostaSincronaInizioContrattoSotto150000().getFase();

		if (!this.existsLotto(fase)) {
			logger.error("La richiesta di primo invio ha un cig (" + fase.getW3FACIG() + ") di un lotto non presente in DB.");
			this.setEsito(datiAggiornamento, StatoComunicazione.STATO_ERRATA.getStato(), "Primo invio di una Fase iniziale di esecuzione del contratto con lotto non esistente in banca dati");
			return;
		}

		if (!this.existsAppalto(fase)) {
			logger.error("La richiesta di primo invio ha un cig (" + fase.getW3FACIG() + ") di un lotto non appaltato sul DB");
			this.setEsito(datiAggiornamento, StatoComunicazione.STATO_ERRATA.getStato(), "Primo invio di una Fase iniziale di esecuzione del contratto di un lotto non appaltato in banca dati");
			// si termina con questo errore
			return;
		}

		if (!this.existsAggiudicazione(fase)) {
			logger.error("La richiesta di primo invio ha un cig (" + fase.getW3FACIG() + ") di un lotto non presente in DB");
			this.setEsito(datiAggiornamento, StatoComunicazione.STATO_ERRATA.getStato(), "Primo invio di una Fase iniziale di esecuzione del contratto di un lotto non presente in banca dati");
			// si termina con questo errore
			return;
		}

		if (this.existsInizio(fase)) {
			logger.error("La richiesta di primo invio ha un cig (" + fase.getW3FACIG() + ") di un lotto che possiede gia' fase una inziale sul DB");
			this.setEsito(datiAggiornamento, StatoComunicazione.STATO_ERRATA.getStato(), "Primo invio di una Fase iniziale di esecuzione del contratto di un lotto che "
					+ "possiede gia' una fase inziale in banca dati");
			// si termina con questo errore
			return;
		}

		// warnings
		if (!ignoreWarnings) {
			boolean isS2 = UtilitySITAT.isS2(fase.getW3FACIG(), this.sqlManager);
			boolean isE1 = UtilitySITAT.isE1(fase.getW3FACIG(), this.sqlManager);
		    boolean isOrd = UtilitySITAT.isOrd(fase.getW3FACIG(), this.sqlManager);
		      
		    if (!isE1 && isS2 && isOrd) {
				logger.error("La richiesta di primo invio di Fase iniziale di esecuzione semplificata del contratto non previsto per il lotto con CIG=" + fase.getW3FACIG());
				this.setEsito(datiAggiornamento, StatoComunicazione.STATO_WARNING.getStato(), "Primo invio di inizio esecuzione semplificata del contratto non previsto");

				logger.error("La richiesta di primo invio ha un lotto con importo maggiore o uguale a 40000 e non escluso");
				return;
			}
		}

		this.insertDatiFlusso(doc, datiAggiornamento, true);
	}

	private void insertDatiFlusso(RichiestaRichiestaRispostaSincronaInizioContrattoSotto150000Document doc, DataColumnContainer datiAggiornamento, boolean primoInvio) throws SQLException,
			GestoreException {

		Tab8BisType tab8Bis = doc.getRichiestaRichiestaRispostaSincronaInizioContrattoSotto150000().getTab8Bis();
		FaseEstesaType fase = doc.getRichiestaRichiestaRispostaSincronaInizioContrattoSotto150000().getFase();

		if (fase.getW3FACIG() != null) {
			Long[] longArray = this.getCodGaraCodLottByCIG(fase.getW3FACIG());
			Long codGara = longArray[0];
			Long codLott = longArray[1];
			if (fase.getW9FLCFSA() != null) {
				String pkUffint = this.getCodiceUfficioIntestatario(fase.getW9FLCFSA());

				this.updateW9Fasi(codGara, codLott, fase, datiAggiornamento, primoInvio);

				// predisposizione dati W9INIZ (tab8bis): i dati facoltativi
				// vengono testati
				// con il metodo .isSetXXX per verificare se nel tracciato sono
				// valorizzati
				DataColumnContainer dccIniz = new DataColumnContainer(
						new DataColumn[] { new DataColumn("W9INIZ.CODGARA", new JdbcParametro(JdbcParametro.TIPO_NUMERICO, codGara)),
								new DataColumn("W9INIZ.CODLOTT", new JdbcParametro(JdbcParametro.TIPO_NUMERICO, codLott)),
								new DataColumn("W9INIZ.NUM_INIZ", new JdbcParametro(JdbcParametro.TIPO_NUMERICO, 1)) });

				if (tab8Bis != null) {
					if (tab8Bis.getW3RISERVA() != null) {
						dccIniz.addColumn("W9INIZ.FLAG_RISERVA", JdbcParametro.TIPO_TESTO, this.getFlagSNDB(tab8Bis.getW3RISERVA()).toString());
					}
					if (tab8Bis.getW3DVERBIN() != null) {
						dccIniz.addColumn("W9INIZ.DATA_VERB_INIZIO", JdbcParametro.TIPO_DATA, tab8Bis.getW3DVERBIN().getTime());
					}
					if (tab8Bis.getW3DTERM1() != null) {
						dccIniz.addColumn("W9INIZ.DATA_TERMINE", JdbcParametro.TIPO_DATA, tab8Bis.getW3DTERM1().getTime());
					}
					if (tab8Bis.isSetW3DATASTI()) {
						dccIniz.addColumn("W9INIZ.DATA_STIPULA", JdbcParametro.TIPO_DATA, tab8Bis.getW3DATASTI().getTime());
					}
				}
				dccIniz.insert("W9INIZ", this.sqlManager);

				// Scheda sicurezza
				if (doc.getRichiestaRichiestaRispostaSincronaInizioContrattoSotto150000().isSetTab8Bis2()) {
					Tab8Bis2Type tab8bis2 = doc.getRichiestaRichiestaRispostaSincronaInizioContrattoSotto150000().getTab8Bis2();
					DataColumnContainer dccSicurezza = new DataColumnContainer(new DataColumn[] { new DataColumn("W9SIC.CODGARA", new JdbcParametro(JdbcParametro.TIPO_NUMERICO, codGara)),
							new DataColumn("W9SIC.CODLOTT", new JdbcParametro(JdbcParametro.TIPO_NUMERICO, codLott)),
							new DataColumn("W9SIC.NUM_SIC", new JdbcParametro(JdbcParametro.TIPO_NUMERICO, new Long("1"))) });
					if (tab8bis2 != null) {
						if (tab8bis2.isSetW3PIANSCIC()) {
							dccSicurezza.addColumn("W9SIC.PIANSCIC", JdbcParametro.TIPO_TESTO, this.getFlagSNDB(tab8bis2.getW3PIANSCIC()).toString());
						}
						if (tab8bis2.isSetW3DIROPE()) {
							dccSicurezza.addColumn("W9SIC.DIROPE", JdbcParametro.TIPO_TESTO, this.getFlagSNDB(tab8bis2.getW3DIROPE()).toString());
						}
						if (tab8bis2.isSetW3SITUTOR()) {
							dccSicurezza.addColumn("W9SIC.TUTOR", JdbcParametro.TIPO_TESTO, this.getFlagSNDB(tab8bis2.getW3SITUTOR()));
						}
					}
					dccSicurezza.insert("W9SIC", this.sqlManager);
				}

				// Incarichi professionali
				Tab101Type tab101 = null;
				int k = 0;
				for (int i = 0; i < doc.getRichiestaRichiestaRispostaSincronaInizioContrattoSotto150000().getTab8Bis1Array().length; i++) {
					tab101 = doc.getRichiestaRichiestaRispostaSincronaInizioContrattoSotto150000().getTab8Bis1Array()[i];
					if (tab101.getW3SEZIONE().equals("IN")) {
						// Arch2Type arch2 = tab101.getArch2();
						if (tab101 != null && tab101.getArch2() != null) {
							String pkTecni = this.getTecnico(tab101.getArch2(), pkUffint);
							k = k + 1;
							DataColumnContainer datiInca = new DataColumnContainer(new DataColumn[] { new DataColumn("W9INCA.CODGARA", new JdbcParametro(JdbcParametro.TIPO_NUMERICO, codGara)),
									new DataColumn("W9INCA.CODLOTT", new JdbcParametro(JdbcParametro.TIPO_NUMERICO, codLott)) });
							datiInca.addColumn("W9INCA.NUM", JdbcParametro.TIPO_NUMERICO, new Long(fase.getW3NUM5()));
							datiInca.addColumn("W9INCA.NUM_INCA", JdbcParametro.TIPO_NUMERICO, new Long(k));
							datiInca.addColumn("W9INCA.SEZIONE", JdbcParametro.TIPO_TESTO, "IN");
							datiInca.addColumn("W9INCA.CODTEC", JdbcParametro.TIPO_TESTO, pkTecni);

							datiInca.addColumn("W9INCA.ID_RUOLO", JdbcParametro.TIPO_NUMERICO, new Long(tab101.getW3IDRUOLO().toString()));
							if (tab101.isSetW3CIGPROG()) {
								datiInca.addColumn("W9INCA.CIG_PROG_ESTERNA", JdbcParametro.TIPO_TESTO, tab101.getW3CIGPROG());
							}
							if (tab101.isSetW3DATAAFF()) {
								datiInca.addColumn("W9INCA.DATA_AFF_PROG_ESTERNA", JdbcParametro.TIPO_DATA, tab101.getW3DATAAFF().getTime());
							}
							if (tab101.isSetW3DATACON()) {
								datiInca.addColumn("W9INCA.DATA_CONS_PROG_ESTERNA", JdbcParametro.TIPO_DATA, tab101.getW3DATACON().getTime());
							}

							datiInca.insert("W9INCA", this.sqlManager);
						}
					}
				}

				// Misure aggiuntive e migliorative per la sicurezza (W9MISSIC)
				if (doc.getRichiestaRichiestaRispostaSincronaInizioContrattoSotto150000().isSetTab8Bis3()) {
					Tab13Type tab13 = doc.getRichiestaRichiestaRispostaSincronaInizioContrattoSotto150000().getTab8Bis3();

					DataColumnContainer datiW9Missic = new DataColumnContainer(new DataColumn[] { new DataColumn("W9MISSIC.CODGARA", new JdbcParametro(JdbcParametro.TIPO_NUMERICO, codGara)),
							new DataColumn("W9MISSIC.CODLOTT", new JdbcParametro(JdbcParametro.TIPO_NUMERICO, codLott)),
							new DataColumn("W9MISSIC.NUM_MISS", new JdbcParametro(JdbcParametro.TIPO_NUMERICO, new Long(fase.getW3NUM5()))) });

					if (tab13 != null) {
						if (tab13.getW3MSDESCMIS() != null) {
							datiW9Missic.addColumn("W9MISSIC.DESCMIS", JdbcParametro.TIPO_TESTO, tab13.getW3MSDESCMIS());
						}
						if (tab13.getArch3() != null) {
							String pkImpresa = this.gestioneImpresa(tab13.getArch3(), pkUffint);
							datiW9Missic.addColumn("W9MISSIC.CODIMP", JdbcParametro.TIPO_TESTO, pkImpresa);
						}
					}
					datiW9Missic.insert("W9MISSIC", this.sqlManager);
				}

				// Allegati alle misure aggiuntive e migliorative per la
				// sicurezza (Dati di W9DOCGARA)
				if (doc.getRichiestaRichiestaRispostaSincronaInizioContrattoSotto150000().sizeOfTab8Bis31Array() > 0) {
					Tab41Type[] arrayTab41 = doc.getRichiestaRichiestaRispostaSincronaInizioContrattoSotto150000().getTab8Bis31Array();

					for (int iu = 0; iu < arrayTab41.length; iu++) {
						Tab41Type tab41 = arrayTab41[iu];

						datiAggiornamento.addColumn("W9DOCFASE.CODGARA", JdbcParametro.TIPO_NUMERICO, codGara);
						datiAggiornamento.addColumn("W9DOCFASE.CODLOTT", JdbcParametro.TIPO_NUMERICO, codLott);
						datiAggiornamento.addColumn("W9DOCFASE.FASE_ESECUZIONE", JdbcParametro.TIPO_NUMERICO, new Long(CostantiW9.MISURE_AGGIUNTIVE_SICUREZZA));
						datiAggiornamento.addColumn("W9DOCFASE.NUM_FASE", JdbcParametro.TIPO_NUMERICO, new Long(1));
						datiAggiornamento.addColumn("W9DOCFASE.NUMDOC", JdbcParametro.TIPO_NUMERICO, new Long(iu + 1));
						if (tab41 != null && tab41.getW9DGTITOLO() != null) {
							datiAggiornamento.addColumn("W9DOCFASE.TITOLO", JdbcParametro.TIPO_TESTO, tab41.getW9DGTITOLO());
						}
						ByteArrayOutputStream fileAllegato = new ByteArrayOutputStream();
						try {
							fileAllegato.write(tab41.getFile());
						} catch (IOException e) {
							throw new GestoreException("Errore durante la lettura del file allegato presente nella richiesta XML", null, e);
						}
						datiAggiornamento.addColumn("W9DOCFASE.FILE_ALLEGATO", JdbcParametro.TIPO_BINARIO, fileAllegato);
						datiAggiornamento.insert("W9DOCFASE", this.sqlManager);
					}
				}
			}
		}
		// se la procedura di aggiornamento e' andata a buon fine, si aggiorna
		// lo
		// stato dell'importazione
		this.setEsito(datiAggiornamento, StatoComunicazione.STATO_IMPORTATA.getStato(), null);
	}

	/**
	 * Verifica se esiste in banca dati una fase iniziale per il lotto indicato
	 * a partire dal cig fornito nel tracciato.
	 * 
	 * @param fase
	 *            elemento fase del flusso
	 * @return true se l'elemento esiste, false altrimenti
	 * @throws SQLException
	 */
	private boolean existsInizio(FaseEstesaType fase) throws SQLException {
		Long numeroOccorrenze = (Long) this.sqlManager.getObject("select count(w9iniz.codgara) from w9iniz, w9lott " + "where w9iniz.codgara = w9lott.codgara and w9iniz.codlott = w9lott.codlott "
				+ "and w9lott.cig = ?", new Object[] { fase.getW3FACIG() });
		return numeroOccorrenze.intValue() > 0;
	}

	@Override
	protected void manageRettifica(XmlObject documento, DataColumnContainer datiAggiornamento, boolean ignoreWarnings) throws GestoreException, SQLException {
		// TODO Auto-generated method stub

	}

}