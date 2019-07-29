package com.gab.hibernateadvanced.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Embeddable
public class Department {

    @Column(name = "dean")
    private String dean;

    @ElementCollection
    @CollectionTable(
            name = "lecturer", // table name
            joinColumns = @JoinColumn(name = "lecturer_id")
    )
    private Set<Lecturer> lecturers;
}
