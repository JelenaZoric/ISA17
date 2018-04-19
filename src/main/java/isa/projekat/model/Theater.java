package isa.projekat.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import isa.projekat.model.Play;

@Entity
public class Theater implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5744795584730331422L;
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	@Column(name = "theater_id")
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = true)
	private String description;
	
	@Column(nullable = false)
	private char ttype;	//t - theater, c - cinema
	
	//spisak karata sa popustima za brzu rezervaciju
	
	//repertoar
	@OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "theater")
	@JsonIgnore	
//	@JoinTable(name="theater_play", joinColumns = { @JoinColumn(name = "theater_id") }, inverseJoinColumns = { @JoinColumn(name = "play_id")})
	private Set<Play> program = new HashSet<Play>();
	
	//konfiguracija segmenata i mesta u salama
	
	public Theater() {}

	public Theater(String name, String address, String city, String description, char type) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.description = description;
		this.ttype = type;
	}

	public Theater(String name, String address, String city,
			String description, char ttype, Set<Play> program) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.description = description;
		this.ttype = ttype;
		this.program = program;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public char getTtype() {
		return ttype;
	}

	public void setTtype(char ttype) {
		this.ttype = ttype;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Play> getProgram() {
		return program;
	}

	public void setProgram(Set<Play> program) {
		this.program = program;
	}
}
