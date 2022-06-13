package com.surge.locationAPI.LocationAPI.repositories;

import com.surge.locationAPI.LocationAPI.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}
