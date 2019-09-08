package ru.semenov.services;

import ru.semenov.entities.Product;
import ru.semenov.entities.User;
import ru.semenov.repositories.UserRepository;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class UserService {

    @EJB
    UserRepository userRepository;

    public UserService() {
    }

    @Transactional
    public void insert(User user) {
        userRepository.insert(user);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User findById(int id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void merge(User user) {
        userRepository.merge(user);
    }

    @Transactional
    public void delete(User entity) {
        userRepository.delete(entity);
    }

    public List<Product> findByName(String namePart) {
        return userRepository.findByName(namePart);
    }
}
