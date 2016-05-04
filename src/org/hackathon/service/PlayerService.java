package org.hackathon.service;

import java.util.List;

import org.hackathon.domain.Player;

public interface PlayerService {
	
	void saveOrUpdate(Player player);
	
	List<Player> findAll();
	
	Player getById(int id);
	
	Player getByName(String name);

}
