package com.berkayarslan.UserEngage.model;

import com.berkayarslan.UserEngage.general.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/*
* id, createdAt, createdBy, updatedAt, updatedBy
* @author berkayaslan
* */

@Entity
@Table(name = "user_table")
@Data
public class User extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME",nullable = false,length = 100)
    private String name;

    @Column(name = "SURNAME",nullable = false,length = 100)
    private String surname;

    @Column(name = "CREATE_DATE",nullable = false)
    private LocalDateTime createDate;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER",length = 30)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS",nullable = false,length = 30)
    private Status status;


    @PrePersist
    protected void onCreate() {
        createDate = LocalDateTime.now();
    }
}
