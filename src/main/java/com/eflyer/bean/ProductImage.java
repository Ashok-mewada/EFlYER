package com.eflyer.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductImage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productImageId;
	private String productImageName;
	private boolean mainImage;
	
	@ManyToOne
	@JoinColumn(name = "productId")
	private Product product;

	public ProductImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductImage(int productImageId, String productImageName, boolean mainImage, Product product) {
		super();
		this.productImageId = productImageId;
		this.productImageName = productImageName;
		this.mainImage = mainImage;
		this.product = product;
	}

	public int getProductImageId() {
		return productImageId;
	}

	public void setProductImageId(int productImageId) {
		this.productImageId = productImageId;
	}

	public String getProductImageName() {
		return productImageName;
	}

	public void setProductImageName(String productImageName) {
		this.productImageName = productImageName;
	}

	public boolean isMainImage() {
		return mainImage;
	}

	public void setMainImage(boolean mainImage) {
		this.mainImage = mainImage;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductImage [productImageId=" + productImageId + ", productImageName=" + productImageName
				+ ", mainImage=" + mainImage + ", product=" + product + "]";
	}
	
	
}
