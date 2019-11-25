package com.example.demo.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO { 
	
	    private String name;
	    
	    private String email;
	   
	    private String password;
	  
	    private String username;

}
