package com.example.garage;

import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.example.cars.CarEntity;
import com.example.sellers.SellersInfo;

public interface GarageService {
	public List<GarageEntity>getAllGarages();
	
	GarageEntity save(GarageEntity garage, MultipartFile[] files) throws IOException;   // create 
	
	public GarageEntity getById(int gid);				// Update
	
	public void deleteById(int gid);				// Delete
	
	public void DeleteAll(); 
	
	List<GarageEntity>searchByKeyword(String keyword);
}
