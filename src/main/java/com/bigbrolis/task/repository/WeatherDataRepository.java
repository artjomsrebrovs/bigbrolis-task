package com.bigbrolis.task.repository;

import com.bigbrolis.task.entity.WeatherDataDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherDataRepository extends CrudRepository<WeatherDataDO, Long> {
}
