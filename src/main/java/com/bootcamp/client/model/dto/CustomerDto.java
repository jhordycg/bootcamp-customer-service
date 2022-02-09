package com.bootcamp.client.model.dto;

import com.bootcamp.client.model.dao.CustomerType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private String id;
    private String fullName;
    private String mailAddress;
    private String address;
    private CustomerType type;
}
