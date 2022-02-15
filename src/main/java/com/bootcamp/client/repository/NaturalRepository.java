package com.bootcamp.client.repository;

import com.bootcamp.client.model.dao.Natural;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface NaturalRepository extends ReactiveMongoRepository<Natural, String> {
}
