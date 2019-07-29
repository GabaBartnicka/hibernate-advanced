package com.gab.hibernateadvanced.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

//    @ElementCollection
//    @CollectionTable(
//            name = "lecturer", // table name
//            joinColumns = @JoinColumn(name = "lecturer_id")
//    )
//    private Set<Lecturer> lecturers;

//    @ManyToOne
//    @Cascade(value={org.hibernate.annotations.CascadeType.ALL})
//    @JoinColumn(name="university_id")
//    private University university;
}
