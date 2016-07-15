package dao;

import java.util.GregorianCalendar;
import java.util.List;

import ro.ea.ja.teambook.domain.Category;
import ro.ea.ja.teambook.domain.Player;

public class DAOPlayerImpl implements DAOPlayer
{

	// !READ! METHODS
	
	@Override
	public Player getPlayer(String email, String password)
	{
		
		return null;
	}

	@Override
	public List<Player> getPlayers()
	{
		
		return null;
	}

	
	
	// !UPDATE! METHODS
	
	@Override
	public boolean updatePicture(String id, byte[] picture)
	{	
		return false;
	}

	@Override
	public boolean updateFirstName(String id, String firstName)
	{	
		return false;
	}

	@Override
	public boolean updateLastName(String id, String lastName)
	{
		return false;
	}

	@Override
	public boolean updateBirthday(String id, GregorianCalendar birthday)
	{
		return false;
	}

	@Override
	public boolean updateDepartment(String id, String department)
	{
		return false;
	}

	@Override
	public boolean updatePosition(String id, String position)
	{
		return false;
	}

	@Override
	public boolean updateGender(String id, String gender)
	{
		return false;
	}

	@Override
	public boolean updateCategories(String id, List<Category> categories)
	{
		return false;
	}

	@Override
	public Player createPlayer(Player player)
	{	
		return null;
	}

	@Override
	public boolean approvePlayerActivity(String id)
	{
		return false;
	}

	@Override
	public boolean deletePlayer(String id)
	{
		return false;
	}
}
