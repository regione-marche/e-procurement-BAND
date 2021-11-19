package it.eldasoft.w9.bl;

import it.avlp.simog.massload.xmlbeans.CUPLOTTOType;
import it.avlp.simog.massload.xmlbeans.CategLottoType;
import it.avlp.simog.massload.xmlbeans.GaraType;
import it.avlp.simog.massload.xmlbeans.LottoType;
import it.avlp.simog.massload.xmlbeans.SchedaType;
import it.eldasoft.gene.bl.GeneManager;
import it.eldasoft.gene.bl.SqlManager;
import it.eldasoft.gene.web.struts.tags.gestori.GestoreException;
import it.eldasoft.utils.sicurezza.CriptazioneException;
import it.eldasoft.w9.common.SituazioneGaraLotto;
import it.eldasoft.w9.utils.UtilitySITAT;
import it.toscana.rete.rfc.sitat.types.W3Z05Type;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class ConsultaGaraUnificatoManager {

	/**
	 * Logger di classe.
	 */
	private static Logger logger = Logger.getLogger(ConsultaGaraUnificatoManager.class);

	/** Manager per le transazioni SQL. */
	private SqlManager sqlManager;

	/** W9Manager. */
	private W9Manager w9Manager;

	/** Manager di funzionalita' generali. */
	private GeneManager geneManager;

	/**
	 * Set sqlManager.
	 * 
	 * @param sqlManager
	 *            the sqlManager to set
	 */
	public void setSqlManager(SqlManager sqlManager) {
		this.sqlManager = sqlManager;
	}

	/**
	 * Set W9Manager.
	 * 
	 * @param w9Manager
	 *            the w9Manager to set
	 */
	public void setW9Manager(W9Manager w9Manager) {
		this.w9Manager = w9Manager;
	}

	/**
	 * Set geneManager.
	 * 
	 * @param geneManager
	 *            geneManager da settare internamente alla classe.
	 */
	public void setGeneManager(GeneManager geneManager) {
		this.geneManager = geneManager;
	}

	public synchronized ConsultaLottoBean consultaGaraUnificatoWS(final String codiceCIG, final String idAvGara, final String codUffInt,
	    final int syscon, final SchedaType schedaType, final GaraType garaType, final LottoType lottoType) 
	        throws SQLException, GestoreException, CriptazioneException {

		if (logger.isDebugEnabled()) {
			logger.debug("consultaGaraUnificatoWS: inizio metodo");
		}

		ConsultaLottoBean consultaLottoBean = new ConsultaLottoBean(codiceCIG, true, false);
		
		long idGara = garaType.getIDGARA();
		String cfUffInt = (String) this.sqlManager.getObject("select CFEIN from UFFINT where CODEIN=?", new Object[] { codUffInt });
		String cfAnac = (String) this.sqlManager.getObject("select CFANAC from UFFINT where CODEIN=?", new Object[] { codUffInt });

		if ((StringUtils.isEmpty(idAvGara) || (("" + garaType.getIDGARA()).equals(idAvGara))) 
				&& (garaType.getCFAMMINISTRAZIONE().equals(cfUffInt) || garaType.getCFAMMINISTRAZIONE().equals(cfAnac))
				&& lottoType.getDATAPUBBLICAZIONE() != null) {

			// Flag che indica se in DB esiste la gara con idAvGara specificato dall'utente
			boolean esisteGara = this.isGaraEsistente("" + garaType.getIDGARA());

			if (logger.isDebugEnabled()) {
				logger.debug("Inizio import del xml fornito dal WS dopo controllo su IDAVGARA e CF stazione appaltante");
				logger.debug("Nella base dati " + (esisteGara ? "esiste" : "non esiste") + " la gara con IDAVGARA = '" + idAvGara + "'");
			}

			Long codGara = null;
			if (esisteGara) {
				codGara = (Long) this.sqlManager.getObject("select CODGARA from W9GARA where idAVGARA=?", new Object[] { "" + idGara });
			} else {
				Long maxCodGara = (Long) this.sqlManager.getObject("select max(CODGARA)+1 from W9GARA", new Object[] {});
				if (maxCodGara == null) {
					codGara = new Long(1);
				} else {
					codGara = maxCodGara;
				}
			}

	    // Estrazione del campo TECNI.CODTEC per valorizzare i campi W9GARA.RUP e W9LOTT.RUP
      String codTec = null;
      String cfRup = null;
      if (schedaType != null && schedaType.getDatiScheda() != null && schedaType.getDatiScheda().getDatiComuni() != null) {
        cfRup = schedaType.getDatiScheda().getDatiComuni().getCFRUP();
      }
      if (StringUtils.isEmpty(cfRup)) {
        if (garaType != null) {
          cfRup = garaType.getCFUTENTE();
        }
      }
			
      codTec = (String) this.sqlManager.getObject("select CODTEC from TECNI where SYSCON=? and CGENTEI=? and UPPER(CFTEC)=?", 
          new Object[] { new Long(syscon), codUffInt, cfRup.toUpperCase() });
      if (StringUtils.isEmpty(codTec)) {
        codTec = (String) this.sqlManager.getObject("select CODTEC from TECNI where SYSCON is null and CGENTEI=? and UPPER(CFTEC)=?", 
            new Object[] { codUffInt, cfRup.toUpperCase() });
        if (StringUtils.isEmpty(codTec)) {
          cfRup = this.insertTecnico(codUffInt, syscon);
          codTec = (String) this.sqlManager.getObject("select CODTEC from TECNI where SYSCON=? and CGENTEI=? and UPPER(CFTEC)=?", 
              new Object[] { new Long(syscon), codUffInt, cfRup.toUpperCase() });
        } else {
          this.sqlManager.update("update TECNI set SYSCON=? where CODTEC=?", new Object[] { new Long(syscon), codTec });
        }
      }

			boolean esisteTecnico = StringUtils.isNotEmpty(codTec);

			if (esisteTecnico) {
			  
        GregorianCalendar dataCreazioneGara = null;
        if (garaType.isSetDATACREAZIONE()) {
          dataCreazioneGara = new GregorianCalendar(
              garaType.getDATACREAZIONE().get(Calendar.YEAR), 
              garaType.getDATACREAZIONE().get(Calendar.MONTH), 
              garaType.getDATACREAZIONE().get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        }
        
        GregorianCalendar dataPerfezionamentoBando = null;
        if (garaType.isSetDATAPERFEZIONAMENTOBANDO()) {
          dataPerfezionamentoBando = new GregorianCalendar(
              garaType.getDATAPERFEZIONAMENTOBANDO().get(Calendar.YEAR),
              garaType.getDATAPERFEZIONAMENTOBANDO().get(Calendar.MONTH),
              garaType.getDATAPERFEZIONAMENTOBANDO().get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        }
        
        GregorianCalendar dataAttuazioneSimog2 = UtilitySITAT.getDataAttuazioneSimog2(this.sqlManager);
			  
				if (!esisteGara) {
					List<String> listaSqlGaraCampi = new ArrayList<String>();
					listaSqlGaraCampi.add("CODGARA");
					listaSqlGaraCampi.add("SYSCON");
					listaSqlGaraCampi.add("OGGETTO");
					listaSqlGaraCampi.add("PROV_DATO");
					listaSqlGaraCampi.add("RUP");
					listaSqlGaraCampi.add("IMPORTO_GARA");
					listaSqlGaraCampi.add("NLOTTI");
					listaSqlGaraCampi.add("CODEIN");
					listaSqlGaraCampi.add("RIC_ALLUV");
					listaSqlGaraCampi.add("SITUAZIONE");
					listaSqlGaraCampi.add("PREV_BANDO");
					listaSqlGaraCampi.add("VER_SIMOG");
					
					List<Object> listaSqlGaraParams = new ArrayList<Object>();
					listaSqlGaraParams.add(codGara);
					listaSqlGaraParams.add(syscon);
					listaSqlGaraParams.add(garaType.getOGGETTO());
					listaSqlGaraParams.add(new Long(2)); // Provenienza SIMOG
					listaSqlGaraParams.add(codTec);
					listaSqlGaraParams.add(new Double(garaType.getIMPORTOGARA().doubleValue()));
					listaSqlGaraParams.add(new Long(1)); // NLOTTI
					listaSqlGaraParams.add(codUffInt);  // CODEIN
					listaSqlGaraParams.add("2");  // RIC_ALLUV
					listaSqlGaraParams.add(new Long(1));  // SITUAZIONE
					listaSqlGaraParams.add("2");  // PREV_BANDO
					
					if (dataCreazioneGara == null) {
				    listaSqlGaraParams.add(new Long(1));
					} else {
					  if (dataAttuazioneSimog2 != null) {
					    if (dataCreazioneGara.before(dataAttuazioneSimog2)) {
		            listaSqlGaraParams.add(new Long(1));
		          } else {
		            listaSqlGaraParams.add(new Long(2));
		          }
					  } else {
					    listaSqlGaraParams.add(new Long(1));
					  }
					}
					
					if (schedaType.isSetDatiScheda()) {
						listaSqlGaraCampi.add("FLAG_SA_AGENTE");
						listaSqlGaraParams.add(it.avlp.simog.massload.xmlbeans.FlagSNType.S.equals(schedaType.getDatiScheda().getDatiComuni().getFLAGSAAGENTE()) ? "1" : "2");
						listaSqlGaraCampi.add("DENOM_SA_AGENTE");
						listaSqlGaraParams.add(schedaType.getDatiScheda().getDatiComuni().getDENAMMAGENTE().toString());
						listaSqlGaraCampi.add("CF_SA_AGENTE");
						listaSqlGaraParams.add(schedaType.getDatiScheda().getDatiComuni().getCFAMMAGENTE().toString());
            
						if (garaType.isSetDURATAACCQUADROCONVENZIONEGARA()) {
              listaSqlGaraCampi.add("DURATA_ACCQUADRO");
              listaSqlGaraParams.add(new Long(garaType.getDURATAACCQUADROCONVENZIONEGARA()));
            } else  if (schedaType.isSetDatiScheda() &&
                schedaType.getDatiScheda().getDatiComuni().isSetDURATAACCQUADROCONVENZIONE()) {
              listaSqlGaraCampi.add("DURATA_ACCQUADRO");
              listaSqlGaraParams.add(new Long(schedaType.getDatiScheda().getDatiComuni().getDURATAACCQUADROCONVENZIONE()));
            }
					}

					if (garaType.isSetDATAPERFEZIONAMENTOBANDO()) {
					  listaSqlGaraCampi.add("DATA_PUBBLICAZIONE");
            listaSqlGaraParams.add(garaType.getDATAPERFEZIONAMENTOBANDO().getTime());
					}
					
					if (garaType.getIDGARA() != 0) {
						listaSqlGaraCampi.add("IDAVGARA");
						listaSqlGaraParams.add("" + garaType.getIDGARA());
					}

					if (garaType.isSetMODOREALIZZAZIONE()) {
						listaSqlGaraCampi.add("TIPO_APP");
						listaSqlGaraParams.add(new Long(garaType.getMODOREALIZZAZIONE()));
					}

					if (garaType.isSetCIGACCQUADRO()) {
						listaSqlGaraCampi.add("CIG_ACCQUADRO");
						listaSqlGaraParams.add(garaType.getCIGACCQUADRO());
					}

					if (garaType.isSetMODOINDIZIONE()) {
						listaSqlGaraCampi.add("ID_MODO_INDIZIONE");
						listaSqlGaraParams.add(new Long(garaType.getMODOINDIZIONE()));
					}

					if (garaType.isSetTIPOSCHEDA()) {
						listaSqlGaraCampi.add("FLAG_ENTE_SPECIALE");
						listaSqlGaraParams.add(garaType.getTIPOSCHEDA().toString());
					}

					String codiceCentroCostoFromSIMOG = garaType.getIDSTAZIONEAPPALTANTE();
					String descrCentroCostoFromSIMOG = garaType.getDENOMSTAZIONEAPPALTANTE();

          if (garaType.isSetURGENZADL133()) {
            listaSqlGaraCampi.add("SOMMA_URGENZA");
            listaSqlGaraParams.add(it.avlp.simog.massload.xmlbeans.FlagSNType.S.equals(garaType.getURGENZADL133()) ? "1" : "2");
          }
					
					Long idCentroCosto = (Long) this.sqlManager.getObject("select IDCENTRO from CENTRICOSTO where UPPER(CODCENTRO)=? and CODEIN=?",
							new Object[] { codiceCentroCostoFromSIMOG.toUpperCase(), codUffInt });

					if (idCentroCosto == null) {
						Long maxIdCentroCosto = (Long) this.sqlManager.getObject("select max(IDCENTRO)+1 from CENTRICOSTO", new Object[] {});
						if (maxIdCentroCosto == null) {
							idCentroCosto = new Long(1);
						} else {
							idCentroCosto = maxIdCentroCosto;
						}

						this.sqlManager.update("INSERT INTO CENTRICOSTO (IDCENTRO,CODEIN,CODCENTRO,DENOMCENTRO) VALUES (?,?,?,?)", 
						    new Object[] { idCentroCosto, codUffInt, codiceCentroCostoFromSIMOG, StringUtils.substring(descrCentroCostoFromSIMOG,0,250) });
					} else {
					  this.sqlManager.update("UPDATE CENTRICOSTO set DENOMCENTRO=? where IDCENTRO=?", 
                new Object[] { StringUtils.substring(descrCentroCostoFromSIMOG,0,250), idCentroCosto });
					}

					listaSqlGaraCampi.add("IDCC");
					listaSqlGaraParams.add(idCentroCosto);

					// Inserimento in W9GARA
					StringBuffer listaCampi = new StringBuffer("");
					StringBuffer listaParams = new StringBuffer("");
					for (int ir = 0; ir < listaSqlGaraCampi.size(); ir++) {
						listaCampi.append(listaSqlGaraCampi.get(ir) + ", ");
						listaParams.append("?,");
					}

					String sqlInsertW9GARA = "insert into W9GARA (LISTACAMPI) values (LISTAPARAMS)";
					sqlInsertW9GARA = sqlInsertW9GARA.replaceAll("LISTACAMPI", listaCampi.toString().substring(0, listaCampi.length() - 2));
					sqlInsertW9GARA = sqlInsertW9GARA.replaceAll("LISTAPARAMS", listaParams.toString().substring(0, listaParams.length() - 1));
					this.sqlManager.update(sqlInsertW9GARA, listaSqlGaraParams.toArray());

					// Pubblicazione
					if (schedaType.getDatiScheda() != null && schedaType.getDatiScheda().getPubblicazione() != null) {
						it.avlp.simog.massload.xmlbeans.PubblicazioneType pubblicazione = schedaType.getDatiScheda().getPubblicazione();

						List<String> listaSqlPubblicazioneCampi = new ArrayList<String>();
						List<Object> listaSqlPubblicazioneParams = new ArrayList<Object>();

						listaSqlPubblicazioneCampi.add("CODGARA");
						listaSqlPubblicazioneParams.add(codGara);

						listaSqlPubblicazioneCampi.add("CODLOTT");
						listaSqlPubblicazioneParams.add(new Long(1));

						listaSqlPubblicazioneCampi.add("NUM_APPA");
						listaSqlPubblicazioneParams.add(new Long(1));

						listaSqlPubblicazioneCampi.add("NUM_PUBB");
						listaSqlPubblicazioneParams.add(new Long(1));

						if (pubblicazione.getDATAGUCE() != null) {
							listaSqlPubblicazioneCampi.add("DATA_GUCE");
							listaSqlPubblicazioneParams.add(pubblicazione.getDATAGUCE().getTime());
						}

						if (pubblicazione.getDATAGURI() != null) {
							listaSqlPubblicazioneCampi.add("DATA_GURI");
							listaSqlPubblicazioneParams.add(pubblicazione.getDATAGURI().getTime());
						}

						if (pubblicazione.getDATAALBO() != null) {
							listaSqlPubblicazioneCampi.add("DATA_ALBO");
							listaSqlPubblicazioneParams.add(pubblicazione.getDATAALBO().getTime());
						}

						if (pubblicazione.getQUOTIDIANINAZ() > 0) {
							listaSqlPubblicazioneCampi.add("QUOTIDIANI_NAZ");
							listaSqlPubblicazioneParams.add(pubblicazione.getQUOTIDIANINAZ());
						}

						if (pubblicazione.getQUOTIDIANIREG() > 0) {
							listaSqlPubblicazioneCampi.add("QUOTIDIANI_REG");
							listaSqlPubblicazioneParams.add(pubblicazione.getQUOTIDIANIREG());
						}

						if (pubblicazione.getPROFILOCOMMITTENTE() != null) {
							listaSqlPubblicazioneCampi.add("PROFILO_COMMITTENTE");
							listaSqlPubblicazioneParams.add(it.avlp.simog.massload.xmlbeans.FlagSNType.S.equals(pubblicazione.getPROFILOCOMMITTENTE()) ? "1" : "2");
						}

						if (pubblicazione.getSITOMINISTEROINFTRASP() != null) {
							listaSqlPubblicazioneCampi.add("SITO_MINISTERO_INF_TRASP");
							listaSqlPubblicazioneParams.add(it.avlp.simog.massload.xmlbeans.FlagSNType.S.equals(pubblicazione.getSITOMINISTEROINFTRASP()) ? "1" : "2");
						}

						if (pubblicazione.getSITOOSSERVATORIOCP() != null) {
							listaSqlPubblicazioneCampi.add("SITO_OSSERVATORIO_CP");
							listaSqlPubblicazioneParams.add(it.avlp.simog.massload.xmlbeans.FlagSNType.S.equals(pubblicazione.getSITOOSSERVATORIOCP()) ? "1" : "2");
						}

						if (pubblicazione.getDATABORE() != null) {
							listaSqlPubblicazioneCampi.add("DATA_BORE");
							listaSqlPubblicazioneParams.add(pubblicazione.getDATABORE().getTime());
						}

						if (pubblicazione.getPERIODICI() > 0) {
							listaSqlPubblicazioneCampi.add("PERIODICI");
							listaSqlPubblicazioneParams.add(pubblicazione.getPERIODICI());
						}

						// Inserimento W9PUBB
						String sqlInsertW9PUBB = "insert into W9PUBB (LISTACAMPI) values (LISTAPARAMS)";
						listaCampi = new StringBuffer("");
						listaParams = new StringBuffer("");
						for (int i = 0; i < listaSqlPubblicazioneCampi.size(); i++) {
							listaCampi.append(listaSqlPubblicazioneCampi.get(i) + ", ");
							listaParams.append("?, ");
						}

						sqlInsertW9PUBB = sqlInsertW9PUBB.replaceAll("LISTACAMPI", listaCampi.toString().substring(0, listaCampi.length() - 2));
						sqlInsertW9PUBB = sqlInsertW9PUBB.replaceAll("LISTAPARAMS", listaParams.toString().substring(0, listaParams.length() - 2));

						this.sqlManager.update(sqlInsertW9PUBB, listaSqlPubblicazioneParams.toArray());
					}
				}

				Long codLott = (Long) this.sqlManager.getObject(
				    "select max(CODLOTT)+1 from W9LOTT where CODGARA=?", new Object[] { codGara });
				if (codLott == null) {
					codLott = new Long(1);
				}

				Long numeroLotti = (Long) this.sqlManager.getObject(
				    "select count(*) from W9LOTT where CODGARA=?", new Object[] { codGara });
				numeroLotti++;

				List<String> listaSqlLottoCampi = new ArrayList<String>();
				List<Object> listaSqlLottoParams = new ArrayList<Object>();
				
				listaSqlLottoCampi.add("CODGARA");
				listaSqlLottoParams.add(codGara);
				listaSqlLottoCampi.add("CODLOTT");
				listaSqlLottoParams.add(codLott);
        listaSqlLottoCampi.add("OGGETTO");
        listaSqlLottoParams.add(lottoType.getOGGETTO());
        listaSqlLottoCampi.add("RUP");
        listaSqlLottoParams.add(codTec); // RUP
        listaSqlLottoCampi.add("IMPORTO_LOTTO");
        if (lottoType.getIMPORTOATTUAZIONESICUREZZA() != null) {
          listaSqlLottoParams.add(new Double(lottoType.getIMPORTOLOTTO().doubleValue()
              - new Double(lottoType.getIMPORTOATTUAZIONESICUREZZA()).doubleValue()));
        } else {
          listaSqlLottoParams.add(new Double(lottoType.getIMPORTOLOTTO().doubleValue()));
        }
        listaSqlLottoCampi.add("CPV");
        listaSqlLottoParams.add(lottoType.getCPV()); // CPV
        listaSqlLottoCampi.add("ID_SCELTA_CONTRAENTE");
        listaSqlLottoParams.add(Long.parseLong(lottoType.getIDSCELTACONTRAENTE())); // Id Scelta contraente
        listaSqlLottoCampi.add("ID_CATEGORIA_PREVALENTE");
        String categoria = (String) sqlManager.getObject(
            "select CODSITAT from W9CODICI_AVCP where CODAVCP = ?  and TABCOD = 'W3z03' ",
                new Object[] { lottoType.getIDCATEGORIAPREVALENTE() });
        // se manca corrispondenza inserisco il codice non decodificato
        if (StringUtils.isEmpty(categoria)) {
          categoria = lottoType.getIDCATEGORIAPREVALENTE();
        }
        listaSqlLottoParams.add(categoria); // Id Categoria Prevalente
        listaSqlLottoCampi.add("NLOTTO");
        listaSqlLottoParams.add(codLott); // NLOTTO (uguale a W9LOTT.CODLOTT)
				listaSqlLottoCampi.add("CIG");
				listaSqlLottoParams.add(codiceCIG); // CIG
				listaSqlLottoCampi.add("SITUAZIONE");
        listaSqlLottoParams.add(new Long(SituazioneGaraLotto.SITUAZIONE_IN_GARA.getSituazione())); // Situazione
				listaSqlLottoCampi.add("DATA_CONSULTA_GARA");
				listaSqlLottoParams.add(new Date()); // Data consulta gara
				listaSqlLottoCampi.add("EXSOTTOSOGLIA");
				// ExSottoSoglia: se lotto.Importo < 150k e lotto.DataPubblicazione < 29/10/2013
				Double tempImportoLotto = new Double(lottoType.getIMPORTOLOTTO().doubleValue());
				boolean isDataPubbPrecedente =  false;
				boolean isImportoLottoSottoSoglia = false;
				if (tempImportoLotto.compareTo(new Double(150000)) < 0) {
				  isImportoLottoSottoSoglia = true;
				}
        if (isImportoLottoSottoSoglia && dataPerfezionamentoBando != null) {
          if (dataPerfezionamentoBando.before(new GregorianCalendar(2013, 9, 29, 0, 0, 0))) {
            isDataPubbPrecedente = true;
          }
        }
				
				if (isImportoLottoSottoSoglia && isDataPubbPrecedente) {
				  listaSqlLottoParams.add("1");
				} else {
				  listaSqlLottoParams.add("2");
				}
				
        if (dataPerfezionamentoBando != null && dataAttuazioneSimog2 != null 
            && dataPerfezionamentoBando.before(dataAttuazioneSimog2) ) {
          listaSqlLottoCampi.add("ID_SCELTA_CONTRAENTE_50");
          listaSqlLottoParams.add(this.getIdSceltaContraente50(lottoType.getIDSCELTACONTRAENTE()));
        }
				
				if (garaType.getTIPOSCHEDA() != null) {
					listaSqlLottoCampi.add("FLAG_ENTE_SPECIALE");
					listaSqlLottoParams.add(garaType.getTIPOSCHEDA().toString());
				}

				listaSqlLottoCampi.add("DAEXPORT");
				listaSqlLottoParams.add("1");

				listaSqlLottoCampi.add("IMPORTO_ATTUAZIONE_SICUREZZA");
				if (lottoType.getIMPORTOATTUAZIONESICUREZZA() != null) {
					listaSqlLottoParams.add(new Double(lottoType.getIMPORTOATTUAZIONESICUREZZA()));
				} else {
					listaSqlLottoParams.add(new Double(0));
				}

				listaSqlLottoCampi.add("IMPORTO_TOT");
				listaSqlLottoParams.add(new Double(lottoType.getIMPORTOLOTTO().doubleValue()));

				listaSqlLottoCampi.add("CLASCAT");

				double importoLotto = lottoType.getIMPORTOLOTTO().doubleValue();
				if (importoLotto <= 258000) {
					listaSqlLottoParams.add("I");
				} else if (importoLotto <= 516000) {
					listaSqlLottoParams.add("II");
				} else if (importoLotto <= 1033000) {
					listaSqlLottoParams.add("III");
				} else if (importoLotto <= 1500000) {
					listaSqlLottoParams.add("IIIB");
				} else if (importoLotto <= 2582000) {
					listaSqlLottoParams.add("IV");
				} else if (importoLotto <= 3500000) {
					listaSqlLottoParams.add("IVB");
				} else if (importoLotto <= 5165000) {
					listaSqlLottoParams.add("V");
				} else if (importoLotto <= 10329000) {
					listaSqlLottoParams.add("VI");
				} else if (importoLotto <= 15494000) {
					listaSqlLottoParams.add("VII");
				} else {
					listaSqlLottoParams.add("VIII");
				}

				if (lottoType.getTIPOCONTRATTO() != null) {
					listaSqlLottoCampi.add("TIPO_CONTRATTO");
					listaSqlLottoParams.add(lottoType.getTIPOCONTRATTO().toString());
					listaSqlLottoCampi.add("MANOD");
					if (lottoType.getTIPOCONTRATTO().toString().equalsIgnoreCase(W3Z05Type.L.toString())) {
						listaSqlLottoParams.add("1");
					} else {
						listaSqlLottoParams.add("2");
					}
				} else {
					listaSqlLottoCampi.add("MANOD");
					listaSqlLottoParams.add("2");
				}

				listaSqlLottoCampi.add("COMCON");
				listaSqlLottoParams.add("2");
				if (lottoType.getLUOGOISTAT() != null) {
					String luogoIstat = lottoType.getLUOGOISTAT();

					if (luogoIstat.length() == 6) {
						String codiceIstatRegione = (String) this.sqlManager.getObject(
						    "select tabcod3 from tabsche where tabcod = 'S2003' and tabcod1='09' and tabcod3 like ?", 
						    new Object[] { "%".concat(luogoIstat) });
						if (StringUtils.isNotEmpty(codiceIstatRegione)) {
							luogoIstat = codiceIstatRegione;
						} else {
							luogoIstat = null;
						}
					}
					listaSqlLottoCampi.add("LUOGO_ISTAT");
					listaSqlLottoParams.add(luogoIstat);
				}

				if (lottoType.isSetLUOGONUTS()) {
					listaSqlLottoCampi.add("LUOGO_NUTS");
					String tmp = this.verificaNUTS(lottoType.getLUOGONUTS());
					if (tmp != null)
					  listaSqlLottoParams.add(tmp);
					else 
					  listaSqlLottoParams.add(lottoType.getLUOGONUTS());
				}
				
				// Valorizzazione campo ART_E1: S -> 1, N o null -> 2
        listaSqlLottoCampi.add("ART_E1");
        if (lottoType.isSetIDESCLUSIONE()) {
          String strArtEsclusione = lottoType.getIDESCLUSIONE();
          int artEsclusione = Integer.parseInt(strArtEsclusione);
          if (artEsclusione <= 7 || artEsclusione == 11) {
            listaSqlLottoParams.add("1");
          } else {
            listaSqlLottoParams.add("2");
          }
        } else {
          listaSqlLottoParams.add("2");
        }

				if (lottoType.getCUPLOTTO() != null) {
					CUPLOTTOType cupLotto = lottoType.getCUPLOTTO();

					// Per ora si legge solo il primo codice CUP presente nell'array CODICICUP
					// e si suppone che il CUP sia legato al lotto a cui e' associato
					it.avlp.simog.massload.xmlbeans.DatiCUPType datiCup = cupLotto.getCODICICUPArray()[0];

					listaSqlLottoCampi.add("CUP");
					listaSqlLottoParams.add(datiCup.getCUP());
					listaSqlLottoCampi.add("CUPESENTE");
					listaSqlLottoParams.add("2");
				} else {
					listaSqlLottoCampi.add("CUPESENTE");
					listaSqlLottoParams.add("1");
				}
				if (schedaType.getDatiScheda() != null) {
					if (StringUtils.isNotEmpty(schedaType.getDatiScheda().getDatiComuni().getIDSCHEDALOCALE())) {
						listaSqlLottoCampi.add("ID_SCHEDA_LOCALE");
						listaSqlLottoParams.add(schedaType.getDatiScheda().getDatiComuni().getIDSCHEDALOCALE());
					} else {
						listaSqlLottoCampi.add("ID_SCHEDA_LOCALE");
						listaSqlLottoParams.add(codiceCIG);
					}

					// if (schedaType.getDatiScheda().getDatiComuni().isSetIDSCHEDASIMOG()) {
					// listaSqlLottoCampi.add("ID_SCHEDA_SIMOG");
					// listaSqlLottoParams.add(schedaType.getDatiScheda().getDatiComuni().getIDSCHEDASIMOG());
					// }
				} else {
					listaSqlLottoCampi.add("ID_SCHEDA_LOCALE");
					listaSqlLottoParams.add(codiceCIG);
				}

				// Inserimento W9LOTT
				String sqlInsertW9LOTT = "insert into W9LOTT (LISTACAMPI) values (LISTAPARAMS)";
				StringBuffer listaCampi = new StringBuffer("");
				StringBuffer listaParams = new StringBuffer("");
				for (int ir = 0; ir < listaSqlLottoCampi.size(); ir++) {
					listaCampi.append(listaSqlLottoCampi.get(ir) + ", ");
					listaParams.append("?, ");
				}

				sqlInsertW9LOTT = sqlInsertW9LOTT.replaceAll("LISTACAMPI", listaCampi.toString().substring(0, listaCampi.length() - 2));
				sqlInsertW9LOTT = sqlInsertW9LOTT.replaceAll("LISTAPARAMS", listaParams.toString().substring(0, listaParams.length() - 2));

				this.sqlManager.update(sqlInsertW9LOTT, listaSqlLottoParams.toArray());

				// Inserimento W9LOTTCATE
				if (lottoType.getCATEGORIE() != null) {
				  CategLottoType categorieLotto = lottoType.getCATEGORIE(); //categorieLotto.getCATEGORIAArray();
					if (categorieLotto.getCATEGORIAArray() != null && categorieLotto.getCATEGORIAArray().length > 0) {
						Object[] sqlLottCateParams = new Object[4];
						sqlLottCateParams[0] = codGara; // W9GARA.CODGARA con IDAVGARA = codiceGara
						sqlLottCateParams[1] = codLott; // progressivo per lotto

						long numCate = 1;
						for (int i = 0; i < categorieLotto.getCATEGORIAArray().length; i++) {
						  if (! StringUtils.equals(categorieLotto.getCATEGORIAArray()[i], lottoType.getIDCATEGORIAPREVALENTE())) { 
  							sqlLottCateParams[2] = new Long(numCate + i); // progressivo per categoria
  
  							// tabella W9CODICI_AVCP contiene codici per
  							// decodificare ID_CATEGORIA_PREVALENTE e CLASCAT
  							categoria = (String) this.sqlManager.getObject(
  							    "select CODSITAT from W9CODICI_AVCP where CODAVCP=?  and TABCOD='W3z03' ", 
  							    new Object[] { categorieLotto.getCATEGORIAArray()[i] });
  
  							if (categoria == null) {
  								categoria = categorieLotto.getCATEGORIAArray()[i];
  							}
  							sqlLottCateParams[3] = categoria;
  							this.sqlManager.update("insert into W9LOTTCATE (CODGARA, CODLOTT, NUM_CATE, CATEGORIA) values(?,?,?,?)",
  							    sqlLottCateParams);
						  }
						}
					}
				}

				if (lottoType.getTipiAppaltoLavArray() != null && lottoType.getTipiAppaltoLavArray().length > 0) {
					it.avlp.simog.massload.xmlbeans.TipiAppaltoType[] arrayAppaltoLav = lottoType.getTipiAppaltoLavArray();

					Object[] sqlW9AppaLavParams = new Object[4];
					sqlW9AppaLavParams[0] = codGara;
					sqlW9AppaLavParams[1] = codLott; // progressivo per lotto

					for (int i = 0; i < arrayAppaltoLav.length; i++) {
						sqlW9AppaLavParams[2] = new Long((i + 1)); // progressivo
						sqlW9AppaLavParams[3] = new Long(arrayAppaltoLav[i].getIDAPPALTO());
						this.sqlManager.update("insert into W9APPALAV (CODGARA, CODLOTT, NUM_APPAL, ID_APPALTO) values(?,?,?,?)", 
						    sqlW9AppaLavParams);
					}
				}

				if (lottoType.getTipiAppaltoFornArray() != null && lottoType.getTipiAppaltoFornArray().length > 0) {
					it.avlp.simog.massload.xmlbeans.TipiAppaltoType[] arrayAppaltpForn = lottoType.getTipiAppaltoFornArray();

					Object[] sqlW9AppaFornParams = new Object[4];
					sqlW9AppaFornParams[0] = codGara;
					sqlW9AppaFornParams[1] = codLott; // progressivo per lotto

					for (int i = 0; i < arrayAppaltpForn.length; i++) {
						sqlW9AppaFornParams[2] = new Long((i + 1)); // progressivo
						sqlW9AppaFornParams[3] = new Long(arrayAppaltpForn[i].getIDAPPALTO());
						this.sqlManager.update("insert into W9APPAFORN (CODGARA, CODLOTT, NUM_APPAF, ID_APPALTO) values(?,?,?,?)", 
						    sqlW9AppaFornParams);
					}
				}

				if (esisteGara) {
					// Aggiornamento W9GARA
					this.sqlManager.update("update W9GARA set NLOTTI=?, SITUAZIONE=1 where CODGARA=?", 
					    new Object[] { numeroLotti, codGara });
				}

				if (this.w9Manager.isStazioneAppaltanteConPermessiDaApplicareInCreazione(codUffInt)) {
					this.w9Manager.updateAttribuzioneModello(codGara, new Long(1));

					// Inserimento dei ruolo per il RUP, altrimenti con la gestione dei
					// permessi attiva nessun utente accederebbe alla gara/lotto
					this.sqlManager.update("INSERT INTO W9INCA (CODGARA, CODLOTT, NUM, NUM_INCA, SEZIONE, ID_RUOLO, CODTEC) values (?,?,?,?,?,?,?)", 
					    new Object[] { codGara, codLott, new Long(1), new Long(1), "RA", 14, codTec });
					this.sqlManager.update("INSERT INTO W9INCA (CODGARA, CODLOTT, NUM, NUM_INCA, SEZIONE, ID_RUOLO, CODTEC) values (?,?,?,?,?,?,?)", 
					    new Object[] { codGara, codLott, new Long(1), new Long(2), "RA", 15, codTec });
					this.sqlManager.update("INSERT INTO W9INCA (CODGARA, CODLOTT, NUM, NUM_INCA, SEZIONE, ID_RUOLO, CODTEC) values (?,?,?,?,?,?,?)", 
					    new Object[] { codGara, codLott, new Long(1), new Long(3), "RA", 16, codTec });
					this.sqlManager.update("INSERT INTO W9INCA (CODGARA, CODLOTT, NUM, NUM_INCA, SEZIONE, ID_RUOLO, CODTEC) values (?,?,?,?,?,?,?)", 
					    new Object[] { codGara, codLott, new Long(1), new Long(4), "RA", 17, codTec });
				}

				consultaLottoBean.setCaricato(true);
				consultaLottoBean.setMsg("Lotto importato");
				
				//resultMap.put("esito", Boolean.TRUE);
			} else {
				// Tecnico non associato alla stazione appaltante in uso
				String msgErrore = "La richiesta consultaGara (CIG=" + codiceCIG 
				    + ") e' stata avviata da un utente (SYSCON=" + syscon
						+ ") che non risulta essere tecnico della stazione appaltante attualmente in uso (UFFINT.CFEIN=" + codUffInt + ")";

				logger.error(msgErrore);

				consultaLottoBean.setCaricato(false);
				consultaLottoBean.setMsg("Lotto non importato: non e' stato individuato il RUP");
			}

		} else {

			if ((StringUtils.isNotEmpty(idAvGara) && !("" + garaType.getIDGARA()).equals(idAvGara)) 
			    && garaType.getCFAMMINISTRAZIONE().equals(cfUffInt) && (lottoType.getDATAPUBBLICAZIONE() != null)) {
				logger.error("La richiesta consultaGara ha restituito una gara con IDGARA diverso da quello digitato dall'utente");

				consultaLottoBean.setCaricato(false);
        consultaLottoBean.setMsg("Il lotto fa riferimento ad un Numero Gara ANAC diverso da quello indicato");
        
			} else if ((StringUtils.isEmpty(idAvGara) || (garaType.getIDGARA() > 0
			    && ("" + garaType.getIDGARA()).equals(idAvGara))) && (!garaType.getCFAMMINISTRAZIONE().equals(cfUffInt))
					&& (lottoType.getDATAPUBBLICAZIONE() != null)) {
				logger.error("La richiesta consultaGara e' stata interrotta per il seguente motivo: la stazione appaltante "
						+ "associata al codice CIG e' differente da quella da cui si sta effettuando l’operazione, cioe' il codice fiscale "
						+ "della stazione appaltante in uso (UFFINT.CFEIN) e' diverso dal campo CF_AMMINISTRAZIONE ritornato dal WS dell'AVCP.");
				
        consultaLottoBean.setCaricato(false);
        consultaLottoBean.setMsg("Il lotto fa riferimento ad una stazione appaltante diversa da quella indicata");
        
			} else if ((StringUtils.isEmpty(idAvGara) || (garaType.getIDGARA() > 0 
			    && ("" + garaType.getIDGARA()).equals(idAvGara))) && garaType.getCFAMMINISTRAZIONE().equals(cfUffInt)
					&& (lottoType.getDATAPUBBLICAZIONE() == null)) {
				logger.error("La richiesta consultaGara e' stata interrotta per il seguente motivo: "
				    + "il codice CIG indicato fa riferimento ad un lotto non perfezionato.");
        
				consultaLottoBean.setCaricato(false);
        consultaLottoBean.setMsg("Il lotto non e' perfezionato");
        
			} else {
				logger.error("La richiesta consultaGara e' stata interrotta per piu' motivi: al codice CIG e' associata "
						+ "una gara con codice gara diverso da quello digitato, la stazione appaltante associata al "
						+ "codice CIG e' differente da quella da cui si sta effettuando l’operazione (cioe' il codice fiscale "
						+ "della stazione appaltante in uso (UFFINT.CFEIN) e' diverso dal campo CF_AMMINISTRAZIONE ritornato "
						+ "dal WS dell'AVCP) e il codice CIG indicato fa riferimento ad un lotto non perfezionato.");
				
        consultaLottoBean.setCaricato(false);
        consultaLottoBean.setMsg("Il lotto non importabile");
			}
		}

		if (logger.isDebugEnabled()) {
			logger.debug("consultaGaraUnificatoWS: fine metodo");
		}
		
		return consultaLottoBean;
	}

	private String verificaNUTS(String codiceNUTS) {
	  String result = null;
	  
	  if ("ITF46".equals(codiceNUTS.toUpperCase())) {
	    result = "ITF41"; 
	  } else if ("ITF47".equals(codiceNUTS.toUpperCase())) {
      result = "ITF42"; 
    } else if ("ITF4C".equals(codiceNUTS.toUpperCase())) {
      result = "ITF45"; 
    } else if (codiceNUTS.toUpperCase().startsWith("ITH")) {
      result = StringUtils.replace(codiceNUTS, "ITD", "ITH");
    } else if (codiceNUTS.toUpperCase().startsWith("ITE")) {
      result = StringUtils.replace(codiceNUTS, "ITE", "ITI");
    }
	  
	  return result;
	}
	
  public synchronized ConsultaLottoBean consultaGaraUnificatoPDD(final String codiceCIG, final String idAvGara, final String codUffInt,
      final int syscon, final SchedaType schedaType, final GaraType garaType, final LottoType lottoType)
          throws SQLException, GestoreException {

    if (logger.isDebugEnabled()) {
      logger.debug("consultaGaraUnificatoPDD: inizio metodo");
    }

    ConsultaLottoBean consultaLottoBean = new ConsultaLottoBean(codiceCIG, true, false);
    
    long idGara = garaType.getIDGARA();
    String cfUffInt = (String) this.sqlManager.getObject("select CFEIN from UFFINT where CODEIN=?", new Object[] { codUffInt });
    String cfAnac = (String) this.sqlManager.getObject("select CFANAC from UFFINT where CODEIN=?", new Object[] { codUffInt });

    if ((StringUtils.isEmpty(idAvGara) || (garaType.getIDGARA() > 0 && ("" + garaType.getIDGARA()).equals(idAvGara))) 
        && (garaType.getCFAMMINISTRAZIONE().equals(cfUffInt) || garaType.getCFAMMINISTRAZIONE().equals(cfAnac))
        && lottoType.getDATAPUBBLICAZIONE() != null) {

      // Flag che indica se in DB esiste la gara con idAvGara specificato dall'utente
      boolean esisteGara = this.isGaraEsistente("" + garaType.getIDGARA());

      if (logger.isDebugEnabled()) {
        logger.debug("Inizio import del xml fornito dal WS dopo controllo su IDAVGARA e CF stazione appaltante");
        logger.debug("Nella base dati " + (esisteGara ? "esiste" : "non esiste") + " la gara con IDAVGARA = '" + idAvGara + "'");
      }

      Long codGara = null;
      if (esisteGara) {
        codGara = (Long) this.sqlManager.getObject("select CODGARA from W9GARA where idAVGARA=?", new Object[] { "" + idGara });
      } else {
        Long maxCodGara = (Long) this.sqlManager.getObject("select max(CODGARA)+1 from W9GARA", new Object[] {});
        if (maxCodGara == null) {
          codGara = new Long(1);
        } else {
          codGara = maxCodGara;
        }
      }

      // Estrazione del campo TECNI.CODTEC per valorizzare i campi W9GARA.RUP e W9LOTT.RUP
      String codTec = null;
      String cfRup = null;
      if (schedaType != null && schedaType.getDatiScheda() != null && schedaType.getDatiScheda().getDatiComuni() != null) {
        cfRup = schedaType.getDatiScheda().getDatiComuni().getCFRUP();
      }
      if (StringUtils.isEmpty(cfRup)) {
        if (garaType != null) {
          cfRup = garaType.getCFUTENTE();
        }
      }
      
      codTec = (String) this.sqlManager.getObject("select CODTEC from TECNI where SYSCON=? and CGENTEI=? and UPPER(CFTEC)=?", 
          new Object[] { new Long(syscon), codUffInt, cfRup.toUpperCase() });
      if (StringUtils.isEmpty(codTec)) {
        codTec = (String) this.sqlManager.getObject("select CODTEC from TECNI where SYSCON is null and CGENTEI=? and UPPER(CFTEC)=?", 
            new Object[] { codUffInt, cfRup.toUpperCase() });
        if (StringUtils.isEmpty(codTec)) {
          cfRup = this.insertTecnico(codUffInt, syscon);
          codTec = (String) this.sqlManager.getObject("select CODTEC from TECNI where SYSCON=? and CGENTEI=? and UPPER(CFTEC)=?", 
              new Object[] { new Long(syscon), codUffInt, cfRup.toUpperCase() });
        } else {
          this.updateTecnico(syscon, codTec);
        }
      }

      boolean esisteTecnico = StringUtils.isNotEmpty(codTec);

      if (esisteTecnico) {
        
        GregorianCalendar dataCreazioneGara = null;
        if (garaType.isSetDATACREAZIONE()) {
          dataCreazioneGara = new GregorianCalendar(
              garaType.getDATACREAZIONE().get(Calendar.YEAR), 
              garaType.getDATACREAZIONE().get(Calendar.MONTH), 
              garaType.getDATACREAZIONE().get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        }
        
        GregorianCalendar dataPerfezionamentoBando = null;
        if (garaType.isSetDATAPERFEZIONAMENTOBANDO()) {
          dataPerfezionamentoBando = new GregorianCalendar(
              garaType.getDATAPERFEZIONAMENTOBANDO().get(Calendar.YEAR),
              garaType.getDATAPERFEZIONAMENTOBANDO().get(Calendar.MONTH),
              garaType.getDATAPERFEZIONAMENTOBANDO().get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        }
        
        GregorianCalendar dataAttuazioneSimog2 = UtilitySITAT.getDataAttuazioneSimog2(this.sqlManager);
        
        if (!esisteGara) {
        
          List<String> listaSqlGaraCampi = new ArrayList<String>();
          listaSqlGaraCampi.add("CODGARA");
          listaSqlGaraCampi.add("SYSCON");
          listaSqlGaraCampi.add("OGGETTO");
          listaSqlGaraCampi.add("PROV_DATO");
          listaSqlGaraCampi.add("RUP");
          listaSqlGaraCampi.add("IMPORTO_GARA");
          listaSqlGaraCampi.add("NLOTTI");
          listaSqlGaraCampi.add("CODEIN");
          listaSqlGaraCampi.add("RIC_ALLUV");
          listaSqlGaraCampi.add("SITUAZIONE");
          listaSqlGaraCampi.add("PREV_BANDO");
          listaSqlGaraCampi.add("VER_SIMOG");
          
          List<Object> listaSqlGaraParams = new ArrayList<Object>();
          listaSqlGaraParams.add(codGara);
          listaSqlGaraParams.add(syscon);
          listaSqlGaraParams.add(garaType.getOGGETTO());
          listaSqlGaraParams.add(new Long(2)); // Provenienza Simog
          listaSqlGaraParams.add(codTec);
          listaSqlGaraParams.add(new Double(garaType.getIMPORTOGARA().doubleValue()));
          listaSqlGaraParams.add(new Long(1)); // NLOTTI
          listaSqlGaraParams.add(codUffInt);  // CODEIN
          listaSqlGaraParams.add("2");  // RIC_ALLUV
          listaSqlGaraParams.add(new Long(SituazioneGaraLotto.SITUAZIONE_IN_GARA.getSituazione()));  // SITUAZIONE
          listaSqlGaraParams.add("2");  // PREV_BANDO
          
          if (dataCreazioneGara == null || dataAttuazioneSimog2 == null) {
            listaSqlGaraParams.add(new Long(1));
          } else if (dataCreazioneGara.before(dataAttuazioneSimog2)) {
            listaSqlGaraParams.add(new Long(1));
          } else {
            listaSqlGaraParams.add(new Long(2));
          }
          
          if (schedaType.isSetDatiScheda()) {
            listaSqlGaraCampi.add("FLAG_SA_AGENTE");
            listaSqlGaraParams.add(it.avlp.simog.massload.xmlbeans.FlagSNType.S.equals(schedaType.getDatiScheda().getDatiComuni().getFLAGSAAGENTE()) ? "1" : "2");
            listaSqlGaraCampi.add("DENOM_SA_AGENTE");
            listaSqlGaraParams.add(schedaType.getDatiScheda().getDatiComuni().getDENAMMAGENTE().toString());
            listaSqlGaraCampi.add("CF_SA_AGENTE");
            listaSqlGaraParams.add(schedaType.getDatiScheda().getDatiComuni().getCFAMMAGENTE().toString());
            if (garaType.isSetDURATAACCQUADROCONVENZIONEGARA()) {
              listaSqlGaraCampi.add("DURATA_ACCQUADRO");
              listaSqlGaraParams.add(new Long(garaType.getDURATAACCQUADROCONVENZIONEGARA()));
            } else  if (schedaType.isSetDatiScheda() &&
                schedaType.getDatiScheda().getDatiComuni().isSetDURATAACCQUADROCONVENZIONE()) {
              listaSqlGaraCampi.add("DURATA_ACCQUADRO");
              listaSqlGaraParams.add(new Long(schedaType.getDatiScheda().getDatiComuni().getDURATAACCQUADROCONVENZIONE()));
            }
          }
          
          if (garaType.isSetDATAPERFEZIONAMENTOBANDO()) {
            listaSqlGaraCampi.add("DATA_PUBBLICAZIONE");
            listaSqlGaraParams.add(garaType.getDATAPERFEZIONAMENTOBANDO().getTime());
          }
    
          if (garaType.isSetIDGARA()) {
            listaSqlGaraCampi.add("IDAVGARA");
            listaSqlGaraParams.add("" + garaType.getIDGARA());
          }
    
          if (garaType.isSetMODOREALIZZAZIONE()) {
            listaSqlGaraCampi.add("TIPO_APP");
            listaSqlGaraParams.add(new Long(garaType.getMODOREALIZZAZIONE()));
          }
    
          if (garaType.isSetCIGACCQUADRO()) {
            listaSqlGaraCampi.add("CIG_ACCQUADRO");
            listaSqlGaraParams.add(garaType.getCIGACCQUADRO());
          }
    
          if (garaType.isSetMODOINDIZIONE()) {
            listaSqlGaraCampi.add("ID_MODO_INDIZIONE");
            listaSqlGaraParams.add(new Long(garaType.getMODOINDIZIONE()));
          }
    
          if (garaType.isSetTIPOSCHEDA()) {
            listaSqlGaraCampi.add("FLAG_ENTE_SPECIALE");
            listaSqlGaraParams.add(garaType.getTIPOSCHEDA().toString());
          }
          
          String codiceCentroCostoFromSIMOG = garaType.getIDSTAZIONEAPPALTANTE();
          String descrCentroCostoFromSIMOG = garaType.getDENOMSTAZIONEAPPALTANTE();
      
          if (garaType.isSetURGENZADL133()) {
            listaSqlGaraCampi.add("SOMMA_URGENZA");
            listaSqlGaraParams.add(it.avlp.simog.massload.xmlbeans.FlagSNType.S.equals(garaType.getURGENZADL133()) ? "1" : "2");
          }
          
          Long idCentroCosto = (Long) this.sqlManager.getObject(
              "select IDCENTRO from CENTRICOSTO where UPPER(CODCENTRO)=? and CODEIN=?",
              new Object[] { codiceCentroCostoFromSIMOG.toUpperCase(), codUffInt });
    
          if (idCentroCosto == null) {
            Long maxIdCentroCosto = (Long) this.sqlManager.getObject("select max(IDCENTRO)+1 from CENTRICOSTO", new Object[] {});
            if (maxIdCentroCosto == null) {
              idCentroCosto = new Long(1);
            } else {
              idCentroCosto = maxIdCentroCosto;
            }
    
            this.sqlManager.update("INSERT INTO CENTRICOSTO (IDCENTRO,CODEIN,CODCENTRO,DENOMCENTRO) VALUES (?,?,?,?)",
                new Object[] { idCentroCosto, codUffInt, codiceCentroCostoFromSIMOG, StringUtils.substring(descrCentroCostoFromSIMOG,0,250) });
          } else {
            this.sqlManager.update("UPDATE CENTRICOSTO set DENOMCENTRO=? where IDCENTRO=?", 
              new Object[] { StringUtils.substring(descrCentroCostoFromSIMOG,0,250), idCentroCosto });
          }
    
          listaSqlGaraCampi.add("IDCC");
          listaSqlGaraParams.add(idCentroCosto);
    
          // Inserimento in W9GARA
          StringBuffer listaCampi = new StringBuffer("");
          StringBuffer listaParams = new StringBuffer("");
          for (int ir = 0; ir < listaSqlGaraCampi.size(); ir++) {
            listaCampi.append(listaSqlGaraCampi.get(ir) + ", ");
            listaParams.append("?,");
          }
    
          String sqlInsertW9GARA = "insert into W9GARA (LISTACAMPI) values (LISTAPARAMS)";
          sqlInsertW9GARA = sqlInsertW9GARA.replaceAll("LISTACAMPI", listaCampi.toString().substring(0, listaCampi.length() - 2));
          sqlInsertW9GARA = sqlInsertW9GARA.replaceAll("LISTAPARAMS", listaParams.toString().substring(0, listaParams.length() - 1));
          this.sqlManager.update(sqlInsertW9GARA, listaSqlGaraParams.toArray());

          // Pubblicazione
          if (schedaType.isSetDatiScheda() && schedaType.getDatiScheda().isSetPubblicazione()) {
            it.avlp.simog.massload.xmlbeans.PubblicazioneType pubblicazione = schedaType.getDatiScheda().getPubblicazione();

            List<String> listaSqlPubblicazioneCampi = new ArrayList<String>();
            List<Object> listaSqlPubblicazioneParams = new ArrayList<Object>();

            listaSqlPubblicazioneCampi.add("CODGARA");
            listaSqlPubblicazioneParams.add(codGara);

            listaSqlPubblicazioneCampi.add("CODLOTT");
            listaSqlPubblicazioneParams.add(new Long(1));

            listaSqlPubblicazioneCampi.add("NUM_APPA");
            listaSqlPubblicazioneParams.add(new Long(1));

            listaSqlPubblicazioneCampi.add("NUM_PUBB");
            listaSqlPubblicazioneParams.add(new Long(1));

            if (pubblicazione.getDATAGUCE() != null) {
              listaSqlPubblicazioneCampi.add("DATA_GUCE");
              listaSqlPubblicazioneParams.add(pubblicazione.getDATAGUCE().getTime());
            }

            if (pubblicazione.getDATAGURI() != null) {
              listaSqlPubblicazioneCampi.add("DATA_GURI");
              listaSqlPubblicazioneParams.add(pubblicazione.getDATAGURI().getTime());
            }

            if (pubblicazione.getDATAALBO() != null) {
              listaSqlPubblicazioneCampi.add("DATA_ALBO");
              listaSqlPubblicazioneParams.add(pubblicazione.getDATAALBO().getTime());
            }

            if (pubblicazione.getQUOTIDIANINAZ() > 0) {
              listaSqlPubblicazioneCampi.add("QUOTIDIANI_NAZ");
              listaSqlPubblicazioneParams.add(pubblicazione.getQUOTIDIANINAZ());
            }

            if (pubblicazione.getQUOTIDIANIREG() > 0) {
              listaSqlPubblicazioneCampi.add("QUOTIDIANI_REG");
              listaSqlPubblicazioneParams.add(pubblicazione.getQUOTIDIANIREG());
            }

            if (pubblicazione.getPROFILOCOMMITTENTE() != null) {
              listaSqlPubblicazioneCampi.add("PROFILO_COMMITTENTE");
              listaSqlPubblicazioneParams.add(it.avlp.simog.massload.xmlbeans.FlagSNType.S.equals(pubblicazione.getPROFILOCOMMITTENTE()) ? "1" : "2");
            }

            if (pubblicazione.getSITOMINISTEROINFTRASP() != null) {
              listaSqlPubblicazioneCampi.add("SITO_MINISTERO_INF_TRASP");
              listaSqlPubblicazioneParams.add(it.avlp.simog.massload.xmlbeans.FlagSNType.S.equals(pubblicazione.getSITOMINISTEROINFTRASP()) ? "1" : "2");
            }

            if (pubblicazione.getSITOOSSERVATORIOCP() != null) {
              listaSqlPubblicazioneCampi.add("SITO_OSSERVATORIO_CP");
              listaSqlPubblicazioneParams.add(it.avlp.simog.massload.xmlbeans.FlagSNType.S.equals(pubblicazione.getSITOOSSERVATORIOCP()) ? "1" : "2");
            }

            if (pubblicazione.getDATABORE() != null) {
              listaSqlPubblicazioneCampi.add("DATA_BORE");
              listaSqlPubblicazioneParams.add(pubblicazione.getDATABORE().getTime());
            }

            if (pubblicazione.getPERIODICI() > 0) {
              listaSqlPubblicazioneCampi.add("PERIODICI");
              listaSqlPubblicazioneParams.add(pubblicazione.getPERIODICI());
            }

            // Inserimento W9PUBB
            String sqlInsertW9PUBB = "insert into W9PUBB (LISTACAMPI) values (LISTAPARAMS)";
            listaCampi = new StringBuffer("");
            listaParams = new StringBuffer("");
            for (int i = 0; i < listaSqlPubblicazioneCampi.size(); i++) {
              listaCampi.append(listaSqlPubblicazioneCampi.get(i) + ", ");
              listaParams.append("?, ");
            }

            sqlInsertW9PUBB = sqlInsertW9PUBB.replaceAll("LISTACAMPI", listaCampi.toString().substring(0, listaCampi.length() - 2));
            sqlInsertW9PUBB = sqlInsertW9PUBB.replaceAll("LISTAPARAMS", listaParams.toString().substring(0, listaParams.length() - 2));

            this.sqlManager.update(sqlInsertW9PUBB, listaSqlPubblicazioneParams.toArray());
          }
        }

        Long codLott = (Long) this.sqlManager.getObject(
          "select max(CODLOTT)+1 from W9LOTT where CODGARA=?", new Object[] { codGara });
        if (codLott == null) {
          codLott = new Long(1);
        }

        Long numeroLotti = (Long) this.sqlManager.getObject(
          "select count(*) from W9LOTT where CODGARA=?", new Object[] { codGara });
        numeroLotti++;

        List<String> listaSqlLottoCampi = new ArrayList<String>();
        listaSqlLottoCampi.add("CODGARA");
        listaSqlLottoCampi.add("CODLOTT");
        listaSqlLottoCampi.add("OGGETTO");
        listaSqlLottoCampi.add("RUP");
        listaSqlLottoCampi.add("IMPORTO_LOTTO");
        listaSqlLottoCampi.add("CPV");
        listaSqlLottoCampi.add("ID_SCELTA_CONTRAENTE");
        listaSqlLottoCampi.add("ID_CATEGORIA_PREVALENTE");
        listaSqlLottoCampi.add("NLOTTO");
        listaSqlLottoCampi.add("CIG");
        listaSqlLottoCampi.add("SITUAZIONE");
        listaSqlLottoCampi.add("DATA_CONSULTA_GARA");
        listaSqlLottoCampi.add("EXSOTTOSOGLIA");

        List<Object> listaSqlLottoParams = new ArrayList<Object>();
        listaSqlLottoParams.add(codGara);
        listaSqlLottoParams.add(codLott); // progressivo all'interno della gara
        listaSqlLottoParams.add(lottoType.getOGGETTO());
        listaSqlLottoParams.add(codTec); // RUP

        if (lottoType.getIMPORTOATTUAZIONESICUREZZA() != null) {
          listaSqlLottoParams.add(new Double(lottoType.getIMPORTOLOTTO().doubleValue()
              - new Double(lottoType.getIMPORTOATTUAZIONESICUREZZA()).doubleValue()));
        } else {
          listaSqlLottoParams.add(new Double(lottoType.getIMPORTOLOTTO().doubleValue()));
        }
        listaSqlLottoParams.add(lottoType.getCPV()); // CPV
        listaSqlLottoParams.add(Long.parseLong(lottoType.getIDSCELTACONTRAENTE())); // Id Scelta contraente
        String categoria = (String) sqlManager.getObject(
          "select CODSITAT from W9CODICI_AVCP where CODAVCP = ? and TABCOD = 'W3z03' ",
            new Object[] { lottoType.getIDCATEGORIAPREVALENTE() });
        // se manca corrispondenza inserisco il codice non decodificato
        if (StringUtils.isEmpty(categoria)) {
          categoria = lottoType.getIDCATEGORIAPREVALENTE();
        }
        listaSqlLottoParams.add(categoria); // Id Categoria Prevalente
        
        listaSqlLottoParams.add(codLott); // NLOTTO (uguale a W9LOTT.CODLOTT)
        listaSqlLottoParams.add(codiceCIG); // CIG
        listaSqlLottoParams.add(new Long(SituazioneGaraLotto.SITUAZIONE_IN_GARA.getSituazione())); // Situazione gara
        listaSqlLottoParams.add(new Date()); // Data consulta gara

        // ExSottoSoglia: se lotto.Importo < 150k e gara.DataPubblicazione < 29/10/2013
        Double tempImportoLotto = new Double(lottoType.getIMPORTOLOTTO().doubleValue());
        boolean isDataPubbPrecedente =  false;
        boolean isImportoLottoSottoSoglia = false;
        if (tempImportoLotto.compareTo(new Double(150000)) < 0) {
          isImportoLottoSottoSoglia = true;
        }

        if (isImportoLottoSottoSoglia && dataPerfezionamentoBando != null) {
          if (dataPerfezionamentoBando.before(new GregorianCalendar(2013, 9, 29, 0, 0, 0))) {
            isDataPubbPrecedente = true;
          }
        }
        
        if (isImportoLottoSottoSoglia && isDataPubbPrecedente) {
          listaSqlLottoParams.add("1");
        } else {
          listaSqlLottoParams.add("2");
        }
        
        if (dataPerfezionamentoBando != null && dataAttuazioneSimog2 != null 
            && dataPerfezionamentoBando.before(dataAttuazioneSimog2) ) {
          listaSqlLottoCampi.add("ID_SCELTA_CONTRAENTE_50");
          listaSqlLottoParams.add(this.getIdSceltaContraente50(lottoType.getIDSCELTACONTRAENTE()));
        }
        if (garaType.isSetTIPOSCHEDA()) {
          listaSqlLottoCampi.add("FLAG_ENTE_SPECIALE");
          listaSqlLottoParams.add(garaType.getTIPOSCHEDA().toString());
        }

        listaSqlLottoCampi.add("DAEXPORT");
        listaSqlLottoParams.add("1");

        listaSqlLottoCampi.add("IMPORTO_ATTUAZIONE_SICUREZZA");
        if (lottoType.getIMPORTOATTUAZIONESICUREZZA() != null) {
          listaSqlLottoParams.add(new Double(lottoType.getIMPORTOATTUAZIONESICUREZZA()));
        } else {
          listaSqlLottoParams.add(new Double(0));
        }

        listaSqlLottoCampi.add("IMPORTO_TOT");
        listaSqlLottoParams.add(new Double(lottoType.getIMPORTOLOTTO().doubleValue()));

        listaSqlLottoCampi.add("CLASCAT");

        double importoLotto = lottoType.getIMPORTOLOTTO().doubleValue();
        if (importoLotto <= 258000) {
          listaSqlLottoParams.add("I");
        } else if (importoLotto <= 516000) {
          listaSqlLottoParams.add("II");
        } else if (importoLotto <= 1033000) {
          listaSqlLottoParams.add("III");
        } else if (importoLotto <= 1500000) {
          listaSqlLottoParams.add("IIIB");
        } else if (importoLotto <= 2582000) {
          listaSqlLottoParams.add("IV");
        } else if (importoLotto <= 3500000) {
          listaSqlLottoParams.add("IVB");
        } else if (importoLotto <= 5165000) {
          listaSqlLottoParams.add("V");
        } else if (importoLotto <= 10329000) {
          listaSqlLottoParams.add("VI");
        } else if (importoLotto <= 15494000) {
          listaSqlLottoParams.add("VII");
        } else {
          listaSqlLottoParams.add("VIII");
        }

        if (lottoType.isSetTIPOCONTRATTO()) {
          listaSqlLottoCampi.add("TIPO_CONTRATTO");
          listaSqlLottoParams.add(lottoType.getTIPOCONTRATTO().toString());
          listaSqlLottoCampi.add("MANOD");
          if (lottoType.getTIPOCONTRATTO().toString().equalsIgnoreCase(W3Z05Type.L.toString())) {
            listaSqlLottoParams.add("1");
          } else {
            listaSqlLottoParams.add("2");
          }
        } else {
          listaSqlLottoCampi.add("MANOD");
          listaSqlLottoParams.add("2");
        }

        listaSqlLottoCampi.add("COMCON");
        listaSqlLottoParams.add("2");
        if (lottoType.isSetLUOGOISTAT()) {
          String luogoIstat = lottoType.getLUOGOISTAT();

          if (luogoIstat.length() == 6) {
            String codiceIstatRegione = (String) this.sqlManager.getObject(
                "select tabcod3 from tabsche where tabcod = 'S2003' and tabcod1='09' and tabcod3 like ?",
                new Object[] { "%".concat(luogoIstat) });
            if (StringUtils.isNotEmpty(codiceIstatRegione)) {
              luogoIstat = codiceIstatRegione;
            } else {
              luogoIstat = null;
            }
          }
          listaSqlLottoCampi.add("LUOGO_ISTAT");
          listaSqlLottoParams.add(luogoIstat);
        }
        if (lottoType.isSetLUOGONUTS()) {
          listaSqlLottoCampi.add("LUOGO_NUTS");
          String tmp = this.verificaNUTS(lottoType.getLUOGONUTS());
          if (tmp != null) {
            listaSqlLottoParams.add(tmp);
          } else {
            listaSqlLottoParams.add(lottoType.getLUOGONUTS());
          }
        }
        
        // Valorizzazione campo ART_E1: S -> 1, N o null -> 2
        listaSqlLottoCampi.add("ART_E1");
        if (lottoType.isSetIDESCLUSIONE()) {
          String strArtEsclusione = lottoType.getIDESCLUSIONE();
          int artEsclusione = Integer.parseInt(strArtEsclusione);
          if (artEsclusione <= 7 || artEsclusione == 11) {
            listaSqlLottoParams.add("1");
          } else {
            listaSqlLottoParams.add("2");
          }
        } else {
          listaSqlLottoParams.add("2");
        }
        
        if (lottoType.isSetCUPLOTTO()) {
          it.avlp.simog.massload.xmlbeans.CUPLOTTOType cupLotto = lottoType.getCUPLOTTO();

          // Per ora si legge solo il primo codice CUP presente nell'array CODICICUP
          // e si suppone che il CUP sia legato al lotto a cui e' associato
          it.avlp.simog.massload.xmlbeans.DatiCUPType datiCup = cupLotto.getCODICICUPArray(0);

          listaSqlLottoCampi.add("CUP");
          listaSqlLottoParams.add(datiCup.getCUP());
          listaSqlLottoCampi.add("CUPESENTE");
          listaSqlLottoParams.add("2");
        } else {
          listaSqlLottoCampi.add("CUPESENTE");
          listaSqlLottoParams.add("1");
        }

        if (schedaType.isSetDatiScheda()) {
          if (schedaType.getDatiScheda().getDatiComuni().isSetIDSCHEDALOCALE()) {
            listaSqlLottoCampi.add("ID_SCHEDA_LOCALE");
            listaSqlLottoParams.add(schedaType.getDatiScheda().getDatiComuni().getIDSCHEDALOCALE());
          } else {
            listaSqlLottoCampi.add("ID_SCHEDA_LOCALE");
            listaSqlLottoParams.add(codiceCIG);
          }

        } else {
          listaSqlLottoCampi.add("ID_SCHEDA_LOCALE");
          listaSqlLottoParams.add(codiceCIG);
        }

        // Inserimento W9LOTT
        String sqlInsertW9LOTT = "insert into W9LOTT (LISTACAMPI) values (LISTAPARAMS)";
        StringBuffer listaCampi = new StringBuffer("");
        StringBuffer listaParams = new StringBuffer("");
        for (int ir = 0; ir < listaSqlLottoCampi.size(); ir++) {
          listaCampi.append(listaSqlLottoCampi.get(ir) + ", ");
          listaParams.append("?, ");
        }

        sqlInsertW9LOTT = sqlInsertW9LOTT.replaceAll("LISTACAMPI", listaCampi.toString().substring(0, listaCampi.length() - 2));
        sqlInsertW9LOTT = sqlInsertW9LOTT.replaceAll("LISTAPARAMS", listaParams.toString().substring(0, listaParams.length() - 2));

        this.sqlManager.update(sqlInsertW9LOTT, listaSqlLottoParams.toArray());

        // Inserimento W9LOTTCATE
        if (lottoType.isSetCATEGORIE()) {
          it.avlp.simog.massload.xmlbeans.CategLottoType categorieLotto = lottoType.getCATEGORIE();

          String[] strCategorieLotto = categorieLotto.getCATEGORIAArray();
          if (strCategorieLotto != null && strCategorieLotto.length > 0) {

            Object[] sqlLottCateParams = new Object[4];
            sqlLottCateParams[0] = codGara;
            sqlLottCateParams[1] = codLott; // progressivo per lotto

            long numCate = 1;
            for (int i = 0; i < strCategorieLotto.length; i++) {
              if (! StringUtils.equals(strCategorieLotto[i], lottoType.getIDCATEGORIAPREVALENTE())) {
                sqlLottCateParams[2] = new Long(numCate + i); // progressivo per categoria
  
                // tabella W9CODICI_AVCP contiene codici per
                // decodificare ID_CATEGORIA_PREVALENTE e CLASCAT
                categoria = (String) sqlManager.getObject(
                    "select CODSITAT from W9CODICI_AVCP where CODAVCP = ?  and TABCOD = 'W3z03' ",
                    new Object[] { strCategorieLotto[i] });
                if (categoria == null) {
                  categoria = strCategorieLotto[i];
  
                }
                sqlLottCateParams[3] = categoria;
                this.sqlManager.update("insert into W9LOTTCATE (CODGARA, CODLOTT, NUM_CATE, CATEGORIA) values(?,?,?,?)", 
                    sqlLottCateParams);
              }
            }
          }
        }

        if (lottoType.getTipiAppaltoLavArray() != null && lottoType.getTipiAppaltoLavArray().length > 0) {
          it.avlp.simog.massload.xmlbeans.TipiAppaltoType[] arrayAppaltoLav = lottoType.getTipiAppaltoLavArray();

          Object[] sqlW9AppaLavParams = new Object[4];
          sqlW9AppaLavParams[0] = codGara;
          sqlW9AppaLavParams[1] = codLott; // progressivo per lotto

          for (int i = 0; i < arrayAppaltoLav.length; i++) {
            sqlW9AppaLavParams[2] = new Long((i + 1)); // progressivo
            sqlW9AppaLavParams[3] = new Long(arrayAppaltoLav[i].getIDAPPALTO());
            this.sqlManager.update("insert into W9APPALAV (CODGARA, CODLOTT, NUM_APPAL, ID_APPALTO) values(?,?,?,?)",
                sqlW9AppaLavParams);
          }
        }

        if (lottoType.getTipiAppaltoFornArray() != null && lottoType.getTipiAppaltoFornArray().length > 0) {
          it.avlp.simog.massload.xmlbeans.TipiAppaltoType[] arrayAppaltpForn = lottoType.getTipiAppaltoFornArray();

          Object[] sqlW9AppaFornParams = new Object[4];
          sqlW9AppaFornParams[0] = codGara;
          sqlW9AppaFornParams[1] = codLott; // progressivo per lotto

          for (int i = 0; i < arrayAppaltpForn.length; i++) {
            sqlW9AppaFornParams[2] = new Long((i + 1)); // progressivo
            sqlW9AppaFornParams[3] = new Long(arrayAppaltpForn[i].getIDAPPALTO());
            this.sqlManager.update("insert into W9APPAFORN (CODGARA, CODLOTT, NUM_APPAF, ID_APPALTO) values(?,?,?,?)", 
                sqlW9AppaFornParams);
          }
        }

        if (esisteGara) {
          // Aggiornamento W9GARA
          this.sqlManager.update("update W9GARA set NLOTTI=?, SITUAZIONE=1 where CODGARA=?", 
              new Object[] { numeroLotti, codGara });
        }

        if (this.w9Manager.isStazioneAppaltanteConPermessiDaApplicareInCreazione(codUffInt)) {
          this.w9Manager.updateAttribuzioneModello(codGara, new Long(1));

          // Inserimento dei ruolo per il RUP, altrimenti con la gestione dei
          // permessi attiva nessun utente accederebbe alla gara/lotto
          this.sqlManager.update("INSERT INTO W9INCA (CODGARA, CODLOTT, NUM, NUM_INCA, SEZIONE, ID_RUOLO, CODTEC) values (?,?,?,?,?,?,?)", 
              new Object[] { codGara, codLott, new Long(1), new Long(1), "RA", 14, codTec });
          this.sqlManager.update("INSERT INTO W9INCA (CODGARA, CODLOTT, NUM, NUM_INCA, SEZIONE, ID_RUOLO, CODTEC) values (?,?,?,?,?,?,?)", 
              new Object[] { codGara, codLott, new Long(1), new Long(2), "RA", 15, codTec });
          this.sqlManager.update("INSERT INTO W9INCA (CODGARA, CODLOTT, NUM, NUM_INCA, SEZIONE, ID_RUOLO, CODTEC) values (?,?,?,?,?,?,?)", 
              new Object[] { codGara, codLott, new Long(1), new Long(3), "RA", 16, codTec });
          this.sqlManager.update("INSERT INTO W9INCA (CODGARA, CODLOTT, NUM, NUM_INCA, SEZIONE, ID_RUOLO, CODTEC) values (?,?,?,?,?,?,?)", 
              new Object[] { codGara, codLott, new Long(1), new Long(4), "RA", 17, codTec });
        }

        consultaLottoBean.setCaricato(true);
        consultaLottoBean.setMsg("Lotto importato");
        
        //resultMap.put("esito", Boolean.TRUE);
      } else {
        // Tecnico non associato alla stazione appaltante in uso
        String msgErrore = "La richiesta consultaGara e' stata avviata da un utente (SYSCON=" + syscon

            + ") che non risulta essere tecnico della stazione appaltante attualmente in uso (UFFINT.CFEIN=" + codUffInt + ")";

        logger.error(msgErrore);

        consultaLottoBean.setCaricato(false);
        consultaLottoBean.setMsg("Lotto non importato: non e' stato individuato il RUP");
      }
    } else {


      if (!("" + garaType.getIDGARA()).equals(idAvGara) && garaType.getCFAMMINISTRAZIONE().equals(cfUffInt) && (lottoType.getDATAPUBBLICAZIONE() != null)) {
        logger.error("La richiesta consultaGara ha restituito una gara con IDGARA diverso da quello digitato dall'utente");
        
        consultaLottoBean.setCaricato(false);
        consultaLottoBean.setMsg("Il lotto fa riferimento ad un Numero Gara ANAC diverso da quello indicato");


      } else if (("" + garaType.getIDGARA()).equals(idAvGara) && (!garaType.getCFAMMINISTRAZIONE().equals(cfUffInt)) && (lottoType.getDATAPUBBLICAZIONE() != null)) {

        logger.error("La richiesta consultaGara e' stata interrotta per il seguente motivo: la stazione appaltante "
            + "associata al codice CIG e' differente da quella da cui si sta effettuando l’operazione, cioe' il codice fiscale "
            + "della stazione appaltante in uso (UFFINT.CFEIN) e' diverso dal campo CF_AMMINISTRAZIONE ritornato dal WS dell'AVCP.");

        consultaLottoBean.setCaricato(false);
        consultaLottoBean.setMsg("Il lotto fa riferimento ad una stazione appaltante diversa da quella indicata");
        

      } else if (("" + garaType.getIDGARA()).equals(idAvGara) && garaType.getCFAMMINISTRAZIONE().equals(cfUffInt) && (lottoType.getDATAPUBBLICAZIONE() == null)) {

        logger.error("La richiesta consultaGara e' stata interrotta per il seguente motivo: " 
            + "il codice CIG indicato fa riferimento ad un lotto non perfezionato.");
        
        consultaLottoBean.setCaricato(false);
        consultaLottoBean.setMsg("Il lotto non e' perfezionato");
        
      } else {
        logger.error("La richiesta consultaGara e' stata interrotta per piu' motivi: al codice CIG e' associata "
            + "una gara con codice gara diverso da quello digitato, la stazione appaltante associata al "
            + "codice CIG e' differente da quella da cui si sta effettuando l’operazione (cioe' il codice fiscale "
            + "della stazione appaltante in uso (UFFINT.CFEIN) e' diverso dal campo CF_AMMINISTRAZIONE ritornato "
            + "dal WS dell'AVCP) e il codice CIG indicato fa riferimento ad un lotto non perfezionato.");
        
        consultaLottoBean.setCaricato(false);
        consultaLottoBean.setMsg("Il lotto non importabile");
      }
    }

    if (logger.isDebugEnabled()) {
      logger.debug("consultaGaraUnificatoPDD: fine metodo");
    }

    return consultaLottoBean;
  }

	/**
	 * Metodo per determinare l'esistenza di una gara con codice gara
	 * specificato (per codice gara si intende il campo IDAVGARA.W9GARA).
	 * 
	 * @param idGara
	 *            Codice della gara di ritorno da SIMOG
	 * @return Ritorna true se esiste la gara con codice specificato, false
	 *         altrimenti
	 * @throws SQLException
	 *             SQLException
	 */
	public boolean isGaraEsistente(final String idGara) throws SQLException {
		if (logger.isDebugEnabled()) {
			logger.debug("isGaraEsistente: inizio metodo");
		}

		boolean result = false;

		try {
			Long numeroOccorrenze = (Long) this.sqlManager.getObject("select COUNT(CODGARA) from W9GARA where IDAVGARA=?", 
			    new Object[] { "" + idGara });

			if (numeroOccorrenze != null && numeroOccorrenze.longValue() > 0) {
				result = true;
			}
		} catch (SQLException e) {
			logger.error("Errore nel determinare l'esistenza di una gara con codice gara " + "specificato (IDAVGARA = '" + idGara + "')", e);
			throw e;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("isGaraEsistente: fine metodo");
		}
		return result;
	}

	private Long getIdSceltaContraente50(String IdSceltaContraente) {
		Long result = null;
		if (IdSceltaContraente != null) {
			if (IdSceltaContraente.equals("1")) {
				return new Long(1);
			} else if (IdSceltaContraente.equals("2")) {
				return new Long(12);
			} else if (IdSceltaContraente.equals("4")) {
				return new Long(6);
			} else if (IdSceltaContraente.equals("6")) {
				return new Long(17);
			} else if (IdSceltaContraente.equals("7")) {
				return null;
			} else if (IdSceltaContraente.equals("8")) {
				return new Long(18);
			} else if (IdSceltaContraente.equals("9")) {
				return new Long(5);
			} else if (IdSceltaContraente.equals("10")) {
				return new Long(6);
			} else if (IdSceltaContraente.equals("11")) {
				return null;
			} else if (IdSceltaContraente.equals("12")) {
				return new Long(2);
			} else if (IdSceltaContraente.equals("13")) {
				return new Long(12);
			} else if (IdSceltaContraente.equals("14")) {
				return null;
			} else if (IdSceltaContraente.equals("15")) {
				return new Long(2);
			} else if (IdSceltaContraente.equals("16")) {
				return new Long(2);
			} else if (IdSceltaContraente.equals("17")) {
				return new Long(9);
			} else if (IdSceltaContraente.equals("18")) {
				return new Long(10);
			} else if (IdSceltaContraente.equals("19")) {
				return new Long(11);
			} else if (IdSceltaContraente.equals("20")) {
				return new Long(13);
			} else if (IdSceltaContraente.equals("25")) {
				return null;
			} else if (IdSceltaContraente.equals("31")) {
				return new Long(2);
			}
		}
		return result;
	}


  /**
   * Creazione del tecnico a partire da alcuni campi della USRSYS.
   * 
   * @param codUffInt
   * @param syscon
   * @return Ritorna il CF del RUP
   * @throws SQLException
   * @throws GestoreException
   */
  public String insertTecnico(final String codUffInt, final int syscon)
      throws SQLException, GestoreException {
    String cfrup;
    Vector< ? > datiUsrsys = this.sqlManager.getVector("select SYSUTE, EMAIL, SYSCF from USRSYS where SYSCON=?",
        new Object[] { new Long(syscon) });
  
    String nomeUtente = SqlManager.getValueFromVectorParam(datiUsrsys, 0).getStringValue();
    String mailUtente = SqlManager.getValueFromVectorParam(datiUsrsys, 1).getStringValue();
    String cfUtente = SqlManager.getValueFromVectorParam(datiUsrsys, 2).getStringValue();
    
    synchronized (datiUsrsys) {
      String pk = this.geneManager.calcolaCodificaAutomatica("TECNI", "CODTEC");
      
      this.sqlManager.update("insert into TECNI (CODTEC,NOMTEC,CFTEC,CGENTEI,EMATEC,SYSCON) values (?,?,?,?,?,?)",
          new Object[] {pk, nomeUtente, cfUtente, codUffInt, mailUtente, new Long(syscon) } );
      
      cfrup = cfUtente;
    }
    return cfrup;
  }
  
  /**
   * Update del campo TECNI.SYSCON
   * 
   * @param syscon
   * @param codTec
   * @throws SQLException
   */
  public void updateTecnico(final int syscon, final String codTec) throws SQLException {
    this.sqlManager.update("update TECNI set SYSCON=? where CODTEC=?", new Object[] { new Long(syscon), codTec } );
  }
}
