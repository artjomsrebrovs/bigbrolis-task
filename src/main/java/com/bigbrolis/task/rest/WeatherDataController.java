package com.bigbrolis.task.rest;

import com.bigbrolis.task.entity.WeatherDataDO;
import org.springframework.http.ResponseEntity;

public interface WeatherDataController {

    ResponseEntity<Iterable<WeatherDataDO>> getAllData();
}
