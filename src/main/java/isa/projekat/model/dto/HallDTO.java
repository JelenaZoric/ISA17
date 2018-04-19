package isa.projekat.model.dto;

import java.util.HashSet;
import java.util.Set;

import isa.projekat.model.DateOfPlay;
import isa.projekat.model.Seat;

public class HallDTO {

	private Long id;
	
	private Set<Seat> seats = new HashSet<Seat>();
	
	private String name;
	
	private int numberOfSeats;
	
	private DateOfPlay date;

	public HallDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Seat> getSeats() {
		return seats;
	}

	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public DateOfPlay getDate() {
		return date;
	}

	public void setDate(DateOfPlay date) {
		this.date = date;
	}
	
}
