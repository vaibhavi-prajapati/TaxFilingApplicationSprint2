package com.taxfiling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taxfiling.entity.Admin;
import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;
import com.taxfiling.service.RegistrationService;

@RestController
public class RegistrationController {
	@Autowired
	private RegistrationService ts;

	@PostMapping("/registerCustomer")
	public String registercustomer(@RequestBody Customer c) {
		System.out.println("ccname:"+c.getName());
		String str = "Registration unsuccessful";
		int i = ts.registercustomer(c);
		if (i > 0) {
			str = "Registration successful";
		}
		return str;
	}

	@PostMapping("/registerEmployer")
	public String registerEmployer(@RequestBody Employer e) {
		String str = "Registration unsuccessful";
		int i = ts.registerEmployer(e);
		if (i > 0) {
			str = "Registration successful";
		}
		return str;
	}

	@PostMapping("/registerRepresentative")
	public String registerRepresentative(@RequestBody Representative r) {
		String str = "Registration unsuccessful";
		int i = ts.registerRepresentative(r);
		if (i > 0) {
			str = "Registration successful";
		}
		return str;
	}

	@PostMapping("/registerAdmin")
	public String registerAdmin(@RequestBody Admin a) {
		String str = "Registration unsuccessful";
		int i = ts.registerAdmin(a);
		if (i > 0) {
			str = "Registration successful";
		}
		return str;
	}
}
