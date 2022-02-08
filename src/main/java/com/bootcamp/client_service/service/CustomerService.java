package com.bootcamp.client_service.service;

import com.bootcamp.client_service.model.dao.Customer;
import com.bootcamp.client_service.model.dao.CustomerType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface CustomerService {

    Flux<Customer> findAll();

    Flux<Customer> findAllByType(CustomerType type);

    Mono<Customer> create(Customer customer);

    Mono<Customer> update(String id, Customer customer);

    Mono<Void> delete(String id);
}
