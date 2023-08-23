package com.example.amb_project.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.amb_project.model.UserLocation;
import com.example.amb_project.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class UserController 
{

	@Autowired
	private UserService userServ;
	
	@PostMapping("insert")
	public ResponseEntity<UserLocation> crateUser(@RequestBody UserLocation userLocation)
	{
		UserLocation ul=userServ.createUser(userLocation);
		
		return new ResponseEntity<>(ul,HttpStatus.CREATED);
	}
	
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<UserLocation>> getUsers(@PathVariable("id") Integer n)
	{
		List<UserLocation> allu=userServ.getall(n);
		
		if(allu.size()<=n)
		{
			return new ResponseEntity<>(allu,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(allu.subList(0,n),HttpStatus.OK);
		}
	}
	
	
	@PatchMapping("{id}")
	public ResponseEntity<UserLocation> updateUser(@RequestBody UserLocation userLocation,@PathVariable("id") long uid)
	{
		userLocation.setId(uid);
		UserLocation ul=userServ.updateUser(userLocation);
		return new ResponseEntity<>(ul,HttpStatus.OK);
	}
	
}
