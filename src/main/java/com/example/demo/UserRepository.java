package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Registration,Integer> {

	public Registration findByUname(String uname);
	
	public Registration findByActivesw(String activesw);
	
	public Registration findByUstate(String ustate);
	
	public Registration findByUcity(String ucity);
	
	public Registration findByUemail(String uemail);
	
	public Registration findByUid(int uid);
	
	Registration findByUemailAndUpass(String uemail, String upass);
	
	
	
}
