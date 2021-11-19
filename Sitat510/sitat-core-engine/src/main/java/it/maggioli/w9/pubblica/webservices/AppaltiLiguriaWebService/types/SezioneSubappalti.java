/**
 * SezioneSubappalti.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class SezioneSubappalti  implements java.io.Serializable {
    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSubappalto[] DATI_SUBAPPALTI;

    public SezioneSubappalti() {
    }

    public SezioneSubappalti(
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSubappalto[] DATI_SUBAPPALTI) {
           this.DATI_SUBAPPALTI = DATI_SUBAPPALTI;
    }


    /**
     * Gets the DATI_SUBAPPALTI value for this SezioneSubappalti.
     * 
     * @return DATI_SUBAPPALTI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSubappalto[] getDATI_SUBAPPALTI() {
        return DATI_SUBAPPALTI;
    }


    /**
     * Sets the DATI_SUBAPPALTI value for this SezioneSubappalti.
     * 
     * @param DATI_SUBAPPALTI
     */
    public void setDATI_SUBAPPALTI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSubappalto[] DATI_SUBAPPALTI) {
        this.DATI_SUBAPPALTI = DATI_SUBAPPALTI;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SezioneSubappalti)) return false;
        SezioneSubappalti other = (SezioneSubappalti) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DATI_SUBAPPALTI==null && other.getDATI_SUBAPPALTI()==null) || 
             (this.DATI_SUBAPPALTI!=null &&
              java.util.Arrays.equals(this.DATI_SUBAPPALTI, other.getDATI_SUBAPPALTI())));
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
        if (getDATI_SUBAPPALTI() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDATI_SUBAPPALTI());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDATI_SUBAPPALTI(), i);
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
        new org.apache.axis.description.TypeDesc(SezioneSubappalti.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneSubappalti"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATI_SUBAPPALTI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATI_SUBAPPALTI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiSubappalto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_DatiSubappalto"));
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
