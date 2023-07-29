package com.web.springbootapi.models;

public class CreateUserModel {
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) throws IllegalAccessException {
        if(name == null || name.length() == 0) {
            throw new IllegalAccessException("The name cannot be null.");
        }

        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
