package ru.semenov.jsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.semenov.entities.Order;
import ru.semenov.entities.OrderRecord;
import ru.semenov.entities.Product;
import ru.semenov.entities.User;
import ru.semenov.repositories.UserRepository;
import ru.semenov.services.OrderService;
import ru.semenov.services.ProductService;
import ru.semenov.services.UserService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class OrderBean implements Serializable {

    private Logger logger = LoggerFactory.getLogger(OrderBean.class);


    @EJB
    private OrderService orderService;

    public OrderBean() {
    }

    public void addProduct(Product product) {
        orderService.addProduct(product);
    }
}
