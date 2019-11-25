package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.RestaurantRepository;
import com.example.demo.resource.Restaurant;

@Service
public class RestaurantService {
    
	RestaurantRepository restaurantRepository;
    @Autowired
	public RestaurantService(RestaurantRepository restaurantRepository) {
		super();
		this.restaurantRepository = restaurantRepository;
	}
	
	public void addRestaurant(Restaurant restaurant)
	{
		this.restaurantRepository.insert(restaurant);
	}
	
}
