/**
 * DatiComuni.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class DatiComuni  implements java.io.Serializable {
    private java.lang.String CODICE_UFFICIO;

    private java.lang.String DESCR_UFFICIO;

    private java.lang.Double IMPORTO_LIQUIDATO;

    private java.lang.String OGGETTO_GARA;

    private java.lang.String ID_GARA;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_IMPORTO_GARA_DISP;

    private java.lang.Double IMPORTO_GARA;

    private long NUM_LOTTI;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSOType FLAG_ENTE;

    private java.lang.String MODO_INDIZIONE;

    private java.lang.String MODO_REALIZZAZIONE;

    private java.lang.String CIG_AQ;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_SA_AGENTE;

    private java.lang.String ID_TIPOLOGIA_SA;

    private java.lang.String DEN_AMM_AGENTE;

    private java.lang.String CF_AMM_AGENTE;

    private java.lang.String TIPOLOGIA_PROCEDURA;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_CENTRALE_STIPULA;

    private java.util.Calendar DATA_GURI_GARA;

    private java.util.Calendar DATA_SCADENZA_GARA;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType CAM_GARA;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType SISMA_GARA;

    private java.lang.String INDSEDE_GARA;

    private java.lang.String COMSEDE_GARA;

    private java.lang.String PROSEDE_GARA;

    public DatiComuni() {
    }

    public DatiComuni(
           java.lang.String CODICE_UFFICIO,
           java.lang.String DESCR_UFFICIO,
           java.lang.Double IMPORTO_LIQUIDATO,
           java.lang.String OGGETTO_GARA,
           java.lang.String ID_GARA,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_IMPORTO_GARA_DISP,
           java.lang.Double IMPORTO_GARA,
           long NUM_LOTTI,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSOType FLAG_ENTE,
           java.lang.String MODO_INDIZIONE,
           java.lang.String MODO_REALIZZAZIONE,
           java.lang.String CIG_AQ,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_SA_AGENTE,
           java.lang.String ID_TIPOLOGIA_SA,
           java.lang.String DEN_AMM_AGENTE,
           java.lang.String CF_AMM_AGENTE,
           java.lang.String TIPOLOGIA_PROCEDURA,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_CENTRALE_STIPULA,
           java.util.Calendar DATA_GURI_GARA,
           java.util.Calendar DATA_SCADENZA_GARA,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType CAM_GARA,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType SISMA_GARA,
           java.lang.String INDSEDE_GARA,
           java.lang.String COMSEDE_GARA,
           java.lang.String PROSEDE_GARA) {
           this.CODICE_UFFICIO = CODICE_UFFICIO;
           this.DESCR_UFFICIO = DESCR_UFFICIO;
           this.IMPORTO_LIQUIDATO = IMPORTO_LIQUIDATO;
           this.OGGETTO_GARA = OGGETTO_GARA;
           this.ID_GARA = ID_GARA;
           this.FLAG_IMPORTO_GARA_DISP = FLAG_IMPORTO_GARA_DISP;
           this.IMPORTO_GARA = IMPORTO_GARA;
           this.NUM_LOTTI = NUM_LOTTI;
           this.FLAG_ENTE = FLAG_ENTE;
           this.MODO_INDIZIONE = MODO_INDIZIONE;
           this.MODO_REALIZZAZIONE = MODO_REALIZZAZIONE;
           this.CIG_AQ = CIG_AQ;
           this.FLAG_SA_AGENTE = FLAG_SA_AGENTE;
           this.ID_TIPOLOGIA_SA = ID_TIPOLOGIA_SA;
           this.DEN_AMM_AGENTE = DEN_AMM_AGENTE;
           this.CF_AMM_AGENTE = CF_AMM_AGENTE;
           this.TIPOLOGIA_PROCEDURA = TIPOLOGIA_PROCEDURA;
           this.FLAG_CENTRALE_STIPULA = FLAG_CENTRALE_STIPULA;
           this.DATA_GURI_GARA = DATA_GURI_GARA;
           this.DATA_SCADENZA_GARA = DATA_SCADENZA_GARA;
           this.CAM_GARA = CAM_GARA;
           this.SISMA_GARA = SISMA_GARA;
           this.INDSEDE_GARA = INDSEDE_GARA;
           this.COMSEDE_GARA = COMSEDE_GARA;
           this.PROSEDE_GARA = PROSEDE_GARA;
    }


    /**
     * Gets the CODICE_UFFICIO value for this DatiComuni.
     * 
     * @return CODICE_UFFICIO
     */
    public java.lang.String getCODICE_UFFICIO() {
        return CODICE_UFFICIO;
    }


    /**
     * Sets the CODICE_UFFICIO value for this DatiComuni.
     * 
     * @param CODICE_UFFICIO
     */
    public void setCODICE_UFFICIO(java.lang.String CODICE_UFFICIO) {
        this.CODICE_UFFICIO = CODICE_UFFICIO;
    }


    /**
     * Gets the DESCR_UFFICIO value for this DatiComuni.
     * 
     * @return DESCR_UFFICIO
     */
    public java.lang.String getDESCR_UFFICIO() {
        return DESCR_UFFICIO;
    }


    /**
     * Sets the DESCR_UFFICIO value for this DatiComuni.
     * 
     * @param DESCR_UFFICIO
     */
    public void setDESCR_UFFICIO(java.lang.String DESCR_UFFICIO) {
        this.DESCR_UFFICIO = DESCR_UFFICIO;
    }


    /**
     * Gets the IMPORTO_LIQUIDATO value for this DatiComuni.
     * 
     * @return IMPORTO_LIQUIDATO
     */
    public java.lang.Double getIMPORTO_LIQUIDATO() {
        return IMPORTO_LIQUIDATO;
    }


    /**
     * Sets the IMPORTO_LIQUIDATO value for this DatiComuni.
     * 
     * @param IMPORTO_LIQUIDATO
     */
    public void setIMPORTO_LIQUIDATO(java.lang.Double IMPORTO_LIQUIDATO) {
        this.IMPORTO_LIQUIDATO = IMPORTO_LIQUIDATO;
    }


    /**
     * Gets the OGGETTO_GARA value for this DatiComuni.
     * 
     * @return OGGETTO_GARA
     */
    public java.lang.String getOGGETTO_GARA() {
        return OGGETTO_GARA;
    }


    /**
     * Sets the OGGETTO_GARA value for this DatiComuni.
     * 
     * @param OGGETTO_GARA
     */
    public void setOGGETTO_GARA(java.lang.String OGGETTO_GARA) {
        this.OGGETTO_GARA = OGGETTO_GARA;
    }


    /**
     * Gets the ID_GARA value for this DatiComuni.
     * 
     * @return ID_GARA
     */
    public java.lang.String getID_GARA() {
        return ID_GARA;
    }


    /**
     * Sets the ID_GARA value for this DatiComuni.
     * 
     * @param ID_GARA
     */
    public void setID_GARA(java.lang.String ID_GARA) {
        this.ID_GARA = ID_GARA;
    }


    /**
     * Gets the FLAG_IMPORTO_GARA_DISP value for this DatiComuni.
     * 
     * @return FLAG_IMPORTO_GARA_DISP
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_IMPORTO_GARA_DISP() {
        return FLAG_IMPORTO_GARA_DISP;
    }


    /**
     * Sets the FLAG_IMPORTO_GARA_DISP value for this DatiComuni.
     * 
     * @param FLAG_IMPORTO_GARA_DISP
     */
    public void setFLAG_IMPORTO_GARA_DISP(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_IMPORTO_GARA_DISP) {
        this.FLAG_IMPORTO_GARA_DISP = FLAG_IMPORTO_GARA_DISP;
    }


    /**
     * Gets the IMPORTO_GARA value for this DatiComuni.
     * 
     * @return IMPORTO_GARA
     */
    public java.lang.Double getIMPORTO_GARA() {
        return IMPORTO_GARA;
    }


    /**
     * Sets the IMPORTO_GARA value for this DatiComuni.
     * 
     * @param IMPORTO_GARA
     */
    public void setIMPORTO_GARA(java.lang.Double IMPORTO_GARA) {
        this.IMPORTO_GARA = IMPORTO_GARA;
    }


    /**
     * Gets the NUM_LOTTI value for this DatiComuni.
     * 
     * @return NUM_LOTTI
     */
    public long getNUM_LOTTI() {
        return NUM_LOTTI;
    }


    /**
     * Sets the NUM_LOTTI value for this DatiComuni.
     * 
     * @param NUM_LOTTI
     */
    public void setNUM_LOTTI(long NUM_LOTTI) {
        this.NUM_LOTTI = NUM_LOTTI;
    }


    /**
     * Gets the FLAG_ENTE value for this DatiComuni.
     * 
     * @return FLAG_ENTE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSOType getFLAG_ENTE() {
        return FLAG_ENTE;
    }


    /**
     * Sets the FLAG_ENTE value for this DatiComuni.
     * 
     * @param FLAG_ENTE
     */
    public void setFLAG_ENTE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSOType FLAG_ENTE) {
        this.FLAG_ENTE = FLAG_ENTE;
    }


    /**
     * Gets the MODO_INDIZIONE value for this DatiComuni.
     * 
     * @return MODO_INDIZIONE
     */
    public java.lang.String getMODO_INDIZIONE() {
        return MODO_INDIZIONE;
    }


    /**
     * Sets the MODO_INDIZIONE value for this DatiComuni.
     * 
     * @param MODO_INDIZIONE
     */
    public void setMODO_INDIZIONE(java.lang.String MODO_INDIZIONE) {
        this.MODO_INDIZIONE = MODO_INDIZIONE;
    }


    /**
     * Gets the MODO_REALIZZAZIONE value for this DatiComuni.
     * 
     * @return MODO_REALIZZAZIONE
     */
    public java.lang.String getMODO_REALIZZAZIONE() {
        return MODO_REALIZZAZIONE;
    }


    /**
     * Sets the MODO_REALIZZAZIONE value for this DatiComuni.
     * 
     * @param MODO_REALIZZAZIONE
     */
    public void setMODO_REALIZZAZIONE(java.lang.String MODO_REALIZZAZIONE) {
        this.MODO_REALIZZAZIONE = MODO_REALIZZAZIONE;
    }


    /**
     * Gets the CIG_AQ value for this DatiComuni.
     * 
     * @return CIG_AQ
     */
    public java.lang.String getCIG_AQ() {
        return CIG_AQ;
    }


    /**
     * Sets the CIG_AQ value for this DatiComuni.
     * 
     * @param CIG_AQ
     */
    public void setCIG_AQ(java.lang.String CIG_AQ) {
        this.CIG_AQ = CIG_AQ;
    }


    /**
     * Gets the FLAG_SA_AGENTE value for this DatiComuni.
     * 
     * @return FLAG_SA_AGENTE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_SA_AGENTE() {
        return FLAG_SA_AGENTE;
    }


    /**
     * Sets the FLAG_SA_AGENTE value for this DatiComuni.
     * 
     * @param FLAG_SA_AGENTE
     */
    public void setFLAG_SA_AGENTE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_SA_AGENTE) {
        this.FLAG_SA_AGENTE = FLAG_SA_AGENTE;
    }


    /**
     * Gets the ID_TIPOLOGIA_SA value for this DatiComuni.
     * 
     * @return ID_TIPOLOGIA_SA
     */
    public java.lang.String getID_TIPOLOGIA_SA() {
        return ID_TIPOLOGIA_SA;
    }


    /**
     * Sets the ID_TIPOLOGIA_SA value for this DatiComuni.
     * 
     * @param ID_TIPOLOGIA_SA
     */
    public void setID_TIPOLOGIA_SA(java.lang.String ID_TIPOLOGIA_SA) {
        this.ID_TIPOLOGIA_SA = ID_TIPOLOGIA_SA;
    }


    /**
     * Gets the DEN_AMM_AGENTE value for this DatiComuni.
     * 
     * @return DEN_AMM_AGENTE
     */
    public java.lang.String getDEN_AMM_AGENTE() {
        return DEN_AMM_AGENTE;
    }


    /**
     * Sets the DEN_AMM_AGENTE value for this DatiComuni.
     * 
     * @param DEN_AMM_AGENTE
     */
    public void setDEN_AMM_AGENTE(java.lang.String DEN_AMM_AGENTE) {
        this.DEN_AMM_AGENTE = DEN_AMM_AGENTE;
    }


    /**
     * Gets the CF_AMM_AGENTE value for this DatiComuni.
     * 
     * @return CF_AMM_AGENTE
     */
    public java.lang.String getCF_AMM_AGENTE() {
        return CF_AMM_AGENTE;
    }


    /**
     * Sets the CF_AMM_AGENTE value for this DatiComuni.
     * 
     * @param CF_AMM_AGENTE
     */
    public void setCF_AMM_AGENTE(java.lang.String CF_AMM_AGENTE) {
        this.CF_AMM_AGENTE = CF_AMM_AGENTE;
    }


    /**
     * Gets the TIPOLOGIA_PROCEDURA value for this DatiComuni.
     * 
     * @return TIPOLOGIA_PROCEDURA
     */
    public java.lang.String getTIPOLOGIA_PROCEDURA() {
        return TIPOLOGIA_PROCEDURA;
    }


    /**
     * Sets the TIPOLOGIA_PROCEDURA value for this DatiComuni.
     * 
     * @param TIPOLOGIA_PROCEDURA
     */
    public void setTIPOLOGIA_PROCEDURA(java.lang.String TIPOLOGIA_PROCEDURA) {
        this.TIPOLOGIA_PROCEDURA = TIPOLOGIA_PROCEDURA;
    }


    /**
     * Gets the FLAG_CENTRALE_STIPULA value for this DatiComuni.
     * 
     * @return FLAG_CENTRALE_STIPULA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_CENTRALE_STIPULA() {
        return FLAG_CENTRALE_STIPULA;
    }


    /**
     * Sets the FLAG_CENTRALE_STIPULA value for this DatiComuni.
     * 
     * @param FLAG_CENTRALE_STIPULA
     */
    public void setFLAG_CENTRALE_STIPULA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_CENTRALE_STIPULA) {
        this.FLAG_CENTRALE_STIPULA = FLAG_CENTRALE_STIPULA;
    }


    /**
     * Gets the DATA_GURI_GARA value for this DatiComuni.
     * 
     * @return DATA_GURI_GARA
     */
    public java.util.Calendar getDATA_GURI_GARA() {
        return DATA_GURI_GARA;
    }


    /**
     * Sets the DATA_GURI_GARA value for this DatiComuni.
     * 
     * @param DATA_GURI_GARA
     */
    public void setDATA_GURI_GARA(java.util.Calendar DATA_GURI_GARA) {
        this.DATA_GURI_GARA = DATA_GURI_GARA;
    }


    /**
     * Gets the DATA_SCADENZA_GARA value for this DatiComuni.
     * 
     * @return DATA_SCADENZA_GARA
     */
    public java.util.Calendar getDATA_SCADENZA_GARA() {
        return DATA_SCADENZA_GARA;
    }


    /**
     * Sets the DATA_SCADENZA_GARA value for this DatiComuni.
     * 
     * @param DATA_SCADENZA_GARA
     */
    public void setDATA_SCADENZA_GARA(java.util.Calendar DATA_SCADENZA_GARA) {
        this.DATA_SCADENZA_GARA = DATA_SCADENZA_GARA;
    }


    /**
     * Gets the CAM_GARA value for this DatiComuni.
     * 
     * @return CAM_GARA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getCAM_GARA() {
        return CAM_GARA;
    }


    /**
     * Sets the CAM_GARA value for this DatiComuni.
     * 
     * @param CAM_GARA
     */
    public void setCAM_GARA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType CAM_GARA) {
        this.CAM_GARA = CAM_GARA;
    }


    /**
     * Gets the SISMA_GARA value for this DatiComuni.
     * 
     * @return SISMA_GARA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getSISMA_GARA() {
        return SISMA_GARA;
    }


    /**
     * Sets the SISMA_GARA value for this DatiComuni.
     * 
     * @param SISMA_GARA
     */
    public void setSISMA_GARA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType SISMA_GARA) {
        this.SISMA_GARA = SISMA_GARA;
    }


    /**
     * Gets the INDSEDE_GARA value for this DatiComuni.
     * 
     * @return INDSEDE_GARA
     */
    public java.lang.String getINDSEDE_GARA() {
        return INDSEDE_GARA;
    }


    /**
     * Sets the INDSEDE_GARA value for this DatiComuni.
     * 
     * @param INDSEDE_GARA
     */
    public void setINDSEDE_GARA(java.lang.String INDSEDE_GARA) {
        this.INDSEDE_GARA = INDSEDE_GARA;
    }


    /**
     * Gets the COMSEDE_GARA value for this DatiComuni.
     * 
     * @return COMSEDE_GARA
     */
    public java.lang.String getCOMSEDE_GARA() {
        return COMSEDE_GARA;
    }


    /**
     * Sets the COMSEDE_GARA value for this DatiComuni.
     * 
     * @param COMSEDE_GARA
     */
    public void setCOMSEDE_GARA(java.lang.String COMSEDE_GARA) {
        this.COMSEDE_GARA = COMSEDE_GARA;
    }


    /**
     * Gets the PROSEDE_GARA value for this DatiComuni.
     * 
     * @return PROSEDE_GARA
     */
    public java.lang.String getPROSEDE_GARA() {
        return PROSEDE_GARA;
    }


    /**
     * Sets the PROSEDE_GARA value for this DatiComuni.
     * 
     * @param PROSEDE_GARA
     */
    public void setPROSEDE_GARA(java.lang.String PROSEDE_GARA) {
        this.PROSEDE_GARA = PROSEDE_GARA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatiComuni)) return false;
        DatiComuni other = (DatiComuni) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.CODICE_UFFICIO==null && other.getCODICE_UFFICIO()==null) || 
             (this.CODICE_UFFICIO!=null &&
              this.CODICE_UFFICIO.equals(other.getCODICE_UFFICIO()))) &&
            ((this.DESCR_UFFICIO==null && other.getDESCR_UFFICIO()==null) || 
             (this.DESCR_UFFICIO!=null &&
              this.DESCR_UFFICIO.equals(other.getDESCR_UFFICIO()))) &&
            ((this.IMPORTO_LIQUIDATO==null && other.getIMPORTO_LIQUIDATO()==null) || 
             (this.IMPORTO_LIQUIDATO!=null &&
              this.IMPORTO_LIQUIDATO.equals(other.getIMPORTO_LIQUIDATO()))) &&
            ((this.OGGETTO_GARA==null && other.getOGGETTO_GARA()==null) || 
             (this.OGGETTO_GARA!=null &&
              this.OGGETTO_GARA.equals(other.getOGGETTO_GARA()))) &&
            ((this.ID_GARA==null && other.getID_GARA()==null) || 
             (this.ID_GARA!=null &&
              this.ID_GARA.equals(other.getID_GARA()))) &&
            ((this.FLAG_IMPORTO_GARA_DISP==null && other.getFLAG_IMPORTO_GARA_DISP()==null) || 
             (this.FLAG_IMPORTO_GARA_DISP!=null &&
              this.FLAG_IMPORTO_GARA_DISP.equals(other.getFLAG_IMPORTO_GARA_DISP()))) &&
            ((this.IMPORTO_GARA==null && other.getIMPORTO_GARA()==null) || 
             (this.IMPORTO_GARA!=null &&
              this.IMPORTO_GARA.equals(other.getIMPORTO_GARA()))) &&
            this.NUM_LOTTI == other.getNUM_LOTTI() &&
            ((this.FLAG_ENTE==null && other.getFLAG_ENTE()==null) || 
             (this.FLAG_ENTE!=null &&
              this.FLAG_ENTE.equals(other.getFLAG_ENTE()))) &&
            ((this.MODO_INDIZIONE==null && other.getMODO_INDIZIONE()==null) || 
             (this.MODO_INDIZIONE!=null &&
              this.MODO_INDIZIONE.equals(other.getMODO_INDIZIONE()))) &&
            ((this.MODO_REALIZZAZIONE==null && other.getMODO_REALIZZAZIONE()==null) || 
             (this.MODO_REALIZZAZIONE!=null &&
              this.MODO_REALIZZAZIONE.equals(other.getMODO_REALIZZAZIONE()))) &&
            ((this.CIG_AQ==null && other.getCIG_AQ()==null) || 
             (this.CIG_AQ!=null &&
              this.CIG_AQ.equals(other.getCIG_AQ()))) &&
            ((this.FLAG_SA_AGENTE==null && other.getFLAG_SA_AGENTE()==null) || 
             (this.FLAG_SA_AGENTE!=null &&
              this.FLAG_SA_AGENTE.equals(other.getFLAG_SA_AGENTE()))) &&
            ((this.ID_TIPOLOGIA_SA==null && other.getID_TIPOLOGIA_SA()==null) || 
             (this.ID_TIPOLOGIA_SA!=null &&
              this.ID_TIPOLOGIA_SA.equals(other.getID_TIPOLOGIA_SA()))) &&
            ((this.DEN_AMM_AGENTE==null && other.getDEN_AMM_AGENTE()==null) || 
             (this.DEN_AMM_AGENTE!=null &&
              this.DEN_AMM_AGENTE.equals(other.getDEN_AMM_AGENTE()))) &&
            ((this.CF_AMM_AGENTE==null && other.getCF_AMM_AGENTE()==null) || 
             (this.CF_AMM_AGENTE!=null &&
              this.CF_AMM_AGENTE.equals(other.getCF_AMM_AGENTE()))) &&
            ((this.TIPOLOGIA_PROCEDURA==null && other.getTIPOLOGIA_PROCEDURA()==null) || 
             (this.TIPOLOGIA_PROCEDURA!=null &&
              this.TIPOLOGIA_PROCEDURA.equals(other.getTIPOLOGIA_PROCEDURA()))) &&
            ((this.FLAG_CENTRALE_STIPULA==null && other.getFLAG_CENTRALE_STIPULA()==null) || 
             (this.FLAG_CENTRALE_STIPULA!=null &&
              this.FLAG_CENTRALE_STIPULA.equals(other.getFLAG_CENTRALE_STIPULA()))) &&
            ((this.DATA_GURI_GARA==null && other.getDATA_GURI_GARA()==null) || 
             (this.DATA_GURI_GARA!=null &&
              this.DATA_GURI_GARA.equals(other.getDATA_GURI_GARA()))) &&
            ((this.DATA_SCADENZA_GARA==null && other.getDATA_SCADENZA_GARA()==null) || 
             (this.DATA_SCADENZA_GARA!=null &&
              this.DATA_SCADENZA_GARA.equals(other.getDATA_SCADENZA_GARA()))) &&
            ((this.CAM_GARA==null && other.getCAM_GARA()==null) || 
             (this.CAM_GARA!=null &&
              this.CAM_GARA.equals(other.getCAM_GARA()))) &&
            ((this.SISMA_GARA==null && other.getSISMA_GARA()==null) || 
             (this.SISMA_GARA!=null &&
              this.SISMA_GARA.equals(other.getSISMA_GARA()))) &&
            ((this.INDSEDE_GARA==null && other.getINDSEDE_GARA()==null) || 
             (this.INDSEDE_GARA!=null &&
              this.INDSEDE_GARA.equals(other.getINDSEDE_GARA()))) &&
            ((this.COMSEDE_GARA==null && other.getCOMSEDE_GARA()==null) || 
             (this.COMSEDE_GARA!=null &&
              this.COMSEDE_GARA.equals(other.getCOMSEDE_GARA()))) &&
            ((this.PROSEDE_GARA==null && other.getPROSEDE_GARA()==null) || 
             (this.PROSEDE_GARA!=null &&
              this.PROSEDE_GARA.equals(other.getPROSEDE_GARA())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCODICE_UFFICIO() != null) {
            _hashCode += getCODICE_UFFICIO().hashCode();
        }
        if (getDESCR_UFFICIO() != null) {
            _hashCode += getDESCR_UFFICIO().hashCode();
        }
        if (getIMPORTO_LIQUIDATO() != null) {
            _hashCode += getIMPORTO_LIQUIDATO().hashCode();
        }
        if (getOGGETTO_GARA() != null) {
            _hashCode += getOGGETTO_GARA().hashCode();
        }
        if (getID_GARA() != null) {
            _hashCode += getID_GARA().hashCode();
        }
        if (getFLAG_IMPORTO_GARA_DISP() != null) {
            _hashCode += getFLAG_IMPORTO_GARA_DISP().hashCode();
        }
        if (getIMPORTO_GARA() != null) {
            _hashCode += getIMPORTO_GARA().hashCode();
        }
        _hashCode += new Long(getNUM_LOTTI()).hashCode();
        if (getFLAG_ENTE() != null) {
            _hashCode += getFLAG_ENTE().hashCode();
        }
        if (getMODO_INDIZIONE() != null) {
            _hashCode += getMODO_INDIZIONE().hashCode();
        }
        if (getMODO_REALIZZAZIONE() != null) {
            _hashCode += getMODO_REALIZZAZIONE().hashCode();
        }
        if (getCIG_AQ() != null) {
            _hashCode += getCIG_AQ().hashCode();
        }
        if (getFLAG_SA_AGENTE() != null) {
            _hashCode += getFLAG_SA_AGENTE().hashCode();
        }
        if (getID_TIPOLOGIA_SA() != null) {
            _hashCode += getID_TIPOLOGIA_SA().hashCode();
        }
        if (getDEN_AMM_AGENTE() != null) {
            _hashCode += getDEN_AMM_AGENTE().hashCode();
        }
        if (getCF_AMM_AGENTE() != null) {
            _hashCode += getCF_AMM_AGENTE().hashCode();
        }
        if (getTIPOLOGIA_PROCEDURA() != null) {
            _hashCode += getTIPOLOGIA_PROCEDURA().hashCode();
        }
        if (getFLAG_CENTRALE_STIPULA() != null) {
            _hashCode += getFLAG_CENTRALE_STIPULA().hashCode();
        }
        if (getDATA_GURI_GARA() != null) {
            _hashCode += getDATA_GURI_GARA().hashCode();
        }
        if (getDATA_SCADENZA_GARA() != null) {
            _hashCode += getDATA_SCADENZA_GARA().hashCode();
        }
        if (getCAM_GARA() != null) {
            _hashCode += getCAM_GARA().hashCode();
        }
        if (getSISMA_GARA() != null) {
            _hashCode += getSISMA_GARA().hashCode();
        }
        if (getINDSEDE_GARA() != null) {
            _hashCode += getINDSEDE_GARA().hashCode();
        }
        if (getCOMSEDE_GARA() != null) {
            _hashCode += getCOMSEDE_GARA().hashCode();
        }
        if (getPROSEDE_GARA() != null) {
            _hashCode += getPROSEDE_GARA().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatiComuni.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiComuni"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CODICE_UFFICIO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CODICE_UFFICIO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DESCR_UFFICIO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DESCR_UFFICIO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_LIQUIDATO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_LIQUIDATO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OGGETTO_GARA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "OGGETTO_GARA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_GARA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_GARA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_IMPORTO_GARA_DISP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_IMPORTO_GARA_DISP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_GARA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_GARA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_LOTTI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_LOTTI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_ENTE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_ENTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSOType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MODO_INDIZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "MODO_INDIZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MODO_REALIZZAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "MODO_REALIZZAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CIG_AQ");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CIG_AQ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_SA_AGENTE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_SA_AGENTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_TIPOLOGIA_SA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_TIPOLOGIA_SA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DEN_AMM_AGENTE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DEN_AMM_AGENTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CF_AMM_AGENTE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CF_AMM_AGENTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TIPOLOGIA_PROCEDURA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TIPOLOGIA_PROCEDURA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_CENTRALE_STIPULA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_CENTRALE_STIPULA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_GURI_GARA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_GURI_GARA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_SCADENZA_GARA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_SCADENZA_GARA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CAM_GARA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CAM_GARA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SISMA_GARA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SISMA_GARA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("INDSEDE_GARA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "INDSEDE_GARA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COMSEDE_GARA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "COMSEDE_GARA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROSEDE_GARA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "PROSEDE_GARA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
