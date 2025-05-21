package com.iticbcn.apireactive.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iticbcn.apireactive.DTO.StudentDTO;
import com.iticbcn.apireactive.Service.StudentService;
import com.iticbcn.apireactive.mapper.DocumentMapper;
import com.iticbcn.apireactive.model.Student;
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
        // convierto el DTO a Student para guardarlo en la base de datos
        // y luego lo convierto a DTO para devolverlo
        Student student = documentMapper.toEntity(studentDTO);
        return studentRepo.save(student).map(documentMapper::toDTO);
    }

    @Override
    public Mono<StudentDTO> update(StudentDTO studentDTO) {
        // convierto el DTO a Student para actualizarlo en la base de datos
        // y luego lo convierto a DTO para devolverlo
        Student student = documentMapper.toEntity(studentDTO);
        return studentRepo.save(student).map(documentMapper::toDTO);
    }

    @Override
    public Mono<Void> delete(String id) {
        // elimino el estudiante por id
        return studentRepo.deleteById(id);
    }    

    @Override
    public Flux<StudentDTO> findByName(String name) {
        // busco el estudiante por nombre y lo convierto a DTO
        return studentRepo.findByNameRegex(name).map(documentMapper::toDTO);
    }
}
