package com.example.ketofinder.repository;

import com.example.ketofinder.entity.RestaurantItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantItemRepository extends CrudRepository<RestaurantItemEntity, Long> {
    RestaurantItemEntity findById(long id);
}
