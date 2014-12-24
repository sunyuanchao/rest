package com.chinabsc.client;

import javax.ws.rs.core.MediaType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class UserInfoClient {

	public static final String BASE_URI = "http://localhost:8080/RESTfulWS";
	public static final String PATH_NAME = "/userInfoService/name/";
	public static final String PATH_AGE = "/userInfoService/age/";

	public static void main(String[] args) {
		String name = "tom";
		int age = 20;

		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource resource = client.resource(BASE_URI);

		WebResource nameResource = resource.path("rest").path(PATH_NAME + name);
		System.out.println("Client Response \n"+ getClientResponse(nameResource));
		System.out.println("Response \n" + getResponse(nameResource) + "\n\n");

		System.out.println("============================================");
		WebResource ageResource = resource.path("rest").path(PATH_AGE + age);
		System.out.println("Client Response \n"+ getClientResponse(ageResource));
		System.out.println("Response \n" + getResponse(ageResource));
	}

	/**
	 * Returns client response. e.g : GET
	 * http://localhost:8080/RESTfulWS/rest/UserInfoService/name/Tom
	 * returned a response status of 200 OK
	 * 
	 * @param service
	 * @return
	 */
	private static String getClientResponse(WebResource resource) {
		return resource.accept(MediaType.TEXT_XML).get(ClientResponse.class).toString();
	}

	/**
	 * Returns the response as XML e.g : <User><Name>Pavithra</Name></User>
	 * 
	 * @param service
	 * @return
	 */
	private static String getResponse(WebResource resource) {
		return resource.accept(MediaType.TEXT_XML).get(String.class);
	}

}
