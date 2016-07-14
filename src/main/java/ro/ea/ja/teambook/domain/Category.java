package ro.ea.ja.teambook.domain;

import java.io.IOException;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

enum Type
{
	HEALTH, SOCIAL, TECH, SELFDEV
}

@XmlRootElement
public class Category
{
	public enum Type
	{
		HEALTH, SOCIAL, TECH, SELFDEV
	}
	
	private int stars;
	private Type type;
	private List<Activity> activities;

	public synchronized int getStars()
	{
		return stars;
	}

	public synchronized void setStars(int stars) throws IOException
	{
		if (stars <= 7 && stars >= 1)
		{
			this.stars = stars;
		}
		else
		{
			throw new IOException();
		}
	}

	public synchronized Type getType()
	{
		return type;
	}

	public synchronized void setType(Type type)
	{
		this.type = type;
	}

	public synchronized List<Activity> getActivities()
	{
		return activities;
	}

	public synchronized void setActivities(List<Activity> activities)
	{
		this.activities = activities;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activities == null) ? 0 : activities.hashCode());
		result = prime * result + stars;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (activities == null)
		{
			if (other.activities != null)
				return false;
		}
		else if (!activities.equals(other.activities))
			return false;
		if (stars != other.stars)
			return false;
		if (type != other.type)
			return false;
		return true;
	}


}
