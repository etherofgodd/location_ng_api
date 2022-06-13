package com.surge.locationAPI.LocationAPI.services;


import com.surge.locationAPI.LocationAPI.dto.LgaRequest;
import com.surge.locationAPI.LocationAPI.entities.LocalGovernmentArea;
import com.surge.locationAPI.LocationAPI.entities.State;
import com.surge.locationAPI.LocationAPI.exceptions.NotFoundException;
import com.surge.locationAPI.LocationAPI.repositories.LocalGovernmentAreaRepository;
import com.surge.locationAPI.LocationAPI.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalGovernmentAreasService {

    private final LocalGovernmentAreaRepository localGovernmentAreaRepository;
    private final StateRepository stateRepository;

    @Autowired
    LocalGovernmentAreasService(
            LocalGovernmentAreaRepository localGovernmentAreaRepository,
            StateRepository stateRepository
    ) {
        this.localGovernmentAreaRepository = localGovernmentAreaRepository;
        this.stateRepository = stateRepository;
    }

    public List<LocalGovernmentArea> getLga() {
        return localGovernmentAreaRepository.findAll();
    }

    public void createLga(LgaRequest lgaRequest) throws NotFoundException {
        State state = stateRepository.findById(lgaRequest.getStateId()).orElse(null);
        LocalGovernmentArea localGovernmentArea =
                LocalGovernmentArea.builder()
                        .name(lgaRequest.getName())
                        .state(state)
                        .build();
        if(state != null){
            localGovernmentAreaRepository.save(localGovernmentArea);
        }else{
            throw new NotFoundException("Invalid State id");
        }
    }

    public List<LocalGovernmentArea> getLocalGovernmentAreByStateId(Long stateId){
        return localGovernmentAreaRepository.getLocalGovernmentAreaByStateId(stateId);
    }
}
