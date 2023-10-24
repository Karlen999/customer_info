package com.example.demo.exception;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(Long id) {
        super("Contact with ID " + id + " not found.");
    }
}
