package com.example.springclass.service;

import com.example.springclass.domain.Users;
import com.example.springclass.repository.PermissionRepository;
import com.example.springclass.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UsersRepository usersRepo;
    private final PermissionRepository permissionRepo;


    @Override
    public List<Users> search(String permission) {
        if (permission != null && !permission.equals("")) {
            return usersRepo.findByPermissions(permissionRepo.findByName(permission));
        } else {
            return usersRepo.findAll();
        }
    }

    @Override
    public Users create(Users users) {
        return usersRepo.save(users);
    }
}
