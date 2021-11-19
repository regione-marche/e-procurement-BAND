/**
 * DatiEnte.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class DatiEnte  implements java.io.Serializable {
    private java.lang.String CODICE_FISCALE;

    private java.lang.String ID_USER_ENTE;

    public DatiEnte() {
    }

    public DatiEnte(
           java.lang.String CODICE_FISCALE,
           java.lang.String ID_USER_ENTE) {
           this.CODICE_FISCALE = CODICE_FISCALE;
           this.ID_USER_ENTE = ID_USER_ENTE;
    }


    /**
     * Gets the CODICE_FISCALE value for this DatiEnte.
     * 
     * @return CODICE_FISCALE
     */
    public java.lang.String getCODICE_FISCALE() {
        return CODICE_FISCALE;
    }


    /**
     * Sets the CODICE_FISCALE value for this DatiEnte.
     * 
     * @param CODICE_FISCALE
     */
    public void setCODICE_FISCALE(java.lang.String CODICE_FISCALE) {
        this.CODICE_FISCALE = CODICE_FISCALE;
    }


    /**
     * Gets the ID_USER_ENTE value for this DatiEnte.
     * 
     * @return ID_USER_ENTE
     */
    public java.lang.String getID_USER_ENTE() {
        return ID_USER_ENTE;
    }


    /**
     * Sets the ID_USER_ENTE value for this DatiEnte.
     * 
     * @param ID_USER_ENTE
     */
    public void setID_USER_ENTE(java.lang.String ID_USER_ENTE) {
        this.ID_USER_ENTE = ID_USER_ENTE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatiEnte)) return false;
        DatiEnte other = (DatiEnte) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.CODICE_FISCALE==null && other.getCODICE_FISCALE()==null) || 
             (this.CODICE_FISCALE!=null &&
              this.CODICE_FISCALE.equals(other.getCODICE_FISCALE()))) &&
            ((this.ID_USER_ENTE==null && other.getID_USER_ENTE()==null) || 
             (this.ID_USER_ENTE!=null &&
              this.ID_USER_ENTE.equals(other.getID_USER_ENTE())));
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
        if (getCODICE_FISCALE() != null) {
            _hashCode += getCODICE_FISCALE().hashCode();
        }
        if (getID_USER_ENTE() != null) {
            _hashCode += getID_USER_ENTE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatiEnte.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiEnte"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CODICE_FISCALE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CODICE_FISCALE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_USER_ENTE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_USER_ENTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
