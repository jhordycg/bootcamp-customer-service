package com.bootcamp.client_service.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Customer {
    @Id
    private String id;
    private String fullName;
    private String mailAddress;
    private String address;
    private CustomerType type;
}
