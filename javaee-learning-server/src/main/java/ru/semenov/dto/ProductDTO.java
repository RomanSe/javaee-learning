package ru.semenov.dto;

import ru.semenov.entities.Product;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Product")
public class ProductDTO {
    @XmlElement
    private int id;
    @XmlElement
    private String name;
    @XmlElement
    private String description;
    @XmlElement
    private String image;
    @XmlElement
    private Integer price;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        image = product.getImage();
        price = product.getPrice();
    }

    public Product getProduct() {
        Product product = new Product(name, description, image, price);
        if (id != 0) {
            product.setId(id);
        }
        return product;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                '}';
    }
}
