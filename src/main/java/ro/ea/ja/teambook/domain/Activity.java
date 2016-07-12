package ro.ea.ja.teambook.domain;

import javax.xml.bind.annotation.XmlRootElement;

enum Dificulty
{
	GRADE_A(5), GRADE_B(10), GRADE_C(15);

	private int grade;

	Dificulty(int grade)
	{
		this.grade = grade;
	}
	public int getGrade()
	{
		return this.grade;
	}
}

@XmlRootElement
public class Activity
{
	private String description;
	private Dificulty dificulty;
	private boolean isChecked;
	
	public synchronized String getDescription()
	{
		return description;
	}
	
	public synchronized void setDescription(String description)
	{
		this.description = description;
	}
	
	public synchronized Dificulty getDificulty()
	{
		return dificulty;
	}
	
	public synchronized void setDificulty(Dificulty dificulty)
	{
		this.dificulty = dificulty;
	}
	
	public synchronized boolean isChecked()
	{
		return isChecked;
	}
	
	public synchronized void setChecked(boolean isChecked)
	{
		this.isChecked = isChecked;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((dificulty == null) ? 0 : dificulty.hashCode());
		result = prime * result + (isChecked ? 1231 : 1237);
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
		Activity other = (Activity) obj;
		if (description == null)
		{
			if (other.description != null)
				return false;
		}
		else if (!description.equals(other.description))
			return false;
		if (dificulty != other.dificulty)
			return false;
		if (isChecked != other.isChecked)
			return false;
		return true;
	}
	
	
	
	
}
