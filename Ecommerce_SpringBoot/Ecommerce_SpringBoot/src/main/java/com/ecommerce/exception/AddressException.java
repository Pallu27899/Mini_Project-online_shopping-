package com.ecommerce.exception;

public class AddressException extends RuntimeException{

	
	public AddressException()
	{
		
	}
	

	public AddressException(String mess)
	{
		super(mess);
	}
}
