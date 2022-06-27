package com.example.springclass.repository;

import com.example.springclass.domain.Permission;
import com.example.springclass.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users,Integer> {
    List<Users> findByPermissions(Permission permission);
}
