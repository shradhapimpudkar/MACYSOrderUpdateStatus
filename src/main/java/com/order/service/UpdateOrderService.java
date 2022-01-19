package com.order.service;

import org.springframework.http.ResponseEntity;
import com.order.dtoUpdateOrders.UpdateOrderStatus;

public interface UpdateOrderService {
	ResponseEntity<String> updateOrder(UpdateOrderStatus updateOrderStatusRequest);
//	ResponseEntity<String> updateOrder(int id,String status);

}
