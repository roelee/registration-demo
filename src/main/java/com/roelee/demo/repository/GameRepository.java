package com.roelee.demo.repository;

import com.roelee.demo.model.Game;
import com.roelee.demo.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
