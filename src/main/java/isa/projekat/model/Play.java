package isa.projekat.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import isa.projekat.model.Theater;

@Entity
public class Play implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6464736608983409359L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "play_id")
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	//spisak glumaca
	
	@Column(nullable = true)
	private String genre;
	
	@Column(nullable = false)
	private String director;
	
	@Column(nullable = false)
	private int duration;	//trajanje u minutima
	
	//poster
	
	@Column(nullable = true)
	private float avgScore;
	
	@Column(nullable = true)
	private String description;	//kratak opis
	
	//sale u kojima se vrse projekcije
	
	//termini u kojima se vrse projekcije
	
	@Column(nullable = false)
	private int price;
	
	@ManyToOne
	private Theater theater;
	
	@ManyToMany
	@JoinTable(name = "play_date", joinColumns = { @JoinColumn(name = "play_id") }, inverseJoinColumns = { @JoinColumn(name = "date_id") })
	private Set<DateOfPlay> dates = new HashSet<DateOfPlay>();
	
	public Play() {}

	
	
	public Play(String name, String genre, String director, int duration, float avgScore, String description, int price, Set<DateOfPlay> dates) {
		super();
		this.name = name;
		this.genre = genre;
		this.director = director;
		this.duration = duration;
		this.avgScore = avgScore;
		this.description = description;
		this.price = price;
		this.theater = theater;
		this.dates = dates;
	}

	public Play(String name, String genre, String director,
			int duration, float avgScore, String description, int price, Theater theater) {
		super();
		this.name = name;
		this.genre = genre;
		this.director = director;
		this.duration = duration;
		this.avgScore = avgScore;
		this.description = description;
		this.price = price;
		this.theater = theater;
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

	public Set<DateOfPlay> getDates() {
		return dates;
	}

	public void setDates(Set<DateOfPlay> dates) {
		this.dates = dates;
	}
	
}
