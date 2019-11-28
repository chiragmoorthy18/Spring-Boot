package com.example.demo.controller;

import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.service.MovieService;

public class MovieControllerTest {
    @Mock
	private MovieController movieController;
    @Mock
    private MockMvc mockMvc;
    @Autowired
    private MovieService movieService;
    
    public void getCast()
    {
    	
    }
}
