package it.eldasoft.w9.dao.ibatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import it.eldasoft.gene.commons.web.spring.SqlMapClientDaoSupportBase;
import it.eldasoft.w9.dao.vo.ImpresaAggiudicataria;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Aggiudicatario;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Categorie;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAccordo;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicazione;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAvanzamento;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiCollaudo;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiComuni;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiComuniEstesi;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiConclusione;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiInizio;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiLegaleRappresentante;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiRecesso;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiResponsabile;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSospensione;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSubappalto;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiVariante;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Finanziamenti;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Offerente;
import it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Pubblicazione;

/**
 * 
 * 
 * @author Luca.Giacomazzo
 */
public class SqlMapExportLiguriaDigitaleDao extends SqlMapClientDaoSupportBase {

  public DatiComuni getDatiComuni(HashMap<String, Long> params) throws DataAccessException {
    return (DatiComuni) this.getSqlMapClientTemplate().queryForObject("selectDatiComuni", params);
  }
  
  public DatiComuniEstesi getDatiComuniEstesi(HashMap<String, Long> params) throws DataAccessException {
    return (DatiComuniEstesi) this.getSqlMapClientTemplate().queryForObject("selectDatiComuniEstesi", params);
  }
  
  public List<Long> getListaTipologiaLavori(HashMap<String, Long> params) throws DataAccessException {
    return (List<Long>) this.getSqlMapClientTemplate().queryForList("selectListaTipologiaLavori", params);
  }
  
  public List<Long> getListaTipologiaFornitureServizi(HashMap<String, Long> params) throws DataAccessException {
    return (List<Long>) this.getSqlMapClientTemplate().queryForList("selectListaTipologiaFornitureServizi", params);
  }
  
  public List<Long> getListaCondizioni(HashMap<String, Long> params) throws DataAccessException {
    return (List<Long>) this.getSqlMapClientTemplate().queryForList("selectListaCondizioni", params);
  }
  
  public List<String> getListaCpvSecondari(HashMap<String, Long> params) throws DataAccessException {
    return (List<String>) this.getSqlMapClientTemplate().queryForList("selectListaCpvSecondari", params);
  }
  
  public List<Offerente> getListaOfferenti(HashMap<String, Long> params) throws DataAccessException {
    // La query selectListaOfferenti deve estrarre i dati lo stesso ordinamento della query selectCodiceImpreseListaOfferenti
    return (List<Offerente>) this.getSqlMapClientTemplate().queryForList("selectListaOfferenti", params);
  }
  
  public List<String> getCodiceImpreseListaOfferenti(HashMap<String, Long> params) throws DataAccessException {
    // La query selectCodiceImpreseListaOfferenti deve estrarre i dati lo stesso ordinamento della query selectListaOfferenti
    return (List<String>) this.getSqlMapClientTemplate().queryForList("selectCodiceImpreseListaOfferenti", params);
  }
  
  public DatiAggiudicatari getDatiAggiudicatario(String codiceImpresa) throws DataAccessException {
    return (DatiAggiudicatari) this.getSqlMapClientTemplate().queryForObject("selectDatiAggiudicatario", codiceImpresa);
  }
  
  public DatiLegaleRappresentante getDatiLegaleRappresentante(String codiceTecnico) throws DataAccessException {
    return (DatiLegaleRappresentante) this.getSqlMapClientTemplate().queryForObject("selectDatiLegaleRappresentante", codiceTecnico);
  }
  
  public List<DatiSoggettiEstesi> getDatiSoggettiEstesi(HashMap<String, Long> params) throws DataAccessException {
    return (List<DatiSoggettiEstesi>) this.getSqlMapClientTemplate().queryForList("selectDatiSoggettiEstesi", params);
  }
  
  public List<DatiSoggettiEstesi> getDatiSoggettiEstesiAggiudicazione(HashMap<String, Long> params) throws DataAccessException {
    HashMap<String,Object> hm = new HashMap<String,Object>();
    hm.put("codiceGara", params.get("codiceGara"));
    hm.put("codiceLotto", params.get("codiceLotto"));
    List<String> listaSezioni = new ArrayList<String>();
    listaSezioni.add("PA");
    listaSezioni.add("RA");
    listaSezioni.add("RE");
    listaSezioni.add("RS");
    listaSezioni.add("RQ");
    hm.put("listaSezioni", listaSezioni);
    return (List<DatiSoggettiEstesi>) this.getSqlMapClientTemplate().queryForList("selectDatiSoggettiEstesi", hm);
  }
  
  public List<String> getCodiceTecniciSoggettiEstesi(HashMap<String, Long> params) throws DataAccessException {
    return (List<String>) this.getSqlMapClientTemplate().queryForList("selectCodiceTecniciSoggettiEstesi", params);
  }
  
  public List<String> getCodiceTecniciSoggettiEstesiAggiudicazione(HashMap<String, Long> params) throws DataAccessException {
    HashMap<String,Object> hm = new HashMap<String,Object>();
    hm.put("codiceGara", params.get("codiceGara"));
    hm.put("codiceLotto", params.get("codiceLotto"));
    List<String> listaSezioni = new ArrayList<String>();
    listaSezioni.add("PA");
    listaSezioni.add("RA");
    listaSezioni.add("RE");
    listaSezioni.add("RS");
    listaSezioni.add("RQ");
    hm.put("listaSezioni", listaSezioni);
    return (List<String>) this.getSqlMapClientTemplate().queryForList("selectCodiceTecniciSoggettiEstesi", hm);
  }
  
  public DatiResponsabile getDatiResponsabile(String codiceTecnico) throws DataAccessException {
    return (DatiResponsabile) this.getSqlMapClientTemplate().queryForObject("selectDatiResponsabile", codiceTecnico);
  }
 
  public DatiAggiudicazione getDatiAggiudicazione(HashMap<String, Long> params) throws DataAccessException {
    return (DatiAggiudicazione) this.getSqlMapClientTemplate().queryForObject("selectDatiAggiudicazione", params);
  }
 
  public DatiAggiudicazione getDatiAggiudicazioneExtra(HashMap<String, Long> params) throws DataAccessException {
    return (DatiAggiudicazione) this.getSqlMapClientTemplate().queryForObject("selectDatiAggiudicazioneExtra", params);
  }
  
  public List<Finanziamenti> getListaFinanziamenti(HashMap<String, Long> params) throws DataAccessException {
    return (List<Finanziamenti>) this.getSqlMapClientTemplate().queryForList("selectListaFinanziamenti", params);
  }
  
  public List<Categorie> getListaCategorie(HashMap<String, Long> params) throws DataAccessException {
    return (List<Categorie>) this.getSqlMapClientTemplate().queryForList("selectDatiCategorie", params);
  }
  
  public List<ImpresaAggiudicataria> getListaCampiAggiudicatari(HashMap<String, Long> params) throws DataAccessException {
    return (List<ImpresaAggiudicataria>) this.getSqlMapClientTemplate().queryForList("selectCampiListaAggiudicatari", params);
  } 
  
  public Aggiudicatario getAggiudicatario(HashMap<String, Long> params) throws DataAccessException {
    return (Aggiudicatario) this.getSqlMapClientTemplate().queryForObject("selectAggiudicatario", params);
  }

  public List<String> getCodiceImpreseAggiudicatari(HashMap<String, Long> params) throws DataAccessException {
    return (List<String>) this.getSqlMapClientTemplate().queryForList("selectCodiciImpreseAggiudicatarie", params);
  }
  
  public List<String> getCodiceImpreseAggiudicatariAusiliarie(HashMap<String, Long> params) throws DataAccessException {
    return (List<String>) this.getSqlMapClientTemplate().queryForList("selectCodiciImpreseAggiudicatarieAusiliarie", params);
  }
  
  public DatiInizio getDatiInizio(HashMap<String, Long> params) throws DataAccessException {
    return (DatiInizio) this.getSqlMapClientTemplate().queryForObject("selectDatiInizio", params);
  }
  
  public Pubblicazione getPubblicazione(HashMap<String, Long> params) throws DataAccessException {
    return (Pubblicazione) this.getSqlMapClientTemplate().queryForObject("selectPubblicazione", params);
  }
  
  public List<DatiSoggettiEstesi> getDatiSoggettiEstesiInizio(HashMap<String, Long> params) throws DataAccessException {
    HashMap<String,Object> hm = new HashMap<String,Object>();
    hm.put("codiceGara", params.get("codiceGara"));
    hm.put("codiceLotto", params.get("codiceLotto"));
    List<String> listaSezioni = new ArrayList<String>();
    listaSezioni.add("IN");
    hm.put("listaSezioni", listaSezioni);
    return (List<DatiSoggettiEstesi>) this.getSqlMapClientTemplate().queryForList("selectDatiSoggettiEstesi", hm);
  }
  
  public List<String> getCodiceTecniciSoggettiEstesiInizio(HashMap<String, Long> params) throws DataAccessException {
    HashMap<String,Object> hm = new HashMap<String,Object>();
    hm.put("codiceGara", params.get("codiceGara"));
    hm.put("codiceLotto", params.get("codiceLotto"));
    List<String> listaSezioni = new ArrayList<String>();
    listaSezioni.add("IN");
    hm.put("listaSezioni", listaSezioni);
    return (List<String>) this.getSqlMapClientTemplate().queryForList("selectCodiceTecniciSoggettiEstesi", hm);
  }

  public List<DatiAvanzamento> getListaDatiAvanzamento(HashMap<String, Long> params) throws DataAccessException {
    return (List<DatiAvanzamento>) this.getSqlMapClientTemplate().queryForList("selectDatiAvanzamento", params);
  }
  
  public List<Long> getListaCampiChiaveVarianti(HashMap<String, Long> params) throws DataAccessException {
    return (List<Long>) this.getSqlMapClientTemplate().queryForList("selectListaCampiChiaveVarianti", params);
  }
  
  public DatiVariante getDatiVarianti(HashMap<String, Long> params) throws DataAccessException {
    return (DatiVariante) this.getSqlMapClientTemplate().queryForObject("selectDatiVariante", params);
  }
  
  public List<String> getListaMotiviVariante(HashMap<String, Long> params) throws DataAccessException {
    return (List<String>) this.getSqlMapClientTemplate().queryForList("selectListaMotiviVariante", params);
  }
  
  public List<DatiSospensione> getListaDatiSospensioni(HashMap<String, Long> params) throws DataAccessException {
    return (List<DatiSospensione>) this.getSqlMapClientTemplate().queryForList("selectListaDatiSospensione", params);
  } 
  
  public DatiConclusione getDatiConclusione(HashMap<String, Long> params) throws DataAccessException {
    return (DatiConclusione) this.getSqlMapClientTemplate().queryForObject("selectDatiConclusione", params);
  } 
  
  public DatiCollaudo getDatiCollaudo(HashMap<String, Long> params) throws DataAccessException {
    return (DatiCollaudo) this.getSqlMapClientTemplate().queryForObject("selectDatiCollaudo", params);
  }
  
  public List<DatiSoggettiEstesi> getDatiSoggettiEstesiCollaudo(HashMap<String, Long> params) throws DataAccessException {
    HashMap<String,Object> hm = new HashMap<String,Object>();
    hm.put("codiceGara", params.get("codiceGara"));
    hm.put("codiceLotto", params.get("codiceLotto"));
    List<String> listaSezioni = new ArrayList<String>();
    listaSezioni.add("CO");
    hm.put("listaSezioni", listaSezioni);
    return (List<DatiSoggettiEstesi>) this.getSqlMapClientTemplate().queryForList("selectDatiSoggettiEstesi", hm);
  }

  public List<String> getCodiceTecniciSoggettiEstesiCollaudo(HashMap<String, Long> params) throws DataAccessException {
    HashMap<String,Object> hm = new HashMap<String,Object>();
    hm.put("codiceGara", params.get("codiceGara"));
    hm.put("codiceLotto", params.get("codiceLotto"));
    List<String> listaSezioni = new ArrayList<String>();
    listaSezioni.add("CO");
    hm.put("listaSezioni", listaSezioni);
    return (List<String>) this.getSqlMapClientTemplate().queryForList("selectCodiceTecniciSoggettiEstesi", hm);
  }
  
  public List<ImpresaAggiudicataria> getListaCampiSubappalti(HashMap<String, Long> params) throws DataAccessException {
    return (List<ImpresaAggiudicataria>) this.getSqlMapClientTemplate().queryForList("selectCampiListaSubappalti", params);
  }
  
  public DatiSubappalto getDatiSubappalto(HashMap<String, Long> params) throws DataAccessException {
    return (DatiSubappalto) this.getSqlMapClientTemplate().queryForObject("selectDatiSubappalto", params);
  }
  
  public List<DatiRecesso> getListaDatiRecessi(HashMap<String, Long> params) throws DataAccessException {
    return (List<DatiRecesso>) this.getSqlMapClientTemplate().queryForList("selectListaDatiRecessi", params);
  }
  
  public List<DatiAccordo> getListaDatiAccordiBonari(HashMap<String, Long> params) throws DataAccessException {
    return (List<DatiAccordo>) this.getSqlMapClientTemplate().queryForList("selectListaDatiAccordiBonari", params);
  }
}
