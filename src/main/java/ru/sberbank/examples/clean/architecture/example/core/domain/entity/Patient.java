package ru.sberbank.examples.clean.architecture.example.core.domain.entity;

import lombok.Builder;
import lombok.Getter;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.Age;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.FullName;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.Gender;

@Getter
@Builder
public class Patient {
    FullName fullName;
    Age age;
    Gender gender;
}
