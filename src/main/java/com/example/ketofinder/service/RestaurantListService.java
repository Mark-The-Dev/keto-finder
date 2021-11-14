package com.example.ketofinder.service;

import com.example.ketofinder.dto.RestaurantBundleDTO;
import com.example.ketofinder.dto.RestaurantItemDTO;
import com.example.ketofinder.entity.RestaurantListEntity;
import com.example.ketofinder.repository.RestaurantListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantListService {

    private RestaurantListRepository restaurantListRepository;

    @Autowired
    public RestaurantListService (
        RestaurantListRepository restaurantListRepository
    ){
        this.restaurantListRepository = restaurantListRepository;
    }

    public List<RestaurantBundleDTO> findAllItems() {
        List<RestaurantListEntity> listEntities = restaurantListRepository.findRestaurantListEntities();

        List<RestaurantBundleDTO> bundleList = listEntities.stream().map( listItem ->
                new RestaurantBundleDTO(listItem.getId() , listItem.getRestaurantName(), listItem.getItems().stream().map(item ->
                new RestaurantItemDTO(
                        item.getItemName(),
                        item.getItemDescription(),
                        item.getCalories(),
                        item.getProteinValue(),
                        item.getCarbValue(),
                        item.getNetCarbValue())
                ).collect(Collectors.toList()))).collect(Collectors.toList());

        return bundleList;
    }
}
