package com.gab.hibernateadvanced.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "University")
@Data
@NoArgsConstructor
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rector")
    private String rector;

    @Column(name = "name")
    private String name;

    @ElementCollection
    @CollectionTable(
            name = "department",
            joinColumns = @JoinColumn(name = "department_id")
    )
    private Set<Department> departments;
}
