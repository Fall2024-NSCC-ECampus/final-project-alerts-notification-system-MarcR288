package com.example.alertsnotificationsystem.controller;

import com.example.alertsnotificationsystem.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommunityEmailController {

    private final PersonService personService;

    @Autowired
    public CommunityEmailController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/communityEmail")
    public ResponseEntity<List<String>> getCommunityEmail(@RequestParam String city) {
        List<String> emails = personService.getEmailsByCity(city);

        if (emails.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(emails);
    }

}
