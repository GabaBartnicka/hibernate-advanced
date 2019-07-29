package com.gab.hibernateadvanced;

import com.gab.hibernateadvanced.domain.Department;
import com.gab.hibernateadvanced.domain.Lecturer;
import com.gab.hibernateadvanced.domain.University;
import com.gab.hibernateadvanced.repos.UniversityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

import static com.gab.hibernateadvanced.RandomStringGenerator.randomString;

@RequiredArgsConstructor
@Service
@Log4j2
public class DataGenerator {
    private final UniversityRepository universityRepository;

    @PostConstruct
    public void doGenerate() {

        log.info("Generating universities");
        final Set<University> universities = universities(3);
        log.info("Saving into db");
        universityRepository.saveAll(universities);
        log.info("Saved!");
    }

    public Set<University> universities(int number) {
        Set<University> universities = new HashSet<>(number);
        for (int i = 0; i < number; i++) {
            University university = new University();
            university.setName("University of " + randomString(4));
            university.setRector("PhD " + randomString(5));
            university.setDepartments(departments(5));

            universities.add(university);
        }

        return universities;
    }

    private Set<Department> departments(int number) {
        Set<Department> departments = new HashSet<>(number);

        for (int i = 0; i < number; i++) {
            Department department = new Department();
            department.setDean("DEAN-" + randomString(6));
            department.setLecturers(lecturers(6));
            departments.add(department);
        }

        return departments;
    }

    private Set<Lecturer> lecturers(int number) {
        Set<Lecturer> lecturers = new HashSet<>(number);

        for (int i = 0; i < number; i++) {
            Lecturer lecturer = new Lecturer();
            lecturer.setFirstName("Mrs. " + randomString(10));
            lecturer.setLastName(" von " + randomString(5));
            lecturer.setSpeciality("Science of " + randomString(10));
            lecturers.add(lecturer);
        }

        return lecturers;
    }

}
