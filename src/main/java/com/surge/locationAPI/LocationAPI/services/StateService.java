package com.surge.locationAPI.LocationAPI.services;

import com.surge.locationAPI.LocationAPI.dto.StateRequest;
import com.surge.locationAPI.LocationAPI.entities.State;
import com.surge.locationAPI.LocationAPI.exceptions.ExtendedConstants;
import com.surge.locationAPI.LocationAPI.helpers.AppResponse;
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

    public AppResponse createState(StateRequest stateRequest) {
        AppResponse appResponse = new AppResponse();


        State state = State.builder()
                .stateName(stateRequest.getStateName())
                .stateSlug(stateRequest.getStateSlug())
                .stateCapital(stateRequest.getStateCapital())
                .build();
        stateRepository.save(state);
        appResponse.setMessage(ExtendedConstants.ResponseCode.SUCCESS.getDescription());
        appResponse.setStatus(ExtendedConstants.ResponseCode.SUCCESS.getCode());


        return appResponse;
    }

    public AppResponse getStates() {
        AppResponse appResponse = new AppResponse();
        List<State> stateList = stateRepository.findAll();
        System.out.println("stateList = " + stateList);


        appResponse.setMessage(ExtendedConstants.ResponseCode.SUCCESS.getDescription());
        appResponse.setStatus(ExtendedConstants.ResponseCode.SUCCESS.getCode());
        appResponse.setData(stateList);

        return appResponse;
    }

    public AppResponse getStatesByStateSlug(String stateSlug) {
        AppResponse appResponse = new AppResponse();


        State state = stateRepository.getStateByStateSlug(stateSlug);

        if (state != null) {
            appResponse.setMessage(ExtendedConstants.ResponseCode.SUCCESS.getDescription());
            appResponse.setStatus(ExtendedConstants.ResponseCode.SUCCESS.getCode());
            appResponse.setData(state);

        } else {
            appResponse.setMessage(ExtendedConstants.ResponseCode.ENTITY_NOT_FOUND.getDescription() + " FOR STATE WITH NAME " + stateSlug);
            appResponse.setStatus(ExtendedConstants.ResponseCode.ENTITY_NOT_FOUND.getCode());
        }


        return appResponse;
    }
}
