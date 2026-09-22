package com.example.payments;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentImpl implements PaymentService{

	@Autowired
	PaymentRepository payrepo;
	
	
	
	@Override
	public List<PaymentEntity> getAllPayments() {
		List<PaymentEntity>AllPays=payrepo.findAll();
		return AllPays;
	}

	@Override
	public PaymentEntity SavePay(PaymentEntity pay) {
		PaymentEntity payment=payrepo.save(pay);
		return payment;
	}

	@Override
	public PaymentEntity getById(int payid) {
		
		return payrepo.findById(payid).get();
	}

	@Override
	public void deleteById(int payid) {
		payrepo.deleteById(payid);
		
	}

	@Override
	public void DeleteAll() {
		payrepo.deleteAll();
		
	}

}
