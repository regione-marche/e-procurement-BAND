/**
 * SezioneInizio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class SezioneInizio  implements java.io.Serializable {
    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiInizio DATI_INIZIO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Pubblicazione PUBBLICAZIONE_INIZIO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi[] LISTA_DATI_SOGGETTI_ESTESI_INIZIO;

    public SezioneInizio() {
    }

    public SezioneInizio(
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiInizio DATI_INIZIO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Pubblicazione PUBBLICAZIONE_INIZIO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi[] LISTA_DATI_SOGGETTI_ESTESI_INIZIO) {
           this.DATI_INIZIO = DATI_INIZIO;
           this.PUBBLICAZIONE_INIZIO = PUBBLICAZIONE_INIZIO;
           this.LISTA_DATI_SOGGETTI_ESTESI_INIZIO = LISTA_DATI_SOGGETTI_ESTESI_INIZIO;
    }


    /**
     * Gets the DATI_INIZIO value for this SezioneInizio.
     * 
     * @return DATI_INIZIO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiInizio getDATI_INIZIO() {
        return DATI_INIZIO;
    }


    /**
     * Sets the DATI_INIZIO value for this SezioneInizio.
     * 
     * @param DATI_INIZIO
     */
    public void setDATI_INIZIO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiInizio DATI_INIZIO) {
        this.DATI_INIZIO = DATI_INIZIO;
    }


    /**
     * Gets the PUBBLICAZIONE_INIZIO value for this SezioneInizio.
     * 
     * @return PUBBLICAZIONE_INIZIO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Pubblicazione getPUBBLICAZIONE_INIZIO() {
        return PUBBLICAZIONE_INIZIO;
    }


    /**
     * Sets the PUBBLICAZIONE_INIZIO value for this SezioneInizio.
     * 
     * @param PUBBLICAZIONE_INIZIO
     */
    public void setPUBBLICAZIONE_INIZIO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Pubblicazione PUBBLICAZIONE_INIZIO) {
        this.PUBBLICAZIONE_INIZIO = PUBBLICAZIONE_INIZIO;
    }


    /**
     * Gets the LISTA_DATI_SOGGETTI_ESTESI_INIZIO value for this SezioneInizio.
     * 
     * @return LISTA_DATI_SOGGETTI_ESTESI_INIZIO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi[] getLISTA_DATI_SOGGETTI_ESTESI_INIZIO() {
        return LISTA_DATI_SOGGETTI_ESTESI_INIZIO;
    }


    /**
     * Sets the LISTA_DATI_SOGGETTI_ESTESI_INIZIO value for this SezioneInizio.
     * 
     * @param LISTA_DATI_SOGGETTI_ESTESI_INIZIO
     */
    public void setLISTA_DATI_SOGGETTI_ESTESI_INIZIO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi[] LISTA_DATI_SOGGETTI_ESTESI_INIZIO) {
        this.LISTA_DATI_SOGGETTI_ESTESI_INIZIO = LISTA_DATI_SOGGETTI_ESTESI_INIZIO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SezioneInizio)) return false;
        SezioneInizio other = (SezioneInizio) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DATI_INIZIO==null && other.getDATI_INIZIO()==null) || 
             (this.DATI_INIZIO!=null &&
              this.DATI_INIZIO.equals(other.getDATI_INIZIO()))) &&
            ((this.PUBBLICAZIONE_INIZIO==null && other.getPUBBLICAZIONE_INIZIO()==null) || 
             (this.PUBBLICAZIONE_INIZIO!=null &&
              this.PUBBLICAZIONE_INIZIO.equals(other.getPUBBLICAZIONE_INIZIO()))) &&
            ((this.LISTA_DATI_SOGGETTI_ESTESI_INIZIO==null && other.getLISTA_DATI_SOGGETTI_ESTESI_INIZIO()==null) || 
             (this.LISTA_DATI_SOGGETTI_ESTESI_INIZIO!=null &&
              java.util.Arrays.equals(this.LISTA_DATI_SOGGETTI_ESTESI_INIZIO, other.getLISTA_DATI_SOGGETTI_ESTESI_INIZIO())));
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
        if (getDATI_INIZIO() != null) {
            _hashCode += getDATI_INIZIO().hashCode();
        }
        if (getPUBBLICAZIONE_INIZIO() != null) {
            _hashCode += getPUBBLICAZIONE_INIZIO().hashCode();
        }
        if (getLISTA_DATI_SOGGETTI_ESTESI_INIZIO() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLISTA_DATI_SOGGETTI_ESTESI_INIZIO());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLISTA_DATI_SOGGETTI_ESTESI_INIZIO(), i);
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
        new org.apache.axis.description.TypeDesc(SezioneInizio.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneInizio"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATI_INIZIO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATI_INIZIO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiInizio"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PUBBLICAZIONE_INIZIO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "PUBBLICAZIONE_INIZIO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Pubblicazione"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LISTA_DATI_SOGGETTI_ESTESI_INIZIO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "LISTA_DATI_SOGGETTI_ESTESI_INIZIO"));
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
