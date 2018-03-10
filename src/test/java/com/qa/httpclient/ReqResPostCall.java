package com.qa.httpclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReqResPostCall {
	
	static ObjectMapper mapper = new ObjectMapper();
	static String postUrl = "https://reqres.in/api/users";
	
	
	
	@Test
	public void CreateUserPostCall() throws Exception
	{
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost(postUrl);		
		postRequest.setHeader("Content-Type","application/json");
		
		ExamplePojo ps = new ExamplePojo();
		ps.setJob("leader");
		ps.setName("morpheus");
		
		System.out.println(ps);
		
		String data = convertToJson(ps);
		System.out.println("Input data \n"+data);
		
		StringEntity entity = new StringEntity(data,"UTF-8");
		entity.setContentType("application/json");
		postRequest.setEntity(entity);
		
		HttpResponse response = httpClient.execute(postRequest);
		
		//Find the Response Status Code
		System.out.println("Response Status Code : "+response.getStatusLine().getStatusCode());			
		System.out.println("Response Status Name : "+response.getStatusLine().getReasonPhrase());
		
		
		String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
		System.out.println("Response Content-Type : "+mimeType);
					
		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String jsonData = reader.readLine();
		
		System.out.println("\n--------Printing Json Response-------- \n"+jsonData);
		
		System.out.println("\n \n --------Printing Java Object after Conversion--------");
		
		//ObjectMapper mapp = new ObjectMapper();
		
		//Object to JSON in file
		//mapp.writeValue(new File("c:\\WILSON\\file.txt"), jsonData);
		
		//Object to JSON in String
		//String jsonInString = mapper.writeValueAsString(jsonData);
		//System.out.println(jsonInString);
		
		
		//mapp.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		
		ObjectMapper obj = new ObjectMapper();			
		ExamplePojo ps1 = obj.readValue(jsonData, ExamplePojo.class);	
		System.out.println(ps1);
		System.out.println("ID : "+ps1.getId());
	
		
	}
	
	 public static String convertToJson(Object object) throws Exception
	 {
		//mapper.setPropertyNamingStrategy(new PascalCaseStrategy());
		//mapper.setSerializationInclusion(null);
		return mapper.writeValueAsString(object);
	}
	
}
