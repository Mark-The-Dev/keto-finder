package com.example.ketofinder.repository;

import com.example.ketofinder.entity.RestaurantListEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantListRepository extends CrudRepository<RestaurantListEntity, Long> {

    RestaurantListEntity findById(long id);
}
