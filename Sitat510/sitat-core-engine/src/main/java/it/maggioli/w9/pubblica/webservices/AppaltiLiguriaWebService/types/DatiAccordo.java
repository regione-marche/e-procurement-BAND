/**
 * DatiAccordo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package it.maggioli.w9.pubblica.webservices.AppaltiLiguriaWebService.types;

public class DatiAccordo  implements java.io.Serializable {
    private java.util.Calendar DATA_INIZIO_ACC;

    private java.util.Calendar DATA_FINE_ACC;

    private java.util.Calendar DATA_ACCORDO;

    private double ONERI_DERIVANTI;

    private long NUM_RISERVE;

    public DatiAccordo() {
    }

    public DatiAccordo(
           java.util.Calendar DATA_INIZIO_ACC,
           java.util.Calendar DATA_FINE_ACC,
           java.util.Calendar DATA_ACCORDO,
           double ONERI_DERIVANTI,
           long NUM_RISERVE) {
           this.DATA_INIZIO_ACC = DATA_INIZIO_ACC;
           this.DATA_FINE_ACC = DATA_FINE_ACC;
           this.DATA_ACCORDO = DATA_ACCORDO;
           this.ONERI_DERIVANTI = ONERI_DERIVANTI;
           this.NUM_RISERVE = NUM_RISERVE;
    }


    /**
     * Gets the DATA_INIZIO_ACC value for this DatiAccordo.
     * 
     * @return DATA_INIZIO_ACC
     */
    public java.util.Calendar getDATA_INIZIO_ACC() {
        return DATA_INIZIO_ACC;
    }


    /**
     * Sets the DATA_INIZIO_ACC value for this DatiAccordo.
     * 
     * @param DATA_INIZIO_ACC
     */
    public void setDATA_INIZIO_ACC(java.util.Calendar DATA_INIZIO_ACC) {
        this.DATA_INIZIO_ACC = DATA_INIZIO_ACC;
    }


    /**
     * Gets the DATA_FINE_ACC value for this DatiAccordo.
     * 
     * @return DATA_FINE_ACC
     */
    public java.util.Calendar getDATA_FINE_ACC() {
        return DATA_FINE_ACC;
    }


    /**
     * Sets the DATA_FINE_ACC value for this DatiAccordo.
     * 
     * @param DATA_FINE_ACC
     */
    public void setDATA_FINE_ACC(java.util.Calendar DATA_FINE_ACC) {
        this.DATA_FINE_ACC = DATA_FINE_ACC;
    }


    /**
     * Gets the DATA_ACCORDO value for this DatiAccordo.
     * 
     * @return DATA_ACCORDO
     */
    public java.util.Calendar getDATA_ACCORDO() {
        return DATA_ACCORDO;
    }


    /**
     * Sets the DATA_ACCORDO value for this DatiAccordo.
     * 
     * @param DATA_ACCORDO
     */
    public void setDATA_ACCORDO(java.util.Calendar DATA_ACCORDO) {
        this.DATA_ACCORDO = DATA_ACCORDO;
    }


    /**
     * Gets the ONERI_DERIVANTI value for this DatiAccordo.
     * 
     * @return ONERI_DERIVANTI
     */
    public double getONERI_DERIVANTI() {
        return ONERI_DERIVANTI;
    }


    /**
     * Sets the ONERI_DERIVANTI value for this DatiAccordo.
     * 
     * @param ONERI_DERIVANTI
     */
    public void setONERI_DERIVANTI(double ONERI_DERIVANTI) {
        this.ONERI_DERIVANTI = ONERI_DERIVANTI;
    }


    /**
     * Gets the NUM_RISERVE value for this DatiAccordo.
     * 
     * @return NUM_RISERVE
     */
    public long getNUM_RISERVE() {
        return NUM_RISERVE;
    }


    /**
     * Sets the NUM_RISERVE value for this DatiAccordo.
     * 
     * @param NUM_RISERVE
     */
    public void setNUM_RISERVE(long NUM_RISERVE) {
        this.NUM_RISERVE = NUM_RISERVE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatiAccordo)) return false;
        DatiAccordo other = (DatiAccordo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DATA_INIZIO_ACC==null && other.getDATA_INIZIO_ACC()==null) || 
             (this.DATA_INIZIO_ACC!=null &&
              this.DATA_INIZIO_ACC.equals(other.getDATA_INIZIO_ACC()))) &&
            ((this.DATA_FINE_ACC==null && other.getDATA_FINE_ACC()==null) || 
             (this.DATA_FINE_ACC!=null &&
              this.DATA_FINE_ACC.equals(other.getDATA_FINE_ACC()))) &&
            ((this.DATA_ACCORDO==null && other.getDATA_ACCORDO()==null) || 
             (this.DATA_ACCORDO!=null &&
              this.DATA_ACCORDO.equals(other.getDATA_ACCORDO()))) &&
            this.ONERI_DERIVANTI == other.getONERI_DERIVANTI() &&
            this.NUM_RISERVE == other.getNUM_RISERVE();
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
        if (getDATA_INIZIO_ACC() != null) {
            _hashCode += getDATA_INIZIO_ACC().hashCode();
        }
        if (getDATA_FINE_ACC() != null) {
            _hashCode += getDATA_FINE_ACC().hashCode();
        }
        if (getDATA_ACCORDO() != null) {
            _hashCode += getDATA_ACCORDO().hashCode();
        }
        _hashCode += new Double(getONERI_DERIVANTI()).hashCode();
        _hashCode += new Long(getNUM_RISERVE()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatiAccordo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DatiAccordo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_INIZIO_ACC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_INIZIO_ACC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_FINE_ACC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_FINE_ACC"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DATA_ACCORDO");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "DATA_ACCORDO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ONERI_DERIVANTI");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "ONERI_DERIVANTI"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("NUM_RISERVE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://10.20.3.19:8080/pubblica/webservices/types", "NUM_RISERVE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
