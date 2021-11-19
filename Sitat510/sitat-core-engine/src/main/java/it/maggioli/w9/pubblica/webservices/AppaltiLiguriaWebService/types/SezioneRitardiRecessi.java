/**
 * SezioneRitardiRecessi.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class SezioneRitardiRecessi  implements java.io.Serializable {
    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiRecesso[] DATI_RITARDI_RECESSI;

    public SezioneRitardiRecessi() {
    }

    public SezioneRitardiRecessi(
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiRecesso[] DATI_RITARDI_RECESSI) {
           this.DATI_RITARDI_RECESSI = DATI_RITARDI_RECESSI;
    }


    /**
     * Gets the DATI_RITARDI_RECESSI value for this SezioneRitardiRecessi.
     * 
     * @return DATI_RITARDI_RECESSI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiRecesso[] getDATI_RITARDI_RECESSI() {
        return DATI_RITARDI_RECESSI;
    }


    /**
     * Sets the DATI_RITARDI_RECESSI value for this SezioneRitardiRecessi.
     * 
     * @param DATI_RITARDI_RECESSI
     */
    public void setDATI_RITARDI_RECESSI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiRecesso[] DATI_RITARDI_RECESSI) {
        this.DATI_RITARDI_RECESSI = DATI_RITARDI_RECESSI;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SezioneRitardiRecessi)) return false;
        SezioneRitardiRecessi other = (SezioneRitardiRecessi) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DATI_RITARDI_RECESSI==null && other.getDATI_RITARDI_RECESSI()==null) || 
             (this.DATI_RITARDI_RECESSI!=null &&
              java.util.Arrays.equals(this.DATI_RITARDI_RECESSI, other.getDATI_RITARDI_RECESSI())));
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
        if (getDATI_RITARDI_RECESSI() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDATI_RITARDI_RECESSI());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDATI_RITARDI_RECESSI(), i);
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
        new org.apache.axis.description.TypeDesc(SezioneRitardiRecessi.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneRitardiRecessi"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATI_RITARDI_RECESSI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATI_RITARDI_RECESSI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiRecesso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_DatiRitardiRecessi"));
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
