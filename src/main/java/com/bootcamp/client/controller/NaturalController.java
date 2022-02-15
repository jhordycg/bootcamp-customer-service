package com.bootcamp.client.controller;

import com.bootcamp.client.model.dao.Natural;
import com.bootcamp.client.model.dto.CustomerDto;
import com.bootcamp.client.service.NaturalService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class NaturalController {

    private final NaturalService service;
    private final ModelMapper mapper;

    @GetMapping
    public Flux<CustomerDto> findAll() {
        return service.findAll().mapNotNull(natural -> mapper.map(natural, CustomerDto.class));
    }

    @GetMapping("/{id}")
    public Mono<CustomerDto> findById(@PathVariable String id) {
        return service.findById(id)
                .mapNotNull(natural -> mapper.map(natural, CustomerDto.class));
    }

    @PostMapping("natural")
    public Mono<CustomerDto> create(@RequestBody Natural natural) {
        return service.create(natural)
                .mapNotNull(naturalCreated -> mapper.map(naturalCreated, CustomerDto.class));
    }

    @PutMapping("natural/{id}")
    public Mono<CustomerDto> update(@PathVariable String id, @RequestBody Natural natural) {
        return service.update(id, natural)
                .mapNotNull(natural1 -> mapper.map(natural1, CustomerDto.class));
    }

    @DeleteMapping("natural/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}
