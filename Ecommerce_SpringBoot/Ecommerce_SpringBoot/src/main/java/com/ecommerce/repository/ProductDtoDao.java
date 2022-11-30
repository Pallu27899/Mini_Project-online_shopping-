package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.dto.ProductDto;

public interface ProductDtoDao extends JpaRepository<ProductDto, Integer> {

	
	
}
