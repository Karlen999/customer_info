package com.example.demo.service;

import com.example.demo.dto.ContactDTO;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.model.Contact;
import com.example.demo.model.ContactType;
import com.example.demo.model.Customer;
import com.example.demo.repository.ContactRepository;
import com.example.demo.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ContactRepository contactRepository;

    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, ContactRepository contactRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.contactRepository = contactRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toDTO(savedCustomer);
    }

    public ContactDTO addContact(Long customerId, ContactDTO contactDTO) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException(customerId));
        Contact contact = customerMapper.toEntity(contactDTO);
        contact.setCustomer(customer);
        Contact savedContact = contactRepository.save(contact);
        return customerMapper.toContactDTO(savedContact);
    }

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        return customerMapper.toDTO(customer);
    }

    public List<ContactDTO> getContactByCustomerId(Long customerId) {
        List<Contact> contacts = contactRepository.findByCustomerId(customerId);
        return contacts.stream()
                .map(customerMapper::toContactDTO)
                .collect(Collectors.toList());
    }

    public List<ContactDTO> getContactByCustomerIdAndType(Long customerId, ContactType type) {
        List<Contact> contacts = contactRepository.findByCustomerIdAndType(customerId, type);
        return contacts.stream()
                .map(customerMapper::toContactDTO)
                .collect(Collectors.toList());
    }
}
