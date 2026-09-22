package com.example.contacts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Registration;

@Service
public class ContactImpl implements ContactService {
	
	@Autowired
	private ContactRepository crepo;

	@Override
	public List<contact> getAllUser() {
		List<contact> alldata=crepo.findAll();
		return alldata;
	}

	@Override
	public contact SaveContact(contact con) {
		contact saved=crepo.save(con);
		return saved;
	}

	@Override
	public contact getById(int conid) {
		
		return crepo.findById(conid).get();
	}

	@Override
	public void deleteById(int conid) {
		crepo.deleteById(conid);
		
	}

	@Override
	public void DeleteAll() {
		crepo.deleteAll();
		
	}

	

}
