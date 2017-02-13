//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.11.28 um 01:14:59 PM CET 
//


package net.disy.biggis.sentinel.download.aws.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ListBucketResultType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ListBucketResultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Prefix" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Marker" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MaxKeys" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Delimiter" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="IsTruncated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Contents" type="{http://s3.amazonaws.com/doc/2006-03-01/}ContentsType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CommonPrefixes" type="{http://s3.amazonaws.com/doc/2006-03-01/}CommonPrefixesType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListBucketResultType", propOrder = {
    "name",
    "prefix",
    "marker",
    "maxKeys",
    "delimiter",
    "isTruncated",
    "contents",
    "commonPrefixes"
})
public class ListBucketResultType {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Prefix", required = true)
    protected String prefix;
    @XmlElement(name = "Marker", required = true)
    protected String marker;
    @XmlElement(name = "MaxKeys")
    protected int maxKeys;
    @XmlElement(name = "Delimiter", required = true)
    protected String delimiter;
    @XmlElement(name = "IsTruncated")
    protected boolean isTruncated;
    @XmlElement(name = "Contents")
    protected List<ContentsType> contents;
    @XmlElement(name = "CommonPrefixes")
    protected List<CommonPrefixesType> commonPrefixes;

    /**
     * Ruft den Wert der name-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der prefix-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Legt den Wert der prefix-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefix(String value) {
        this.prefix = value;
    }

    /**
     * Ruft den Wert der marker-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarker() {
        return marker;
    }

    /**
     * Legt den Wert der marker-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarker(String value) {
        this.marker = value;
    }

    /**
     * Ruft den Wert der maxKeys-Eigenschaft ab.
     * 
     */
    public int getMaxKeys() {
        return maxKeys;
    }

    /**
     * Legt den Wert der maxKeys-Eigenschaft fest.
     * 
     */
    public void setMaxKeys(int value) {
        this.maxKeys = value;
    }

    /**
     * Ruft den Wert der delimiter-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelimiter() {
        return delimiter;
    }

    /**
     * Legt den Wert der delimiter-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelimiter(String value) {
        this.delimiter = value;
    }

    /**
     * Ruft den Wert der isTruncated-Eigenschaft ab.
     * 
     */
    public boolean isIsTruncated() {
        return isTruncated;
    }

    /**
     * Legt den Wert der isTruncated-Eigenschaft fest.
     * 
     */
    public void setIsTruncated(boolean value) {
        this.isTruncated = value;
    }

    /**
     * Gets the value of the contents property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contents property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContents().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContentsType }
     * 
     * 
     */
    public List<ContentsType> getContents() {
        if (contents == null) {
            contents = new ArrayList<ContentsType>();
        }
        return this.contents;
    }

    /**
     * Gets the value of the commonPrefixes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commonPrefixes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommonPrefixes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommonPrefixesType }
     * 
     * 
     */
    public List<CommonPrefixesType> getCommonPrefixes() {
        if (commonPrefixes == null) {
            commonPrefixes = new ArrayList<CommonPrefixesType>();
        }
        return this.commonPrefixes;
    }

}
