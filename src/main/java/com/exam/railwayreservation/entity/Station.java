package com.exam.railwayreservation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "stations")
public class Station {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "station_id")
    private Integer id;

    @Column(nullable=false, name = "station_name", unique = true)
    private String stationName;

    public Station() {
    }

    public Station(String stationName) {
        this.stationName = stationName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer stationId) {
        this.id = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
