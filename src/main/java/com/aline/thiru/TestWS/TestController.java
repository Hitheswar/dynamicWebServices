package com.aline.thiru.TestWS;

import java.io.File;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aline.thiru.Xsd.RootClass;

@RestController
@EnableAutoConfiguration
@ComponentScan("com.aline.*")

public class TestController {
	
	@Autowired
	RootClass rootClass;
	
	@RequestMapping(value = "/Request",method = RequestMethod.GET)
	public String index() throws ParseException, ParserConfigurationException, TransformerException {		
		rootClass.root();
		return "localhost:6091/ws/Test.wsdl";
	}
	
	
	@RequestMapping(value = "/Json", method = RequestMethod.POST)
	public String getjson(@RequestBody String jsonString) throws ParseException, ParserConfigurationException, TransformerException{
		
		rootClass.root(jsonString);
		return "localhost:6091/ws/Test.wsdl";

		
	}

}
