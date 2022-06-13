package com.surge.locationAPI.LocationAPI.controllers;


import com.surge.locationAPI.LocationAPI.dto.StateRequest;
import com.surge.locationAPI.LocationAPI.entities.State;
import com.surge.locationAPI.LocationAPI.helpers.AppResponse;
import com.surge.locationAPI.LocationAPI.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/api/v1")
public class StateController {


    private final StateService stateService;

    @Autowired
    StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @PostMapping("/createState")
    public ResponseEntity<AppResponse<String>> createState(@RequestBody @Valid StateRequest stateRequest) {
        stateService.createState(stateRequest);
        return new ResponseEntity<>(
                new AppResponse<>(
                        true,
                        null,
                        "State Saved Successfully"
                ),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/states")
    public ResponseEntity<AppResponse<State>> getStates() {
        List<State> stateList = stateService.getStates();

        return new ResponseEntity<>(
                new AppResponse<>(
                        true,
                        stateList,
                        "State Retrieved Successfully"
                ),
                HttpStatus.OK
        );
    }
}
