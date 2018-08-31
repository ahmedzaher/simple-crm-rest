package com.simple_crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simple_crm.entity.Customer;
import com.simple_crm.rest.exception.CustomerNotFoundException;
import com.simple_crm.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("")
	public List<Customer> getCustomers() {
		List<Customer> customers = customerService.getCustomers();
		return customers;
	}

	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable("id") int id) {
		Customer customer = customerService.getCustomer(id);
		System.out.println(customer);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer not found -- " + id);
		}
		return customer;
	}

	@PostMapping("")
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		customerService.addCustomer(customer);

		return customer;
	}

	@PutMapping("")
	public Customer updateCustomer(@RequestBody Customer customer) {
		if (customerService.getCustomer(customer.getId()) == null) {
			throw new CustomerNotFoundException("Customer not found -- " + customer.getId());
		}
		customerService.updateCustomer(customer);
		return customer;
	}

	@DeleteMapping("/{id}")
	public String deleteCustomer(@PathVariable("id") int id) {
		Customer customer = customerService.getCustomer(id);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer not found -- " + id);
		}

		customerService.deleteCustomer(id);
		return "Customer Deleted -- " + id;
	}
}
