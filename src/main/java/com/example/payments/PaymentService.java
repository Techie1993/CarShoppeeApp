package com.example.payments;

import java.util.List;

import com.example.demo.Registration;

public interface PaymentService {

	public List<PaymentEntity>getAllPayments();
	
	public PaymentEntity SavePay(PaymentEntity pay);    // create 
	
	public PaymentEntity getById(int payid);				// Update
	
	public void deleteById(int payid);				// Delete
	
	public void DeleteAll(); 
	
}
