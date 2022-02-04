package com.bootcamp.client_service.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Customer {
    @Id
    private Long id;
    private String fullName;
    private String mailAddress;
    private String address;
    private CustomerType type;
}
