package isa.projekat.model.dto;

import java.util.HashSet;
import java.util.Set;

import isa.projekat.model.DateOfPlay;
import isa.projekat.model.Theater;

public class PlayDTO {

	private Long id;
	
	private String name;
	
	private String genre;
	
	private String director;
	
	private int duration;
	
	private float avgScore;
	
	private String description;
	
	private int price;
	
	private Theater theater;
	
	private Set<DateOfPlay> dates = new HashSet<DateOfPlay>();

	public PlayDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public float getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(float avgScore) {
		this.avgScore = avgScore;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public Set<DateOfPlay> getDates() {
		return dates;
	}

	public void setDates(Set<DateOfPlay> dates) {
		this.dates = dates;
	}

}
