package isa.projekat.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import isa.projekat.model.Play;

@Entity
public class Theater implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5744795584730331422L;
	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = true)
	private String description;
	
	//spisak karata sa popustima za brzu rezervaciju
	
	//repertoar
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "theater")
	private Set<Play> program;
	
	//konfiguracija segmenata i mesta u salama
	
	public Theater() {}

	public Theater(Long id, String name, String address, String description) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
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
