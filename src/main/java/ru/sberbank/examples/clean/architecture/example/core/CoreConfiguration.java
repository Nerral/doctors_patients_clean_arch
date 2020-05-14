package ru.sberbank.examples.clean.architecture.example.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.sberbank.examples.clean.architecture.example.core.application.ApplicationConfiguration;
import ru.sberbank.examples.clean.architecture.example.core.domain.DomainConfiguration;

@Configuration
@Import({
        ApplicationConfiguration.class,
        DomainConfiguration.class
})
public class CoreConfiguration {
}
