package com.gab.hibernateadvanced.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
@NoArgsConstructor
@Entity
@Table(name = "Lecturer")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "speciality")
    private String speciality;

}
