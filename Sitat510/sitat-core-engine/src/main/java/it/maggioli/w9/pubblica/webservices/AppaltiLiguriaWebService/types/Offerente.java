/**
 * Offerente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

import javax.xml.bind.annotation.XmlValue;

public class Offerente  implements java.io.Serializable {
    private java.lang.String TIPOLOGIA_SOGGETTO;

    private java.lang.String flagPartecipante;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari aggiudicatario;

    private java.lang.String RUOLO;

    private java.lang.Integer ID_GRUPPO;

    public Offerente() {
    }

    public Offerente(
           java.lang.String TIPOLOGIA_SOGGETTO,
           java.lang.String flagPartecipante,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari aggiudicatario,
           java.lang.String RUOLO,
           java.lang.Integer ID_GRUPPO) {
           this.TIPOLOGIA_SOGGETTO = TIPOLOGIA_SOGGETTO;
           this.flagPartecipante = flagPartecipante;
           this.aggiudicatario = aggiudicatario;
           this.RUOLO = RUOLO;
           this.ID_GRUPPO = ID_GRUPPO;
    }


    /**
     * Gets the TIPOLOGIA_SOGGETTO value for this Offerente.
     * 
     * @return TIPOLOGIA_SOGGETTO
     */
    public java.lang.String getTIPOLOGIA_SOGGETTO() {
        return TIPOLOGIA_SOGGETTO;
    }


    /**
     * Sets the TIPOLOGIA_SOGGETTO value for this Offerente.
     * 
     * @param TIPOLOGIA_SOGGETTO
     */
    public void setTIPOLOGIA_SOGGETTO(java.lang.String TIPOLOGIA_SOGGETTO) {
        this.TIPOLOGIA_SOGGETTO = TIPOLOGIA_SOGGETTO;
    }


    /**
     * Gets the flagPartecipante value for this Offerente.
     * 
     * @return flagPartecipante
     */
    public java.lang.String getFlagPartecipante() {
        return flagPartecipante;
    }


    /**
     * Sets the flagPartecipante value for this Offerente.
     * 
     * @param flagPartecipante
     */
    public void setFlagPartecipante(java.lang.String flagPartecipante) {
        this.flagPartecipante = flagPartecipante;
    }


    /**
     * Gets the aggiudicatario value for this Offerente.
     * 
     * @return aggiudicatario
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari getAggiudicatario() {
        return aggiudicatario;
    }


    /**
     * Sets the aggiudicatario value for this Offerente.
     * 
     * @param aggiudicatario
     */
    public void setAggiudicatario(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari aggiudicatario) {
        this.aggiudicatario = aggiudicatario;
    }


    /**
     * Gets the RUOLO value for this Offerente.
     * 
     * @return RUOLO
     */
    public java.lang.String getRUOLO() {
        return RUOLO;
    }


    /**
     * Sets the RUOLO value for this Offerente.
     * 
     * @param RUOLO
     */
    public void setRUOLO(java.lang.String RUOLO) {
        this.RUOLO = RUOLO;
    }


    /**
     * Gets the ID_GRUPPO value for this Offerente.
     * 
     * @return ID_GRUPPO
     */
    public java.lang.Integer getID_GRUPPO() {
        return ID_GRUPPO;
    }


    /**
     * Sets the ID_GRUPPO value for this Offerente.
     * 
     * @param ID_GRUPPO
     */
    public void setID_GRUPPO(java.lang.Integer ID_GRUPPO) {
        this.ID_GRUPPO = ID_GRUPPO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Offerente)) return false;
        Offerente other = (Offerente) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.TIPOLOGIA_SOGGETTO==null && other.getTIPOLOGIA_SOGGETTO()==null) || 
             (this.TIPOLOGIA_SOGGETTO!=null &&
              this.TIPOLOGIA_SOGGETTO.equals(other.getTIPOLOGIA_SOGGETTO()))) &&
            ((this.flagPartecipante==null && other.getFlagPartecipante()==null) || 
             (this.flagPartecipante!=null &&
              this.flagPartecipante.equals(other.getFlagPartecipante()))) &&
            ((this.aggiudicatario==null && other.getAggiudicatario()==null) || 
             (this.aggiudicatario!=null &&
              this.aggiudicatario.equals(other.getAggiudicatario()))) &&
            ((this.RUOLO==null && other.getRUOLO()==null) || 
             (this.RUOLO!=null &&
              this.RUOLO.equals(other.getRUOLO()))) &&
            ((this.ID_GRUPPO==null && other.getID_GRUPPO()==null) || 
             (this.ID_GRUPPO!=null &&
              this.ID_GRUPPO.equals(other.getID_GRUPPO())));
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
        if (getTIPOLOGIA_SOGGETTO() != null) {
            _hashCode += getTIPOLOGIA_SOGGETTO().hashCode();
        }
        if (getFlagPartecipante() != null) {
            _hashCode += getFlagPartecipante().hashCode();
        }
        if (getAggiudicatario() != null) {
            _hashCode += getAggiudicatario().hashCode();
        }
        if (getRUOLO() != null) {
            _hashCode += getRUOLO().hashCode();
        }
        if (getID_GRUPPO() != null) {
            _hashCode += getID_GRUPPO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Offerente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Offerente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TIPOLOGIA_SOGGETTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "TIPOLOGIA_SOGGETTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("flagPartecipante");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagPartecipante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("aggiudicatario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "aggiudicatario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiAggiudicatari"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RUOLO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "RUOLO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_GRUPPO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_GRUPPO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
