package com.thricethree.spring.crud.frontend.controller;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
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
import com.thricethree.spring.crud.model.Order;
import com.thricethree.spring.crud.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	private OrderService orderService;
	
	@Inject
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	// List Orders By User
	@RequestMapping("/list")
	public ModelAndView orderListByUser(@RequestParam("userName") String user, Model model) {
		System.out.println("=== In orderList ===");
		List<Order> orders = orderService.getOrdersByUser(user);
		model.addAttribute("orderList", orders);
		return new ModelAndView("order/orderList");
	}
	

	// View Order
	@RequestMapping("/view")
	public ModelAndView orderView(@RequestParam("orderId") int orderId,
			Model model) {
		System.out.println("=== In orderView ===");
		Order order = orderService.getOrderById(orderId);
		model.addAttribute("order", order);
		return new ModelAndView("order/viewOrder");

	}

	
	// Add Order Before Submitting Form
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addOrder(Model model, Principal principal) {
		System.out.println("=== In addOrder ===");
		User activeUser = (User) ((Authentication) principal).getPrincipal();
		Order order = new Order(0, null, 0, " ", activeUser.getUsername());
		orderService.insertOrder(order);
		order = orderService.getLastInsert();
		model.addAttribute("order", order);
		return "order/addOrder";
	}

	
	// After submitting Add order Form
		@RequestMapping(value="/add", method=RequestMethod.POST)
		public String addOrderSave(Order order, BindingResult bindingResult) {
			System.out.println("======= in addProductSave");
			if(bindingResult.hasErrors()){
				return "order/addOrder";
			}
			orderService.insertOrder(order);
				return "redirect:/order/view.html?orderId=" + order.getOrderId();
		}
	
	
	// Edit Order
	@RequestMapping(value = "/edit/{orderId}", method = RequestMethod.GET)
	public String editOrder(@PathVariable int orderId, Model model) {
		System.out.println("======= in editOrder");
		Order order = orderService.getOrderById(orderId);
		model.addAttribute("order", order);
		return "order/editOrder";
	}

	// Edit Order Save
	@RequestMapping(value = "/edit/{orderId}", method = RequestMethod.POST)
	public String editOrderSave(@PathVariable int orderId, @Valid Order order,
			BindingResult bindingResult) {
		System.out.println("======= in editOrderSave");
		if (bindingResult.hasErrors()) {
			return "order/editOrder";
		}
		orderService.updateOrder(orderId, order);
		;
		return "redirect:/order/view.html?orderId=" + orderId;
	}

	// Delete Order

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String deleteOrders(@ModelAttribute Items selectedOrders) {
		System.out.println("======= in deleteOrders");
		for (String orderIdStr : selectedOrders.getItemList()) {
			System.out.println("delete order id=" + orderIdStr);
			try {
				int orderId = Integer.parseInt(orderIdStr);
				orderService.deleteOrder(orderId);
			} catch (Exception e) {
			}
		}
		return "redirect:/order/list.html";
	}

}
