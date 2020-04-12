package com.exam.railwayreservation.repository;

import com.exam.railwayreservation.entity.Schedule;
import com.exam.railwayreservation.entity.Station;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {
    List<Schedule> findAll();
    List<Schedule> findAllByStationFromAndStationTo(Station stationFrom, Station stationTo);
}
