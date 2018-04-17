package isa.projekat.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Hall {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "hall_id")
	private Long id;

	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "hall")
	@OneToMany
	@JoinTable(name = "hall_seat", joinColumns = { @JoinColumn(name = "hall_id") }, inverseJoinColumns = { @JoinColumn(name = "seat_id") })
	private Set<Seat> seats = new HashSet<Seat>();
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private int numberOfSeats;
	
	@ManyToOne
	private DateOfPlay date;

	public Hall() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hall(Set<Seat> seats, String name, int numberOfSeats) {
		super();
		this.seats = seats;
		this.name = name;
		this.numberOfSeats = numberOfSeats;
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
