package com.gab.hibernateadvanced;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.person.Person;
import com.gab.hibernateadvanced.domain.Department;
import com.gab.hibernateadvanced.domain.Lecturer;
import com.gab.hibernateadvanced.domain.University;
import com.gab.hibernateadvanced.repos.UniversityRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Log4j2
public class DataGenerator {
    private static final Integer DEPS = 5;
    private static final Integer UNIVS = 2;
    private static final Integer LECT = 6;

    private final UniversityRepository universityRepository;

    private final Faker faker = new Faker();
    private final com.github.javafaker.University universityFaker = faker.university();
    private final Fairy fairy = Fairy.create();

    @PostConstruct
    public void doGenerate() {

        log.info("Generating universities");
        final Set<University> universities = universities();
        log.info("Saving into db");
        universityRepository.saveAll(universities);
        log.info("Saved!");
    }

    public Set<University> universities() {
        Set<University> universities = new HashSet<>(UNIVS);
        for (int i = 0; i < UNIVS; i++) {
            University university = new University();
            university.setName(universityFaker.name());

            university.setRector(fairy.person().getFullName());
            university.setDepartments(departments());

            universities.add(university);
        }

        return universities;
    }

    private Set<Department> departments() {
        Set<Department> departments = new HashSet<>(DEPS);

        for (int i = 0; i < DEPS; i++) {
            Department department = new Department();
            department.setDean(fairy.person().getFullName());
            department.setLecturers(lecturers());
            departments.add(department);
        }

        return departments;
    }

    @NotNull
    private Set<Lecturer> lecturers() {
        Set<Lecturer> lecturers = new HashSet<>(LECT);

        for (int i = 0; i < LECT; i++) {
            Lecturer lecturer = new Lecturer();
            final Person person = fairy.person();
            lecturer.setFirstName(person.getFirstName());
            lecturer.setLastName(person.getLastName());
            lecturer.setSpeciality("Science of " + faker.harryPotter().spell());
            lecturers.add(lecturer);
        }

        return lecturers;
    }

}
