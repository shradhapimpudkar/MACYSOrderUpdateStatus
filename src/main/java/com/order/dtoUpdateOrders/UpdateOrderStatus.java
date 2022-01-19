package com.order.dtoUpdateOrders;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UpdateOrderStatus implements Serializable {

    @JsonProperty("id")
    private int id;

    @JsonProperty("status")
    private String status;

    public UpdateOrderStatus() {
    }

    public UpdateOrderStatus(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UpdateOrderStatus{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
