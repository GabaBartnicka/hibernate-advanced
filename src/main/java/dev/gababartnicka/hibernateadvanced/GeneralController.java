package dev.gababartnicka.hibernateadvanced;

import dev.gababartnicka.hibernateadvanced.domain.University;
import dev.gababartnicka.hibernateadvanced.repos.UniversityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@Log4j2
public class GeneralController {

    private final UniversityRepository universityRepository;

    @GetMapping(path = "/")
    public Set<University> showUniversities() {
        final Iterable<University> all = universityRepository.findAll();
        Set<University> universities = new HashSet<>();
        for (University university : all) {
            universities.add(university);
        }
        return universities;
    }
}