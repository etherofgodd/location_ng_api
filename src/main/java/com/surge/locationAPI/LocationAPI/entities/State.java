package com.surge.locationAPI.LocationAPI.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "state",
        uniqueConstraints =
        @UniqueConstraint(
                name = "state_unique",
                columnNames = {
                        "state_name",
                        "state_capital"
                }
        )

)
public class State {

    @Id
    @SequenceGenerator(
            name = "state_sequence",
            sequenceName = "state_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "state_sequence"
    )
    private Long stateId;

    @Column(
            name = "state_name",
            nullable = false
    )
    private String stateName;

    @Column(
            name = "state_capital",
            nullable = false
    )
    private String stateCapital;


}
