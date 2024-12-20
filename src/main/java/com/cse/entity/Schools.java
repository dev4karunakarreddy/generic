package com.cse.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Schools extends BaseEntity{
    private String name;
    private String address;
}
