package com.example.alertsnotificationsystem.controller;

import com.example.alertsnotificationsystem.model.Person;
import com.example.alertsnotificationsystem.repository.FireStationRepository;
import com.example.alertsnotificationsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PhoneAlertController {

    @Autowired
    private FireStationRepository fireStationRepository;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/phoneAlert")
    public List<String> getPhoneNumbersByFireStation(@RequestParam int stationNumber) {
        // Fetch persons associated with the given station number
        List<Person> people = personRepository.findByFireStationStationNumber(stationNumber);

        // Extract phone numbers from the people list
        return people.stream()
                .map(Person::getPhone) // Assuming you have a `getPhone` method in the Person class
                .collect(Collectors.toList());
    }
}
