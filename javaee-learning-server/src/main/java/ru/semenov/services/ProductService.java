package ru.semenov.services;

import ru.semenov.entities.Product;
import ru.semenov.repositories.ProductRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class ProductService {

    @EJB
    ProductRepository productRepository;

    @Transactional
    public void insert(Product product) {
        productRepository.insert(product);
    }

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Transactional
    public void merge(Product product) {
        productRepository.merge(product);
    }

    @Transactional
    public void delete(Product entity) {
        productRepository.delete(entity);
    }

    public List<Product> findByName(String namePart) {
        return productRepository.findByName(namePart);
    }

    public List<Product> findByPrice(Integer from, Integer to) {
        return productRepository.findByPrice(from, to);
    }
}
