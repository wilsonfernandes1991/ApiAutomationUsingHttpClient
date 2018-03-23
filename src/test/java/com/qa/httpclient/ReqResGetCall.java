package com.qa.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReqResGetCall {
	
	static ObjectMapper mapper = new ObjectMapper();
	static String getUrl = "https://reqres.in/api/users/2";
	
	
	
	@Test
	public void getSingleUser() throws Exception
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
		JsonNode responseData = responseJsonNode.get("data").get(0);
		
		System.out.println("ID : "+responseData.get("id"));
		System.out.println("First Name : "+responseData.get("first_name"));
		System.out.println("Last Name : "+responseData.get("last_name"));
		System.out.println("Avatar : "+responseData.get("avatar"));
				
		System.out.println("****************** 'getSingleUser' method completed *******************\n\n");
	}
	
	@Test
	public void getListOfUsers() throws ClientProtocolException, IOException
	{
		//Calling below Url using GET call
		getUrl = "https://reqres.in/api/users?page=2";
		 
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet(getUrl);
		getRequest.setHeader("Content-Type","application/json");
		
		HttpResponse response = httpClient.execute(getRequest);
		
		//Find the Response Code Status
		System.out.println("Response Status Code : "+response.getStatusLine().getStatusCode());
		System.out.println("Response Status Name : "+response.getStatusLine().getReasonPhrase());
		
		String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
		System.out.println("Response Content Type : "+mimeType);
		
		//Convert response to String format
//		String jsonData = EntityUtils.toString(response.getEntity());
//		System.out.println("\n--------Printing Json Response-------- \n"+jsonData);
		
		
		//You can use above or below code to convert Json Response to String format
		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String jsonData = reader.readLine();
		System.out.println("\n--------Printing Json Response-------- \n"+jsonData);
		
		
		System.out.println("\n************ Validating Json Response with JSON NODE ***************");
		JsonNode jsonResponse = mapper.readValue(jsonData, JsonNode.class);
		
		JsonNode jsonNode = jsonResponse.get("data");
		JsonNode jsonArray = jsonNode.get(0);
		System.out.println("First Name : "+jsonArray.get("first_name"));
		
		System.out.println("Total : "+jsonResponse.get("total"));
		System.out.println(jsonResponse.get("data").get(2));
		System.out.println("First Name : "+jsonResponse.get("data").get(2).get("first_name"));
		
		
		System.out.println("\n\n************ Validating Json Response with JSON OBJECT ***************");
		
		//Convert the result as a String to Json Object
		JSONObject jo = new JSONObject(jsonData);
		
		System.out.println("Page : "+jo.get("page"));
		
		int pageData = (Integer) jo.get("per_page");
		System.out.println("Per Page : "+pageData);
		
		System.out.println(jo.get("data"));
		
		JSONArray jo1 = new JSONArray(jo.get("data").toString());
		System.out.println(jo1.getJSONObject(0).getString("last_name")); //getString() can also be used
		
		System.out.println("Last Name : "+jo1.getJSONObject(0).get("last_name"));
				
		System.out.println("****************** 'getListOfUsers' method completed *******************\n\n");
	}
	
}
