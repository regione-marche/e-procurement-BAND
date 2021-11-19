/**
 * DatiComuniEstesi.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class DatiComuniEstesi  implements java.io.Serializable {
    private java.lang.String OGGETTO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_SOMMA_URGENZA;

    private double IMPORTO_LOTTO;

    private java.lang.String CPV;

    private java.lang.String ID_SCELTA_CONTRAENTE;

    private java.lang.String PROC_SCELTA_502016;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CategoriaType CAT_PREVALENTE;

    private long NUM_PROGR_LOTTO;

    private long NUM_LOTTO_GARA;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_POSA;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_IMPORTO_DISP;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.ClasseImportoType CLASSE_IMPORTO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_LOTTO_DERIVANTE;

    private java.lang.String MOTIVO_COMPLETAMENTO;

    private java.lang.String CIG_PADRE;

    private java.lang.String NUM_PROGRESSIVO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoSchedaType TIPO_APPALTO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSOType FLAG_TIPO_SETTORE;

    private java.lang.String ID_MODO_GARA;

    private java.lang.String LUOGO_ISTAT;

    private java.lang.String NUTS;

    private java.lang.String ID_TIPO_PRESTAZIONE;

    private java.lang.String CIG;

    private double IMPORTO_SIC;

    private java.lang.String CUP;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_1632006_1;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_1632006_2;

    private java.util.Calendar DATA_PUBBLICAZIONE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_SOTTOSOGLIA;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiResponsabile responsabile;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipologiaFS[] listaId_TipologiaFS;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipologiaL[] listaId_TipologiaL;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Condizioni[] listaID_Condizioni;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CPVSecondari[] listaID_CPVSecondari;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi[] listaDatiSoggettiEstesi;

    public DatiComuniEstesi() {
    }

    public DatiComuniEstesi(
           java.lang.String OGGETTO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_SOMMA_URGENZA,
           double IMPORTO_LOTTO,
           java.lang.String CPV,
           java.lang.String ID_SCELTA_CONTRAENTE,
           java.lang.String PROC_SCELTA_502016,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CategoriaType CAT_PREVALENTE,
           long NUM_PROGR_LOTTO,
           long NUM_LOTTO_GARA,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_POSA,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_IMPORTO_DISP,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.ClasseImportoType CLASSE_IMPORTO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_LOTTO_DERIVANTE,
           java.lang.String MOTIVO_COMPLETAMENTO,
           java.lang.String CIG_PADRE,
           java.lang.String NUM_PROGRESSIVO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoSchedaType TIPO_APPALTO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSOType FLAG_TIPO_SETTORE,
           java.lang.String ID_MODO_GARA,
           java.lang.String LUOGO_ISTAT,
           java.lang.String NUTS,
           java.lang.String ID_TIPO_PRESTAZIONE,
           java.lang.String CIG,
           double IMPORTO_SIC,
           java.lang.String CUP,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_1632006_1,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_1632006_2,
           java.util.Calendar DATA_PUBBLICAZIONE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_SOTTOSOGLIA,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiResponsabile responsabile,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipologiaFS[] listaId_TipologiaFS,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipologiaL[] listaId_TipologiaL,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Condizioni[] listaID_Condizioni,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CPVSecondari[] listaID_CPVSecondari,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi[] listaDatiSoggettiEstesi) {
           this.OGGETTO = OGGETTO;
           this.FLAG_SOMMA_URGENZA = FLAG_SOMMA_URGENZA;
           this.IMPORTO_LOTTO = IMPORTO_LOTTO;
           this.CPV = CPV;
           this.ID_SCELTA_CONTRAENTE = ID_SCELTA_CONTRAENTE;
           this.PROC_SCELTA_502016 = PROC_SCELTA_502016;
           this.CAT_PREVALENTE = CAT_PREVALENTE;
           this.NUM_PROGR_LOTTO = NUM_PROGR_LOTTO;
           this.NUM_LOTTO_GARA = NUM_LOTTO_GARA;
           this.FLAG_POSA = FLAG_POSA;
           this.FLAG_IMPORTO_DISP = FLAG_IMPORTO_DISP;
           this.CLASSE_IMPORTO = CLASSE_IMPORTO;
           this.FLAG_LOTTO_DERIVANTE = FLAG_LOTTO_DERIVANTE;
           this.MOTIVO_COMPLETAMENTO = MOTIVO_COMPLETAMENTO;
           this.CIG_PADRE = CIG_PADRE;
           this.NUM_PROGRESSIVO = NUM_PROGRESSIVO;
           this.TIPO_APPALTO = TIPO_APPALTO;
           this.FLAG_TIPO_SETTORE = FLAG_TIPO_SETTORE;
           this.ID_MODO_GARA = ID_MODO_GARA;
           this.LUOGO_ISTAT = LUOGO_ISTAT;
           this.NUTS = NUTS;
           this.ID_TIPO_PRESTAZIONE = ID_TIPO_PRESTAZIONE;
           this.CIG = CIG;
           this.IMPORTO_SIC = IMPORTO_SIC;
           this.CUP = CUP;
           this.FLAG_1632006_1 = FLAG_1632006_1;
           this.FLAG_1632006_2 = FLAG_1632006_2;
           this.DATA_PUBBLICAZIONE = DATA_PUBBLICAZIONE;
           this.FLAG_SOTTOSOGLIA = FLAG_SOTTOSOGLIA;
           this.responsabile = responsabile;
           this.listaId_TipologiaFS = listaId_TipologiaFS;
           this.listaId_TipologiaL = listaId_TipologiaL;
           this.listaID_Condizioni = listaID_Condizioni;
           this.listaID_CPVSecondari = listaID_CPVSecondari;
           this.listaDatiSoggettiEstesi = listaDatiSoggettiEstesi;
    }


    /**
     * Gets the OGGETTO value for this DatiComuniEstesi.
     * 
     * @return OGGETTO
     */
    public java.lang.String getOGGETTO() {
        return OGGETTO;
    }


    /**
     * Sets the OGGETTO value for this DatiComuniEstesi.
     * 
     * @param OGGETTO
     */
    public void setOGGETTO(java.lang.String OGGETTO) {
        this.OGGETTO = OGGETTO;
    }


    /**
     * Gets the FLAG_SOMMA_URGENZA value for this DatiComuniEstesi.
     * 
     * @return FLAG_SOMMA_URGENZA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_SOMMA_URGENZA() {
        return FLAG_SOMMA_URGENZA;
    }


    /**
     * Sets the FLAG_SOMMA_URGENZA value for this DatiComuniEstesi.
     * 
     * @param FLAG_SOMMA_URGENZA
     */
    public void setFLAG_SOMMA_URGENZA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_SOMMA_URGENZA) {
        this.FLAG_SOMMA_URGENZA = FLAG_SOMMA_URGENZA;
    }


    /**
     * Gets the IMPORTO_LOTTO value for this DatiComuniEstesi.
     * 
     * @return IMPORTO_LOTTO
     */
    public double getIMPORTO_LOTTO() {
        return IMPORTO_LOTTO;
    }


    /**
     * Sets the IMPORTO_LOTTO value for this DatiComuniEstesi.
     * 
     * @param IMPORTO_LOTTO
     */
    public void setIMPORTO_LOTTO(double IMPORTO_LOTTO) {
        this.IMPORTO_LOTTO = IMPORTO_LOTTO;
    }


    /**
     * Gets the CPV value for this DatiComuniEstesi.
     * 
     * @return CPV
     */
    public java.lang.String getCPV() {
        return CPV;
    }


    /**
     * Sets the CPV value for this DatiComuniEstesi.
     * 
     * @param CPV
     */
    public void setCPV(java.lang.String CPV) {
        this.CPV = CPV;
    }


    /**
     * Gets the ID_SCELTA_CONTRAENTE value for this DatiComuniEstesi.
     * 
     * @return ID_SCELTA_CONTRAENTE
     */
    public java.lang.String getID_SCELTA_CONTRAENTE() {
        return ID_SCELTA_CONTRAENTE;
    }


    /**
     * Sets the ID_SCELTA_CONTRAENTE value for this DatiComuniEstesi.
     * 
     * @param ID_SCELTA_CONTRAENTE
     */
    public void setID_SCELTA_CONTRAENTE(java.lang.String ID_SCELTA_CONTRAENTE) {
        this.ID_SCELTA_CONTRAENTE = ID_SCELTA_CONTRAENTE;
    }


    /**
     * Gets the PROC_SCELTA_502016 value for this DatiComuniEstesi.
     * 
     * @return PROC_SCELTA_502016
     */
    public java.lang.String getPROC_SCELTA_502016() {
        return PROC_SCELTA_502016;
    }


    /**
     * Sets the PROC_SCELTA_502016 value for this DatiComuniEstesi.
     * 
     * @param PROC_SCELTA_502016
     */
    public void setPROC_SCELTA_502016(java.lang.String PROC_SCELTA_502016) {
        this.PROC_SCELTA_502016 = PROC_SCELTA_502016;
    }


    /**
     * Gets the CAT_PREVALENTE value for this DatiComuniEstesi.
     * 
     * @return CAT_PREVALENTE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CategoriaType getCAT_PREVALENTE() {
        return CAT_PREVALENTE;
    }


    /**
     * Sets the CAT_PREVALENTE value for this DatiComuniEstesi.
     * 
     * @param CAT_PREVALENTE
     */
    public void setCAT_PREVALENTE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CategoriaType CAT_PREVALENTE) {
        this.CAT_PREVALENTE = CAT_PREVALENTE;
    }


    /**
     * Gets the NUM_PROGR_LOTTO value for this DatiComuniEstesi.
     * 
     * @return NUM_PROGR_LOTTO
     */
    public long getNUM_PROGR_LOTTO() {
        return NUM_PROGR_LOTTO;
    }


    /**
     * Sets the NUM_PROGR_LOTTO value for this DatiComuniEstesi.
     * 
     * @param NUM_PROGR_LOTTO
     */
    public void setNUM_PROGR_LOTTO(long NUM_PROGR_LOTTO) {
        this.NUM_PROGR_LOTTO = NUM_PROGR_LOTTO;
    }


    /**
     * Gets the NUM_LOTTO_GARA value for this DatiComuniEstesi.
     * 
     * @return NUM_LOTTO_GARA
     */
    public long getNUM_LOTTO_GARA() {
        return NUM_LOTTO_GARA;
    }


    /**
     * Sets the NUM_LOTTO_GARA value for this DatiComuniEstesi.
     * 
     * @param NUM_LOTTO_GARA
     */
    public void setNUM_LOTTO_GARA(long NUM_LOTTO_GARA) {
        this.NUM_LOTTO_GARA = NUM_LOTTO_GARA;
    }


    /**
     * Gets the FLAG_POSA value for this DatiComuniEstesi.
     * 
     * @return FLAG_POSA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_POSA() {
        return FLAG_POSA;
    }


    /**
     * Sets the FLAG_POSA value for this DatiComuniEstesi.
     * 
     * @param FLAG_POSA
     */
    public void setFLAG_POSA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_POSA) {
        this.FLAG_POSA = FLAG_POSA;
    }


    /**
     * Gets the FLAG_IMPORTO_DISP value for this DatiComuniEstesi.
     * 
     * @return FLAG_IMPORTO_DISP
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_IMPORTO_DISP() {
        return FLAG_IMPORTO_DISP;
    }


    /**
     * Sets the FLAG_IMPORTO_DISP value for this DatiComuniEstesi.
     * 
     * @param FLAG_IMPORTO_DISP
     */
    public void setFLAG_IMPORTO_DISP(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_IMPORTO_DISP) {
        this.FLAG_IMPORTO_DISP = FLAG_IMPORTO_DISP;
    }


    /**
     * Gets the CLASSE_IMPORTO value for this DatiComuniEstesi.
     * 
     * @return CLASSE_IMPORTO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.ClasseImportoType getCLASSE_IMPORTO() {
        return CLASSE_IMPORTO;
    }


    /**
     * Sets the CLASSE_IMPORTO value for this DatiComuniEstesi.
     * 
     * @param CLASSE_IMPORTO
     */
    public void setCLASSE_IMPORTO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.ClasseImportoType CLASSE_IMPORTO) {
        this.CLASSE_IMPORTO = CLASSE_IMPORTO;
    }


    /**
     * Gets the FLAG_LOTTO_DERIVANTE value for this DatiComuniEstesi.
     * 
     * @return FLAG_LOTTO_DERIVANTE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_LOTTO_DERIVANTE() {
        return FLAG_LOTTO_DERIVANTE;
    }


    /**
     * Sets the FLAG_LOTTO_DERIVANTE value for this DatiComuniEstesi.
     * 
     * @param FLAG_LOTTO_DERIVANTE
     */
    public void setFLAG_LOTTO_DERIVANTE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_LOTTO_DERIVANTE) {
        this.FLAG_LOTTO_DERIVANTE = FLAG_LOTTO_DERIVANTE;
    }


    /**
     * Gets the MOTIVO_COMPLETAMENTO value for this DatiComuniEstesi.
     * 
     * @return MOTIVO_COMPLETAMENTO
     */
    public java.lang.String getMOTIVO_COMPLETAMENTO() {
        return MOTIVO_COMPLETAMENTO;
    }


    /**
     * Sets the MOTIVO_COMPLETAMENTO value for this DatiComuniEstesi.
     * 
     * @param MOTIVO_COMPLETAMENTO
     */
    public void setMOTIVO_COMPLETAMENTO(java.lang.String MOTIVO_COMPLETAMENTO) {
        this.MOTIVO_COMPLETAMENTO = MOTIVO_COMPLETAMENTO;
    }


    /**
     * Gets the CIG_PADRE value for this DatiComuniEstesi.
     * 
     * @return CIG_PADRE
     */
    public java.lang.String getCIG_PADRE() {
        return CIG_PADRE;
    }


    /**
     * Sets the CIG_PADRE value for this DatiComuniEstesi.
     * 
     * @param CIG_PADRE
     */
    public void setCIG_PADRE(java.lang.String CIG_PADRE) {
        this.CIG_PADRE = CIG_PADRE;
    }


    /**
     * Gets the NUM_PROGRESSIVO value for this DatiComuniEstesi.
     * 
     * @return NUM_PROGRESSIVO
     */
    public java.lang.String getNUM_PROGRESSIVO() {
        return NUM_PROGRESSIVO;
    }


    /**
     * Sets the NUM_PROGRESSIVO value for this DatiComuniEstesi.
     * 
     * @param NUM_PROGRESSIVO
     */
    public void setNUM_PROGRESSIVO(java.lang.String NUM_PROGRESSIVO) {
        this.NUM_PROGRESSIVO = NUM_PROGRESSIVO;
    }


    /**
     * Gets the TIPO_APPALTO value for this DatiComuniEstesi.
     * 
     * @return TIPO_APPALTO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoSchedaType getTIPO_APPALTO() {
        return TIPO_APPALTO;
    }


    /**
     * Sets the TIPO_APPALTO value for this DatiComuniEstesi.
     * 
     * @param TIPO_APPALTO
     */
    public void setTIPO_APPALTO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoSchedaType TIPO_APPALTO) {
        this.TIPO_APPALTO = TIPO_APPALTO;
    }


    /**
     * Gets the FLAG_TIPO_SETTORE value for this DatiComuniEstesi.
     * 
     * @return FLAG_TIPO_SETTORE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSOType getFLAG_TIPO_SETTORE() {
        return FLAG_TIPO_SETTORE;
    }


    /**
     * Sets the FLAG_TIPO_SETTORE value for this DatiComuniEstesi.
     * 
     * @param FLAG_TIPO_SETTORE
     */
    public void setFLAG_TIPO_SETTORE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSOType FLAG_TIPO_SETTORE) {
        this.FLAG_TIPO_SETTORE = FLAG_TIPO_SETTORE;
    }


    /**
     * Gets the ID_MODO_GARA value for this DatiComuniEstesi.
     * 
     * @return ID_MODO_GARA
     */
    public java.lang.String getID_MODO_GARA() {
        return ID_MODO_GARA;
    }


    /**
     * Sets the ID_MODO_GARA value for this DatiComuniEstesi.
     * 
     * @param ID_MODO_GARA
     */
    public void setID_MODO_GARA(java.lang.String ID_MODO_GARA) {
        this.ID_MODO_GARA = ID_MODO_GARA;
    }


    /**
     * Gets the LUOGO_ISTAT value for this DatiComuniEstesi.
     * 
     * @return LUOGO_ISTAT
     */
    public java.lang.String getLUOGO_ISTAT() {
        return LUOGO_ISTAT;
    }


    /**
     * Sets the LUOGO_ISTAT value for this DatiComuniEstesi.
     * 
     * @param LUOGO_ISTAT
     */
    public void setLUOGO_ISTAT(java.lang.String LUOGO_ISTAT) {
        this.LUOGO_ISTAT = LUOGO_ISTAT;
    }


    /**
     * Gets the NUTS value for this DatiComuniEstesi.
     * 
     * @return NUTS
     */
    public java.lang.String getNUTS() {
        return NUTS;
    }


    /**
     * Sets the NUTS value for this DatiComuniEstesi.
     * 
     * @param NUTS
     */
    public void setNUTS(java.lang.String NUTS) {
        this.NUTS = NUTS;
    }


    /**
     * Gets the ID_TIPO_PRESTAZIONE value for this DatiComuniEstesi.
     * 
     * @return ID_TIPO_PRESTAZIONE
     */
    public java.lang.String getID_TIPO_PRESTAZIONE() {
        return ID_TIPO_PRESTAZIONE;
    }


    /**
     * Sets the ID_TIPO_PRESTAZIONE value for this DatiComuniEstesi.
     * 
     * @param ID_TIPO_PRESTAZIONE
     */
    public void setID_TIPO_PRESTAZIONE(java.lang.String ID_TIPO_PRESTAZIONE) {
        this.ID_TIPO_PRESTAZIONE = ID_TIPO_PRESTAZIONE;
    }


    /**
     * Gets the CIG value for this DatiComuniEstesi.
     * 
     * @return CIG
     */
    public java.lang.String getCIG() {
        return CIG;
    }


    /**
     * Sets the CIG value for this DatiComuniEstesi.
     * 
     * @param CIG
     */
    public void setCIG(java.lang.String CIG) {
        this.CIG = CIG;
    }


    /**
     * Gets the IMPORTO_SIC value for this DatiComuniEstesi.
     * 
     * @return IMPORTO_SIC
     */
    public double getIMPORTO_SIC() {
        return IMPORTO_SIC;
    }


    /**
     * Sets the IMPORTO_SIC value for this DatiComuniEstesi.
     * 
     * @param IMPORTO_SIC
     */
    public void setIMPORTO_SIC(double IMPORTO_SIC) {
        this.IMPORTO_SIC = IMPORTO_SIC;
    }


    /**
     * Gets the CUP value for this DatiComuniEstesi.
     * 
     * @return CUP
     */
    public java.lang.String getCUP() {
        return CUP;
    }


    /**
     * Sets the CUP value for this DatiComuniEstesi.
     * 
     * @param CUP
     */
    public void setCUP(java.lang.String CUP) {
        this.CUP = CUP;
    }


    /**
     * Gets the FLAG_1632006_1 value for this DatiComuniEstesi.
     * 
     * @return FLAG_1632006_1
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_1632006_1() {
        return FLAG_1632006_1;
    }


    /**
     * Sets the FLAG_1632006_1 value for this DatiComuniEstesi.
     * 
     * @param FLAG_1632006_1
     */
    public void setFLAG_1632006_1(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_1632006_1) {
        this.FLAG_1632006_1 = FLAG_1632006_1;
    }


    /**
     * Gets the FLAG_1632006_2 value for this DatiComuniEstesi.
     * 
     * @return FLAG_1632006_2
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_1632006_2() {
        return FLAG_1632006_2;
    }


    /**
     * Sets the FLAG_1632006_2 value for this DatiComuniEstesi.
     * 
     * @param FLAG_1632006_2
     */
    public void setFLAG_1632006_2(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_1632006_2) {
        this.FLAG_1632006_2 = FLAG_1632006_2;
    }


    /**
     * Gets the DATA_PUBBLICAZIONE value for this DatiComuniEstesi.
     * 
     * @return DATA_PUBBLICAZIONE
     */
    public java.util.Calendar getDATA_PUBBLICAZIONE() {
        return DATA_PUBBLICAZIONE;
    }


    /**
     * Sets the DATA_PUBBLICAZIONE value for this DatiComuniEstesi.
     * 
     * @param DATA_PUBBLICAZIONE
     */
    public void setDATA_PUBBLICAZIONE(java.util.Calendar DATA_PUBBLICAZIONE) {
        this.DATA_PUBBLICAZIONE = DATA_PUBBLICAZIONE;
    }


    /**
     * Gets the FLAG_SOTTOSOGLIA value for this DatiComuniEstesi.
     * 
     * @return FLAG_SOTTOSOGLIA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_SOTTOSOGLIA() {
        return FLAG_SOTTOSOGLIA;
    }


    /**
     * Sets the FLAG_SOTTOSOGLIA value for this DatiComuniEstesi.
     * 
     * @param FLAG_SOTTOSOGLIA
     */
    public void setFLAG_SOTTOSOGLIA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_SOTTOSOGLIA) {
        this.FLAG_SOTTOSOGLIA = FLAG_SOTTOSOGLIA;
    }


    /**
     * Gets the responsabile value for this DatiComuniEstesi.
     * 
     * @return responsabile
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiResponsabile getResponsabile() {
        return responsabile;
    }


    /**
     * Sets the responsabile value for this DatiComuniEstesi.
     * 
     * @param responsabile
     */
    public void setResponsabile(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiResponsabile responsabile) {
        this.responsabile = responsabile;
    }


    /**
     * Gets the listaId_TipologiaFS value for this DatiComuniEstesi.
     * 
     * @return listaId_TipologiaFS
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipologiaFS[] getListaId_TipologiaFS() {
        return listaId_TipologiaFS;
    }


    /**
     * Sets the listaId_TipologiaFS value for this DatiComuniEstesi.
     * 
     * @param listaId_TipologiaFS
     */
    public void setListaId_TipologiaFS(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipologiaFS[] listaId_TipologiaFS) {
        this.listaId_TipologiaFS = listaId_TipologiaFS;
    }


    /**
     * Gets the listaId_TipologiaL value for this DatiComuniEstesi.
     * 
     * @return listaId_TipologiaL
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipologiaL[] getListaId_TipologiaL() {
        return listaId_TipologiaL;
    }


    /**
     * Sets the listaId_TipologiaL value for this DatiComuniEstesi.
     * 
     * @param listaId_TipologiaL
     */
    public void setListaId_TipologiaL(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipologiaL[] listaId_TipologiaL) {
        this.listaId_TipologiaL = listaId_TipologiaL;
    }


    /**
     * Gets the listaID_Condizioni value for this DatiComuniEstesi.
     * 
     * @return listaID_Condizioni
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Condizioni[] getListaID_Condizioni() {
        return listaID_Condizioni;
    }


    /**
     * Sets the listaID_Condizioni value for this DatiComuniEstesi.
     * 
     * @param listaID_Condizioni
     */
    public void setListaID_Condizioni(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Condizioni[] listaID_Condizioni) {
        this.listaID_Condizioni = listaID_Condizioni;
    }


    /**
     * Gets the listaID_CPVSecondari value for this DatiComuniEstesi.
     * 
     * @return listaID_CPVSecondari
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CPVSecondari[] getListaID_CPVSecondari() {
        return listaID_CPVSecondari;
    }


    /**
     * Sets the listaID_CPVSecondari value for this DatiComuniEstesi.
     * 
     * @param listaID_CPVSecondari
     */
    public void setListaID_CPVSecondari(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CPVSecondari[] listaID_CPVSecondari) {
        this.listaID_CPVSecondari = listaID_CPVSecondari;
    }


    /**
     * Gets the listaDatiSoggettiEstesi value for this DatiComuniEstesi.
     * 
     * @return listaDatiSoggettiEstesi
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi[] getListaDatiSoggettiEstesi() {
        return listaDatiSoggettiEstesi;
    }


    /**
     * Sets the listaDatiSoggettiEstesi value for this DatiComuniEstesi.
     * 
     * @param listaDatiSoggettiEstesi
     */
    public void setListaDatiSoggettiEstesi(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi[] listaDatiSoggettiEstesi) {
        this.listaDatiSoggettiEstesi = listaDatiSoggettiEstesi;
    }

    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi getListaDatiSoggettiEstesi(int i) {
        return this.listaDatiSoggettiEstesi[i];
    }

    public void setListaDatiSoggettiEstesi(int i, it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi _value) {
        this.listaDatiSoggettiEstesi[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatiComuniEstesi)) return false;
        DatiComuniEstesi other = (DatiComuniEstesi) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.OGGETTO==null && other.getOGGETTO()==null) || 
             (this.OGGETTO!=null &&
              this.OGGETTO.equals(other.getOGGETTO()))) &&
            ((this.FLAG_SOMMA_URGENZA==null && other.getFLAG_SOMMA_URGENZA()==null) || 
             (this.FLAG_SOMMA_URGENZA!=null &&
              this.FLAG_SOMMA_URGENZA.equals(other.getFLAG_SOMMA_URGENZA()))) &&
            this.IMPORTO_LOTTO == other.getIMPORTO_LOTTO() &&
            ((this.CPV==null && other.getCPV()==null) || 
             (this.CPV!=null &&
              this.CPV.equals(other.getCPV()))) &&
            ((this.ID_SCELTA_CONTRAENTE==null && other.getID_SCELTA_CONTRAENTE()==null) || 
             (this.ID_SCELTA_CONTRAENTE!=null &&
              this.ID_SCELTA_CONTRAENTE.equals(other.getID_SCELTA_CONTRAENTE()))) &&
            ((this.PROC_SCELTA_502016==null && other.getPROC_SCELTA_502016()==null) || 
             (this.PROC_SCELTA_502016!=null &&
              this.PROC_SCELTA_502016.equals(other.getPROC_SCELTA_502016()))) &&
            ((this.CAT_PREVALENTE==null && other.getCAT_PREVALENTE()==null) || 
             (this.CAT_PREVALENTE!=null &&
              this.CAT_PREVALENTE.equals(other.getCAT_PREVALENTE()))) &&
            this.NUM_PROGR_LOTTO == other.getNUM_PROGR_LOTTO() &&
            this.NUM_LOTTO_GARA == other.getNUM_LOTTO_GARA() &&
            ((this.FLAG_POSA==null && other.getFLAG_POSA()==null) || 
             (this.FLAG_POSA!=null &&
              this.FLAG_POSA.equals(other.getFLAG_POSA()))) &&
            ((this.FLAG_IMPORTO_DISP==null && other.getFLAG_IMPORTO_DISP()==null) || 
             (this.FLAG_IMPORTO_DISP!=null &&
              this.FLAG_IMPORTO_DISP.equals(other.getFLAG_IMPORTO_DISP()))) &&
            ((this.CLASSE_IMPORTO==null && other.getCLASSE_IMPORTO()==null) || 
             (this.CLASSE_IMPORTO!=null &&
              this.CLASSE_IMPORTO.equals(other.getCLASSE_IMPORTO()))) &&
            ((this.FLAG_LOTTO_DERIVANTE==null && other.getFLAG_LOTTO_DERIVANTE()==null) || 
             (this.FLAG_LOTTO_DERIVANTE!=null &&
              this.FLAG_LOTTO_DERIVANTE.equals(other.getFLAG_LOTTO_DERIVANTE()))) &&
            ((this.MOTIVO_COMPLETAMENTO==null && other.getMOTIVO_COMPLETAMENTO()==null) || 
             (this.MOTIVO_COMPLETAMENTO!=null &&
              this.MOTIVO_COMPLETAMENTO.equals(other.getMOTIVO_COMPLETAMENTO()))) &&
            ((this.CIG_PADRE==null && other.getCIG_PADRE()==null) || 
             (this.CIG_PADRE!=null &&
              this.CIG_PADRE.equals(other.getCIG_PADRE()))) &&
            ((this.NUM_PROGRESSIVO==null && other.getNUM_PROGRESSIVO()==null) || 
             (this.NUM_PROGRESSIVO!=null &&
              this.NUM_PROGRESSIVO.equals(other.getNUM_PROGRESSIVO()))) &&
            ((this.TIPO_APPALTO==null && other.getTIPO_APPALTO()==null) || 
             (this.TIPO_APPALTO!=null &&
              this.TIPO_APPALTO.equals(other.getTIPO_APPALTO()))) &&
            ((this.FLAG_TIPO_SETTORE==null && other.getFLAG_TIPO_SETTORE()==null) || 
             (this.FLAG_TIPO_SETTORE!=null &&
              this.FLAG_TIPO_SETTORE.equals(other.getFLAG_TIPO_SETTORE()))) &&
            ((this.ID_MODO_GARA==null && other.getID_MODO_GARA()==null) || 
             (this.ID_MODO_GARA!=null &&
              this.ID_MODO_GARA.equals(other.getID_MODO_GARA()))) &&
            ((this.LUOGO_ISTAT==null && other.getLUOGO_ISTAT()==null) || 
             (this.LUOGO_ISTAT!=null &&
              this.LUOGO_ISTAT.equals(other.getLUOGO_ISTAT()))) &&
            ((this.NUTS==null && other.getNUTS()==null) || 
             (this.NUTS!=null &&
              this.NUTS.equals(other.getNUTS()))) &&
            ((this.ID_TIPO_PRESTAZIONE==null && other.getID_TIPO_PRESTAZIONE()==null) || 
             (this.ID_TIPO_PRESTAZIONE!=null &&
              this.ID_TIPO_PRESTAZIONE.equals(other.getID_TIPO_PRESTAZIONE()))) &&
            ((this.CIG==null && other.getCIG()==null) || 
             (this.CIG!=null &&
              this.CIG.equals(other.getCIG()))) &&
            this.IMPORTO_SIC == other.getIMPORTO_SIC() &&
            ((this.CUP==null && other.getCUP()==null) || 
             (this.CUP!=null &&
              this.CUP.equals(other.getCUP()))) &&
            ((this.FLAG_1632006_1==null && other.getFLAG_1632006_1()==null) || 
             (this.FLAG_1632006_1!=null &&
              this.FLAG_1632006_1.equals(other.getFLAG_1632006_1()))) &&
            ((this.FLAG_1632006_2==null && other.getFLAG_1632006_2()==null) || 
             (this.FLAG_1632006_2!=null &&
              this.FLAG_1632006_2.equals(other.getFLAG_1632006_2()))) &&
            ((this.DATA_PUBBLICAZIONE==null && other.getDATA_PUBBLICAZIONE()==null) || 
             (this.DATA_PUBBLICAZIONE!=null &&
              this.DATA_PUBBLICAZIONE.equals(other.getDATA_PUBBLICAZIONE()))) &&
            ((this.FLAG_SOTTOSOGLIA==null && other.getFLAG_SOTTOSOGLIA()==null) || 
             (this.FLAG_SOTTOSOGLIA!=null &&
              this.FLAG_SOTTOSOGLIA.equals(other.getFLAG_SOTTOSOGLIA()))) &&
            ((this.responsabile==null && other.getResponsabile()==null) || 
             (this.responsabile!=null &&
              this.responsabile.equals(other.getResponsabile()))) &&
            ((this.listaId_TipologiaFS==null && other.getListaId_TipologiaFS()==null) || 
             (this.listaId_TipologiaFS!=null &&
              java.util.Arrays.equals(this.listaId_TipologiaFS, other.getListaId_TipologiaFS()))) &&
            ((this.listaId_TipologiaL==null && other.getListaId_TipologiaL()==null) || 
             (this.listaId_TipologiaL!=null &&
              java.util.Arrays.equals(this.listaId_TipologiaL, other.getListaId_TipologiaL()))) &&
            ((this.listaID_Condizioni==null && other.getListaID_Condizioni()==null) || 
             (this.listaID_Condizioni!=null &&
              java.util.Arrays.equals(this.listaID_Condizioni, other.getListaID_Condizioni()))) &&
            ((this.listaID_CPVSecondari==null && other.getListaID_CPVSecondari()==null) || 
             (this.listaID_CPVSecondari!=null &&
              java.util.Arrays.equals(this.listaID_CPVSecondari, other.getListaID_CPVSecondari()))) &&
            ((this.listaDatiSoggettiEstesi==null && other.getListaDatiSoggettiEstesi()==null) || 
             (this.listaDatiSoggettiEstesi!=null &&
              java.util.Arrays.equals(this.listaDatiSoggettiEstesi, other.getListaDatiSoggettiEstesi())));
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
        if (getOGGETTO() != null) {
            _hashCode += getOGGETTO().hashCode();
        }
        if (getFLAG_SOMMA_URGENZA() != null) {
            _hashCode += getFLAG_SOMMA_URGENZA().hashCode();
        }
        _hashCode += new Double(getIMPORTO_LOTTO()).hashCode();
        if (getCPV() != null) {
            _hashCode += getCPV().hashCode();
        }
        if (getID_SCELTA_CONTRAENTE() != null) {
            _hashCode += getID_SCELTA_CONTRAENTE().hashCode();
        }
        if (getPROC_SCELTA_502016() != null) {
            _hashCode += getPROC_SCELTA_502016().hashCode();
        }
        if (getCAT_PREVALENTE() != null) {
            _hashCode += getCAT_PREVALENTE().hashCode();
        }
        _hashCode += new Long(getNUM_PROGR_LOTTO()).hashCode();
        _hashCode += new Long(getNUM_LOTTO_GARA()).hashCode();
        if (getFLAG_POSA() != null) {
            _hashCode += getFLAG_POSA().hashCode();
        }
        if (getFLAG_IMPORTO_DISP() != null) {
            _hashCode += getFLAG_IMPORTO_DISP().hashCode();
        }
        if (getCLASSE_IMPORTO() != null) {
            _hashCode += getCLASSE_IMPORTO().hashCode();
        }
        if (getFLAG_LOTTO_DERIVANTE() != null) {
            _hashCode += getFLAG_LOTTO_DERIVANTE().hashCode();
        }
        if (getMOTIVO_COMPLETAMENTO() != null) {
            _hashCode += getMOTIVO_COMPLETAMENTO().hashCode();
        }
        if (getCIG_PADRE() != null) {
            _hashCode += getCIG_PADRE().hashCode();
        }
        if (getNUM_PROGRESSIVO() != null) {
            _hashCode += getNUM_PROGRESSIVO().hashCode();
        }
        if (getTIPO_APPALTO() != null) {
            _hashCode += getTIPO_APPALTO().hashCode();
        }
        if (getFLAG_TIPO_SETTORE() != null) {
            _hashCode += getFLAG_TIPO_SETTORE().hashCode();
        }
        if (getID_MODO_GARA() != null) {
            _hashCode += getID_MODO_GARA().hashCode();
        }
        if (getLUOGO_ISTAT() != null) {
            _hashCode += getLUOGO_ISTAT().hashCode();
        }
        if (getNUTS() != null) {
            _hashCode += getNUTS().hashCode();
        }
        if (getID_TIPO_PRESTAZIONE() != null) {
            _hashCode += getID_TIPO_PRESTAZIONE().hashCode();
        }
        if (getCIG() != null) {
            _hashCode += getCIG().hashCode();
        }
        _hashCode += new Double(getIMPORTO_SIC()).hashCode();
        if (getCUP() != null) {
            _hashCode += getCUP().hashCode();
        }
        if (getFLAG_1632006_1() != null) {
            _hashCode += getFLAG_1632006_1().hashCode();
        }
        if (getFLAG_1632006_2() != null) {
            _hashCode += getFLAG_1632006_2().hashCode();
        }
        if (getDATA_PUBBLICAZIONE() != null) {
            _hashCode += getDATA_PUBBLICAZIONE().hashCode();
        }
        if (getFLAG_SOTTOSOGLIA() != null) {
            _hashCode += getFLAG_SOTTOSOGLIA().hashCode();
        }
        if (getResponsabile() != null) {
            _hashCode += getResponsabile().hashCode();
        }
        if (getListaId_TipologiaFS() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaId_TipologiaFS());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaId_TipologiaFS(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaId_TipologiaL() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaId_TipologiaL());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaId_TipologiaL(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaID_Condizioni() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaID_Condizioni());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaID_Condizioni(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaID_CPVSecondari() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaID_CPVSecondari());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaID_CPVSecondari(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getListaDatiSoggettiEstesi() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getListaDatiSoggettiEstesi());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getListaDatiSoggettiEstesi(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatiComuniEstesi.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiComuniEstesi"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OGGETTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "OGGETTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_SOMMA_URGENZA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_SOMMA_URGENZA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_LOTTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_LOTTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CPV");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CPV"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_SCELTA_CONTRAENTE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_SCELTA_CONTRAENTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROC_SCELTA_502016");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "PROC_SCELTA_502016"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CAT_PREVALENTE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CAT_PREVALENTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CategoriaType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_PROGR_LOTTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_PROGR_LOTTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_LOTTO_GARA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_LOTTO_GARA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_POSA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_POSA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_IMPORTO_DISP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_IMPORTO_DISP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CLASSE_IMPORTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CLASSE_IMPORTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ClasseImportoType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_LOTTO_DERIVANTE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_LOTTO_DERIVANTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MOTIVO_COMPLETAMENTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "MOTIVO_COMPLETAMENTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CIG_PADRE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CIG_PADRE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_PROGRESSIVO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_PROGRESSIVO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TIPO_APPALTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TIPO_APPALTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TipoSchedaType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_TIPO_SETTORE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_TIPO_SETTORE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSOType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_MODO_GARA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_MODO_GARA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LUOGO_ISTAT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "LUOGO_ISTAT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUTS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUTS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_TIPO_PRESTAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_TIPO_PRESTAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CIG");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CIG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_SIC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_SIC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CUP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CUP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_1632006_1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_1632006_1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_1632006_2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_1632006_2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_PUBBLICAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_PUBBLICAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_SOTTOSOGLIA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_SOTTOSOGLIA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responsabile");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "responsabile"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiResponsabile"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaId_TipologiaFS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "lista-Id_TipologiaFS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TipologiaFS"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_TipologiaFS"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaId_TipologiaL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "lista-Id_TipologiaL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TipologiaL"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_TipologiaL"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaID_Condizioni");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "lista-ID_Condizioni"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Condizioni"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_Condizioni"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaID_CPVSecondari");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "lista-ID_CPVSecondari"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CPVSecondari"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_CPVSecondari"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("listaDatiSoggettiEstesi");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ListaDatiSoggettiEstesi"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiSoggettiEstesi"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
