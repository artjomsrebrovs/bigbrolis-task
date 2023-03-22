package com.bigbrolis.task.rest.impl;

import com.bigbrolis.task.entity.WeatherDataDO;
import com.bigbrolis.task.rest.WeatherDataController;
import com.bigbrolis.task.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherDataControllerImpl implements WeatherDataController {

    private final WeatherDataService weatherDataService;

    @Autowired
    public WeatherDataControllerImpl(final WeatherDataService weatherDataService) {
        this.weatherDataService = weatherDataService;
    }

    @Override
    @GetMapping("/data")
    public ResponseEntity<Iterable<WeatherDataDO>> getAllData() {
        return new ResponseEntity<>(weatherDataService.getAllData(), HttpStatus.OK);
    }
}
