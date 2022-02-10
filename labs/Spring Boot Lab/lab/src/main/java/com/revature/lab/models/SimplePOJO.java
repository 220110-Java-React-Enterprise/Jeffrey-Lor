package com.revature.lab.models;

import javax.persistence.*;

@Entity
public class SimplePOJO
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;

	@Column
	private String name;

	@Column
	private boolean booleanField;

	@Column
	private double doubleField;

	@Column
	private String stringField;

	public SimplePOJO()
	{

	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public boolean isBooleanField()
	{
		return booleanField;
	}

	public void setBooleanField(boolean booleanField)
	{
		this.booleanField = booleanField;
	}

	public double getDoubleField()
	{
		return doubleField;
	}

	public void setDoubleField(double doubleField)
	{
		this.doubleField = doubleField;
	}

	public String getStringField()
	{
		return stringField;
	}

	public void setStringField(String stringField)
	{
		this.stringField = stringField;
	}
}