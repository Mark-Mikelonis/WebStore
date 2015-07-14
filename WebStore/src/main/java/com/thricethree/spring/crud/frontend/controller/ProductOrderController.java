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
import com.thricethree.spring.crud.model.ProductOrder;
import com.thricethree.spring.crud.service.OrderService;
import com.thricethree.spring.crud.service.ProductOrderService;
import com.thricethree.spring.crud.service.ProductService;


@Controller
@RequestMapping("/productorder")
public class ProductOrderController {

	private ProductOrderService productOrderService;
	
	@Inject
	public void setProductOrderService(ProductOrderService productOrderService) {
		this.productOrderService = productOrderService;
	}
	
	
	private ProductService productService;
	
	@Inject
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	private OrderService orderService;
	
	@Inject
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	// List Product Orders By Order ID
	@RequestMapping("/list")
	public ModelAndView productOrderListByOrderId(@RequestParam("orderId") int orderId, Model model) {
		System.out.println("=== In productOrderList ===");
		List<ProductOrder> productOrders = productOrderService.getProductOrderByOrderId(orderId);
		System.out.println("productOrders size: " + productOrders.size());
		for(ProductOrder productOrder: productOrders){
			productOrder.setProductName(productService.getProduct(productOrder.getProductId()).getProductName());
			
		}
		model.addAttribute("productOrderList", productOrders);
		model.addAttribute("selectedProductOrders", new Items());
		return new ModelAndView("productorder/productOrderList");
	}
	
	// Add Product Order before submitting
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProductOrder(Model model) {
		System.out.println("=== In addProduct ===");
		model.addAttribute(new ProductOrder());
		return "productorder/addProductOrder";
	}
		
	// After submitting Add product Form
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addProductOrderSave(ProductOrder productOrder, BindingResult bindingResult) {
		System.out.println("======= in addProductSave");
		if(bindingResult.hasErrors()){
			return "productorder/addProductOrder";
		}
		productOrderService.insertProductOrder(productOrder);
			return "redirect:/productOrder/list.html";
	}
	
	// Edit Product Order
	@RequestMapping(value = "/edit/{productOrderId}", method = RequestMethod.GET)
	public String editProductOrder(@PathVariable int productOrderId, Model model) {
		System.out.println("======= in editProductOrder");
		ProductOrder productOrder = productOrderService.getProductOrderByProductOrderId(productOrderId);
		model.addAttribute("productOrder", productOrder);
		return "productorder/editProductOrder";
	}
		
		
	// Edit Product Order Save
	@RequestMapping(value = "/edit/{productOrderId}", method = RequestMethod.POST)
	public String editProductOrderSave(@PathVariable int productOrderId, @Valid ProductOrder productOrder,
			BindingResult bindingResult) {
		System.out.println("======= in editProductOrderSave");
		int orderDifference = 0;
		if (bindingResult.hasErrors()) {
			return "productorder/editProductOrder";
		}
		int orderId = productOrder.getOrderId();
		ProductOrder pOrder = productOrderService.getProductOrderByProductOrderId(productOrderId);
		
		orderDifference = pOrder.getOrderAmount() - productOrder.getOrderAmount();
		
		Product product = productService.getProduct(productOrder.getProductId());
		System.out.println("ProductId: " + productOrder.getProductId());
		System.out.println("Order Diff: "+ orderDifference);
		
		product.setAvailableQuantity(product.getAvailableQuantity() + orderDifference);
		productService.updateProduct(product.getProductId(), product);
	    productOrderService.updateProductOrder(productOrderId, productOrder);
			
		return "redirect:/productorder/list.html?orderId=" + orderId;
	}
	
	// Add Product List

		@RequestMapping(value = "/listadd", method = RequestMethod.POST)
		public String addProductsToOrder(@RequestParam("user") String user, @ModelAttribute Items selectedProducts) {
			System.out.println("======= in addProductsToOrder");
			int orderId = orderService.getCart(user);
			for (String prodIdStr : selectedProducts.getItemList()) {
				System.out.println("add product id=" + prodIdStr);
				try {
					int productId = Integer.parseInt(prodIdStr);
					Product product = productService.getProduct(productId);
					product.setAvailableQuantity((product.getAvailableQuantity()-1));
					productService.updateProduct(productId, product);
					ProductOrder pOrder = new ProductOrder(0, orderId, productId, 1);
					productOrderService.insertProductOrder(pOrder);
				} catch (Exception e) {
				}
			}
			return "redirect:/productorder/list.html?orderId=" + orderId ;
		}
	
	// Delete Product Order

		@RequestMapping(value = "/list", method = RequestMethod.POST)
		public String deleteProductOrders(@ModelAttribute Items selectedProductOrders) {
			System.out.println("======= in deleteProductOrders");
			int orderId = 0;
			Product product = null;
			ProductOrder productOrder = null;
			for (String prodOrderIdStr : selectedProductOrders.getItemList()) {
				System.out.println("delete product order id=" + prodOrderIdStr);
				try {
					int productOrderId = Integer.parseInt(prodOrderIdStr);
					productOrder = productOrderService.getProductOrderByProductOrderId(productOrderId);
					orderId = productOrder.getOrderId();
					product = productService.getProduct(productOrder.getProductId());
					product.setAvailableQuantity(product.getAvailableQuantity() + productOrder.getOrderAmount());
					productService.updateProduct(product.getProductId(), product);
					productOrderService.deleteProductOrder(productOrderId);
				} catch (Exception e) {
				}
			}
			
			return "redirect:/productorder/list.html?orderId=" + orderId;
		}
	
}
