package ru.semenov.services;

import ru.semenov.entities.Role;
import ru.semenov.repositories.RoleRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class RoleService {

    @EJB
    private RoleRepository roleRepository;

    public Role findById(int id) {
        return roleRepository.findById(id);
    }

    @Transactional
    public void merge(Role role) {
        roleRepository.merge(role);
    }

    @Transactional
    public void insert(Role role) {
        roleRepository.insert(role);

   }


    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    public List<Role> getAll() {
        return roleRepository.getAll();
    }
}
