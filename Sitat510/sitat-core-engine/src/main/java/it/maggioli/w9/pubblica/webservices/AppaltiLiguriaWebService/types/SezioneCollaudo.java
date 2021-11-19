/**
 * SezioneCollaudo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class SezioneCollaudo  implements java.io.Serializable {
    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiCollaudo DATI_COLLAUDO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi[] LISTA_DATI_SOGGETTI_ESTESI_COLL;

    public SezioneCollaudo() {
    }

    public SezioneCollaudo(
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiCollaudo DATI_COLLAUDO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi[] LISTA_DATI_SOGGETTI_ESTESI_COLL) {
           this.DATI_COLLAUDO = DATI_COLLAUDO;
           this.LISTA_DATI_SOGGETTI_ESTESI_COLL = LISTA_DATI_SOGGETTI_ESTESI_COLL;
    }


    /**
     * Gets the DATI_COLLAUDO value for this SezioneCollaudo.
     * 
     * @return DATI_COLLAUDO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiCollaudo getDATI_COLLAUDO() {
        return DATI_COLLAUDO;
    }


    /**
     * Sets the DATI_COLLAUDO value for this SezioneCollaudo.
     * 
     * @param DATI_COLLAUDO
     */
    public void setDATI_COLLAUDO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiCollaudo DATI_COLLAUDO) {
        this.DATI_COLLAUDO = DATI_COLLAUDO;
    }


    /**
     * Gets the LISTA_DATI_SOGGETTI_ESTESI_COLL value for this SezioneCollaudo.
     * 
     * @return LISTA_DATI_SOGGETTI_ESTESI_COLL
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi[] getLISTA_DATI_SOGGETTI_ESTESI_COLL() {
        return LISTA_DATI_SOGGETTI_ESTESI_COLL;
    }


    /**
     * Sets the LISTA_DATI_SOGGETTI_ESTESI_COLL value for this SezioneCollaudo.
     * 
     * @param LISTA_DATI_SOGGETTI_ESTESI_COLL
     */
    public void setLISTA_DATI_SOGGETTI_ESTESI_COLL(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi[] LISTA_DATI_SOGGETTI_ESTESI_COLL) {
        this.LISTA_DATI_SOGGETTI_ESTESI_COLL = LISTA_DATI_SOGGETTI_ESTESI_COLL;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SezioneCollaudo)) return false;
        SezioneCollaudo other = (SezioneCollaudo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DATI_COLLAUDO==null && other.getDATI_COLLAUDO()==null) || 
             (this.DATI_COLLAUDO!=null &&
              this.DATI_COLLAUDO.equals(other.getDATI_COLLAUDO()))) &&
            ((this.LISTA_DATI_SOGGETTI_ESTESI_COLL==null && other.getLISTA_DATI_SOGGETTI_ESTESI_COLL()==null) || 
             (this.LISTA_DATI_SOGGETTI_ESTESI_COLL!=null &&
              java.util.Arrays.equals(this.LISTA_DATI_SOGGETTI_ESTESI_COLL, other.getLISTA_DATI_SOGGETTI_ESTESI_COLL())));
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
        if (getDATI_COLLAUDO() != null) {
            _hashCode += getDATI_COLLAUDO().hashCode();
        }
        if (getLISTA_DATI_SOGGETTI_ESTESI_COLL() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLISTA_DATI_SOGGETTI_ESTESI_COLL());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLISTA_DATI_SOGGETTI_ESTESI_COLL(), i);
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
        new org.apache.axis.description.TypeDesc(SezioneCollaudo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneCollaudo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATI_COLLAUDO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATI_COLLAUDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiCollaudo"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LISTA_DATI_SOGGETTI_ESTESI_COLL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "LISTA_DATI_SOGGETTI_ESTESI_COLL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiSoggettiEstesi"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_DatiSoggettiEstesi"));
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
