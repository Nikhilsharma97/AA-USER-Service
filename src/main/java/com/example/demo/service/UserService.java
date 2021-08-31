package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Users;

public interface UserService {
	
	public void saveData(Users users);

	public Users getUser(String userId);

}
