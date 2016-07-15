package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


import ro.ea.ja.teambook.domain.Category;
import ro.ea.ja.teambook.domain.InvalidRegexExpressionException;
import ro.ea.ja.teambook.domain.Player;

public class DAOPlayerImpl implements DAOPlayer {

	// !READ! METHODS

	@Override
	public Player getPlayer(String email, String password) {
		Connection conn = DaoFactory.getConnection();
		Player player = null;
		String querry = "SELECT * FROM player p, categories c WHERE p.id = d.id AND email='" + email + "'AND pass='"
				+ password + "';";
		PreparedStatement statement = null;
		ResultSet set = null;
		try {
			statement = conn.prepareStatement(querry);
			set = statement.executeQuery();
			while (set.next()) {
				player = new Player();
				Date date = set.getDate("birthday");
				Calendar cal = new GregorianCalendar();
				cal.setTime(date);
				player.setBirthday((GregorianCalendar) cal);
				player.setEmail(set.getString("EMAIL"));
				player.setFirstName(set.getString("first_name"));
				player.setFirstName(set.getString("last_name"));
				player.setGender(set.getString(set.getString("gender")));
				// player.setPicture("mockup");
			}
			return player;
		} catch (SQLException | InvalidRegexExpressionException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return player;
	}

	@Override
	public List<Player> getPlayers() {

		return null;
	}

	// !UPDATE! METHODS

	@Override
	public boolean updatePicture(String id, byte[] picture) {
		return false;
	}

	@Override
	public boolean updateFirstName(String id, String firstName) {
		return false;
	}

	@Override
	public boolean updateLastName(String id, String lastName) {
		return false;
	}

	@Override
	public boolean updateBirthday(String id, GregorianCalendar birthday) {
		return false;
	}

	@Override
	public boolean updateDepartment(String id, String department) {
		return false;
	}

	@Override
	public boolean updatePosition(String id, String position) {
		return false;
	}

	@Override
	public boolean updateGender(String id, String gender) {
		return false;
	}

	@Override
	public boolean updateCategories(String id, List<Category> categories) {
		return false;
	}

	@Override
	public Player createPlayer(Player player) {
		return null;
	}

	@Override
	public boolean approvePlayerActivity(String id) {
		return false;
	}

	@Override
	public boolean deletePlayer(String id) {
		return false;
	}
}
