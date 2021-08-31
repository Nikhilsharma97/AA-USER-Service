package com.example.demo.rest;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Contacts;
import com.example.demo.model.Users;
import com.example.demo.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add-data")
	public String saveData(@RequestBody Users users) {
		
		userService.saveData(users);
		return "Added data with name is : " + users.getName();
	}

	
	@GetMapping("/find/{userId}")
	public Users getUser(@PathVariable String userId) {
		Users user= userService.getUser(userId);
		return user;
	}

}
