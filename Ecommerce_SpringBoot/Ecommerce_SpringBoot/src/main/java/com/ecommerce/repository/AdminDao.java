package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.Admin;
import com.ecommerce.model.Customer;

public interface AdminDao  extends JpaRepository<Admin, Integer>{
	
	public Admin findByemail(String email);

}