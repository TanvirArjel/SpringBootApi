package com.example.springbootapi.models;

public class User {
    private final int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalAccessException {
        if(name == null || name.length() == 0) {
            throw new IllegalAccessException("The name cannot be null.");
        }

        this.name = name;
    }
}
