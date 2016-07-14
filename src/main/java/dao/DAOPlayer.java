package dao;

import java.util.GregorianCalendar;
import java.util.List;

import ro.ea.ja.teambook.domain.Category;
import ro.ea.ja.teambook.domain.Player;

public interface DAOPlayer
{

	// !READ! METHODS
	
	Player getPlayer(String email, String password);
	Player getPlayers();


	// !UPDATE! METHODS

	boolean updatePicture(String id, byte[] picture);
	boolean updateFirstName(String id, String firstName);
	boolean updateLastName(String id, String lastName);
	boolean updateBirthday(String id, GregorianCalendar birthday);
	boolean updateDepartment(String id, String department);
	boolean updatePosition(String id, String position);
	boolean updateGender(String id, String gender);
	boolean updateCategories(String id, List<Category> categories);


	// !CREATE! METHODS

	Player createPlayer(Player player);
	boolean approvePlayerActivity(String id);

	// !DELETE! METHODS

	boolean deletePlayer(String id);
	

	
}
