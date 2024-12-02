package com.example.alertsnotificationsystem.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class PersonDTO {
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private int age;
    private List<String> medications;
    private String allergies;

    public PersonDTO(String firstname, String lastname, String phoneNumber, int age, String medications, String allergies) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.medications = Collections.singletonList(medications);
        this.allergies = allergies;
    }


}
