package com.example.amb_project.junti;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.amb_project.model.UserLocation;
import com.example.amb_project.repository.UserRepository;

@SpringBootApplication
public class JunitAmb 
{
	@Autowired
	private UserRepository userRep;
	
	@Test
	void savedata()
	{
		UserLocation ul=new UserLocation();
		ul.setName("america");
		ul.setLatitude(78.90);
		ul.setLongitude(89.09);
		userRep.save(ul);	
		
	}
}


