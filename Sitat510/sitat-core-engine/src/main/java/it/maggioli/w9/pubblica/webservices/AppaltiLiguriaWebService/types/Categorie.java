/**
 * Categorie.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class Categorie  implements java.io.Serializable {
    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CategoriaType ID_CATEGORIA;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.ClasseImportoType CLASSE_IMPORTO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType PREVALENTE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType SCORPORABILE;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType SUBAPPALTABILE;

    public Categorie() {
    }

    public Categorie(
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CategoriaType ID_CATEGORIA,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.ClasseImportoType CLASSE_IMPORTO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType PREVALENTE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType SCORPORABILE,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType SUBAPPALTABILE) {
           this.ID_CATEGORIA = ID_CATEGORIA;
           this.CLASSE_IMPORTO = CLASSE_IMPORTO;
           this.PREVALENTE = PREVALENTE;
           this.SCORPORABILE = SCORPORABILE;
           this.SUBAPPALTABILE = SUBAPPALTABILE;
    }


    /**
     * Gets the ID_CATEGORIA value for this Categorie.
     * 
     * @return ID_CATEGORIA
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CategoriaType getID_CATEGORIA() {
        return ID_CATEGORIA;
    }


    /**
     * Sets the ID_CATEGORIA value for this Categorie.
     * 
     * @param ID_CATEGORIA
     */
    public void setID_CATEGORIA(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.CategoriaType ID_CATEGORIA) {
        this.ID_CATEGORIA = ID_CATEGORIA;
    }


    /**
     * Gets the CLASSE_IMPORTO value for this Categorie.
     * 
     * @return CLASSE_IMPORTO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.ClasseImportoType getCLASSE_IMPORTO() {
        return CLASSE_IMPORTO;
    }


    /**
     * Sets the CLASSE_IMPORTO value for this Categorie.
     * 
     * @param CLASSE_IMPORTO
     */
    public void setCLASSE_IMPORTO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.ClasseImportoType CLASSE_IMPORTO) {
        this.CLASSE_IMPORTO = CLASSE_IMPORTO;
    }


    /**
     * Gets the PREVALENTE value for this Categorie.
     * 
     * @return PREVALENTE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getPREVALENTE() {
        return PREVALENTE;
    }


    /**
     * Sets the PREVALENTE value for this Categorie.
     * 
     * @param PREVALENTE
     */
    public void setPREVALENTE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType PREVALENTE) {
        this.PREVALENTE = PREVALENTE;
    }


    /**
     * Gets the SCORPORABILE value for this Categorie.
     * 
     * @return SCORPORABILE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getSCORPORABILE() {
        return SCORPORABILE;
    }


    /**
     * Sets the SCORPORABILE value for this Categorie.
     * 
     * @param SCORPORABILE
     */
    public void setSCORPORABILE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType SCORPORABILE) {
        this.SCORPORABILE = SCORPORABILE;
    }


    /**
     * Gets the SUBAPPALTABILE value for this Categorie.
     * 
     * @return SUBAPPALTABILE
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getSUBAPPALTABILE() {
        return SUBAPPALTABILE;
    }


    /**
     * Sets the SUBAPPALTABILE value for this Categorie.
     * 
     * @param SUBAPPALTABILE
     */
    public void setSUBAPPALTABILE(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType SUBAPPALTABILE) {
        this.SUBAPPALTABILE = SUBAPPALTABILE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Categorie)) return false;
        Categorie other = (Categorie) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ID_CATEGORIA==null && other.getID_CATEGORIA()==null) || 
             (this.ID_CATEGORIA!=null &&
              this.ID_CATEGORIA.equals(other.getID_CATEGORIA()))) &&
            ((this.CLASSE_IMPORTO==null && other.getCLASSE_IMPORTO()==null) || 
             (this.CLASSE_IMPORTO!=null &&
              this.CLASSE_IMPORTO.equals(other.getCLASSE_IMPORTO()))) &&
            ((this.PREVALENTE==null && other.getPREVALENTE()==null) || 
             (this.PREVALENTE!=null &&
              this.PREVALENTE.equals(other.getPREVALENTE()))) &&
            ((this.SCORPORABILE==null && other.getSCORPORABILE()==null) || 
             (this.SCORPORABILE!=null &&
              this.SCORPORABILE.equals(other.getSCORPORABILE()))) &&
            ((this.SUBAPPALTABILE==null && other.getSUBAPPALTABILE()==null) || 
             (this.SUBAPPALTABILE!=null &&
              this.SUBAPPALTABILE.equals(other.getSUBAPPALTABILE())));
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
        if (getID_CATEGORIA() != null) {
            _hashCode += getID_CATEGORIA().hashCode();
        }
        if (getCLASSE_IMPORTO() != null) {
            _hashCode += getCLASSE_IMPORTO().hashCode();
        }
        if (getPREVALENTE() != null) {
            _hashCode += getPREVALENTE().hashCode();
        }
        if (getSCORPORABILE() != null) {
            _hashCode += getSCORPORABILE().hashCode();
        }
        if (getSUBAPPALTABILE() != null) {
            _hashCode += getSUBAPPALTABILE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Categorie.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "Categorie"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID_CATEGORIA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ID_CATEGORIA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CategoriaType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CLASSE_IMPORTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "CLASSE_IMPORTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ClasseImportoType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PREVALENTE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "PREVALENTE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SCORPORABILE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SCORPORABILE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SUBAPPALTABILE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SUBAPPALTABILE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
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
