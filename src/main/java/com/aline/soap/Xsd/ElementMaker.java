package com.aline.soap.Xsd;

import javax.xml.XMLConstants;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ElementMaker {
    private String nsPrefix;
    private Document doc;

    public ElementMaker(String nsPrefix, Document doc) {
        this.nsPrefix = nsPrefix;
        this.doc = doc;
    }

    public Element createElement(String elementName, String nameAttrVal, String typeAttrVal) {
        Element element = doc.createElementNS(XMLConstants.W3C_XML_SCHEMA_NS_URI, nsPrefix+elementName);
        if(nameAttrVal != null)
            element.setAttribute("name", nameAttrVal);
        if(typeAttrVal != null)
            element.setAttribute("type", typeAttrVal);
        return element;
    }

    public Element createElement(String elementName, String nameAttrVal) {
        return createElement(elementName, nameAttrVal, null);
    }

    public Element createElement(String elementName) {
        return createElement(elementName, null, null);
    }
}
