package dev.gababartnicka.hibernateadvanced.repos;

import dev.gababartnicka.hibernateadvanced.domain.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "universities")
public interface UniversityRepository extends JpaRepository<University, Integer> {
}
