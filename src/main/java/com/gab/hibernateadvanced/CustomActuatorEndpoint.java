package com.gab.hibernateadvanced;

import com.gab.hibernateadvanced.repos.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Endpoint(id = "custom")
@RequiredArgsConstructor
public class CustomActuatorEndpoint {

    private final StudentRepo studentRepo;

    // http://localhost:8080/actuator/custom
    @ReadOperation
    public Map<String, String> get() {
        return Map.of("gaba", "test");
    }

}
