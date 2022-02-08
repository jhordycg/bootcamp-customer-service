package com.bootcamp.client_service.repository;

import com.bootcamp.client_service.model.dao.Customer;
import com.bootcamp.client_service.model.dao.CustomerType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
    Flux<Customer> findAllByType(CustomerType type);

    Mono<Customer> findByFullName(String fullName);
}
