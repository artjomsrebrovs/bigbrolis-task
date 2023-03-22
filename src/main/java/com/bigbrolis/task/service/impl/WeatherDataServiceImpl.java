package com.bigbrolis.task.service.impl;

import com.bigbrolis.task.entity.WeatherDataDO;
import com.bigbrolis.task.kafka.consumer.impl.KafkaConsumerImpl;
import com.bigbrolis.task.repository.WeatherDataRepository;
import com.bigbrolis.task.service.WeatherDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerImpl.class);

    private final WeatherDataRepository weatherDataRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public WeatherDataServiceImpl(final WeatherDataRepository weatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.findAndRegisterModules();
    }

    @Override
    public void saveWeatherData(final String data) {
        final Optional<WeatherDataDO> optionalWeatherData = map(data);
        optionalWeatherData.ifPresent(weatherDataRepository::save);
        logger.debug("Weather data saved successfully...");
    }

    private Optional<WeatherDataDO> map(final String string) {
        Optional<WeatherDataDO> optionalWeatherData;

        try {
            optionalWeatherData = Optional.of(objectMapper.readValue(string, WeatherDataDO.class));

        } catch (JsonProcessingException e) {
            logger.error("Cannon parse data, skipping...", e);
            optionalWeatherData = Optional.empty();
        }

        return optionalWeatherData;
    }

    @Override
    public Iterable<WeatherDataDO> getAllData() {
        return weatherDataRepository.findAll();
    }
}
