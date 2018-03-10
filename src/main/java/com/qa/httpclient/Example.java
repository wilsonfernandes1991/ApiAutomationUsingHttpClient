package com.qa.httpclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"MovieBooking",
"Msg"
})
public class Example {
	
	@JsonProperty("MovieBooking")
	private List<MovieBooking> movieBooking = null;
	public List<MovieBooking> getMovieBooking() {
		return movieBooking;
	}

	public void setMovieBooking(List<MovieBooking> movieBooking) {
		this.movieBooking = movieBooking;
	}
	

//@JsonProperty("MovieBooking")
//private MovieBooking[] movieBooking = null;
//public MovieBooking[] getMovieBooking() {
//	return movieBooking;
//}
//
//public void setMovieBooking(MovieBooking[] movieBooking) {
//	this.movieBooking = movieBooking;
//}



@JsonProperty("Msg")
private Msg msg;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/*@JsonProperty("MovieBooking")
public List<MovieBooking> getMovieBooking() {
return movieBooking;
}

@JsonProperty("MovieBooking")
public void setMovieBooking(List<MovieBooking> movieBooking) {
this.movieBooking = movieBooking;
}*/

@JsonProperty("Msg")
public Msg getMsg() {
return msg;
}

@JsonProperty("Msg")
public void setMsg(Msg msg) {
this.msg = msg;
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

