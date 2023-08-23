package com.example.amb_project.userserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.amb_project.model.UserLocation;
import com.example.amb_project.repository.UserRepository;
import com.example.amb_project.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService
{
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserLocation createUser(UserLocation userLocation) {
		
		return userRepo.save(userLocation);
	}

	@Override
	public List<UserLocation> getall(Integer n)
	{
		return userRepo.findAllByOrderByLatitudeAscLongitudeAsc();
	}

	@Override
	public UserLocation updateUser(UserLocation userLocation) 
	{
		UserLocation exul=userRepo.findById(userLocation.getId()).get();
		exul.setName(userLocation.getName());
		exul.setLatitude(userLocation.getLatitude());
		exul.setLongitude(userLocation.getLongitude());
		return userRepo.save(exul);
	}

		
}
