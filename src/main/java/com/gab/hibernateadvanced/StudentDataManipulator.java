package com.gab.hibernateadvanced;

import com.gab.hibernateadvanced.domain.Student;
import com.gab.hibernateadvanced.repos.StudentRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Log4j2
public class StudentDataManipulator {

    private final StudentRepo studentRepo;

    @PostConstruct
    public void doManipulate() {
        log.info("Saving student");

        var student = new Student();
        student.setFirstName("Gaba");
        student.setLastName("B.");
        student.setEmail("gab@g.pl");

        Set<String> images = new HashSet<>();
        images.add("photo1.jpg");
        images.add("photo2.jpg");
        images.add("photo3.jpg");

        student.setImages(images);

        studentRepo.save(student);


    }
}
