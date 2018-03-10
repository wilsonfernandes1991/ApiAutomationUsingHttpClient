package com.qa.httpclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReqResGetCall {
	
	static ObjectMapper mapper = new ObjectMapper();
	static String getUrl = "https://reqres.in/api/users/2";
	
	
	
	@Test
	public void getUsers() throws Exception
	{
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet(getUrl);		
		getRequest.setHeader("Content-Type","application/json");
		
		HttpResponse response = httpClient.execute(getRequest);
		
		//Find the Response Status Code
		System.out.println("Response Status Code : "+response.getStatusLine().getStatusCode());			
		System.out.println("Response Status Name : "+response.getStatusLine().getReasonPhrase());
		
		String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
		System.out.println("Response Content-Type : "+mimeType);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String jsonData = reader.readLine();
		
		System.out.println("\n--------Printing Json Response-------- \n"+jsonData);
		
		//Validate Response Output
		JsonNode responseJsonNode = mapper.readValue(jsonData, JsonNode.class);		
		JsonNode responseData = responseJsonNode.get("data");
		
		System.out.println("ID : "+responseData.get("id"));
		System.out.println("First Name : "+responseData.get("first_name"));
		System.out.println("Last Name : "+responseData.get("last_name"));
		System.out.println("Avatar : "+responseData.get("avatar"));
		
	}
	
}
