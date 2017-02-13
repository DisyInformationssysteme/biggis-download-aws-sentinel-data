//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2016.11.28 um 01:14:59 PM CET 
//


package net.disy.biggis.sentinel.download.aws.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.disy.biggis.sentinel.download.aws.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListBucketResult_QNAME = new QName("http://s3.amazonaws.com/doc/2006-03-01/", "ListBucketResult");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.disy.biggis.sentinel.download.aws.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ListBucketResultType }
     * 
     */
    public ListBucketResultType createListBucketResultType() {
        return new ListBucketResultType();
    }

    /**
     * Create an instance of {@link OwnerType }
     * 
     */
    public OwnerType createOwnerType() {
        return new OwnerType();
    }

    /**
     * Create an instance of {@link CommonPrefixesType }
     * 
     */
    public CommonPrefixesType createCommonPrefixesType() {
        return new CommonPrefixesType();
    }

    /**
     * Create an instance of {@link ContentsType }
     * 
     */
    public ContentsType createContentsType() {
        return new ContentsType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListBucketResultType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://s3.amazonaws.com/doc/2006-03-01/", name = "ListBucketResult")
    public JAXBElement<ListBucketResultType> createListBucketResult(ListBucketResultType value) {
        return new JAXBElement<ListBucketResultType>(_ListBucketResult_QNAME, ListBucketResultType.class, null, value);
    }

}
