package com.first_spring.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.first_spring.web.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    List<UserEntity> findAllByIsActive(Integer isActive);
}
