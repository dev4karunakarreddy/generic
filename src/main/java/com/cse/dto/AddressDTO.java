package com.cse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO extends BaseDTO{
    private String houseNumber;
    private String street;
    private String city;
    private String postalCode;
}
