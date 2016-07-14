package rest;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.client.ClientResponse;

import ro.ea.ja.teambook.domain.Category;
import ro.ea.ja.teambook.domain.Player;

@Path("/team")
public class PlayerResource
{

	// !READ! METHODS
	
	@POST          // this is the login method
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	public Response getPlayer(String email, String password){
		
		Player player = new Player();
		
		
		
		return Response.status(200).entity(player).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPlayers(){
		
		List<Player> players = new ArrayList<>();
		
		return Response.status(200).entity(players).build();
	}
	
	@Path("/{health}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPlayersByHealth(){
		
		List<Player> playersByHealth = new ArrayList<>();
		
		return Response.status(200).entity(playersByHealth).build();
	}
	
	@Path("/{TechnicalSkills}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPlayersByTechnicalSkills(){
		
		List<Player> playersByHealth = new ArrayList<>();
		
		return Response.status(200).entity(playersByHealth).build();
	}
	
	@Path("/{SocialSkills}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPlayersBySocialSkills(){
		
		List<Player> playersByHealth = new ArrayList<>();
		
		return Response.status(200).entity(playersByHealth).build();
	}
	
	@Path("/{SelfDevSkills}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPlayersBySelfDevSkills(){
		
		List<Player> playersByHealth = new ArrayList<>();
		
		return Response.status(200).entity(playersByHealth).build();
	}
	
	@Path("/{AllSkills}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPlayersBySelfAllSkills(){
		
		List<Player> playersByHealth = new ArrayList<>();
		
		return Response.status(200).entity(playersByHealth).build();
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
