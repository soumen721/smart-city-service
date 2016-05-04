package org.hackathon.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hackathon.dao.PlayerDao;
import org.hackathon.domain.Player;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDaoImpl implements PlayerDao{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	public void save(Player player) {
		sessionFactory.getCurrentSession().save(player);
		
	}

	public void update(Player player) {
		// TODO Auto-generated method stub
		
	}

	public List<Player> findAll() {
		sessionFactory.getCurrentSession().beginTransaction();
		List<Player> players = sessionFactory.getCurrentSession().createCriteria(Player.class).list();
		return players;
	}

	public Player getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Player getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
