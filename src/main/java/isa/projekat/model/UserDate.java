package isa.projekat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_date")
public class UserDate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6328342361614244486L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_date_id")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User1 user;
	
	@ManyToOne
	@JoinColumn(name="date_id")
	private DateOfPlay date;
	
	@Column(name="score", nullable=true)
	private int score;
	
	public UserDate() {}
	
	public UserDate(User1 user, DateOfPlay date) {
		this.user = user;
		this.date = date;
	}
	
	public UserDate(User1 user, DateOfPlay date, int score) {
		this.user = user;
		this.date = date;
		this.score = score;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User1 getUser() {
		return user;
	}

	public void setUser(User1 user) {
		this.user = user;
	}

	public DateOfPlay getDate() {
		return date;
	}

	public void setDate(DateOfPlay date) {
		this.date = date;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
