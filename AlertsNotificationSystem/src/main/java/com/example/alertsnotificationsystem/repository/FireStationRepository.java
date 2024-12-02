package com.example.alertsnotificationsystem.repository;

import com.example.alertsnotificationsystem.model.Address;
import com.example.alertsnotificationsystem.model.FireStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FireStationRepository extends JpaRepository<FireStation, Long> {

    public List<FireStation> findByAddress(Address address);

    FireStation findByStationNumber(int stationNumber);
}
