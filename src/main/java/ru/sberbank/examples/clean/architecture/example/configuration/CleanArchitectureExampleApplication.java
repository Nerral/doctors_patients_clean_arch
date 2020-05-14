package ru.sberbank.examples.clean.architecture.example.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.sberbank.examples.clean.architecture.example.infrastructure.InfrastructureConfiguration;
import ru.sberbank.examples.clean.architecture.example.core.CoreConfiguration;

@SpringBootApplication
@Import({
        InfrastructureConfiguration.class,
        CoreConfiguration.class
})
public class CleanArchitectureExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(CleanArchitectureExampleApplication.class, args);
    }
}
