package com.taxfiling.service;

import com.taxfiling.entity.Admin;
import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;

public interface RegistrationService {
	public int registercustomer(Customer c);
	public int registerEmployer(Employer e);
	public int registerRepresentative(Representative r);
	public int registerAdmin(Admin a);
}
