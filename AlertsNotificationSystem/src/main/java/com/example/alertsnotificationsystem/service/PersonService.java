package com.example.alertsnotificationsystem.service;

import com.example.alertsnotificationsystem.model.Person;
import com.example.alertsnotificationsystem.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<String> getEmailsByCity(String city) {
        List<Person> peopleInCity = personRepository.findByAddress_City(city);

        return peopleInCity.stream()
                .map(Person::getEmail)
                .collect(Collectors.toList());
    }
}
