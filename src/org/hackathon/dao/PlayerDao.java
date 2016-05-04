package org.hackathon.dao;

import java.util.List;

import org.hackathon.domain.Player;

public interface PlayerDao {
	
	void save(Player player);
	
	void update(Player player);
	
	List<Player> findAll();
	
	Player getById(int id);
	
	Player getByName(String name);

}
