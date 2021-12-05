package com.example.ketofinder.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "restaurant_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name="item_description")
    private String itemDescription;

    @Column(name="calories")
    private float calories;

    @Column(name="protein_value")
    private float proteinValue;

    @Column(name="fat_value")
    private float fatValue;

    @Column(name="carb_value")
    private float carbValue;

    @Column(name="net_carb_value")
    private float netCarbValue;

    @ManyToOne
    @JoinColumn(name="restaurant_id")
    private RestaurantListEntity restaurantListEntity;
}
