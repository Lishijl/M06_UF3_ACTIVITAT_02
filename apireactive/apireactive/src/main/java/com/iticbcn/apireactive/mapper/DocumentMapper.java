package com.iticbcn.apireactive.mapper;

import org.mapstruct.Mapper;

import com.iticbcn.apireactive.DTO.StudentDTO;
import com.iticbcn.apireactive.model.Student;

@Mapper(componentModel = "spring")
public interface DocumentMapper {
    StudentDTO toDTO(Student student);
    Student toEntity(StudentDTO dto);
}
