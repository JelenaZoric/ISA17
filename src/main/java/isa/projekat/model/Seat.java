package isa.projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="seat_id")
	private Long id;

	@Column(nullable = false)
	private int number;
	
	@Column(nullable = false)
	private String reserved;
	
	@Column(nullable=true)
	private int discount;
	
	@ManyToOne
	private Hall hall;
	
	public Seat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seat(int number, String reserved) {
		super();
		this.number = number;
		this.reserved = reserved;
	}
	
	public Seat(int number, String reserved, int discount) {
		super();
		this.number = number;
		this.reserved = reserved;
		this.discount = discount;
	}

	public Seat(int number, String reserved, int discount, Hall hall) {
		super();
		this.number = number;
		this.reserved = reserved;
		this.discount = discount;
		this.hall = hall;
	}

	public Seat(int number, String reserved, Hall hall) {
		super();
		this.number = number;
		this.reserved = reserved;
		this.hall = hall;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
	
	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Hall getHall() {
		return hall;
	}

	public void setHall(Hall hall) {
		this.hall = hall;
	}
	
}
