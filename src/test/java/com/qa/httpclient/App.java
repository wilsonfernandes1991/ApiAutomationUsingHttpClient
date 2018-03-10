package com.qa.httpclient;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
 
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
 
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
 
/**
* Hello world!
*
*/
@SuppressWarnings("deprecation")
public class App
{
    public static void main( String[] args ) throws Exception
    {
    // DefaultHttpClient httpClient = new DefaultHttpClient();
      HttpClient httpClient = HttpClientBuilder.create().build();
      HttpGet getRequest = new HttpGet("http://www.thomas-bayer.com/sqlrest/");
      getRequest.setHeader("content-type", "application/json");
      //setHeader will set the header value in the request,
      //addHeader will not overwrite the header value in the request if the header is already exists else
      //it will also work like setHeadder.
      HttpResponse response = httpClient.execute(getRequest);
      
      
     
      if (response.getStatusLine().getStatusCode()!=200){
            throw new Exception("");
      }
      BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
      String data = reader.readLine();
      System.out.println(data);
 
    }

    public void post(Object object) throws ClientProtocolException, IOException{
      HttpClient httpClient = HttpClientBuilder.create().build();
      HttpPost postRequest = new HttpPost("");
      String s = convertJavaTojson(object);
      //StringEntity is the raw data that you send in the request. Server communicate using JSON,
      //JSON string can be sent via StringEntity and server can get it in the request body
      StringEntity strEnt =  new StringEntity(s);
      postRequest.setEntity(strEnt);  
     
      HttpResponse response = httpClient.execute(postRequest);
     
    }
 
    
    public String convertJavaTojson(Object object) throws JsonProcessingException{
      //object mapper is a class
      //object mapper is used to convert the java object to json and json to java object
      //It uses instances of JsonParser and JsonGenerator for implementing actual reading/writing of JSON.
      ObjectMapper mapper = new ObjectMapper();
    //      mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
    return mapper.writeValueAsString(object);
    }
 
   
    public void convertJsonToJava(){
     
    }
    public  void get() throws IOException{
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet getRequest = new HttpGet("");
        getRequest.setHeader("", "");
        httpClient.execute(getRequest);
        httpClient.close();
        
    }
   
 
// API testing:
//=================================================
// 1 . validation of response
// 2 . serialization and deserialization methods or values
// 3 . Status codes
// 4 . Why is API testing is important than functional testing
// 5 . Components of APi
// 6 . xapth parsers or xml parsers
// 7 . write a sample code to convert XML to java (or) parse the xml
// 8 . API testing interview questions
// 9 . Different methods of API
 
 
//Java
//==============================
 
// 9 . java design patterns and java concepts
// 10 . Java collecttions
// 11 . Oops concepts
 
// Maven , Jenkins
 
// General questions
// 1 . Project Architecture
// 2. Questions on migration between two systems, what are the things to be verified
// 3. how to validate data from html or xml file
 
  
/*public void test() throws IOException{
      Document doc = Jsoup.parse("");
      Elements ele = doc.select("");
      for(Element links : ele){
            links.childNode(0);
      }
}*/
 
 
}
