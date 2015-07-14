package com.thricethree.spring.crud.frontend.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thricethree.spring.crud.model.Items;
import com.thricethree.spring.crud.model.Product;
import com.thricethree.spring.crud.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	private ProductService productService;

	@Inject
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	// List Products
	@RequestMapping("/list")
	public ModelAndView listProducts(Model model) {
		System.out.println("=== In productList ===");
		List<Product> products = productService.getProducts();
		model.addAttribute("productList", products);
		model.addAttribute("selectedProducts", new Items());
		return new ModelAndView("product/productList");

	}

	// View Product
	@RequestMapping("/view")
	public ModelAndView productView(@RequestParam("productId") int productId,
			Model model) {
		System.out.println("=== In productView ===");
		Product product = productService.getProduct(productId);
		model.addAttribute("product", product);
		return new ModelAndView("product/viewProduct");

	}

	// Add Product before submitting
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProduct(Model model) {
		System.out.println("=== In addProduct ===");
		model.addAttribute(new Product());
		return "product/addProduct";
	}
	
	// After submitting Add product Form
		@RequestMapping(value="/add", method=RequestMethod.POST)
		public String addProductSave(Product product, BindingResult bindingResult) {
			System.out.println("======= in addProductSave");
			if(bindingResult.hasErrors()){
				return "product/addProduct";
			}
			productService.insertProduct(product);
			return "redirect:/product/list.html";
		}

	// Edit Product
	@RequestMapping(value = "/edit/{productId}", method = RequestMethod.GET)
	public String editDepartment(@PathVariable int productId, Model model) {
		System.out.println("======= in editProduct");
		Product product = productService.getProduct(productId);
		model.addAttribute("product", product);
		return "product/editProduct";
	}

	// Edit Product Save
	@RequestMapping(value = "/edit/{productId}", method = RequestMethod.POST)
	public String editDepartmentSave(@PathVariable int productId,
			@Valid Product product, BindingResult bindingResult) {
		System.out.println("======= in editProductSave");
		if (bindingResult.hasErrors()) {
			return "product/editProduct";
		}
		productService.updateProduct(productId, product);
		return "redirect:/product/list.html";
	}

	// Delete Product

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String deleteProducts(@ModelAttribute Items selectedProducts) {
		System.out.println("======= in deleteProducts");
		for (String prodIdStr : selectedProducts.getItemList()) {
			System.out.println("delete product id=" + prodIdStr);
			try {
				int productId = Integer.parseInt(prodIdStr);
				productService.deleteProduct(productId);
			} catch (Exception e) {
			}
		}
		return "redirect:/product/list.html";
	}

}
