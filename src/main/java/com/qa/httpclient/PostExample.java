package com.qa.httpclient;


import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostExample {
private int Mov_ID;
private int Location_ID;
private String BookingSite_ID;
private String BookingSite_Name;
private String Laocation_Name;
private String Logo;
private String URL;
private int ID;
private String[] MovieBooking;
public int getMov_ID() {
return Mov_ID;
}
public void setMov_ID(int mov_ID) {
Mov_ID = mov_ID;
}
public int getLocation_ID() {
return Location_ID;
}
public void setLocation_ID(int location_ID) {
Location_ID = location_ID;
}
public String getBookingSite_ID() {
return BookingSite_ID;
}
public void setBookingSite_ID(String bookingSite_ID) {
BookingSite_ID = bookingSite_ID;
}
public String getBookingSite_Name() {
return BookingSite_Name;
}
public void setBookingSite_Name(String bookingSite_Name) {
BookingSite_Name = bookingSite_Name;
}
public String getLaocation_Name() {
return Laocation_Name;
}
public void setLaocation_Name(String laocation_Name) {
Laocation_Name = laocation_Name;
}
public String getLogo() {
return Logo;
}
public void setLogo(String logo) {
Logo = logo;
}
public String getURL() {
return URL;
}
public void setURL(String uRL) {
URL = uRL;
}
public int getID() {
return ID;
}
public void setID(int iD) {
ID = iD;
}
public String[] getMovieBooking() {
return MovieBooking;
}
public void setMovieBooking(String[] movieBooking) {
MovieBooking = movieBooking;
}
@Override
public String toString() {
	return "PostExample [Mov_ID=" + Mov_ID + ", Location_ID=" + Location_ID + ", BookingSite_ID=" + BookingSite_ID
			+ ", BookingSite_Name=" + BookingSite_Name + ", Laocation_Name=" + Laocation_Name + ", Logo=" + Logo
			+ ", URL=" + URL + ", ID=" + ID + ", MovieBooking=" + Arrays.toString(MovieBooking) + "]";
}
}

*/

@JsonInclude(JsonInclude.Include.NON_NULL) //To Ignore null values and pass only those data whose values are initialized...
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostExample {
	@JsonProperty("Mov_ID")
	int Mov_ID;
	@JsonProperty("Location_ID")
	int Location_ID;
	
	//@JsonProperty("Mov_ID")
	public int getMov_ID() {
		return Mov_ID;
	}
	
	@JsonProperty("Mov_ID")
	public void setMov_ID(int mov_ID) {
		Mov_ID = mov_ID;
	}
	
	@JsonProperty("Location_ID")
	public int getLocation_ID() {
		return Location_ID;
	}
	
	@JsonProperty("Location_ID")
	public void setLocation_ID(int location_ID) {
		Location_ID = location_ID;
	}
	}

	
	
	
	
	
	

