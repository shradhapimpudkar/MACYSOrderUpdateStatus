package com.order.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.order.dtoUpdateOrders.OrderStatus;
import com.order.dtoUpdateOrders.UpdateOrderStatus;
import com.order.entityUpdateOrder.json.UpdateOrderMsgJsonEntity;
import com.order.entityUpdateOrder.xml.FulfillmentOrderEntity;
import com.order.repo.UpdateOrderJsonMsgRepo;
import com.order.repo.UpdateOrderXMLMsgRepo;

@Service
public class UpdateOrderServiceImpl implements UpdateOrderService {

	@Autowired
	UpdateOrderXMLMsgRepo updateOrderXMLMsgRepo;

	@Autowired
	UpdateOrderJsonMsgRepo updateOrderJsonMsgRepo;

	@Override
	public ResponseEntity<String> updateOrder(UpdateOrderStatus updateOrderStatus) {
		try {
			FulfillmentOrderEntity xmlUpdateOrderEntity = updateOrderXMLMsgRepo.getById(updateOrderStatus.getId());
			return updateXmlOrderStatus(xmlUpdateOrderEntity, updateOrderStatus);
		} catch (EntityNotFoundException e) {
			try {
				UpdateOrderMsgJsonEntity jsonUpdateOrderEntity = updateOrderJsonMsgRepo
						.getById(updateOrderStatus.getId());
				return updateJsonOrderStatus(jsonUpdateOrderEntity, updateOrderStatus);
			} catch (EntityNotFoundException e1) {
				e1.printStackTrace();
			}
		}
//		return new ResponseEntity<>("Status order updated successfully", HttpStatus.OK);
		return null;

	}

	private ResponseEntity<String> updateXmlOrderStatus(FulfillmentOrderEntity entity,
			UpdateOrderStatus updateOrderStatus) throws EntityNotFoundException {
		entity.setOrderStatus(OrderStatus.valueOf(updateOrderStatus.getStatus().toUpperCase()));
		updateOrderXMLMsgRepo.save(entity);
		return new ResponseEntity<>("Xml order updated successfully", HttpStatus.OK);
	}

	public ResponseEntity<String> updateJsonOrderStatus(UpdateOrderMsgJsonEntity jsonEntity,
			UpdateOrderStatus updateOrderStatus) throws EntityNotFoundException {
		jsonEntity.setOrderStatus(OrderStatus.valueOf(updateOrderStatus.getStatus().toUpperCase()));
		updateOrderJsonMsgRepo.save(jsonEntity);
		return new ResponseEntity<>("Json order updated successfully", HttpStatus.OK);
	}
}
