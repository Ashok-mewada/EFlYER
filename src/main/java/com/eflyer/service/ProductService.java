package com.eflyer.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eflyer.bean.Admin;
import com.eflyer.bean.Product;
import com.eflyer.bean.ProductImage;
import com.eflyer.repository.ProductImageRepository;
import com.eflyer.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductImageRepository productImageRepository;
	
	public List<Product> getAdminProducts(Admin admin){
		return this.productRepository.findByAdmin(admin);
//		return findAll();
	}
	
	public void save(Product product) {
		this.productRepository.save(product);
	}
	
	public int getAdminRecentProductId(Admin admin) {
		List<Product> products =  productRepository.findByAdmin(admin);
		
		Product p = products.get(products.size()-1);
		return p.getProductId();
	}
	
	public Product findById(int productId) {
		return this.productRepository.findById(productId).get();
	}
	
	public List<ProductImage> getAllImagesOfProductById(Product product){
		return this.productImageRepository.findByProduct(product);
	}
	
	public List<Product> findAll(){
		List<Product> products = new ArrayList<Product>();
		this.productRepository.findAll().forEach(products::add);
		return products;
	}

	
}
