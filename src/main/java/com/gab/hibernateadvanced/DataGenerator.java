package com.gab.hibernateadvanced;

import com.gab.hibernateadvanced.domain.Department;
import com.gab.hibernateadvanced.domain.Lecturer;
import com.gab.hibernateadvanced.domain.University;
import com.gab.hibernateadvanced.repos.UniversityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.gab.hibernateadvanced.RandomStringGenerator.randomString;

@RequiredArgsConstructor
@Service
@Log4j2
public class DataGenerator {
    private static Integer DEPS = 5;
    private static Integer UNIVS = 2;
    private static Integer LECT = 6;

    private final UniversityRepository universityRepository;

    //    @PostConstruct
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
            university.setName("University of " + randomString(4));
            university.setRector("PhD " + randomString(5));
            university.setDepartments(departments());

            universities.add(university);
        }

        return universities;
    }

    private Set<Department> departments() {
        Set<Department> departments = new HashSet<>(DEPS);

        for (int i = 0; i < DEPS; i++) {
            Department department = new Department();
            department.setDean("DEAN-" + randomString(6));
            department.setLecturers(lecturers());
            departments.add(department);
        }

        return departments;
    }

    private Set<Lecturer> lecturers() {
        Set<Lecturer> lecturers = new HashSet<>(LECT);

        for (int i = 0; i < LECT; i++) {
            Lecturer lecturer = new Lecturer();
            lecturer.setFirstName("Mrs. " + randomString(10));
            lecturer.setLastName(" von " + randomString(5));
            lecturer.setSpeciality("Science of " + randomString(10));
            lecturers.add(lecturer);
        }

        return lecturers;
    }

}
