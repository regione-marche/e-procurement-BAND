/**
 * SezioneAggiudicazione.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class SezioneAggiudicazione  implements java.io.Serializable {
    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicazione DATI_AGGIUDICAZIONE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Pubblicazione PUBBLICAZIONE_AGGIUDICAZIONE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Finanziamenti[] LISTA_FINANZIAMENTI;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Categorie[] LISTA_CATEGORIE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Aggiudicatario[] LISTA_AGGIUDICATARI;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi[] LISTA_DATI_SOGGETTI_ESTESI_AGG;

    public SezioneAggiudicazione() {
    }

    public SezioneAggiudicazione(
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicazione DATI_AGGIUDICAZIONE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Pubblicazione PUBBLICAZIONE_AGGIUDICAZIONE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Finanziamenti[] LISTA_FINANZIAMENTI,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Categorie[] LISTA_CATEGORIE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Aggiudicatario[] LISTA_AGGIUDICATARI,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi[] LISTA_DATI_SOGGETTI_ESTESI_AGG) {
           this.DATI_AGGIUDICAZIONE = DATI_AGGIUDICAZIONE;
           this.PUBBLICAZIONE_AGGIUDICAZIONE = PUBBLICAZIONE_AGGIUDICAZIONE;
           this.LISTA_FINANZIAMENTI = LISTA_FINANZIAMENTI;
           this.LISTA_CATEGORIE = LISTA_CATEGORIE;
           this.LISTA_AGGIUDICATARI = LISTA_AGGIUDICATARI;
           this.LISTA_DATI_SOGGETTI_ESTESI_AGG = LISTA_DATI_SOGGETTI_ESTESI_AGG;
    }


    /**
     * Gets the DATI_AGGIUDICAZIONE value for this SezioneAggiudicazione.
     * 
     * @return DATI_AGGIUDICAZIONE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicazione getDATI_AGGIUDICAZIONE() {
        return DATI_AGGIUDICAZIONE;
    }


    /**
     * Sets the DATI_AGGIUDICAZIONE value for this SezioneAggiudicazione.
     * 
     * @param DATI_AGGIUDICAZIONE
     */
    public void setDATI_AGGIUDICAZIONE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicazione DATI_AGGIUDICAZIONE) {
        this.DATI_AGGIUDICAZIONE = DATI_AGGIUDICAZIONE;
    }


    /**
     * Gets the PUBBLICAZIONE_AGGIUDICAZIONE value for this SezioneAggiudicazione.
     * 
     * @return PUBBLICAZIONE_AGGIUDICAZIONE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Pubblicazione getPUBBLICAZIONE_AGGIUDICAZIONE() {
        return PUBBLICAZIONE_AGGIUDICAZIONE;
    }


    /**
     * Sets the PUBBLICAZIONE_AGGIUDICAZIONE value for this SezioneAggiudicazione.
     * 
     * @param PUBBLICAZIONE_AGGIUDICAZIONE
     */
    public void setPUBBLICAZIONE_AGGIUDICAZIONE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Pubblicazione PUBBLICAZIONE_AGGIUDICAZIONE) {
        this.PUBBLICAZIONE_AGGIUDICAZIONE = PUBBLICAZIONE_AGGIUDICAZIONE;
    }


    /**
     * Gets the LISTA_FINANZIAMENTI value for this SezioneAggiudicazione.
     * 
     * @return LISTA_FINANZIAMENTI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Finanziamenti[] getLISTA_FINANZIAMENTI() {
        return LISTA_FINANZIAMENTI;
    }


    /**
     * Sets the LISTA_FINANZIAMENTI value for this SezioneAggiudicazione.
     * 
     * @param LISTA_FINANZIAMENTI
     */
    public void setLISTA_FINANZIAMENTI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Finanziamenti[] LISTA_FINANZIAMENTI) {
        this.LISTA_FINANZIAMENTI = LISTA_FINANZIAMENTI;
    }


    /**
     * Gets the LISTA_CATEGORIE value for this SezioneAggiudicazione.
     * 
     * @return LISTA_CATEGORIE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Categorie[] getLISTA_CATEGORIE() {
        return LISTA_CATEGORIE;
    }


    /**
     * Sets the LISTA_CATEGORIE value for this SezioneAggiudicazione.
     * 
     * @param LISTA_CATEGORIE
     */
    public void setLISTA_CATEGORIE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Categorie[] LISTA_CATEGORIE) {
        this.LISTA_CATEGORIE = LISTA_CATEGORIE;
    }


    /**
     * Gets the LISTA_AGGIUDICATARI value for this SezioneAggiudicazione.
     * 
     * @return LISTA_AGGIUDICATARI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Aggiudicatario[] getLISTA_AGGIUDICATARI() {
        return LISTA_AGGIUDICATARI;
    }


    /**
     * Sets the LISTA_AGGIUDICATARI value for this SezioneAggiudicazione.
     * 
     * @param LISTA_AGGIUDICATARI
     */
    public void setLISTA_AGGIUDICATARI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.Aggiudicatario[] LISTA_AGGIUDICATARI) {
        this.LISTA_AGGIUDICATARI = LISTA_AGGIUDICATARI;
    }


    /**
     * Gets the LISTA_DATI_SOGGETTI_ESTESI_AGG value for this SezioneAggiudicazione.
     * 
     * @return LISTA_DATI_SOGGETTI_ESTESI_AGG
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi[] getLISTA_DATI_SOGGETTI_ESTESI_AGG() {
        return LISTA_DATI_SOGGETTI_ESTESI_AGG;
    }


    /**
     * Sets the LISTA_DATI_SOGGETTI_ESTESI_AGG value for this SezioneAggiudicazione.
     * 
     * @param LISTA_DATI_SOGGETTI_ESTESI_AGG
     */
    public void setLISTA_DATI_SOGGETTI_ESTESI_AGG(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiSoggettiEstesi[] LISTA_DATI_SOGGETTI_ESTESI_AGG) {
        this.LISTA_DATI_SOGGETTI_ESTESI_AGG = LISTA_DATI_SOGGETTI_ESTESI_AGG;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SezioneAggiudicazione)) return false;
        SezioneAggiudicazione other = (SezioneAggiudicazione) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DATI_AGGIUDICAZIONE==null && other.getDATI_AGGIUDICAZIONE()==null) || 
             (this.DATI_AGGIUDICAZIONE!=null &&
              this.DATI_AGGIUDICAZIONE.equals(other.getDATI_AGGIUDICAZIONE()))) &&
            ((this.PUBBLICAZIONE_AGGIUDICAZIONE==null && other.getPUBBLICAZIONE_AGGIUDICAZIONE()==null) || 
             (this.PUBBLICAZIONE_AGGIUDICAZIONE!=null &&
              this.PUBBLICAZIONE_AGGIUDICAZIONE.equals(other.getPUBBLICAZIONE_AGGIUDICAZIONE()))) &&
            ((this.LISTA_FINANZIAMENTI==null && other.getLISTA_FINANZIAMENTI()==null) || 
             (this.LISTA_FINANZIAMENTI!=null &&
              java.util.Arrays.equals(this.LISTA_FINANZIAMENTI, other.getLISTA_FINANZIAMENTI()))) &&
            ((this.LISTA_CATEGORIE==null && other.getLISTA_CATEGORIE()==null) || 
             (this.LISTA_CATEGORIE!=null &&
              java.util.Arrays.equals(this.LISTA_CATEGORIE, other.getLISTA_CATEGORIE()))) &&
            ((this.LISTA_AGGIUDICATARI==null && other.getLISTA_AGGIUDICATARI()==null) || 
             (this.LISTA_AGGIUDICATARI!=null &&
              java.util.Arrays.equals(this.LISTA_AGGIUDICATARI, other.getLISTA_AGGIUDICATARI()))) &&
            ((this.LISTA_DATI_SOGGETTI_ESTESI_AGG==null && other.getLISTA_DATI_SOGGETTI_ESTESI_AGG()==null) || 
             (this.LISTA_DATI_SOGGETTI_ESTESI_AGG!=null &&
              java.util.Arrays.equals(this.LISTA_DATI_SOGGETTI_ESTESI_AGG, other.getLISTA_DATI_SOGGETTI_ESTESI_AGG())));
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
        if (getDATI_AGGIUDICAZIONE() != null) {
            _hashCode += getDATI_AGGIUDICAZIONE().hashCode();
        }
        if (getPUBBLICAZIONE_AGGIUDICAZIONE() != null) {
            _hashCode += getPUBBLICAZIONE_AGGIUDICAZIONE().hashCode();
        }
        if (getLISTA_FINANZIAMENTI() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLISTA_FINANZIAMENTI());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLISTA_FINANZIAMENTI(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLISTA_CATEGORIE() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLISTA_CATEGORIE());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLISTA_CATEGORIE(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLISTA_AGGIUDICATARI() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLISTA_AGGIUDICATARI());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLISTA_AGGIUDICATARI(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getLISTA_DATI_SOGGETTI_ESTESI_AGG() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLISTA_DATI_SOGGETTI_ESTESI_AGG());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLISTA_DATI_SOGGETTI_ESTESI_AGG(), i);
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
        new org.apache.axis.description.TypeDesc(SezioneAggiudicazione.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SezioneAggiudicazione"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATI_AGGIUDICAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATI_AGGIUDICAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiAggiudicazione"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PUBBLICAZIONE_AGGIUDICAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "PUBBLICAZIONE_AGGIUDICAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Pubblicazione"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LISTA_FINANZIAMENTI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "LISTA_FINANZIAMENTI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Finanziamenti"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_Finanziamenti"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LISTA_CATEGORIE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "LISTA_CATEGORIE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Categorie"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_Categorie"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LISTA_AGGIUDICATARI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "LISTA_AGGIUDICATARI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Aggiudicatario"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Id_Aggiudicatari"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LISTA_DATI_SOGGETTI_ESTESI_AGG");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "LISTA_DATI_SOGGETTI_ESTESI_AGG"));
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
