package com.qa.httpclient;


import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"Message",
"StatusCode",
"isError",
"isSuccess"
})
public class Msg {

@JsonProperty("Message")
private String message;
@JsonProperty("StatusCode")
private Integer statusCode;
@JsonProperty("isError")
private Boolean isError;
@JsonProperty("isSuccess")
private Boolean isSuccess;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
@JsonProperty("example")
private Example[] example = null;

public Example[] getExample() {
	return example;
}

public void setExample(Example[] example) {
	this.example = example;
}

@JsonProperty("Message")
public String getMessage() {
return message;
}

@JsonProperty("Message")
public void setMessage(String message) {
this.message = message;
}

@JsonProperty("StatusCode")
public Integer getStatusCode() {
return statusCode;
}

@JsonProperty("StatusCode")
public void setStatusCode(Integer statusCode) {
this.statusCode = statusCode;
}

@JsonProperty("isError")
public Boolean getIsError() {
return isError;
}

@JsonProperty("isError")
public void setIsError(Boolean isError) {
this.isError = isError;
}

@JsonProperty("isSuccess")
public Boolean getIsSuccess() {
return isSuccess;
}

@JsonProperty("isSuccess")
public void setIsSuccess(Boolean isSuccess) {
this.isSuccess = isSuccess;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}

