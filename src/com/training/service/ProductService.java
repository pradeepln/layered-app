package com.training.service;

import java.util.List;

import com.training.domain.Product;

public interface ProductService {

	int addProduct(Product toBeAdded);

	void removeExisting(int id);

	Product findById(int id);

	List<Product> findAll();

}