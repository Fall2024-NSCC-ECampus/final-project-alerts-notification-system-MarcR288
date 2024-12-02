package com.example.alertsnotificationsystem.controller;
import com.example.alertsnotificationsystem.model.Person;
import com.example.alertsnotificationsystem.model.ChildAlertDTO;
import com.example.alertsnotificationsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ChildAlertController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/childAlert")
    public List<ChildAlertDTO> getChildrenByAddress(@RequestParam String address) {
        // Find all persons by address
        List<Person> personsAtAddress = personRepository.findByAddress_AddressLine(address);  // Adjust according to how Address is structured

        // Filter children (age < 18)
        List<Person> childrenAtAddress = personsAtAddress.stream()
                .filter(person -> person.getAge() < 18)
                .collect(Collectors.toList());

        // If no children are found, return an empty list or empty string
        if (childrenAtAddress.isEmpty()) {
            return List.of();  // Returning an empty list if no children are found
        }

        // For each child, get the other persons living at the same address
        return childrenAtAddress.stream()
                .map(child -> {
                    // Get the list of other persons at the address
                    List<String> otherPersons = personsAtAddress.stream()
                            .filter(person -> !person.getId().equals(child.getId()))  // Exclude the current child
                            .map(person -> person.getFirstName() + " " + person.getLastName())
                            .collect(Collectors.toList());

                    // Create a DTO for each child
                    return new ChildAlertDTO(
                            child.getFirstName(),
                            child.getLastName(),
                            child.getAge(),
                            otherPersons
                    );
                })
                .collect(Collectors.toList());
    }
}
