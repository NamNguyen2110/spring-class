package com.example.springclass.repository;

import com.example.springclass.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission,Integer> {
    Permission findByName(String name);
}
