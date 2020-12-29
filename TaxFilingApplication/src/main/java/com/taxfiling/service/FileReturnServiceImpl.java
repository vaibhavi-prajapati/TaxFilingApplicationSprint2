package com.taxfiling.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxfiling.entity.Customer;
import com.taxfiling.entity.TaxForm;
import com.taxfiling.repository.CustomerRepository;
import com.taxfiling.repository.TaxFormRepository;

@Service
public class FileReturnServiceImpl implements FileReturnService{

	@Autowired
	private TaxFormRepository tr;
	
	@Autowired
	private CustomerRepository cr;
	
	@Override
	public int fileReturn(TaxForm t) {
		return tr.fileReturn(t);
	}

	@Override
	public TaxForm getTaxFromByPan(String pan) {
		System.out.println("pan:"+pan);
		return tr.getTaxFormByPan(pan);
	}

	@Override
	public Customer getCustomerById(Long id) {
		
		return cr.findById(id).orElse(null);
	}
}
