package com.exam.railwayreservation.controller;

import com.exam.railwayreservation.entity.Schedule;
import com.exam.railwayreservation.entity.Station;
import com.exam.railwayreservation.entity.Transaction;
import com.exam.railwayreservation.repository.ScheduleRepository;
import com.exam.railwayreservation.repository.StationRepository;
import com.exam.railwayreservation.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    StationRepository stationRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/stations")
    public List<Station> getAllStations(){
        return stationRepository.findAll();
    }

    @GetMapping("/stations/{stationName}")
    public Station getAllStations(@PathVariable String stationName){
        return stationRepository.findByStationName(stationName);
    }

    @GetMapping("/schedules")
    public List<Schedule> getAllSchedules(){
        return scheduleRepository.findAll();
    }

    @GetMapping(path ="/schedules/{fromStation}/{toStation}")
    List<Schedule> getAllSchedulesForSelectedCities(@PathVariable String fromStation, @PathVariable String toStation) {
        Station stationFrom = stationRepository.findByStationName(fromStation);
        Station stationTo = stationRepository.findByStationName(toStation);
        return scheduleRepository.findAllByStationFromAndStationTo(stationFrom, stationTo);
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    @PostMapping("/transaction")
    public String purchaseTicket(@RequestBody Transaction transaction) {
        transactionRepository.save(transaction);
        return "Purchase Successfull";
    }

}
