package ru.sberbank.examples.clean.architecture.example.infrastructure.web;

import org.springframework.stereotype.Component;
import ru.sberbank.examples.clean.architecture.example.core.application.port.out.DoctorRepository;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.Doctor;

@Component
class RestDoctorRepository implements DoctorRepository {
    @Override
    public Doctor findById(long id) {
        return null;
    }

    @Override
    public void save(Doctor doctor) {

    }
}
