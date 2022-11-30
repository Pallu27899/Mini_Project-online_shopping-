package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.exception.AddressException;
import com.ecommerce.model.Address;

public interface AddressDao  extends JpaRepository<Address, Integer> {

	
	@Query("from Address where state = ?1")
	public Address viewAllAddress(String id) throws AddressException;
	
}
