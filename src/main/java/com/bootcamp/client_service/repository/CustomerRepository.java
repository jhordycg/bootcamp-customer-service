package com.bootcamp.client_service.repository;

import com.bootcamp.client_service.entity.Customer;
import com.bootcamp.client_service.entity.CustomerType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, Long> {
    Flux<Customer> findAllByType(CustomerType type);
}
