package com.first_spring.web.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "user_address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Integer addressId;
    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String note;
    @Column(name = "user_id")
    private Integer userId;

    @JsonBackReference("user-address")
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private UserEntity userEntity;

}
