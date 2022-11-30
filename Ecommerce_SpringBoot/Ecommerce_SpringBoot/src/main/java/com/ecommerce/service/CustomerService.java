package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.model.Customer;

public interface CustomerService {

	
	
	
	public Customer addCustomer(Customer customer) throws CustomerException;

	public Customer updateCust(Customer customer, String key) throws CustomerException, LoginException;
	
	public Customer removeCustomer(Customer customer,String key) throws CustomerException, LoginException;
	
	public Customer viemCustomer(Integer cusInteger) throws CustomerException;
	
//	public List<Customer> viewAll(String location) throws CustomerException;
	
	
}
