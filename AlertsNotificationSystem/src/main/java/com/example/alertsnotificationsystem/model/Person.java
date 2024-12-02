package com.example.alertsnotificationsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private int age;
    @Getter
    @Setter
    private String phone;
    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")  // Define the foreign key column
    private Address address;  // One address for many people

    @Setter
    @Getter
    private String medications;

    @Getter
    @Setter
    private String dosages;

    @Setter
    @Getter
    private String allergies;

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fire_station_id")
    private FireStation fireStation;

    public Person(String firstName, String lastName, int age, String phone, String email, Address address) {

    }

    public Person() {}

    public Person(String firstName, String lastName, int age, String phone, String email) {
    }


    public void setAddress(String s, String halifax) {
    }

    public void setMedications(String heartMedication, String s) {
    }

    public Person(Long id, String firstName, String lastName, int age, String phone, String email, Address address, String medications, String dosages, String allergies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.medications = medications;
        this.dosages = dosages;
        this.allergies = allergies;
    }
}
