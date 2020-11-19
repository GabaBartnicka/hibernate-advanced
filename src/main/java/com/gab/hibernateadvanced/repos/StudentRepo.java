package com.gab.hibernateadvanced.repos;

import com.gab.hibernateadvanced.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "students")
public interface StudentRepo extends JpaRepository<Student, Integer> {
}
