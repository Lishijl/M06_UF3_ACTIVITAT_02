package com.iticbcn.apireactive.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.iticbcn.apireactive.model.Student;

@EnableReactiveMongoRepositories
public interface StudentRepo extends ReactiveMongoRepository<Student, String> {
    
}
