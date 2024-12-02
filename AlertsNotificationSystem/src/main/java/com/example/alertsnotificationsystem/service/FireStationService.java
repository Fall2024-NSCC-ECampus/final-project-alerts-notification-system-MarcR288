package com.example.alertsnotificationsystem.service;

import com.example.alertsnotificationsystem.model.*;
import com.example.alertsnotificationsystem.repository.FireStationRepository;
import com.example.alertsnotificationsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FireStationService {

    private final FireStationRepository fireStationRepository;
    private final PersonRepository personRepository;

    @Autowired
    public FireStationService(FireStationRepository fireStationRepository, PersonRepository personRepository) {
        this.fireStationRepository = fireStationRepository;
        this.personRepository = personRepository;
    }

    public FireStationResponseDTO getFireStationAndResidentsByAddress(Address address) {
        // Get the fire station number
        FireStation fireStation = (FireStation) fireStationRepository.findByAddress(address);

        // Get the list of people at the given address
        List<Person> people = personRepository.findByAddress(address);

        // Convert the list of people to DTOs
        List<PersonDTO> personDTOs = people.stream()
                .map(person -> new PersonDTO(
                        person.getFirstName(),
                        person.getLastName(),
                        person.getPhone(),
                        person.getAge(),
                        person.getMedications().toString(),
                        person.getAllergies()))
                .collect(Collectors.toList());

        // Return the response
        return new FireStationResponseDTO(fireStation.getStationNumber(), personDTOs);
    }
}
