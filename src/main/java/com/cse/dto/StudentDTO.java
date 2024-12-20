package com.cse.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDTO extends BaseDTO {
    private String roll;
    private String aadhar;
    private String fullName;
    private LocalDate dateOfBirth;
    private String path;
    private String email1;
    private String email2;
    private String mobile1;
    private String mobile2;
    private ParentsDTO parents;
    private AddressDTO address;
    private EducationDTO education;
    private SocialDTO social;
}
