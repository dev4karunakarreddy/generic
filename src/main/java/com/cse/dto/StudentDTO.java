package com.cse.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentDTO extends BaseDTO {
    private String fullName;
    private LocalDate dateOfBirth;
    private String email1;
    private String mobile1;
}
