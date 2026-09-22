package com.example.garage;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GarageImpl implements GarageService{
	
	@Autowired
	private GarageRepository grepo;

	@Override
	public List<GarageEntity> getAllGarages() {
		List<GarageEntity>AllGarages=grepo.findAll();
		return AllGarages;
	}

	@Override
	public GarageEntity save(GarageEntity garage, MultipartFile[] files) throws IOException {

	    if(files != null) {

	        for(MultipartFile file : files) {

	            GarageImages img = new GarageImages();

	            img.setImage(file.getBytes());
	            img.setFileName(file.getOriginalFilename());
	            img.setContentType(file.getContentType());

	            // Parent mapping
	            img.setGarage(garage);

	            garage.getGimages().add(img);
	        }
	    }

	    GarageEntity saved = grepo.save(garage);

	    return saved;
	}

	@Override
	public GarageEntity getById(int gid) {
		
		return grepo.findById(gid).get();
	}

	@Override
	public void deleteById(int gid) {
		grepo.deleteById(gid);
	}

	@Override
	public void DeleteAll() {
		grepo.deleteAll();
		
	}

	@Override
	public List<GarageEntity> searchByKeyword(String keyword) {
		List<GarageEntity>garages=grepo.searchGarges(keyword);
		return garages;
	}

}
