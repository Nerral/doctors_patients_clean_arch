package ru.sberbank.examples.clean.architecture.example.infrastructure.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sberbank.examples.clean.architecture.example.core.application.port.in.AcceptPatientUseCase;
import ru.sberbank.examples.clean.architecture.example.core.application.port.out.FindPatient;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.Age;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.FullName;
import ru.sberbank.examples.clean.architecture.example.infrastructure.web.dto.AcceptPatientRequest;
import ru.sberbank.examples.clean.architecture.example.infrastructure.web.dto.AcceptPatientResponse;
import ru.sberbank.examples.clean.architecture.example.infrastructure.web.dto.FindPatientRequest;
import ru.sberbank.examples.clean.architecture.example.infrastructure.web.dto.PatientDto;
import ru.sberbank.examples.clean.architecture.example.infrastructure.web.mapper.AcceptPatientRequestMapper;
import ru.sberbank.examples.clean.architecture.example.infrastructure.web.mapper.AcceptPatientResponseMapper;
import ru.sberbank.examples.clean.architecture.example.infrastructure.web.mapper.PatientMapper;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private AcceptPatientUseCase acceptPatientUseCase;
    private FindPatient findPatient;
    private AcceptPatientRequestMapper acceptPatientRequestMapper;
    private AcceptPatientResponseMapper acceptPatientResponseMapper;
    private PatientMapper patientMapper;

    @Autowired
    public PatientController(AcceptPatientUseCase acceptPatientUseCase,
                             FindPatient findPatient,
                             AcceptPatientRequestMapper acceptPatientRequestMapper,
                             AcceptPatientResponseMapper acceptPatientResponseMapper,
                             PatientMapper patientMapper) {
        this.acceptPatientUseCase = acceptPatientUseCase;
        this.findPatient = findPatient;
        this.acceptPatientRequestMapper = acceptPatientRequestMapper;
        this.acceptPatientResponseMapper = acceptPatientResponseMapper;
        this.patientMapper = patientMapper;
    }

    @PostMapping("/accept")
    public AcceptPatientResponse acceptPatient(@RequestBody AcceptPatientRequest request) {
        AcceptPatientUseCase.Input input = acceptPatientRequestMapper.map(request);
        AcceptPatientUseCase.Result result = acceptPatientUseCase.acceptPatient(input);
        return acceptPatientResponseMapper.map(result);
    }


    @PostMapping("/find")
    public PatientDto findPatient(@RequestBody FindPatientRequest request) {
        FullName fullName = new FullName(request.getFirstName(), request.getLastName(), null);
        Age age = Age.of(request.getAge());
        return patientMapper.map(findPatient.findByFullNameAndAge(fullName, age));
    }
}
