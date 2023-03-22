package com.bigbrolis.task.service;

import com.bigbrolis.task.entity.WeatherDataDO;

public interface WeatherDataService {

    void saveWeatherData(String data);

    Iterable<WeatherDataDO> getAllData();
}
