package com.bootcamp.client_service.model.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class CustomerType {
    @Id
    private Long id;
    private String name;
}
