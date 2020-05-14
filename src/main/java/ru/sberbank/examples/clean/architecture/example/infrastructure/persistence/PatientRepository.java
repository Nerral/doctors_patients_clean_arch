package ru.sberbank.examples.clean.architecture.example.infrastructure.persistence;

import org.springframework.stereotype.Component;
import ru.sberbank.examples.clean.architecture.example.core.application.port.out.FindPatient;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.Patient;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.Age;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.FullName;

@Component
class PatientRepository implements FindPatient {

    private PatientJpaRepository patientJpaRepository;

    public PatientRepository(PatientJpaRepository patientJpaRepository) {
        this.patientJpaRepository = patientJpaRepository;
    }

    @Override
    public Patient findByFullNameAndAge(FullName fullName, Age age) {
        //todo
        return null;
    }
}
