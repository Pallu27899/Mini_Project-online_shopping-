package com.ecommerce.exception;

public class CartException  extends RuntimeException {

	
	
	public CartException()
	{
		
	}
	
	public CartException(String mess)
	{
		super(mess);
	}
}
