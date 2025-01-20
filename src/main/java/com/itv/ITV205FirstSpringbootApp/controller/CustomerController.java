package com.itv.ITV205FirstSpringbootApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itv.ITV205FirstSpringbootApp.model.Customer;
import com.itv.ITV205FirstSpringbootApp.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@RequestMapping("/welcome")
	public String welcome() {
		return "hello";
	}

	@RequestMapping("/addCustomer")
	public String addCustomer() {
		Customer c1 = new Customer();
		c1.setCustEmail("alice@123");
		c1.setCustGender("female");
		c1.setCustName("Alice");
		customerService.addCustomer(c1);
		return "Customer added Successfully!!!!!!!!";

	}

	@PostMapping("/addCustomerByRequestParam")
	public Customer addCustomerByRequestParam(@RequestParam("a") String email, @RequestParam("b") String gen,
			@RequestParam("c") String name) {
		Customer c1 = new Customer();
		c1.setCustEmail(email);
		c1.setCustGender(gen);
		c1.setCustName(name);
		return customerService.addCustomer(c1);

	}

	@PostMapping("/addCustomerByRequestbody")
	public Customer addCustomerByRequestbody(@RequestBody Customer c1) {
		return customerService.addCustomer(c1);

}
	@PostMapping("/addCustomerByPathVariable/{emal}/{gen}/{name}")
	public Customer addCustomerByPathVariable(@PathVariable("emal") String email, @PathVariable("gen") String gen,
			@PathVariable("name") String name) {
		Customer c1 = new Customer();
		c1.setCustEmail(email);
		c1.setCustGender(gen);
		c1.setCustName(name);
		return customerService.addCustomer(c1);

	}
	@GetMapping("/getAllCustomer")
	public List<Customer> getAllCustomer() {
		
		
		return customerService.getAllCustomer();

	}
	@GetMapping("/getCustomerById/{id}")
	public Customer getCustomerById(@PathVariable("id") int custid) {
		
		
		return customerService.getCustomerById(custid);

	}
}
