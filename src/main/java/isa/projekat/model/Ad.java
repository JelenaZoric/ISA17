package isa.projekat.model;

import java.io.File;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ad implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = true)
	private Date date;
	
	@Column(nullable = true)
	private File image;
	
	@Column(nullable = true)
	private boolean reservationStatus;
	
	@Column(nullable = true)
	private boolean approvedStatus;
	
	@ManyToOne
	private User1 user;
	
	public Ad(){
		
	}
	

	public Ad(String name, String description, Date date, File image, boolean reservationStatus) {
	    super();
		this.name = name;
		this.description = description;
		this.date = date;
		this.image = image;
		this.reservationStatus = reservationStatus;
	}
	public Ad(String name, String description, Date date, File image, boolean reservationStatus, User1 user) {
	    super();
		this.name = name;
		this.description = description;
		this.date = date;
		this.image = image;
		this.reservationStatus = reservationStatus;
		this.user = user;
	}
	public Ad(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}


	public boolean isApprovedStatus() {
		return approvedStatus;
	}


	public void setApprovedStatus(boolean approvedStatus) {
		this.approvedStatus = approvedStatus;
	}


	public User1 getUser() {
		return user;
	}


	public void setUser(User1 user) {
		this.user = user;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}


	public boolean isReservationStatus() {
		return reservationStatus;
	}


	public void setReservationStatus(boolean reservationStatus) {
		this.reservationStatus = reservationStatus;
	}
	
}
