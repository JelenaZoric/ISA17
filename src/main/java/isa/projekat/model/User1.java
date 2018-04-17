package isa.projekat.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;


@Entity
public class User1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3401692146417660242L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String lastname;

	@Column(nullable = false)
	private String city;

	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private String enabled;
	
	@ManyToMany
	@JoinTable(name = "user_theater", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "theater_id") })
	private Set<Theater> theaters = new HashSet<Theater>();
	
	@OneToMany
	@JoinTable(name = "user_seat", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "seat_id") })
	private Set<Seat> seats = new HashSet<Seat>();

	public User1() {
		
	}

	public User1(String name, String lastname, String city, String email, String password, String phone, String enabled,
			Set<Theater> theaters, Set<Seat> seats) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.city = city;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.enabled = "false";
		this.theaters = theaters;
		this.seats = seats;
	}

	public User1(String name, String lastname) {
		super();
		this.name = name;
		this.lastname = lastname;
	}

	public String getName() {
		return this.name;
	}

	public String getLastname() {
		return this.lastname;
	}

	public String getCity() {
		return this.city;
	}

	public String getEmail() {
		return this.email;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Theater> getTheaters() {
		return theaters;
	}

	public void setTheaters(Set<Theater> theaters) {
		this.theaters = theaters;
	}

	@Override
	public String toString() {
		return getName() + "," + getLastname();
	}

	public Set<Seat> getSeats() {
		return seats;
	}

	public void setSeats(Set<Seat> seats) {
		this.seats = seats;
	}
	
	
}
