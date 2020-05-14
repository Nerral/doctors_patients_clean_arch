package ru.sberbank.examples.clean.architecture.example.core.application.port.out;

import ru.sberbank.examples.clean.architecture.example.core.domain.entity.Doctor;

public interface DoctorRepository {
    Doctor findById(long id);
    void save(Doctor doctor);
}
