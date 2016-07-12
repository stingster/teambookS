package ro.ea.ja.teambook.domain;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Player
{
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private byte[] picture;
	private String password;
	private GregorianCalendar birthday;
	private int age;
	private String department;
	private String position;
	private String gender;
	private List<Category> categories;

	public synchronized int getId()
	{
		return id;
	}

	public synchronized void setId(int id)
	{
		this.id = id;
	}
	
	public synchronized String getFirstName()
	{
		return firstName;
	}

	public synchronized void setFirstName(String firstName) throws InvalidRegexExpressionException
	{
		Pattern p = Pattern.compile("[a-zA-Z]{3, 15}");
		Matcher m = p.matcher(firstName);
		if (m.matches())
		{
			this.firstName = firstName;
		}
		else
		{
			throw new InvalidRegexExpressionException();
		}
	}

	public synchronized String getLastName()
	{
		return lastName;
	}

	public synchronized void setLastName(String lastName) throws InvalidRegexExpressionException
	{
		Pattern p = Pattern.compile("[a-zA-Z]{3, 15}");
		Matcher m = p.matcher(lastName);
		if (m.matches())
		{
			this.lastName = lastName;
		}
		else
		{
			throw new InvalidRegexExpressionException();
		}
	}

	public synchronized String getEmail()
	{
		return email;
	}

	public synchronized void setEmail(String email) throws InvalidRegexExpressionException
	{
		Pattern p = Pattern.compile("([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})");
		Matcher m = p.matcher(email);
		if (m.matches())
		{
			this.email = email;
		}
		else
		{
			throw new InvalidRegexExpressionException();
		}
	}

	public synchronized byte[] getPicture()
	{
		return picture;
	}

	public synchronized void setPicture(byte[] picture)
	{
		this.picture = picture;
	}
	
	public synchronized String getPassword()
	{
		return password;
	}

	public synchronized void setPassword(String password) throws InvalidRegexExpressionException
	{
		Pattern p = Pattern.compile("[a-zA-Z0-9@*#]{8,15}");
		Matcher m = p.matcher(password);
		if (m.matches())
		{
			this.password = password;
		}
		else
		{
			throw new InvalidRegexExpressionException();
		}
	}

	public synchronized GregorianCalendar getBirthday()
	{
		return birthday;
	}

	public synchronized void setBirthday(GregorianCalendar birthday)
	{
		this.birthday = birthday;
		setAge(birthday);
	}

	public synchronized int getAge()
	{
		return age;
	}

	private synchronized void setAge(GregorianCalendar birthday)
	{
		if (birthday != null)
		{
			long birthdayToMillis = birthday.getTimeInMillis();
			long epoch = new Date().getTime();
			long ageInMillis = epoch - birthdayToMillis;
			this.age = (int) (((ageInMillis / 1000) / 3600) / 24) / 365;
		}
	}


	public synchronized String getDepartment()
	{
		return department;
	}

	public synchronized void setDepartment(String department)
	{
		this.department = department;
	}

	public synchronized String getPosition()
	{
		return position;
	}

	public synchronized void setPosition(String position)
	{
		this.position = position;
	}
	
	public synchronized String getGender()
	{
		return gender;
	}

	public synchronized void setGender(String gender)
	{
		this.gender = gender;
	}

	public synchronized List<Category> getCategories()
	{
		return categories;
	}

	public synchronized void setCategories(List<Category> categories)
	{
		this.categories = categories;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((categories == null) ? 0 : categories.hashCode());
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + Arrays.hashCode(picture);
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
		Player other = (Player) obj;
		if (age != other.age)
			return false;
		if (birthday == null)
		{
			if (other.birthday != null)
				return false;
		}
		else if (!birthday.equals(other.birthday))
			return false;
		if (categories == null)
		{
			if (other.categories != null)
				return false;
		}
		else if (!categories.equals(other.categories))
			return false;
		if (department == null)
		{
			if (other.department != null)
				return false;
		}
		else if (!department.equals(other.department))
			return false;
		if (email == null)
		{
			if (other.email != null)
				return false;
		}
		else if (!email.equals(other.email))
			return false;
		if (firstName == null)
		{
			if (other.firstName != null)
				return false;
		}
		else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null)
		{
			if (other.gender != null)
				return false;
		}
		else if (!gender.equals(other.gender))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null)
		{
			if (other.lastName != null)
				return false;
		}
		else if (!lastName.equals(other.lastName))
			return false;
		if (password == null)
		{
			if (other.password != null)
				return false;
		}
		else if (!password.equals(other.password))
			return false;
		if (!Arrays.equals(picture, other.picture))
			return false;
		if (position == null)
		{
			if (other.position != null)
				return false;
		}
		else if (!position.equals(other.position))
			return false;
		return true;
	}

}
