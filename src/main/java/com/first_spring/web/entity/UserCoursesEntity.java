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
@Table(name = "user_courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCoursesEntity {
    @Transient
    private String courseName;
    @Transient
    private String userName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uc_id")
    private Integer ucId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "course_id")
    private Integer courseId;

    @JsonBackReference("user-courses")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private UserEntity userEntity;

    @JsonBackReference("course_users")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private CourseEntity courseEntity;

    public String getCourseName() {
        return this.courseEntity.getName();
    }

    public String getUserName() {
        return this.userEntity.getFirstName();
    }

}
