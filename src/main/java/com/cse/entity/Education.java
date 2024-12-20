package com.cse.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Education extends BaseEntity{
    private String schoolHall;
    private String schoolName;
    private String schoolGPA;
    private String interHall;
    private String collegeName;
    private String collegeGPA;
}
