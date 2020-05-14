package ru.sberbank.examples.clean.architecture.example.infrastructure;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.sberbank.examples.clean.architecture.example.infrastructure.jms.JmsConfiguration;
import ru.sberbank.examples.clean.architecture.example.infrastructure.mail.MailConfiguration;
import ru.sberbank.examples.clean.architecture.example.infrastructure.persistence.PersistenceConfiguration;
import ru.sberbank.examples.clean.architecture.example.infrastructure.schedule.ScheduleConfiguration;
import ru.sberbank.examples.clean.architecture.example.infrastructure.web.WebConfiguration;

@Configuration
@Import({
        JmsConfiguration.class,
        PersistenceConfiguration.class,
        ScheduleConfiguration.class,
        WebConfiguration.class,
        MailConfiguration.class
})
public class InfrastructureConfiguration {
}
