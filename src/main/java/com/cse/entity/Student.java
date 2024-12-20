package com.cse.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Student extends BaseEntity{
    private String roll;
    private String aadhar;
    private String fullName;
    private LocalDate dateOfBirth;
    private String path;
    private String email1;
    private String email2;
    private String mobile1;
    private String mobile2;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "parents",referencedColumnName = "id")
    private Parents parents;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address",referencedColumnName = "id")
    private Address address;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "education",referencedColumnName = "id")
    private Education education;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "social",referencedColumnName = "id")
    private Social social;
}
