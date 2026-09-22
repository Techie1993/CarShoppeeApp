package com.example.sellers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.Registration;
import com.example.garage.GarageEntity;

@Repository
public interface SellerRepository extends JpaRepository<SellersInfo,Integer> {
		
	@Query("SELECT c FROM SellersInfo c WHERE " +
	           "LOWER(c.city) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
	           "LOWER(c.state) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	
	List<SellersInfo> searchSeller(@Param("keyword") String keyword);
	           
	
	
}
