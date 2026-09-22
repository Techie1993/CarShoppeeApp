package com.example.demo;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	
	public List<Registration>getAllUser();
	
	public Registration SaveUser(Registration user);    // create 
	
	public Registration getById(int uid);				// Update
	
	public void deleteById(int uid);				// Delete
	
	public void DeleteAll(); 
	
	public Registration Login(String uemail,String upass);

	public Registration findByUid(int uid);
	
	public Registration getUserById(int uid);

	//public UserDetails loadUserByUsername(String username);
	
}
