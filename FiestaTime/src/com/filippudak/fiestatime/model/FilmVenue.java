package com.filippudak.fiestatime.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FilmVenue implements Serializable {
	
	private String date;
	private String time;
	private String place;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}

}
