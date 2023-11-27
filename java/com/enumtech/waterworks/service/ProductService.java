package com.enumtech.waterworks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enumtech.waterworks.entity.Product;
import com.enumtech.waterworks.repository.ProductRepo;
@Service
public class ProductService {
	@Autowired
	ProductRepo productRepo;
	

	public void deleteProductById(int productId) {
	
	productRepo.deleteById(productId);
		
		
	}

	public Product insertProduct(Product product) {
		
		return productRepo.save(product) ;
	}

	public List<Product> getAllProduct() {
		return  productRepo.findAll();
	}

	public Product getProductById(int productId) {
		return productRepo.findById(productId).get();
	}


	public Product getProductByName(String productName) {
		return productRepo.findByProductName(productName);
	}


	public Product updateProductById(int productId, Product product) {
		
		Product insertDB = null;
		Optional<Product> temp = productRepo.findById(productId);

		if (temp.isPresent()) {
			insertDB = temp.get();
			insertDB.setProductName(product.getProductName());
			insertDB.setProductQty(product.getProductQty());
			
		}
		return productRepo.save(insertDB);

		
	}
	

}
