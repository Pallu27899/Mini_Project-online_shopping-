package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecommerce.exception.CustomerException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.Customer;

public interface CartDao  extends JpaRepository<Cart, Integer>{

	
	
	public Cart findByCustomer(Customer customer) throws CustomerException;
	
	
	@Query("select c from Cart c where c.customer.customerId=?1")
	public Cart getCart(Integer custId);
	
	
	
}
