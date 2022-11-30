package com.ecommerce.exception;

public class CustomerException  extends RuntimeException{

	
	
	public CustomerException()
	{
		
	}
	
	public CustomerException(String mess)
	{
		super(mess);
	}
}

