/**
 * DatiCollaudo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class DatiCollaudo  implements java.io.Serializable {
    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSingoloCommissioneType FLAG_SINGOLO_COMMISSIONE;

    private java.util.Calendar DATA_APPROVAZIONE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType FLAG_IMPORTI;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType FLAG_SICUREZZA;

    private java.util.Calendar DATA_INIZIO_AMM_RISERVE;

    private java.util.Calendar DATA_FINE_AMM_RISERVE;

    private java.lang.Double ONERI_AMM_RISERVE;

    private java.util.Calendar DATA_INIZIO_ARB_RISERVE;

    private java.util.Calendar DATA_FINE_ARB_RISERVE;

    private java.lang.Double ONERI_ARB_RISERVE;

    private java.util.Calendar DATA_INIZIO_GIU_RISERVE;

    private java.util.Calendar DATA_FINE_GIU_RISERVE;

    private java.lang.Double ONERI_GIU_RISERVE;

    private java.util.Calendar DATA_INIZIO_TRA_RISERVE;

    private java.util.Calendar DATA_FINE_TRA_RISERVE;

    private java.lang.Double ONERI_TRA_RISERVE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_SUBAPPALTATORI;

    private java.util.Calendar DATA_REGOLARE_ESEC;

    private java.util.Calendar DATA_COLLAUDO_STAT;

    private java.lang.String MODO_COLLAUDO;

    private java.util.Calendar DATA_NOMINA_COLL;

    private java.util.Calendar DATA_INIZIO_OPER;

    private java.util.Calendar DATA_CERT_COLLAUDO;

    private java.util.Calendar DATA_DELIBERA;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagEsitoCollaudoType ESITO_COLLAUDO;

    private java.lang.Double IMP_FINALE_LAVORI;

    private java.lang.Double IMP_FINALE_SERVIZI;

    private java.lang.Double IMP_FINALE_FORNIT;

    private java.lang.Double IMP_FINALE_SECUR;

    private java.lang.Double IMP_PROGETTAZIONE;

    private double IMP_DISPOSIZIONE;

    private java.lang.Long AMM_NUM_DEFINITE;

    private java.lang.Long AMM_NUM_DADEF;

    private java.lang.Double AMM_IMPORTO_RICH;

    private java.lang.Double AMM_IMPORTO_DEF;

    private java.lang.Long ARB_NUM_DEFINITE;

    private java.lang.Long ARB_NUM_DADEF;

    private java.lang.Double ARB_IMPORTO_RICH;

    private java.lang.Double ARB_IMPORTO_DEF;

    private java.lang.Long GIU_NUM_DEFINITE;

    private java.lang.Long GIU_NUM_DADEF;

    private java.lang.Double GIU_IMPORTO_RICH;

    private java.lang.Double GIU_IMPORTO_DEF;

    private java.lang.Long TRA_NUM_DEFINITE;

    private java.lang.Long TRA_NUM_DADEF;

    private java.lang.Double TRA_IMPORTO_RICH;

    private java.lang.Double TRA_IMPORTO_DEF;

    private double IMPORTO_SUBTOTALE;

    private double IMPORTO_FINALE;

    private double IMPORTO_CONSUNTIVO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_LAVORI_ESTESI;

    public DatiCollaudo() {
    }

    public DatiCollaudo(
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSingoloCommissioneType FLAG_SINGOLO_COMMISSIONE,
           java.util.Calendar DATA_APPROVAZIONE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType FLAG_IMPORTI,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType FLAG_SICUREZZA,
           java.util.Calendar DATA_INIZIO_AMM_RISERVE,
           java.util.Calendar DATA_FINE_AMM_RISERVE,
           java.lang.Double ONERI_AMM_RISERVE,
           java.util.Calendar DATA_INIZIO_ARB_RISERVE,
           java.util.Calendar DATA_FINE_ARB_RISERVE,
           java.lang.Double ONERI_ARB_RISERVE,
           java.util.Calendar DATA_INIZIO_GIU_RISERVE,
           java.util.Calendar DATA_FINE_GIU_RISERVE,
           java.lang.Double ONERI_GIU_RISERVE,
           java.util.Calendar DATA_INIZIO_TRA_RISERVE,
           java.util.Calendar DATA_FINE_TRA_RISERVE,
           java.lang.Double ONERI_TRA_RISERVE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_SUBAPPALTATORI,
           java.util.Calendar DATA_REGOLARE_ESEC,
           java.util.Calendar DATA_COLLAUDO_STAT,
           java.lang.String MODO_COLLAUDO,
           java.util.Calendar DATA_NOMINA_COLL,
           java.util.Calendar DATA_INIZIO_OPER,
           java.util.Calendar DATA_CERT_COLLAUDO,
           java.util.Calendar DATA_DELIBERA,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagEsitoCollaudoType ESITO_COLLAUDO,
           java.lang.Double IMP_FINALE_LAVORI,
           java.lang.Double IMP_FINALE_SERVIZI,
           java.lang.Double IMP_FINALE_FORNIT,
           java.lang.Double IMP_FINALE_SECUR,
           java.lang.Double IMP_PROGETTAZIONE,
           double IMP_DISPOSIZIONE,
           java.lang.Long AMM_NUM_DEFINITE,
           java.lang.Long AMM_NUM_DADEF,
           java.lang.Double AMM_IMPORTO_RICH,
           java.lang.Double AMM_IMPORTO_DEF,
           java.lang.Long ARB_NUM_DEFINITE,
           java.lang.Long ARB_NUM_DADEF,
           java.lang.Double ARB_IMPORTO_RICH,
           java.lang.Double ARB_IMPORTO_DEF,
           java.lang.Long GIU_NUM_DEFINITE,
           java.lang.Long GIU_NUM_DADEF,
           java.lang.Double GIU_IMPORTO_RICH,
           java.lang.Double GIU_IMPORTO_DEF,
           java.lang.Long TRA_NUM_DEFINITE,
           java.lang.Long TRA_NUM_DADEF,
           java.lang.Double TRA_IMPORTO_RICH,
           java.lang.Double TRA_IMPORTO_DEF,
           double IMPORTO_SUBTOTALE,
           double IMPORTO_FINALE,
           double IMPORTO_CONSUNTIVO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_LAVORI_ESTESI) {
           this.FLAG_SINGOLO_COMMISSIONE = FLAG_SINGOLO_COMMISSIONE;
           this.DATA_APPROVAZIONE = DATA_APPROVAZIONE;
           this.FLAG_IMPORTI = FLAG_IMPORTI;
           this.FLAG_SICUREZZA = FLAG_SICUREZZA;
           this.DATA_INIZIO_AMM_RISERVE = DATA_INIZIO_AMM_RISERVE;
           this.DATA_FINE_AMM_RISERVE = DATA_FINE_AMM_RISERVE;
           this.ONERI_AMM_RISERVE = ONERI_AMM_RISERVE;
           this.DATA_INIZIO_ARB_RISERVE = DATA_INIZIO_ARB_RISERVE;
           this.DATA_FINE_ARB_RISERVE = DATA_FINE_ARB_RISERVE;
           this.ONERI_ARB_RISERVE = ONERI_ARB_RISERVE;
           this.DATA_INIZIO_GIU_RISERVE = DATA_INIZIO_GIU_RISERVE;
           this.DATA_FINE_GIU_RISERVE = DATA_FINE_GIU_RISERVE;
           this.ONERI_GIU_RISERVE = ONERI_GIU_RISERVE;
           this.DATA_INIZIO_TRA_RISERVE = DATA_INIZIO_TRA_RISERVE;
           this.DATA_FINE_TRA_RISERVE = DATA_FINE_TRA_RISERVE;
           this.ONERI_TRA_RISERVE = ONERI_TRA_RISERVE;
           this.FLAG_SUBAPPALTATORI = FLAG_SUBAPPALTATORI;
           this.DATA_REGOLARE_ESEC = DATA_REGOLARE_ESEC;
           this.DATA_COLLAUDO_STAT = DATA_COLLAUDO_STAT;
           this.MODO_COLLAUDO = MODO_COLLAUDO;
           this.DATA_NOMINA_COLL = DATA_NOMINA_COLL;
           this.DATA_INIZIO_OPER = DATA_INIZIO_OPER;
           this.DATA_CERT_COLLAUDO = DATA_CERT_COLLAUDO;
           this.DATA_DELIBERA = DATA_DELIBERA;
           this.ESITO_COLLAUDO = ESITO_COLLAUDO;
           this.IMP_FINALE_LAVORI = IMP_FINALE_LAVORI;
           this.IMP_FINALE_SERVIZI = IMP_FINALE_SERVIZI;
           this.IMP_FINALE_FORNIT = IMP_FINALE_FORNIT;
           this.IMP_FINALE_SECUR = IMP_FINALE_SECUR;
           this.IMP_PROGETTAZIONE = IMP_PROGETTAZIONE;
           this.IMP_DISPOSIZIONE = IMP_DISPOSIZIONE;
           this.AMM_NUM_DEFINITE = AMM_NUM_DEFINITE;
           this.AMM_NUM_DADEF = AMM_NUM_DADEF;
           this.AMM_IMPORTO_RICH = AMM_IMPORTO_RICH;
           this.AMM_IMPORTO_DEF = AMM_IMPORTO_DEF;
           this.ARB_NUM_DEFINITE = ARB_NUM_DEFINITE;
           this.ARB_NUM_DADEF = ARB_NUM_DADEF;
           this.ARB_IMPORTO_RICH = ARB_IMPORTO_RICH;
           this.ARB_IMPORTO_DEF = ARB_IMPORTO_DEF;
           this.GIU_NUM_DEFINITE = GIU_NUM_DEFINITE;
           this.GIU_NUM_DADEF = GIU_NUM_DADEF;
           this.GIU_IMPORTO_RICH = GIU_IMPORTO_RICH;
           this.GIU_IMPORTO_DEF = GIU_IMPORTO_DEF;
           this.TRA_NUM_DEFINITE = TRA_NUM_DEFINITE;
           this.TRA_NUM_DADEF = TRA_NUM_DADEF;
           this.TRA_IMPORTO_RICH = TRA_IMPORTO_RICH;
           this.TRA_IMPORTO_DEF = TRA_IMPORTO_DEF;
           this.IMPORTO_SUBTOTALE = IMPORTO_SUBTOTALE;
           this.IMPORTO_FINALE = IMPORTO_FINALE;
           this.IMPORTO_CONSUNTIVO = IMPORTO_CONSUNTIVO;
           this.FLAG_LAVORI_ESTESI = FLAG_LAVORI_ESTESI;
    }


    /**
     * Gets the FLAG_SINGOLO_COMMISSIONE value for this DatiCollaudo.
     * 
     * @return FLAG_SINGOLO_COMMISSIONE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSingoloCommissioneType getFLAG_SINGOLO_COMMISSIONE() {
        return FLAG_SINGOLO_COMMISSIONE;
    }


    /**
     * Sets the FLAG_SINGOLO_COMMISSIONE value for this DatiCollaudo.
     * 
     * @param FLAG_SINGOLO_COMMISSIONE
     */
    public void setFLAG_SINGOLO_COMMISSIONE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSingoloCommissioneType FLAG_SINGOLO_COMMISSIONE) {
        this.FLAG_SINGOLO_COMMISSIONE = FLAG_SINGOLO_COMMISSIONE;
    }


    /**
     * Gets the DATA_APPROVAZIONE value for this DatiCollaudo.
     * 
     * @return DATA_APPROVAZIONE
     */
    public java.util.Calendar getDATA_APPROVAZIONE() {
        return DATA_APPROVAZIONE;
    }


    /**
     * Sets the DATA_APPROVAZIONE value for this DatiCollaudo.
     * 
     * @param DATA_APPROVAZIONE
     */
    public void setDATA_APPROVAZIONE(java.util.Calendar DATA_APPROVAZIONE) {
        this.DATA_APPROVAZIONE = DATA_APPROVAZIONE;
    }


    /**
     * Gets the FLAG_IMPORTI value for this DatiCollaudo.
     * 
     * @return FLAG_IMPORTI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType getFLAG_IMPORTI() {
        return FLAG_IMPORTI;
    }


    /**
     * Sets the FLAG_IMPORTI value for this DatiCollaudo.
     * 
     * @param FLAG_IMPORTI
     */
    public void setFLAG_IMPORTI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType FLAG_IMPORTI) {
        this.FLAG_IMPORTI = FLAG_IMPORTI;
    }


    /**
     * Gets the FLAG_SICUREZZA value for this DatiCollaudo.
     * 
     * @return FLAG_SICUREZZA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType getFLAG_SICUREZZA() {
        return FLAG_SICUREZZA;
    }


    /**
     * Sets the FLAG_SICUREZZA value for this DatiCollaudo.
     * 
     * @param FLAG_SICUREZZA
     */
    public void setFLAG_SICUREZZA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType FLAG_SICUREZZA) {
        this.FLAG_SICUREZZA = FLAG_SICUREZZA;
    }


    /**
     * Gets the DATA_INIZIO_AMM_RISERVE value for this DatiCollaudo.
     * 
     * @return DATA_INIZIO_AMM_RISERVE
     */
    public java.util.Calendar getDATA_INIZIO_AMM_RISERVE() {
        return DATA_INIZIO_AMM_RISERVE;
    }


    /**
     * Sets the DATA_INIZIO_AMM_RISERVE value for this DatiCollaudo.
     * 
     * @param DATA_INIZIO_AMM_RISERVE
     */
    public void setDATA_INIZIO_AMM_RISERVE(java.util.Calendar DATA_INIZIO_AMM_RISERVE) {
        this.DATA_INIZIO_AMM_RISERVE = DATA_INIZIO_AMM_RISERVE;
    }


    /**
     * Gets the DATA_FINE_AMM_RISERVE value for this DatiCollaudo.
     * 
     * @return DATA_FINE_AMM_RISERVE
     */
    public java.util.Calendar getDATA_FINE_AMM_RISERVE() {
        return DATA_FINE_AMM_RISERVE;
    }


    /**
     * Sets the DATA_FINE_AMM_RISERVE value for this DatiCollaudo.
     * 
     * @param DATA_FINE_AMM_RISERVE
     */
    public void setDATA_FINE_AMM_RISERVE(java.util.Calendar DATA_FINE_AMM_RISERVE) {
        this.DATA_FINE_AMM_RISERVE = DATA_FINE_AMM_RISERVE;
    }


    /**
     * Gets the ONERI_AMM_RISERVE value for this DatiCollaudo.
     * 
     * @return ONERI_AMM_RISERVE
     */
    public java.lang.Double getONERI_AMM_RISERVE() {
        return ONERI_AMM_RISERVE;
    }


    /**
     * Sets the ONERI_AMM_RISERVE value for this DatiCollaudo.
     * 
     * @param ONERI_AMM_RISERVE
     */
    public void setONERI_AMM_RISERVE(java.lang.Double ONERI_AMM_RISERVE) {
        this.ONERI_AMM_RISERVE = ONERI_AMM_RISERVE;
    }


    /**
     * Gets the DATA_INIZIO_ARB_RISERVE value for this DatiCollaudo.
     * 
     * @return DATA_INIZIO_ARB_RISERVE
     */
    public java.util.Calendar getDATA_INIZIO_ARB_RISERVE() {
        return DATA_INIZIO_ARB_RISERVE;
    }


    /**
     * Sets the DATA_INIZIO_ARB_RISERVE value for this DatiCollaudo.
     * 
     * @param DATA_INIZIO_ARB_RISERVE
     */
    public void setDATA_INIZIO_ARB_RISERVE(java.util.Calendar DATA_INIZIO_ARB_RISERVE) {
        this.DATA_INIZIO_ARB_RISERVE = DATA_INIZIO_ARB_RISERVE;
    }


    /**
     * Gets the DATA_FINE_ARB_RISERVE value for this DatiCollaudo.
     * 
     * @return DATA_FINE_ARB_RISERVE
     */
    public java.util.Calendar getDATA_FINE_ARB_RISERVE() {
        return DATA_FINE_ARB_RISERVE;
    }


    /**
     * Sets the DATA_FINE_ARB_RISERVE value for this DatiCollaudo.
     * 
     * @param DATA_FINE_ARB_RISERVE
     */
    public void setDATA_FINE_ARB_RISERVE(java.util.Calendar DATA_FINE_ARB_RISERVE) {
        this.DATA_FINE_ARB_RISERVE = DATA_FINE_ARB_RISERVE;
    }


    /**
     * Gets the ONERI_ARB_RISERVE value for this DatiCollaudo.
     * 
     * @return ONERI_ARB_RISERVE
     */
    public java.lang.Double getONERI_ARB_RISERVE() {
        return ONERI_ARB_RISERVE;
    }


    /**
     * Sets the ONERI_ARB_RISERVE value for this DatiCollaudo.
     * 
     * @param ONERI_ARB_RISERVE
     */
    public void setONERI_ARB_RISERVE(java.lang.Double ONERI_ARB_RISERVE) {
        this.ONERI_ARB_RISERVE = ONERI_ARB_RISERVE;
    }


    /**
     * Gets the DATA_INIZIO_GIU_RISERVE value for this DatiCollaudo.
     * 
     * @return DATA_INIZIO_GIU_RISERVE
     */
    public java.util.Calendar getDATA_INIZIO_GIU_RISERVE() {
        return DATA_INIZIO_GIU_RISERVE;
    }


    /**
     * Sets the DATA_INIZIO_GIU_RISERVE value for this DatiCollaudo.
     * 
     * @param DATA_INIZIO_GIU_RISERVE
     */
    public void setDATA_INIZIO_GIU_RISERVE(java.util.Calendar DATA_INIZIO_GIU_RISERVE) {
        this.DATA_INIZIO_GIU_RISERVE = DATA_INIZIO_GIU_RISERVE;
    }


    /**
     * Gets the DATA_FINE_GIU_RISERVE value for this DatiCollaudo.
     * 
     * @return DATA_FINE_GIU_RISERVE
     */
    public java.util.Calendar getDATA_FINE_GIU_RISERVE() {
        return DATA_FINE_GIU_RISERVE;
    }


    /**
     * Sets the DATA_FINE_GIU_RISERVE value for this DatiCollaudo.
     * 
     * @param DATA_FINE_GIU_RISERVE
     */
    public void setDATA_FINE_GIU_RISERVE(java.util.Calendar DATA_FINE_GIU_RISERVE) {
        this.DATA_FINE_GIU_RISERVE = DATA_FINE_GIU_RISERVE;
    }


    /**
     * Gets the ONERI_GIU_RISERVE value for this DatiCollaudo.
     * 
     * @return ONERI_GIU_RISERVE
     */
    public java.lang.Double getONERI_GIU_RISERVE() {
        return ONERI_GIU_RISERVE;
    }


    /**
     * Sets the ONERI_GIU_RISERVE value for this DatiCollaudo.
     * 
     * @param ONERI_GIU_RISERVE
     */
    public void setONERI_GIU_RISERVE(java.lang.Double ONERI_GIU_RISERVE) {
        this.ONERI_GIU_RISERVE = ONERI_GIU_RISERVE;
    }


    /**
     * Gets the DATA_INIZIO_TRA_RISERVE value for this DatiCollaudo.
     * 
     * @return DATA_INIZIO_TRA_RISERVE
     */
    public java.util.Calendar getDATA_INIZIO_TRA_RISERVE() {
        return DATA_INIZIO_TRA_RISERVE;
    }


    /**
     * Sets the DATA_INIZIO_TRA_RISERVE value for this DatiCollaudo.
     * 
     * @param DATA_INIZIO_TRA_RISERVE
     */
    public void setDATA_INIZIO_TRA_RISERVE(java.util.Calendar DATA_INIZIO_TRA_RISERVE) {
        this.DATA_INIZIO_TRA_RISERVE = DATA_INIZIO_TRA_RISERVE;
    }


    /**
     * Gets the DATA_FINE_TRA_RISERVE value for this DatiCollaudo.
     * 
     * @return DATA_FINE_TRA_RISERVE
     */
    public java.util.Calendar getDATA_FINE_TRA_RISERVE() {
        return DATA_FINE_TRA_RISERVE;
    }


    /**
     * Sets the DATA_FINE_TRA_RISERVE value for this DatiCollaudo.
     * 
     * @param DATA_FINE_TRA_RISERVE
     */
    public void setDATA_FINE_TRA_RISERVE(java.util.Calendar DATA_FINE_TRA_RISERVE) {
        this.DATA_FINE_TRA_RISERVE = DATA_FINE_TRA_RISERVE;
    }


    /**
     * Gets the ONERI_TRA_RISERVE value for this DatiCollaudo.
     * 
     * @return ONERI_TRA_RISERVE
     */
    public java.lang.Double getONERI_TRA_RISERVE() {
        return ONERI_TRA_RISERVE;
    }


    /**
     * Sets the ONERI_TRA_RISERVE value for this DatiCollaudo.
     * 
     * @param ONERI_TRA_RISERVE
     */
    public void setONERI_TRA_RISERVE(java.lang.Double ONERI_TRA_RISERVE) {
        this.ONERI_TRA_RISERVE = ONERI_TRA_RISERVE;
    }


    /**
     * Gets the FLAG_SUBAPPALTATORI value for this DatiCollaudo.
     * 
     * @return FLAG_SUBAPPALTATORI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_SUBAPPALTATORI() {
        return FLAG_SUBAPPALTATORI;
    }


    /**
     * Sets the FLAG_SUBAPPALTATORI value for this DatiCollaudo.
     * 
     * @param FLAG_SUBAPPALTATORI
     */
    public void setFLAG_SUBAPPALTATORI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_SUBAPPALTATORI) {
        this.FLAG_SUBAPPALTATORI = FLAG_SUBAPPALTATORI;
    }


    /**
     * Gets the DATA_REGOLARE_ESEC value for this DatiCollaudo.
     * 
     * @return DATA_REGOLARE_ESEC
     */
    public java.util.Calendar getDATA_REGOLARE_ESEC() {
        return DATA_REGOLARE_ESEC;
    }


    /**
     * Sets the DATA_REGOLARE_ESEC value for this DatiCollaudo.
     * 
     * @param DATA_REGOLARE_ESEC
     */
    public void setDATA_REGOLARE_ESEC(java.util.Calendar DATA_REGOLARE_ESEC) {
        this.DATA_REGOLARE_ESEC = DATA_REGOLARE_ESEC;
    }


    /**
     * Gets the DATA_COLLAUDO_STAT value for this DatiCollaudo.
     * 
     * @return DATA_COLLAUDO_STAT
     */
    public java.util.Calendar getDATA_COLLAUDO_STAT() {
        return DATA_COLLAUDO_STAT;
    }


    /**
     * Sets the DATA_COLLAUDO_STAT value for this DatiCollaudo.
     * 
     * @param DATA_COLLAUDO_STAT
     */
    public void setDATA_COLLAUDO_STAT(java.util.Calendar DATA_COLLAUDO_STAT) {
        this.DATA_COLLAUDO_STAT = DATA_COLLAUDO_STAT;
    }


    /**
     * Gets the MODO_COLLAUDO value for this DatiCollaudo.
     * 
     * @return MODO_COLLAUDO
     */
    public java.lang.String getMODO_COLLAUDO() {
        return MODO_COLLAUDO;
    }


    /**
     * Sets the MODO_COLLAUDO value for this DatiCollaudo.
     * 
     * @param MODO_COLLAUDO
     */
    public void setMODO_COLLAUDO(java.lang.String MODO_COLLAUDO) {
        this.MODO_COLLAUDO = MODO_COLLAUDO;
    }


    /**
     * Gets the DATA_NOMINA_COLL value for this DatiCollaudo.
     * 
     * @return DATA_NOMINA_COLL
     */
    public java.util.Calendar getDATA_NOMINA_COLL() {
        return DATA_NOMINA_COLL;
    }


    /**
     * Sets the DATA_NOMINA_COLL value for this DatiCollaudo.
     * 
     * @param DATA_NOMINA_COLL
     */
    public void setDATA_NOMINA_COLL(java.util.Calendar DATA_NOMINA_COLL) {
        this.DATA_NOMINA_COLL = DATA_NOMINA_COLL;
    }


    /**
     * Gets the DATA_INIZIO_OPER value for this DatiCollaudo.
     * 
     * @return DATA_INIZIO_OPER
     */
    public java.util.Calendar getDATA_INIZIO_OPER() {
        return DATA_INIZIO_OPER;
    }


    /**
     * Sets the DATA_INIZIO_OPER value for this DatiCollaudo.
     * 
     * @param DATA_INIZIO_OPER
     */
    public void setDATA_INIZIO_OPER(java.util.Calendar DATA_INIZIO_OPER) {
        this.DATA_INIZIO_OPER = DATA_INIZIO_OPER;
    }


    /**
     * Gets the DATA_CERT_COLLAUDO value for this DatiCollaudo.
     * 
     * @return DATA_CERT_COLLAUDO
     */
    public java.util.Calendar getDATA_CERT_COLLAUDO() {
        return DATA_CERT_COLLAUDO;
    }


    /**
     * Sets the DATA_CERT_COLLAUDO value for this DatiCollaudo.
     * 
     * @param DATA_CERT_COLLAUDO
     */
    public void setDATA_CERT_COLLAUDO(java.util.Calendar DATA_CERT_COLLAUDO) {
        this.DATA_CERT_COLLAUDO = DATA_CERT_COLLAUDO;
    }


    /**
     * Gets the DATA_DELIBERA value for this DatiCollaudo.
     * 
     * @return DATA_DELIBERA
     */
    public java.util.Calendar getDATA_DELIBERA() {
        return DATA_DELIBERA;
    }


    /**
     * Sets the DATA_DELIBERA value for this DatiCollaudo.
     * 
     * @param DATA_DELIBERA
     */
    public void setDATA_DELIBERA(java.util.Calendar DATA_DELIBERA) {
        this.DATA_DELIBERA = DATA_DELIBERA;
    }


    /**
     * Gets the ESITO_COLLAUDO value for this DatiCollaudo.
     * 
     * @return ESITO_COLLAUDO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagEsitoCollaudoType getESITO_COLLAUDO() {
        return ESITO_COLLAUDO;
    }


    /**
     * Sets the ESITO_COLLAUDO value for this DatiCollaudo.
     * 
     * @param ESITO_COLLAUDO
     */
    public void setESITO_COLLAUDO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagEsitoCollaudoType ESITO_COLLAUDO) {
        this.ESITO_COLLAUDO = ESITO_COLLAUDO;
    }


    /**
     * Gets the IMP_FINALE_LAVORI value for this DatiCollaudo.
     * 
     * @return IMP_FINALE_LAVORI
     */
    public java.lang.Double getIMP_FINALE_LAVORI() {
        return IMP_FINALE_LAVORI;
    }


    /**
     * Sets the IMP_FINALE_LAVORI value for this DatiCollaudo.
     * 
     * @param IMP_FINALE_LAVORI
     */
    public void setIMP_FINALE_LAVORI(java.lang.Double IMP_FINALE_LAVORI) {
        this.IMP_FINALE_LAVORI = IMP_FINALE_LAVORI;
    }


    /**
     * Gets the IMP_FINALE_SERVIZI value for this DatiCollaudo.
     * 
     * @return IMP_FINALE_SERVIZI
     */
    public java.lang.Double getIMP_FINALE_SERVIZI() {
        return IMP_FINALE_SERVIZI;
    }


    /**
     * Sets the IMP_FINALE_SERVIZI value for this DatiCollaudo.
     * 
     * @param IMP_FINALE_SERVIZI
     */
    public void setIMP_FINALE_SERVIZI(java.lang.Double IMP_FINALE_SERVIZI) {
        this.IMP_FINALE_SERVIZI = IMP_FINALE_SERVIZI;
    }


    /**
     * Gets the IMP_FINALE_FORNIT value for this DatiCollaudo.
     * 
     * @return IMP_FINALE_FORNIT
     */
    public java.lang.Double getIMP_FINALE_FORNIT() {
        return IMP_FINALE_FORNIT;
    }


    /**
     * Sets the IMP_FINALE_FORNIT value for this DatiCollaudo.
     * 
     * @param IMP_FINALE_FORNIT
     */
    public void setIMP_FINALE_FORNIT(java.lang.Double IMP_FINALE_FORNIT) {
        this.IMP_FINALE_FORNIT = IMP_FINALE_FORNIT;
    }


    /**
     * Gets the IMP_FINALE_SECUR value for this DatiCollaudo.
     * 
     * @return IMP_FINALE_SECUR
     */
    public java.lang.Double getIMP_FINALE_SECUR() {
        return IMP_FINALE_SECUR;
    }


    /**
     * Sets the IMP_FINALE_SECUR value for this DatiCollaudo.
     * 
     * @param IMP_FINALE_SECUR
     */
    public void setIMP_FINALE_SECUR(java.lang.Double IMP_FINALE_SECUR) {
        this.IMP_FINALE_SECUR = IMP_FINALE_SECUR;
    }


    /**
     * Gets the IMP_PROGETTAZIONE value for this DatiCollaudo.
     * 
     * @return IMP_PROGETTAZIONE
     */
    public java.lang.Double getIMP_PROGETTAZIONE() {
        return IMP_PROGETTAZIONE;
    }


    /**
     * Sets the IMP_PROGETTAZIONE value for this DatiCollaudo.
     * 
     * @param IMP_PROGETTAZIONE
     */
    public void setIMP_PROGETTAZIONE(java.lang.Double IMP_PROGETTAZIONE) {
        this.IMP_PROGETTAZIONE = IMP_PROGETTAZIONE;
    }


    /**
     * Gets the IMP_DISPOSIZIONE value for this DatiCollaudo.
     * 
     * @return IMP_DISPOSIZIONE
     */
    public double getIMP_DISPOSIZIONE() {
        return IMP_DISPOSIZIONE;
    }


    /**
     * Sets the IMP_DISPOSIZIONE value for this DatiCollaudo.
     * 
     * @param IMP_DISPOSIZIONE
     */
    public void setIMP_DISPOSIZIONE(double IMP_DISPOSIZIONE) {
        this.IMP_DISPOSIZIONE = IMP_DISPOSIZIONE;
    }


    /**
     * Gets the AMM_NUM_DEFINITE value for this DatiCollaudo.
     * 
     * @return AMM_NUM_DEFINITE
     */
    public java.lang.Long getAMM_NUM_DEFINITE() {
        return AMM_NUM_DEFINITE;
    }


    /**
     * Sets the AMM_NUM_DEFINITE value for this DatiCollaudo.
     * 
     * @param AMM_NUM_DEFINITE
     */
    public void setAMM_NUM_DEFINITE(java.lang.Long AMM_NUM_DEFINITE) {
        this.AMM_NUM_DEFINITE = AMM_NUM_DEFINITE;
    }


    /**
     * Gets the AMM_NUM_DADEF value for this DatiCollaudo.
     * 
     * @return AMM_NUM_DADEF
     */
    public java.lang.Long getAMM_NUM_DADEF() {
        return AMM_NUM_DADEF;
    }


    /**
     * Sets the AMM_NUM_DADEF value for this DatiCollaudo.
     * 
     * @param AMM_NUM_DADEF
     */
    public void setAMM_NUM_DADEF(java.lang.Long AMM_NUM_DADEF) {
        this.AMM_NUM_DADEF = AMM_NUM_DADEF;
    }


    /**
     * Gets the AMM_IMPORTO_RICH value for this DatiCollaudo.
     * 
     * @return AMM_IMPORTO_RICH
     */
    public java.lang.Double getAMM_IMPORTO_RICH() {
        return AMM_IMPORTO_RICH;
    }


    /**
     * Sets the AMM_IMPORTO_RICH value for this DatiCollaudo.
     * 
     * @param AMM_IMPORTO_RICH
     */
    public void setAMM_IMPORTO_RICH(java.lang.Double AMM_IMPORTO_RICH) {
        this.AMM_IMPORTO_RICH = AMM_IMPORTO_RICH;
    }


    /**
     * Gets the AMM_IMPORTO_DEF value for this DatiCollaudo.
     * 
     * @return AMM_IMPORTO_DEF
     */
    public java.lang.Double getAMM_IMPORTO_DEF() {
        return AMM_IMPORTO_DEF;
    }


    /**
     * Sets the AMM_IMPORTO_DEF value for this DatiCollaudo.
     * 
     * @param AMM_IMPORTO_DEF
     */
    public void setAMM_IMPORTO_DEF(java.lang.Double AMM_IMPORTO_DEF) {
        this.AMM_IMPORTO_DEF = AMM_IMPORTO_DEF;
    }


    /**
     * Gets the ARB_NUM_DEFINITE value for this DatiCollaudo.
     * 
     * @return ARB_NUM_DEFINITE
     */
    public java.lang.Long getARB_NUM_DEFINITE() {
        return ARB_NUM_DEFINITE;
    }


    /**
     * Sets the ARB_NUM_DEFINITE value for this DatiCollaudo.
     * 
     * @param ARB_NUM_DEFINITE
     */
    public void setARB_NUM_DEFINITE(java.lang.Long ARB_NUM_DEFINITE) {
        this.ARB_NUM_DEFINITE = ARB_NUM_DEFINITE;
    }


    /**
     * Gets the ARB_NUM_DADEF value for this DatiCollaudo.
     * 
     * @return ARB_NUM_DADEF
     */
    public java.lang.Long getARB_NUM_DADEF() {
        return ARB_NUM_DADEF;
    }


    /**
     * Sets the ARB_NUM_DADEF value for this DatiCollaudo.
     * 
     * @param ARB_NUM_DADEF
     */
    public void setARB_NUM_DADEF(java.lang.Long ARB_NUM_DADEF) {
        this.ARB_NUM_DADEF = ARB_NUM_DADEF;
    }


    /**
     * Gets the ARB_IMPORTO_RICH value for this DatiCollaudo.
     * 
     * @return ARB_IMPORTO_RICH
     */
    public java.lang.Double getARB_IMPORTO_RICH() {
        return ARB_IMPORTO_RICH;
    }


    /**
     * Sets the ARB_IMPORTO_RICH value for this DatiCollaudo.
     * 
     * @param ARB_IMPORTO_RICH
     */
    public void setARB_IMPORTO_RICH(java.lang.Double ARB_IMPORTO_RICH) {
        this.ARB_IMPORTO_RICH = ARB_IMPORTO_RICH;
    }


    /**
     * Gets the ARB_IMPORTO_DEF value for this DatiCollaudo.
     * 
     * @return ARB_IMPORTO_DEF
     */
    public java.lang.Double getARB_IMPORTO_DEF() {
        return ARB_IMPORTO_DEF;
    }


    /**
     * Sets the ARB_IMPORTO_DEF value for this DatiCollaudo.
     * 
     * @param ARB_IMPORTO_DEF
     */
    public void setARB_IMPORTO_DEF(java.lang.Double ARB_IMPORTO_DEF) {
        this.ARB_IMPORTO_DEF = ARB_IMPORTO_DEF;
    }


    /**
     * Gets the GIU_NUM_DEFINITE value for this DatiCollaudo.
     * 
     * @return GIU_NUM_DEFINITE
     */
    public java.lang.Long getGIU_NUM_DEFINITE() {
        return GIU_NUM_DEFINITE;
    }


    /**
     * Sets the GIU_NUM_DEFINITE value for this DatiCollaudo.
     * 
     * @param GIU_NUM_DEFINITE
     */
    public void setGIU_NUM_DEFINITE(java.lang.Long GIU_NUM_DEFINITE) {
        this.GIU_NUM_DEFINITE = GIU_NUM_DEFINITE;
    }


    /**
     * Gets the GIU_NUM_DADEF value for this DatiCollaudo.
     * 
     * @return GIU_NUM_DADEF
     */
    public java.lang.Long getGIU_NUM_DADEF() {
        return GIU_NUM_DADEF;
    }


    /**
     * Sets the GIU_NUM_DADEF value for this DatiCollaudo.
     * 
     * @param GIU_NUM_DADEF
     */
    public void setGIU_NUM_DADEF(java.lang.Long GIU_NUM_DADEF) {
        this.GIU_NUM_DADEF = GIU_NUM_DADEF;
    }


    /**
     * Gets the GIU_IMPORTO_RICH value for this DatiCollaudo.
     * 
     * @return GIU_IMPORTO_RICH
     */
    public java.lang.Double getGIU_IMPORTO_RICH() {
        return GIU_IMPORTO_RICH;
    }


    /**
     * Sets the GIU_IMPORTO_RICH value for this DatiCollaudo.
     * 
     * @param GIU_IMPORTO_RICH
     */
    public void setGIU_IMPORTO_RICH(java.lang.Double GIU_IMPORTO_RICH) {
        this.GIU_IMPORTO_RICH = GIU_IMPORTO_RICH;
    }


    /**
     * Gets the GIU_IMPORTO_DEF value for this DatiCollaudo.
     * 
     * @return GIU_IMPORTO_DEF
     */
    public java.lang.Double getGIU_IMPORTO_DEF() {
        return GIU_IMPORTO_DEF;
    }


    /**
     * Sets the GIU_IMPORTO_DEF value for this DatiCollaudo.
     * 
     * @param GIU_IMPORTO_DEF
     */
    public void setGIU_IMPORTO_DEF(java.lang.Double GIU_IMPORTO_DEF) {
        this.GIU_IMPORTO_DEF = GIU_IMPORTO_DEF;
    }


    /**
     * Gets the TRA_NUM_DEFINITE value for this DatiCollaudo.
     * 
     * @return TRA_NUM_DEFINITE
     */
    public java.lang.Long getTRA_NUM_DEFINITE() {
        return TRA_NUM_DEFINITE;
    }


    /**
     * Sets the TRA_NUM_DEFINITE value for this DatiCollaudo.
     * 
     * @param TRA_NUM_DEFINITE
     */
    public void setTRA_NUM_DEFINITE(java.lang.Long TRA_NUM_DEFINITE) {
        this.TRA_NUM_DEFINITE = TRA_NUM_DEFINITE;
    }


    /**
     * Gets the TRA_NUM_DADEF value for this DatiCollaudo.
     * 
     * @return TRA_NUM_DADEF
     */
    public java.lang.Long getTRA_NUM_DADEF() {
        return TRA_NUM_DADEF;
    }


    /**
     * Sets the TRA_NUM_DADEF value for this DatiCollaudo.
     * 
     * @param TRA_NUM_DADEF
     */
    public void setTRA_NUM_DADEF(java.lang.Long TRA_NUM_DADEF) {
        this.TRA_NUM_DADEF = TRA_NUM_DADEF;
    }


    /**
     * Gets the TRA_IMPORTO_RICH value for this DatiCollaudo.
     * 
     * @return TRA_IMPORTO_RICH
     */
    public java.lang.Double getTRA_IMPORTO_RICH() {
        return TRA_IMPORTO_RICH;
    }


    /**
     * Sets the TRA_IMPORTO_RICH value for this DatiCollaudo.
     * 
     * @param TRA_IMPORTO_RICH
     */
    public void setTRA_IMPORTO_RICH(java.lang.Double TRA_IMPORTO_RICH) {
        this.TRA_IMPORTO_RICH = TRA_IMPORTO_RICH;
    }


    /**
     * Gets the TRA_IMPORTO_DEF value for this DatiCollaudo.
     * 
     * @return TRA_IMPORTO_DEF
     */
    public java.lang.Double getTRA_IMPORTO_DEF() {
        return TRA_IMPORTO_DEF;
    }


    /**
     * Sets the TRA_IMPORTO_DEF value for this DatiCollaudo.
     * 
     * @param TRA_IMPORTO_DEF
     */
    public void setTRA_IMPORTO_DEF(java.lang.Double TRA_IMPORTO_DEF) {
        this.TRA_IMPORTO_DEF = TRA_IMPORTO_DEF;
    }


    /**
     * Gets the IMPORTO_SUBTOTALE value for this DatiCollaudo.
     * 
     * @return IMPORTO_SUBTOTALE
     */
    public double getIMPORTO_SUBTOTALE() {
        return IMPORTO_SUBTOTALE;
    }


    /**
     * Sets the IMPORTO_SUBTOTALE value for this DatiCollaudo.
     * 
     * @param IMPORTO_SUBTOTALE
     */
    public void setIMPORTO_SUBTOTALE(double IMPORTO_SUBTOTALE) {
        this.IMPORTO_SUBTOTALE = IMPORTO_SUBTOTALE;
    }


    /**
     * Gets the IMPORTO_FINALE value for this DatiCollaudo.
     * 
     * @return IMPORTO_FINALE
     */
    public double getIMPORTO_FINALE() {
        return IMPORTO_FINALE;
    }


    /**
     * Sets the IMPORTO_FINALE value for this DatiCollaudo.
     * 
     * @param IMPORTO_FINALE
     */
    public void setIMPORTO_FINALE(double IMPORTO_FINALE) {
        this.IMPORTO_FINALE = IMPORTO_FINALE;
    }


    /**
     * Gets the IMPORTO_CONSUNTIVO value for this DatiCollaudo.
     * 
     * @return IMPORTO_CONSUNTIVO
     */
    public double getIMPORTO_CONSUNTIVO() {
        return IMPORTO_CONSUNTIVO;
    }


    /**
     * Sets the IMPORTO_CONSUNTIVO value for this DatiCollaudo.
     * 
     * @param IMPORTO_CONSUNTIVO
     */
    public void setIMPORTO_CONSUNTIVO(double IMPORTO_CONSUNTIVO) {
        this.IMPORTO_CONSUNTIVO = IMPORTO_CONSUNTIVO;
    }


    /**
     * Gets the FLAG_LAVORI_ESTESI value for this DatiCollaudo.
     * 
     * @return FLAG_LAVORI_ESTESI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_LAVORI_ESTESI() {
        return FLAG_LAVORI_ESTESI;
    }


    /**
     * Sets the FLAG_LAVORI_ESTESI value for this DatiCollaudo.
     * 
     * @param FLAG_LAVORI_ESTESI
     */
    public void setFLAG_LAVORI_ESTESI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_LAVORI_ESTESI) {
        this.FLAG_LAVORI_ESTESI = FLAG_LAVORI_ESTESI;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatiCollaudo)) return false;
        DatiCollaudo other = (DatiCollaudo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.FLAG_SINGOLO_COMMISSIONE==null && other.getFLAG_SINGOLO_COMMISSIONE()==null) || 
             (this.FLAG_SINGOLO_COMMISSIONE!=null &&
              this.FLAG_SINGOLO_COMMISSIONE.equals(other.getFLAG_SINGOLO_COMMISSIONE()))) &&
            ((this.DATA_APPROVAZIONE==null && other.getDATA_APPROVAZIONE()==null) || 
             (this.DATA_APPROVAZIONE!=null &&
              this.DATA_APPROVAZIONE.equals(other.getDATA_APPROVAZIONE()))) &&
            ((this.FLAG_IMPORTI==null && other.getFLAG_IMPORTI()==null) || 
             (this.FLAG_IMPORTI!=null &&
              this.FLAG_IMPORTI.equals(other.getFLAG_IMPORTI()))) &&
            ((this.FLAG_SICUREZZA==null && other.getFLAG_SICUREZZA()==null) || 
             (this.FLAG_SICUREZZA!=null &&
              this.FLAG_SICUREZZA.equals(other.getFLAG_SICUREZZA()))) &&
            ((this.DATA_INIZIO_AMM_RISERVE==null && other.getDATA_INIZIO_AMM_RISERVE()==null) || 
             (this.DATA_INIZIO_AMM_RISERVE!=null &&
              this.DATA_INIZIO_AMM_RISERVE.equals(other.getDATA_INIZIO_AMM_RISERVE()))) &&
            ((this.DATA_FINE_AMM_RISERVE==null && other.getDATA_FINE_AMM_RISERVE()==null) || 
             (this.DATA_FINE_AMM_RISERVE!=null &&
              this.DATA_FINE_AMM_RISERVE.equals(other.getDATA_FINE_AMM_RISERVE()))) &&
            ((this.ONERI_AMM_RISERVE==null && other.getONERI_AMM_RISERVE()==null) || 
             (this.ONERI_AMM_RISERVE!=null &&
              this.ONERI_AMM_RISERVE.equals(other.getONERI_AMM_RISERVE()))) &&
            ((this.DATA_INIZIO_ARB_RISERVE==null && other.getDATA_INIZIO_ARB_RISERVE()==null) || 
             (this.DATA_INIZIO_ARB_RISERVE!=null &&
              this.DATA_INIZIO_ARB_RISERVE.equals(other.getDATA_INIZIO_ARB_RISERVE()))) &&
            ((this.DATA_FINE_ARB_RISERVE==null && other.getDATA_FINE_ARB_RISERVE()==null) || 
             (this.DATA_FINE_ARB_RISERVE!=null &&
              this.DATA_FINE_ARB_RISERVE.equals(other.getDATA_FINE_ARB_RISERVE()))) &&
            ((this.ONERI_ARB_RISERVE==null && other.getONERI_ARB_RISERVE()==null) || 
             (this.ONERI_ARB_RISERVE!=null &&
              this.ONERI_ARB_RISERVE.equals(other.getONERI_ARB_RISERVE()))) &&
            ((this.DATA_INIZIO_GIU_RISERVE==null && other.getDATA_INIZIO_GIU_RISERVE()==null) || 
             (this.DATA_INIZIO_GIU_RISERVE!=null &&
              this.DATA_INIZIO_GIU_RISERVE.equals(other.getDATA_INIZIO_GIU_RISERVE()))) &&
            ((this.DATA_FINE_GIU_RISERVE==null && other.getDATA_FINE_GIU_RISERVE()==null) || 
             (this.DATA_FINE_GIU_RISERVE!=null &&
              this.DATA_FINE_GIU_RISERVE.equals(other.getDATA_FINE_GIU_RISERVE()))) &&
            ((this.ONERI_GIU_RISERVE==null && other.getONERI_GIU_RISERVE()==null) || 
             (this.ONERI_GIU_RISERVE!=null &&
              this.ONERI_GIU_RISERVE.equals(other.getONERI_GIU_RISERVE()))) &&
            ((this.DATA_INIZIO_TRA_RISERVE==null && other.getDATA_INIZIO_TRA_RISERVE()==null) || 
             (this.DATA_INIZIO_TRA_RISERVE!=null &&
              this.DATA_INIZIO_TRA_RISERVE.equals(other.getDATA_INIZIO_TRA_RISERVE()))) &&
            ((this.DATA_FINE_TRA_RISERVE==null && other.getDATA_FINE_TRA_RISERVE()==null) || 
             (this.DATA_FINE_TRA_RISERVE!=null &&
              this.DATA_FINE_TRA_RISERVE.equals(other.getDATA_FINE_TRA_RISERVE()))) &&
            ((this.ONERI_TRA_RISERVE==null && other.getONERI_TRA_RISERVE()==null) || 
             (this.ONERI_TRA_RISERVE!=null &&
              this.ONERI_TRA_RISERVE.equals(other.getONERI_TRA_RISERVE()))) &&
            ((this.FLAG_SUBAPPALTATORI==null && other.getFLAG_SUBAPPALTATORI()==null) || 
             (this.FLAG_SUBAPPALTATORI!=null &&
              this.FLAG_SUBAPPALTATORI.equals(other.getFLAG_SUBAPPALTATORI()))) &&
            ((this.DATA_REGOLARE_ESEC==null && other.getDATA_REGOLARE_ESEC()==null) || 
             (this.DATA_REGOLARE_ESEC!=null &&
              this.DATA_REGOLARE_ESEC.equals(other.getDATA_REGOLARE_ESEC()))) &&
            ((this.DATA_COLLAUDO_STAT==null && other.getDATA_COLLAUDO_STAT()==null) || 
             (this.DATA_COLLAUDO_STAT!=null &&
              this.DATA_COLLAUDO_STAT.equals(other.getDATA_COLLAUDO_STAT()))) &&
            ((this.MODO_COLLAUDO==null && other.getMODO_COLLAUDO()==null) || 
             (this.MODO_COLLAUDO!=null &&
              this.MODO_COLLAUDO.equals(other.getMODO_COLLAUDO()))) &&
            ((this.DATA_NOMINA_COLL==null && other.getDATA_NOMINA_COLL()==null) || 
             (this.DATA_NOMINA_COLL!=null &&
              this.DATA_NOMINA_COLL.equals(other.getDATA_NOMINA_COLL()))) &&
            ((this.DATA_INIZIO_OPER==null && other.getDATA_INIZIO_OPER()==null) || 
             (this.DATA_INIZIO_OPER!=null &&
              this.DATA_INIZIO_OPER.equals(other.getDATA_INIZIO_OPER()))) &&
            ((this.DATA_CERT_COLLAUDO==null && other.getDATA_CERT_COLLAUDO()==null) || 
             (this.DATA_CERT_COLLAUDO!=null &&
              this.DATA_CERT_COLLAUDO.equals(other.getDATA_CERT_COLLAUDO()))) &&
            ((this.DATA_DELIBERA==null && other.getDATA_DELIBERA()==null) || 
             (this.DATA_DELIBERA!=null &&
              this.DATA_DELIBERA.equals(other.getDATA_DELIBERA()))) &&
            ((this.ESITO_COLLAUDO==null && other.getESITO_COLLAUDO()==null) || 
             (this.ESITO_COLLAUDO!=null &&
              this.ESITO_COLLAUDO.equals(other.getESITO_COLLAUDO()))) &&
            ((this.IMP_FINALE_LAVORI==null && other.getIMP_FINALE_LAVORI()==null) || 
             (this.IMP_FINALE_LAVORI!=null &&
              this.IMP_FINALE_LAVORI.equals(other.getIMP_FINALE_LAVORI()))) &&
            ((this.IMP_FINALE_SERVIZI==null && other.getIMP_FINALE_SERVIZI()==null) || 
             (this.IMP_FINALE_SERVIZI!=null &&
              this.IMP_FINALE_SERVIZI.equals(other.getIMP_FINALE_SERVIZI()))) &&
            ((this.IMP_FINALE_FORNIT==null && other.getIMP_FINALE_FORNIT()==null) || 
             (this.IMP_FINALE_FORNIT!=null &&
              this.IMP_FINALE_FORNIT.equals(other.getIMP_FINALE_FORNIT()))) &&
            ((this.IMP_FINALE_SECUR==null && other.getIMP_FINALE_SECUR()==null) || 
             (this.IMP_FINALE_SECUR!=null &&
              this.IMP_FINALE_SECUR.equals(other.getIMP_FINALE_SECUR()))) &&
            ((this.IMP_PROGETTAZIONE==null && other.getIMP_PROGETTAZIONE()==null) || 
             (this.IMP_PROGETTAZIONE!=null &&
              this.IMP_PROGETTAZIONE.equals(other.getIMP_PROGETTAZIONE()))) &&
            this.IMP_DISPOSIZIONE == other.getIMP_DISPOSIZIONE() &&
            ((this.AMM_NUM_DEFINITE==null && other.getAMM_NUM_DEFINITE()==null) || 
             (this.AMM_NUM_DEFINITE!=null &&
              this.AMM_NUM_DEFINITE.equals(other.getAMM_NUM_DEFINITE()))) &&
            ((this.AMM_NUM_DADEF==null && other.getAMM_NUM_DADEF()==null) || 
             (this.AMM_NUM_DADEF!=null &&
              this.AMM_NUM_DADEF.equals(other.getAMM_NUM_DADEF()))) &&
            ((this.AMM_IMPORTO_RICH==null && other.getAMM_IMPORTO_RICH()==null) || 
             (this.AMM_IMPORTO_RICH!=null &&
              this.AMM_IMPORTO_RICH.equals(other.getAMM_IMPORTO_RICH()))) &&
            ((this.AMM_IMPORTO_DEF==null && other.getAMM_IMPORTO_DEF()==null) || 
             (this.AMM_IMPORTO_DEF!=null &&
              this.AMM_IMPORTO_DEF.equals(other.getAMM_IMPORTO_DEF()))) &&
            ((this.ARB_NUM_DEFINITE==null && other.getARB_NUM_DEFINITE()==null) || 
             (this.ARB_NUM_DEFINITE!=null &&
              this.ARB_NUM_DEFINITE.equals(other.getARB_NUM_DEFINITE()))) &&
            ((this.ARB_NUM_DADEF==null && other.getARB_NUM_DADEF()==null) || 
             (this.ARB_NUM_DADEF!=null &&
              this.ARB_NUM_DADEF.equals(other.getARB_NUM_DADEF()))) &&
            ((this.ARB_IMPORTO_RICH==null && other.getARB_IMPORTO_RICH()==null) || 
             (this.ARB_IMPORTO_RICH!=null &&
              this.ARB_IMPORTO_RICH.equals(other.getARB_IMPORTO_RICH()))) &&
            ((this.ARB_IMPORTO_DEF==null && other.getARB_IMPORTO_DEF()==null) || 
             (this.ARB_IMPORTO_DEF!=null &&
              this.ARB_IMPORTO_DEF.equals(other.getARB_IMPORTO_DEF()))) &&
            ((this.GIU_NUM_DEFINITE==null && other.getGIU_NUM_DEFINITE()==null) || 
             (this.GIU_NUM_DEFINITE!=null &&
              this.GIU_NUM_DEFINITE.equals(other.getGIU_NUM_DEFINITE()))) &&
            ((this.GIU_NUM_DADEF==null && other.getGIU_NUM_DADEF()==null) || 
             (this.GIU_NUM_DADEF!=null &&
              this.GIU_NUM_DADEF.equals(other.getGIU_NUM_DADEF()))) &&
            ((this.GIU_IMPORTO_RICH==null && other.getGIU_IMPORTO_RICH()==null) || 
             (this.GIU_IMPORTO_RICH!=null &&
              this.GIU_IMPORTO_RICH.equals(other.getGIU_IMPORTO_RICH()))) &&
            ((this.GIU_IMPORTO_DEF==null && other.getGIU_IMPORTO_DEF()==null) || 
             (this.GIU_IMPORTO_DEF!=null &&
              this.GIU_IMPORTO_DEF.equals(other.getGIU_IMPORTO_DEF()))) &&
            ((this.TRA_NUM_DEFINITE==null && other.getTRA_NUM_DEFINITE()==null) || 
             (this.TRA_NUM_DEFINITE!=null &&
              this.TRA_NUM_DEFINITE.equals(other.getTRA_NUM_DEFINITE()))) &&
            ((this.TRA_NUM_DADEF==null && other.getTRA_NUM_DADEF()==null) || 
             (this.TRA_NUM_DADEF!=null &&
              this.TRA_NUM_DADEF.equals(other.getTRA_NUM_DADEF()))) &&
            ((this.TRA_IMPORTO_RICH==null && other.getTRA_IMPORTO_RICH()==null) || 
             (this.TRA_IMPORTO_RICH!=null &&
              this.TRA_IMPORTO_RICH.equals(other.getTRA_IMPORTO_RICH()))) &&
            ((this.TRA_IMPORTO_DEF==null && other.getTRA_IMPORTO_DEF()==null) || 
             (this.TRA_IMPORTO_DEF!=null &&
              this.TRA_IMPORTO_DEF.equals(other.getTRA_IMPORTO_DEF()))) &&
            this.IMPORTO_SUBTOTALE == other.getIMPORTO_SUBTOTALE() &&
            this.IMPORTO_FINALE == other.getIMPORTO_FINALE() &&
            this.IMPORTO_CONSUNTIVO == other.getIMPORTO_CONSUNTIVO() &&
            ((this.FLAG_LAVORI_ESTESI==null && other.getFLAG_LAVORI_ESTESI()==null) || 
             (this.FLAG_LAVORI_ESTESI!=null &&
              this.FLAG_LAVORI_ESTESI.equals(other.getFLAG_LAVORI_ESTESI())));
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
        if (getFLAG_SINGOLO_COMMISSIONE() != null) {
            _hashCode += getFLAG_SINGOLO_COMMISSIONE().hashCode();
        }
        if (getDATA_APPROVAZIONE() != null) {
            _hashCode += getDATA_APPROVAZIONE().hashCode();
        }
        if (getFLAG_IMPORTI() != null) {
            _hashCode += getFLAG_IMPORTI().hashCode();
        }
        if (getFLAG_SICUREZZA() != null) {
            _hashCode += getFLAG_SICUREZZA().hashCode();
        }
        if (getDATA_INIZIO_AMM_RISERVE() != null) {
            _hashCode += getDATA_INIZIO_AMM_RISERVE().hashCode();
        }
        if (getDATA_FINE_AMM_RISERVE() != null) {
            _hashCode += getDATA_FINE_AMM_RISERVE().hashCode();
        }
        if (getONERI_AMM_RISERVE() != null) {
            _hashCode += getONERI_AMM_RISERVE().hashCode();
        }
        if (getDATA_INIZIO_ARB_RISERVE() != null) {
            _hashCode += getDATA_INIZIO_ARB_RISERVE().hashCode();
        }
        if (getDATA_FINE_ARB_RISERVE() != null) {
            _hashCode += getDATA_FINE_ARB_RISERVE().hashCode();
        }
        if (getONERI_ARB_RISERVE() != null) {
            _hashCode += getONERI_ARB_RISERVE().hashCode();
        }
        if (getDATA_INIZIO_GIU_RISERVE() != null) {
            _hashCode += getDATA_INIZIO_GIU_RISERVE().hashCode();
        }
        if (getDATA_FINE_GIU_RISERVE() != null) {
            _hashCode += getDATA_FINE_GIU_RISERVE().hashCode();
        }
        if (getONERI_GIU_RISERVE() != null) {
            _hashCode += getONERI_GIU_RISERVE().hashCode();
        }
        if (getDATA_INIZIO_TRA_RISERVE() != null) {
            _hashCode += getDATA_INIZIO_TRA_RISERVE().hashCode();
        }
        if (getDATA_FINE_TRA_RISERVE() != null) {
            _hashCode += getDATA_FINE_TRA_RISERVE().hashCode();
        }
        if (getONERI_TRA_RISERVE() != null) {
            _hashCode += getONERI_TRA_RISERVE().hashCode();
        }
        if (getFLAG_SUBAPPALTATORI() != null) {
            _hashCode += getFLAG_SUBAPPALTATORI().hashCode();
        }
        if (getDATA_REGOLARE_ESEC() != null) {
            _hashCode += getDATA_REGOLARE_ESEC().hashCode();
        }
        if (getDATA_COLLAUDO_STAT() != null) {
            _hashCode += getDATA_COLLAUDO_STAT().hashCode();
        }
        if (getMODO_COLLAUDO() != null) {
            _hashCode += getMODO_COLLAUDO().hashCode();
        }
        if (getDATA_NOMINA_COLL() != null) {
            _hashCode += getDATA_NOMINA_COLL().hashCode();
        }
        if (getDATA_INIZIO_OPER() != null) {
            _hashCode += getDATA_INIZIO_OPER().hashCode();
        }
        if (getDATA_CERT_COLLAUDO() != null) {
            _hashCode += getDATA_CERT_COLLAUDO().hashCode();
        }
        if (getDATA_DELIBERA() != null) {
            _hashCode += getDATA_DELIBERA().hashCode();
        }
        if (getESITO_COLLAUDO() != null) {
            _hashCode += getESITO_COLLAUDO().hashCode();
        }
        if (getIMP_FINALE_LAVORI() != null) {
            _hashCode += getIMP_FINALE_LAVORI().hashCode();
        }
        if (getIMP_FINALE_SERVIZI() != null) {
            _hashCode += getIMP_FINALE_SERVIZI().hashCode();
        }
        if (getIMP_FINALE_FORNIT() != null) {
            _hashCode += getIMP_FINALE_FORNIT().hashCode();
        }
        if (getIMP_FINALE_SECUR() != null) {
            _hashCode += getIMP_FINALE_SECUR().hashCode();
        }
        if (getIMP_PROGETTAZIONE() != null) {
            _hashCode += getIMP_PROGETTAZIONE().hashCode();
        }
        _hashCode += new Double(getIMP_DISPOSIZIONE()).hashCode();
        if (getAMM_NUM_DEFINITE() != null) {
            _hashCode += getAMM_NUM_DEFINITE().hashCode();
        }
        if (getAMM_NUM_DADEF() != null) {
            _hashCode += getAMM_NUM_DADEF().hashCode();
        }
        if (getAMM_IMPORTO_RICH() != null) {
            _hashCode += getAMM_IMPORTO_RICH().hashCode();
        }
        if (getAMM_IMPORTO_DEF() != null) {
            _hashCode += getAMM_IMPORTO_DEF().hashCode();
        }
        if (getARB_NUM_DEFINITE() != null) {
            _hashCode += getARB_NUM_DEFINITE().hashCode();
        }
        if (getARB_NUM_DADEF() != null) {
            _hashCode += getARB_NUM_DADEF().hashCode();
        }
        if (getARB_IMPORTO_RICH() != null) {
            _hashCode += getARB_IMPORTO_RICH().hashCode();
        }
        if (getARB_IMPORTO_DEF() != null) {
            _hashCode += getARB_IMPORTO_DEF().hashCode();
        }
        if (getGIU_NUM_DEFINITE() != null) {
            _hashCode += getGIU_NUM_DEFINITE().hashCode();
        }
        if (getGIU_NUM_DADEF() != null) {
            _hashCode += getGIU_NUM_DADEF().hashCode();
        }
        if (getGIU_IMPORTO_RICH() != null) {
            _hashCode += getGIU_IMPORTO_RICH().hashCode();
        }
        if (getGIU_IMPORTO_DEF() != null) {
            _hashCode += getGIU_IMPORTO_DEF().hashCode();
        }
        if (getTRA_NUM_DEFINITE() != null) {
            _hashCode += getTRA_NUM_DEFINITE().hashCode();
        }
        if (getTRA_NUM_DADEF() != null) {
            _hashCode += getTRA_NUM_DADEF().hashCode();
        }
        if (getTRA_IMPORTO_RICH() != null) {
            _hashCode += getTRA_IMPORTO_RICH().hashCode();
        }
        if (getTRA_IMPORTO_DEF() != null) {
            _hashCode += getTRA_IMPORTO_DEF().hashCode();
        }
        _hashCode += new Double(getIMPORTO_SUBTOTALE()).hashCode();
        _hashCode += new Double(getIMPORTO_FINALE()).hashCode();
        _hashCode += new Double(getIMPORTO_CONSUNTIVO()).hashCode();
        if (getFLAG_LAVORI_ESTESI() != null) {
            _hashCode += getFLAG_LAVORI_ESTESI().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatiCollaudo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiCollaudo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_SINGOLO_COMMISSIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_SINGOLO_COMMISSIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSingoloCommissioneType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_APPROVAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_APPROVAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_IMPORTI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_IMPORTI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagImportiType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_SICUREZZA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_SICUREZZA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagImportiType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_INIZIO_AMM_RISERVE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_INIZIO_AMM_RISERVE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_FINE_AMM_RISERVE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_FINE_AMM_RISERVE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ONERI_AMM_RISERVE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ONERI_AMM_RISERVE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_INIZIO_ARB_RISERVE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_INIZIO_ARB_RISERVE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_FINE_ARB_RISERVE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_FINE_ARB_RISERVE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ONERI_ARB_RISERVE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ONERI_ARB_RISERVE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_INIZIO_GIU_RISERVE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_INIZIO_GIU_RISERVE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_FINE_GIU_RISERVE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_FINE_GIU_RISERVE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ONERI_GIU_RISERVE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ONERI_GIU_RISERVE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_INIZIO_TRA_RISERVE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_INIZIO_TRA_RISERVE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_FINE_TRA_RISERVE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_FINE_TRA_RISERVE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ONERI_TRA_RISERVE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ONERI_TRA_RISERVE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_SUBAPPALTATORI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_SUBAPPALTATORI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_REGOLARE_ESEC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_REGOLARE_ESEC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_COLLAUDO_STAT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_COLLAUDO_STAT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MODO_COLLAUDO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "MODO_COLLAUDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_NOMINA_COLL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_NOMINA_COLL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_INIZIO_OPER");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_INIZIO_OPER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_CERT_COLLAUDO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_CERT_COLLAUDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_DELIBERA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_DELIBERA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ESITO_COLLAUDO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ESITO_COLLAUDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagEsitoCollaudoType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_FINALE_LAVORI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMP_FINALE_LAVORI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_FINALE_SERVIZI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMP_FINALE_SERVIZI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_FINALE_FORNIT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMP_FINALE_FORNIT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_FINALE_SECUR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMP_FINALE_SECUR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_PROGETTAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMP_PROGETTAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_DISPOSIZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMP_DISPOSIZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AMM_NUM_DEFINITE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "AMM_NUM_DEFINITE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AMM_NUM_DADEF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "AMM_NUM_DADEF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AMM_IMPORTO_RICH");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "AMM_IMPORTO_RICH"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("AMM_IMPORTO_DEF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "AMM_IMPORTO_DEF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ARB_NUM_DEFINITE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ARB_NUM_DEFINITE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ARB_NUM_DADEF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ARB_NUM_DADEF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ARB_IMPORTO_RICH");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ARB_IMPORTO_RICH"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ARB_IMPORTO_DEF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ARB_IMPORTO_DEF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GIU_NUM_DEFINITE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "GIU_NUM_DEFINITE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GIU_NUM_DADEF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "GIU_NUM_DADEF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GIU_IMPORTO_RICH");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "GIU_IMPORTO_RICH"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GIU_IMPORTO_DEF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "GIU_IMPORTO_DEF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TRA_NUM_DEFINITE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TRA_NUM_DEFINITE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TRA_NUM_DADEF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TRA_NUM_DADEF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TRA_IMPORTO_RICH");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TRA_IMPORTO_RICH"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TRA_IMPORTO_DEF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TRA_IMPORTO_DEF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_SUBTOTALE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_SUBTOTALE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_FINALE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_FINALE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_CONSUNTIVO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_CONSUNTIVO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_LAVORI_ESTESI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_LAVORI_ESTESI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
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
