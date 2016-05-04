package org.hackathon.service.impl;

import java.util.List;

import org.hackathon.dao.PlayerDao;
import org.hackathon.dao.impl.PlayerDaoImpl;
import org.hackathon.domain.Player;
import org.hackathon.service.PlayerService;

public class PlayerServiceImpl implements PlayerService{
	
	PlayerDao playerDao = new PlayerDaoImpl();

	@Override
	public void saveOrUpdate(Player player) {
		if(player.isNew()){
			playerDao.save(player);
		}else{
			playerDao.update(player);
		}
		
	}

	@Override
	public List<Player> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
