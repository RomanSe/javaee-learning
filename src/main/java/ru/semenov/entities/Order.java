package ru.semenov.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue
    private int id;
    private String buyer;
    private String address;
    private Date orderDate;
    @OneToMany(fetch = FetchType.EAGER)
    private List<OrderRecord> orderRecords;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Order() {
        orderRecords = new ArrayList<>();
    }

    public Order(String buyer, String address, Date orderDate, List<OrderRecord> orderRecords, OrderStatus status, User user) {
        this.buyer = buyer;
        this.address = address;
        this.orderDate = orderDate;
        this.orderRecords = orderRecords;
        this.status = status;
        this.user = user;
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
