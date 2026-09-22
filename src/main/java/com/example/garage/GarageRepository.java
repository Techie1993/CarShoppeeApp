package com.example.garage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.cars.CarEntity;

public interface GarageRepository extends JpaRepository<GarageEntity,Integer>{

	@Query("SELECT c FROM GarageEntity c WHERE " +
	           "LOWER(c.city) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	           "LOWER(c.garageType) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	
	List<GarageEntity> searchGarges(@Param("keyword") String keyword);
	           
	   
	
	
	
}
