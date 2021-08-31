package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class Users {
	
	@Id
	private String id;
	
	private String userId;
	private String name;
	private String phone;
	
	List<Contacts> contacts= new ArrayList<>();

	public Users(String id, String userId, String name, String phone, List<Contacts> contacts) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.phone = phone;
		this.contacts = contacts;
	}

	public Users(String id, String userId, String name, String phone) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.phone = phone;
	}

	public Users() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Contacts> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contacts> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userId=" + userId + ", name=" + name + ", phone=" + phone + ", contacts="
				+ contacts + "]";
	}
	
}
