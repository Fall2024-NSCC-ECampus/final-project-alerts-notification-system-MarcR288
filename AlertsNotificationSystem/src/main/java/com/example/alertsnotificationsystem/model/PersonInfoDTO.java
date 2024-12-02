package com.example.alertsnotificationsystem.model;

import lombok.Getter;
import lombok.Setter;

public class PersonInfoDTO {

    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String address;
    @Getter
    @Setter
    private String medicationsAndDosages;
    @Getter
    @Setter
    private int age;  // Add age field
    @Getter
    @Setter
    private String allergies;  // Add allergies field

    // Constructor
    public PersonInfoDTO(String firstName, String lastName, String email, String address, String medicationsAndDosages, int age, String allergies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.medicationsAndDosages = medicationsAndDosages;
        this.age = age;
        this.allergies = allergies;
    }

}
