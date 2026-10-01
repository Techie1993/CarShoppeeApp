package com.example.sellers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SellerImpl implements SellerService {
	
	@Autowired
	private SellerRepository srepo;

	@Override
	public List<SellersInfo> getAllSellers() {
		List<SellersInfo> Save=srepo.findAll();
		return Save;
	}

	@Override
	public SellersInfo Save(SellersInfo sell) {
		SellersInfo saved=srepo.save(sell);
		return saved;
	}

	@Override
	public SellersInfo getById(int sid) {
		
		return srepo.findById(sid).get();
	}

	@Override
	public void deleteById(int sid) {
		srepo.deleteById(sid);
		
	}

	@Override
	public void DeleteAll() {
		srepo.deleteAll();
		
	}

	@Override
	public List<SellersInfo> searchByKeyword(String keyword) {
		List<SellersInfo>sellinfo=srepo.searchSeller(keyword);
		return sellinfo;
	}

	@Override
	public Page<SellersInfo> GetAllSellers(int pagenum, int pagesize) {
		PageRequest page=PageRequest.of(pagenum, pagesize);
		return srepo.findAll(page);
	
		
	}

}
