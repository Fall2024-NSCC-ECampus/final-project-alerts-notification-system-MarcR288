package com.example.alertsnotificationsystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String addressLine;
    private String city;


    @OneToMany(mappedBy = "address")
    private List<Person> persons;


//    @Getter
//    @Setter
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fire_station_id", insertable = false, updatable = false) // Mapping to FireStation
//    private FireStation fireStation; // This creates the relationship


    public Address(String addressLine, String city) {
        this.addressLine = addressLine;
        this.city = city;
    }

    public Address() {}


}
