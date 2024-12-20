package com.cse.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Parents extends BaseEntity{
    private String motherName;
    private String motherMobile;
    private String fatherName;
    private String fatherMobile;
}
