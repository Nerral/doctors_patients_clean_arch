package ru.sberbank.examples.clean.architecture.example.infrastructure.mail.entity;

import ru.sberbank.examples.clean.architecture.example.infrastructure.mail.GetAcceptPatientsMail;

import java.util.Date;

public class AcceptPatientMailEntity implements GetAcceptPatientsMail.AcceptPatientMail {
    @Override
    public String patientFirstName() {
        return null;
    }

    @Override
    public String patientLastName() {
        return null;
    }

    @Override
    public String patientMiddleName() {
        return null;
    }

    @Override
    public int patientAge() {
        return 0;
    }

    @Override
    public Date acceptDate() {
        return null;
    }

    @Override
    public long doctorId() {
        return 0;
    }
}
