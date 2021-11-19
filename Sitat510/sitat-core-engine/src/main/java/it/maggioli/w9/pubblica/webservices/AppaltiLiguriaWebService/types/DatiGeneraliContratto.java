/**
 * DatiGeneraliContratto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class DatiGeneraliContratto  implements java.io.Serializable {
    private java.lang.String CONTROLLO_INVIO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiComuni DATI_COMUNI;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiComuniEstesi DATI_COMUNI_ESTESI;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Offerente[] LISTA_OFFERENTI;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneAggiudicazione SEZIONE_AGGIUDICAZIONE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneInizio SEZIONE_INIZIO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSAL SEZIONE_SAL;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneVarianti SEZIONE_VARIANTI;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSospensioni SEZIONE_SOSPENSIONI;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneConclusione SEZIONE_CONCLUSIONE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneCollaudo SEZIONE_COLLAUDO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSubappalti SEZIONE_SUBAPPALTI;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneRitardiRecessi SEZIONE_RITARDI_RECESSI;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneAccordiBonari SEZIONE_ACCORDI_BONARI;

    public DatiGeneraliContratto() {
    }

    public DatiGeneraliContratto(
           java.lang.String CONTROLLO_INVIO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiComuni DATI_COMUNI,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiComuniEstesi DATI_COMUNI_ESTESI,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Offerente[] LISTA_OFFERENTI,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneAggiudicazione SEZIONE_AGGIUDICAZIONE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneInizio SEZIONE_INIZIO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSAL SEZIONE_SAL,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneVarianti SEZIONE_VARIANTI,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSospensioni SEZIONE_SOSPENSIONI,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneConclusione SEZIONE_CONCLUSIONE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneCollaudo SEZIONE_COLLAUDO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSubappalti SEZIONE_SUBAPPALTI,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneRitardiRecessi SEZIONE_RITARDI_RECESSI,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneAccordiBonari SEZIONE_ACCORDI_BONARI) {
           this.CONTROLLO_INVIO = CONTROLLO_INVIO;
           this.DATI_COMUNI = DATI_COMUNI;
           this.DATI_COMUNI_ESTESI = DATI_COMUNI_ESTESI;
           this.LISTA_OFFERENTI = LISTA_OFFERENTI;
           this.SEZIONE_AGGIUDICAZIONE = SEZIONE_AGGIUDICAZIONE;
           this.SEZIONE_INIZIO = SEZIONE_INIZIO;
           this.SEZIONE_SAL = SEZIONE_SAL;
           this.SEZIONE_VARIANTI = SEZIONE_VARIANTI;
           this.SEZIONE_SOSPENSIONI = SEZIONE_SOSPENSIONI;
           this.SEZIONE_CONCLUSIONE = SEZIONE_CONCLUSIONE;
           this.SEZIONE_COLLAUDO = SEZIONE_COLLAUDO;
           this.SEZIONE_SUBAPPALTI = SEZIONE_SUBAPPALTI;
           this.SEZIONE_RITARDI_RECESSI = SEZIONE_RITARDI_RECESSI;
           this.SEZIONE_ACCORDI_BONARI = SEZIONE_ACCORDI_BONARI;
    }


    /**
     * Gets the CONTROLLO_INVIO value for this DatiGeneraliContratto.
     * 
     * @return CONTROLLO_INVIO
     */
    public java.lang.String getCONTROLLO_INVIO() {
        return CONTROLLO_INVIO;
    }


    /**
     * Sets the CONTROLLO_INVIO value for this DatiGeneraliContratto.
     * 
     * @param CONTROLLO_INVIO
     */
    public void setCONTROLLO_INVIO(java.lang.String CONTROLLO_INVIO) {
        this.CONTROLLO_INVIO = CONTROLLO_INVIO;
    }


    /**
     * Gets the DATI_COMUNI value for this DatiGeneraliContratto.
     * 
     * @return DATI_COMUNI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiComuni getDATI_COMUNI() {
        return DATI_COMUNI;
    }


    /**
     * Sets the DATI_COMUNI value for this DatiGeneraliContratto.
     * 
     * @param DATI_COMUNI
     */
    public void setDATI_COMUNI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiComuni DATI_COMUNI) {
        this.DATI_COMUNI = DATI_COMUNI;
    }


    /**
     * Gets the DATI_COMUNI_ESTESI value for this DatiGeneraliContratto.
     * 
     * @return DATI_COMUNI_ESTESI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiComuniEstesi getDATI_COMUNI_ESTESI() {
        return DATI_COMUNI_ESTESI;
    }


    /**
     * Sets the DATI_COMUNI_ESTESI value for this DatiGeneraliContratto.
     * 
     * @param DATI_COMUNI_ESTESI
     */
    public void setDATI_COMUNI_ESTESI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiComuniEstesi DATI_COMUNI_ESTESI) {
        this.DATI_COMUNI_ESTESI = DATI_COMUNI_ESTESI;
    }


    /**
     * Gets the LISTA_OFFERENTI value for this DatiGeneraliContratto.
     * 
     * @return LISTA_OFFERENTI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Offerente[] getLISTA_OFFERENTI() {
        return LISTA_OFFERENTI;
    }


    /**
     * Sets the LISTA_OFFERENTI value for this DatiGeneraliContratto.
     * 
     * @param LISTA_OFFERENTI
     */
    public void setLISTA_OFFERENTI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Offerente[] LISTA_OFFERENTI) {
        this.LISTA_OFFERENTI = LISTA_OFFERENTI;
    }


    /**
     * Gets the SEZIONE_AGGIUDICAZIONE value for this DatiGeneraliContratto.
     * 
     * @return SEZIONE_AGGIUDICAZIONE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneAggiudicazione getSEZIONE_AGGIUDICAZIONE() {
        return SEZIONE_AGGIUDICAZIONE;
    }


    /**
     * Sets the SEZIONE_AGGIUDICAZIONE value for this DatiGeneraliContratto.
     * 
     * @param SEZIONE_AGGIUDICAZIONE
     */
    public void setSEZIONE_AGGIUDICAZIONE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneAggiudicazione SEZIONE_AGGIUDICAZIONE) {
        this.SEZIONE_AGGIUDICAZIONE = SEZIONE_AGGIUDICAZIONE;
    }


    /**
     * Gets the SEZIONE_INIZIO value for this DatiGeneraliContratto.
     * 
     * @return SEZIONE_INIZIO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneInizio getSEZIONE_INIZIO() {
        return SEZIONE_INIZIO;
    }


    /**
     * Sets the SEZIONE_INIZIO value for this DatiGeneraliContratto.
     * 
     * @param SEZIONE_INIZIO
     */
    public void setSEZIONE_INIZIO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneInizio SEZIONE_INIZIO) {
        this.SEZIONE_INIZIO = SEZIONE_INIZIO;
    }


    /**
     * Gets the SEZIONE_SAL value for this DatiGeneraliContratto.
     * 
     * @return SEZIONE_SAL
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSAL getSEZIONE_SAL() {
        return SEZIONE_SAL;
    }


    /**
     * Sets the SEZIONE_SAL value for this DatiGeneraliContratto.
     * 
     * @param SEZIONE_SAL
     */
    public void setSEZIONE_SAL(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSAL SEZIONE_SAL) {
        this.SEZIONE_SAL = SEZIONE_SAL;
    }


    /**
     * Gets the SEZIONE_VARIANTI value for this DatiGeneraliContratto.
     * 
     * @return SEZIONE_VARIANTI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneVarianti getSEZIONE_VARIANTI() {
        return SEZIONE_VARIANTI;
    }


    /**
     * Sets the SEZIONE_VARIANTI value for this DatiGeneraliContratto.
     * 
     * @param SEZIONE_VARIANTI
     */
    public void setSEZIONE_VARIANTI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneVarianti SEZIONE_VARIANTI) {
        this.SEZIONE_VARIANTI = SEZIONE_VARIANTI;
    }


    /**
     * Gets the SEZIONE_SOSPENSIONI value for this DatiGeneraliContratto.
     * 
     * @return SEZIONE_SOSPENSIONI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSospensioni getSEZIONE_SOSPENSIONI() {
        return SEZIONE_SOSPENSIONI;
    }


    /**
     * Sets the SEZIONE_SOSPENSIONI value for this DatiGeneraliContratto.
     * 
     * @param SEZIONE_SOSPENSIONI
     */
    public void setSEZIONE_SOSPENSIONI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSospensioni SEZIONE_SOSPENSIONI) {
        this.SEZIONE_SOSPENSIONI = SEZIONE_SOSPENSIONI;
    }


    /**
     * Gets the SEZIONE_CONCLUSIONE value for this DatiGeneraliContratto.
     * 
     * @return SEZIONE_CONCLUSIONE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneConclusione getSEZIONE_CONCLUSIONE() {
        return SEZIONE_CONCLUSIONE;
    }


    /**
     * Sets the SEZIONE_CONCLUSIONE value for this DatiGeneraliContratto.
     * 
     * @param SEZIONE_CONCLUSIONE
     */
    public void setSEZIONE_CONCLUSIONE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneConclusione SEZIONE_CONCLUSIONE) {
        this.SEZIONE_CONCLUSIONE = SEZIONE_CONCLUSIONE;
    }


    /**
     * Gets the SEZIONE_COLLAUDO value for this DatiGeneraliContratto.
     * 
     * @return SEZIONE_COLLAUDO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneCollaudo getSEZIONE_COLLAUDO() {
        return SEZIONE_COLLAUDO;
    }


    /**
     * Sets the SEZIONE_COLLAUDO value for this DatiGeneraliContratto.
     * 
     * @param SEZIONE_COLLAUDO
     */
    public void setSEZIONE_COLLAUDO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneCollaudo SEZIONE_COLLAUDO) {
        this.SEZIONE_COLLAUDO = SEZIONE_COLLAUDO;
    }


    /**
     * Gets the SEZIONE_SUBAPPALTI value for this DatiGeneraliContratto.
     * 
     * @return SEZIONE_SUBAPPALTI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSubappalti getSEZIONE_SUBAPPALTI() {
        return SEZIONE_SUBAPPALTI;
    }


    /**
     * Sets the SEZIONE_SUBAPPALTI value for this DatiGeneraliContratto.
     * 
     * @param SEZIONE_SUBAPPALTI
     */
    public void setSEZIONE_SUBAPPALTI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneSubappalti SEZIONE_SUBAPPALTI) {
        this.SEZIONE_SUBAPPALTI = SEZIONE_SUBAPPALTI;
    }


    /**
     * Gets the SEZIONE_RITARDI_RECESSI value for this DatiGeneraliContratto.
     * 
     * @return SEZIONE_RITARDI_RECESSI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneRitardiRecessi getSEZIONE_RITARDI_RECESSI() {
        return SEZIONE_RITARDI_RECESSI;
    }


    /**
     * Sets the SEZIONE_RITARDI_RECESSI value for this DatiGeneraliContratto.
     * 
     * @param SEZIONE_RITARDI_RECESSI
     */
    public void setSEZIONE_RITARDI_RECESSI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneRitardiRecessi SEZIONE_RITARDI_RECESSI) {
        this.SEZIONE_RITARDI_RECESSI = SEZIONE_RITARDI_RECESSI;
    }


    /**
     * Gets the SEZIONE_ACCORDI_BONARI value for this DatiGeneraliContratto.
     * 
     * @return SEZIONE_ACCORDI_BONARI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneAccordiBonari getSEZIONE_ACCORDI_BONARI() {
        return SEZIONE_ACCORDI_BONARI;
    }


    /**
     * Sets the SEZIONE_ACCORDI_BONARI value for this DatiGeneraliContratto.
     * 
     * @param SEZIONE_ACCORDI_BONARI
     */
    public void setSEZIONE_ACCORDI_BONARI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.SezioneAccordiBonari SEZIONE_ACCORDI_BONARI) {
        this.SEZIONE_ACCORDI_BONARI = SEZIONE_ACCORDI_BONARI;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatiGeneraliContratto)) return false;
        DatiGeneraliContratto other = (DatiGeneraliContratto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.CONTROLLO_INVIO==null && other.getCONTROLLO_INVIO()==null) || 
             (this.CONTROLLO_INVIO!=null &&
              this.CONTROLLO_INVIO.equals(other.getCONTROLLO_INVIO()))) &&
            ((this.DATI_COMUNI==null && other.getDATI_COMUNI()==null) || 
             (this.DATI_COMUNI!=null &&
              this.DATI_COMUNI.equals(other.getDATI_COMUNI()))) &&
            ((this.DATI_COMUNI_ESTESI==null && other.getDATI_COMUNI_ESTESI()==null) || 
             (this.DATI_COMUNI_ESTESI!=null &&
              this.DATI_COMUNI_ESTESI.equals(other.getDATI_COMUNI_ESTESI()))) &&
            ((this.LISTA_OFFERENTI==null && other.getLISTA_OFFERENTI()==null) || 
             (this.LISTA_OFFERENTI!=null &&
              java.util.Arrays.equals(this.LISTA_OFFERENTI, other.getLISTA_OFFERENTI()))) &&
            ((this.SEZIONE_AGGIUDICAZIONE==null && other.getSEZIONE_AGGIUDICAZIONE()==null) || 
             (this.SEZIONE_AGGIUDICAZIONE!=null &&
              this.SEZIONE_AGGIUDICAZIONE.equals(other.getSEZIONE_AGGIUDICAZIONE()))) &&
            ((this.SEZIONE_INIZIO==null && other.getSEZIONE_INIZIO()==null) || 
             (this.SEZIONE_INIZIO!=null &&
              this.SEZIONE_INIZIO.equals(other.getSEZIONE_INIZIO()))) &&
            ((this.SEZIONE_SAL==null && other.getSEZIONE_SAL()==null) || 
             (this.SEZIONE_SAL!=null &&
              this.SEZIONE_SAL.equals(other.getSEZIONE_SAL()))) &&
            ((this.SEZIONE_VARIANTI==null && other.getSEZIONE_VARIANTI()==null) || 
             (this.SEZIONE_VARIANTI!=null &&
              this.SEZIONE_VARIANTI.equals(other.getSEZIONE_VARIANTI()))) &&
            ((this.SEZIONE_SOSPENSIONI==null && other.getSEZIONE_SOSPENSIONI()==null) || 
             (this.SEZIONE_SOSPENSIONI!=null &&
              this.SEZIONE_SOSPENSIONI.equals(other.getSEZIONE_SOSPENSIONI()))) &&
            ((this.SEZIONE_CONCLUSIONE==null && other.getSEZIONE_CONCLUSIONE()==null) || 
             (this.SEZIONE_CONCLUSIONE!=null &&
              this.SEZIONE_CONCLUSIONE.equals(other.getSEZIONE_CONCLUSIONE()))) &&
            ((this.SEZIONE_COLLAUDO==null && other.getSEZIONE_COLLAUDO()==null) || 
             (this.SEZIONE_COLLAUDO!=null &&
              this.SEZIONE_COLLAUDO.equals(other.getSEZIONE_COLLAUDO()))) &&
            ((this.SEZIONE_SUBAPPALTI==null && other.getSEZIONE_SUBAPPALTI()==null) || 
             (this.SEZIONE_SUBAPPALTI!=null &&
              this.SEZIONE_SUBAPPALTI.equals(other.getSEZIONE_SUBAPPALTI()))) &&
            ((this.SEZIONE_RITARDI_RECESSI==null && other.getSEZIONE_RITARDI_RECESSI()==null) || 
             (this.SEZIONE_RITARDI_RECESSI!=null &&
              this.SEZIONE_RITARDI_RECESSI.equals(other.getSEZIONE_RITARDI_RECESSI()))) &&
            ((this.SEZIONE_ACCORDI_BONARI==null && other.getSEZIONE_ACCORDI_BONARI()==null) || 
             (this.SEZIONE_ACCORDI_BONARI!=null &&
              this.SEZIONE_ACCORDI_BONARI.equals(other.getSEZIONE_ACCORDI_BONARI())));
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
        if (getCONTROLLO_INVIO() != null) {
            _hashCode += getCONTROLLO_INVIO().hashCode();
        }
        if (getDATI_COMUNI() != null) {
            _hashCode += getDATI_COMUNI().hashCode();
        }
        if (getDATI_COMUNI_ESTESI() != null) {
            _hashCode += getDATI_COMUNI_ESTESI().hashCode();
        }
        if (getLISTA_OFFERENTI() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLISTA_OFFERENTI());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLISTA_OFFERENTI(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSEZIONE_AGGIUDICAZIONE() != null) {
            _hashCode += getSEZIONE_AGGIUDICAZIONE().hashCode();
        }
        if (getSEZIONE_INIZIO() != null) {
            _hashCode += getSEZIONE_INIZIO().hashCode();
        }
        if (getSEZIONE_SAL() != null) {
            _hashCode += getSEZIONE_SAL().hashCode();
        }
        if (getSEZIONE_VARIANTI() != null) {
            _hashCode += getSEZIONE_VARIANTI().hashCode();
        }
        if (getSEZIONE_SOSPENSIONI() != null) {
            _hashCode += getSEZIONE_SOSPENSIONI().hashCode();
        }
        if (getSEZIONE_CONCLUSIONE() != null) {
            _hashCode += getSEZIONE_CONCLUSIONE().hashCode();
        }
        if (getSEZIONE_COLLAUDO() != null) {
            _hashCode += getSEZIONE_COLLAUDO().hashCode();
        }
        if (getSEZIONE_SUBAPPALTI() != null) {
            _hashCode += getSEZIONE_SUBAPPALTI().hashCode();
        }
        if (getSEZIONE_RITARDI_RECESSI() != null) {
            _hashCode += getSEZIONE_RITARDI_RECESSI().hashCode();
        }
        if (getSEZIONE_ACCORDI_BONARI() != null) {
            _hashCode += getSEZIONE_ACCORDI_BONARI().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatiGeneraliContratto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiGeneraliContratto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONTROLLO_INVIO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CONTROLLO_INVIO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATI_COMUNI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATI_COMUNI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiComuni"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATI_COMUNI_ESTESI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATI_COMUNI_ESTESI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiComuniEstesi"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LISTA_OFFERENTI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "LISTA_OFFERENTI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Offerente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_Offerenti"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SEZIONE_AGGIUDICAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SEZIONE_AGGIUDICAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneAggiudicazione"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SEZIONE_INIZIO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SEZIONE_INIZIO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneInizio"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SEZIONE_SAL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SEZIONE_SAL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneSAL"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SEZIONE_VARIANTI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SEZIONE_VARIANTI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneVarianti"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SEZIONE_SOSPENSIONI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SEZIONE_SOSPENSIONI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneSospensioni"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SEZIONE_CONCLUSIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SEZIONE_CONCLUSIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneConclusione"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SEZIONE_COLLAUDO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SEZIONE_COLLAUDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneCollaudo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SEZIONE_SUBAPPALTI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SEZIONE_SUBAPPALTI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneSubappalti"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SEZIONE_RITARDI_RECESSI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SEZIONE_RITARDI_RECESSI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneRitardiRecessi"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SEZIONE_ACCORDI_BONARI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SEZIONE_ACCORDI_BONARI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneAccordiBonari"));
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
