package com.iticbcn.apireactive.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iticbcn.apireactive.DTO.StudentDTO;
import com.iticbcn.apireactive.Service.StudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    
    @PostMapping("/save")
    public Mono<StudentDTO> save(@RequestBody StudentDTO dto) {
        return studentService.save(dto);
    }

    @GetMapping("/{id}")
    public Mono<StudentDTO> findById(@PathVariable String id) {
        return studentService.findById(id);
    }

    @GetMapping("/all")
    public Flux<StudentDTO> findAll() {
        return studentService.findAll();
    }

    @PutMapping("/update")
    public Mono<StudentDTO> update(@RequestBody StudentDTO dto) {
        return studentService.update(dto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return studentService.delete(id);
    }

    @GetMapping("/search/{name}")
    public Flux<StudentDTO> findByNamePattern(@PathVariable String name){
        // busco el o los estudiantes por nombre y lo convierto a DTO
        return studentService.findByNamePattern(name);
    }    
    
}
