package com.exampro.api.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.exampro.api.entity.Users;
import com.exampro.api.service.UsersService;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    private UsersService usersService;

    @Override
    public void run(String... args) throws Exception {
            usersService.createUser(new Users(null, "Marie"));

    }
}
