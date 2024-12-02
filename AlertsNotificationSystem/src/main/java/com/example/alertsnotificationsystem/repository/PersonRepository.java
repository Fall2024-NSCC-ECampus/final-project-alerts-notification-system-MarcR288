package com.example.alertsnotificationsystem.repository;

import com.example.alertsnotificationsystem.model.Address;
import com.example.alertsnotificationsystem.model.FireStation;
import com.example.alertsnotificationsystem.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByAddress_City(String city);

    List<Person> findByAddress(Address address);

    List<Person> findByFirstNameAndLastName(String firstName, String lastName);

    List<Person> findByAddress_AddressLine(String addressLine);

    List<Person> findByFireStationStationNumber(@Param("stationNumber") int stationNumber);
}
