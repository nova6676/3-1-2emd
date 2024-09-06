package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User findById(Long id);
    void save(User user);
    void update(User user);
    void deleteById(Long id);
    User findByUsername(String username);
}
