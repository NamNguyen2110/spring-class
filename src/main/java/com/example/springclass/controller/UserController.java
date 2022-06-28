package com.example.springclass.controller;

import com.example.springclass.domain.Users;
import com.example.springclass.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Api(tags = "Users Rest Controller")
public class UserController {
    private final UserService userService;

    @GetMapping("")
    private ResponseEntity<?> search(
            @RequestHeader(value = "x-permission", required = false) String x_permission,
            @RequestParam(value = "permission", required = false) String permission) {
        return ResponseEntity
                .ok(
                        userService.search(
                                (x_permission != null && !permission.equals(""))
                                        ? x_permission :
                                        permission));
    }

    @PostMapping("")
    private ResponseEntity<?> create(@RequestBody Users users) {
        return ResponseEntity.ok(userService.create(users));
    }

    @GetMapping("/fake")
    private String fakeData(){
        return userService.fakeData();
    }
}
