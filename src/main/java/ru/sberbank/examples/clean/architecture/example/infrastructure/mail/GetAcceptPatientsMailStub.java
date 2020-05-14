package ru.sberbank.examples.clean.architecture.example.infrastructure.mail;

import org.springframework.stereotype.Component;
import ru.sberbank.examples.clean.architecture.example.infrastructure.mail.entity.AcceptPatientMailEntity;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component
class GetAcceptPatientsMailStub implements GetAcceptPatientsMail {
    @Override
    public List<AcceptPatientMail> getMails(Date fromDate) {
        //todo stub
        return Collections.singletonList(new AcceptPatientMailEntity());
    }
}
