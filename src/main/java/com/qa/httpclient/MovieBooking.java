package com.qa.httpclient;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL) //To Ignore null values and pass only those data whose values are initialized...
@JsonIgnoreProperties(ignoreUnknown = true)

@JsonPropertyOrder({
"BookingSite_ID",
"BookingSite_Name",
"ID",
"Laocation_Name",
"Location_ID",
"Logo",
"Mov_ID",
"URL"
})


public class MovieBooking {

@JsonProperty("BookingSite_ID")
private Integer bookingSiteID;
@Override
public String toString() {
	return "MovieBooking [bookingSiteID=" + bookingSiteID + ", bookingSiteName="
			+ bookingSiteName + ", iD=" + iD + ", laocationName=" + laocationName + ", locationID=" + locationID
			+ ", logo=" + logo + ", movID=" + movID + ", uRL=" + uRL + ", additionalProperties=" + additionalProperties
			+ "]";
}

@JsonProperty("BookingSite_Name")
private String bookingSiteName;
@JsonProperty("ID")
private Integer iD;
@JsonProperty("Laocation_Name")
private String laocationName;
@JsonProperty("Location_ID")
private Integer locationID;
@JsonProperty("Logo")
private Object logo;
@JsonProperty("Mov_ID")
private Integer movID;
@JsonProperty("URL")
private String uRL;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("BookingSite_ID")
public Integer getBookingSiteID() {
return bookingSiteID;
}

@JsonProperty("BookingSite_ID")
public void setBookingSiteID(Integer bookingSiteID) {
this.bookingSiteID = bookingSiteID;
}

@JsonProperty("BookingSite_Name")
public String getBookingSiteName() {
return bookingSiteName;
}

@JsonProperty("BookingSite_Name")
public void setBookingSiteName(String bookingSiteName) {
this.bookingSiteName = bookingSiteName;
}

@JsonProperty("ID")
public Integer getID() {
return iD;
}

@JsonProperty("ID")
public void setID(Integer iD) {
this.iD = iD;
}

@JsonProperty("Laocation_Name")
public String getLaocationName() {
return laocationName;
}

@JsonProperty("Laocation_Name")
public void setLaocationName(String laocationName) {
this.laocationName = laocationName;
}

@JsonProperty("Location_ID")
public Integer getLocationID() {
return locationID;
}

@JsonProperty("Location_ID")
public void setLocationID(Integer locationID) {
this.locationID = locationID;
}

@JsonProperty("Logo")
public Object getLogo() {
return logo;
}

@JsonProperty("Logo")
public void setLogo(Object logo) {
this.logo = logo;
}

@JsonProperty("Mov_ID")
public Integer getMovID() {
return movID;
}

@JsonProperty("Mov_ID")
public void setMovID(Integer movID) {
this.movID = movID;
}

@JsonProperty("URL")
public String getURL() {
return uRL;
}

@JsonProperty("URL")
public void setURL(String uRL) {
this.uRL = uRL;
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
