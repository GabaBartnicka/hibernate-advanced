package dev.gababartnicka.hibernateadvanced;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Endpoint(id = "custom")
@RequiredArgsConstructor
public class CustomActuatorEndpoint {

    // http://localhost:8080/actuator/custom
    @ReadOperation
    public Map<String, String> get() {
        return Map.of("gaba", "test");
    }

}
