package com.example.demo.dto;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class CustomerDTO {
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;
    private List<ContactDTO> contacts;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, String name, List<ContactDTO> contacts) {
        this.id = id;
        this.name = name;
        this.contacts = contacts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ContactDTO> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }
}
