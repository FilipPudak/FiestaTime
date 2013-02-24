package com.filippudak.fiestatime.model;

public class Event {
	
	private String title;
	private String address;
	private double latitude;
	private double longitude;
	private String startDate;
	private String endDate;
	private Venue[] venues;
	private Film[] films;
	private PoI[] pois;
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Venue[] getVenues() {
		return venues;
	}
	public void setVenues(Venue[] venues) {
		this.venues = venues;
	}
	public Film[] getFilms() {
		return films;
	}
	public void setFilms(Film[] films) {
		this.films = films;
	}
	public PoI[] getPois() {
		return pois;
	}
	public void setPois(PoI[] pois) {
		this.pois = pois;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	} 
	
}
