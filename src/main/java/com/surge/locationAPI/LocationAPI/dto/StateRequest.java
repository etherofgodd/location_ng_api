package com.surge.locationAPI.LocationAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StateRequest {


    @NotNull(message = "State Name should not be null")
    @Size(min = 3, message = "State Name too short")
    @Size(max = 16, message = "State Name too long")
    private  String stateName;

    @NotNull(message = "State Capital should not be null")
    @Size(min = 3, message = "State Capital too short")
    @Size(max = 16, message = "State Capital too long")
    private String stateCapital;
}
