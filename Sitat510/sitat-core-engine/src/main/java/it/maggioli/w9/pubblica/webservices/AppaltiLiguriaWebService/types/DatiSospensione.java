/**
 * DatiSospensione.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class DatiSospensione  implements java.io.Serializable {
    private long NUM_PROGRESSIVO;

    private java.util.Calendar DATA_VERB_SOSP;

    private java.util.Calendar DATA_VERB_RIPR;

    private java.lang.String ID_MOTIVO_SOSP;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_SUPERO_TEMPO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_RISERVE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_VERBALE;

    public DatiSospensione() {
    }

    public DatiSospensione(
           long NUM_PROGRESSIVO,
           java.util.Calendar DATA_VERB_SOSP,
           java.util.Calendar DATA_VERB_RIPR,
           java.lang.String ID_MOTIVO_SOSP,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_SUPERO_TEMPO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_RISERVE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_VERBALE) {
           this.NUM_PROGRESSIVO = NUM_PROGRESSIVO;
           this.DATA_VERB_SOSP = DATA_VERB_SOSP;
           this.DATA_VERB_RIPR = DATA_VERB_RIPR;
           this.ID_MOTIVO_SOSP = ID_MOTIVO_SOSP;
           this.FLAG_SUPERO_TEMPO = FLAG_SUPERO_TEMPO;
           this.FLAG_RISERVE = FLAG_RISERVE;
           this.FLAG_VERBALE = FLAG_VERBALE;
    }


    /**
     * Gets the NUM_PROGRESSIVO value for this DatiSospensione.
     * 
     * @return NUM_PROGRESSIVO
     */
    public long getNUM_PROGRESSIVO() {
        return NUM_PROGRESSIVO;
    }


    /**
     * Sets the NUM_PROGRESSIVO value for this DatiSospensione.
     * 
     * @param NUM_PROGRESSIVO
     */
    public void setNUM_PROGRESSIVO(long NUM_PROGRESSIVO) {
        this.NUM_PROGRESSIVO = NUM_PROGRESSIVO;
    }


    /**
     * Gets the DATA_VERB_SOSP value for this DatiSospensione.
     * 
     * @return DATA_VERB_SOSP
     */
    public java.util.Calendar getDATA_VERB_SOSP() {
        return DATA_VERB_SOSP;
    }


    /**
     * Sets the DATA_VERB_SOSP value for this DatiSospensione.
     * 
     * @param DATA_VERB_SOSP
     */
    public void setDATA_VERB_SOSP(java.util.Calendar DATA_VERB_SOSP) {
        this.DATA_VERB_SOSP = DATA_VERB_SOSP;
    }


    /**
     * Gets the DATA_VERB_RIPR value for this DatiSospensione.
     * 
     * @return DATA_VERB_RIPR
     */
    public java.util.Calendar getDATA_VERB_RIPR() {
        return DATA_VERB_RIPR;
    }


    /**
     * Sets the DATA_VERB_RIPR value for this DatiSospensione.
     * 
     * @param DATA_VERB_RIPR
     */
    public void setDATA_VERB_RIPR(java.util.Calendar DATA_VERB_RIPR) {
        this.DATA_VERB_RIPR = DATA_VERB_RIPR;
    }


    /**
     * Gets the ID_MOTIVO_SOSP value for this DatiSospensione.
     * 
     * @return ID_MOTIVO_SOSP
     */
    public java.lang.String getID_MOTIVO_SOSP() {
        return ID_MOTIVO_SOSP;
    }


    /**
     * Sets the ID_MOTIVO_SOSP value for this DatiSospensione.
     * 
     * @param ID_MOTIVO_SOSP
     */
    public void setID_MOTIVO_SOSP(java.lang.String ID_MOTIVO_SOSP) {
        this.ID_MOTIVO_SOSP = ID_MOTIVO_SOSP;
    }


    /**
     * Gets the FLAG_SUPERO_TEMPO value for this DatiSospensione.
     * 
     * @return FLAG_SUPERO_TEMPO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_SUPERO_TEMPO() {
        return FLAG_SUPERO_TEMPO;
    }


    /**
     * Sets the FLAG_SUPERO_TEMPO value for this DatiSospensione.
     * 
     * @param FLAG_SUPERO_TEMPO
     */
    public void setFLAG_SUPERO_TEMPO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_SUPERO_TEMPO) {
        this.FLAG_SUPERO_TEMPO = FLAG_SUPERO_TEMPO;
    }


    /**
     * Gets the FLAG_RISERVE value for this DatiSospensione.
     * 
     * @return FLAG_RISERVE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_RISERVE() {
        return FLAG_RISERVE;
    }


    /**
     * Sets the FLAG_RISERVE value for this DatiSospensione.
     * 
     * @param FLAG_RISERVE
     */
    public void setFLAG_RISERVE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_RISERVE) {
        this.FLAG_RISERVE = FLAG_RISERVE;
    }


    /**
     * Gets the FLAG_VERBALE value for this DatiSospensione.
     * 
     * @return FLAG_VERBALE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_VERBALE() {
        return FLAG_VERBALE;
    }


    /**
     * Sets the FLAG_VERBALE value for this DatiSospensione.
     * 
     * @param FLAG_VERBALE
     */
    public void setFLAG_VERBALE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_VERBALE) {
        this.FLAG_VERBALE = FLAG_VERBALE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatiSospensione)) return false;
        DatiSospensione other = (DatiSospensione) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.NUM_PROGRESSIVO == other.getNUM_PROGRESSIVO() &&
            ((this.DATA_VERB_SOSP==null && other.getDATA_VERB_SOSP()==null) || 
             (this.DATA_VERB_SOSP!=null &&
              this.DATA_VERB_SOSP.equals(other.getDATA_VERB_SOSP()))) &&
            ((this.DATA_VERB_RIPR==null && other.getDATA_VERB_RIPR()==null) || 
             (this.DATA_VERB_RIPR!=null &&
              this.DATA_VERB_RIPR.equals(other.getDATA_VERB_RIPR()))) &&
            ((this.ID_MOTIVO_SOSP==null && other.getID_MOTIVO_SOSP()==null) || 
             (this.ID_MOTIVO_SOSP!=null &&
              this.ID_MOTIVO_SOSP.equals(other.getID_MOTIVO_SOSP()))) &&
            ((this.FLAG_SUPERO_TEMPO==null && other.getFLAG_SUPERO_TEMPO()==null) || 
             (this.FLAG_SUPERO_TEMPO!=null &&
              this.FLAG_SUPERO_TEMPO.equals(other.getFLAG_SUPERO_TEMPO()))) &&
            ((this.FLAG_RISERVE==null && other.getFLAG_RISERVE()==null) || 
             (this.FLAG_RISERVE!=null &&
              this.FLAG_RISERVE.equals(other.getFLAG_RISERVE()))) &&
            ((this.FLAG_VERBALE==null && other.getFLAG_VERBALE()==null) || 
             (this.FLAG_VERBALE!=null &&
              this.FLAG_VERBALE.equals(other.getFLAG_VERBALE())));
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
        _hashCode += new Long(getNUM_PROGRESSIVO()).hashCode();
        if (getDATA_VERB_SOSP() != null) {
            _hashCode += getDATA_VERB_SOSP().hashCode();
        }
        if (getDATA_VERB_RIPR() != null) {
            _hashCode += getDATA_VERB_RIPR().hashCode();
        }
        if (getID_MOTIVO_SOSP() != null) {
            _hashCode += getID_MOTIVO_SOSP().hashCode();
        }
        if (getFLAG_SUPERO_TEMPO() != null) {
            _hashCode += getFLAG_SUPERO_TEMPO().hashCode();
        }
        if (getFLAG_RISERVE() != null) {
            _hashCode += getFLAG_RISERVE().hashCode();
        }
        if (getFLAG_VERBALE() != null) {
            _hashCode += getFLAG_VERBALE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatiSospensione.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiSospensione"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_PROGRESSIVO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_PROGRESSIVO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_VERB_SOSP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_VERB_SOSP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_VERB_RIPR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_VERB_RIPR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_MOTIVO_SOSP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_MOTIVO_SOSP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_SUPERO_TEMPO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_SUPERO_TEMPO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_RISERVE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_RISERVE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_VERBALE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_VERBALE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
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
