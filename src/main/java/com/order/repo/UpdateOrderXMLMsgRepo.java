package com.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entityUpdateOrder.xml.FulfillmentOrderEntity;

public interface UpdateOrderXMLMsgRepo extends JpaRepository<FulfillmentOrderEntity, Integer> {
}