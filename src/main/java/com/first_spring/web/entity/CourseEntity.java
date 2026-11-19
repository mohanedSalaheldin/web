package com.first_spring.web.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "name")
    private String name;

    @JsonManagedReference("course_users")
    @OneToMany(mappedBy = "courseEntity")
    private List<UserCoursesEntity> userCoursesEntities;
}
