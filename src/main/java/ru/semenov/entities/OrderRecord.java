package ru.semenov.entities;

public class OrderRecord {
    private int id;
    private int count;
    private int totalCost;
    private Product product;

    public OrderRecord() {
    }

    public OrderRecord(int id, int count, int totalCost, Product product) {
        this.id = id;
        this.count = count;
        this.totalCost = totalCost;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
