package ru.sberbank.examples.clean.architecture.example.core.application.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.sberbank.examples.clean.architecture.example.core.application.port.in.AcceptPatientUseCase;
import ru.sberbank.examples.clean.architecture.example.core.application.port.out.DoctorRepository;
import ru.sberbank.examples.clean.architecture.example.core.application.port.out.FindPatient;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.Doctor;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.Patient;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.Age;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.FullName;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.Gender;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AcceptPatientServiceTest {

    @Mock
    private FindPatient findPatient;
    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private AcceptPatientUseCase acceptPatientUseCase = new AcceptPatientService(findPatient, doctorRepository);

    @Test
    void test_success_accept_patient_call_save_doctor() {

        AcceptPatientUseCase.Input input = new AcceptPatientUseCase.Input(new FullName("ex", "ex", "ex"),
                Age.of(19),
                dateFrom("01.01.2000"),
                1L);

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

        when(doctorRepository.findById(eq(1L))).thenReturn(doctor);
        when(findPatient.findByFullNameAndAge(any(FullName.class), any(Age.class))).thenReturn(patient);


        AcceptPatientUseCase.Result result = acceptPatientUseCase.acceptPatient(input);

        verify(doctorRepository, times(1)).findById(eq(1L));
        verify(doctorRepository, times(1)).save(any(Doctor.class));
        verify(findPatient, times(1)).findByFullNameAndAge(any(FullName.class), any(Age.class));
        verifyNoMoreInteractions(doctorRepository, findPatient);

        assertTrue(result.isSuccess());

    }

    @Test
    void test_fail_accept_patient_no_call_save_doctor() {

        AcceptPatientUseCase.Input input = new AcceptPatientUseCase.Input(new FullName("ex", "ex", "ex"),
                Age.of(19),
                dateFrom("12.01.2000"),
                1L);

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

        when(doctorRepository.findById(eq(1L))).thenReturn(doctor);
        when(findPatient.findByFullNameAndAge(any(FullName.class), any(Age.class))).thenReturn(patient);


        AcceptPatientUseCase.Result result = acceptPatientUseCase.acceptPatient(input);

        verify(doctorRepository, times(1)).findById(eq(1L));
        verify(findPatient, times(1)).findByFullNameAndAge(any(FullName.class), any(Age.class));
        verifyNoMoreInteractions(doctorRepository, findPatient);

        assertFalse(result.isSuccess());

    }

    @SneakyThrows
    public Date dateFrom(String s) {
        return new SimpleDateFormat("dd.MM.yyyy").parse(s);
    }
}