package com.taxfiling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taxfiling.entity.Customer;
import com.taxfiling.entity.TaxForm;
import com.taxfiling.repository.CustomerRepository;
import com.taxfiling.repository.TaxFormRepository;

@Service
public class AddTaxDetailsServiceImpl implements AddTaxDetailsService {
	@Autowired
	TaxFormRepository taxformRepo;

	@Autowired
	CustomerRepository customerRepo;

	@Override
	public int addTaxDetailsForEmployeeService(TaxForm objTaxForm) {
		taxformRepo.save(objTaxForm);
		return 1;
	}

	@Override
	@Transactional
	public int addTaxDetailsByNewCustomerService(TaxForm objTaxForm) {
		taxformRepo.save(objTaxForm);
		Customer c = customerRepo.getCustByPan(objTaxForm.getPan());
		c.setTaxForm(objTaxForm);
		customerRepo.save(c);
		return 1;
	}

	@Override
	public int addTaxDetailsByCustomerService(TaxForm objTaxForm) {
		TaxForm t = taxformRepo.findById(objTaxForm.getTaxformId()).orElse(null);
		t.setTotalIncomeSalary(objTaxForm.getTotalIncomeSalary());
		t.setOtherIncome(objTaxForm.getOtherIncome());
		t.setInterestIncome(objTaxForm.getInterestIncome());
		t.setRentalIncome(objTaxForm.getRentalIncome());
		t.setPpf(objTaxForm.getPpf());
		t.setMedicalInsurance(objTaxForm.getMedicalInsurance());
		t.setEducaionLoan(objTaxForm.getEducaionLoan());
		t.setNps(objTaxForm.getNps());
		t.setSavingsInterest(objTaxForm.getSavingsInterest());
		t.setVerifiedStatus("Pending");
		t.setPayableTax(objTaxForm.getPayableTax());
		t.setTaxformId(objTaxForm.getTaxformId());
		taxformRepo.save(t);
		Customer c1 = customerRepo.getCustByPan(objTaxForm.getPan());
		c1.setTaxForm(objTaxForm);
		customerRepo.save(c1);
		return 1;
	}
}
