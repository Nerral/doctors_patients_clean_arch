package ru.sberbank.examples.clean.architecture.example.core.domain.entity.common;

import lombok.Value;

@Value
public class Age {
    int value;

    public static Age of(int value) {
        if(value <= MINIMAL_AGE) {
            throw new IllegalArgumentException("Age cant be less than 1");
        }
        return new Age(value);
    }

    public boolean isAdult() {
        return value > ADULT_AGE;
    }

    public boolean isChild() {
        return !isAdult();
    }

    private static final int MINIMAL_AGE = 1;
    private static final int ADULT_AGE = 18;
}
