package com.example.cars;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends JpaRepository<CarEntity,Integer> {

	@Query("SELECT c FROM CarEntity c WHERE " +
	           "LOWER(c.companyName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	           "LOWER(c.carName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	           "LOWER(c.model) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	           "LOWER(c.fuelType) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	           "LOWER(c.city) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	           "LOWER(c.carType) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	           "LOWER(c.showroomName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	           "LOWER(c.gearTransmission) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	    List<CarEntity> searchCars(@Param("keyword") String keyword);

}
