package com.example.springbootapi.controllers;

import com.example.springbootapi.models.User;
import com.example.springbootapi.services.UserService;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.responses.*;
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

    @Operation(summary = "Get the list of users.", description = "Returns a list of users.")
    @GetMapping("users")
    public List<User> getList() {
        List<User> users = userService.getList();
        return users;
    }

    @Operation(summary = "Get a user by id.", description = "Returns a user as per the id.")
    @GetMapping("users/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        User user = userService.getById(id);

        if(user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }

        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Create new user.", description = "Create a new user with the provided information.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Bad request - The provided values are not correct.")
    })
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
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        userService.Delete(id);
        return ResponseEntity.noContent().build();
    }
}
