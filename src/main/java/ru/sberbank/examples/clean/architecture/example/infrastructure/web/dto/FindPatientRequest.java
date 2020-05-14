package ru.sberbank.examples.clean.architecture.example.infrastructure.web.dto;

import lombok.Data;

@Data
public class FindPatientRequest {
    private String firstName;
    private String lastName;
    private int age;
}
