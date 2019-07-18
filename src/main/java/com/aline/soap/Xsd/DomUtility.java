package com.aline.soap.Xsd;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomUtility {
	
	
	public static Document getDocument() throws ParserConfigurationException{
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		 
		 DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		 
		 Document document = documentBuilder.newDocument();
		 
		return document;
		 
		
	}
	
	public static void writeDOM(Document document) throws TransformerException {
		
		 
		 TransformerFactory transformerFactory = TransformerFactory.newInstance();
		 Transformer transformer = transformerFactory.newTransformer();
		 transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		 transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        
		 DOMSource domSource  = new DOMSource(document);
        
         //to create a file use something like this:
         transformer.transform(domSource, new StreamResult(new File("H:\\webServices\\WebService\\TestWS\\src\\main\\resources\\Test.xsd")));
         //to print to console use this:

		 transformer.transform(domSource, new StreamResult(System.out));
	
	}
	
	public static Element rootElement(Document document,String nameSpace,String targetNameSpace) {
		
		Element schemaRoot = document.createElementNS(XMLConstants.W3C_XML_SCHEMA_NS_URI, nameSpace+"schema");		
		 document.appendChild(schemaRoot);
		 
	      schemaRoot.setAttribute("targetNamespace", targetNameSpace);
	      schemaRoot.setAttribute("xmlns:tns", targetNameSpace);
	      schemaRoot.setAttribute("elementFormDefault", "qualified");
	      return schemaRoot;
	  
		
	}


}
