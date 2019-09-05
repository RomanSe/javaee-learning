package ru.semenov.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.semenov.entities.Product;
import ru.semenov.services.MethodLogger;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Stateless
public class ProductRepository implements Serializable {

    private Logger logger = LoggerFactory.getLogger(ProductRepository.class);

    @PersistenceContext(name = "ds")
    protected EntityManager em;

    public ProductRepository() {
    }

    @Transactional
    public void insert(Product product) {
        em.merge(product);
    }

    public List<Product> getAll() {
        Query q = em.createQuery("select t from Product t");
        return q.getResultList();
    }

    public Product findById(int id) {
        return em.find(Product.class, id);
    }

    @Transactional
    public void merge(Product product) {
        em.merge(product);
    }

    @Transactional
    @Interceptors({MethodLogger.class})
    public void delete(Product entity) {
        em.remove(findById(entity.getId()));
    }

    public List<Product> findByName(String namePart) {
        Query q = em.createQuery("select t from Product t where t.name like %?1%").setParameter(1, namePart);
        return q.getResultList();
    }

    public List<Product> findByPrice(Integer from, Integer to) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Product> query = cb.createQuery(Product.class);
        Root<Product> root = query.from(Product.class);
        Predicate condition = cb.gt(root.get("price"), from);
        Predicate condition2 = cb.lt(root.get("price"), to);
        Predicate and = cb.and(condition,condition2);
        query.select(root);
        query.where(and);
        return (em.createQuery(query).getResultList());
    }
}
