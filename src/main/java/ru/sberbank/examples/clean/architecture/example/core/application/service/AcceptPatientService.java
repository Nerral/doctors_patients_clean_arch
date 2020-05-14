package ru.sberbank.examples.clean.architecture.example.core.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.sberbank.examples.clean.architecture.example.core.application.port.in.AcceptPatientUseCase;
import ru.sberbank.examples.clean.architecture.example.core.application.port.out.DoctorRepository;
import ru.sberbank.examples.clean.architecture.example.core.application.port.out.FindPatient;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.Doctor;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.Patient;
import ru.sberbank.examples.clean.architecture.example.core.domain.exception.AcceptPatientException;

@Component
class AcceptPatientService implements AcceptPatientUseCase {

    private FindPatient findPatient;
    private DoctorRepository doctorRepository;

    @Autowired
    public AcceptPatientService(FindPatient findPatient,
                                DoctorRepository doctorRepository) {
        this.findPatient = findPatient;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Result acceptPatient(Input input) {
        Result result;
        try {
            Patient patient = findPatientFromInput(input);
            Doctor doctor = findDoctorFromInput(input);
            doctor.acceptPatient(patient, input.getAcceptDate());
            doctorRepository.save(doctor);
            result = new Result(true, "ok");
        } catch (AcceptPatientException e) {
            result = new Result(false, e.getMessage());
        }
        return result;
    }

    private Doctor findDoctorFromInput(Input input) {
        return doctorRepository.findById(input.getDoctorId());
    }

    private Patient findPatientFromInput(Input input) {
        return findPatient.findByFullNameAndAge(input.getPatientFullName(), input.getPatientAge());
    }
}
