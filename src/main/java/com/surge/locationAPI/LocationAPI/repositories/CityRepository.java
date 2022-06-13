package com.surge.locationAPI.LocationAPI.repositories;


import com.surge.locationAPI.LocationAPI.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
