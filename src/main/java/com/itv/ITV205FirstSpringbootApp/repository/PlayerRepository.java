package com.itv.ITV205FirstSpringbootApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itv.ITV205FirstSpringbootApp.model.Player;
@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
