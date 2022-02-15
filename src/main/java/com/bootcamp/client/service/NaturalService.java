package com.bootcamp.client.service;

import com.bootcamp.client.model.dao.Natural;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NaturalService {

    Mono<Natural> findById(String id);

    Flux<Natural> findAll();

    //Flux<Natural> findAllByType(CustomerType type);

    Mono<Natural> create(Natural natural);

    Mono<Natural> update(String id, Natural natural);

    Mono<Void> delete(String id);
}
