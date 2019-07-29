package com.gab.hibernateadvanced.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dean")
    private String dean;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Lecturer> lecturers;
}
