package com.exam.railwayreservation.repository;

import com.exam.railwayreservation.entity.Station;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StationRepository extends CrudRepository<Station, Long> {
    List<Station> findAll();
    Station findByStationName(String stationName);
}
