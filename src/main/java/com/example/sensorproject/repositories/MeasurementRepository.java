package com.example.sensorproject.repositories;

import com.example.sensorproject.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
}
