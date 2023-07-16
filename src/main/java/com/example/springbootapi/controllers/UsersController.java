package com.example.springbootapi.controllers;

import com.example.springbootapi.models.User;
import com.example.springbootapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users")
    public List<User> getList() {
        List<User> users = userService.getList();
        return users;
    }

    @GetMapping("users/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        User user = userService.getById(id);

        if(user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/users")
    public ResponseEntity<?> create(@RequestBody User user)
            throws Exception {
        userService.Add(user);
        URI createdLocation = new URI(String.format("http://localhost:8080/users/%s", user.getId()));
        return ResponseEntity.created(createdLocation).build();
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody User user)
            throws Exception {
        userService.Update(id, user.getName());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        userService.Delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
