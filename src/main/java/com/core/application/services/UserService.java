package com.core.application.services;

import com.core.domain.entities.User;
import com.core.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getList() {
        Iterable<User> users = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        users.forEach(userList::add);
        return userList;
    }

    public User getById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public void add(String name, String email) throws IllegalAccessException {
        if(name == null || name.length() == 0) {
            throw new IllegalAccessException("The name cannot be null.");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);

        userRepository.save(user);
    }

    public void update(int id, String name, String email)
            throws IllegalAccessException {
        Optional<User> userToBeUpdated = userRepository.findById(id);

        if(userToBeUpdated.isEmpty()) {
            return;
        }

        userToBeUpdated.get().setName(name);
        userToBeUpdated.get().setEmail(email);
        userRepository.save(userToBeUpdated.get());
    }

    public void delete(int id) {
        Optional<User> userToBeUpdated = userRepository.findById(id);

        if(userToBeUpdated.isEmpty()) {
            return;
        }

        userRepository.delete(userToBeUpdated.get());
    }
}

