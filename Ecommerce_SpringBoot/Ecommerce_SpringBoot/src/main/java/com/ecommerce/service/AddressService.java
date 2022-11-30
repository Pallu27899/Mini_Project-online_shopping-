package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.AddressException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.model.Address;

public interface AddressService {

	
	
	public Address addAddress(Address add , String key) throws AddressException, LoginException;
	
	public Address updateAddress(Address add, String key) throws AddressException , LoginException;
	
	public String removeAddress(Integer addressId,String key) throws AddressException, LoginException;
	
	public List<Address> viewAlladdress();
	
	public Address viewAddress(Integer id) throws AddressException;
	
}
