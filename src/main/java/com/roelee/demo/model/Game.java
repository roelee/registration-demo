package com.roelee.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
public class Game {

    @Id
    private Long id;
    private LocalDate mdate;
    private String stadium;
    private String team1;
    private String team2;

}
