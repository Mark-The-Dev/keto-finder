package com.example.ketofinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantItemDTO {
    private String itemName;
    private String itemDescription;
    private float calories;
    private float proteinValue;
    private float carbValue;
    private float netCarbValue;
}
