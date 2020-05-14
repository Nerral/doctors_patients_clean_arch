package ru.sberbank.examples.clean.architecture.example.infrastructure.web.mapper;

import ru.sberbank.examples.clean.architecture.example.core.domain.entity.Patient;
import ru.sberbank.examples.clean.architecture.example.infrastructure.web.dto.PatientDto;

public interface PatientMapper {
    PatientDto map(Patient patient);
}
