package com.gab.hibernateadvanced.domain;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Student")
@NoArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ElementCollection // mapping a collection
    @CollectionTable(
            name = "image", // name of collection table
            joinColumns = @JoinColumn(name = "student_id") // join column
    )

    @Column(name = "file_name") // column name (in image table)
    private Set<String> images = new HashSet<>();


    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

//    @Embedded
    private Address homeAddress;

    // TODO: attributes override
}
