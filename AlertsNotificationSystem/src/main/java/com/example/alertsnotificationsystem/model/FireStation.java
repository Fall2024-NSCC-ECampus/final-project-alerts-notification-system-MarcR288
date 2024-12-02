package com.example.alertsnotificationsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class FireStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "station_number")
    private int stationNumber;

    @ManyToOne
    //@JoinColumn(name = "person_id")
    @Getter
    @Setter
    private Person person;

    @OneToMany(mappedBy = "fireStation")
    @Getter
    @Setter
    private List<Person> people;


    @Setter
    @Getter
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;



    public FireStation(int stationNumber) {
        this.stationNumber = stationNumber;
    }

    public FireStation() {}

    public FireStation(Person person, Address address) {
    }

    // Constructor, getters and setters
    public FireStation(Person person, Address address, int stationNumber) {
        this.person = person;
        this.address = address;
        this.stationNumber = stationNumber;  // Set station number in the constructor
    }
}
