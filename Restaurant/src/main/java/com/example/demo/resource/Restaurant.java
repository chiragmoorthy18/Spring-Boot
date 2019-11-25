package com.example.demo.resource;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
	@Id
	private String orderId;
	private List<String> orderItems;
	private String restaurantName;
}
