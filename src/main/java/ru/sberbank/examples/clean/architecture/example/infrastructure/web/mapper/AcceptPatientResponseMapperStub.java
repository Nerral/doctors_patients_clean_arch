package ru.sberbank.examples.clean.architecture.example.infrastructure.web.mapper;

import org.springframework.stereotype.Component;
import ru.sberbank.examples.clean.architecture.example.core.application.port.in.AcceptPatientUseCase;
import ru.sberbank.examples.clean.architecture.example.infrastructure.web.dto.AcceptPatientResponse;

@Component
public class AcceptPatientResponseMapperStub implements  AcceptPatientResponseMapper {
    @Override
    public AcceptPatientResponse map(AcceptPatientUseCase.Result result) {
        //todo stub
        return null;
    }
}
