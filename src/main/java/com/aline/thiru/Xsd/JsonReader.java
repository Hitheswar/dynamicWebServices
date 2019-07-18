package com.aline.thiru.Xsd;

import java.util.Iterator;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class JsonReader {
	
	
	public static void parseJson(String json,Document document,String service,Element schemaRoot) throws ParseException {
		
		JSONParser jsonParser = new JSONParser();
		
		Object object = jsonParser.parse(json);
		JSONObject jsonTree= (JSONObject)object;
								 
		Set  set = jsonTree.keySet();
					  
		Iterator iterator= set.iterator();
		
		if(iterator.hasNext()) {
			
			 ElementMaker elementMaker = new ElementMaker(Constants.NS_PREFIX, document);
			 
			 Element classTag = elementMaker.createElement("element", service);		 
			 schemaRoot.appendChild(classTag);
			 
			 Element complexTypeTag = elementMaker.createElement("complexType");
			 Element sequenceTag = elementMaker.createElement("sequence");

			 classTag.appendChild(complexTypeTag);		 
			 complexTypeTag.appendChild(sequenceTag);
			 
			   while(iterator.hasNext()) {
				   
				    Object obj =  iterator.next();
				    			    
				    if(jsonTree.get(obj) instanceof JSONArray) {
				    	System.out.println("array element");
				    }
				    else {
						  Element tag = elementMaker.createElement("element", (String)obj,Constants.NS_PREFIX+jsonTree.get(obj));
						  sequenceTag.appendChild(tag);
				    	
				    }
			   }

		}
		   		
	}
	
	public static void parseArray() {
		
	}
	
	public static void parseObject(String jsonArr,Document document,Element schemaRoot) throws ParseException {
		
		JSONParser jsonParser = new JSONParser();		
		Object object = jsonParser.parse(jsonArr);
		JSONArray jsonArray= (JSONArray)object;
				
		 Object requestObj= jsonArray.get(0);
		 String reqService = "orderRequest";		
		 formElement(requestObj, reqService, document, schemaRoot);
		 
		 Object responseObj= jsonArray.get(1);
		 String resService = "orderResponse";		
		 formElement(responseObj, resService, document, schemaRoot);

	}
	
	public static void formElement(Object obj,String service,Document document,Element schemaRoot) {
		
		if(obj instanceof JSONObject) {
						
			JSONObject processObj = (JSONObject) ((JSONObject) obj).get(service);
			 			
			Set elementSet = processObj.keySet();			  
			Iterator iterator= elementSet.iterator();
				
				if(iterator.hasNext()) {
					
					 ElementMaker elementMaker = new ElementMaker(Constants.NS_PREFIX, document);
					 
					 Element classTag = elementMaker.createElement("element", service);		 
					 schemaRoot.appendChild(classTag);
					 Element complexTypeTag = elementMaker.createElement("complexType");
					 Element sequenceTag = elementMaker.createElement("sequence");

					 classTag.appendChild(complexTypeTag);		 
					 complexTypeTag.appendChild(sequenceTag);

					   while(iterator.hasNext()) {
						   
						    Object obj1 =  iterator.next();
						    			    
						    if(processObj.get(obj1) instanceof JSONArray) {
						    }
						    else {
								  Element tag = elementMaker.createElement("element", (String)obj1,Constants.NS_PREFIX+processObj.get(obj1));
								  sequenceTag.appendChild(tag);
						    	
						    }
					   }
			 
		}
				
		}

	}
}





