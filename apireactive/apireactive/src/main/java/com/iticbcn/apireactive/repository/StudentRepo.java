package com.iticbcn.apireactive.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import reactor.core.publisher.Flux;

import com.iticbcn.apireactive.model.Student;

@EnableReactiveMongoRepositories
public interface StudentRepo extends ReactiveMongoRepository<Student, String> {
    @Query("{ 'name': { $regex: ?0, $options: 'i' } }") // ?0 es el primer argumento
    Flux<Student> findByNamePattern(String regex);
}

