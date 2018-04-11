package isa.projekat.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "date")
public class DateOfPlay {
	
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	@Column(name = "date_id")
	private Long id;

	@Column(nullable=false)
	private Date date;
	
	//@OneToMany(fetch = FetchType.LAZY, mappedBy = "date")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "date_hall", joinColumns = { @JoinColumn(name = "date_id") }, inverseJoinColumns = { @JoinColumn(name = "hall_id") })
	private Set<Hall> halls = new HashSet<Hall>();

	public DateOfPlay() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DateOfPlay(Date date, Set<Hall> halls) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
	
	
}
