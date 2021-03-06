package isa.projekat.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "date_of_play")
public class DateOfPlay {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	@Column(name = "date_id")
	private Long id;

	@Column(nullable=false, name="date_")
	private String date;
	
	@ManyToOne
	private Play play;
	
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "date")
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "date")
	@JsonIgnore
//	@JoinTable(name = "date_hall", joinColumns = { @JoinColumn(name = "date_id") }, inverseJoinColumns = { @JoinColumn(name = "hall_id") })
	private Set<Hall> halls = new HashSet<Hall>();
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="date")
	@JsonIgnore
	private Set<UserDate> userDates = new HashSet<UserDate>();

	public DateOfPlay() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DateOfPlay(String date, Play play) {
		super();
		this.date = date;
		this.play = play;
	}

	public DateOfPlay(String date, Set<Hall> halls) {
		super();
		this.date = date;
		this.halls = halls;
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

	public Set<Hall> getHalls() {
		return halls;
	}

	/*@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "date_hall", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = { @JoinColumn(name = "PHONE_ID") })
	public Set<Hall> getHalls() {
		return this.halls;
	} */
	public void setHalls(Set<Hall> halls) {
		this.halls = halls;
	}

	public Play getPlay() {
		return play;
	}

	public void setPlay(Play play) {
		this.play = play;
	}
	
	public Set<UserDate> getUserDates() {
		return userDates;
	}

	public void setUserDates(Set<UserDate> userDates) {
		this.userDates = userDates;
	}
}
