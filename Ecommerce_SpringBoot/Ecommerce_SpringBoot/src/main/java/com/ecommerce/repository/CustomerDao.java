package com.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.model.Customer;

public interface CustomerDao  extends JpaRepository<Customer, Integer>{

	
	public Customer findByemail(String email);
	public Optional<Customer> findBymobilenumber(String mobileNumber) throws CustomerException;

	
}
