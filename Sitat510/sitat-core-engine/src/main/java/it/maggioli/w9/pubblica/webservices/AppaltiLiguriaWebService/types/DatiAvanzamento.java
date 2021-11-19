/**
 * DatiAvanzamento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class DatiAvanzamento  implements java.io.Serializable {
    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType SUBAPPALTI;

    private java.util.Calendar DATA_CERTIFICATO;

    private double IMPORTO_CERTIFICATO;

    private it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagRitardoType FLAG_RITARDO;

    private java.lang.Long NUM_GIORNI_SCOST;

    private java.lang.Long NUM_GIORNI_PROROGA;

    private java.lang.String FLAG_PAGAMENTO;

    private java.util.Calendar DATA_ANTICIPAZIONE;

    private java.lang.Double IMPORTO_ANTICIPAZIONE;

    private java.util.Calendar DATA_RAGGIUNGIMENTO;

    private double IMPORTO_SAL;

    private java.lang.String DENOMINAZIONE;

    public DatiAvanzamento() {
    }

    public DatiAvanzamento(
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType SUBAPPALTI,
           java.util.Calendar DATA_CERTIFICATO,
           double IMPORTO_CERTIFICATO,
           it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagRitardoType FLAG_RITARDO,
           java.lang.Long NUM_GIORNI_SCOST,
           java.lang.Long NUM_GIORNI_PROROGA,
           java.lang.String FLAG_PAGAMENTO,
           java.util.Calendar DATA_ANTICIPAZIONE,
           java.lang.Double IMPORTO_ANTICIPAZIONE,
           java.util.Calendar DATA_RAGGIUNGIMENTO,
           double IMPORTO_SAL,
           java.lang.String DENOMINAZIONE) {
           this.SUBAPPALTI = SUBAPPALTI;
           this.DATA_CERTIFICATO = DATA_CERTIFICATO;
           this.IMPORTO_CERTIFICATO = IMPORTO_CERTIFICATO;
           this.FLAG_RITARDO = FLAG_RITARDO;
           this.NUM_GIORNI_SCOST = NUM_GIORNI_SCOST;
           this.NUM_GIORNI_PROROGA = NUM_GIORNI_PROROGA;
           this.FLAG_PAGAMENTO = FLAG_PAGAMENTO;
           this.DATA_ANTICIPAZIONE = DATA_ANTICIPAZIONE;
           this.IMPORTO_ANTICIPAZIONE = IMPORTO_ANTICIPAZIONE;
           this.DATA_RAGGIUNGIMENTO = DATA_RAGGIUNGIMENTO;
           this.IMPORTO_SAL = IMPORTO_SAL;
           this.DENOMINAZIONE = DENOMINAZIONE;
    }


    /**
     * Gets the SUBAPPALTI value for this DatiAvanzamento.
     * 
     * @return SUBAPPALTI
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType getSUBAPPALTI() {
        return SUBAPPALTI;
    }


    /**
     * Sets the SUBAPPALTI value for this DatiAvanzamento.
     * 
     * @param SUBAPPALTI
     */
    public void setSUBAPPALTI(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagSNType SUBAPPALTI) {
        this.SUBAPPALTI = SUBAPPALTI;
    }


    /**
     * Gets the DATA_CERTIFICATO value for this DatiAvanzamento.
     * 
     * @return DATA_CERTIFICATO
     */
    public java.util.Calendar getDATA_CERTIFICATO() {
        return DATA_CERTIFICATO;
    }


    /**
     * Sets the DATA_CERTIFICATO value for this DatiAvanzamento.
     * 
     * @param DATA_CERTIFICATO
     */
    public void setDATA_CERTIFICATO(java.util.Calendar DATA_CERTIFICATO) {
        this.DATA_CERTIFICATO = DATA_CERTIFICATO;
    }


    /**
     * Gets the IMPORTO_CERTIFICATO value for this DatiAvanzamento.
     * 
     * @return IMPORTO_CERTIFICATO
     */
    public double getIMPORTO_CERTIFICATO() {
        return IMPORTO_CERTIFICATO;
    }


    /**
     * Sets the IMPORTO_CERTIFICATO value for this DatiAvanzamento.
     * 
     * @param IMPORTO_CERTIFICATO
     */
    public void setIMPORTO_CERTIFICATO(double IMPORTO_CERTIFICATO) {
        this.IMPORTO_CERTIFICATO = IMPORTO_CERTIFICATO;
    }


    /**
     * Gets the FLAG_RITARDO value for this DatiAvanzamento.
     * 
     * @return FLAG_RITARDO
     */
    public it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagRitardoType getFLAG_RITARDO() {
        return FLAG_RITARDO;
    }


    /**
     * Sets the FLAG_RITARDO value for this DatiAvanzamento.
     * 
     * @param FLAG_RITARDO
     */
    public void setFLAG_RITARDO(it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types.FlagRitardoType FLAG_RITARDO) {
        this.FLAG_RITARDO = FLAG_RITARDO;
    }


    /**
     * Gets the NUM_GIORNI_SCOST value for this DatiAvanzamento.
     * 
     * @return NUM_GIORNI_SCOST
     */
    public java.lang.Long getNUM_GIORNI_SCOST() {
        return NUM_GIORNI_SCOST;
    }


    /**
     * Sets the NUM_GIORNI_SCOST value for this DatiAvanzamento.
     * 
     * @param NUM_GIORNI_SCOST
     */
    public void setNUM_GIORNI_SCOST(java.lang.Long NUM_GIORNI_SCOST) {
        this.NUM_GIORNI_SCOST = NUM_GIORNI_SCOST;
    }


    /**
     * Gets the NUM_GIORNI_PROROGA value for this DatiAvanzamento.
     * 
     * @return NUM_GIORNI_PROROGA
     */
    public java.lang.Long getNUM_GIORNI_PROROGA() {
        return NUM_GIORNI_PROROGA;
    }


    /**
     * Sets the NUM_GIORNI_PROROGA value for this DatiAvanzamento.
     * 
     * @param NUM_GIORNI_PROROGA
     */
    public void setNUM_GIORNI_PROROGA(java.lang.Long NUM_GIORNI_PROROGA) {
        this.NUM_GIORNI_PROROGA = NUM_GIORNI_PROROGA;
    }


    /**
     * Gets the FLAG_PAGAMENTO value for this DatiAvanzamento.
     * 
     * @return FLAG_PAGAMENTO
     */
    public java.lang.String getFLAG_PAGAMENTO() {
        return FLAG_PAGAMENTO;
    }


    /**
     * Sets the FLAG_PAGAMENTO value for this DatiAvanzamento.
     * 
     * @param FLAG_PAGAMENTO
     */
    public void setFLAG_PAGAMENTO(java.lang.String FLAG_PAGAMENTO) {
        this.FLAG_PAGAMENTO = FLAG_PAGAMENTO;
    }


    /**
     * Gets the DATA_ANTICIPAZIONE value for this DatiAvanzamento.
     * 
     * @return DATA_ANTICIPAZIONE
     */
    public java.util.Calendar getDATA_ANTICIPAZIONE() {
        return DATA_ANTICIPAZIONE;
    }


    /**
     * Sets the DATA_ANTICIPAZIONE value for this DatiAvanzamento.
     * 
     * @param DATA_ANTICIPAZIONE
     */
    public void setDATA_ANTICIPAZIONE(java.util.Calendar DATA_ANTICIPAZIONE) {
        this.DATA_ANTICIPAZIONE = DATA_ANTICIPAZIONE;
    }


    /**
     * Gets the IMPORTO_ANTICIPAZIONE value for this DatiAvanzamento.
     * 
     * @return IMPORTO_ANTICIPAZIONE
     */
    public java.lang.Double getIMPORTO_ANTICIPAZIONE() {
        return IMPORTO_ANTICIPAZIONE;
    }


    /**
     * Sets the IMPORTO_ANTICIPAZIONE value for this DatiAvanzamento.
     * 
     * @param IMPORTO_ANTICIPAZIONE
     */
    public void setIMPORTO_ANTICIPAZIONE(java.lang.Double IMPORTO_ANTICIPAZIONE) {
        this.IMPORTO_ANTICIPAZIONE = IMPORTO_ANTICIPAZIONE;
    }


    /**
     * Gets the DATA_RAGGIUNGIMENTO value for this DatiAvanzamento.
     * 
     * @return DATA_RAGGIUNGIMENTO
     */
    public java.util.Calendar getDATA_RAGGIUNGIMENTO() {
        return DATA_RAGGIUNGIMENTO;
    }


    /**
     * Sets the DATA_RAGGIUNGIMENTO value for this DatiAvanzamento.
     * 
     * @param DATA_RAGGIUNGIMENTO
     */
    public void setDATA_RAGGIUNGIMENTO(java.util.Calendar DATA_RAGGIUNGIMENTO) {
        this.DATA_RAGGIUNGIMENTO = DATA_RAGGIUNGIMENTO;
    }


    /**
     * Gets the IMPORTO_SAL value for this DatiAvanzamento.
     * 
     * @return IMPORTO_SAL
     */
    public double getIMPORTO_SAL() {
        return IMPORTO_SAL;
    }


    /**
     * Sets the IMPORTO_SAL value for this DatiAvanzamento.
     * 
     * @param IMPORTO_SAL
     */
    public void setIMPORTO_SAL(double IMPORTO_SAL) {
        this.IMPORTO_SAL = IMPORTO_SAL;
    }


    /**
     * Gets the DENOMINAZIONE value for this DatiAvanzamento.
     * 
     * @return DENOMINAZIONE
     */
    public java.lang.String getDENOMINAZIONE() {
        return DENOMINAZIONE;
    }


    /**
     * Sets the DENOMINAZIONE value for this DatiAvanzamento.
     * 
     * @param DENOMINAZIONE
     */
    public void setDENOMINAZIONE(java.lang.String DENOMINAZIONE) {
        this.DENOMINAZIONE = DENOMINAZIONE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatiAvanzamento)) return false;
        DatiAvanzamento other = (DatiAvanzamento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.SUBAPPALTI==null && other.getSUBAPPALTI()==null) || 
             (this.SUBAPPALTI!=null &&
              this.SUBAPPALTI.equals(other.getSUBAPPALTI()))) &&
            ((this.DATA_CERTIFICATO==null && other.getDATA_CERTIFICATO()==null) || 
             (this.DATA_CERTIFICATO!=null &&
              this.DATA_CERTIFICATO.equals(other.getDATA_CERTIFICATO()))) &&
            this.IMPORTO_CERTIFICATO == other.getIMPORTO_CERTIFICATO() &&
            ((this.FLAG_RITARDO==null && other.getFLAG_RITARDO()==null) || 
             (this.FLAG_RITARDO!=null &&
              this.FLAG_RITARDO.equals(other.getFLAG_RITARDO()))) &&
            ((this.NUM_GIORNI_SCOST==null && other.getNUM_GIORNI_SCOST()==null) || 
             (this.NUM_GIORNI_SCOST!=null &&
              this.NUM_GIORNI_SCOST.equals(other.getNUM_GIORNI_SCOST()))) &&
            ((this.NUM_GIORNI_PROROGA==null && other.getNUM_GIORNI_PROROGA()==null) || 
             (this.NUM_GIORNI_PROROGA!=null &&
              this.NUM_GIORNI_PROROGA.equals(other.getNUM_GIORNI_PROROGA()))) &&
            ((this.FLAG_PAGAMENTO==null && other.getFLAG_PAGAMENTO()==null) || 
             (this.FLAG_PAGAMENTO!=null &&
              this.FLAG_PAGAMENTO.equals(other.getFLAG_PAGAMENTO()))) &&
            ((this.DATA_ANTICIPAZIONE==null && other.getDATA_ANTICIPAZIONE()==null) || 
             (this.DATA_ANTICIPAZIONE!=null &&
              this.DATA_ANTICIPAZIONE.equals(other.getDATA_ANTICIPAZIONE()))) &&
            ((this.IMPORTO_ANTICIPAZIONE==null && other.getIMPORTO_ANTICIPAZIONE()==null) || 
             (this.IMPORTO_ANTICIPAZIONE!=null &&
              this.IMPORTO_ANTICIPAZIONE.equals(other.getIMPORTO_ANTICIPAZIONE()))) &&
            ((this.DATA_RAGGIUNGIMENTO==null && other.getDATA_RAGGIUNGIMENTO()==null) || 
             (this.DATA_RAGGIUNGIMENTO!=null &&
              this.DATA_RAGGIUNGIMENTO.equals(other.getDATA_RAGGIUNGIMENTO()))) &&
            this.IMPORTO_SAL == other.getIMPORTO_SAL() &&
            ((this.DENOMINAZIONE==null && other.getDENOMINAZIONE()==null) || 
             (this.DENOMINAZIONE!=null &&
              this.DENOMINAZIONE.equals(other.getDENOMINAZIONE())));
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
        if (getSUBAPPALTI() != null) {
            _hashCode += getSUBAPPALTI().hashCode();
        }
        if (getDATA_CERTIFICATO() != null) {
            _hashCode += getDATA_CERTIFICATO().hashCode();
        }
        _hashCode += new Double(getIMPORTO_CERTIFICATO()).hashCode();
        if (getFLAG_RITARDO() != null) {
            _hashCode += getFLAG_RITARDO().hashCode();
        }
        if (getNUM_GIORNI_SCOST() != null) {
            _hashCode += getNUM_GIORNI_SCOST().hashCode();
        }
        if (getNUM_GIORNI_PROROGA() != null) {
            _hashCode += getNUM_GIORNI_PROROGA().hashCode();
        }
        if (getFLAG_PAGAMENTO() != null) {
            _hashCode += getFLAG_PAGAMENTO().hashCode();
        }
        if (getDATA_ANTICIPAZIONE() != null) {
            _hashCode += getDATA_ANTICIPAZIONE().hashCode();
        }
        if (getIMPORTO_ANTICIPAZIONE() != null) {
            _hashCode += getIMPORTO_ANTICIPAZIONE().hashCode();
        }
        if (getDATA_RAGGIUNGIMENTO() != null) {
            _hashCode += getDATA_RAGGIUNGIMENTO().hashCode();
        }
        _hashCode += new Double(getIMPORTO_SAL()).hashCode();
        if (getDENOMINAZIONE() != null) {
            _hashCode += getDENOMINAZIONE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatiAvanzamento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiAvanzamento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SUBAPPALTI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "SUBAPPALTI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagSNType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_CERTIFICATO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_CERTIFICATO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_CERTIFICATO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_CERTIFICATO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_RITARDO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_RITARDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FlagRitardoType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_GIORNI_SCOST");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_GIORNI_SCOST"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_GIORNI_PROROGA");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_GIORNI_PROROGA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("FLAG_PAGAMENTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "FLAG_PAGAMENTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_ANTICIPAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_ANTICIPAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_ANTICIPAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_ANTICIPAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_RAGGIUNGIMENTO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_RAGGIUNGIMENTO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IMPORTO_SAL");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "IMPORTO_SAL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DENOMINAZIONE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DENOMINAZIONE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
