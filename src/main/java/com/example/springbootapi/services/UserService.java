package com.example.springbootapi.services;

import com.example.springbootapi.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users;

    public UserService() {
        users = new ArrayList<>();

        User user1 = new User(1, "Tanvir");
        User user2 = new User(2, "Raeed");

        users.add(user1);
        users.add(user2);
    }

    public List<User> getList() {
        return users;
    }

    public User getById(int id) {
        for (User user: users) {
            if(user.getId() == id) {
                return user;
            }
        }

        return null;
    }

    public void Add(User user) throws IllegalAccessException {
        if(user == null) {
            throw new IllegalAccessException("The user cannot be null.");
        }

        users.add(user);
    }

    public void Update(int id, String name) throws IllegalAccessException {
        User userToBeUpdated = null;
        for (User user: users) {
            if(user.getId() == id) {
                userToBeUpdated = user;
            }
        }

        if(userToBeUpdated == null) {
            return;
        }

        userToBeUpdated.setName(name);
    }

    public void Delete(int id) {
        User userToBeDeleted = null;
        for (User user: users) {
            if(user.getId() == id) {
                userToBeDeleted = user;
            }
        }

        if(userToBeDeleted == null) {
            return;
        }

        users.remove(userToBeDeleted);
    }
}
