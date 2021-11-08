package com.example.ketofinder.controller;

import com.example.ketofinder.dto.RestaurantBundleDTO;
import com.example.ketofinder.service.RestaurantListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    private RestaurantListService restaurantListService;

    @Autowired
    public RestaurantController (
        RestaurantListService restaurantListService
    ){
        this.restaurantListService = restaurantListService;
    }

    @GetMapping("/restaurants")
    public List<RestaurantBundleDTO> findAllRestaurants() {
        return restaurantListService.findAllItems();
    }

}
