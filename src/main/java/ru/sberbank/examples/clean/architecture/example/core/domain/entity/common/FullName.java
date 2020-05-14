package ru.sberbank.examples.clean.architecture.example.core.domain.entity.common;

import lombok.Value;

@Value
public class FullName {
    String firstName;
    String lastName;
    String middleName;

    public static FullName of(String firstName, String lastName, String middleName) {

        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("FirstName is absent");
        }

        if(lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("LastName is absent");
        }

        return new FullName(firstName, lastName, middleName);
    }
}
