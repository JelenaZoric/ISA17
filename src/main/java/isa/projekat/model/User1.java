package isa.projekat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3401692146417660242L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public User1() {
		
	}

	public User1(String name, String state, String city, String mail, String password, String phone, String enabled) {
		super();
		this.name = name;
		this.lastname = state;
		this.city = city;
		this.email = mail;
		this.password = password;
		this.phone = phone;
		this.enabled = "false";
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

	@Override
	public String toString() {
		return getName() + "," + getLastname();
	}
}
