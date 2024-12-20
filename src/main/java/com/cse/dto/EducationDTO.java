package com.cse.dto;

import lombok.Data;

@Data
public class EducationDTO extends BaseDTO{
    private String schoolHall;
    private String schoolName;
    private String schoolGPA;
    private String interHall;
    private String collegeName;
    private String collegeGPA;
}
