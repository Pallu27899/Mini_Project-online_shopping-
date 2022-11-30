package com.ecommerce.service;

import java.time.LocalDate;

import com.ecommerce.exception.AddressException;
import com.ecommerce.exception.CartException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.exception.OrderExcetion;
import com.ecommerce.model.Orders;

import java.util.List;
public interface OrderService {
	
	
	
	public  Orders addOrder(Orders order,String key) throws LoginException, CartException, OrderExcetion;
	
	public  Orders updateCustomer(Orders order,String key) throws LoginException, CartException, OrderExcetion;
	
	public  Orders removeOrder(Integer id,String key) throws LoginException, CartException, OrderExcetion;

	public  Orders viewOrder(Integer id) throws CartException, OrderExcetion;
	
	public List<Orders> viewallOrderByDate(LocalDate date) throws OrderExcetion;
	
	public List<Orders> orderbylocation(String city) throws OrderExcetion, AddressException;
	
	public List<Orders> viewallbyuserid(String userid) throws OrderExcetion;
}
