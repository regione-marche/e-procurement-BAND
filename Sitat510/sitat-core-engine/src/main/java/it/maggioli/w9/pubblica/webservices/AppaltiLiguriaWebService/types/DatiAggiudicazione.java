/**
 * DatiAggiudicazione.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class DatiAggiudicazione  implements java.io.Serializable {
    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FIN_REGIONALE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType FLAG_IMPORTI;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType FLAG_SICUREZZA;

    private java.lang.String FLAG_LIVELLO_PROGETTUALE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType VERIFICA_CAMPIONE;

    private java.util.Calendar DATA_VERB_AGGIUDICAZIONE;

    private double IMPORTO_AGGIUDICAZIONE;

    private java.lang.Double IMPORTO_DISPOSIZIONE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType ASTA_ELETTRONICA;

    private java.lang.Float PERC_RIBASSO_AGG;

    private java.lang.Float PERC_OFF_AUMENTO;

    private java.lang.Double IMPORTO_APPALTO;

    private java.lang.Double IMPORTO_INTERVENTO;

    private java.lang.Double IMPORTO_NETTO_SIC;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType PROCEDURA_ACC;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType PREINFORMAZIONE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType TERMINE_RIDOTTO;

    private java.lang.String ID_MODO_INDIZIONE;

    private java.lang.Long NUM_IMPRESE_INVITATE;

    private java.lang.Long NUM_IMPRESE_RICHIESTA_INVITO;

    private long NUM_IMPRESE_OFFERENTI;

    private long NUM_OFFERTE_AMMESSE;

    private java.util.Calendar DATA_SCADENZA_RICHIESTA_INVITO;

    private java.util.Calendar DATA_SCADENZA_PRES_OFFERTA;

    private java.lang.Double IMPORTO_LAVORI;

    private java.lang.Double IMPORTO_SERVIZI;

    private java.lang.Double IMPORTO_FORNITURE;

    private java.lang.Double IMPORTO_ATTUAZIONE_SICUREZZA;

    private java.lang.Double IMPORTO_PROGETTAZIONE;

    private java.lang.String REQUISITI_SS;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_AQ;

    private java.util.Calendar DATA_INVITO;

    private java.lang.Long NUM_MANIF_INTERESSE;

    private java.util.Calendar DATA_MANIF_INTERESSE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_RICH_SUBAPPALTO;

    private java.lang.Long NUM_OFFERTE_ESCLUSE;

    private java.lang.Float OFFERTA_MASSIMO;

    private java.lang.Float OFFERTA_MINIMA;

    private java.lang.Float VAL_SOGLIA_ANOMALIA;

    private java.lang.Long NUM_OFFERTE_FUORI_SOGLIA;

    private java.lang.Long NUM_IMP_ESCL_INSUF_GIUST;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoStrumentoType COD_STRUMENTO;

    private java.lang.Double IMP_NON_ASSOG;

    private java.lang.String MODALITA_RIAGGIUDICAZIONE;

    private java.lang.Long DURATA_AQ;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType OPERE_URBANIZ_SCOMPUTO;

    private java.lang.String TIPO_ATTO;

    private java.util.Calendar DATA_ATTO;

    private java.lang.String NUM_ATTO;

    private java.lang.Float PERC_IVA;

    private java.lang.Double IMPORTO_IVA;

    public DatiAggiudicazione() {
    }

    public DatiAggiudicazione(
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FIN_REGIONALE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType FLAG_IMPORTI,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType FLAG_SICUREZZA,
           java.lang.String FLAG_LIVELLO_PROGETTUALE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType VERIFICA_CAMPIONE,
           java.util.Calendar DATA_VERB_AGGIUDICAZIONE,
           double IMPORTO_AGGIUDICAZIONE,
           java.lang.Double IMPORTO_DISPOSIZIONE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType ASTA_ELETTRONICA,
           java.lang.Float PERC_RIBASSO_AGG,
           java.lang.Float PERC_OFF_AUMENTO,
           java.lang.Double IMPORTO_APPALTO,
           java.lang.Double IMPORTO_INTERVENTO,
           java.lang.Double IMPORTO_NETTO_SIC,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType PROCEDURA_ACC,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType PREINFORMAZIONE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType TERMINE_RIDOTTO,
           java.lang.String ID_MODO_INDIZIONE,
           java.lang.Long NUM_IMPRESE_INVITATE,
           java.lang.Long NUM_IMPRESE_RICHIESTA_INVITO,
           long NUM_IMPRESE_OFFERENTI,
           long NUM_OFFERTE_AMMESSE,
           java.util.Calendar DATA_SCADENZA_RICHIESTA_INVITO,
           java.util.Calendar DATA_SCADENZA_PRES_OFFERTA,
           java.lang.Double IMPORTO_LAVORI,
           java.lang.Double IMPORTO_SERVIZI,
           java.lang.Double IMPORTO_FORNITURE,
           java.lang.Double IMPORTO_ATTUAZIONE_SICUREZZA,
           java.lang.Double IMPORTO_PROGETTAZIONE,
           java.lang.String REQUISITI_SS,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_AQ,
           java.util.Calendar DATA_INVITO,
           java.lang.Long NUM_MANIF_INTERESSE,
           java.util.Calendar DATA_MANIF_INTERESSE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_RICH_SUBAPPALTO,
           java.lang.Long NUM_OFFERTE_ESCLUSE,
           java.lang.Float OFFERTA_MASSIMO,
           java.lang.Float OFFERTA_MINIMA,
           java.lang.Float VAL_SOGLIA_ANOMALIA,
           java.lang.Long NUM_OFFERTE_FUORI_SOGLIA,
           java.lang.Long NUM_IMP_ESCL_INSUF_GIUST,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoStrumentoType COD_STRUMENTO,
           java.lang.Double IMP_NON_ASSOG,
           java.lang.String MODALITA_RIAGGIUDICAZIONE,
           java.lang.Long DURATA_AQ,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType OPERE_URBANIZ_SCOMPUTO,
           java.lang.String TIPO_ATTO,
           java.util.Calendar DATA_ATTO,
           java.lang.String NUM_ATTO,
           java.lang.Float PERC_IVA,
           java.lang.Double IMPORTO_IVA) {
           this.FIN_REGIONALE = FIN_REGIONALE;
           this.FLAG_IMPORTI = FLAG_IMPORTI;
           this.FLAG_SICUREZZA = FLAG_SICUREZZA;
           this.FLAG_LIVELLO_PROGETTUALE = FLAG_LIVELLO_PROGETTUALE;
           this.VERIFICA_CAMPIONE = VERIFICA_CAMPIONE;
           this.DATA_VERB_AGGIUDICAZIONE = DATA_VERB_AGGIUDICAZIONE;
           this.IMPORTO_AGGIUDICAZIONE = IMPORTO_AGGIUDICAZIONE;
           this.IMPORTO_DISPOSIZIONE = IMPORTO_DISPOSIZIONE;
           this.ASTA_ELETTRONICA = ASTA_ELETTRONICA;
           this.PERC_RIBASSO_AGG = PERC_RIBASSO_AGG;
           this.PERC_OFF_AUMENTO = PERC_OFF_AUMENTO;
           this.IMPORTO_APPALTO = IMPORTO_APPALTO;
           this.IMPORTO_INTERVENTO = IMPORTO_INTERVENTO;
           this.IMPORTO_NETTO_SIC = IMPORTO_NETTO_SIC;
           this.PROCEDURA_ACC = PROCEDURA_ACC;
           this.PREINFORMAZIONE = PREINFORMAZIONE;
           this.TERMINE_RIDOTTO = TERMINE_RIDOTTO;
           this.ID_MODO_INDIZIONE = ID_MODO_INDIZIONE;
           this.NUM_IMPRESE_INVITATE = NUM_IMPRESE_INVITATE;
           this.NUM_IMPRESE_RICHIESTA_INVITO = NUM_IMPRESE_RICHIESTA_INVITO;
           this.NUM_IMPRESE_OFFERENTI = NUM_IMPRESE_OFFERENTI;
           this.NUM_OFFERTE_AMMESSE = NUM_OFFERTE_AMMESSE;
           this.DATA_SCADENZA_RICHIESTA_INVITO = DATA_SCADENZA_RICHIESTA_INVITO;
           this.DATA_SCADENZA_PRES_OFFERTA = DATA_SCADENZA_PRES_OFFERTA;
           this.IMPORTO_LAVORI = IMPORTO_LAVORI;
           this.IMPORTO_SERVIZI = IMPORTO_SERVIZI;
           this.IMPORTO_FORNITURE = IMPORTO_FORNITURE;
           this.IMPORTO_ATTUAZIONE_SICUREZZA = IMPORTO_ATTUAZIONE_SICUREZZA;
           this.IMPORTO_PROGETTAZIONE = IMPORTO_PROGETTAZIONE;
           this.REQUISITI_SS = REQUISITI_SS;
           this.FLAG_AQ = FLAG_AQ;
           this.DATA_INVITO = DATA_INVITO;
           this.NUM_MANIF_INTERESSE = NUM_MANIF_INTERESSE;
           this.DATA_MANIF_INTERESSE = DATA_MANIF_INTERESSE;
           this.FLAG_RICH_SUBAPPALTO = FLAG_RICH_SUBAPPALTO;
           this.NUM_OFFERTE_ESCLUSE = NUM_OFFERTE_ESCLUSE;
           this.OFFERTA_MASSIMO = OFFERTA_MASSIMO;
           this.OFFERTA_MINIMA = OFFERTA_MINIMA;
           this.VAL_SOGLIA_ANOMALIA = VAL_SOGLIA_ANOMALIA;
           this.NUM_OFFERTE_FUORI_SOGLIA = NUM_OFFERTE_FUORI_SOGLIA;
           this.NUM_IMP_ESCL_INSUF_GIUST = NUM_IMP_ESCL_INSUF_GIUST;
           this.COD_STRUMENTO = COD_STRUMENTO;
           this.IMP_NON_ASSOG = IMP_NON_ASSOG;
           this.MODALITA_RIAGGIUDICAZIONE = MODALITA_RIAGGIUDICAZIONE;
           this.DURATA_AQ = DURATA_AQ;
           this.OPERE_URBANIZ_SCOMPUTO = OPERE_URBANIZ_SCOMPUTO;
           this.TIPO_ATTO = TIPO_ATTO;
           this.DATA_ATTO = DATA_ATTO;
           this.NUM_ATTO = NUM_ATTO;
           this.PERC_IVA = PERC_IVA;
           this.IMPORTO_IVA = IMPORTO_IVA;
    }


    /**
     * Gets the FIN_REGIONALE value for this DatiAggiudicazione.
     * 
     * @return FIN_REGIONALE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFIN_REGIONALE() {
        return FIN_REGIONALE;
    }


    /**
     * Sets the FIN_REGIONALE value for this DatiAggiudicazione.
     * 
     * @param FIN_REGIONALE
     */
    public void setFIN_REGIONALE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FIN_REGIONALE) {
        this.FIN_REGIONALE = FIN_REGIONALE;
    }


    /**
     * Gets the FLAG_IMPORTI value for this DatiAggiudicazione.
     * 
     * @return FLAG_IMPORTI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType getFLAG_IMPORTI() {
        return FLAG_IMPORTI;
    }


    /**
     * Sets the FLAG_IMPORTI value for this DatiAggiudicazione.
     * 
     * @param FLAG_IMPORTI
     */
    public void setFLAG_IMPORTI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType FLAG_IMPORTI) {
        this.FLAG_IMPORTI = FLAG_IMPORTI;
    }


    /**
     * Gets the FLAG_SICUREZZA value for this DatiAggiudicazione.
     * 
     * @return FLAG_SICUREZZA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType getFLAG_SICUREZZA() {
        return FLAG_SICUREZZA;
    }


    /**
     * Sets the FLAG_SICUREZZA value for this DatiAggiudicazione.
     * 
     * @param FLAG_SICUREZZA
     */
    public void setFLAG_SICUREZZA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType FLAG_SICUREZZA) {
        this.FLAG_SICUREZZA = FLAG_SICUREZZA;
    }


    /**
     * Gets the FLAG_LIVELLO_PROGETTUALE value for this DatiAggiudicazione.
     * 
     * @return FLAG_LIVELLO_PROGETTUALE
     */
    public java.lang.String getFLAG_LIVELLO_PROGETTUALE() {
        return FLAG_LIVELLO_PROGETTUALE;
    }


    /**
     * Sets the FLAG_LIVELLO_PROGETTUALE value for this DatiAggiudicazione.
     * 
     * @param FLAG_LIVELLO_PROGETTUALE
     */
    public void setFLAG_LIVELLO_PROGETTUALE(java.lang.String FLAG_LIVELLO_PROGETTUALE) {
        this.FLAG_LIVELLO_PROGETTUALE = FLAG_LIVELLO_PROGETTUALE;
    }


    /**
     * Gets the VERIFICA_CAMPIONE value for this DatiAggiudicazione.
     * 
     * @return VERIFICA_CAMPIONE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getVERIFICA_CAMPIONE() {
        return VERIFICA_CAMPIONE;
    }


    /**
     * Sets the VERIFICA_CAMPIONE value for this DatiAggiudicazione.
     * 
     * @param VERIFICA_CAMPIONE
     */
    public void setVERIFICA_CAMPIONE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType VERIFICA_CAMPIONE) {
        this.VERIFICA_CAMPIONE = VERIFICA_CAMPIONE;
    }


    /**
     * Gets the DATA_VERB_AGGIUDICAZIONE value for this DatiAggiudicazione.
     * 
     * @return DATA_VERB_AGGIUDICAZIONE
     */
    public java.util.Calendar getDATA_VERB_AGGIUDICAZIONE() {
        return DATA_VERB_AGGIUDICAZIONE;
    }


    /**
     * Sets the DATA_VERB_AGGIUDICAZIONE value for this DatiAggiudicazione.
     * 
     * @param DATA_VERB_AGGIUDICAZIONE
     */
    public void setDATA_VERB_AGGIUDICAZIONE(java.util.Calendar DATA_VERB_AGGIUDICAZIONE) {
        this.DATA_VERB_AGGIUDICAZIONE = DATA_VERB_AGGIUDICAZIONE;
    }


    /**
     * Gets the IMPORTO_AGGIUDICAZIONE value for this DatiAggiudicazione.
     * 
     * @return IMPORTO_AGGIUDICAZIONE
     */
    public double getIMPORTO_AGGIUDICAZIONE() {
        return IMPORTO_AGGIUDICAZIONE;
    }


    /**
     * Sets the IMPORTO_AGGIUDICAZIONE value for this DatiAggiudicazione.
     * 
     * @param IMPORTO_AGGIUDICAZIONE
     */
    public void setIMPORTO_AGGIUDICAZIONE(double IMPORTO_AGGIUDICAZIONE) {
        this.IMPORTO_AGGIUDICAZIONE = IMPORTO_AGGIUDICAZIONE;
    }


    /**
     * Gets the IMPORTO_DISPOSIZIONE value for this DatiAggiudicazione.
     * 
     * @return IMPORTO_DISPOSIZIONE
     */
    public java.lang.Double getIMPORTO_DISPOSIZIONE() {
        return IMPORTO_DISPOSIZIONE;
    }


    /**
     * Sets the IMPORTO_DISPOSIZIONE value for this DatiAggiudicazione.
     * 
     * @param IMPORTO_DISPOSIZIONE
     */
    public void setIMPORTO_DISPOSIZIONE(java.lang.Double IMPORTO_DISPOSIZIONE) {
        this.IMPORTO_DISPOSIZIONE = IMPORTO_DISPOSIZIONE;
    }


    /**
     * Gets the ASTA_ELETTRONICA value for this DatiAggiudicazione.
     * 
     * @return ASTA_ELETTRONICA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getASTA_ELETTRONICA() {
        return ASTA_ELETTRONICA;
    }


    /**
     * Sets the ASTA_ELETTRONICA value for this DatiAggiudicazione.
     * 
     * @param ASTA_ELETTRONICA
     */
    public void setASTA_ELETTRONICA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType ASTA_ELETTRONICA) {
        this.ASTA_ELETTRONICA = ASTA_ELETTRONICA;
    }


    /**
     * Gets the PERC_RIBASSO_AGG value for this DatiAggiudicazione.
     * 
     * @return PERC_RIBASSO_AGG
     */
    public java.lang.Float getPERC_RIBASSO_AGG() {
        return PERC_RIBASSO_AGG;
    }


    /**
     * Sets the PERC_RIBASSO_AGG value for this DatiAggiudicazione.
     * 
     * @param PERC_RIBASSO_AGG
     */
    public void setPERC_RIBASSO_AGG(java.lang.Float PERC_RIBASSO_AGG) {
        this.PERC_RIBASSO_AGG = PERC_RIBASSO_AGG;
    }


    /**
     * Gets the PERC_OFF_AUMENTO value for this DatiAggiudicazione.
     * 
     * @return PERC_OFF_AUMENTO
     */
    public java.lang.Float getPERC_OFF_AUMENTO() {
        return PERC_OFF_AUMENTO;
    }


    /**
     * Sets the PERC_OFF_AUMENTO value for this DatiAggiudicazione.
     * 
     * @param PERC_OFF_AUMENTO
     */
    public void setPERC_OFF_AUMENTO(java.lang.Float PERC_OFF_AUMENTO) {
        this.PERC_OFF_AUMENTO = PERC_OFF_AUMENTO;
    }


    /**
     * Gets the IMPORTO_APPALTO value for this DatiAggiudicazione.
     * 
     * @return IMPORTO_APPALTO
     */
    public java.lang.Double getIMPORTO_APPALTO() {
        return IMPORTO_APPALTO;
    }


    /**
     * Sets the IMPORTO_APPALTO value for this DatiAggiudicazione.
     * 
     * @param IMPORTO_APPALTO
     */
    public void setIMPORTO_APPALTO(java.lang.Double IMPORTO_APPALTO) {
        this.IMPORTO_APPALTO = IMPORTO_APPALTO;
    }


    /**
     * Gets the IMPORTO_INTERVENTO value for this DatiAggiudicazione.
     * 
     * @return IMPORTO_INTERVENTO
     */
    public java.lang.Double getIMPORTO_INTERVENTO() {
        return IMPORTO_INTERVENTO;
    }


    /**
     * Sets the IMPORTO_INTERVENTO value for this DatiAggiudicazione.
     * 
     * @param IMPORTO_INTERVENTO
     */
    public void setIMPORTO_INTERVENTO(java.lang.Double IMPORTO_INTERVENTO) {
        this.IMPORTO_INTERVENTO = IMPORTO_INTERVENTO;
    }


    /**
     * Gets the IMPORTO_NETTO_SIC value for this DatiAggiudicazione.
     * 
     * @return IMPORTO_NETTO_SIC
     */
    public java.lang.Double getIMPORTO_NETTO_SIC() {
        return IMPORTO_NETTO_SIC;
    }


    /**
     * Sets the IMPORTO_NETTO_SIC value for this DatiAggiudicazione.
     * 
     * @param IMPORTO_NETTO_SIC
     */
    public void setIMPORTO_NETTO_SIC(java.lang.Double IMPORTO_NETTO_SIC) {
        this.IMPORTO_NETTO_SIC = IMPORTO_NETTO_SIC;
    }


    /**
     * Gets the PROCEDURA_ACC value for this DatiAggiudicazione.
     * 
     * @return PROCEDURA_ACC
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getPROCEDURA_ACC() {
        return PROCEDURA_ACC;
    }


    /**
     * Sets the PROCEDURA_ACC value for this DatiAggiudicazione.
     * 
     * @param PROCEDURA_ACC
     */
    public void setPROCEDURA_ACC(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType PROCEDURA_ACC) {
        this.PROCEDURA_ACC = PROCEDURA_ACC;
    }


    /**
     * Gets the PREINFORMAZIONE value for this DatiAggiudicazione.
     * 
     * @return PREINFORMAZIONE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getPREINFORMAZIONE() {
        return PREINFORMAZIONE;
    }


    /**
     * Sets the PREINFORMAZIONE value for this DatiAggiudicazione.
     * 
     * @param PREINFORMAZIONE
     */
    public void setPREINFORMAZIONE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType PREINFORMAZIONE) {
        this.PREINFORMAZIONE = PREINFORMAZIONE;
    }


    /**
     * Gets the TERMINE_RIDOTTO value for this DatiAggiudicazione.
     * 
     * @return TERMINE_RIDOTTO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getTERMINE_RIDOTTO() {
        return TERMINE_RIDOTTO;
    }


    /**
     * Sets the TERMINE_RIDOTTO value for this DatiAggiudicazione.
     * 
     * @param TERMINE_RIDOTTO
     */
    public void setTERMINE_RIDOTTO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType TERMINE_RIDOTTO) {
        this.TERMINE_RIDOTTO = TERMINE_RIDOTTO;
    }


    /**
     * Gets the ID_MODO_INDIZIONE value for this DatiAggiudicazione.
     * 
     * @return ID_MODO_INDIZIONE
     */
    public java.lang.String getID_MODO_INDIZIONE() {
        return ID_MODO_INDIZIONE;
    }


    /**
     * Sets the ID_MODO_INDIZIONE value for this DatiAggiudicazione.
     * 
     * @param ID_MODO_INDIZIONE
     */
    public void setID_MODO_INDIZIONE(java.lang.String ID_MODO_INDIZIONE) {
        this.ID_MODO_INDIZIONE = ID_MODO_INDIZIONE;
    }


    /**
     * Gets the NUM_IMPRESE_INVITATE value for this DatiAggiudicazione.
     * 
     * @return NUM_IMPRESE_INVITATE
     */
    public java.lang.Long getNUM_IMPRESE_INVITATE() {
        return NUM_IMPRESE_INVITATE;
    }


    /**
     * Sets the NUM_IMPRESE_INVITATE value for this DatiAggiudicazione.
     * 
     * @param NUM_IMPRESE_INVITATE
     */
    public void setNUM_IMPRESE_INVITATE(java.lang.Long NUM_IMPRESE_INVITATE) {
        this.NUM_IMPRESE_INVITATE = NUM_IMPRESE_INVITATE;
    }


    /**
     * Gets the NUM_IMPRESE_RICHIESTA_INVITO value for this DatiAggiudicazione.
     * 
     * @return NUM_IMPRESE_RICHIESTA_INVITO
     */
    public java.lang.Long getNUM_IMPRESE_RICHIESTA_INVITO() {
        return NUM_IMPRESE_RICHIESTA_INVITO;
    }


    /**
     * Sets the NUM_IMPRESE_RICHIESTA_INVITO value for this DatiAggiudicazione.
     * 
     * @param NUM_IMPRESE_RICHIESTA_INVITO
     */
    public void setNUM_IMPRESE_RICHIESTA_INVITO(java.lang.Long NUM_IMPRESE_RICHIESTA_INVITO) {
        this.NUM_IMPRESE_RICHIESTA_INVITO = NUM_IMPRESE_RICHIESTA_INVITO;
    }


    /**
     * Gets the NUM_IMPRESE_OFFERENTI value for this DatiAggiudicazione.
     * 
     * @return NUM_IMPRESE_OFFERENTI
     */
    public long getNUM_IMPRESE_OFFERENTI() {
        return NUM_IMPRESE_OFFERENTI;
    }


    /**
     * Sets the NUM_IMPRESE_OFFERENTI value for this DatiAggiudicazione.
     * 
     * @param NUM_IMPRESE_OFFERENTI
     */
    public void setNUM_IMPRESE_OFFERENTI(long NUM_IMPRESE_OFFERENTI) {
        this.NUM_IMPRESE_OFFERENTI = NUM_IMPRESE_OFFERENTI;
    }


    /**
     * Gets the NUM_OFFERTE_AMMESSE value for this DatiAggiudicazione.
     * 
     * @return NUM_OFFERTE_AMMESSE
     */
    public long getNUM_OFFERTE_AMMESSE() {
        return NUM_OFFERTE_AMMESSE;
    }


    /**
     * Sets the NUM_OFFERTE_AMMESSE value for this DatiAggiudicazione.
     * 
     * @param NUM_OFFERTE_AMMESSE
     */
    public void setNUM_OFFERTE_AMMESSE(long NUM_OFFERTE_AMMESSE) {
        this.NUM_OFFERTE_AMMESSE = NUM_OFFERTE_AMMESSE;
    }


    /**
     * Gets the DATA_SCADENZA_RICHIESTA_INVITO value for this DatiAggiudicazione.
     * 
     * @return DATA_SCADENZA_RICHIESTA_INVITO
     */
    public java.util.Calendar getDATA_SCADENZA_RICHIESTA_INVITO() {
        return DATA_SCADENZA_RICHIESTA_INVITO;
    }


    /**
     * Sets the DATA_SCADENZA_RICHIESTA_INVITO value for this DatiAggiudicazione.
     * 
     * @param DATA_SCADENZA_RICHIESTA_INVITO
     */
    public void setDATA_SCADENZA_RICHIESTA_INVITO(java.util.Calendar DATA_SCADENZA_RICHIESTA_INVITO) {
        this.DATA_SCADENZA_RICHIESTA_INVITO = DATA_SCADENZA_RICHIESTA_INVITO;
    }


    /**
     * Gets the DATA_SCADENZA_PRES_OFFERTA value for this DatiAggiudicazione.
     * 
     * @return DATA_SCADENZA_PRES_OFFERTA
     */
    public java.util.Calendar getDATA_SCADENZA_PRES_OFFERTA() {
        return DATA_SCADENZA_PRES_OFFERTA;
    }


    /**
     * Sets the DATA_SCADENZA_PRES_OFFERTA value for this DatiAggiudicazione.
     * 
     * @param DATA_SCADENZA_PRES_OFFERTA
     */
    public void setDATA_SCADENZA_PRES_OFFERTA(java.util.Calendar DATA_SCADENZA_PRES_OFFERTA) {
        this.DATA_SCADENZA_PRES_OFFERTA = DATA_SCADENZA_PRES_OFFERTA;
    }


    /**
     * Gets the IMPORTO_LAVORI value for this DatiAggiudicazione.
     * 
     * @return IMPORTO_LAVORI
     */
    public java.lang.Double getIMPORTO_LAVORI() {
        return IMPORTO_LAVORI;
    }


    /**
     * Sets the IMPORTO_LAVORI value for this DatiAggiudicazione.
     * 
     * @param IMPORTO_LAVORI
     */
    public void setIMPORTO_LAVORI(java.lang.Double IMPORTO_LAVORI) {
        this.IMPORTO_LAVORI = IMPORTO_LAVORI;
    }


    /**
     * Gets the IMPORTO_SERVIZI value for this DatiAggiudicazione.
     * 
     * @return IMPORTO_SERVIZI
     */
    public java.lang.Double getIMPORTO_SERVIZI() {
        return IMPORTO_SERVIZI;
    }


    /**
     * Sets the IMPORTO_SERVIZI value for this DatiAggiudicazione.
     * 
     * @param IMPORTO_SERVIZI
     */
    public void setIMPORTO_SERVIZI(java.lang.Double IMPORTO_SERVIZI) {
        this.IMPORTO_SERVIZI = IMPORTO_SERVIZI;
    }


    /**
     * Gets the IMPORTO_FORNITURE value for this DatiAggiudicazione.
     * 
     * @return IMPORTO_FORNITURE
     */
    public java.lang.Double getIMPORTO_FORNITURE() {
        return IMPORTO_FORNITURE;
    }


    /**
     * Sets the IMPORTO_FORNITURE value for this DatiAggiudicazione.
     * 
     * @param IMPORTO_FORNITURE
     */
    public void setIMPORTO_FORNITURE(java.lang.Double IMPORTO_FORNITURE) {
        this.IMPORTO_FORNITURE = IMPORTO_FORNITURE;
    }


    /**
     * Gets the IMPORTO_ATTUAZIONE_SICUREZZA value for this DatiAggiudicazione.
     * 
     * @return IMPORTO_ATTUAZIONE_SICUREZZA
     */
    public java.lang.Double getIMPORTO_ATTUAZIONE_SICUREZZA() {
        return IMPORTO_ATTUAZIONE_SICUREZZA;
    }


    /**
     * Sets the IMPORTO_ATTUAZIONE_SICUREZZA value for this DatiAggiudicazione.
     * 
     * @param IMPORTO_ATTUAZIONE_SICUREZZA
     */
    public void setIMPORTO_ATTUAZIONE_SICUREZZA(java.lang.Double IMPORTO_ATTUAZIONE_SICUREZZA) {
        this.IMPORTO_ATTUAZIONE_SICUREZZA = IMPORTO_ATTUAZIONE_SICUREZZA;
    }


    /**
     * Gets the IMPORTO_PROGETTAZIONE value for this DatiAggiudicazione.
     * 
     * @return IMPORTO_PROGETTAZIONE
     */
    public java.lang.Double getIMPORTO_PROGETTAZIONE() {
        return IMPORTO_PROGETTAZIONE;
    }


    /**
     * Sets the IMPORTO_PROGETTAZIONE value for this DatiAggiudicazione.
     * 
     * @param IMPORTO_PROGETTAZIONE
     */
    public void setIMPORTO_PROGETTAZIONE(java.lang.Double IMPORTO_PROGETTAZIONE) {
        this.IMPORTO_PROGETTAZIONE = IMPORTO_PROGETTAZIONE;
    }


    /**
     * Gets the REQUISITI_SS value for this DatiAggiudicazione.
     * 
     * @return REQUISITI_SS
     */
    public java.lang.String getREQUISITI_SS() {
        return REQUISITI_SS;
    }


    /**
     * Sets the REQUISITI_SS value for this DatiAggiudicazione.
     * 
     * @param REQUISITI_SS
     */
    public void setREQUISITI_SS(java.lang.String REQUISITI_SS) {
        this.REQUISITI_SS = REQUISITI_SS;
    }


    /**
     * Gets the FLAG_AQ value for this DatiAggiudicazione.
     * 
     * @return FLAG_AQ
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_AQ() {
        return FLAG_AQ;
    }


    /**
     * Sets the FLAG_AQ value for this DatiAggiudicazione.
     * 
     * @param FLAG_AQ
     */
    public void setFLAG_AQ(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_AQ) {
        this.FLAG_AQ = FLAG_AQ;
    }


    /**
     * Gets the DATA_INVITO value for this DatiAggiudicazione.
     * 
     * @return DATA_INVITO
     */
    public java.util.Calendar getDATA_INVITO() {
        return DATA_INVITO;
    }


    /**
     * Sets the DATA_INVITO value for this DatiAggiudicazione.
     * 
     * @param DATA_INVITO
     */
    public void setDATA_INVITO(java.util.Calendar DATA_INVITO) {
        this.DATA_INVITO = DATA_INVITO;
    }


    /**
     * Gets the NUM_MANIF_INTERESSE value for this DatiAggiudicazione.
     * 
     * @return NUM_MANIF_INTERESSE
     */
    public java.lang.Long getNUM_MANIF_INTERESSE() {
        return NUM_MANIF_INTERESSE;
    }


    /**
     * Sets the NUM_MANIF_INTERESSE value for this DatiAggiudicazione.
     * 
     * @param NUM_MANIF_INTERESSE
     */
    public void setNUM_MANIF_INTERESSE(java.lang.Long NUM_MANIF_INTERESSE) {
        this.NUM_MANIF_INTERESSE = NUM_MANIF_INTERESSE;
    }


    /**
     * Gets the DATA_MANIF_INTERESSE value for this DatiAggiudicazione.
     * 
     * @return DATA_MANIF_INTERESSE
     */
    public java.util.Calendar getDATA_MANIF_INTERESSE() {
        return DATA_MANIF_INTERESSE;
    }


    /**
     * Sets the DATA_MANIF_INTERESSE value for this DatiAggiudicazione.
     * 
     * @param DATA_MANIF_INTERESSE
     */
    public void setDATA_MANIF_INTERESSE(java.util.Calendar DATA_MANIF_INTERESSE) {
        this.DATA_MANIF_INTERESSE = DATA_MANIF_INTERESSE;
    }


    /**
     * Gets the FLAG_RICH_SUBAPPALTO value for this DatiAggiudicazione.
     * 
     * @return FLAG_RICH_SUBAPPALTO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_RICH_SUBAPPALTO() {
        return FLAG_RICH_SUBAPPALTO;
    }


    /**
     * Sets the FLAG_RICH_SUBAPPALTO value for this DatiAggiudicazione.
     * 
     * @param FLAG_RICH_SUBAPPALTO
     */
    public void setFLAG_RICH_SUBAPPALTO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_RICH_SUBAPPALTO) {
        this.FLAG_RICH_SUBAPPALTO = FLAG_RICH_SUBAPPALTO;
    }


    /**
     * Gets the NUM_OFFERTE_ESCLUSE value for this DatiAggiudicazione.
     * 
     * @return NUM_OFFERTE_ESCLUSE
     */
    public java.lang.Long getNUM_OFFERTE_ESCLUSE() {
        return NUM_OFFERTE_ESCLUSE;
    }


    /**
     * Sets the NUM_OFFERTE_ESCLUSE value for this DatiAggiudicazione.
     * 
     * @param NUM_OFFERTE_ESCLUSE
     */
    public void setNUM_OFFERTE_ESCLUSE(java.lang.Long NUM_OFFERTE_ESCLUSE) {
        this.NUM_OFFERTE_ESCLUSE = NUM_OFFERTE_ESCLUSE;
    }


    /**
     * Gets the OFFERTA_MASSIMO value for this DatiAggiudicazione.
     * 
     * @return OFFERTA_MASSIMO
     */
    public java.lang.Float getOFFERTA_MASSIMO() {
        return OFFERTA_MASSIMO;
    }


    /**
     * Sets the OFFERTA_MASSIMO value for this DatiAggiudicazione.
     * 
     * @param OFFERTA_MASSIMO
     */
    public void setOFFERTA_MASSIMO(java.lang.Float OFFERTA_MASSIMO) {
        this.OFFERTA_MASSIMO = OFFERTA_MASSIMO;
    }


    /**
     * Gets the OFFERTA_MINIMA value for this DatiAggiudicazione.
     * 
     * @return OFFERTA_MINIMA
     */
    public java.lang.Float getOFFERTA_MINIMA() {
        return OFFERTA_MINIMA;
    }


    /**
     * Sets the OFFERTA_MINIMA value for this DatiAggiudicazione.
     * 
     * @param OFFERTA_MINIMA
     */
    public void setOFFERTA_MINIMA(java.lang.Float OFFERTA_MINIMA) {
        this.OFFERTA_MINIMA = OFFERTA_MINIMA;
    }


    /**
     * Gets the VAL_SOGLIA_ANOMALIA value for this DatiAggiudicazione.
     * 
     * @return VAL_SOGLIA_ANOMALIA
     */
    public java.lang.Float getVAL_SOGLIA_ANOMALIA() {
        return VAL_SOGLIA_ANOMALIA;
    }


    /**
     * Sets the VAL_SOGLIA_ANOMALIA value for this DatiAggiudicazione.
     * 
     * @param VAL_SOGLIA_ANOMALIA
     */
    public void setVAL_SOGLIA_ANOMALIA(java.lang.Float VAL_SOGLIA_ANOMALIA) {
        this.VAL_SOGLIA_ANOMALIA = VAL_SOGLIA_ANOMALIA;
    }


    /**
     * Gets the NUM_OFFERTE_FUORI_SOGLIA value for this DatiAggiudicazione.
     * 
     * @return NUM_OFFERTE_FUORI_SOGLIA
     */
    public java.lang.Long getNUM_OFFERTE_FUORI_SOGLIA() {
        return NUM_OFFERTE_FUORI_SOGLIA;
    }


    /**
     * Sets the NUM_OFFERTE_FUORI_SOGLIA value for this DatiAggiudicazione.
     * 
     * @param NUM_OFFERTE_FUORI_SOGLIA
     */
    public void setNUM_OFFERTE_FUORI_SOGLIA(java.lang.Long NUM_OFFERTE_FUORI_SOGLIA) {
        this.NUM_OFFERTE_FUORI_SOGLIA = NUM_OFFERTE_FUORI_SOGLIA;
    }


    /**
     * Gets the NUM_IMP_ESCL_INSUF_GIUST value for this DatiAggiudicazione.
     * 
     * @return NUM_IMP_ESCL_INSUF_GIUST
     */
    public java.lang.Long getNUM_IMP_ESCL_INSUF_GIUST() {
        return NUM_IMP_ESCL_INSUF_GIUST;
    }


    /**
     * Sets the NUM_IMP_ESCL_INSUF_GIUST value for this DatiAggiudicazione.
     * 
     * @param NUM_IMP_ESCL_INSUF_GIUST
     */
    public void setNUM_IMP_ESCL_INSUF_GIUST(java.lang.Long NUM_IMP_ESCL_INSUF_GIUST) {
        this.NUM_IMP_ESCL_INSUF_GIUST = NUM_IMP_ESCL_INSUF_GIUST;
    }


    /**
     * Gets the COD_STRUMENTO value for this DatiAggiudicazione.
     * 
     * @return COD_STRUMENTO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoStrumentoType getCOD_STRUMENTO() {
        return COD_STRUMENTO;
    }


    /**
     * Sets the COD_STRUMENTO value for this DatiAggiudicazione.
     * 
     * @param COD_STRUMENTO
     */
    public void setCOD_STRUMENTO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.TipoStrumentoType COD_STRUMENTO) {
        this.COD_STRUMENTO = COD_STRUMENTO;
    }


    /**
     * Gets the IMP_NON_ASSOG value for this DatiAggiudicazione.
     * 
     * @return IMP_NON_ASSOG
     */
    public java.lang.Double getIMP_NON_ASSOG() {
        return IMP_NON_ASSOG;
    }


    /**
     * Sets the IMP_NON_ASSOG value for this DatiAggiudicazione.
     * 
     * @param IMP_NON_ASSOG
     */
    public void setIMP_NON_ASSOG(java.lang.Double IMP_NON_ASSOG) {
        this.IMP_NON_ASSOG = IMP_NON_ASSOG;
    }


    /**
     * Gets the MODALITA_RIAGGIUDICAZIONE value for this DatiAggiudicazione.
     * 
     * @return MODALITA_RIAGGIUDICAZIONE
     */
    public java.lang.String getMODALITA_RIAGGIUDICAZIONE() {
        return MODALITA_RIAGGIUDICAZIONE;
    }


    /**
     * Sets the MODALITA_RIAGGIUDICAZIONE value for this DatiAggiudicazione.
     * 
     * @param MODALITA_RIAGGIUDICAZIONE
     */
    public void setMODALITA_RIAGGIUDICAZIONE(java.lang.String MODALITA_RIAGGIUDICAZIONE) {
        this.MODALITA_RIAGGIUDICAZIONE = MODALITA_RIAGGIUDICAZIONE;
    }


    /**
     * Gets the DURATA_AQ value for this DatiAggiudicazione.
     * 
     * @return DURATA_AQ
     */
    public java.lang.Long getDURATA_AQ() {
        return DURATA_AQ;
    }


    /**
     * Sets the DURATA_AQ value for this DatiAggiudicazione.
     * 
     * @param DURATA_AQ
     */
    public void setDURATA_AQ(java.lang.Long DURATA_AQ) {
        this.DURATA_AQ = DURATA_AQ;
    }


    /**
     * Gets the OPERE_URBANIZ_SCOMPUTO value for this DatiAggiudicazione.
     * 
     * @return OPERE_URBANIZ_SCOMPUTO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getOPERE_URBANIZ_SCOMPUTO() {
        return OPERE_URBANIZ_SCOMPUTO;
    }


    /**
     * Sets the OPERE_URBANIZ_SCOMPUTO value for this DatiAggiudicazione.
     * 
     * @param OPERE_URBANIZ_SCOMPUTO
     */
    public void setOPERE_URBANIZ_SCOMPUTO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType OPERE_URBANIZ_SCOMPUTO) {
        this.OPERE_URBANIZ_SCOMPUTO = OPERE_URBANIZ_SCOMPUTO;
    }


    /**
     * Gets the TIPO_ATTO value for this DatiAggiudicazione.
     * 
     * @return TIPO_ATTO
     */
    public java.lang.String getTIPO_ATTO() {
        return TIPO_ATTO;
    }


    /**
     * Sets the TIPO_ATTO value for this DatiAggiudicazione.
     * 
     * @param TIPO_ATTO
     */
    public void setTIPO_ATTO(java.lang.String TIPO_ATTO) {
        this.TIPO_ATTO = TIPO_ATTO;
    }


    /**
     * Gets the DATA_ATTO value for this DatiAggiudicazione.
     * 
     * @return DATA_ATTO
     */
    public java.util.Calendar getDATA_ATTO() {
        return DATA_ATTO;
    }


    /**
     * Sets the DATA_ATTO value for this DatiAggiudicazione.
     * 
     * @param DATA_ATTO
     */
    public void setDATA_ATTO(java.util.Calendar DATA_ATTO) {
        this.DATA_ATTO = DATA_ATTO;
    }


    /**
     * Gets the NUM_ATTO value for this DatiAggiudicazione.
     * 
     * @return NUM_ATTO
     */
    public java.lang.String getNUM_ATTO() {
        return NUM_ATTO;
    }


    /**
     * Sets the NUM_ATTO value for this DatiAggiudicazione.
     * 
     * @param NUM_ATTO
     */
    public void setNUM_ATTO(java.lang.String NUM_ATTO) {
        this.NUM_ATTO = NUM_ATTO;
    }


    /**
     * Gets the PERC_IVA value for this DatiAggiudicazione.
     * 
     * @return PERC_IVA
     */
    public java.lang.Float getPERC_IVA() {
        return PERC_IVA;
    }


    /**
     * Sets the PERC_IVA value for this DatiAggiudicazione.
     * 
     * @param PERC_IVA
     */
    public void setPERC_IVA(java.lang.Float PERC_IVA) {
        this.PERC_IVA = PERC_IVA;
    }


    /**
     * Gets the IMPORTO_IVA value for this DatiAggiudicazione.
     * 
     * @return IMPORTO_IVA
     */
    public java.lang.Double getIMPORTO_IVA() {
        return IMPORTO_IVA;
    }


    /**
     * Sets the IMPORTO_IVA value for this DatiAggiudicazione.
     * 
     * @param IMPORTO_IVA
     */
    public void setIMPORTO_IVA(java.lang.Double IMPORTO_IVA) {
        this.IMPORTO_IVA = IMPORTO_IVA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatiAggiudicazione)) return false;
        DatiAggiudicazione other = (DatiAggiudicazione) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.FIN_REGIONALE==null && other.getFIN_REGIONALE()==null) || 
             (this.FIN_REGIONALE!=null &&
              this.FIN_REGIONALE.equals(other.getFIN_REGIONALE()))) &&
            ((this.FLAG_IMPORTI==null && other.getFLAG_IMPORTI()==null) || 
             (this.FLAG_IMPORTI!=null &&
              this.FLAG_IMPORTI.equals(other.getFLAG_IMPORTI()))) &&
            ((this.FLAG_SICUREZZA==null && other.getFLAG_SICUREZZA()==null) || 
             (this.FLAG_SICUREZZA!=null &&
              this.FLAG_SICUREZZA.equals(other.getFLAG_SICUREZZA()))) &&
            ((this.FLAG_LIVELLO_PROGETTUALE==null && other.getFLAG_LIVELLO_PROGETTUALE()==null) || 
             (this.FLAG_LIVELLO_PROGETTUALE!=null &&
              this.FLAG_LIVELLO_PROGETTUALE.equals(other.getFLAG_LIVELLO_PROGETTUALE()))) &&
            ((this.VERIFICA_CAMPIONE==null && other.getVERIFICA_CAMPIONE()==null) || 
             (this.VERIFICA_CAMPIONE!=null &&
              this.VERIFICA_CAMPIONE.equals(other.getVERIFICA_CAMPIONE()))) &&
            ((this.DATA_VERB_AGGIUDICAZIONE==null && other.getDATA_VERB_AGGIUDICAZIONE()==null) || 
             (this.DATA_VERB_AGGIUDICAZIONE!=null &&
              this.DATA_VERB_AGGIUDICAZIONE.equals(other.getDATA_VERB_AGGIUDICAZIONE()))) &&
            this.IMPORTO_AGGIUDICAZIONE == other.getIMPORTO_AGGIUDICAZIONE() &&
            ((this.IMPORTO_DISPOSIZIONE==null && other.getIMPORTO_DISPOSIZIONE()==null) || 
             (this.IMPORTO_DISPOSIZIONE!=null &&
              this.IMPORTO_DISPOSIZIONE.equals(other.getIMPORTO_DISPOSIZIONE()))) &&
            ((this.ASTA_ELETTRONICA==null && other.getASTA_ELETTRONICA()==null) || 
             (this.ASTA_ELETTRONICA!=null &&
              this.ASTA_ELETTRONICA.equals(other.getASTA_ELETTRONICA()))) &&
            ((this.PERC_RIBASSO_AGG==null && other.getPERC_RIBASSO_AGG()==null) || 
             (this.PERC_RIBASSO_AGG!=null &&
              this.PERC_RIBASSO_AGG.equals(other.getPERC_RIBASSO_AGG()))) &&
            ((this.PERC_OFF_AUMENTO==null && other.getPERC_OFF_AUMENTO()==null) || 
             (this.PERC_OFF_AUMENTO!=null &&
              this.PERC_OFF_AUMENTO.equals(other.getPERC_OFF_AUMENTO()))) &&
            ((this.IMPORTO_APPALTO==null && other.getIMPORTO_APPALTO()==null) || 
             (this.IMPORTO_APPALTO!=null &&
              this.IMPORTO_APPALTO.equals(other.getIMPORTO_APPALTO()))) &&
            ((this.IMPORTO_INTERVENTO==null && other.getIMPORTO_INTERVENTO()==null) || 
             (this.IMPORTO_INTERVENTO!=null &&
              this.IMPORTO_INTERVENTO.equals(other.getIMPORTO_INTERVENTO()))) &&
            ((this.IMPORTO_NETTO_SIC==null && other.getIMPORTO_NETTO_SIC()==null) || 
             (this.IMPORTO_NETTO_SIC!=null &&
              this.IMPORTO_NETTO_SIC.equals(other.getIMPORTO_NETTO_SIC()))) &&
            ((this.PROCEDURA_ACC==null && other.getPROCEDURA_ACC()==null) || 
             (this.PROCEDURA_ACC!=null &&
              this.PROCEDURA_ACC.equals(other.getPROCEDURA_ACC()))) &&
            ((this.PREINFORMAZIONE==null && other.getPREINFORMAZIONE()==null) || 
             (this.PREINFORMAZIONE!=null &&
              this.PREINFORMAZIONE.equals(other.getPREINFORMAZIONE()))) &&
            ((this.TERMINE_RIDOTTO==null && other.getTERMINE_RIDOTTO()==null) || 
             (this.TERMINE_RIDOTTO!=null &&
              this.TERMINE_RIDOTTO.equals(other.getTERMINE_RIDOTTO()))) &&
            ((this.ID_MODO_INDIZIONE==null && other.getID_MODO_INDIZIONE()==null) || 
             (this.ID_MODO_INDIZIONE!=null &&
              this.ID_MODO_INDIZIONE.equals(other.getID_MODO_INDIZIONE()))) &&
            ((this.NUM_IMPRESE_INVITATE==null && other.getNUM_IMPRESE_INVITATE()==null) || 
             (this.NUM_IMPRESE_INVITATE!=null &&
              this.NUM_IMPRESE_INVITATE.equals(other.getNUM_IMPRESE_INVITATE()))) &&
            ((this.NUM_IMPRESE_RICHIESTA_INVITO==null && other.getNUM_IMPRESE_RICHIESTA_INVITO()==null) || 
             (this.NUM_IMPRESE_RICHIESTA_INVITO!=null &&
              this.NUM_IMPRESE_RICHIESTA_INVITO.equals(other.getNUM_IMPRESE_RICHIESTA_INVITO()))) &&
            this.NUM_IMPRESE_OFFERENTI == other.getNUM_IMPRESE_OFFERENTI() &&
            this.NUM_OFFERTE_AMMESSE == other.getNUM_OFFERTE_AMMESSE() &&
            ((this.DATA_SCADENZA_RICHIESTA_INVITO==null && other.getDATA_SCADENZA_RICHIESTA_INVITO()==null) || 
             (this.DATA_SCADENZA_RICHIESTA_INVITO!=null &&
              this.DATA_SCADENZA_RICHIESTA_INVITO.equals(other.getDATA_SCADENZA_RICHIESTA_INVITO()))) &&
            ((this.DATA_SCADENZA_PRES_OFFERTA==null && other.getDATA_SCADENZA_PRES_OFFERTA()==null) || 
             (this.DATA_SCADENZA_PRES_OFFERTA!=null &&
              this.DATA_SCADENZA_PRES_OFFERTA.equals(other.getDATA_SCADENZA_PRES_OFFERTA()))) &&
            ((this.IMPORTO_LAVORI==null && other.getIMPORTO_LAVORI()==null) || 
             (this.IMPORTO_LAVORI!=null &&
              this.IMPORTO_LAVORI.equals(other.getIMPORTO_LAVORI()))) &&
            ((this.IMPORTO_SERVIZI==null && other.getIMPORTO_SERVIZI()==null) || 
             (this.IMPORTO_SERVIZI!=null &&
              this.IMPORTO_SERVIZI.equals(other.getIMPORTO_SERVIZI()))) &&
            ((this.IMPORTO_FORNITURE==null && other.getIMPORTO_FORNITURE()==null) || 
             (this.IMPORTO_FORNITURE!=null &&
              this.IMPORTO_FORNITURE.equals(other.getIMPORTO_FORNITURE()))) &&
            ((this.IMPORTO_ATTUAZIONE_SICUREZZA==null && other.getIMPORTO_ATTUAZIONE_SICUREZZA()==null) || 
             (this.IMPORTO_ATTUAZIONE_SICUREZZA!=null &&
              this.IMPORTO_ATTUAZIONE_SICUREZZA.equals(other.getIMPORTO_ATTUAZIONE_SICUREZZA()))) &&
            ((this.IMPORTO_PROGETTAZIONE==null && other.getIMPORTO_PROGETTAZIONE()==null) || 
             (this.IMPORTO_PROGETTAZIONE!=null &&
              this.IMPORTO_PROGETTAZIONE.equals(other.getIMPORTO_PROGETTAZIONE()))) &&
            ((this.REQUISITI_SS==null && other.getREQUISITI_SS()==null) || 
             (this.REQUISITI_SS!=null &&
              this.REQUISITI_SS.equals(other.getREQUISITI_SS()))) &&
            ((this.FLAG_AQ==null && other.getFLAG_AQ()==null) || 
             (this.FLAG_AQ!=null &&
              this.FLAG_AQ.equals(other.getFLAG_AQ()))) &&
            ((this.DATA_INVITO==null && other.getDATA_INVITO()==null) || 
             (this.DATA_INVITO!=null &&
              this.DATA_INVITO.equals(other.getDATA_INVITO()))) &&
            ((this.NUM_MANIF_INTERESSE==null && other.getNUM_MANIF_INTERESSE()==null) || 
             (this.NUM_MANIF_INTERESSE!=null &&
              this.NUM_MANIF_INTERESSE.equals(other.getNUM_MANIF_INTERESSE()))) &&
            ((this.DATA_MANIF_INTERESSE==null && other.getDATA_MANIF_INTERESSE()==null) || 
             (this.DATA_MANIF_INTERESSE!=null &&
              this.DATA_MANIF_INTERESSE.equals(other.getDATA_MANIF_INTERESSE()))) &&
            ((this.FLAG_RICH_SUBAPPALTO==null && other.getFLAG_RICH_SUBAPPALTO()==null) || 
             (this.FLAG_RICH_SUBAPPALTO!=null &&
              this.FLAG_RICH_SUBAPPALTO.equals(other.getFLAG_RICH_SUBAPPALTO()))) &&
            ((this.NUM_OFFERTE_ESCLUSE==null && other.getNUM_OFFERTE_ESCLUSE()==null) || 
             (this.NUM_OFFERTE_ESCLUSE!=null &&
              this.NUM_OFFERTE_ESCLUSE.equals(other.getNUM_OFFERTE_ESCLUSE()))) &&
            ((this.OFFERTA_MASSIMO==null && other.getOFFERTA_MASSIMO()==null) || 
             (this.OFFERTA_MASSIMO!=null &&
              this.OFFERTA_MASSIMO.equals(other.getOFFERTA_MASSIMO()))) &&
            ((this.OFFERTA_MINIMA==null && other.getOFFERTA_MINIMA()==null) || 
             (this.OFFERTA_MINIMA!=null &&
              this.OFFERTA_MINIMA.equals(other.getOFFERTA_MINIMA()))) &&
            ((this.VAL_SOGLIA_ANOMALIA==null && other.getVAL_SOGLIA_ANOMALIA()==null) || 
             (this.VAL_SOGLIA_ANOMALIA!=null &&
              this.VAL_SOGLIA_ANOMALIA.equals(other.getVAL_SOGLIA_ANOMALIA()))) &&
            ((this.NUM_OFFERTE_FUORI_SOGLIA==null && other.getNUM_OFFERTE_FUORI_SOGLIA()==null) || 
             (this.NUM_OFFERTE_FUORI_SOGLIA!=null &&
              this.NUM_OFFERTE_FUORI_SOGLIA.equals(other.getNUM_OFFERTE_FUORI_SOGLIA()))) &&
            ((this.NUM_IMP_ESCL_INSUF_GIUST==null && other.getNUM_IMP_ESCL_INSUF_GIUST()==null) || 
             (this.NUM_IMP_ESCL_INSUF_GIUST!=null &&
              this.NUM_IMP_ESCL_INSUF_GIUST.equals(other.getNUM_IMP_ESCL_INSUF_GIUST()))) &&
            ((this.COD_STRUMENTO==null && other.getCOD_STRUMENTO()==null) || 
             (this.COD_STRUMENTO!=null &&
              this.COD_STRUMENTO.equals(other.getCOD_STRUMENTO()))) &&
            ((this.IMP_NON_ASSOG==null && other.getIMP_NON_ASSOG()==null) || 
             (this.IMP_NON_ASSOG!=null &&
              this.IMP_NON_ASSOG.equals(other.getIMP_NON_ASSOG()))) &&
            ((this.MODALITA_RIAGGIUDICAZIONE==null && other.getMODALITA_RIAGGIUDICAZIONE()==null) || 
             (this.MODALITA_RIAGGIUDICAZIONE!=null &&
              this.MODALITA_RIAGGIUDICAZIONE.equals(other.getMODALITA_RIAGGIUDICAZIONE()))) &&
            ((this.DURATA_AQ==null && other.getDURATA_AQ()==null) || 
             (this.DURATA_AQ!=null &&
              this.DURATA_AQ.equals(other.getDURATA_AQ()))) &&
            ((this.OPERE_URBANIZ_SCOMPUTO==null && other.getOPERE_URBANIZ_SCOMPUTO()==null) || 
             (this.OPERE_URBANIZ_SCOMPUTO!=null &&
              this.OPERE_URBANIZ_SCOMPUTO.equals(other.getOPERE_URBANIZ_SCOMPUTO()))) &&
            ((this.TIPO_ATTO==null && other.getTIPO_ATTO()==null) || 
             (this.TIPO_ATTO!=null &&
              this.TIPO_ATTO.equals(other.getTIPO_ATTO()))) &&
            ((this.DATA_ATTO==null && other.getDATA_ATTO()==null) || 
             (this.DATA_ATTO!=null &&
              this.DATA_ATTO.equals(other.getDATA_ATTO()))) &&
            ((this.NUM_ATTO==null && other.getNUM_ATTO()==null) || 
             (this.NUM_ATTO!=null &&
              this.NUM_ATTO.equals(other.getNUM_ATTO()))) &&
            ((this.PERC_IVA==null && other.getPERC_IVA()==null) || 
             (this.PERC_IVA!=null &&
              this.PERC_IVA.equals(other.getPERC_IVA()))) &&
            ((this.IMPORTO_IVA==null && other.getIMPORTO_IVA()==null) || 
             (this.IMPORTO_IVA!=null &&
              this.IMPORTO_IVA.equals(other.getIMPORTO_IVA())));
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
        if (getFIN_REGIONALE() != null) {
            _hashCode += getFIN_REGIONALE().hashCode();
        }
        if (getFLAG_IMPORTI() != null) {
            _hashCode += getFLAG_IMPORTI().hashCode();
        }
        if (getFLAG_SICUREZZA() != null) {
            _hashCode += getFLAG_SICUREZZA().hashCode();
        }
        if (getFLAG_LIVELLO_PROGETTUALE() != null) {
            _hashCode += getFLAG_LIVELLO_PROGETTUALE().hashCode();
        }
        if (getVERIFICA_CAMPIONE() != null) {
            _hashCode += getVERIFICA_CAMPIONE().hashCode();
        }
        if (getDATA_VERB_AGGIUDICAZIONE() != null) {
            _hashCode += getDATA_VERB_AGGIUDICAZIONE().hashCode();
        }
        _hashCode += new Double(getIMPORTO_AGGIUDICAZIONE()).hashCode();
        if (getIMPORTO_DISPOSIZIONE() != null) {
            _hashCode += getIMPORTO_DISPOSIZIONE().hashCode();
        }
        if (getASTA_ELETTRONICA() != null) {
            _hashCode += getASTA_ELETTRONICA().hashCode();
        }
        if (getPERC_RIBASSO_AGG() != null) {
            _hashCode += getPERC_RIBASSO_AGG().hashCode();
        }
        if (getPERC_OFF_AUMENTO() != null) {
            _hashCode += getPERC_OFF_AUMENTO().hashCode();
        }
        if (getIMPORTO_APPALTO() != null) {
            _hashCode += getIMPORTO_APPALTO().hashCode();
        }
        if (getIMPORTO_INTERVENTO() != null) {
            _hashCode += getIMPORTO_INTERVENTO().hashCode();
        }
        if (getIMPORTO_NETTO_SIC() != null) {
            _hashCode += getIMPORTO_NETTO_SIC().hashCode();
        }
        if (getPROCEDURA_ACC() != null) {
            _hashCode += getPROCEDURA_ACC().hashCode();
        }
        if (getPREINFORMAZIONE() != null) {
            _hashCode += getPREINFORMAZIONE().hashCode();
        }
        if (getTERMINE_RIDOTTO() != null) {
            _hashCode += getTERMINE_RIDOTTO().hashCode();
        }
        if (getID_MODO_INDIZIONE() != null) {
            _hashCode += getID_MODO_INDIZIONE().hashCode();
        }
        if (getNUM_IMPRESE_INVITATE() != null) {
            _hashCode += getNUM_IMPRESE_INVITATE().hashCode();
        }
        if (getNUM_IMPRESE_RICHIESTA_INVITO() != null) {
            _hashCode += getNUM_IMPRESE_RICHIESTA_INVITO().hashCode();
        }
        _hashCode += new Long(getNUM_IMPRESE_OFFERENTI()).hashCode();
        _hashCode += new Long(getNUM_OFFERTE_AMMESSE()).hashCode();
        if (getDATA_SCADENZA_RICHIESTA_INVITO() != null) {
            _hashCode += getDATA_SCADENZA_RICHIESTA_INVITO().hashCode();
        }
        if (getDATA_SCADENZA_PRES_OFFERTA() != null) {
            _hashCode += getDATA_SCADENZA_PRES_OFFERTA().hashCode();
        }
        if (getIMPORTO_LAVORI() != null) {
            _hashCode += getIMPORTO_LAVORI().hashCode();
        }
        if (getIMPORTO_SERVIZI() != null) {
            _hashCode += getIMPORTO_SERVIZI().hashCode();
        }
        if (getIMPORTO_FORNITURE() != null) {
            _hashCode += getIMPORTO_FORNITURE().hashCode();
        }
        if (getIMPORTO_ATTUAZIONE_SICUREZZA() != null) {
            _hashCode += getIMPORTO_ATTUAZIONE_SICUREZZA().hashCode();
        }
        if (getIMPORTO_PROGETTAZIONE() != null) {
            _hashCode += getIMPORTO_PROGETTAZIONE().hashCode();
        }
        if (getREQUISITI_SS() != null) {
            _hashCode += getREQUISITI_SS().hashCode();
        }
        if (getFLAG_AQ() != null) {
            _hashCode += getFLAG_AQ().hashCode();
        }
        if (getDATA_INVITO() != null) {
            _hashCode += getDATA_INVITO().hashCode();
        }
        if (getNUM_MANIF_INTERESSE() != null) {
            _hashCode += getNUM_MANIF_INTERESSE().hashCode();
        }
        if (getDATA_MANIF_INTERESSE() != null) {
            _hashCode += getDATA_MANIF_INTERESSE().hashCode();
        }
        if (getFLAG_RICH_SUBAPPALTO() != null) {
            _hashCode += getFLAG_RICH_SUBAPPALTO().hashCode();
        }
        if (getNUM_OFFERTE_ESCLUSE() != null) {
            _hashCode += getNUM_OFFERTE_ESCLUSE().hashCode();
        }
        if (getOFFERTA_MASSIMO() != null) {
            _hashCode += getOFFERTA_MASSIMO().hashCode();
        }
        if (getOFFERTA_MINIMA() != null) {
            _hashCode += getOFFERTA_MINIMA().hashCode();
        }
        if (getVAL_SOGLIA_ANOMALIA() != null) {
            _hashCode += getVAL_SOGLIA_ANOMALIA().hashCode();
        }
        if (getNUM_OFFERTE_FUORI_SOGLIA() != null) {
            _hashCode += getNUM_OFFERTE_FUORI_SOGLIA().hashCode();
        }
        if (getNUM_IMP_ESCL_INSUF_GIUST() != null) {
            _hashCode += getNUM_IMP_ESCL_INSUF_GIUST().hashCode();
        }
        if (getCOD_STRUMENTO() != null) {
            _hashCode += getCOD_STRUMENTO().hashCode();
        }
        if (getIMP_NON_ASSOG() != null) {
            _hashCode += getIMP_NON_ASSOG().hashCode();
        }
        if (getMODALITA_RIAGGIUDICAZIONE() != null) {
            _hashCode += getMODALITA_RIAGGIUDICAZIONE().hashCode();
        }
        if (getDURATA_AQ() != null) {
            _hashCode += getDURATA_AQ().hashCode();
        }
        if (getOPERE_URBANIZ_SCOMPUTO() != null) {
            _hashCode += getOPERE_URBANIZ_SCOMPUTO().hashCode();
        }
        if (getTIPO_ATTO() != null) {
            _hashCode += getTIPO_ATTO().hashCode();
        }
        if (getDATA_ATTO() != null) {
            _hashCode += getDATA_ATTO().hashCode();
        }
        if (getNUM_ATTO() != null) {
            _hashCode += getNUM_ATTO().hashCode();
        }
        if (getPERC_IVA() != null) {
            _hashCode += getPERC_IVA().hashCode();
        }
        if (getIMPORTO_IVA() != null) {
            _hashCode += getIMPORTO_IVA().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatiAggiudicazione.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiAggiudicazione"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FIN_REGIONALE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FIN_REGIONALE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
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
        elemField.setFieldName("FLAG_LIVELLO_PROGETTUALE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_LIVELLO_PROGETTUALE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VERIFICA_CAMPIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "VERIFICA_CAMPIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_VERB_AGGIUDICAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_VERB_AGGIUDICAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_AGGIUDICAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_AGGIUDICAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_DISPOSIZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_DISPOSIZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ASTA_ELETTRONICA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ASTA_ELETTRONICA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PERC_RIBASSO_AGG");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "PERC_RIBASSO_AGG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PERC_OFF_AUMENTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "PERC_OFF_AUMENTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_APPALTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_APPALTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_INTERVENTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_INTERVENTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_NETTO_SIC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_NETTO_SIC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PROCEDURA_ACC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "PROCEDURA_ACC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PREINFORMAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "PREINFORMAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TERMINE_RIDOTTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TERMINE_RIDOTTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_MODO_INDIZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_MODO_INDIZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_IMPRESE_INVITATE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_IMPRESE_INVITATE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_IMPRESE_RICHIESTA_INVITO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_IMPRESE_RICHIESTA_INVITO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_IMPRESE_OFFERENTI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_IMPRESE_OFFERENTI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_OFFERTE_AMMESSE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_OFFERTE_AMMESSE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_SCADENZA_RICHIESTA_INVITO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_SCADENZA_RICHIESTA_INVITO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_SCADENZA_PRES_OFFERTA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_SCADENZA_PRES_OFFERTA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_LAVORI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_LAVORI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_SERVIZI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_SERVIZI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_FORNITURE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_FORNITURE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_ATTUAZIONE_SICUREZZA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_ATTUAZIONE_SICUREZZA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_PROGETTAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_PROGETTAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("REQUISITI_SS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "REQUISITI_SS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_AQ");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_AQ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_INVITO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_INVITO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_MANIF_INTERESSE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_MANIF_INTERESSE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_MANIF_INTERESSE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_MANIF_INTERESSE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_RICH_SUBAPPALTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_RICH_SUBAPPALTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_OFFERTE_ESCLUSE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_OFFERTE_ESCLUSE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OFFERTA_MASSIMO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "OFFERTA_MASSIMO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OFFERTA_MINIMA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "OFFERTA_MINIMA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VAL_SOGLIA_ANOMALIA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "VAL_SOGLIA_ANOMALIA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_OFFERTE_FUORI_SOGLIA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_OFFERTE_FUORI_SOGLIA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_IMP_ESCL_INSUF_GIUST");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_IMP_ESCL_INSUF_GIUST"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("COD_STRUMENTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "COD_STRUMENTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TipoStrumentoType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_NON_ASSOG");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMP_NON_ASSOG"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MODALITA_RIAGGIUDICAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "MODALITA_RIAGGIUDICAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DURATA_AQ");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DURATA_AQ"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OPERE_URBANIZ_SCOMPUTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "OPERE_URBANIZ_SCOMPUTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TIPO_ATTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TIPO_ATTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_ATTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_ATTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_ATTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_ATTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PERC_IVA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "PERC_IVA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_IVA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_IVA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
