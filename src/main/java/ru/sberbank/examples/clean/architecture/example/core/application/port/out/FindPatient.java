package ru.sberbank.examples.clean.architecture.example.core.application.port.out;

import ru.sberbank.examples.clean.architecture.example.core.domain.entity.Patient;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.Age;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.common.FullName;

public interface FindPatient {
    Patient findByFullNameAndAge(FullName fullName, Age age);
}
