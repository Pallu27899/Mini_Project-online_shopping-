package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dto.ProductDto;
import com.ecommerce.exception.CartException;
import com.ecommerce.exception.LoginException;
import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Cart;

public interface CartService {

	
	
	public Cart addProductToCart(Integer productId, Integer quantity, String key) throws CartException,LoginException,ProductException;
	
	
	public List<ProductDto> removeProductfromCart(Integer productId, String key) throws CartException,LoginException,ProductException;
	
	
	public List<ProductDto> updateProductQuantity(Integer productId, Integer quantity, String key)throws CartException,LoginException,ProductException;
	
	
	
	public Cart removeAllproduct(String key) throws CartException,LoginException;
	
	public List<ProductDto> viewAllProducts(String key) throws CartException,LoginException;
	
	
	
}
