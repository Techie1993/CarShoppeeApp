package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingImpl implements BookService {
	
	@Autowired
	private BookingServiceRepository bookrepo;

	@Override
	public List<BookingServiceEntity> getAllBookings() {
		List<BookingServiceEntity>AllBookings=bookrepo.findAll();
		return AllBookings;
	}

	@Override
	public BookingServiceEntity BookUser(BookingServiceEntity book) {
		BookingServiceEntity booked=bookrepo.save(book);
		return booked;
	}

	@Override
	public BookingServiceEntity getById(int servid) {
		
		return bookrepo.findById(servid).get();
	}

	@Override
	public void deleteById(int servid) {
		bookrepo.deleteById(servid);
		
	}

	@Override
	public void DeleteAll() {
		bookrepo.deleteAll();
		
	}

	
}
