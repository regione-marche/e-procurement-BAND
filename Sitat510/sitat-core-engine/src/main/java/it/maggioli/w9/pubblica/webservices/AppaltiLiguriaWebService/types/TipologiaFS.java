/**
 * TipologiaFS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

import javax.xml.bind.annotation.XmlValue;

public class TipologiaFS  implements java.io.Serializable {
    private java.lang.String ID_APPALTO_FS;

    public TipologiaFS() {
    }

    public TipologiaFS(
           java.lang.String ID_APPALTO_FS) {
           this.ID_APPALTO_FS = ID_APPALTO_FS;
    }


    /**
     * Gets the ID_APPALTO_FS value for this TipologiaFS.
     * 
     * @return ID_APPALTO_FS
     */
    public java.lang.String getID_APPALTO_FS() {
        return ID_APPALTO_FS;
    }


    /**
     * Sets the ID_APPALTO_FS value for this TipologiaFS.
     * 
     * @param ID_APPALTO_FS
     */
    @XmlValue
    public void setID_APPALTO_FS(java.lang.String ID_APPALTO_FS) {
        this.ID_APPALTO_FS = ID_APPALTO_FS;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TipologiaFS)) return false;
        TipologiaFS other = (TipologiaFS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ID_APPALTO_FS==null && other.getID_APPALTO_FS()==null) || 
             (this.ID_APPALTO_FS!=null &&
              this.ID_APPALTO_FS.equals(other.getID_APPALTO_FS())));
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
        if (getID_APPALTO_FS() != null) {
            _hashCode += getID_APPALTO_FS().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TipologiaFS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TipologiaFS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_APPALTO_FS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_APPALTO_FS"));
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
