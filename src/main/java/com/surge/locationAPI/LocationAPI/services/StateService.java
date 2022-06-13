package com.surge.locationAPI.LocationAPI.services;

import com.surge.locationAPI.LocationAPI.dto.StateRequest;
import com.surge.locationAPI.LocationAPI.entities.State;
import com.surge.locationAPI.LocationAPI.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    private final StateRepository stateRepository;

    @Autowired
    StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public void createState(StateRequest stateRequest) {
        State state = State.builder()
                .stateName(stateRequest.getStateName())
                .stateCapital(stateRequest.getStateCapital())
                .build();
        stateRepository.save(state);
    }

    public List<State> getStates() {
        return stateRepository.findAll();
    }
}
