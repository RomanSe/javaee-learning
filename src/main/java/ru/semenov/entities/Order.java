package ru.semenov.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private String buyer;
    private String address;
    private Date orderDate;
    private List<OrderRecord> orderRecords;
    private OrderStatus status;

    public Order() {
        orderRecords = new ArrayList<>();
    }

    public Order(int id, String buyer, String address, Date orderDate, List<OrderRecord> orderRecords, OrderStatus status) {
        this.id = id;
        this.buyer = buyer;
        this.address = address;
        this.orderDate = orderDate;
        this.orderRecords = orderRecords;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderRecord> getOrderRecords() {
        return orderRecords;
    }

    public void setOrderRecords(List<OrderRecord> orderRecords) {
        this.orderRecords = orderRecords;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
