package com.aline.soap.WS;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.aline.test.OrderRequest;
import com.aline.test.OrderResponse;

@Endpoint
public class StudentDetailsEndpoint {
	
	final String xsdName = "Test";
	final String request = "Request";


	@PayloadRoot(namespace="http://aline.com/Test",localPart="orderRequest")
	@ResponsePayload
	public OrderResponse processCourseDetailsRequest(@RequestPayload OrderRequest request) {
		
		OrderResponse response= new OrderResponse();
//writing from RR		 
		 try {
			BeanUtils.setProperty(response, "id", "10");
			BeanUtils.setProperty(response, "name", "thiru");
			BeanUtils.setProperty(response, "passportNumber", "passport");
			
			BeanUtils.setProperty(response, "id", "11");
			BeanUtils.setProperty(response, "name", "Dama");
			BeanUtils.setProperty(response, "passportNumber", "passport");

		} catch (IllegalAccessException | InvocationTargetException e) {

			e.printStackTrace();
		}
		 
		 return response;
		
	}

}
