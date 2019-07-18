package com.aline.thiru.TestWS;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {
	
	final String xsdName = "Test";
	
	@Bean
	  public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
	    MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
	    messageDispatcherServlet.setApplicationContext(context);
	    messageDispatcherServlet.setTransformWsdlLocations(true);
	    return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
	  }
	
	@Bean(name = "Test")
	public DefaultWsdl11Definition defaultWsdl11Definition() {
	  DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
	  definition.setPortTypeName("TestPort");
	  definition.setTargetNamespace("http://aline.com/Test");
	  definition.setLocationUri("/ws");
	  definition.setSchema(TestSchema());
	  return definition;
	}
	@Bean
	public XsdSchema TestSchema() {
	  return new SimpleXsdSchema(new FileSystemResource("H:\\webServices\\WebService\\TestWS\\src\\main\\resources\\Test.xsd"));
	}

}
