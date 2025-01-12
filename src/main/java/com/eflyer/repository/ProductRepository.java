package com.eflyer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eflyer.bean.Admin;
import com.eflyer.bean.Product;
import com.eflyer.bean.ProductImage;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
//	@Query("FROM Product where admin.adminId = :adminId")
//	public List<Product> getAdminProducts(int adminId);
	
	public List<Product> findByAdmin(Admin admin);
	
//	@Query("select p.productId from Product p where p.admin.adminId = ?1 order by p.productId desc")
//	public List<Integer> getAdminRecentProductId(int adminId);
	
	
}
