package com.example.service;

import java.util.List;

import com.example.demo.Registration;

public interface BookService {

	public List<BookingServiceEntity>getAllBookings();
	
	public BookingServiceEntity BookUser(BookingServiceEntity book);    // create 
	
	public BookingServiceEntity getById(int id);				// Update
	
	public void deleteById(int servid);				// Delete
	
	public void DeleteAll(); 
	
	
	
}
