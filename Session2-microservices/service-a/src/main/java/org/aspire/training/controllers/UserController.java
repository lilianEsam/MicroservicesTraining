package org.aspire.training.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspire.training.beans.Gender;
import org.aspire.training.beans.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/users")
public class UserController {

	Map<String, User> users = new HashMap<String, User>(){
		
		private static final long serialVersionUID = 1L;

	{
		put("1", new User(1, "Lilian", 24, Gender.FEMALE));
		put("2", new User(2, "Ali", 20, Gender.MALE));
		put("3", new User(3, "William", 35, Gender.MALE));
	}};
	
	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") String userId) {
		
		return users.getOrDefault(userId, 
				new User(0, "default", 0, Gender.FEMALE)); 
	}
	
	@GetMapping
	public List<User> getUsers(){
		
		List<User> usersList = new ArrayList<>(users.values()); 
		
		return usersList; 
	}
}
