package com.enumtech.waterworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enumtech.waterworks.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

	Product findByProductName(String productName);
	
	//@Query(value="select * from Category where cat_type=?1",nativeQuery = true)
	//Category getCategoryByType(String cat_type);
	
	//@Query(value="select * from Category where cat_type=?1",nativeQuery = true)
	//List<Category> getAllCategoryByType(String cat_type);


}
