package com.first_spring.web.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 30, nullable = false)
    private String lastName;

    @Column(name = "username", length = 20, nullable = false)
    private String username;

    @Column(name = "password", length = 250, nullable = false)
    private String password;

    @Column(name = "is_active", nullable = false)
    private Integer isActive;

    @JsonManagedReference("user-address")
    @OneToOne(mappedBy = "userEntity")
    private AddressEntity addressEntity;

    @JsonManagedReference("user-notes")
    @OneToMany(mappedBy = "userEntity")
    private List<NoteEntity> notesEntity;

    @JsonManagedReference("user-courses")
    @OneToMany(mappedBy = "userEntity")
    private List<UserCoursesEntity> userCoursesEntities;
}