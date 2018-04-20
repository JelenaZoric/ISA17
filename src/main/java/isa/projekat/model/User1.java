package isa.projekat.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@Column(nullable = true)
	private String role;
	
	@ManyToMany
	@JoinTable(name = "user_theater", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "theater_id") })
	private Set<Theater> theaters = new HashSet<Theater>();
	
	@OneToMany
	@JoinTable(name = "user_seat", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "seat_id") })
	private Set<Seat> seats = new HashSet<Seat>();

	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name="user_ad", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "ad_id")})
	private Set<Ad> ad = new HashSet<Ad>();
	
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
	public User1(String name, String lastname, String city, String email, String password, String phone, String enabled,String uloga) {
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
		this.role = uloga;
	}
	public User1(String name, String lastname, String city, String email, String password, String phone, String enabled,String uloga, Set<Ad> ad) {
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
		this.role = uloga;
		this.ad = ad;
	}
	public User1(String name, String lastname) {
		super();
		this.name = name;
		this.lastname = lastname;
	}

	
	public Set<Ad> getAd() {
		return ad;
	}

	public void setAd(Set<Ad> ad) {
		this.ad = ad;
	}

	public String getName() {
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getLastname() {
		return this.lastname;
	}
	
	public void setLastname(String lastname){
		this.lastname = lastname;
	}

	public String getCity() {
		return this.city;
	}
	
	public void setCity(String city){
		this.city = city;
	}

	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
