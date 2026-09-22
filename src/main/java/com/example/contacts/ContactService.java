package com.example.contacts;

import java.util.List;

import com.example.demo.Registration;

public interface ContactService {
	public List<contact>getAllUser();
	
	public contact SaveContact(contact con);    // create 
	
	public contact getById(int conid);				// Update
	
	public void deleteById(int conid);				// Delete
	
	public void DeleteAll(); 
	
	
}
