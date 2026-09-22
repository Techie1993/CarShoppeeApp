package com.example.sellers;

import java.util.List;

import com.example.demo.Registration;

public interface SellerService {
	public List<SellersInfo>getAllSellers();
	
	public SellersInfo Save(SellersInfo sell);    // create 
	
	public SellersInfo getById(int sid);				// Update
	
	public void deleteById(int sid);				// Delete
	
	public void DeleteAll();
	
	List<SellersInfo>searchByKeyword(String keyword);
}
