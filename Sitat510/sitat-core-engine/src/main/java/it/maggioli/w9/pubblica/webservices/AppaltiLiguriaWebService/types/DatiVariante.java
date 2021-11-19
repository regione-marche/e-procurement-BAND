/**
 * DatiVariante.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class DatiVariante  implements java.io.Serializable {
    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.MotiviVariante[] LISTA_MOTIVI_VARIANTE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagVarianteType FLAG_VARIANTE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType QUINTO_OBBLIGO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType FLAG_IMPORTI;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType FLAG_SICUREZZA;

    private java.util.Calendar DATA_VERB_APPR;

    private java.lang.String ALTRE_MOTIVAZIONI;

    private java.lang.Double IMP_RIDET_LAVORI;

    private java.lang.Double IMP_RIDET_SERVIZI;

    private java.lang.Double IMP_RIDET_FORNIT;

    private java.lang.Double IMP_SICUREZZA;

    private java.lang.Double IMP_PROGETTAZIONE;

    private java.lang.Double IMP_DISPOSIZIONE;

    private java.util.Calendar DATA_ATTO_AGGIUNTIVO;

    private java.lang.Long NUM_GIORNI_PROROGA;

    private double IMPORTO_SUBTOTALE;

    private double IMPORTO_RIDETERMINATO;

    private double IMPORTO_COMPLESSIVO;

    public DatiVariante() {
    }

    public DatiVariante(
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.MotiviVariante[] LISTA_MOTIVI_VARIANTE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagVarianteType FLAG_VARIANTE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType QUINTO_OBBLIGO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType FLAG_IMPORTI,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType FLAG_SICUREZZA,
           java.util.Calendar DATA_VERB_APPR,
           java.lang.String ALTRE_MOTIVAZIONI,
           java.lang.Double IMP_RIDET_LAVORI,
           java.lang.Double IMP_RIDET_SERVIZI,
           java.lang.Double IMP_RIDET_FORNIT,
           java.lang.Double IMP_SICUREZZA,
           java.lang.Double IMP_PROGETTAZIONE,
           java.lang.Double IMP_DISPOSIZIONE,
           java.util.Calendar DATA_ATTO_AGGIUNTIVO,
           java.lang.Long NUM_GIORNI_PROROGA,
           double IMPORTO_SUBTOTALE,
           double IMPORTO_RIDETERMINATO,
           double IMPORTO_COMPLESSIVO) {
           this.LISTA_MOTIVI_VARIANTE = LISTA_MOTIVI_VARIANTE;
           this.FLAG_VARIANTE = FLAG_VARIANTE;
           this.QUINTO_OBBLIGO = QUINTO_OBBLIGO;
           this.FLAG_IMPORTI = FLAG_IMPORTI;
           this.FLAG_SICUREZZA = FLAG_SICUREZZA;
           this.DATA_VERB_APPR = DATA_VERB_APPR;
           this.ALTRE_MOTIVAZIONI = ALTRE_MOTIVAZIONI;
           this.IMP_RIDET_LAVORI = IMP_RIDET_LAVORI;
           this.IMP_RIDET_SERVIZI = IMP_RIDET_SERVIZI;
           this.IMP_RIDET_FORNIT = IMP_RIDET_FORNIT;
           this.IMP_SICUREZZA = IMP_SICUREZZA;
           this.IMP_PROGETTAZIONE = IMP_PROGETTAZIONE;
           this.IMP_DISPOSIZIONE = IMP_DISPOSIZIONE;
           this.DATA_ATTO_AGGIUNTIVO = DATA_ATTO_AGGIUNTIVO;
           this.NUM_GIORNI_PROROGA = NUM_GIORNI_PROROGA;
           this.IMPORTO_SUBTOTALE = IMPORTO_SUBTOTALE;
           this.IMPORTO_RIDETERMINATO = IMPORTO_RIDETERMINATO;
           this.IMPORTO_COMPLESSIVO = IMPORTO_COMPLESSIVO;
    }


    /**
     * Gets the LISTA_MOTIVI_VARIANTE value for this DatiVariante.
     * 
     * @return LISTA_MOTIVI_VARIANTE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.MotiviVariante[] getLISTA_MOTIVI_VARIANTE() {
        return LISTA_MOTIVI_VARIANTE;
    }


    /**
     * Sets the LISTA_MOTIVI_VARIANTE value for this DatiVariante.
     * 
     * @param LISTA_MOTIVI_VARIANTE
     */
    public void setLISTA_MOTIVI_VARIANTE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.MotiviVariante[] LISTA_MOTIVI_VARIANTE) {
        this.LISTA_MOTIVI_VARIANTE = LISTA_MOTIVI_VARIANTE;
    }


    /**
     * Gets the FLAG_VARIANTE value for this DatiVariante.
     * 
     * @return FLAG_VARIANTE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagVarianteType getFLAG_VARIANTE() {
        return FLAG_VARIANTE;
    }


    /**
     * Sets the FLAG_VARIANTE value for this DatiVariante.
     * 
     * @param FLAG_VARIANTE
     */
    public void setFLAG_VARIANTE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagVarianteType FLAG_VARIANTE) {
        this.FLAG_VARIANTE = FLAG_VARIANTE;
    }


    /**
     * Gets the QUINTO_OBBLIGO value for this DatiVariante.
     * 
     * @return QUINTO_OBBLIGO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getQUINTO_OBBLIGO() {
        return QUINTO_OBBLIGO;
    }


    /**
     * Sets the QUINTO_OBBLIGO value for this DatiVariante.
     * 
     * @param QUINTO_OBBLIGO
     */
    public void setQUINTO_OBBLIGO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType QUINTO_OBBLIGO) {
        this.QUINTO_OBBLIGO = QUINTO_OBBLIGO;
    }


    /**
     * Gets the FLAG_IMPORTI value for this DatiVariante.
     * 
     * @return FLAG_IMPORTI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType getFLAG_IMPORTI() {
        return FLAG_IMPORTI;
    }


    /**
     * Sets the FLAG_IMPORTI value for this DatiVariante.
     * 
     * @param FLAG_IMPORTI
     */
    public void setFLAG_IMPORTI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType FLAG_IMPORTI) {
        this.FLAG_IMPORTI = FLAG_IMPORTI;
    }


    /**
     * Gets the FLAG_SICUREZZA value for this DatiVariante.
     * 
     * @return FLAG_SICUREZZA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType getFLAG_SICUREZZA() {
        return FLAG_SICUREZZA;
    }


    /**
     * Sets the FLAG_SICUREZZA value for this DatiVariante.
     * 
     * @param FLAG_SICUREZZA
     */
    public void setFLAG_SICUREZZA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagImportiType FLAG_SICUREZZA) {
        this.FLAG_SICUREZZA = FLAG_SICUREZZA;
    }


    /**
     * Gets the DATA_VERB_APPR value for this DatiVariante.
     * 
     * @return DATA_VERB_APPR
     */
    public java.util.Calendar getDATA_VERB_APPR() {
        return DATA_VERB_APPR;
    }


    /**
     * Sets the DATA_VERB_APPR value for this DatiVariante.
     * 
     * @param DATA_VERB_APPR
     */
    public void setDATA_VERB_APPR(java.util.Calendar DATA_VERB_APPR) {
        this.DATA_VERB_APPR = DATA_VERB_APPR;
    }


    /**
     * Gets the ALTRE_MOTIVAZIONI value for this DatiVariante.
     * 
     * @return ALTRE_MOTIVAZIONI
     */
    public java.lang.String getALTRE_MOTIVAZIONI() {
        return ALTRE_MOTIVAZIONI;
    }


    /**
     * Sets the ALTRE_MOTIVAZIONI value for this DatiVariante.
     * 
     * @param ALTRE_MOTIVAZIONI
     */
    public void setALTRE_MOTIVAZIONI(java.lang.String ALTRE_MOTIVAZIONI) {
        this.ALTRE_MOTIVAZIONI = ALTRE_MOTIVAZIONI;
    }


    /**
     * Gets the IMP_RIDET_LAVORI value for this DatiVariante.
     * 
     * @return IMP_RIDET_LAVORI
     */
    public java.lang.Double getIMP_RIDET_LAVORI() {
        return IMP_RIDET_LAVORI;
    }


    /**
     * Sets the IMP_RIDET_LAVORI value for this DatiVariante.
     * 
     * @param IMP_RIDET_LAVORI
     */
    public void setIMP_RIDET_LAVORI(java.lang.Double IMP_RIDET_LAVORI) {
        this.IMP_RIDET_LAVORI = IMP_RIDET_LAVORI;
    }


    /**
     * Gets the IMP_RIDET_SERVIZI value for this DatiVariante.
     * 
     * @return IMP_RIDET_SERVIZI
     */
    public java.lang.Double getIMP_RIDET_SERVIZI() {
        return IMP_RIDET_SERVIZI;
    }


    /**
     * Sets the IMP_RIDET_SERVIZI value for this DatiVariante.
     * 
     * @param IMP_RIDET_SERVIZI
     */
    public void setIMP_RIDET_SERVIZI(java.lang.Double IMP_RIDET_SERVIZI) {
        this.IMP_RIDET_SERVIZI = IMP_RIDET_SERVIZI;
    }


    /**
     * Gets the IMP_RIDET_FORNIT value for this DatiVariante.
     * 
     * @return IMP_RIDET_FORNIT
     */
    public java.lang.Double getIMP_RIDET_FORNIT() {
        return IMP_RIDET_FORNIT;
    }


    /**
     * Sets the IMP_RIDET_FORNIT value for this DatiVariante.
     * 
     * @param IMP_RIDET_FORNIT
     */
    public void setIMP_RIDET_FORNIT(java.lang.Double IMP_RIDET_FORNIT) {
        this.IMP_RIDET_FORNIT = IMP_RIDET_FORNIT;
    }


    /**
     * Gets the IMP_SICUREZZA value for this DatiVariante.
     * 
     * @return IMP_SICUREZZA
     */
    public java.lang.Double getIMP_SICUREZZA() {
        return IMP_SICUREZZA;
    }


    /**
     * Sets the IMP_SICUREZZA value for this DatiVariante.
     * 
     * @param IMP_SICUREZZA
     */
    public void setIMP_SICUREZZA(java.lang.Double IMP_SICUREZZA) {
        this.IMP_SICUREZZA = IMP_SICUREZZA;
    }


    /**
     * Gets the IMP_PROGETTAZIONE value for this DatiVariante.
     * 
     * @return IMP_PROGETTAZIONE
     */
    public java.lang.Double getIMP_PROGETTAZIONE() {
        return IMP_PROGETTAZIONE;
    }


    /**
     * Sets the IMP_PROGETTAZIONE value for this DatiVariante.
     * 
     * @param IMP_PROGETTAZIONE
     */
    public void setIMP_PROGETTAZIONE(java.lang.Double IMP_PROGETTAZIONE) {
        this.IMP_PROGETTAZIONE = IMP_PROGETTAZIONE;
    }


    /**
     * Gets the IMP_DISPOSIZIONE value for this DatiVariante.
     * 
     * @return IMP_DISPOSIZIONE
     */
    public java.lang.Double getIMP_DISPOSIZIONE() {
        return IMP_DISPOSIZIONE;
    }


    /**
     * Sets the IMP_DISPOSIZIONE value for this DatiVariante.
     * 
     * @param IMP_DISPOSIZIONE
     */
    public void setIMP_DISPOSIZIONE(java.lang.Double IMP_DISPOSIZIONE) {
        this.IMP_DISPOSIZIONE = IMP_DISPOSIZIONE;
    }


    /**
     * Gets the DATA_ATTO_AGGIUNTIVO value for this DatiVariante.
     * 
     * @return DATA_ATTO_AGGIUNTIVO
     */
    public java.util.Calendar getDATA_ATTO_AGGIUNTIVO() {
        return DATA_ATTO_AGGIUNTIVO;
    }


    /**
     * Sets the DATA_ATTO_AGGIUNTIVO value for this DatiVariante.
     * 
     * @param DATA_ATTO_AGGIUNTIVO
     */
    public void setDATA_ATTO_AGGIUNTIVO(java.util.Calendar DATA_ATTO_AGGIUNTIVO) {
        this.DATA_ATTO_AGGIUNTIVO = DATA_ATTO_AGGIUNTIVO;
    }


    /**
     * Gets the NUM_GIORNI_PROROGA value for this DatiVariante.
     * 
     * @return NUM_GIORNI_PROROGA
     */
    public java.lang.Long getNUM_GIORNI_PROROGA() {
        return NUM_GIORNI_PROROGA;
    }


    /**
     * Sets the NUM_GIORNI_PROROGA value for this DatiVariante.
     * 
     * @param NUM_GIORNI_PROROGA
     */
    public void setNUM_GIORNI_PROROGA(java.lang.Long NUM_GIORNI_PROROGA) {
        this.NUM_GIORNI_PROROGA = NUM_GIORNI_PROROGA;
    }


    /**
     * Gets the IMPORTO_SUBTOTALE value for this DatiVariante.
     * 
     * @return IMPORTO_SUBTOTALE
     */
    public double getIMPORTO_SUBTOTALE() {
        return IMPORTO_SUBTOTALE;
    }


    /**
     * Sets the IMPORTO_SUBTOTALE value for this DatiVariante.
     * 
     * @param IMPORTO_SUBTOTALE
     */
    public void setIMPORTO_SUBTOTALE(double IMPORTO_SUBTOTALE) {
        this.IMPORTO_SUBTOTALE = IMPORTO_SUBTOTALE;
    }


    /**
     * Gets the IMPORTO_RIDETERMINATO value for this DatiVariante.
     * 
     * @return IMPORTO_RIDETERMINATO
     */
    public double getIMPORTO_RIDETERMINATO() {
        return IMPORTO_RIDETERMINATO;
    }


    /**
     * Sets the IMPORTO_RIDETERMINATO value for this DatiVariante.
     * 
     * @param IMPORTO_RIDETERMINATO
     */
    public void setIMPORTO_RIDETERMINATO(double IMPORTO_RIDETERMINATO) {
        this.IMPORTO_RIDETERMINATO = IMPORTO_RIDETERMINATO;
    }


    /**
     * Gets the IMPORTO_COMPLESSIVO value for this DatiVariante.
     * 
     * @return IMPORTO_COMPLESSIVO
     */
    public double getIMPORTO_COMPLESSIVO() {
        return IMPORTO_COMPLESSIVO;
    }


    /**
     * Sets the IMPORTO_COMPLESSIVO value for this DatiVariante.
     * 
     * @param IMPORTO_COMPLESSIVO
     */
    public void setIMPORTO_COMPLESSIVO(double IMPORTO_COMPLESSIVO) {
        this.IMPORTO_COMPLESSIVO = IMPORTO_COMPLESSIVO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatiVariante)) return false;
        DatiVariante other = (DatiVariante) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.LISTA_MOTIVI_VARIANTE==null && other.getLISTA_MOTIVI_VARIANTE()==null) || 
             (this.LISTA_MOTIVI_VARIANTE!=null &&
              java.util.Arrays.equals(this.LISTA_MOTIVI_VARIANTE, other.getLISTA_MOTIVI_VARIANTE()))) &&
            ((this.FLAG_VARIANTE==null && other.getFLAG_VARIANTE()==null) || 
             (this.FLAG_VARIANTE!=null &&
              this.FLAG_VARIANTE.equals(other.getFLAG_VARIANTE()))) &&
            ((this.QUINTO_OBBLIGO==null && other.getQUINTO_OBBLIGO()==null) || 
             (this.QUINTO_OBBLIGO!=null &&
              this.QUINTO_OBBLIGO.equals(other.getQUINTO_OBBLIGO()))) &&
            ((this.FLAG_IMPORTI==null && other.getFLAG_IMPORTI()==null) || 
             (this.FLAG_IMPORTI!=null &&
              this.FLAG_IMPORTI.equals(other.getFLAG_IMPORTI()))) &&
            ((this.FLAG_SICUREZZA==null && other.getFLAG_SICUREZZA()==null) || 
             (this.FLAG_SICUREZZA!=null &&
              this.FLAG_SICUREZZA.equals(other.getFLAG_SICUREZZA()))) &&
            ((this.DATA_VERB_APPR==null && other.getDATA_VERB_APPR()==null) || 
             (this.DATA_VERB_APPR!=null &&
              this.DATA_VERB_APPR.equals(other.getDATA_VERB_APPR()))) &&
            ((this.ALTRE_MOTIVAZIONI==null && other.getALTRE_MOTIVAZIONI()==null) || 
             (this.ALTRE_MOTIVAZIONI!=null &&
              this.ALTRE_MOTIVAZIONI.equals(other.getALTRE_MOTIVAZIONI()))) &&
            ((this.IMP_RIDET_LAVORI==null && other.getIMP_RIDET_LAVORI()==null) || 
             (this.IMP_RIDET_LAVORI!=null &&
              this.IMP_RIDET_LAVORI.equals(other.getIMP_RIDET_LAVORI()))) &&
            ((this.IMP_RIDET_SERVIZI==null && other.getIMP_RIDET_SERVIZI()==null) || 
             (this.IMP_RIDET_SERVIZI!=null &&
              this.IMP_RIDET_SERVIZI.equals(other.getIMP_RIDET_SERVIZI()))) &&
            ((this.IMP_RIDET_FORNIT==null && other.getIMP_RIDET_FORNIT()==null) || 
             (this.IMP_RIDET_FORNIT!=null &&
              this.IMP_RIDET_FORNIT.equals(other.getIMP_RIDET_FORNIT()))) &&
            ((this.IMP_SICUREZZA==null && other.getIMP_SICUREZZA()==null) || 
             (this.IMP_SICUREZZA!=null &&
              this.IMP_SICUREZZA.equals(other.getIMP_SICUREZZA()))) &&
            ((this.IMP_PROGETTAZIONE==null && other.getIMP_PROGETTAZIONE()==null) || 
             (this.IMP_PROGETTAZIONE!=null &&
              this.IMP_PROGETTAZIONE.equals(other.getIMP_PROGETTAZIONE()))) &&
            ((this.IMP_DISPOSIZIONE==null && other.getIMP_DISPOSIZIONE()==null) || 
             (this.IMP_DISPOSIZIONE!=null &&
              this.IMP_DISPOSIZIONE.equals(other.getIMP_DISPOSIZIONE()))) &&
            ((this.DATA_ATTO_AGGIUNTIVO==null && other.getDATA_ATTO_AGGIUNTIVO()==null) || 
             (this.DATA_ATTO_AGGIUNTIVO!=null &&
              this.DATA_ATTO_AGGIUNTIVO.equals(other.getDATA_ATTO_AGGIUNTIVO()))) &&
            ((this.NUM_GIORNI_PROROGA==null && other.getNUM_GIORNI_PROROGA()==null) || 
             (this.NUM_GIORNI_PROROGA!=null &&
              this.NUM_GIORNI_PROROGA.equals(other.getNUM_GIORNI_PROROGA()))) &&
            this.IMPORTO_SUBTOTALE == other.getIMPORTO_SUBTOTALE() &&
            this.IMPORTO_RIDETERMINATO == other.getIMPORTO_RIDETERMINATO() &&
            this.IMPORTO_COMPLESSIVO == other.getIMPORTO_COMPLESSIVO();
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
        if (getLISTA_MOTIVI_VARIANTE() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLISTA_MOTIVI_VARIANTE());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLISTA_MOTIVI_VARIANTE(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFLAG_VARIANTE() != null) {
            _hashCode += getFLAG_VARIANTE().hashCode();
        }
        if (getQUINTO_OBBLIGO() != null) {
            _hashCode += getQUINTO_OBBLIGO().hashCode();
        }
        if (getFLAG_IMPORTI() != null) {
            _hashCode += getFLAG_IMPORTI().hashCode();
        }
        if (getFLAG_SICUREZZA() != null) {
            _hashCode += getFLAG_SICUREZZA().hashCode();
        }
        if (getDATA_VERB_APPR() != null) {
            _hashCode += getDATA_VERB_APPR().hashCode();
        }
        if (getALTRE_MOTIVAZIONI() != null) {
            _hashCode += getALTRE_MOTIVAZIONI().hashCode();
        }
        if (getIMP_RIDET_LAVORI() != null) {
            _hashCode += getIMP_RIDET_LAVORI().hashCode();
        }
        if (getIMP_RIDET_SERVIZI() != null) {
            _hashCode += getIMP_RIDET_SERVIZI().hashCode();
        }
        if (getIMP_RIDET_FORNIT() != null) {
            _hashCode += getIMP_RIDET_FORNIT().hashCode();
        }
        if (getIMP_SICUREZZA() != null) {
            _hashCode += getIMP_SICUREZZA().hashCode();
        }
        if (getIMP_PROGETTAZIONE() != null) {
            _hashCode += getIMP_PROGETTAZIONE().hashCode();
        }
        if (getIMP_DISPOSIZIONE() != null) {
            _hashCode += getIMP_DISPOSIZIONE().hashCode();
        }
        if (getDATA_ATTO_AGGIUNTIVO() != null) {
            _hashCode += getDATA_ATTO_AGGIUNTIVO().hashCode();
        }
        if (getNUM_GIORNI_PROROGA() != null) {
            _hashCode += getNUM_GIORNI_PROROGA().hashCode();
        }
        _hashCode += new Double(getIMPORTO_SUBTOTALE()).hashCode();
        _hashCode += new Double(getIMPORTO_RIDETERMINATO()).hashCode();
        _hashCode += new Double(getIMPORTO_COMPLESSIVO()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatiVariante.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiVariante"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LISTA_MOTIVI_VARIANTE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "LISTA_MOTIVI_VARIANTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "MotiviVariante"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_MotiviVariante"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_VARIANTE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_VARIANTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagVarianteType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("QUINTO_OBBLIGO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "QUINTO_OBBLIGO"));
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
        elemField.setFieldName("DATA_VERB_APPR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_VERB_APPR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ALTRE_MOTIVAZIONI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ALTRE_MOTIVAZIONI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_RIDET_LAVORI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMP_RIDET_LAVORI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_RIDET_SERVIZI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMP_RIDET_SERVIZI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_RIDET_FORNIT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMP_RIDET_FORNIT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMP_SICUREZZA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMP_SICUREZZA"));
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
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_ATTO_AGGIUNTIVO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_ATTO_AGGIUNTIVO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_GIORNI_PROROGA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_GIORNI_PROROGA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("IMPORTO_RIDETERMINATO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_RIDETERMINATO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_COMPLESSIVO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_COMPLESSIVO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
