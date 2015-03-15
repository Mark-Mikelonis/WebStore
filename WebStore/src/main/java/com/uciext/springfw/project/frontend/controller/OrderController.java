package com.uciext.springfw.project.frontend.controller;

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

import com.uciext.springfw.project.model.Items;
import com.uciext.springfw.project.model.Order;
import com.uciext.springfw.project.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	private OrderService orderService;
	
	@Inject
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	// List Orders By User
//	@RequestMapping("/list")
//	public ModelAndView orderListByUser(Model model, String user) {
//		System.out.println("=== In orderList ===");
//		List<Order> orders = orderService.getOrdersByUser(user);
//		model.addAttribute("orderList", orders);
//		model.addAttribute("selectedOrders", new Items());
//		return new ModelAndView("order/orderList");
//	}
	
	// List Orders
		@RequestMapping("/list")
		public ModelAndView orderList(Model model) {
			System.out.println("=== In orderList ===");
			List<Order> orders = orderService.getOrders();
			model.addAttribute("orderList", orders);
			model.addAttribute("selectedOrders", new Items());
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

	// Add Order
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addOrder(Model model) {
		System.out.println("=== In addOrder ===");
		model.addAttribute(new Order());
		return "order/addOrder";
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
		return "redirect:/order/list.html";
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
