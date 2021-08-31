package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Contacts;
import com.example.demo.model.Users;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class UserServiceImpl implements UserService {

	private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveData(Users users) {
		log.info("Save users data {}",users);
		userRepository.save(users);
	}

	@Override
	public Users getUser(String userId) {
		log.info("Users name {}",userId);
		Users user = userRepository.findByUserId(userId);
		log.info("Users data {}",user);
		
		List<Contacts> contacts= restTemplate.getForObject("http://Contacts/contacts/find/"+userId, List.class);
		log.info("No. of contacts {} ",contacts.size());
		user.setContacts(contacts);
		return user;
	}


}
