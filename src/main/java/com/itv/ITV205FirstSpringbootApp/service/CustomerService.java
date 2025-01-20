package com.itv.ITV205FirstSpringbootApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itv.ITV205FirstSpringbootApp.model.Customer;
import com.itv.ITV205FirstSpringbootApp.repository.CustomerRepository;

@Service

public class CustomerService {
	@Autowired
	CustomerRepository customerRepository; 
	public Customer addCustomer(Customer c1) {

		 return customerRepository.save(c1);
	
	}
	public Customer getCustomerById(int custid) {
		
		return customerRepository.findById(custid).get();
	}
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}
}
