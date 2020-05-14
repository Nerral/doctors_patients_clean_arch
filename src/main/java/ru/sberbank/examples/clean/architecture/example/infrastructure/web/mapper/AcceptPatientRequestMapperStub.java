package ru.sberbank.examples.clean.architecture.example.infrastructure.web.mapper;

import org.springframework.stereotype.Component;
import ru.sberbank.examples.clean.architecture.example.core.application.port.in.AcceptPatientUseCase;
import ru.sberbank.examples.clean.architecture.example.infrastructure.web.dto.AcceptPatientRequest;

@Component
class AcceptPatientRequestMapperStub implements AcceptPatientRequestMapper {
    @Override
    public AcceptPatientUseCase.Input map(AcceptPatientRequest request) {
        //todo stub
        return null;
    }
}
