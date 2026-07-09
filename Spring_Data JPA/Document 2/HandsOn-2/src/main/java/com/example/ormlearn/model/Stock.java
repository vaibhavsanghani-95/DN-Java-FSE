package com.example.ormlearn.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "stock")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "st_id")
    private int id;

    @Column(name = "st_code")
    private String code;

    @Column(name = "st_date")
    private LocalDate date;

    @Column(name = "st_open")
    private double open;

    @Column(name = "st_close")
    private double close;

    @Column(name = "st_volume")
    private long volume;
}
