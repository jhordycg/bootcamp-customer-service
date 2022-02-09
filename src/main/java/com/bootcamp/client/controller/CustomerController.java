package com.bootcamp.client.controller;

import com.bootcamp.client.model.dao.Customer;
import com.bootcamp.client.model.dao.CustomerType;
import com.bootcamp.client.model.dto.CustomerDto;
import com.bootcamp.client.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;
    private final ModelMapper mapper;

    @GetMapping
    public Flux<CustomerDto> findAll() {
        return service.findAll().mapNotNull(customer -> mapper.map(customer, CustomerDto.class));
    }

    @GetMapping("/{id}")
    public Mono<CustomerDto> findById(@PathVariable String id) {
        return service.findById(id)
                .mapNotNull(customer -> mapper.map(customer, CustomerDto.class));
    }

    @GetMapping("/")
    public Flux<CustomerDto> findByType(@PathParam("type") CustomerType type) {
        return service.findAllByType(type)
                .mapNotNull(customer -> mapper.map(customer, CustomerDto.class));
    }

    @PostMapping
    public Mono<CustomerDto> create(@RequestBody Customer customer) {
        return service.create(customer)
                .mapNotNull(customerCreated -> mapper.map(customerCreated, CustomerDto.class));
    }

    @PutMapping("/{id}")
    public Mono<CustomerDto> update(@PathVariable String id, @RequestBody Customer customer) {
        return service.update(id, customer)
                .mapNotNull(customer1 -> mapper.map(customer1, CustomerDto.class));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
