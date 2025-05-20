package com.iticbcn.apireactive.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iticbcn.apireactive.DTO.StudentDTO;
import com.iticbcn.apireactive.Service.StudentService;
import com.iticbcn.apireactive.mapper.DocumentMapper;
import com.iticbcn.apireactive.repository.StudentRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImpl implements StudentService {
    
    private final StudentRepo studentRepo;
    private final DocumentMapper documentMapper;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo, DocumentMapper documentMapper) {
        this.studentRepo = studentRepo;
        this.documentMapper = documentMapper;
    }

    @Override
    public Flux<StudentDTO> findAll() {
        // busco todos los estudiantes y los convierto a DTO
        return studentRepo.findAll().map(documentMapper::toDTO);
    }

    @Override
    public Mono<StudentDTO> findById(String id) {
        // busco el estudiante por id y lo convierto a DTO
        return studentRepo.findById(id).map(documentMapper::toDTO);
    }

    @Override
    public Mono<StudentDTO> save(StudentDTO studentDTO) {
        // Primero verifico si el estudiante ya existe en la BBDD con el id,
        // si no existe, lo guardo y si no, no hago nada

        // Convierto el DTO a Student, lo persisto en la base de datos
        // y luego lo convierto a DTO para devolverlo
        return studentRepo.findById(studentDTO.id()).flatMap(existeix -> 
             studentRepo.save(documentMapper.toEntity(studentDTO)).map(documentMapper::toDTO));
    }

    @Override
    public Mono<StudentDTO> update(StudentDTO studentDTO) {
        // Primero verifico si el estudiante ya existe en la BBDD con el id,
        // si existe, lo actualizo y si no, no hago nada.

        // convierto el DTO a Student, lo persisto en la base de datos
        // y luego lo convierto a DTO para devolverlo
        return studentRepo.findById(studentDTO.id()).flatMap(existeix -> 
             studentRepo.save(documentMapper.toEntity(studentDTO)).map(documentMapper::toDTO));
    }

    @Override
    public Mono<Void> delete(String id) {
        // Solo eliminará el estudiante si existe la ID en la BBDD
        return studentRepo.findById(id).flatMap(existeix -> 
             studentRepo.deleteById(id));
    }    
}