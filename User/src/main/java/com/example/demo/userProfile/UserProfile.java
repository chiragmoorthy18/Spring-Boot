package com.example.demo.userProfile;



import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.Document.Movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {
	@Id
	private String _id;
	@Indexed(unique = true)
	private String uuid;
    private String name;
    @Indexed(unique = true)
    private String email;
    private List<Movie> list;
    @Transient
    private String password;
    private String hashedPassword;
    @Indexed(unique = true)
    private String username;
	public UserProfile(String name, String email, String username,String password) {
		super();
		this.uuid = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}
    
    
}
