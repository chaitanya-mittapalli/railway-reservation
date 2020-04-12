package com.exam.railwayreservation;

import com.exam.railwayreservation.entity.Schedule;
import com.exam.railwayreservation.entity.Station;
import com.exam.railwayreservation.entity.Transaction;
import com.exam.railwayreservation.repository.ScheduleRepository;
import com.exam.railwayreservation.repository.StationRepository;
import com.exam.railwayreservation.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(StationRepository stationRepository, ScheduleRepository scheduleRepository, TransactionRepository transactionRepository) {
        return (args) -> {
            // save a few Stattions
            stationRepository.save(Station.builder().stationName("NewYork").build());
            stationRepository.save(Station.builder().stationName("Chicago").build());
            stationRepository.save(Station.builder().stationName("Boston").build());

            // fetch all stations
            log.info("Stations found with findAll():");
            log.info("-------------------------------");
            List<Station> stations = stationRepository.findAll();
            for (Station customer : stations) {
                log.info(customer.toString());
            }
            log.info("");

            //New York // Chicago Schedules
            Schedule s1= Schedule.builder().stationFrom(stations.get(0)).stationTo(stations.get(1)).scheduledTime("06.00").ticketPrice(100.0).build();
            Schedule s2= Schedule.builder().stationFrom(stations.get(1)).stationTo(stations.get(0)).scheduledTime("09.30").ticketPrice(110.0).build();
            scheduleRepository.save(s1);
            scheduleRepository.save(s2);
            //New York // Boston Schedules
            Schedule s3= Schedule.builder().stationFrom(stations.get(0)).stationTo(stations.get(2)).scheduledTime("13.10").ticketPrice(56.0).build();
            Schedule s4= Schedule.builder().stationFrom(stations.get(2)).stationTo(stations.get(0)).scheduledTime("16.30").ticketPrice(61.0).build();
            scheduleRepository.save(s3);
            scheduleRepository.save(s4);
            //Chicago // Boston Schedules
            Schedule s5= Schedule.builder().stationFrom(stations.get(1)).stationTo(stations.get(2)).scheduledTime("10.00").ticketPrice(72.0).build();
            Schedule s6= Schedule.builder().stationFrom(stations.get(2)).stationTo(stations.get(1)).scheduledTime("13.30").ticketPrice(82.0).build();
            scheduleRepository.save(s5);
            scheduleRepository.save(s6);

            List<Schedule> schedules = scheduleRepository.findAll();
            // fetch all Schedules
            log.info("Scheules found with findAll():");
            log.info("-------------------------------");
            for (Schedule schedule : schedules) {
                log.info(schedule.toString());
            }
            log.info("");

            // Now Insert a Transaction
            Date currentDate = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(currentDate);
            c.add(Calendar.DAY_OF_MONTH, 7);
            // convert calendar to date
            Date currentDatePlusSevenDays = c.getTime();
            Transaction t1 = Transaction.builder().customerName("Raju").scheduledTime(s1.getScheduledTime())
                                        .stationFrom(s1.getStationFrom()).stationto(s1.getStationTo()).ticketPrice(s1.getTicketPrice())
                                        .travelDate(new java.sql.Date(currentDatePlusSevenDays.getTime())).build();

            transactionRepository.save(t1);
            // fetch all Transactions
            List<Transaction> transactions = transactionRepository.findAll();
            log.info("Transactions found with findAll():");
            log.info("-------------------------------");
            for (Transaction transaction : transactions) {
                log.info(transaction.toString());
            }
            log.info("");
        };
    }
}
