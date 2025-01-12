package com.eflyer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eflyer.bean.Product;
import com.eflyer.bean.ProductImage;

@Repository
public interface ProductImageRepository extends CrudRepository<ProductImage, Integer> {
	
	@Query("select pi from ProductImage pi where pi.product.productId = ?1")
	public List<ProductImage> getAllImagesOfProductById(int productId);
	
	public List<ProductImage> findByProduct(Product product);
}
