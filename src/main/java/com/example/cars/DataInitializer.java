package com.example.cars;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class DataInitializer implements CommandLineRunner{

	
	@Autowired
	private CarRepository crepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		List<CarEntity>cardata=new ArrayList<>();
		
		
		for(int i=1;i<=100;i++) {
			
			CarEntity carinfo=new CarEntity();
			
			carinfo.setCarName("Thar");
			carinfo.setCarType("SUV");
			carinfo.setChassisNumber("12154545452");
			carinfo.setCity("Pune");
			carinfo.setCompanyName("Mahindra");
			carinfo.setDescription("ABC");
			carinfo.setDistanceCovered("2500 Kms");
			carinfo.setEmissionStandards("BS-5");
			carinfo.setEngineNumber("78544245454");
			carinfo.setFuelType("Petrol");
			carinfo.setGearConfiguration("4 * 4");
			carinfo.setGearTransmission("Manual");
			carinfo.setInsurance("Done");
			carinfo.setModel("VXI");
			carinfo.setPucStatus("Done");
			carinfo.setRegistrationNumber("MH40 AR-5419");
			carinfo.setShowroomName("Ak Gandhi Motors");
			carinfo.setYear(2018);
			
			cardata.add(carinfo);
				
		}
		
		crepo.saveAll(cardata);
		System.out.println("100 Records inserted!");
		
	}
}
