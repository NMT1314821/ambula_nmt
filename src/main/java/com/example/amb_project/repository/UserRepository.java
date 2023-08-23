package com.example.amb_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.amb_project.model.UserLocation;

public interface UserRepository extends JpaRepository<UserLocation,Long>
{
	List<UserLocation> findAllByOrderByLatitudeAscLongitudeAsc();
}
