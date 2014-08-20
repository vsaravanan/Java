package com.theopentutorials.jaxrs.calc.others;
 
import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
 
public class CalcRESTClient {
    static final String REST_URI = "http://localhost:9999/calcrest";
    static final String ADD_PATH = "calc/add";
    static final String SUB_PATH = "calc/sub";
    
 
	
	public static void main(String[] args) {
         
        int a = 122;
        int b = 34;

         
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config); 
        WebResource service = client.resource(REST_URI);
         
        WebResource addService = service.path(ADD_PATH).path(a + "/" + b);
        System.out.println("Add Response: " + getResponse(addService));
        System.out.println("Add Output as XML: " + getOutputAsXML(addService));
        System.out.println("Add Output as Text: " + getOutputAsText(addService));
        System.out.println("---------------------------------------------------");
         
        WebResource subService = service.path(SUB_PATH).path(a + "/" + b);
        System.out.println("Sub Response: " + getResponse(subService));
        System.out.println("Sub Output as XML: " + getOutputAsXML(subService));
        System.out.println("---------------------------------------------------");
 
    }
     
    private static String getResponse(WebResource service) {
        return service.accept(MediaType.TEXT_XML).get(ClientResponse.class).toString();
    }
     
    private static String getOutputAsXML(WebResource service) {
        return service.accept(MediaType.TEXT_XML).get(String.class);
    }
     
    private static String getOutputAsText(WebResource service) {
        return service.accept(MediaType.TEXT_PLAIN).get(String.class);
    }
}