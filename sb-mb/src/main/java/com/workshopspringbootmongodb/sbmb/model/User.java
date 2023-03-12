package com.workshopspringbootmongodb.sbmb.model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "TBG_USER")
public class User implements Serializable {

    private static long serialversionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
}
