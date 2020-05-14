package ru.sberbank.examples.clean.architecture.example.infrastructure.web.mapper;

import ru.sberbank.examples.clean.architecture.example.core.application.port.in.AcceptPatientUseCase;
import ru.sberbank.examples.clean.architecture.example.infrastructure.web.dto.AcceptPatientRequest;

public interface AcceptPatientRequestMapper {
    AcceptPatientUseCase.Input map(AcceptPatientRequest request);
}
