package com.example.springclass.service;

import com.example.springclass.domain.Permission;
import com.example.springclass.domain.Users;
import com.example.springclass.repository.PermissionRepository;
import com.example.springclass.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepo;
    private final PermissionRepository permissionRepo;


    @Override
    public List<Users> search(String permission) {
        return
                (permission != null && !permission.equals(""))
                        ? usersRepo.findByPermissions(permissionRepo.findByName(permission))
                        : usersRepo.findAll();
    }

    @Override
    public Users create(Users users) {
        return usersRepo.save(users);
    }

    @Override
    public String fakeData() {
        Set<Permission> permissions = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            Permission permission = Permission.builder()
                    .name("ROLE_" + UUID.randomUUID())
                    .build();
            permissionRepo.save(permission);
            permissions.add(permission);
        }
        for (int i = 0; i < 10; i++) {
            usersRepo.save(Users.builder()
                    .name("" + UUID.randomUUID())
                    .permissions(permissions)
                    .build());
        }
        return "Có dữ liệu rồi nè !!!";
    }
}
