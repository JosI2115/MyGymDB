package com.example.mygymdb.services;

import com.example.mygymdb.entity.User;

public interface UserService {
    User createUser(User user);
    User findByEmailAndPassword(String email, String password);
}
