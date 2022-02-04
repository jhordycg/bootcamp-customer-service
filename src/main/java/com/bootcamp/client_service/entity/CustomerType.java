package com.bootcamp.client_service.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class CustomerType {
    @Id
    private Long id;
    private String name;
}
