/**
 * SezioneAccordiBonari.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class SezioneAccordiBonari  implements java.io.Serializable {
    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAccordo[] DATI_ACCORDI_BONARI;

    public SezioneAccordiBonari() {
    }

    public SezioneAccordiBonari(
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAccordo[] DATI_ACCORDI_BONARI) {
           this.DATI_ACCORDI_BONARI = DATI_ACCORDI_BONARI;
    }


    /**
     * Gets the DATI_ACCORDI_BONARI value for this SezioneAccordiBonari.
     * 
     * @return DATI_ACCORDI_BONARI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAccordo[] getDATI_ACCORDI_BONARI() {
        return DATI_ACCORDI_BONARI;
    }


    /**
     * Sets the DATI_ACCORDI_BONARI value for this SezioneAccordiBonari.
     * 
     * @param DATI_ACCORDI_BONARI
     */
    public void setDATI_ACCORDI_BONARI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAccordo[] DATI_ACCORDI_BONARI) {
        this.DATI_ACCORDI_BONARI = DATI_ACCORDI_BONARI;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SezioneAccordiBonari)) return false;
        SezioneAccordiBonari other = (SezioneAccordiBonari) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DATI_ACCORDI_BONARI==null && other.getDATI_ACCORDI_BONARI()==null) || 
             (this.DATI_ACCORDI_BONARI!=null &&
              java.util.Arrays.equals(this.DATI_ACCORDI_BONARI, other.getDATI_ACCORDI_BONARI())));
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
        if (getDATI_ACCORDI_BONARI() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDATI_ACCORDI_BONARI());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDATI_ACCORDI_BONARI(), i);
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
        new org.apache.axis.description.TypeDesc(SezioneAccordiBonari.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneAccordiBonari"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATI_ACCORDI_BONARI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATI_ACCORDI_BONARI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiAccordo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_DatiAccordiBonari"));
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
