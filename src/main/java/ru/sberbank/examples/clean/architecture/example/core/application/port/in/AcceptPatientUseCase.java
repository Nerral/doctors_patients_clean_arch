package ru.sberbank.examples.clean.architecture.example.core.application.port.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.Age;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.FullName;

import java.util.Date;

public interface AcceptPatientUseCase {

    Result acceptPatient(Input input);

    @Value
    class Input {
        FullName patientFullName;
        Age patientAge;
        Date acceptDate;
        long doctorId;
    }

    @Value
    class Result {
        boolean success;
        String message;
    }
}
