package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {

	@Autowired
	private UserRepository urepo;
	
	
	@Override
	public List<Registration> getAllUser() {
		List<Registration>AllUser=urepo.findAll();
		return AllUser;
	}

	@Override
	public Registration SaveUser(Registration user) {
		Registration RegUser=urepo.save(user);
		return RegUser;
	}

	@Override
	public Registration getById(int uid) {
		
		return urepo.findById(uid).get();
	}

	@Override
	public void deleteById(int uid) {
		urepo.deleteById(uid);
		
	}

	@Override
	public void DeleteAll() {
		urepo.deleteAll();
		
	}


	@Override
	public Registration Login(String uemail, String upass) {
		Registration valid=urepo.findByUemail(uemail);
		
		if(valid!=null && valid.getUpass().equals(upass)) {
			return valid;
		}else {
			return null;

		}
	}

	@Override
	public Registration findByUid(int uid) {
		Registration profile=urepo.findByUid(uid);
		return profile;
	}

	@Override
	public Registration getUserById(int uid) {
		Registration userinfo=urepo.getById(uid);
		return userinfo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	


	

}
