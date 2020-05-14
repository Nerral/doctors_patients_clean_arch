package ru.sberbank.examples.clean.architecture.example.core.domain.entity;

import lombok.Getter;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.FullName;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.Gender;
import ru.sberbank.examples.clean.architecture.example.core.domain.exception.AcceptPatientException;

import java.util.Date;
import java.util.Set;

import static ru.sberbank.examples.clean.architecture.example.core.domain.entity.Doctor.Type.ADULT;
import static ru.sberbank.examples.clean.architecture.example.core.domain.entity.Doctor.Type.ANY;
import static ru.sberbank.examples.clean.architecture.example.core.domain.entity.Doctor.Type.CHILD;

public class Doctor {

    @Getter
    private FullName fullName;
    private TimeTable timeTable;
    private Type type;
    private Gender acceptGender;

    private Doctor(FullName fullName, TimeTable timeTable, Type type, Gender gender) {
        this.fullName = fullName;
        this.timeTable = timeTable;
        this.type = type;
        this.acceptGender = gender;
    }

    public static Doctor of(FullName fullName, TimeTable timeTable, Type type, Gender gender) {

        if(fullName == null) {
            throw new IllegalArgumentException("fullName is absent");
        }

        if(timeTable == null) {
            throw new IllegalArgumentException("timeTable is absent");
        }

        if(type == null) {
            type = ANY;
        }

        return new Doctor(fullName, timeTable, type, gender);
    }

    public static Doctor of(FullName fullName, TimeTable timeTable) {
        return of(fullName, timeTable, ANY, null);
    }

    public void acceptPatient(Patient patient, Date acceptDate) throws AcceptPatientException {
        if(patient == null || acceptDate == null) {
            throw new AcceptPatientException("No patient and(or) acceptDate");
        }

        throwIfCantAcceptPatientsOnDate(acceptDate);
        throwIfCantAcceptPatient(patient);
        reserveDate(acceptDate);
    }

    private void reserveDate(Date date) {
        timeTable.reserveDate(date);
    }

    private void throwIfCantAcceptPatient(Patient patient) {
        if(patient.getAge().isAdult() && !canAcceptByAge(ADULT)) {
            throw new AcceptPatientException("Doctor can't accept adults");
        }

        if(patient.getAge().isChild() && !canAcceptByAge(CHILD)) {
            throw new AcceptPatientException("Doctor can't accept children");
        }

        if (!canAcceptByGender(patient.getGender())) {
            throw new AcceptPatientException("Doctor can't accept people with this gender");
        }
    }

    private boolean canAcceptByAge(Type type) {
        return this.type == ANY || this.type == type;
    }

    private boolean canAcceptByGender(Gender gender) {
        if (this.acceptGender == null) {
            return true;
        }

        return acceptGender == gender;
    }

    private void throwIfCantAcceptPatientsOnDate(Date date) {
        if(!timeTable.isFreeOnDate(date)) {
            throw new AcceptPatientException("Couldn't accept patient on date");
        }
    }

    public static class TimeTable {
        private Set<Date> freeDates;

        public TimeTable(Set<Date> freeDates) {
            this.freeDates = freeDates;
        }

        private boolean isFreeOnDate(Date date) {
            return freeDates.contains(date);
        }

        private void reserveDate(Date date) {
            freeDates.remove(date);
        }
    }

    public enum Type {
        ADULT,
        CHILD,
        ANY
    }
}
