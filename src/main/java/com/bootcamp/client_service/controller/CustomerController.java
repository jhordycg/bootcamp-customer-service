package com.bootcamp.client_service.controller;

import com.bootcamp.client_service.entity.Customer;
import com.bootcamp.client_service.entity.CustomerType;
import com.bootcamp.client_service.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerRepository repository;

    @GetMapping
    public Flux<Customer> findAll() {
        return repository.findAll();
    }

    @GetMapping("/")
    public Flux<Customer> findByType(@PathParam("type") CustomerType type) {
        return repository.findAllByType(type);
    }

    @PostMapping
    public Mono<Customer> save(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @PutMapping("/{id}")
    public Mono<Customer> edit(@PathVariable("id") Long id, @RequestBody Customer customer) {
        return repository.save(customer);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return repository.deleteById(id);
    }
}
