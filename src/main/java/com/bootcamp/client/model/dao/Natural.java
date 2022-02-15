package com.bootcamp.client.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Natural {
    @Id
    private String id;
    private String dni;
    private String firstName;
    private String lastName;
    private String email;
    private CustomerProfile profile;
}
