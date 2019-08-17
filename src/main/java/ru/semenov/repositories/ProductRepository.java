package ru.semenov.repositories;

import ru.semenov.entities.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Singleton;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@ApplicationScoped
@Named
public class ProductRepository implements Serializable {

    private HashMap<Integer, Product> products = new HashMap<>();

    public void insert(Product product) {
        products.put(product.getId(), product);
    }

    public List<Product> getAll() {
        return new ArrayList(products.values());
    }

    public Product findById(int id) {
        if (products.containsKey(id))
            return products.get(id);
        return null;
    }

    public ProductRepository() {
    }

    public void update(Product product) {
        if (products.containsKey(product.getId())) {
            products.put(product.getId(), product);
        }
    }
}
