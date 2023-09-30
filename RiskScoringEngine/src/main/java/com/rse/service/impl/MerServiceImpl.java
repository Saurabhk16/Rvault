package com.rse.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rse.dao.MerDetailsDao;
import com.rse.model.Merchant;
import com.rse.service.MerService;

@Service
public class MerServiceImpl implements MerService {

	@Autowired
	MerDetailsDao merDetailsDao;

	@Override
	public Merchant saveTransaction(Merchant merchant) {
		Merchant object = new Merchant();
		try {
			Merchant obj = new Merchant();
			obj = merDetailsDao.save(merchant);
			object = merDetailsDao.findByEmail(obj.getEmail());
			object.setStatus("200");
		} catch (Exception e) {
			System.out.println("Exception Occured : " + e);
			object.setStatus("100");
		}
		return object;

	}

}
