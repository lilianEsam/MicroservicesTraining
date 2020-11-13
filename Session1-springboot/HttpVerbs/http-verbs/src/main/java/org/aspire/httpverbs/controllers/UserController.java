package org.aspire.httpverbs.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.aspire.httpverbs.beans.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	private final Map<String, User> users; 
	
	public UserController() {
		this.users = new HashMap<>();
	}
	
	@PostMapping 
	public User saveUser(@RequestBody User user) {
		users.put(user.getId(), user); 
		
		return user; 
	}
	
	@GetMapping
	public Collection<User> allUsers(){
		return users.values(); 
	}
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") String userId) {
		return users.get(userId); 
	}
	
	@PutMapping("/{userId}")
	public User updateUser(@RequestBody User user) {
		
		if(user.getId() == null) {
			throw new RuntimeException(); 
		}
		
		users.computeIfPresent(user.getId(), (k, v) -> user); 
		
		return user; 
	}
	
}
