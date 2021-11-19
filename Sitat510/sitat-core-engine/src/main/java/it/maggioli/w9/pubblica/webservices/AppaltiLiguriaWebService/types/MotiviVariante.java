/**
 * MotiviVariante.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

import javax.xml.bind.annotation.XmlValue;

public class MotiviVariante  implements java.io.Serializable {
    private java.lang.String ID_MOTIVO_VAR;

    public MotiviVariante() {
    }

    public MotiviVariante(
           java.lang.String ID_MOTIVO_VAR) {
           this.ID_MOTIVO_VAR = ID_MOTIVO_VAR;
    }


    /**
     * Gets the ID_MOTIVO_VAR value for this MotiviVariante.
     * 
     * @return ID_MOTIVO_VAR
     */
    public java.lang.String getID_MOTIVO_VAR() {
        return ID_MOTIVO_VAR;
    }


    /**
     * Sets the ID_MOTIVO_VAR value for this MotiviVariante.
     * 
     * @param ID_MOTIVO_VAR
     */
    @XmlValue
    public void setID_MOTIVO_VAR(java.lang.String ID_MOTIVO_VAR) {
        this.ID_MOTIVO_VAR = ID_MOTIVO_VAR;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MotiviVariante)) return false;
        MotiviVariante other = (MotiviVariante) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ID_MOTIVO_VAR==null && other.getID_MOTIVO_VAR()==null) || 
             (this.ID_MOTIVO_VAR!=null &&
              this.ID_MOTIVO_VAR.equals(other.getID_MOTIVO_VAR())));
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
        if (getID_MOTIVO_VAR() != null) {
            _hashCode += getID_MOTIVO_VAR().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MotiviVariante.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "MotiviVariante"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_MOTIVO_VAR");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_MOTIVO_VAR"));
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
