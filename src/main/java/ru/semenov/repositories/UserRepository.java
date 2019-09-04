package ru.semenov.repositories;

import ru.semenov.entities.Product;
import ru.semenov.entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class UserRepository {

    @PersistenceContext(name = "ds")
    protected EntityManager em;

    public UserRepository() {
    }

    @Transactional
    public void insert(User user) {
        em.merge(user);
    }

    public List<User> getAll() {
        Query q = em.createQuery("select t from User t");
        return q.getResultList();
    }

    public User findById(int id) {
        return em.find(User.class, id);
    }

    @Transactional
    public void merge(User user) {
        em.merge(user);
    }

    @Transactional
    public void delete(User entity) {
        em.remove(findById(entity.getId()));
    }

    public List<Product> findByName(String namePart) {
        Query q = em.createQuery("select t from User t where t.name like %?1%").setParameter(1, namePart);
        return q.getResultList();
    }
}
