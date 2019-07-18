package com.aline.thiru.Xsd;

import java.io.File;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import com.aline.thiru.Xsd.DomUtility;

@Component
public class RootClass {

	public static void root() throws ParseException, ParserConfigurationException, TransformerException {
		root(null);
	}

	public static void root(String jsonInput)
			throws ParseException, ParserConfigurationException, TransformerException {

		String Reqjson = "{\"id\":\"int\"}";

		String Resjson = "{\"id\":\"int\",\"name\":\"string\",\"passportNumber\":\"string\"}";

		String jsonObj = "[{\"orderRequest\": {\r\n" + "			\"id\": \"int\"}},\r\n" + "	{\"orderResponse\": {\r\n"
				+ "			\"id\": \"int\",\r\n" + "			\"name\": \"string\",\r\n"
				+ "			\"passportNumber\": \"string\"}}\r\n" + "] ";

		Document document = DomUtility.getDocument();

		Element schemaRoot = DomUtility.rootElement(document, Constants.NS_PREFIX, Constants.TNS);

		
//		  JsonReader.parseJson(Reqjson, document,"getRequest",schemaRoot);
//		  JsonReader.parseJson(Resjson, document,"getResponse",schemaRoot);
		 
	
		 JsonReader.parseObject(jsonObj, document, schemaRoot);
		 DomUtility.writeDOM(document);
	}

}
