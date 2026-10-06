package com.example.garage;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GarageDataInitializer implements CommandLineRunner{

	@Autowired
	private GarageRepository grepo;

	@Override
	public void run(String... args) throws Exception {
		
		List<GarageEntity>garagedata=new ArrayList<>();
		
		for(int i=0;i<=100;i++) {
			
			GarageEntity garage=new GarageEntity();
			garage.setAddress("Wallstreet");
			garage.setBookamt(500);
			garage.setCity("Banglore");
			garage.setDescription("ABC");
			garage.setExp(15);
			garage.setGarageType("Both");
			garage.setGarageName("Carwala");
			garage.setGstNum("548454545432");
			garage.setOwner("Akshay");
			garage.setWorkingHrs("10.00 AM-7.00 PM");
			
			garagedata.add(garage);
			
		}
		
		grepo.saveAll(garagedata);
		
		System.out.println("100 Records inserted!");

	}
}
