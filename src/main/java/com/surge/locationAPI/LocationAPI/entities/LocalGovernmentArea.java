package com.surge.locationAPI.LocationAPI.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocalGovernmentArea {

    @Id
    @SequenceGenerator(
            name = "localGovernmentArea_sequence",
            sequenceName = "localGovernmentArea_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "localGovernmentArea_sequence"
    )
    private  Long localGovernmentAreaId;


    private String name;

    @ManyToOne
    @JoinColumn(
            name = "state_id",
            referencedColumnName = "stateId"
    )
    private State state;




}
