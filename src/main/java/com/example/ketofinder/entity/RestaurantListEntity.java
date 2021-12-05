package com.example.ketofinder.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "restaurant_list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @OneToMany(mappedBy = "restaurantListEntity")
    private List<RestaurantItemEntity> items;
}
