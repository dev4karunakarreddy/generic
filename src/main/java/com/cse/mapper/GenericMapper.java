package com.cse.mapper;

import com.cse.dto.*;
import com.cse.entity.*;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface GenericMapper {

    StudentDTO toDTO(Student entity);

    Student toEntity(StudentDTO dto);

}
