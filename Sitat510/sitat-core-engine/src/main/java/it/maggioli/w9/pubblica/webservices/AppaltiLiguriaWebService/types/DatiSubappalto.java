/**
 * DatiSubappalto.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class DatiSubappalto  implements java.io.Serializable {
    private java.util.Calendar DATA_AUTORIZZAZIONE;

    private java.lang.String OGGETTO_SUBAPPALTO;

    private double IMPORTO_PRESUNTO;

    private double IMPORTO_EFFETTIVO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CategoriaType ID_CATEGORIA;

    private java.lang.String ID_CPV;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari aggiudicatario;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari arch3_impagg;

    public DatiSubappalto() {
    }

    public DatiSubappalto(
           java.util.Calendar DATA_AUTORIZZAZIONE,
           java.lang.String OGGETTO_SUBAPPALTO,
           double IMPORTO_PRESUNTO,
           double IMPORTO_EFFETTIVO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CategoriaType ID_CATEGORIA,
           java.lang.String ID_CPV,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari aggiudicatario,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari arch3_impagg) {
           this.DATA_AUTORIZZAZIONE = DATA_AUTORIZZAZIONE;
           this.OGGETTO_SUBAPPALTO = OGGETTO_SUBAPPALTO;
           this.IMPORTO_PRESUNTO = IMPORTO_PRESUNTO;
           this.IMPORTO_EFFETTIVO = IMPORTO_EFFETTIVO;
           this.ID_CATEGORIA = ID_CATEGORIA;
           this.ID_CPV = ID_CPV;
           this.aggiudicatario = aggiudicatario;
           this.arch3_impagg = arch3_impagg;
    }


    /**
     * Gets the DATA_AUTORIZZAZIONE value for this DatiSubappalto.
     * 
     * @return DATA_AUTORIZZAZIONE
     */
    public java.util.Calendar getDATA_AUTORIZZAZIONE() {
        return DATA_AUTORIZZAZIONE;
    }


    /**
     * Sets the DATA_AUTORIZZAZIONE value for this DatiSubappalto.
     * 
     * @param DATA_AUTORIZZAZIONE
     */
    public void setDATA_AUTORIZZAZIONE(java.util.Calendar DATA_AUTORIZZAZIONE) {
        this.DATA_AUTORIZZAZIONE = DATA_AUTORIZZAZIONE;
    }


    /**
     * Gets the OGGETTO_SUBAPPALTO value for this DatiSubappalto.
     * 
     * @return OGGETTO_SUBAPPALTO
     */
    public java.lang.String getOGGETTO_SUBAPPALTO() {
        return OGGETTO_SUBAPPALTO;
    }


    /**
     * Sets the OGGETTO_SUBAPPALTO value for this DatiSubappalto.
     * 
     * @param OGGETTO_SUBAPPALTO
     */
    public void setOGGETTO_SUBAPPALTO(java.lang.String OGGETTO_SUBAPPALTO) {
        this.OGGETTO_SUBAPPALTO = OGGETTO_SUBAPPALTO;
    }


    /**
     * Gets the IMPORTO_PRESUNTO value for this DatiSubappalto.
     * 
     * @return IMPORTO_PRESUNTO
     */
    public double getIMPORTO_PRESUNTO() {
        return IMPORTO_PRESUNTO;
    }


    /**
     * Sets the IMPORTO_PRESUNTO value for this DatiSubappalto.
     * 
     * @param IMPORTO_PRESUNTO
     */
    public void setIMPORTO_PRESUNTO(double IMPORTO_PRESUNTO) {
        this.IMPORTO_PRESUNTO = IMPORTO_PRESUNTO;
    }


    /**
     * Gets the IMPORTO_EFFETTIVO value for this DatiSubappalto.
     * 
     * @return IMPORTO_EFFETTIVO
     */
    public double getIMPORTO_EFFETTIVO() {
        return IMPORTO_EFFETTIVO;
    }


    /**
     * Sets the IMPORTO_EFFETTIVO value for this DatiSubappalto.
     * 
     * @param IMPORTO_EFFETTIVO
     */
    public void setIMPORTO_EFFETTIVO(double IMPORTO_EFFETTIVO) {
        this.IMPORTO_EFFETTIVO = IMPORTO_EFFETTIVO;
    }


    /**
     * Gets the ID_CATEGORIA value for this DatiSubappalto.
     * 
     * @return ID_CATEGORIA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CategoriaType getID_CATEGORIA() {
        return ID_CATEGORIA;
    }


    /**
     * Sets the ID_CATEGORIA value for this DatiSubappalto.
     * 
     * @param ID_CATEGORIA
     */
    public void setID_CATEGORIA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CategoriaType ID_CATEGORIA) {
        this.ID_CATEGORIA = ID_CATEGORIA;
    }


    /**
     * Gets the ID_CPV value for this DatiSubappalto.
     * 
     * @return ID_CPV
     */
    public java.lang.String getID_CPV() {
        return ID_CPV;
    }


    /**
     * Sets the ID_CPV value for this DatiSubappalto.
     * 
     * @param ID_CPV
     */
    public void setID_CPV(java.lang.String ID_CPV) {
        this.ID_CPV = ID_CPV;
    }


    /**
     * Gets the aggiudicatario value for this DatiSubappalto.
     * 
     * @return aggiudicatario
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari getAggiudicatario() {
        return aggiudicatario;
    }


    /**
     * Sets the aggiudicatario value for this DatiSubappalto.
     * 
     * @param aggiudicatario
     */
    public void setAggiudicatario(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari aggiudicatario) {
        this.aggiudicatario = aggiudicatario;
    }


    /**
     * Gets the arch3_impagg value for this DatiSubappalto.
     * 
     * @return arch3_impagg
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari getArch3_impagg() {
        return arch3_impagg;
    }


    /**
     * Sets the arch3_impagg value for this DatiSubappalto.
     * 
     * @param arch3_impagg
     */
    public void setArch3_impagg(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.DatiAggiudicatari arch3_impagg) {
        this.arch3_impagg = arch3_impagg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatiSubappalto)) return false;
        DatiSubappalto other = (DatiSubappalto) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DATA_AUTORIZZAZIONE==null && other.getDATA_AUTORIZZAZIONE()==null) || 
             (this.DATA_AUTORIZZAZIONE!=null &&
              this.DATA_AUTORIZZAZIONE.equals(other.getDATA_AUTORIZZAZIONE()))) &&
            ((this.OGGETTO_SUBAPPALTO==null && other.getOGGETTO_SUBAPPALTO()==null) || 
             (this.OGGETTO_SUBAPPALTO!=null &&
              this.OGGETTO_SUBAPPALTO.equals(other.getOGGETTO_SUBAPPALTO()))) &&
            this.IMPORTO_PRESUNTO == other.getIMPORTO_PRESUNTO() &&
            this.IMPORTO_EFFETTIVO == other.getIMPORTO_EFFETTIVO() &&
            ((this.ID_CATEGORIA==null && other.getID_CATEGORIA()==null) || 
             (this.ID_CATEGORIA!=null &&
              this.ID_CATEGORIA.equals(other.getID_CATEGORIA()))) &&
            ((this.ID_CPV==null && other.getID_CPV()==null) || 
             (this.ID_CPV!=null &&
              this.ID_CPV.equals(other.getID_CPV()))) &&
            ((this.aggiudicatario==null && other.getAggiudicatario()==null) || 
             (this.aggiudicatario!=null &&
              this.aggiudicatario.equals(other.getAggiudicatario()))) &&
            ((this.arch3_impagg==null && other.getArch3_impagg()==null) || 
             (this.arch3_impagg!=null &&
              this.arch3_impagg.equals(other.getArch3_impagg())));
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
        if (getDATA_AUTORIZZAZIONE() != null) {
            _hashCode += getDATA_AUTORIZZAZIONE().hashCode();
        }
        if (getOGGETTO_SUBAPPALTO() != null) {
            _hashCode += getOGGETTO_SUBAPPALTO().hashCode();
        }
        _hashCode += new Double(getIMPORTO_PRESUNTO()).hashCode();
        _hashCode += new Double(getIMPORTO_EFFETTIVO()).hashCode();
        if (getID_CATEGORIA() != null) {
            _hashCode += getID_CATEGORIA().hashCode();
        }
        if (getID_CPV() != null) {
            _hashCode += getID_CPV().hashCode();
        }
        if (getAggiudicatario() != null) {
            _hashCode += getAggiudicatario().hashCode();
        }
        if (getArch3_impagg() != null) {
            _hashCode += getArch3_impagg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatiSubappalto.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiSubappalto"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_AUTORIZZAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_AUTORIZZAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("OGGETTO_SUBAPPALTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "OGGETTO_SUBAPPALTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_PRESUNTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_PRESUNTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_EFFETTIVO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_EFFETTIVO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_CATEGORIA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_CATEGORIA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CategoriaType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_CPV");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_CPV"));
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
        elemField.setFieldName("arch3_impagg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "arch3_impagg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiAggiudicatari"));
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
