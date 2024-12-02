package com.example.alertsnotificationsystem.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FireStationResponseDTO {
    private int fireStationNumber;
    private List<PersonDTO> residents;

    public FireStationResponseDTO(int fireStationNumber, List<PersonDTO> residents) {
        this.fireStationNumber = fireStationNumber;
        this.residents = residents;
    }
}
