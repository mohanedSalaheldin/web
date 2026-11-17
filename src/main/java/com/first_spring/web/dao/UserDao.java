package com.first_spring.web.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first_spring.web.entity.UserEntity;
import com.first_spring.web.repository.UserRepository;

@Service
public class UserDao {
    @Autowired
    private UserRepository repo;

    public List<UserEntity> getAllUsers() {
        return this.repo.findAll();
    }

    public List<UserEntity> getAllUsersByIsActive(Integer isActive) {
        return this.repo.findAllByIsActive(isActive);
    }
}
