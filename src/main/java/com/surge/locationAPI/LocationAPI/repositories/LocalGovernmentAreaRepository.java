package com.surge.locationAPI.LocationAPI.repositories;

import com.surge.locationAPI.LocationAPI.entities.LocalGovernmentArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalGovernmentAreaRepository extends JpaRepository<LocalGovernmentArea, Long> {

    @Query("" +
            "select localGovernmentArea " +
            "from LocalGovernmentArea localGovernmentArea " +
            "where localGovernmentArea.state.stateId =:stateId " +
            ""
    )
    List<LocalGovernmentArea> getLocalGovernmentAreaByStateId(Long stateId);
}
