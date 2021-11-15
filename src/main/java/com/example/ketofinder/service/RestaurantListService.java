package com.example.ketofinder.service;

import com.example.ketofinder.dto.RestaurantBundleDTO;
import com.example.ketofinder.dto.RestaurantItemDTO;
import com.example.ketofinder.entity.RestaurantItemEntity;
import com.example.ketofinder.entity.RestaurantListEntity;
import com.example.ketofinder.repository.RestaurantItemRepository;
import com.example.ketofinder.repository.RestaurantListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantListService {

    private RestaurantListRepository restaurantListRepository;
    private RestaurantItemRepository restaurantItemRepository;

    @Autowired
    public RestaurantListService (
        RestaurantListRepository restaurantListRepository,
        RestaurantItemRepository restaurantItemRepository
    ){
        this.restaurantListRepository = restaurantListRepository;
        this.restaurantItemRepository = restaurantItemRepository;
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
                        item.getFatValue(),
                        item.getCarbValue(),
                        item.getNetCarbValue())
                ).collect(Collectors.toList()))).collect(Collectors.toList());

        return bundleList;
    }

    public RestaurantBundleDTO getRestaurantByName(String restaurantName) {

        RestaurantListEntity restaurantListEntity = restaurantListRepository.findByRestaurantName(restaurantName);

        return new RestaurantBundleDTO(restaurantListEntity.getId() ,
                restaurantListEntity.getRestaurantName(),
                restaurantListEntity.getItems().stream().map(item ->
                new RestaurantItemDTO(
                        item.getItemName(),
                        item.getItemDescription(),
                        item.getCalories(),
                        item.getProteinValue(),
                        item.getFatValue(),
                        item.getCarbValue(),
                        item.getNetCarbValue())
        ).collect(Collectors.toList()));
    }

    public void addRestaurant(RestaurantBundleDTO restaurantBundleDTO){

        RestaurantListEntity restaurantListEntity = new RestaurantListEntity();
        restaurantListEntity.setRestaurantName(restaurantBundleDTO.getRestaurantName());
        restaurantListRepository.save(restaurantListEntity);

    }

    public void addRestaurantItem(RestaurantItemDTO restaurantItemDTO, String restaurantId){
        RestaurantListEntity restaurantListEntity = restaurantListRepository.findById(Long.parseLong(restaurantId));
        RestaurantItemEntity restaurantItemEntity = new RestaurantItemEntity();


        restaurantItemEntity.setRestaurantListEntity(restaurantListEntity);
        restaurantItemEntity.setItemName(restaurantItemDTO.getMealName());
        restaurantItemEntity.setItemDescription(restaurantItemDTO.getMealDescription());
        restaurantItemEntity.setCalories(restaurantItemDTO.getCalories());
        restaurantItemEntity.setProteinValue(restaurantItemDTO.getProteinValue());
        restaurantItemEntity.setFatValue(restaurantItemDTO.getFatValue());
        restaurantItemEntity.setCarbValue(restaurantItemDTO.getCarbValue());
        restaurantItemEntity.setNetCarbValue(restaurantItemDTO.getNetCarbValue());

        restaurantItemRepository.save(restaurantItemEntity);
    }
}
