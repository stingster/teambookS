package dao;

import java.util.GregorianCalendar;
import java.util.List;

import ro.ea.ja.teambook.domain.Category;
import ro.ea.ja.teambook.domain.Player;

public class DAOPlayerImpl implements DAOPlayer
{

	@Override
	public Player getPlayer(String email, String password)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getPlayers()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePicture(String id, byte[] picture)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateFirstName(String id, String firstName)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLastName(String id, String lastName)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBirthday(String id, GregorianCalendar birthday)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDepartment(String id, String department)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePosition(String id, String position)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateGender(String id, String gender)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCategories(String id, List<Category> categories)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player createPlayer(Player player)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean approvePlayerActivity(String id)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePlayer(String id)
	{
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
