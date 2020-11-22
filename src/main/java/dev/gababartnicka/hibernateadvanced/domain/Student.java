package dev.gababartnicka.hibernateadvanced.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    @ElementCollection
    @CollectionTable(name = "file")
    @MapKeyColumn(name = "file_name")
    @Column(name = "notes_name")
    private Map<String, String> notes = new HashMap<>();

    // TODO: attributes override
}
