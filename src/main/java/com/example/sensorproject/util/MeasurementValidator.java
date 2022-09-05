package com.example.sensorproject.util;


import com.example.sensorproject.models.Measurement;
import com.example.sensorproject.services.SensorService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class MeasurementValidator implements Validator {

    private final SensorService sensorService;

    public MeasurementValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Measurement.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Measurement measurement = (Measurement) target;

        if (measurement.getSensor() == null) {
            return;
        }

        if (sensorService.findByName(measurement.getSensor().getName()).isEmpty()) {
            errors.rejectValue("sensor", "No such sensor registered");
        }
    }
}
