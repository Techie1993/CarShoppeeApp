package com.example.cars;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarImageImpl implements CarImageService{

	
	@Autowired
	private CarImagesRepository imagerepo;
	
	
	@Override
	public List<CarImages> getAllImages() {
		List<CarImages>GetAll=imagerepo.findAll();
		return GetAll;
	}

	@Override
	public CarImages getByImageId(int imageId) {
		
		return imagerepo.findById(imageId).get();
	}

}
