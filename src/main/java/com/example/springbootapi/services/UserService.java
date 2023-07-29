package com.example.springbootapi.services;

import com.example.springbootapi.models.User;
import com.example.springbootapi.repositories.UserRepository;
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

    public void add(User user) throws IllegalAccessException {
        if(user == null) {
            throw new IllegalAccessException("The user cannot be null.");
        }

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
