package com.example.demo.mapper;

import com.example.demo.dto.ContactDTO;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.Contact;
import com.example.demo.model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    public ContactDTO toContactDTO(Contact contact) {
        ContactDTO dto = new ContactDTO();
        dto.setId(contact.getId());
        dto.setType(contact.getType());
        dto.setValue(contact.getValue());
        return dto;
    }

    public CustomerDTO toDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setContacts(customer.getContacts().stream()
                .map(this::toContactDTO)  // Updated method reference here
                .collect(Collectors.toList()));
        return dto;
    }

    public Customer toEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setName(dto.getName());
        return customer;
    }

    public ContactDTO toDTO(Contact contact) {
        ContactDTO dto = new ContactDTO();
        dto.setId(contact.getId());
        dto.setType(contact.getType());
        dto.setValue(contact.getValue());
        return dto;
    }

    public Contact toEntity(ContactDTO dto) {
        Contact contact = new Contact();
        contact.setId(dto.getId());
        contact.setType(dto.getType());
        contact.setValue(dto.getValue());
        return contact;
    }
}
