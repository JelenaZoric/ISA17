package isa.projekat.model.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import isa.projekat.model.Play;

public class TheaterDTO implements Serializable {
	
	private Long id;
	
	private String name;
	
	private String address;
	
	private String city;
	
	private String description;
	
	private char ttype;
	
	private Set<Play> program;

	public TheaterDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public char getTtype() {
		return ttype;
	}

	public void setTtype(char ttype) {
		this.ttype = ttype;
	}

	public Set<Play> getProgram() {
		return program;
	}

	public void setProgram(Set<Play> program) {
		this.program = program;
	}
	
	

}
