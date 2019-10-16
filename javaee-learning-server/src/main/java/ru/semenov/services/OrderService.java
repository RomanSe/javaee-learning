package ru.semenov.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.semenov.entities.Order;
import ru.semenov.entities.OrderRecord;
import ru.semenov.entities.Product;
import ru.semenov.entities.User;
import ru.semenov.repositories.OrderRepository;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Stateful
public class OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderService.class);
    private User user;
    private Order order;

    @EJB
    private OrderRepository orderRepository;

    @EJB
    private UserService userService;

    public OrderService() {
    }

    @PostConstruct
    public void init() {
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
        orderRepository.merge(order);
        logger.info(order.getOrderRecords().stream().map(OrderRecord::toString).collect(Collectors.joining(" ")));
    }
}
