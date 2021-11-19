package it.eldasoft.w9.bl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import it.eldasoft.gene.bl.SqlManager;
import it.eldasoft.gene.db.sql.sqlparser.JdbcParametro;
import it.eldasoft.utils.utility.UtilityHashMap;
import it.eldasoft.utils.utility.UtilityNumeri;

/**
 * Manager per il calcolo degli indicatori statistici di un lotto.
 * 
 * @author luca.giacomazzo
 */
public class IndicatoriLottoManager {

  static Logger logger = Logger.getLogger(IndicatoriLottoManager.class); 
  
  private SqlManager sqlManager;

  public void setSqlManager(SqlManager sqlManager) {
    this.sqlManager = sqlManager;
  }
  
  /**
   * Calcolo degli indicatori per affidamento o per esecuzione del CIG indicato
   * 
   * @param codiceCIG Codice CIG del lotto 
   * @param isAffidamento true --> indicatori per affidamento, false per esecuzione
   * @return Ritorna gli indicatori per affidamento o per esecuzione del CIG indicato
   * @throws SQLException
   */
  public List<IndicatoreBean> calcolaIndicatori(String codiceCIG, boolean isAffidamento) throws SQLException {

    String tipoDiContratto = (String) this.sqlManager.getObject("select TIPO from SITAT_IND_TIPI where CIG=?",
        new Object[] { codiceCIG });
    
    List<HashMap<String, Object>> listaIndicatori = null;
    
    if (isAffidamento) {
      listaIndicatori = this.sqlManager.getListHashMap(
          "select i.ID, a.CONGRUO, a.CALCOLABILE, a.SOGLIAINF, a.SOGLIASUP, i.NOME, i.DESCRIZIONE, i.UNIMIS, "
              + " i.STR_SQL, i.TIPO, i.TIPO_SOGLIA, i.FASE, i.LIVELLO, a.INCONGRUITA, a.AFFIDABILITA, a.NUMEROSITA " 
         + " from SITAT_IND_ATTUAZIONE a, SITAT_IND_INDICATORI i "
        + " where a.TIPO=? and a.idINDICATORE=i.ID and i.NORD > 0 and i.FASE='A' order by i.NORD asc", new Object[] { tipoDiContratto });
    } else {
      listaIndicatori = this.sqlManager.getListHashMap(
          "select i.ID, a.CONGRUO, a.CALCOLABILE, a.SOGLIAINF, a.SOGLIASUP, i.NOME, i.DESCRIZIONE, i.UNIMIS, "
              + " i.STR_SQL, i.TIPO, i.TIPO_SOGLIA, i.LIVELLO, a.INCONGRUITA, a.AFFIDABILITA, a.NUMEROSITA " 
          + "from SITAT_IND_ATTUAZIONE a, SITAT_IND_INDICATORI i"
        + " where a.TIPO=? and a.idINDICATORE=i.ID and i.NORD > 0 and i.FASE='E' order by i.NORD asc", new Object[] { tipoDiContratto });
    }
    List<IndicatoreBean> listaIndicatoriBean = new ArrayList<IndicatoreBean>();
    
    if (listaIndicatori != null && listaIndicatori.size() > 0) {
      for (Iterator<HashMap<String, Object>> iterator = listaIndicatori.iterator(); iterator.hasNext();) {
        HashMap<String, Object> hashMap = iterator.next();
        
        String congruo     = ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_ATTUAZIONE.CONGRUO")).getStringValue();
        String calcolabile = ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_ATTUAZIONE.CALCOLABILE")).getStringValue();
        Double sogliaInferiore = (Double) ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_ATTUAZIONE.SOGLIAINF")).getValue();
        Double sogliaSuperiore = (Double) ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_ATTUAZIONE.SOGLIASUP")).getValue();
        String descrizione   = ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_INDICATORI.DESCRIZIONE")).getStringValue();
        String unitaDiMisura = ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_INDICATORI.UNIMIS")).getStringValue();
        String strSql = ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_INDICATORI.STR_SQL")).getStringValue();
        String tipo   = ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_INDICATORI.TIPO")).getStringValue();
        String tipoSoglia = ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_INDICATORI.TIPO_SOGLIA")).getStringValue();
        String livello    = ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_INDICATORI.LIVELLO")).getStringValue();
        String descrIncongruita  = ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "INCONGRUITA")).getStringValue();
        String affidabilitaStima = ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "AFFIDABILITA")).getStringValue();
        String numerositaStima   = ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "NUMEROSITA")).getStringValue();

        IndicatoreBean indicatore = new IndicatoreBean();
        indicatore.setDescrizione(descrizione);
        indicatore.setCalcolabile("1".equals(calcolabile));

        Object valore = null;
        if (StringUtils.isNotEmpty(strSql)) {
          valore = this.sqlManager.getObject(strSql, new Object[] { codiceCIG });
        }
        
        if (StringUtils.isNotEmpty(unitaDiMisura)) {
          indicatore.setUnitaDiMisura(unitaDiMisura);
        }

        if (StringUtils.isNotEmpty(congruo)) {
          indicatore.setCongruo(congruo);
        }

        if (StringUtils.isNotEmpty(descrIncongruita)) {
          indicatore.setDescrizioneIncongruita(descrIncongruita);
        }
        
        if (indicatore.getCalcolabile()) {
          if (StringUtils.isNotEmpty(tipoSoglia)) {
            indicatore.setTipoSoglia(tipoSoglia);
            
            // Determinazione dei valori delle soglie
            if ("I".equals(tipoSoglia)) {
              if (sogliaInferiore != null) {
                indicatore.setSogliaInferiore(UtilityNumeri.convertiDouble(sogliaInferiore, 
                    UtilityNumeri.FORMATO_DOUBLE_CON_VIRGOLA_DECIMALE, 2));
              } else {
                indicatore.setSogliaInferiore("");
              }
            } else if ("S".equals(tipoSoglia)) {
              if (sogliaSuperiore != null) {
                indicatore.setSogliaSuperiore(UtilityNumeri.convertiDouble(sogliaSuperiore, 
                    UtilityNumeri.FORMATO_DOUBLE_CON_VIRGOLA_DECIMALE, 2));
              } else {
                indicatore.setSogliaSuperiore("");
              }
            } else {
              indicatore.setSogliaInferiore(UtilityNumeri.convertiDouble(sogliaInferiore, 
                  UtilityNumeri.FORMATO_DOUBLE_CON_VIRGOLA_DECIMALE, 2));
              indicatore.setSogliaSuperiore(UtilityNumeri.convertiDouble(sogliaSuperiore, 
                  UtilityNumeri.FORMATO_DOUBLE_CON_VIRGOLA_DECIMALE, 2));
            }
          } else {
            if (sogliaInferiore != null) {
              if (sogliaSuperiore != null && sogliaInferiore.equals(sogliaSuperiore)) {
                indicatore.setSogliaSuperiore("= ".concat(
                    UtilityNumeri.convertiDouble(sogliaSuperiore, 
                        UtilityNumeri.FORMATO_DOUBLE_CON_VIRGOLA_DECIMALE, 2)));
              } else {
                indicatore.setSogliaInferiore(UtilityNumeri.convertiDouble(sogliaInferiore, 
                    UtilityNumeri.FORMATO_DOUBLE_CON_VIRGOLA_DECIMALE, 2));
              }
            } else {
              indicatore.setSogliaInferiore("");
            }
            if (sogliaSuperiore != null) {
              indicatore.setSogliaSuperiore(UtilityNumeri.convertiDouble(sogliaSuperiore, 
                  UtilityNumeri.FORMATO_DOUBLE_CON_VIRGOLA_DECIMALE, 2));
            } else {
              indicatore.setSogliaSuperiore("");
            }
          }

          if ("SN".equals(tipo)) {
            if (("1").equals((String) valore)) {
              indicatore.setValore("Si");
            } else if (("2").equals((String) valore)) {
              indicatore.setValore("No");
            } else {
              indicatore.setValore("N.D.");
            }
          } else if ("D".equals(tipo)) { // Double
            if (valore != null) {
              // Convertire il double nel formato previsto
              indicatore.setValore(UtilityNumeri.convertiDouble((Double) valore, 
                  UtilityNumeri.FORMATO_DOUBLE_CON_VIRGOLA_DECIMALE, 2));
              
              // Valorizzazione dell'asterisco
              if (sogliaInferiore != null && sogliaSuperiore != null) {
                if (sogliaInferiore.compareTo((Double) valore) > 0 || 
                  ((Double) valore).compareTo(sogliaSuperiore) > 0) {
                  indicatore.setAsterisco("*");
                }
              } else if (sogliaInferiore == null && sogliaSuperiore != null) {
                if (((Double) valore).compareTo(sogliaSuperiore) > 0) {
                  indicatore.setAsterisco("*");
                }  
              } else if (sogliaInferiore != null && sogliaSuperiore == null) {
                if (sogliaInferiore.compareTo((Double) valore) > 0) {
                  indicatore.setAsterisco("*");
                }
              }
              
            } else {
              indicatore.setValore("N.D.");
            }
            
          } else if ("N".equals(tipo)) { // Intero
            if (valore != null) {
              indicatore.setValore(valore.toString());

              // Valorizzazione dell'asterisco
              if (sogliaInferiore != null && sogliaSuperiore != null) {
                if (sogliaInferiore.compareTo(new Double((Long) valore)) > 0 || 
                  (new Double((Long) valore).compareTo(sogliaSuperiore) > 0)) {
                  indicatore.setAsterisco("*");
                }
              } else if (sogliaInferiore == null && sogliaSuperiore != null) {
                if (new Double((Long) valore).compareTo(sogliaSuperiore) > 0) {
                  indicatore.setAsterisco("*");
                }  
              } else if (sogliaInferiore != null && sogliaSuperiore == null) {
                if (sogliaInferiore.compareTo(new Double((Long) valore)) > 0) {
                  indicatore.setAsterisco("*");
                }
              }
            } else {
              indicatore.setValore("N.D.");
            }
          }
          
        } else {
          //indicatore.setSogliaSuperiore("(soglie non disponibili)");
          indicatore.setSogliaSuperiore("N.D.");
          indicatore.setSogliaInferiore("N.D.");
        }

        if (StringUtils.isNotEmpty(livello)) {
          indicatore.setLivello(livello);
        }
        if (StringUtils.isNotEmpty(affidabilitaStima)) {
          indicatore.setAffidabilitaStima(affidabilitaStima);
        }
        if (StringUtils.isNotEmpty(numerositaStima)) {
          indicatore.setContrattiSimiliStima(numerositaStima);
        }
        
        listaIndicatoriBean.add(indicatore);
      }
    }
    
    return listaIndicatoriBean;
  }
  
  // 
  /**
   * Calcolo degli indicatori per affidamento o per esecuzione del CIG indicato
   * 
   * @param codiceCIG Codice CIG del lotto 
   * @param isAffidamento true --> indicatori per affidamento, false per esecuzione
   * @return Ritorna gli indicatori per affidamento o per esecuzione del CIG indicato
   * @throws SQLException
   */
  public List<IndicatorePreliminareBean> calcolaIndicatoriPreliminare(String codiceCIG, String codiceUffint, boolean isAffidamento) throws SQLException {

    String tipoDiContratto = (String) this.sqlManager.getObject("select TIPO from SITAT_IND_TIPI where CIG=?",
        new Object[] { codiceCIG });
    
    String codiceIstatComune = (String) this.sqlManager.getObject("select CODCIT from UFFINT where CODEIN=?", 
        new Object[] { codiceUffint });
    
    List<HashMap<String, Object>> listaIndicatori = null;
    
    if (isAffidamento) {
      listaIndicatori = this.sqlManager.getListHashMap(
          "select i.ID, i.DESCRIZIONE, i.UNIMIS, a.SOGLIAINF, a.VALORE1Q, a.VALORE2Q, a.VALORE3Q, "
              + " a.SOGLIASUP, a.MEDIA, c.PERC_COM, c.PERC_PROV, c.PERC_REG, a.AFFIDABILITA, a.NUMEROSITA " 
         + " from SITAT_IND_ATTUAZIONE a, SITAT_IND_INDICATORI i, SITAT_IND_COMUNI c "
        + " where a.TIPO=? and a.idINDICATORE=i.ID and a.idINDICATORE=c.idINDICATORE and i.NORD > 0 and i.FASE='A' " +
        		" and c.COMUNE=? order by i.NORD asc", new Object[] { tipoDiContratto, codiceIstatComune });
    } else {
      listaIndicatori = this.sqlManager.getListHashMap(
          "select i.ID, i.DESCRIZIONE, i.UNIMIS, a.SOGLIAINF, a.VALORE1Q, a.VALORE2Q, a.VALORE3Q, "
              + " a.SOGLIASUP, a.MEDIA, c.PERC_COM, c.PERC_PROV, c.PERC_REG, a.AFFIDABILITA, a.NUMEROSITA " 
         + " from SITAT_IND_ATTUAZIONE a, SITAT_IND_INDICATORI i, SITAT_IND_COMUNI c "
        + " where a.TIPO=? and a.idINDICATORE=i.ID and a.idINDICATORE=c.idINDICATORE and i.NORD > 0 and i.FASE='E' " +
            " and c.COMUNE=? order by i.NORD asc", new Object[] { tipoDiContratto, codiceIstatComune });
    }
    List<IndicatorePreliminareBean> listaIndicatoriBean = new ArrayList<IndicatorePreliminareBean>();
    
    if (listaIndicatori != null && listaIndicatori.size() > 0) {
      for (Iterator<HashMap<String, Object>> iterator = listaIndicatori.iterator(); iterator.hasNext();) {
        HashMap<String, Object> hashMap = iterator.next();
        
        String descrizione   = ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_INDICATORI.DESCRIZIONE")).getStringValue();
        String unitaDiMisura = ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_INDICATORI.UNIMIS")).getStringValue();
        String affidabilitaStima = ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "AFFIDABILITA")).getStringValue();
        String numerositaStima   = ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "NUMEROSITA")).getStringValue();
        Double sogliaInferiore = (Double) ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_ATTUAZIONE.SOGLIAINF")).getValue();
        Double percentile25 = (Double) ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_ATTUAZIONE.VALORE1Q")).getValue();
        Double percentile50 = (Double) ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_ATTUAZIONE.VALORE2Q")).getValue();
        Double percentile75 = (Double) ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_ATTUAZIONE.VALORE3Q")).getValue();
        Double sogliaSuperiore = (Double) ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_ATTUAZIONE.SOGLIASUP")).getValue();
        Double media = (Double) ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_ATTUAZIONE.MEDIA")).getValue();
        Double stessoComune = (Double) ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_COMUNI.PERC_COM")).getValue();
        Double stessaProvincia = (Double) ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_COMUNI.PERC_PROV")).getValue();
        Double stessaRegione = (Double) ((JdbcParametro) UtilityHashMap.getValueCaseInsensitive(hashMap, "SITAT_IND_COMUNI.PERC_REG")).getValue();

        IndicatorePreliminareBean indicatorePreliminare = new IndicatorePreliminareBean();
        indicatorePreliminare.setDescrizione(descrizione);
        
        if (StringUtils.isNotEmpty(unitaDiMisura)) {
          indicatorePreliminare.setUnitaDiMisura(unitaDiMisura);
        } else {
          indicatorePreliminare.setUnitaDiMisura("");
        }
        
        if (StringUtils.isNotEmpty(affidabilitaStima)) {
          indicatorePreliminare.setAffidabilitaStima(affidabilitaStima);
        } else {
          indicatorePreliminare.setAffidabilitaStima("");
        }
        
        if (StringUtils.isNotEmpty(numerositaStima)) {
          indicatorePreliminare.setContrattiSimiliStima(numerositaStima);
        } else {
          indicatorePreliminare.setContrattiSimiliStima("");
        }
        
        if (sogliaInferiore != null) {
          indicatorePreliminare.setSogliaInferiore(UtilityNumeri.convertiDouble(sogliaInferiore, 
              UtilityNumeri.FORMATO_DOUBLE_CON_VIRGOLA_DECIMALE, 2));
        } else {
          indicatorePreliminare.setSogliaInferiore("");
        }
        
        if (percentile25 != null) {
          indicatorePreliminare.setPercentile25(UtilityNumeri.convertiDouble(percentile25, 
              UtilityNumeri.FORMATO_DOUBLE_CON_VIRGOLA_DECIMALE, 2));
        } else {
          indicatorePreliminare.setSogliaSuperiore("");
        }
        
        if (percentile50 != null) {
          indicatorePreliminare.setPercentile50(UtilityNumeri.convertiDouble(percentile50, 
              UtilityNumeri.FORMATO_DOUBLE_CON_VIRGOLA_DECIMALE, 2));
        } else {
          indicatorePreliminare.setSogliaSuperiore("");
        }
        
        if (percentile75 != null) {
          indicatorePreliminare.setPercentile75(UtilityNumeri.convertiDouble(percentile75, 
              UtilityNumeri.FORMATO_DOUBLE_CON_VIRGOLA_DECIMALE, 2));
        } else {
          indicatorePreliminare.setSogliaSuperiore("");
        }
        
        if (sogliaSuperiore != null) {
          indicatorePreliminare.setSogliaSuperiore(UtilityNumeri.convertiDouble(sogliaSuperiore, 
              UtilityNumeri.FORMATO_DOUBLE_CON_VIRGOLA_DECIMALE, 2));
        } else {
          indicatorePreliminare.setSogliaSuperiore("");
        }
        
        if (media != null) {
          indicatorePreliminare.setMedia(UtilityNumeri.convertiDouble(media, 
              UtilityNumeri.FORMATO_DOUBLE_CON_VIRGOLA_DECIMALE, 2));
        } else {
          indicatorePreliminare.setMedia("");
        }
        
        if (stessoComune != null) {
          indicatorePreliminare.setStessoComune(UtilityNumeri.convertiDouble(stessoComune, 
              UtilityNumeri.FORMATO_DOUBLE_CON_VIRGOLA_DECIMALE, 2));
        } else {
          indicatorePreliminare.setStessoComune("");
        }
        if (stessaProvincia != null) {
          indicatorePreliminare.setStessaProvincia(UtilityNumeri.convertiDouble(stessaProvincia, 
              UtilityNumeri.FORMATO_DOUBLE_CON_VIRGOLA_DECIMALE, 2));
        } else {
          indicatorePreliminare.setStessaProvincia("");
        }
        if (stessaRegione != null) {
          indicatorePreliminare.setStessaRegione(UtilityNumeri.convertiDouble(stessaRegione, 
              UtilityNumeri.FORMATO_DOUBLE_CON_VIRGOLA_DECIMALE, 2));
        } else {
          indicatorePreliminare.setStessaRegione("");
        }
        
        listaIndicatoriBean.add(indicatorePreliminare);
      }
    }
    return listaIndicatoriBean;
  }
  
}
