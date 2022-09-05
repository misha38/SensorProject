package com.example.sensorproject.repositories;

import com.example.sensorproject.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, String> {
    Optional<Sensor> findByName(String name);
}
