package ru.semenov.repositories;

import ru.semenov.entities.Role;
import ru.semenov.entities.User;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Stateless
public class RoleRepository {

    @PersistenceContext(name = "ds")
    protected EntityManager em;

    @PostConstruct
    public void init() {
        if (getAll().size() == 0) {
            em.merge(new Role("ADMIN"));
            em.merge(new Role("USER"));
        }
    }

    public Role findById(int id) {
        return em.find(Role.class, id);
    }

    public Role findByName(String name) {
        Query q = em.createQuery("select t from Role t where t.name = :name");
        q.setParameter("name", name);
        List<Role> roles = q.getResultList();
        if (roles.size() > 0)
            return roles.get(0);
        return null;
    }


    public List<Role> getAll() {
        Query q = em.createQuery("select t from Role t");
        return q.getResultList();
    }

    @Transactional
    public void merge(Role role) {
        em.merge(role);
    }

    @Transactional
    public void insert(Role role) {
        em.merge(role);
    }
}
