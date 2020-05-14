package ru.sberbank.examples.clean.architecture.example.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sberbank.examples.clean.architecture.example.core.domain.entity.Patient;

@Repository
interface PatientJpaRepository extends JpaRepository<Patient, Long> {

}
