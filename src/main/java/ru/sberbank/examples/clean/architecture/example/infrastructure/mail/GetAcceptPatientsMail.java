package ru.sberbank.examples.clean.architecture.example.infrastructure.mail;

import java.util.Date;
import java.util.List;

public interface GetAcceptPatientsMail {

    List<AcceptPatientMail> getMails(Date fromDate);

    interface AcceptPatientMail {
       String patientFirstName();
       String patientLastName();
       String patientMiddleName();
       int patientAge();
       Date acceptDate();
       long doctorId();
    }
}
