package ru.semenov.repositories;

import ru.semenov.entities.Order;

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
        Query q = em.createQuery("select t from Order t");
        return q.getResultList();
    }

    public Order findById(int id) {
        return em.find(Order.class, id);
    }

    @Transactional
    public void merge(Order Order) {
        em.merge(Order);
    }

    @Transactional
    public void delete(Order entity) {
        em.remove(findById(entity.getId()));
    }

}
