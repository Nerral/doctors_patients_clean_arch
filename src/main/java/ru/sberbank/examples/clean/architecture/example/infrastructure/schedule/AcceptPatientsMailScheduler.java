package ru.sberbank.examples.clean.architecture.example.infrastructure.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.sberbank.examples.clean.architecture.example.core.application.port.in.AcceptPatientUseCase;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.Age;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.FullName;
import ru.sberbank.examples.clean.architecture.example.infrastructure.mail.GetAcceptPatientsMail;

import java.util.Date;
import java.util.List;

@Component
class AcceptPatientsMailScheduler {
    private GetAcceptPatientsMail getAcceptPatientsMail;
    private AcceptPatientUseCase acceptPatientUseCase;

    @Autowired
    public AcceptPatientsMailScheduler(GetAcceptPatientsMail getAcceptPatientsMail,
                                       AcceptPatientUseCase acceptPatientUseCase) {
        this.getAcceptPatientsMail = getAcceptPatientsMail;
        this.acceptPatientUseCase = acceptPatientUseCase;
    }

    @Scheduled
    public void scheduleAcceptPatients() {
        List<GetAcceptPatientsMail.AcceptPatientMail> mails = getAcceptPatientsMail.getMails(dayBeforeToday());
        mails.forEach(m -> {
            FullName fullName = new FullName(m.patientFirstName(), m.patientLastName(), m.patientMiddleName());
            acceptPatientUseCase.acceptPatient(new AcceptPatientUseCase.Input(
                    fullName,
                    Age.of(m.patientAge()),
                    m.acceptDate(),
                    m.doctorId()
            ));
        });
    }

    private Date dayBeforeToday() {
        return null;
    }
}
