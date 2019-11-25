package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.resource.Restaurant;
import com.example.demo.service.RestaurantService;

@RestController
public class RestaurantController {
    @Autowired
	RestaurantService restaurantService;
    
    @PostMapping("insertRestaurant")
    public ResponseEntity<?> addRes(@RequestBody Restaurant restaurant)
    {
    	this.restaurantService.addRestaurant(restaurant);
    	return ResponseEntity.status(200).body(restaurant);
    }
}
