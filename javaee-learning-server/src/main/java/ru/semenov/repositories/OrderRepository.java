package ru.semenov.repositories;

import ru.semenov.entities.Order;
import ru.semenov.entities.OrderRecord;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Stateless
public class OrderRepository implements Serializable {

    @PersistenceContext(name = "ds")
    protected EntityManager em;

    public OrderRepository() {
    }

    @Transactional
    public void insert(Order order) {
        em.merge(order);
    }

    public List<Order> getAll() {
        Query q = em.createQuery("select t from Order t left join fetch t.orderRecords", Order.class);
        return q.getResultList();
    }

    public Order findById(int id) {
        return em.find(Order.class, id);
    }

    @Transactional

    public void merge(Order order) {
        for (OrderRecord orderRecord: order.getOrderRecords()) {
            em.merge(orderRecord);
        }
        em.merge(order);
    }

    @Transactional
    public void delete(Order entity) {
        em.remove(findById(entity.getId()));
    }

}
