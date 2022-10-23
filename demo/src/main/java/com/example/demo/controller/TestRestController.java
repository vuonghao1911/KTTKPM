//package com.example.demo.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.entity.Order;
//import com.example.demo.service.OrderRepository;
//
//@RestController
//
//public class TestRestController {
//	@Autowired
//	private OrderRepository orderRepository;
//	@GetMapping("/")
//	public String demo() {
//		return "ok";
//	}
//	
//	   @PostMapping("/saveorder")
//	    public Order addOrder(@RequestBody Order order) {
//	    	
//	    	try {
//				 orderRepository.save(order);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//	    	
//	    	return order;
//	    }
//	    @GetMapping("/getlist")
//	    public List<Order> getOrder() {
//	    	List<Order> list = orderRepository.findAll();
//	    	return list;
//			
//		}
//}
