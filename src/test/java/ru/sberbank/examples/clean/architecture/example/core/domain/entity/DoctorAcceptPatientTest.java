package ru.sberbank.examples.clean.architecture.example.core.domain.entity;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.Age;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.FullName;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.Gender;
import ru.sberbank.examples.clean.architecture.example.core.domain.exception.AcceptPatientException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DoctorAcceptPatientTest {

    @Test
    void test_doctor_any_age_any_gender_on_free_date_1() {
        Set<Date> timeTableSet = new HashSet<>();
        timeTableSet.add(dateFrom("01.01.2000"));
        timeTableSet.add(dateFrom("02.01.2000"));
        timeTableSet.add(dateFrom("03.01.2000"));
        timeTableSet.add(dateFrom("10.01.2000"));
        Doctor.TimeTable timeTable = new Doctor.TimeTable(timeTableSet);
        Doctor doctor = Doctor.of(FullName.of("Зинаида", "Волкова", "Николаевна"), timeTable);
        Patient patient = Patient.builder()
                .age(Age.of(20))
                .gender(Gender.MALE)
                .build();
        doctor.acceptPatient(patient, dateFrom("03.01.2000"));
    }

    @Test
    void test_doctor_any_age_any_gender_on_free_date_2() {
        Set<Date> timeTableSet = new HashSet<>();
        timeTableSet.add(dateFrom("01.01.2000"));
        timeTableSet.add(dateFrom("02.01.2000"));
        timeTableSet.add(dateFrom("03.01.2000"));
        timeTableSet.add(dateFrom("10.01.2000"));
        Doctor.TimeTable timeTable = new Doctor.TimeTable(timeTableSet);
        Doctor doctor = Doctor.of(FullName.of("Зинаида", "Волкова", "Николаевна"), timeTable);
        Patient patient = Patient.builder()
                .age(Age.of(20))
                .gender(Gender.FEMALE)
                .build();
        doctor.acceptPatient(patient, dateFrom("03.01.2000"));
    }

    @Test
    void test_doctor_any_age_any_gender_on_free_date_3() {
        Set<Date> timeTableSet = new HashSet<>();
        timeTableSet.add(dateFrom("01.01.2000"));
        timeTableSet.add(dateFrom("02.01.2000"));
        timeTableSet.add(dateFrom("03.01.2000"));
        timeTableSet.add(dateFrom("10.01.2000"));
        Doctor.TimeTable timeTable = new Doctor.TimeTable(timeTableSet);
        Doctor doctor = Doctor.of(FullName.of("Зинаида", "Волкова", "Николаевна"), timeTable);
        Patient patient = Patient.builder()
                .age(Age.of(5))
                .gender(Gender.MALE)
                .build();
        doctor.acceptPatient(patient, dateFrom("03.01.2000"));
    }

    @Test
    void test_doctor_any_age_any_gender_on_free_date_4() {
        Set<Date> timeTableSet = new HashSet<>();
        timeTableSet.add(dateFrom("01.01.2000"));
        timeTableSet.add(dateFrom("02.01.2000"));
        timeTableSet.add(dateFrom("03.01.2000"));
        timeTableSet.add(dateFrom("10.01.2000"));
        Doctor.TimeTable timeTable = new Doctor.TimeTable(timeTableSet);
        Doctor doctor = Doctor.of(FullName.of("Зинаида", "Волкова", "Николаевна"), timeTable);
        Patient patient = Patient.builder()
                .age(Age.of(5))
                .gender(Gender.FEMALE)
                .build();
        doctor.acceptPatient(patient, dateFrom("03.01.2000"));
    }

    @Test
    void test_doctor_adults_any_gender_on_free_date_adult_1() {
        Set<Date> timeTableSet = new HashSet<>();
        timeTableSet.add(dateFrom("01.01.2000"));
        timeTableSet.add(dateFrom("02.01.2000"));
        timeTableSet.add(dateFrom("03.01.2000"));
        timeTableSet.add(dateFrom("10.01.2000"));
        Doctor.TimeTable timeTable = new Doctor.TimeTable(timeTableSet);
        Doctor doctor = Doctor.of(FullName.of("Зинаида", "Волкова", "Николаевна"), timeTable, Doctor.Type.ADULT, null);
        Patient patient = Patient.builder()
                .age(Age.of(19))
                .gender(Gender.MALE)
                .build();
        doctor.acceptPatient(patient, dateFrom("03.01.2000"));
    }

    @Test
    void test_doctor_adults_any_gender_on_free_date_adult_2() {
        Set<Date> timeTableSet = new HashSet<>();
        timeTableSet.add(dateFrom("01.01.2000"));
        timeTableSet.add(dateFrom("02.01.2000"));
        timeTableSet.add(dateFrom("03.01.2000"));
        timeTableSet.add(dateFrom("10.01.2000"));
        Doctor.TimeTable timeTable = new Doctor.TimeTable(timeTableSet);
        Doctor doctor = Doctor.of(FullName.of("Зинаида", "Волкова", "Николаевна"), timeTable, Doctor.Type.ADULT, null);
        Patient patient = Patient.builder()
                .age(Age.of(19))
                .gender(Gender.FEMALE)
                .build();
        doctor.acceptPatient(patient, dateFrom("03.01.2000"));
    }

    @Test
    void test_doctor_adults_any_gender_on_free_date_child_1() {
        Set<Date> timeTableSet = new HashSet<>();
        timeTableSet.add(dateFrom("01.01.2000"));
        timeTableSet.add(dateFrom("02.01.2000"));
        timeTableSet.add(dateFrom("03.01.2000"));
        timeTableSet.add(dateFrom("10.01.2000"));
        Doctor.TimeTable timeTable = new Doctor.TimeTable(timeTableSet);
        Doctor doctor = Doctor.of(FullName.of("Зинаида", "Волкова", "Николаевна"), timeTable, Doctor.Type.ADULT, null);
        Patient patient = Patient.builder()
                .age(Age.of(5))
                .gender(Gender.MALE)
                .build();
        assertThrows(AcceptPatientException.class, () -> {
            doctor.acceptPatient(patient, dateFrom("03.01.2000"));
        });
    }

    @Test
    void test_doctor_adults_any_gender_on_free_date_child_2() {
        Set<Date> timeTableSet = new HashSet<>();
        timeTableSet.add(dateFrom("01.01.2000"));
        timeTableSet.add(dateFrom("02.01.2000"));
        timeTableSet.add(dateFrom("03.01.2000"));
        timeTableSet.add(dateFrom("10.01.2000"));
        Doctor.TimeTable timeTable = new Doctor.TimeTable(timeTableSet);
        Doctor doctor = Doctor.of(FullName.of("Зинаида", "Волкова", "Николаевна"), timeTable, Doctor.Type.ADULT, null);
        Patient patient = Patient.builder()
                .age(Age.of(5))
                .gender(Gender.FEMALE)
                .build();
        assertThrows(AcceptPatientException.class, () -> {
            doctor.acceptPatient(patient, dateFrom("03.01.2000"));
        });
    }

    @Test
    void test_doctor_any_age_any_gender_on_bad_date() {
        Set<Date> timeTableSet = new HashSet<>();
        timeTableSet.add(dateFrom("01.01.2000"));
        timeTableSet.add(dateFrom("02.01.2000"));
        timeTableSet.add(dateFrom("03.01.2000"));
        timeTableSet.add(dateFrom("10.01.2000"));
        Doctor.TimeTable timeTable = new Doctor.TimeTable(timeTableSet);
        Doctor doctor = Doctor.of(FullName.of("Зинаида", "Волкова", "Николаевна"), timeTable);
        Patient patient = Patient.builder()
                .age(Age.of(20))
                .gender(Gender.MALE)
                .build();
        assertThrows(AcceptPatientException.class, () -> {
            doctor.acceptPatient(patient, dateFrom("12.01.2000"));
        });
    }

    @Test
    void test_doctor_any_age_female_on_free_date_male() {
        Set<Date> timeTableSet = new HashSet<>();
        timeTableSet.add(dateFrom("01.01.2000"));
        timeTableSet.add(dateFrom("02.01.2000"));
        timeTableSet.add(dateFrom("03.01.2000"));
        timeTableSet.add(dateFrom("10.01.2000"));
        Doctor.TimeTable timeTable = new Doctor.TimeTable(timeTableSet);
    Doctor doctor = Doctor.of(FullName.of("Зинаида", "Волкова", "Николаевна"), timeTable, Doctor.Type.ANY, Gender.FEMALE);
        Patient patient = Patient.builder()
                .age(Age.of(20))
                .gender(Gender.MALE)
                .build();
        assertThrows(AcceptPatientException.class, () -> {
            doctor.acceptPatient(patient, dateFrom("01.01.2000"));
        });
    }

    @SneakyThrows
    public Date dateFrom(String s) {
        return new SimpleDateFormat("dd.MM.yyyy").parse(s);
    }
}