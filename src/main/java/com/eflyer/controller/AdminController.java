package com.eflyer.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;




import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.eflyer.bean.Admin;
import com.eflyer.bean.Product;
import com.eflyer.bean.ProductImage;
import com.eflyer.bean.User;
import com.eflyer.service.ProductService;
import com.eflyer.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	private HttpSession session;
	
	String path = "D:\\Spring Boot\\Eflyer\\Eflyer\\src\\main\\webapp\\images" + File.separator;
	
	@RequestMapping("/admin")
	public String adminHome(Model model, HttpServletRequest request) {
		session = request.getSession();
		Admin user = (Admin) session.getAttribute("admin");
		List<Product> products = productService.getAdminProducts(user);
//		System.out.println(user.getUserID());
//		for(Product product: products) {
//			System.out.println(product);
//		}
		model.addAttribute("products", products);
		return "admin_home";
	}
	
	
	@RequestMapping("/add_product")
	public String addProduct(@ModelAttribute("product") Product product,
			@RequestParam("files") List<MultipartFile> files
			,Model model,
			HttpServletRequest request) throws IOException {
		session = request.getSession();
		List<String> images = new ArrayList<String>();
		List<ProductImage> productImages = new ArrayList<ProductImage>();
		if(product != null) {
			                                      
			System.out.println(files);
			for(MultipartFile file: files) {
				String name = URLEncoder.encode(file.getOriginalFilename(), "UTF-8");
				try {
					Files.copy(file.getInputStream(), Paths.get(path+name), StandardCopyOption.REPLACE_EXISTING);
					ProductImage productImage = new ProductImage();
					productImage.setProductImageName(name);
					productImage.setMainImage(false);
					productImage.setProduct(product);
//					this.productImageService.saveProductImage(productImage);
					productImages.add(productImage);
				}catch(FileNotFoundException e) {
					e.printStackTrace();
				}
				
				images.add(name);
			}
			model.addAttribute("productImages", images);
			product.setProductImages(productImages);
			Admin admin = (Admin) session.getAttribute("admin");
			product.setAdmin(admin);
			Enumeration<String> e =  session.getAttributeNames();
			System.out.println(session.getId());
			this.productService.save(product);
			int id = this.productService.getAdminRecentProductId(admin);
			model.addAttribute("id",id);
			return "images_preview";
		}
		return "redirect:/upload";
	}	
	
	@RequestMapping("/setMainImage")
	public String setMainImage(@RequestParam("mainImage") String mainImage, @RequestParam("productId") int productId) {
		System.out.println(mainImage + " "+ productId);
		Product p = this.productService.findById(productId);
		List<ProductImage> productImages = p.getProductImages();
		for(ProductImage productImage: productImages) {
			if(productImage.getProductImageName().equals(mainImage)) {
				productImage.setMainImage(true);
			}else {
				productImage.setMainImage(false);
			}
		}
		this.productService.save(p);
		return "redirect:/admin";
	}
	

	@RequestMapping("/upload")
	public String fileUpload1(HttpServletRequest request) {
		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("admin");
		return "upload";
	}
	
	@RequestMapping("/viewProduct")
	public String viewProduct(@RequestParam("id") int productId, Model model) {
		Product product = this.productService.findById(productId);
		if(product == null) {
			return "redirect:/admin";
		}
		model.addAttribute("product", product);
		return "preview";
	}
	
	@PostMapping("/toggleVisibility")
	public String toggleProductStatus(@RequestParam("id") int productId,
			@RequestParam("status") boolean status){
		System.out.println("Request Aayi");
			Product product = this.productService.findById(productId);
			if(product != null) {
//				System.out.println(product.getStatus());
				product.setStatus(status);
//				System.out.println(product.);
				this.productService.save(product);
			}
			return "admin_home";
	}
	
	@RequestMapping("/updateProduct")
	public String updateProduct(@ModelAttribute("product") Product product,
			@RequestParam("files") List<MultipartFile> files,
			Model model,
			HttpServletRequest request) throws IOException {
		if(product != null) {
			session = request.getSession();
			Admin admin = (Admin) session.getAttribute("admin");
			product.setAdmin(admin);
			List<ProductImage> images = new ArrayList<ProductImage>();
			System.out.println("Checking "+files.size() +"  "+files.isEmpty()+files.get(0).getOriginalFilename().isBlank());
			System.out.println(files);
			if(!files.get(0).getOriginalFilename().isBlank()) {
				for(MultipartFile file: files) {
					String name = URLEncoder.encode(file.getOriginalFilename(), "UTF-8");
					try {
						Files.copy(file.getInputStream(), Paths.get(path+name), StandardCopyOption.REPLACE_EXISTING);
						ProductImage productImage = new ProductImage();
						productImage.setProductImageName(name);
						productImage.setMainImage(false);
						productImage.setProduct(product);
						images.add(productImage);
					}catch(FileNotFoundException e) {
						e.printStackTrace();
					}
				}
				product.setProductImages(images);
				this.productService.save(product);
			}else {
				List<ProductImage> existingImages = this.productService.getAllImagesOfProductById(product);
				product.setProductImages(existingImages);
				this.productService.save(product);
			}
		}
		return "redirect:/admin";
	}
	
	@RequestMapping("editProduct")
	public String editProduct(@RequestParam("id") int productId, Model model) {
		Product product = this.productService.findById(productId);
		if(product == null) {
			return "redirect:/admin";
		}
		model.addAttribute("product",product);
		return "edit_product";
	}
	
	
//	public void uploadingFiles(List<MultipartFile> files) throws IOException {
//		for (MultipartFile file : files) {
//			System.out.println(file.getOriginalFilename());
//			System.out.println(file.getContentType());
//			
//			byte[] bytes = file.getBytes();
//		
//			String path = "E:\\Universal 1\\Spring\\EflyerShopping\\src\\main\\webapp\\images" + File.separator + file.getOriginalFilename();
//			
//			System.out.println(path);
//			
//			FileOutputStream output;
//			try {
//				output = new FileOutputStream(path);
//				output.write(bytes);
//				output.close();
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
//			ProductImage p = new ProductImage();
//			p.setImageName(file.getOriginalFilename());
//			p.setMainImage(true);
//			System.out.println(p);
//			int id =productImageService.saveProductImage(p);
//		}
//	}
	
	
}
