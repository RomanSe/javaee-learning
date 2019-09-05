package ru.semenov.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.semenov.entities.Order;
import ru.semenov.entities.OrderRecord;
import ru.semenov.entities.Product;
import ru.semenov.entities.User;
import ru.semenov.repositories.OrderRepository;
import ru.semenov.repositories.ProductRepository;

import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.transaction.Transactional;
import java.util.List;

@Stateful
@DependsOn("UserService")
public class OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderService.class);
    private final User user;
    private Order order;

    @EJB
    OrderRepository orderRepository;

    @EJB
    private UserService userService;

    public OrderService() {
        logger.info("userService " + userService);
        user = userService.findById(0); //TODO потом исправить
        logger.info("User " + user);
        order = new Order(user);
    }

    @Transactional
    public void insert(Order order) {
        orderRepository.insert(order);
    }

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Order findById(int id) {
        return orderRepository.findById(id);
    }

    @Transactional
    public void merge(Order Order) {
        orderRepository.merge(Order);
    }

    @Transactional
    public void delete(Order entity) {
        orderRepository.delete(entity);
    }

    public void addProduct(Product product) {
        OrderRecord orderRecord = new OrderRecord(1, product.getPrice(), product);
        order.getOrderRecords().add(orderRecord);
    }
}
