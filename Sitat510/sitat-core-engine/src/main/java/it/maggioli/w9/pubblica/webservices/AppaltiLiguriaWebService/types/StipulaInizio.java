/**
 * StipulaInizio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class StipulaInizio  implements java.io.Serializable {
    private java.util.Calendar DATA_STIPULA;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_RISERVA;

    private java.util.Calendar DATA_VERB_INIZIO;

    private java.util.Calendar DATA_TERMINE;

    public StipulaInizio() {
    }

    public StipulaInizio(
           java.util.Calendar DATA_STIPULA,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_RISERVA,
           java.util.Calendar DATA_VERB_INIZIO,
           java.util.Calendar DATA_TERMINE) {
           this.DATA_STIPULA = DATA_STIPULA;
           this.FLAG_RISERVA = FLAG_RISERVA;
           this.DATA_VERB_INIZIO = DATA_VERB_INIZIO;
           this.DATA_TERMINE = DATA_TERMINE;
    }


    /**
     * Gets the DATA_STIPULA value for this StipulaInizio.
     * 
     * @return DATA_STIPULA
     */
    public java.util.Calendar getDATA_STIPULA() {
        return DATA_STIPULA;
    }


    /**
     * Sets the DATA_STIPULA value for this StipulaInizio.
     * 
     * @param DATA_STIPULA
     */
    public void setDATA_STIPULA(java.util.Calendar DATA_STIPULA) {
        this.DATA_STIPULA = DATA_STIPULA;
    }


    /**
     * Gets the FLAG_RISERVA value for this StipulaInizio.
     * 
     * @return FLAG_RISERVA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getFLAG_RISERVA() {
        return FLAG_RISERVA;
    }


    /**
     * Sets the FLAG_RISERVA value for this StipulaInizio.
     * 
     * @param FLAG_RISERVA
     */
    public void setFLAG_RISERVA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType FLAG_RISERVA) {
        this.FLAG_RISERVA = FLAG_RISERVA;
    }


    /**
     * Gets the DATA_VERB_INIZIO value for this StipulaInizio.
     * 
     * @return DATA_VERB_INIZIO
     */
    public java.util.Calendar getDATA_VERB_INIZIO() {
        return DATA_VERB_INIZIO;
    }


    /**
     * Sets the DATA_VERB_INIZIO value for this StipulaInizio.
     * 
     * @param DATA_VERB_INIZIO
     */
    public void setDATA_VERB_INIZIO(java.util.Calendar DATA_VERB_INIZIO) {
        this.DATA_VERB_INIZIO = DATA_VERB_INIZIO;
    }


    /**
     * Gets the DATA_TERMINE value for this StipulaInizio.
     * 
     * @return DATA_TERMINE
     */
    public java.util.Calendar getDATA_TERMINE() {
        return DATA_TERMINE;
    }


    /**
     * Sets the DATA_TERMINE value for this StipulaInizio.
     * 
     * @param DATA_TERMINE
     */
    public void setDATA_TERMINE(java.util.Calendar DATA_TERMINE) {
        this.DATA_TERMINE = DATA_TERMINE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof StipulaInizio)) return false;
        StipulaInizio other = (StipulaInizio) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DATA_STIPULA==null && other.getDATA_STIPULA()==null) || 
             (this.DATA_STIPULA!=null &&
              this.DATA_STIPULA.equals(other.getDATA_STIPULA()))) &&
            ((this.FLAG_RISERVA==null && other.getFLAG_RISERVA()==null) || 
             (this.FLAG_RISERVA!=null &&
              this.FLAG_RISERVA.equals(other.getFLAG_RISERVA()))) &&
            ((this.DATA_VERB_INIZIO==null && other.getDATA_VERB_INIZIO()==null) || 
             (this.DATA_VERB_INIZIO!=null &&
              this.DATA_VERB_INIZIO.equals(other.getDATA_VERB_INIZIO()))) &&
            ((this.DATA_TERMINE==null && other.getDATA_TERMINE()==null) || 
             (this.DATA_TERMINE!=null &&
              this.DATA_TERMINE.equals(other.getDATA_TERMINE())));
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
        if (getDATA_STIPULA() != null) {
            _hashCode += getDATA_STIPULA().hashCode();
        }
        if (getFLAG_RISERVA() != null) {
            _hashCode += getFLAG_RISERVA().hashCode();
        }
        if (getDATA_VERB_INIZIO() != null) {
            _hashCode += getDATA_VERB_INIZIO().hashCode();
        }
        if (getDATA_TERMINE() != null) {
            _hashCode += getDATA_TERMINE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(StipulaInizio.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "StipulaInizio"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_STIPULA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_STIPULA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_RISERVA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_RISERVA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_VERB_INIZIO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_VERB_INIZIO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_TERMINE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_TERMINE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
