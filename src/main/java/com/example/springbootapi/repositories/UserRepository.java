package com.example.springbootapi.repositories;

import com.example.springbootapi.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends CrudRepository<User, Integer> {
}
