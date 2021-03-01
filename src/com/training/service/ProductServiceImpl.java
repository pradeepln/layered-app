package com.training.service;

import java.util.List;

import com.training.dal.ProductDAO;
import com.training.dal.ProductDAOInMemImpl;
import com.training.domain.Product;

public class ProductServiceImpl implements ProductService {
	
	ProductDAO dao = new ProductDAOInMemImpl();
	
	@Override
	public int addProduct(Product toBeAdded) {
		if(toBeAdded.getPrice() * toBeAdded.getQoh() >= 10000) {
			Product added = dao.save(toBeAdded);
			return added.getId();
		}else {
			throw new IllegalArgumentException("Product Value must be GTEQ 10k");
		}
	}
	
	@Override
	public void removeExisting(int id) {
		Product existing = dao.findById(id);
		
		if(existing.getPrice() * existing.getQoh() < 100000) {
			dao.deleteById(id);
		}else {
			throw new IllegalStateException("Product worth more than 100k, can't just be deleted!");
		}
	}

	@Override
	public Product findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	
	
}
