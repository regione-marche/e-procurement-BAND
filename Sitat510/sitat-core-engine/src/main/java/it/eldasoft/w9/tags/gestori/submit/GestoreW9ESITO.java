package it.eldasoft.w9.tags.gestori.submit;


import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import it.eldasoft.gene.db.datautils.DataColumn;
import it.eldasoft.gene.db.datautils.DataColumnContainer;
import it.eldasoft.gene.db.sql.sqlparser.JdbcParametro;
import it.eldasoft.gene.web.struts.tags.gestori.AbstractGestoreChiaveNumerica;
import it.eldasoft.gene.web.struts.tags.gestori.GestoreException;


import org.apache.log4j.Logger;
import org.apache.struts.upload.FormFile;
import org.springframework.transaction.TransactionStatus;

public class GestoreW9ESITO extends AbstractGestoreChiaveNumericaEntitaW9 {

  Logger logger = Logger.getLogger(GestoreW9ESITO.class);
  
  public String[] getAltriCampiChiave() {
    return new String[] { "CODGARA" };
  }

  public String getCampoNumericoChiave() {
    return "CODLOTT";
  }

  public String getEntita() {
    return "W9ESITO";
  }

  public void postDelete(DataColumnContainer impl) throws GestoreException {
  }

  public void postInsert(DataColumnContainer impl) throws GestoreException {
  }

  public void postUpdate(DataColumnContainer arg0) throws GestoreException {
  }

  public void preDelete(TransactionStatus status, DataColumnContainer impl)
      throws GestoreException {
  }

  public void preInsert(TransactionStatus status, DataColumnContainer impl)
      throws GestoreException {

   
    
    GestoreW9ESITO.setFileAllegato(impl, this.getForm().getSelezioneFile(),
        this.getEntita());
    
    try {
      this.salvaPubblicazioneEsito(status, impl);
    } catch (SQLException se) {
      logger.error("Errore nel salvataggio dati in W9PUES durante l'insert della scheda dell'esito (W9ESITO)", se);
      throw new GestoreException("Errore nel salvataggio di pubblicazione",
          "gestione.esitiPubblicazioneGara" , se);
    }
  }

  /**
   * Metodo per l'insert/update in W9PUES
   * 
   * @param impl
   * @throws SQLException
   * @throws GestoreException 
   */
  private void salvaPubblicazioneEsito(TransactionStatus status, DataColumnContainer impl) throws SQLException, GestoreException {
    if (impl.isModifiedTable("W9PUES")) {
      
      impl.setValue("W9PUES.CODGARA", impl.getLong("W9ESITO.CODGARA"));
      impl.setOriginalValue("W9PUES.CODGARA", new JdbcParametro(JdbcParametro.TIPO_NUMERICO, impl.getLong("W9ESITO.CODGARA")));
      
      impl.setValue("W9PUES.CODLOTT", impl.getLong("W9ESITO.CODLOTT"));
      impl.setOriginalValue("W9PUES.CODLOTT", new JdbcParametro(JdbcParametro.TIPO_NUMERICO, impl.getLong("W9ESITO.CODLOTT")));
      
      impl.setValue("W9PUES.NUM_INIZ", new Long(1));
      impl.setOriginalValue("W9PUES.NUM_INIZ", new JdbcParametro(JdbcParametro.TIPO_NUMERICO, new Long(1)));
      
      // Inserimento dell'occorrenza in W9PUES
      impl.setValue("W9PUES.NUM_PUES", new Long(1));
      impl.setOriginalValue("W9PUES.NUM_PUES", new JdbcParametro(JdbcParametro.TIPO_NUMERICO, new Long(1)));
      
      long occorrenzePUES = this.geneManager.countOccorrenze("W9PUES", " CODGARA=? and CODLOTT=? and NUM_INIZ=1 and NUM_PUES=1",
          new Object[]{ impl.getLong("W9ESITO.CODGARA"), impl.getLong("W9ESITO.CODLOTT") });
      
      if (occorrenzePUES > 0) {
        // Aggiornamento dell'occorrenza in W9PUES
        this.update(status, impl, new GestoreW9PUES());
      } else {
        // Inserimento in W9PUES
        this.inserisci(status, impl, new GestoreW9PUES());
      }
    }
  }

  public void preUpdate(TransactionStatus status, DataColumnContainer impl)
      throws GestoreException {

    DataColumn dataAggiudicazione = impl.getColumn("W9ESITO.DATA_VERB_AGGIUDICAZIONE");
    DataColumn importoAggiudicazione = impl.getColumn("W9ESITO.IMPORTO_AGGIUDICAZIONE");
    
    if(dataAggiudicazione.isModified() || importoAggiudicazione.isModified()) {
      // Se data e/o importo di aggiudicazione sono stati modificati e
      // se esiste l'occorrenza in W9LOTT dell'aggiudicazione, allora
      // si aggiornano i due campi in W9LOTT
      DataColumn codiceGara = impl.getColumn("W9ESITO.CODGARA");
      DataColumn codiceLotto = impl.getColumn("W9ESITO.CODLOTT");
      
      try {
        Long numLott = (Long) this.sqlManager.getObject(
            "select count(*) from W9APPA where CODGARA=? and CODLOTT=?",
            new Object[]{ codiceGara.getValue().getValue(), codiceLotto.getValue().getValue() });
        if (numLott != null && numLott.longValue() > 0) {
          this.sqlManager.update(
              "update W9APPA set DATA_VERB_AGGIUDICAZIONE=?, IMPORTO_AGGIUDICAZIONE=? where CODGARA=? and CODLOTT=?",
              new Object[]{ dataAggiudicazione.getValue().getValue(),
                importoAggiudicazione.getValue().getValue(),
                codiceGara.getValue().getValue(),
                codiceLotto.getValue().getValue() });
        }
      } catch (SQLException e) {
        throw new GestoreException("Errore nell'aggiornamento di importo e/o data aggiudicazione " +
                "dei dati generali dell'aggiudicazione", null, e);
      }
    }
    
    GestoreW9ESITO.setFileAllegato(impl, this.getForm().getSelezioneFile(),
        this.getEntita());
    
    try {
      this.salvaPubblicazioneEsito(status, impl);
    } catch (SQLException se) {
      logger.error("Errore nel salvataggio dati in W9PUES durante l'update della scheda dell'esito (W9ESITO)", se);
      throw new GestoreException("Errore nel salvataggio di pubblicazione", 
          "gestione.esitiPubblicazioneGara", se);
    }
  }
  
  /**
   * Setta il campo FILE_ESITO nel container in modo da svuotarlo o da
   * effettuare il salvataggio del file uploadato
   * 
   * @param dcc
   *        container dei dati inseriti nella form
   * @param formFile
   *        oggetto contenente il bytearray con il contenuto del file uploadato
   * @param entita
   *        nome dell'entita in cui inserire il BLOB
   * @throws GestoreException
   */
  public static void setFileAllegato(DataColumnContainer dcc,
      FormFile formFile, String entita) throws GestoreException {
    final double MAX_FILE_SIZE = Math.pow(2, 20) * 10;
    if (dcc.isColumn("FILEDAALLEGARE")
        && dcc.getString("FILEDAALLEGARE") != null
        && !dcc.getString("FILEDAALLEGARE").trim().equals("")) {
      ByteArrayOutputStream baos = null;
      try {
        if (dcc.getString("FILEDAALLEGARE").equals("canc")) {
          // se si deve effettuare la cancellazione, si crea una colonna con
          // valore null ma con un valore originario fittizio diverso da null,
          // in modo da forzare l'update a null
          dcc.addColumn(entita + ".FILE_ALLEGATO", JdbcParametro.TIPO_BINARIO, null);
          ByteArrayOutputStream oldVal = new ByteArrayOutputStream();
          oldVal.write("FITTIZIO".getBytes());
          dcc.getColumn(entita + ".FILE_ALLEGATO").setObjectOriginalValue(oldVal);
        } else {
          // se il dato e' stato aggiornato, allora si crea la colonna con lo
          // stream ricevuto mediante upload
          if (formFile.getFileSize() > MAX_FILE_SIZE) {
            throw new GestoreException("Il file selezionato ha una dimensione "
                + "superiore al massimo consentito (10 MB)", "upload.overflow", null);
          } else {
            baos = new ByteArrayOutputStream();
            baos.write(formFile.getFileData());
            dcc.addColumn(entita + ".FILE_ALLEGATO", JdbcParametro.TIPO_BINARIO, baos);
          }
        }
      } catch (FileNotFoundException e) {
        throw new GestoreException("File da caricare non trovato", "upload", e);
      } catch (IOException e) {
        throw new GestoreException(
            "Si e' verificato un errore durante la scrittura del buffer per il salvataggio del file allegato su DB",
            "upload", e);
      }
    }
  }
 
}