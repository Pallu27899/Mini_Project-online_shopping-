package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Product;

public interface  ProductService {

	
	public Product addProduct(Product product) throws ProductException;
	public List<Product> viewAllproduct() throws ProductException;
	
	public Product updateProduct(Product product) throws ProductException;
	
	public Product viewProduct(Integer id) throws ProductException;
	
	public List<Product> viewProudctbyCategory(String cname) throws ProductException;
	
	
	public Product removeProduct(Integer pid) throws ProductException;
	
	
	
}
