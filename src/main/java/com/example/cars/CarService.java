package com.example.cars;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Registration;

public interface CarService {

	public List<CarEntity>getAllCars();
	
	CarEntity saveCar(CarEntity car, MultipartFile[] files) throws IOException;   // create 
	
	public CarEntity getById(int cid);	// Update
	
	public void deleteById(int cid);	// Delete
	
	public void DeleteAll(); 
	
	List<CarEntity> searchByKeyword(String keyword);
	
	
}
