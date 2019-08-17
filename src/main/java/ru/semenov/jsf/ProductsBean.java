package ru.semenov.jsf;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.semenov.entities.Product;
import ru.semenov.repositories.ProductRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class ProductsBean implements Serializable {

    private Logger logger = LoggerFactory.getLogger(ProductsBean.class);

    @Inject
    private ProductRepository productRepository;

    public List<Product> getAll() {
        logger.info("Get all products:" + productRepository.getAll().size());
        return productRepository.getAll();
    }

}
