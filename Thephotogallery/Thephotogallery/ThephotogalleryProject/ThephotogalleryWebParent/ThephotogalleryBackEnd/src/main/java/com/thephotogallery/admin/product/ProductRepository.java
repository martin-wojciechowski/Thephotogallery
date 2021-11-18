package com.thephotogallery.admin.product;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.thephotogallery.common.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
	
}
