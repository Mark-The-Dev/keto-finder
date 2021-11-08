package com.example.ketofinder.repository;

import com.example.ketofinder.entity.RestaurantListEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantListRepository extends CrudRepository<RestaurantListEntity, Long> {

    RestaurantListEntity findById(long id);

    @Query(value = "select * from restaurant_list", nativeQuery = true)
    List<RestaurantListEntity> findRestaurantListEntities();
}
