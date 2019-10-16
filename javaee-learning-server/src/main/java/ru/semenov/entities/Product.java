package ru.semenov.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "Поле не должно быть пустым")
    private String name;

    private String description;

    private String image;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<OrderRecord> orderRecord;

    @NotNull(message = "Поле не должно быть пустым")
    @Min(value = 0, message = "Цена должна быть больше 0")
    private Integer price;


    public Product() {
    }

    public Product(String name, String description, String image, Integer price) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<OrderRecord> getOrderRecord() {
        return orderRecord;
    }

    public void setOrderRecord(Set<OrderRecord> orderRecord) {
        this.orderRecord = orderRecord;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                '}';
    }
}
