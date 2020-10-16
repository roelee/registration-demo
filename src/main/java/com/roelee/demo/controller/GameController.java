package com.roelee.demo.controller;

import com.roelee.demo.form.GameForm;
import com.roelee.demo.model.Game;
import com.roelee.demo.repository.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("game")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @PostMapping(value="/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createGame(@RequestBody GameForm form) {
        Game data = new Game();
        BeanUtils.copyProperties(form, data);
        gameRepository.save(data);

        return new ResponseEntity<String>("create game success", HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Game>> gets() {
        List<Game> games = gameRepository.findAll();

        return new ResponseEntity<List<Game>>(games, HttpStatus.OK);
    }


}
