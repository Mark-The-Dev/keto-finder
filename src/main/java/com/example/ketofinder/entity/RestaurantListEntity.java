package com.example.ketofinder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "restaurant_list")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "restaurant_name")
    private String restaurantName;
}
