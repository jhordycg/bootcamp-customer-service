package com.bootcamp.client.model.dto;

import com.bootcamp.client.model.dao.CustomerProfile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto {
    private String id;
    private String dni;
    private String firstName;
    private String lastName;
    private String email;
    private CustomerProfile profile;
}
