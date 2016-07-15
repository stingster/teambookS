package rest;

import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.DAOPlayerImpl;
import dao.DaoFactory;
import ro.ea.ja.teambook.domain.Category;
import ro.ea.ja.teambook.domain.Category.Type;
import ro.ea.ja.teambook.domain.Player;

@Path("/team")
public class PlayerResource
{
	private DAOPlayerImpl dao = DaoFactory.getDAOPlayer();

	// !READ! METHODS

	@POST // this is the login method
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlayer(String email, String password)
	{

		Player player = dao.getPlayer(email, password);

		return Response.status(200).entity(player).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlayers()
	{

		List<Player> players = dao.getPlayers();

		return Response.status(200).entity(players).build();
	}

	@Path("/{health}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPlayersByHealth()
	{

		List<Player> temp = dao.getPlayers();

		Collections.sort(temp, new Comparator<Player>()
		{
			@Override
			public int compare(Player o1, Player o2)
			{
				List<Category> categories = o1.getCategories();
				Category c1 = null;
				Category c2 = null;

				for (int i = 0; i < categories.size(); i++)
				{
					if (categories.get(i).getType().equals(Type.HEALTH))
					{
						c1 = categories.get(i);
						break;
					}
				}

				categories = o2.getCategories();

				for (int j = 0; j < categories.size(); j++)
				{
					if (categories.get(j).getType().equals(Type.HEALTH))
					{
						c2 = categories.get(j);
						break;
					}
				}

				return c1.getStars() - c2.getStars();
			}
		});

		List<Player> playersByHealth = Collections.unmodifiableList(temp);

		return Response.status(200).entity(playersByHealth).build();
	}

	@Path("/{TechnicalSkills}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPlayersByTechnicalSkills()
	{

		List<Player> temp = dao.getPlayers();

		Collections.sort(temp, new Comparator<Player>()
		{
			@Override
			public int compare(Player o1, Player o2)
			{
				List<Category> categories = o1.getCategories();
				Category c1 = null;
				Category c2 = null;

				for (int i = 0; i < categories.size(); i++)
				{
					if (categories.get(i).getType().equals(Type.TECH))
					{
						c1 = categories.get(i);
						break;
					}
				}

				categories = o2.getCategories();

				for (int j = 0; j < categories.size(); j++)
				{
					if (categories.get(j).getType().equals(Type.TECH))
					{
						c2 = categories.get(j);
						break;
					}
				}

				return c1.getStars() - c2.getStars();
			}
		});

		List<Player> playersByTechnicalSkills = Collections.unmodifiableList(temp);

		return Response.status(200).entity(playersByTechnicalSkills).build();
	}

	@Path("/{SocialSkills}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPlayersBySocialSkills()
	{

		List<Player> temp = dao.getPlayers();

		Collections.sort(temp, new Comparator<Player>()
		{
			@Override
			public int compare(Player o1, Player o2)
			{
				List<Category> categories = o1.getCategories();
				Category c1 = null;
				Category c2 = null;

				for (int i = 0; i < categories.size(); i++)
				{
					if (categories.get(i).getType().equals(Type.SOCIAL))
					{
						c1 = categories.get(i);
						break;
					}
				}

				categories = o2.getCategories();

				for (int j = 0; j < categories.size(); j++)
				{
					if (categories.get(j).getType().equals(Type.SOCIAL))
					{
						c2 = categories.get(j);
						break;
					}
				}

				return c1.getStars() - c2.getStars();
			}
		});

		List<Player> playersBySocialSkills = Collections.unmodifiableList(temp);

		return Response.status(200).entity(playersBySocialSkills).build();
	}

	@Path("/{SelfDevSkills}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPlayersBySelfDevSkills()
	{

		List<Player> temp = dao.getPlayers();

		Collections.sort(temp, new Comparator<Player>()
		{
			@Override
			public int compare(Player o1, Player o2)
			{
				List<Category> categories = o1.getCategories();
				Category c1 = null;
				Category c2 = null;

				for (int i = 0; i < categories.size(); i++)
				{
					if (categories.get(i).getType().equals(Type.SELFDEV))
					{
						c1 = categories.get(i);
						break;
					}
				}

				categories = o2.getCategories();

				for (int j = 0; j < categories.size(); j++)
				{
					if (categories.get(j).getType().equals(Type.SELFDEV))
					{
						c2 = categories.get(j);
						break;
					}
				}

				return c1.getStars() - c2.getStars();
			}
		});

		List<Player> playersBySelfDevSkills = Collections.unmodifiableList(temp);

		return Response.status(200).entity(playersBySelfDevSkills).build();
	}

	@Path("/{AllSkills}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPlayersBySelfAllSkills()
	{

		List<Player> temp = dao.getPlayers();

		Collections.sort(temp, new Comparator<Player>()
		{
			@Override
			public int compare(Player o1, Player o2)
			{
				List<Category> categories = o1.getCategories();
				int sum1 = 0;
				int sum2 = 0;

				for (int i = 0; i < categories.size(); i++)
				{
					sum1 += categories.get(i).getStars();
				}

				categories = o2.getCategories();

				for (int j = 0; j < categories.size(); j++)
				{
					sum2 = categories.get(j).getStars();
				}

				return sum1 - sum2;
			}
		});

		List<Player> playersByAllSkills = Collections.unmodifiableList(temp);

		return Response.status(200).entity(playersByAllSkills).build();
	}

	// !UPDATE! METHODS

	public Response updatePicture(String id, byte[] picture)
	{
		
		
		return Response.status(200).build();
	}

	public Response updateFirstName(String id, String firstName)
	{

		return Response.status(200).build();
	}

	public Response updateLastName(String id, String lastName)
	{

		return Response.status(200).build();
	}

	public Response updateBirthday(String id, GregorianCalendar birthday)
	{

		return Response.status(200).build();
	}

	public Response updateDepartment(String id, String department)
	{

		return Response.status(200).build();
	}

	public Response updatePosition(String id, String position)
	{

		return Response.status(200).build();
	}

	public Response updateGender(String id, String gender)
	{

		return Response.status(200).build();
	}

	public Response updateCategories(String id, List<Category> categories)
	{

		return Response.status(200).build();
	}

}
