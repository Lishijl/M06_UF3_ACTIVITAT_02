package com.iticbcn.apireactive.Service;

import com.iticbcn.apireactive.DTO.StudentDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {
    // Mono cuando obtiene un solo elemento
    // devuelve un objeto studentDTO
    Mono<StudentDTO> save(StudentDTO studentDTO);
    Mono<StudentDTO> findById(String id);
    Mono<StudentDTO> update(StudentDTO studentDTO);
    // Flux cuando obtiene mas de un elemento
    Flux<StudentDTO> findAll();

    // Mono<Void> cuando no devuelve nada y es reactivo 
    Mono<Void> delete(String id);

    //find by name
    Flux<StudentDTO> findByName(String name);
}
