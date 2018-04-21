package isa.projekat.model.dto;

import java.util.HashSet;
import java.util.Set;

import isa.projekat.model.User1;

public class UserDTO {

	private Set<User1>friends = new HashSet<User1>();

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<User1> getFriends() {
		return friends;
	}

	public void setFriends(Set<User1> friends) {
		this.friends = friends;
	}
}
