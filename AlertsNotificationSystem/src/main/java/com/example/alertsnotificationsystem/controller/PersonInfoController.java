package com.example.alertsnotificationsystem.controller;

import com.example.alertsnotificationsystem.model.Person;
import com.example.alertsnotificationsystem.model.PersonInfoDTO;
import com.example.alertsnotificationsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PersonInfoController {

    @Autowired
    private PersonRepository personRepository;

    // Endpoint to retrieve person's details by first name and last name
    @GetMapping("/personInfo")
    public List<PersonInfoDTO> getPersonInfo(@RequestParam String firstName, @RequestParam String lastName) {
        // Fetch persons by first and last name
        List<Person> persons = personRepository.findByFirstNameAndLastName(firstName, lastName);

        // Log the persons and their medications (for debugging purposes)
        persons.forEach(person -> {
            System.out.println("Person: " + person.getFirstName() + " " + person.getLastName());
            if (person.getMedications() != null && !person.getMedications().isEmpty()) {
                String[] medications = person.getMedications().split(",");
                String[] dosages = person.getDosages().split(",");
                for (int i = 0; i < medications.length; i++) {
                    System.out.println("Medication: " + medications[i] + " - " + dosages[i]);
                }
            } else {
                System.out.println("No medications found for this person.");
            }
        });

        // Map the person data to PersonInfoDTO, including age and allergies
        return persons.stream()
                .map(person -> new PersonInfoDTO(
                        person.getFirstName(),
                        person.getLastName(),
                        person.getEmail(),
                        person.getAddress() != null ? person.getAddress().getAddressLine() : "",  // Check if address is null
                        person.getMedications() != null && !person.getMedications().isEmpty() ?
                                person.getMedications() + " - " + person.getDosages() :
                                "No medications found",
                        person.getAge(),  // Add age to the DTO
                        person.getAllergies()  // Add allergies to the DTO
                ))
                .collect(Collectors.toList());
    }
}
