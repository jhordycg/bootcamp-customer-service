package com.bootcamp.client_service.model.dto;

import com.bootcamp.client_service.model.dao.CustomerType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private Long id;
    private String fullName;
    private String mailAddress;
    private String address;
    private CustomerType type;
}
