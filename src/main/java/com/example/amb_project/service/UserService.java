package com.example.amb_project.service;

import java.util.List;

import com.example.amb_project.model.UserLocation;

public interface UserService 
{
	public UserLocation createUser(UserLocation userLocation);
	
	public List<UserLocation> getall(Integer n);
	
	public UserLocation updateUser(UserLocation userLocation);

}
