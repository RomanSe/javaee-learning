package ru.semenov.repositories;

import ru.semenov.entities.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductRepository {

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

    public void update(Product product) {
        if (products.containsKey(product.getId())) {
            products.put(product.getId(), product);
        }
    }
}
