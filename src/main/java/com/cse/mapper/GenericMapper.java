package com.cse.mapper;

import com.cse.dto.*;
import com.cse.entity.*;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface GenericMapper {

    StudentDTO toDTO(Student entity);

    Student toEntity(StudentDTO dto);

    AddressDTO toDTO(Address entity);

    Address toEntity(AddressDTO dto);

    ParentsDTO toDTO(Parents entity);

    Parents toEntity(ParentsDTO dto);

    EducationDTO toDTO(Education entity);

    Education toEntity(EducationDTO dto);

    SocialDTO toDTO(Social entity);

    Social toEntity(SocialDTO dto);

    Schools toEntity(SchoolDTO dto);

    SchoolDTO toDTO(Schools entity);
}
