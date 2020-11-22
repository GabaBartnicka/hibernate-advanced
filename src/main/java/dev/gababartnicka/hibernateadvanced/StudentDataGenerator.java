package dev.gababartnicka.hibernateadvanced;

import com.devskiller.jfairy.Fairy;
import dev.gababartnicka.hibernateadvanced.domain.Address;
import dev.gababartnicka.hibernateadvanced.domain.Status;
import dev.gababartnicka.hibernateadvanced.domain.Student;
import dev.gababartnicka.hibernateadvanced.repos.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
@Service
@Log4j2
public class StudentDataGenerator {

    private final StudentRepository studentRepo;
    private final Fairy fairy = Fairy.create();

    @PostConstruct
    public void generate() {
        log.info("Saving student");
        final var person = fairy.person();

        var student = new Student();
        student.setFirstName(person.getFirstName());
        student.setLastName(person.getLastName());
        student.setEmail(person.getEmail());

        Set<String> images = new HashSet<>();
        images.add("photo1.jpg");
        images.add("photo2.jpg");
        images.add("photo3.jpg");

        student.setImages(images);
        student.setStatus(Status.ACTIVE);

        final var address = person.getAddress();
        student.setHomeAddress(new Address(address.getStreet(), address.getCity(), address.getPostalCode()));

        Map<String, String> map = new HashMap<>(3);
        map.put("math.txt", "content of math file");
        map.put("algo.pdf", "notes for algorithm");
        map.put("scr.png", "Exam screenshot");
        student.setNotes(map);

        studentRepo.save(student);
    }
}
