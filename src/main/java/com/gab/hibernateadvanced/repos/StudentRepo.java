package com.gab.hibernateadvanced.repos;

import com.gab.hibernateadvanced.domain.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Integer> {
}
