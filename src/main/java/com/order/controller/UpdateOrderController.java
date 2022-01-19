package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.order.dtoUpdateOrders.UpdateOrderStatus;
import com.order.service.UpdateOrderService;

@RestController
@RequestMapping("/updateOrder") 
public class UpdateOrderController {

	@Autowired
	UpdateOrderService updateOrderService;

	@PutMapping(value = "/statusUpdate", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String> updateOrder(@RequestBody UpdateOrderStatus updateOrderStatus) {
		return updateOrderService.updateOrder(updateOrderStatus);
	}
}
