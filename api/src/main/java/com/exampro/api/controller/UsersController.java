package com.exampro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.exampro.api.entity.Users;
import com.exampro.api.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id) {
        return usersService.getUserById(id);
    }
    
    @GetMapping("/by-name/{username}")
    public Users getUserByName(@PathVariable String username) {
        return usersService.getUserByName(username);
    }

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        return usersService.createUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        usersService.deleteUser(id);
    }
}
