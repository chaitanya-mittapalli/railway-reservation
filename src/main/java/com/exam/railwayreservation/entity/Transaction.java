package com.exam.railwayreservation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trasactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "transaction_id")
    private Integer id;

    @Column(nullable = false)
    private String customerName;

    @OneToOne()
    @JoinColumn(name = "stationid_from", referencedColumnName = "station_id")
    private Station stationFrom;

    @OneToOne()
    @JoinColumn(name = "stationid_to", referencedColumnName = "station_id")
    private Station stationto;

    @Column(nullable = false)
    private String scheduledTime;

    private Double ticketPrice;

    private Date travelDate;
}
