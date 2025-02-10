package com.itv.ITV205FirstSpringbootApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.itv.ITV205FirstSpringbootApp.model.Player;
import com.itv.ITV205FirstSpringbootApp.repository.PlayerRepository;
@Service
public class PlayerService {
	@Autowired
	PlayerRepository playerRepository;

	public void addPlayer(Player p1) {
		playerRepository.save(p1);
		
	}

	public Player getPlayerById(int playerId) {
		return playerRepository.findById(playerId).get();
		
	}

	public List<Player> getAllPlayers() {
		
		return playerRepository.findAll();
	}

	public void updatePlayer(Player player) {
		Player dbValue =getPlayerById(player.getPlayerId());
		dbValue.setPlayerName(player.getPlayerName());
		dbValue.setPlayerEmail(player.getPlayerEmail());
		dbValue.setPlayerPhone(player.getPlayerPhone());
		dbValue.setPosition(player.getPosition());
		dbValue.setSkillLevel(player.getSkillLevel());
		dbValue.setTeamAffiliation(player.getTeamAffiliation());
		dbValue.setFitnessLevel(player.getFitnessLevel());
		dbValue.setPlayerBio(player.getPlayerBio());
		playerRepository.save(dbValue);
	}

	public void deletePlayer(int id) {
		playerRepository.delete(getPlayerById(id));
		
	}
}
