package com.filippudak.fiestatime.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Film implements Serializable{
	
	private String title;
	private String director;
	private String runtime;
	private String mainActors;
	private String shortSummary;
	private String category;
	private String trailerLink;
	private String imageLink;
	private FilmVenue[] venues;
	private double rating;
	
	public Film(){};
	
	public Film(String title, String director, String runtime,
			String mainActors, String shortSummary, String category,
			String trailerLink, String imageLink, double rating) {
		super();
		this.title = title;
		this.director = director;
		this.runtime = runtime;
		this.mainActors = mainActors;
		this.shortSummary = shortSummary;
		this.category = category;
		this.trailerLink = trailerLink;
		this.imageLink = imageLink;
		this.rating = rating;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getMainActors() {
		return mainActors;
	}
	public void setMainActors(String mainActors) {
		this.mainActors = mainActors;
	}
	public String getShortSummary() {
		return shortSummary;
	}
	public void setShortSummary(String shortSummary) {
		this.shortSummary = shortSummary;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTrailerLink() {
		return trailerLink;
	}
	public void setTrailerLink(String trailerLink) {
		this.trailerLink = trailerLink;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public FilmVenue[] getVenues() {
		return venues;
	}
	public void setVenues(FilmVenue[] venues) {
		this.venues = venues;
	}

}
