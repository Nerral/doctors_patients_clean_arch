package ru.sberbank.examples.clean.architecture.example.infrastructure.web.mapper;

import org.springframework.stereotype.Component;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.Patient;
import ru.sberbank.examples.clean.architecture.example.infrastructure.web.dto.PatientDto;

@Component
class PatientMapperStub implements PatientMapper {
    @Override
    public PatientDto map(Patient patient) {
        return null;
    }
}
