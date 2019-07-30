package com.gab.hibernateadvanced.repos;

import com.gab.hibernateadvanced.domain.University;
import org.springframework.data.repository.CrudRepository;

public interface UniversityRepository extends CrudRepository<University, Integer> {
}
