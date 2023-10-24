package com.example.demo.dto;

import com.example.demo.model.ContactType;

public class ContactDTO {
    private Long id;
    private ContactType type;
    private String value;

    public ContactDTO() {
    }

    public ContactDTO(Long id, ContactType type, String value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
