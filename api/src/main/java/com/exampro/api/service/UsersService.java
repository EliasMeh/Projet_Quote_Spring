package com.exampro.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampro.api.entity.Users;
import com.exampro.api.repository.UsersRepository;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users getUserById(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }
}
