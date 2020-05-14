package ru.sberbank.examples.clean.architecture.example.core.domain.exception;

public class AcceptPatientException extends RuntimeException {
    public AcceptPatientException(String message) {
        super(message);
    }
}
