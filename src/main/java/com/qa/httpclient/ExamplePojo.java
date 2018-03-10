package com.qa.httpclient;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL) // To Exclude variables which has NULL values
@JsonIgnoreProperties(ignoreUnknown=true) //To make to unassigned variables to NULL.

@JsonPropertyOrder({
"name",
"job",
"id",
"createdAt"
})


public class ExamplePojo {

@JsonProperty("name")
private String name;
@JsonProperty("job")
private String job;
@JsonProperty("id")
private String id;
@JsonProperty("createdAt")
private String createdAt;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("job")
public String getJob() {
return job;
}

@JsonProperty("job")
public void setJob(String job) {
this.job = job;
}

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("createdAt")
public String getCreatedAt() {
return createdAt;
}

@JsonProperty("createdAt")
public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@Override
public String toString() {
	return "Example [name=" + name + ", job=" + job + ", id=" + id + ", createdAt=" + createdAt + "]";
}

}

