package com.example.cars;

import java.util.List;

import org.springframework.stereotype.Service;


public interface CarImageService {
	public List<CarImages>getAllImages();
	
	public CarImages getByImageId(int imageId);
}
