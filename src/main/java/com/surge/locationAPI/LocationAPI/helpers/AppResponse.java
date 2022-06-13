package com.surge.locationAPI.LocationAPI.helpers;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppResponse<T> {

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("data")
    private List<T> data;

    @JsonProperty("message")
    private String message;

    public AppResponse(Boolean success, List<T> data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }


    @Override
    public String toString() {
        return "AppResponse{" +
                "success='" + success + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
