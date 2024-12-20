package com.cse.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Student extends BaseEntity{
    private String fullName;
    private LocalDate dateOfBirth;
    private String email1;
    private String mobile1;
}
