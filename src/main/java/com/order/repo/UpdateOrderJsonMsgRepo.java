package com.order.repo;

import com.order.entityUpdateOrder.json.UpdateOrderMsgJsonEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdateOrderJsonMsgRepo extends JpaRepository<UpdateOrderMsgJsonEntity, Integer> {
}