/**
 * DatiInizio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class DatiInizio  extends it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.StipulaInizio  implements java.io.Serializable {
    private java.util.Calendar DATA_ESECUTIVITA;

    private double IMPORTO_CAUZIONE;

    private java.util.Calendar DATA_INI_PROG_ESEC;

    private java.util.Calendar DATA_APP_PROG_ESEC;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_FRAZIONATA;

    private java.util.Calendar DATA_VERB_PRIMA_CONSEGNA;

    private java.util.Calendar DATA_VERBALE_DEF;

    public DatiInizio() {
    }

    public DatiInizio(
           java.util.Calendar DATA_STIPULA,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_RISERVA,
           java.util.Calendar DATA_VERB_INIZIO,
           java.util.Calendar DATA_TERMINE,
           java.util.Calendar DATA_ESECUTIVITA,
           double IMPORTO_CAUZIONE,
           java.util.Calendar DATA_INI_PROG_ESEC,
           java.util.Calendar DATA_APP_PROG_ESEC,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_FRAZIONATA,
           java.util.Calendar DATA_VERB_PRIMA_CONSEGNA,
           java.util.Calendar DATA_VERBALE_DEF) {
        super(
            DATA_STIPULA,
            FLAG_RISERVA,
            DATA_VERB_INIZIO,
            DATA_TERMINE);
        this.DATA_ESECUTIVITA = DATA_ESECUTIVITA;
        this.IMPORTO_CAUZIONE = IMPORTO_CAUZIONE;
        this.DATA_INI_PROG_ESEC = DATA_INI_PROG_ESEC;
        this.DATA_APP_PROG_ESEC = DATA_APP_PROG_ESEC;
        this.FLAG_FRAZIONATA = FLAG_FRAZIONATA;
        this.DATA_VERB_PRIMA_CONSEGNA = DATA_VERB_PRIMA_CONSEGNA;
        this.DATA_VERBALE_DEF = DATA_VERBALE_DEF;
    }


    /**
     * Gets the DATA_ESECUTIVITA value for this DatiInizio.
     * 
     * @return DATA_ESECUTIVITA
     */
    public java.util.Calendar getDATA_ESECUTIVITA() {
        return DATA_ESECUTIVITA;
    }


    /**
     * Sets the DATA_ESECUTIVITA value for this DatiInizio.
     * 
     * @param DATA_ESECUTIVITA
     */
    public void setDATA_ESECUTIVITA(java.util.Calendar DATA_ESECUTIVITA) {
        this.DATA_ESECUTIVITA = DATA_ESECUTIVITA;
    }


    /**
     * Gets the IMPORTO_CAUZIONE value for this DatiInizio.
     * 
     * @return IMPORTO_CAUZIONE
     */
    public double getIMPORTO_CAUZIONE() {
        return IMPORTO_CAUZIONE;
    }


    /**
     * Sets the IMPORTO_CAUZIONE value for this DatiInizio.
     * 
     * @param IMPORTO_CAUZIONE
     */
    public void setIMPORTO_CAUZIONE(double IMPORTO_CAUZIONE) {
        this.IMPORTO_CAUZIONE = IMPORTO_CAUZIONE;
    }


    /**
     * Gets the DATA_INI_PROG_ESEC value for this DatiInizio.
     * 
     * @return DATA_INI_PROG_ESEC
     */
    public java.util.Calendar getDATA_INI_PROG_ESEC() {
        return DATA_INI_PROG_ESEC;
    }


    /**
     * Sets the DATA_INI_PROG_ESEC value for this DatiInizio.
     * 
     * @param DATA_INI_PROG_ESEC
     */
    public void setDATA_INI_PROG_ESEC(java.util.Calendar DATA_INI_PROG_ESEC) {
        this.DATA_INI_PROG_ESEC = DATA_INI_PROG_ESEC;
    }


    /**
     * Gets the DATA_APP_PROG_ESEC value for this DatiInizio.
     * 
     * @return DATA_APP_PROG_ESEC
     */
    public java.util.Calendar getDATA_APP_PROG_ESEC() {
        return DATA_APP_PROG_ESEC;
    }


    /**
     * Sets the DATA_APP_PROG_ESEC value for this DatiInizio.
     * 
     * @param DATA_APP_PROG_ESEC
     */
    public void setDATA_APP_PROG_ESEC(java.util.Calendar DATA_APP_PROG_ESEC) {
        this.DATA_APP_PROG_ESEC = DATA_APP_PROG_ESEC;
    }


    /**
     * Gets the FLAG_FRAZIONATA value for this DatiInizio.
     * 
     * @return FLAG_FRAZIONATA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_FRAZIONATA() {
        return FLAG_FRAZIONATA;
    }


    /**
     * Sets the FLAG_FRAZIONATA value for this DatiInizio.
     * 
     * @param FLAG_FRAZIONATA
     */
    public void setFLAG_FRAZIONATA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_FRAZIONATA) {
        this.FLAG_FRAZIONATA = FLAG_FRAZIONATA;
    }


    /**
     * Gets the DATA_VERB_PRIMA_CONSEGNA value for this DatiInizio.
     * 
     * @return DATA_VERB_PRIMA_CONSEGNA
     */
    public java.util.Calendar getDATA_VERB_PRIMA_CONSEGNA() {
        return DATA_VERB_PRIMA_CONSEGNA;
    }


    /**
     * Sets the DATA_VERB_PRIMA_CONSEGNA value for this DatiInizio.
     * 
     * @param DATA_VERB_PRIMA_CONSEGNA
     */
    public void setDATA_VERB_PRIMA_CONSEGNA(java.util.Calendar DATA_VERB_PRIMA_CONSEGNA) {
        this.DATA_VERB_PRIMA_CONSEGNA = DATA_VERB_PRIMA_CONSEGNA;
    }


    /**
     * Gets the DATA_VERBALE_DEF value for this DatiInizio.
     * 
     * @return DATA_VERBALE_DEF
     */
    public java.util.Calendar getDATA_VERBALE_DEF() {
        return DATA_VERBALE_DEF;
    }


    /**
     * Sets the DATA_VERBALE_DEF value for this DatiInizio.
     * 
     * @param DATA_VERBALE_DEF
     */
    public void setDATA_VERBALE_DEF(java.util.Calendar DATA_VERBALE_DEF) {
        this.DATA_VERBALE_DEF = DATA_VERBALE_DEF;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatiInizio)) return false;
        DatiInizio other = (DatiInizio) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.DATA_ESECUTIVITA==null && other.getDATA_ESECUTIVITA()==null) || 
             (this.DATA_ESECUTIVITA!=null &&
              this.DATA_ESECUTIVITA.equals(other.getDATA_ESECUTIVITA()))) &&
            this.IMPORTO_CAUZIONE == other.getIMPORTO_CAUZIONE() &&
            ((this.DATA_INI_PROG_ESEC==null && other.getDATA_INI_PROG_ESEC()==null) || 
             (this.DATA_INI_PROG_ESEC!=null &&
              this.DATA_INI_PROG_ESEC.equals(other.getDATA_INI_PROG_ESEC()))) &&
            ((this.DATA_APP_PROG_ESEC==null && other.getDATA_APP_PROG_ESEC()==null) || 
             (this.DATA_APP_PROG_ESEC!=null &&
              this.DATA_APP_PROG_ESEC.equals(other.getDATA_APP_PROG_ESEC()))) &&
            ((this.FLAG_FRAZIONATA==null && other.getFLAG_FRAZIONATA()==null) || 
             (this.FLAG_FRAZIONATA!=null &&
              this.FLAG_FRAZIONATA.equals(other.getFLAG_FRAZIONATA()))) &&
            ((this.DATA_VERB_PRIMA_CONSEGNA==null && other.getDATA_VERB_PRIMA_CONSEGNA()==null) || 
             (this.DATA_VERB_PRIMA_CONSEGNA!=null &&
              this.DATA_VERB_PRIMA_CONSEGNA.equals(other.getDATA_VERB_PRIMA_CONSEGNA()))) &&
            ((this.DATA_VERBALE_DEF==null && other.getDATA_VERBALE_DEF()==null) || 
             (this.DATA_VERBALE_DEF!=null &&
              this.DATA_VERBALE_DEF.equals(other.getDATA_VERBALE_DEF())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getDATA_ESECUTIVITA() != null) {
            _hashCode += getDATA_ESECUTIVITA().hashCode();
        }
        _hashCode += new Double(getIMPORTO_CAUZIONE()).hashCode();
        if (getDATA_INI_PROG_ESEC() != null) {
            _hashCode += getDATA_INI_PROG_ESEC().hashCode();
        }
        if (getDATA_APP_PROG_ESEC() != null) {
            _hashCode += getDATA_APP_PROG_ESEC().hashCode();
        }
        if (getFLAG_FRAZIONATA() != null) {
            _hashCode += getFLAG_FRAZIONATA().hashCode();
        }
        if (getDATA_VERB_PRIMA_CONSEGNA() != null) {
            _hashCode += getDATA_VERB_PRIMA_CONSEGNA().hashCode();
        }
        if (getDATA_VERBALE_DEF() != null) {
            _hashCode += getDATA_VERBALE_DEF().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatiInizio.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiInizio"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_ESECUTIVITA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_ESECUTIVITA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_CAUZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_CAUZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_INI_PROG_ESEC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_INI_PROG_ESEC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_APP_PROG_ESEC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_APP_PROG_ESEC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_FRAZIONATA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_FRAZIONATA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_VERB_PRIMA_CONSEGNA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_VERB_PRIMA_CONSEGNA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_VERBALE_DEF");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_VERBALE_DEF"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
