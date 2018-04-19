package isa.projekat.model.dto;

import java.util.HashSet;
import java.util.Set;

import isa.projekat.model.Hall;
import isa.projekat.model.Play;

public class DateOfPlayDTO {

	private Long id;
	
	private String date;
	
	private Play play;
	
	private Set<Hall> halls = new HashSet<Hall>();

	public DateOfPlayDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Play getPlay() {
		return play;
	}

	public void setPlay(Play play) {
		this.play = play;
	}

	public Set<Hall> getHalls() {
		return halls;
	}

	public void setHalls(Set<Hall> halls) {
		this.halls = halls;
	}
	
}
