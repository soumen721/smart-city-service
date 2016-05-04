
package org.hackathon.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hackathon.dao.UserDao;
import org.hackathon.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public boolean isValidUser(User user) {
		String sql = "SELECT * FROM user_dtls WHERE user_id = ? and password= ?  limit 1";

		/*User fetchUser = (User) jdbcTemplate.queryForObject(sql, new Object[] { user.getUserId(), user.getPassword() },
				new BeanPropertyRowMapper(User.class));
*/
		List<User> users = jdbcTemplate.query(sql, new Object[] { user.getUserId(), user.getPassword() }, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rownumber) throws SQLException {
				User e = new User();
				e.setUserId(rs.getString("user_id"));
				e.setName(rs.getString("user_firstname") + rs.getString("user_surname"));
				e.setPassword(rs.getString("password"));
				return e;
			}
		});

		return users != null && !users.isEmpty() ? true : false;

	}

	public String addUser(User user) {

		String sql = "INSERT INTO PLAYER(NAME, AGE, MATCHES) VALUES(?, ?, ?)";
		int returnValue = 1;// getJdbcTemplate().update( sql, new Object[] {
							// user.getUserId(), player.getAge(),
							// player.getMatches() });

		if (1 == returnValue)
			return "Player creation is SUCCESS";
		else
			return "Player creation is FAILURE";
	}

}
