package isa.projekat.controller;

import java.util.List;

import isa.projekat.model.User1;
import isa.projekat.repository.UserRepository;
import isa.projekat.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/users")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/search/{name}/{lastname}",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public User1 getUserByName(@PathVariable String name, @PathVariable String lastname) {
		return this.userService.findOne(name, lastname);
	}
	
	@RequestMapping(value = "/search/{criteria}",
					method = RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Page<User1> getUserByCriteria(@PathVariable String criteria) {
		return this.userService.findUsers(criteria, new PageRequest(0, 10));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "getUsers")
	public ResponseEntity<List<User1>> getHome() {
		List<User1> users = userService.findAll();
		return new ResponseEntity<List<User1>>(users, HttpStatus.OK);
	}
}
