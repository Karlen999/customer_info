package com.example.demo.controller;

import com.example.demo.dto.ContactDTO;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.Contact;
import com.example.demo.model.ContactType;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> addCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        CustomerDTO savedCustomerDTO = customerService.addCustomer(customerDTO);
        return new ResponseEntity<>(savedCustomerDTO, HttpStatus.CREATED);
    }

    @PostMapping("/{customerId}/contacts")
    public ResponseEntity<ContactDTO> addContact(@PathVariable Long customerId,
                                                 @Valid @RequestBody ContactDTO contactDTO) {
        ContactDTO savedContactDTO = customerService.addContact(customerId, contactDTO);
        return new ResponseEntity<>(savedContactDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> customerDTOs = customerService.getAllCustomers();
        return new ResponseEntity<>(customerDTOs, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long customerId) {
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @GetMapping("/{customerId}/contacts")
    public ResponseEntity<List<ContactDTO>> getContactByCustomerId(@PathVariable Long customerId) {
        List<ContactDTO> contactDTOs = customerService.getContactByCustomerId(customerId);
        return new  ResponseEntity<>(contactDTOs, HttpStatus.OK);
    }

    @GetMapping("/{customerId}/contacts/{type}")
    public ResponseEntity<List<ContactDTO>> getContactsByCustomerIdAndType(@PathVariable Long customerId,
                                                                        @PathVariable ContactType type) {
        List<ContactDTO> contactDTOs = customerService.getContactByCustomerIdAndType(customerId, type);
        return new ResponseEntity<>(contactDTOs, HttpStatus.OK);
    }
}
