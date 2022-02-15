package com.bootcamp.client.service.impl;

import com.bootcamp.client.model.dao.Natural;
import com.bootcamp.client.repository.NaturalRepository;
import com.bootcamp.client.service.NaturalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class NaturalServiceImpl implements NaturalService {

    private final NaturalRepository repository;

    @Override
    public Mono<Natural> findById(String id) {
        return repository.findById(id).single();
    }

    @Override
    public Flux<Natural> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Natural> create(Natural natural) {
        var customerFound = repository.findOne(Example.of(natural)).hasElement();
        return customerFound.flatMap(exist -> {
            if (Boolean.TRUE.equals(exist)) return Mono.error(new HttpClientErrorException(HttpStatus.CONFLICT));
            else return repository.save(natural);
        });
    }

    @Override
    public Mono<Natural> update(String id, Natural natural) {
        return repository.findById(id).single().flatMap(naturalFound -> {
            natural.setId(naturalFound.getId());
            return repository.save(natural);
        });
    }

    @Override
    public Mono<Void> delete(String id) {
        return repository.deleteById(id);
    }
}
