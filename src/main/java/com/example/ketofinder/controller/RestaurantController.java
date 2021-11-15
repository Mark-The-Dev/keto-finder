package com.example.ketofinder.controller;

import com.example.ketofinder.dto.RestaurantBundleDTO;
import com.example.ketofinder.dto.RestaurantItemDTO;
import com.example.ketofinder.service.RestaurantListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @CrossOrigin(origins = "http://localhost:4200")
    public List<RestaurantBundleDTO> findAllRestaurants() {

        return restaurantListService.findAllItems();
    }

    @GetMapping("/restaurants/{restaurantName}")
    @CrossOrigin(origins = "http://localhost:4200")
    public RestaurantBundleDTO findAllRestaurants(@PathVariable String restaurantName) {

        return restaurantListService.getRestaurantByName(restaurantName);

    }

    @PostMapping("/restaurants")
    @CrossOrigin(origins = "http://localhost:4200")
    public void addNewRestaurant(@RequestBody RestaurantBundleDTO restaurantBundleDTO) {

        restaurantListService.addRestaurant(restaurantBundleDTO);

    }

    @PostMapping("/restaurants/addMeal/{restaurantId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void addNewRestaurantMeal(@RequestBody RestaurantItemDTO restaurantItemDTO, @PathVariable String restaurantId) {

        restaurantListService.addRestaurantItem(restaurantItemDTO, restaurantId);
    }

}
