package com.qa.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy.PascalCaseStrategy;



public class SampleTest {
	
	static ObjectMapper mapper = new ObjectMapper();
	
	static PostExample postExample = new PostExample();
	
	static String getUrl = "http://cmapi.bananaappscenter.com/api/Location/LocationDetails";
	static String postUrl = "http://cmapi.bananaappscenter.com/api/MovieBooking/MovieBooking";

	public static void main(String[] args) throws ClientProtocolException, IOException {
	//	System.out.println("Execution Started...");
		

		
		//getRequestMethod(getUrl);
		postRequestMethod();
	
	}

	private static void getRequestMethod(String getUrl) throws Exception {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet(getUrl);
		
		getRequest.setHeader("Content-type","application/json");
		
		HttpResponse response = httpClient.execute(getRequest);
		
		//Find the Response Status Code
		System.out.println("Response Status Code : "+response.getStatusLine().getStatusCode());

		//Ensures that the Response actually contains JSON data.
		String jsonMimeType = "application/json"; 		
		String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
		System.out.println("Response Content-Type : "+mimeType);
		Assert.assertEquals( jsonMimeType, mimeType );
		   
		//System.out.println(response.getEntity());
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));	
						
		String jsonData = reader.readLine();		
		
//		while((line = reader.readLine())!= null)
//		{
//			System.out.println(line);			
//		}
		System.out.println("\n--------Printing Json Response-------- \n"+jsonData);
		
//		System.out.println("\n \n --------Printing Java Object after Conversion--------");		
//		ObjectMapper obj = new ObjectMapper();
		

		
	}
	
	public static String convertToJson(Object object) throws JsonProcessingException{
		
//		mapper.setPropertyNamingStrategy(new PascalCaseStrategy()); //To Make 1st letter as Caps
//		mapper.setSerializationInclusion(null);
		return mapper.writeValueAsString(object);
	}
		
	
	public static void postRequestMethod() throws ClientProtocolException, IOException{
//		DomainClass domain = new DomainClass();
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost(postUrl);
		postRequest.setHeader("Content-type","application/json");
		
		
		MovieBooking ps = new MovieBooking();
		ps.setMovID(3);
		ps.setLocationID(5);
				
//		PostExample ps = new PostExample();
//		ps.setMov_ID(3);
//		ps.setLocation_ID(5);
		
		
		String data = convertToJson(ps);
		
		System.out.println("Sending Body Request \n"+data);
		
	//	System.out.println(data);
		//ObjectMapper mp = new ObjectMapper();

		
		StringEntity entity = new StringEntity(data,"UTF-8");
		entity.setContentType("application/json");
		postRequest.setEntity(entity);
		
		HttpResponse response = httpClient.execute(postRequest);
		
	
		//Find the Response Status Code
		System.out.println("Response Status Code : "+response.getStatusLine().getStatusCode());
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		
		String jsonData;
		
		jsonData = reader.readLine();
//		StringBuilder builder = new StringBuilder();
//		while((line=reader.readLine())!=null){
//			builder.append(line);
//		}
		
		System.out.println("--------Printing Json Response-------- \n"+jsonData);
		
		System.out.println("\n \n--------Printing Json to Java Data--------");
		
		ObjectMapper obj = new ObjectMapper();
		obj.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);
		
		Example msg = obj.readValue(jsonData, Example.class);				
		//To Read Message Details
		System.out.println("Is Success : "+msg.getMsg().getIsSuccess());
		System.out.println("Status Code : "+msg.getMsg().getStatusCode());
		
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		
		Example responseDetails = obj.readValue(jsonData, Example.class);	
		for(MovieBooking s : responseDetails.getMovieBooking()){
			
			System.out.println("BookingSite_ID : "+s.getBookingSiteID());			
			System.out.println("BookingSite_Name : "+s.getBookingSiteName());			
			System.out.println("ID : "+s.getID());
			System.out.println("Laocation_Name : "+s.getLaocationName());
			System.out.println("Location_ID : "+s.getBookingSiteID());
			System.out.println("Logo : "+s.getLogo());
			System.out.println("Mov_ID : "+s.getMovID());
			System.out.println("URL : "+s.getURL());
			System.out.println("------------------------------------");
			
			map.put("BookingSite_ID",  s.getBookingSiteID());
			map.put("BookingSite_Name", ((MovieBooking) s).getBookingSiteName());
			map.put("ID", ((MovieBooking) s).getID());
			map.put("Laocation_Name", ((MovieBooking) s).getLaocationName());
			map.put("Location_ID", ((MovieBooking) s).getLocationID());
			map.put("Logo", ((MovieBooking) s).getLogo());
			map.put("Mov_ID", ((MovieBooking) s).getMovID());
			map.put("URL", ((MovieBooking) s).getURL());
		} 

		System.out.println("----------------------------------");
		for(Map.Entry<String, Object> mp1 : map.entrySet()){
			System.out.println(mp1);
		}

		
			
//		for(Example ps : ps1){
//			System.out.println(ps);
//		}
		
		
		
		
		
		/*
		// Convert object to JSON string and pretty print
		String jsonInString = mp.writerWithDefaultPrettyPrinter().writeValueAsString(PostExample.class);
		System.out.println(jsonInString);
		*/
//		Example ps1 = mp.readValue(builder.toString(), Example.class);
//		
//		for(MovieBooking ps1d: ps1){
//			ps1d.getBookingSiteID();
//		}
//		  
//		
//		HashMap<String,Integer> map = new HashMap<String, Integer>();
//		map.put("BookingSite_ID", ps1d.getBookingSiteID());
		//mp.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
//		mp.configure(Feature.AUTO_CLOSE_SOURCE, true);
//		mp.configure(Feature.all, state)
//		MovieBooking Obj =mp.readValue(jsonData,MovieBooking.class);

		/*for(Object ex : Obj){
			
		}
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();
		map.put("BookingSite_ID", Obj.getBookingSiteID());
		
		System.out.println(map);
		*/
		
		/*Obj.getBookingSiteName();
		Obj.getID();
		Obj.getLaocationName();
		Obj.getLocationID();
		*/
		//mapper.enable(DeserializationFeature)
		//System.out.println(Obj);
		
		
		//PostExample example = mapper.readValue(reader, PostExample.class);
	
		//System.out.println(example);
		//example.getMov_ID();	
	
		//System.out.println(example.getLocation_ID());
	
	
	}

}

	 

