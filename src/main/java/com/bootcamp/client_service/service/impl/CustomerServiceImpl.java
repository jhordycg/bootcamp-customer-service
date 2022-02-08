package com.bootcamp.client_service.service.impl;

import com.bootcamp.client_service.model.dao.Customer;
import com.bootcamp.client_service.model.dao.CustomerType;
import com.bootcamp.client_service.repository.CustomerRepository;
import com.bootcamp.client_service.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Override
    public Flux<Customer> findAllByType(CustomerType type) {
        return repository.findAllByType(type);
    }

    @Override
    public Flux<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Customer> create(Customer customer) {
        var customerFound = repository.findOne(Example.of(customer)).hasElement();
        return customerFound.flatMap(exist -> {
            if (exist) return Mono.error(new HttpClientErrorException(HttpStatus.CONFLICT));
            else return repository.save(customer);
        });
    }

    @Override
    public Mono<Customer> update(String id, Customer customer) {
        return repository.findById(id)
                .single().flatMap(customerFound -> {
                    customer.setId(customerFound.getId());
                    return repository.save(customer);
                });
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
