package com.example.ketofinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantBundleDTO {
    private long restaurantId;
    private String restaurantName;
    private List<RestaurantItemDTO> restaurantItems;
}
