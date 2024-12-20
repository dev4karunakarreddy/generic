package com.cse.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Social extends BaseEntity{
    private String instagram;
    private String twitter;
    private String linkedIn;
    private String snapChat;
}
