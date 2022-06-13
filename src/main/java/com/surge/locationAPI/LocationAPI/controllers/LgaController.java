package com.surge.locationAPI.LocationAPI.controllers;

import com.surge.locationAPI.LocationAPI.dto.LgaRequest;
import com.surge.locationAPI.LocationAPI.entities.LocalGovernmentArea;
import com.surge.locationAPI.LocationAPI.exceptions.NotFoundException;
import com.surge.locationAPI.LocationAPI.helpers.AppResponse;
import com.surge.locationAPI.LocationAPI.services.LocalGovernmentAreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class LgaController {

    public final LocalGovernmentAreasService localGovernmentAreasService;

    @Autowired
    LgaController(LocalGovernmentAreasService localGovernmentAreasService) {
        this.localGovernmentAreasService = localGovernmentAreasService;
    }

    @PostMapping("/createLga")
    public ResponseEntity<AppResponse<String>> createState(@RequestBody @Valid LgaRequest lgaRequest) throws NotFoundException {

        localGovernmentAreasService.createLga(lgaRequest);
        return new ResponseEntity<>(
                new AppResponse<>(
                        true,
                        null,
                        "Lga Saved Successfully"
                ),
                HttpStatus.CREATED
        );
    }


    @GetMapping("/lga")
    public ResponseEntity<AppResponse<LocalGovernmentArea>> createState() {

        List<LocalGovernmentArea> localGovernmentAreaList = localGovernmentAreasService.getLga();
        return new ResponseEntity<>(
                new AppResponse<>(
                        true,
                        localGovernmentAreaList,
                        "Lga Retrieved Successfully"
                ),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/lga/{stateId}")
    public ResponseEntity<AppResponse<LocalGovernmentArea>> getLgaByStateId(@PathVariable Long stateId){
        List<LocalGovernmentArea> localGovernmentAreas =
                localGovernmentAreasService.getLocalGovernmentAreByStateId(stateId);

        return new ResponseEntity<>(
                new AppResponse<>(
                        true,
                        localGovernmentAreas,
                        "Lga Retrieved Successfully"
                ),
                HttpStatus.CREATED
        );
    }
}
