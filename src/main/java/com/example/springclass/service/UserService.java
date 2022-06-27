package com.example.springclass.service;

import com.example.springclass.domain.Users;

import java.util.List;

public interface UserService {
    List<Users> search(String permission);
    Users create(Users users);
}
