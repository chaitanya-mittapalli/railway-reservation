package com.exam.railwayreservation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "schedules")
public class Schedule {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "schedule_id")
    private Integer id;

    @OneToOne()
    @JoinColumn(name = "stationid_from", referencedColumnName = "station_id")
    private Station stationFrom;

    @OneToOne()
    @JoinColumn(name = "stationid_to", referencedColumnName = "station_id")
    private Station stationTo;

    @Column(nullable=false)
    private String scheduledTime;

    private Double ticketPrice;

    private String travelDate;
}
