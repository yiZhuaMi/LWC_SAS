package model;

import java.io.Serializable;

public class Infomation implements Serializable
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int id;
	public String name;
	public String acdamic;
	public String profession;
	public String email;
	public String department;
	public String name2;
	public String attends;
	public String date;
	
	
	public Infomation(int id,String name,String acdamic,String profession,String email,String department,String name2,String attends,String date) 
	{
		this.id=id;
		this.name=name;
		this.acdamic=acdamic;
		this.profession=profession;
		this.email=email;
		this.department=department;
		this.name2=name2;
		this.attends=attends;
		this.date=date;
		
	}

	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
