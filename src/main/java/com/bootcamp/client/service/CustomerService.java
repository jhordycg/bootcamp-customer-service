package com.bootcamp.client.service;

import com.bootcamp.client.model.dao.Customer;
import com.bootcamp.client.model.dao.CustomerType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Mono<Customer> findById(String id);

    Flux<Customer> findAll();

    Flux<Customer> findAllByType(CustomerType type);

    Mono<Customer> create(Customer customer);

    Mono<Customer> update(String id, Customer customer);

    Mono<Void> delete(String id);
}
