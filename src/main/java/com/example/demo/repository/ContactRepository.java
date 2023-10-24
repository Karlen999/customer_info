package com.example.demo.repository;

import com.example.demo.model.Contact;
import com.example.demo.model.ContactType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findByCustomerId(Long customerId);
    List<Contact> findByCustomerIdAndType(Long customerId, ContactType type);
}
