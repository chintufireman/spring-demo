package learning.microservice.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import learning.microservice.basedomains.dto.Order;
import learning.microservice.basedomains.dto.OrderEvent;
import learning.microservice.kafka.OrderProducer;

@RestController
public class OrderController {

	private OrderProducer orderProducer;

	public OrderController(OrderProducer orderProducer) {
		super();
		this.orderProducer = orderProducer;
	}
	
	@PostMapping("/orders")
	public String placeOrder(@RequestBody Order order) {
		order.setOrderId(UUID.randomUUID().toString());
		OrderEvent orderEvent = new OrderEvent();
		orderEvent.setStatus("PENDING");
		orderEvent.setMessage("order status is in pending status");
		orderEvent.setOrder(order);
		orderProducer.sendMessage(orderEvent);
		
		return "Order Placed successfully";
	}
}
