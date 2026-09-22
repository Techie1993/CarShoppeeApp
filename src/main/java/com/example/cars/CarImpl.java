package com.example.cars;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CarImpl implements CarService{
	
	@Autowired
	private CarRepository crepo;

	@Override
	public List<CarEntity> getAllCars() {
		List<CarEntity>AllCars=crepo.findAll();
		return AllCars;
	}

	

	@Override
	public CarEntity getById(int cid) {
		
		return crepo.findById(cid).get();
	}

	@Override
	public void deleteById(int cid) {
		crepo.deleteById(cid);
		
	}

	@Override
	public void DeleteAll() {
		crepo.deleteAll();
		
	}


	 @Override
	    public CarEntity saveCar(CarEntity car, MultipartFile[] files) throws IOException {

	        for (MultipartFile file : files) {

	            CarImages image = new CarImages();

	            image.setFileName(file.getOriginalFilename());
	            image.setContentType(file.getContentType());
	            image.setImage(file.getBytes());

	            image.setCar(car);

	            car.getImages().add(image);
	        }

	        return crepo.save(car);
	    }


	 @Override
	 public List<CarEntity> searchByKeyword(String keyword) {
		List<CarEntity>cardata=crepo.searchCars(keyword);
		return cardata;
	 } 
}
