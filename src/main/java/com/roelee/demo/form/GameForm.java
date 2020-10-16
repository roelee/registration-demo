package com.roelee.demo.form;

import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class GameForm {

    private Long id;
    private LocalDate mdate;
    private String stadium;
    private String team1;
    private String team2;

}
