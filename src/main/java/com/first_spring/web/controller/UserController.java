package com.first_spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.first_spring.web.dao.UserDao;
import com.first_spring.web.entity.UserEntity;

@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/users")
    public List<UserEntity> getAllUsers() {
        return this.userDao.getAllUsers();
    }

    @GetMapping(value = "/users", params = "isActive")
    public List<UserEntity> getAllUsersByIsActive(@RequestParam("isActive") Integer isActive) {
        return this.userDao.getAllUsersByIsActive(isActive);
    }
}
