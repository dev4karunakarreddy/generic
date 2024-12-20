package com.cse.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Address extends BaseEntity{
    private String houseNumber;
    private String street;
    private String city;
    private String postalCode;
}
