package net;

import java.util.Vector;

import model.Infomation;

public class Package {
	private Vector<Infomation> Info=new Vector<Infomation>();
	
	public Vector<Infomation> SSearchTeacherpackaging(String action)
	{
		
		Client client = new Client();
		
		Info = client.client(action);
		
		return Info;
	}
	
	public Vector<Infomation> packaging(String action,String keyword)
	{
		String temp = action+","+keyword;
		
		Client client = new Client();
		
		Info = client.client(temp);
		
		return Info;
	}
    
	public boolean MPWpackaging(String action,String newPassword,String username)
	{
		boolean isSucsess = true;
		String temp = action+","+newPassword+","+username;
		
		Client client = new Client();
		
		Info = client.client(temp);
		if(!Info.get(0).name.equals("yes"))
		{
			isSucsess = false;
		}
		
		return isSucsess;
	}
	
	
	public Vector<Infomation> attendsPackaging(String action,String couseId,String userId)
	{
		
		String temp = action+","+couseId+","+userId;
		
		Client client = new Client();
		
		Info = client.client(temp);
				
		return Info;
	}

	
	public boolean StudentUpdatepackaging(String action,String name,String id,String acdamic,String profession,String classes,String email)
	{
		boolean isSucsess = true;

		String temp = action+","+name+","
				+id+","
				+acdamic+","
				+profession+","
				+classes+","
				+email;
		
		Client client = new Client();
		
		Info = client.client(temp);
		
		if(!Info.get(0).name.equals("yes"))
		{
			isSucsess = false;
		}
		
		return isSucsess;
	}
	
	public Vector<Infomation> modifyPackaging(String action,String value,String col,String order)
	{
		String IdColvalue;
		if(action.equals("modify"))
		{
			IdColvalue = "modify,"+value+","+col+","+order;
		}
		else
		{
			IdColvalue = "delete,"+value+","+col+","+order;
		}
		Client client = new Client();
		
		Info = client.client(IdColvalue);
		
		return Info;
	}
	
	public Vector<Infomation> LoginPackaging(String action,String identity,String un,String pw)
	{
		
		String temp = null;;
		if(identity.equals("student"))
		{
			temp= "login,student"+","+un+","+pw; 
		}
		else
		{
			temp= "login,teacher"+","+un+","+pw; 
		}
		
		Client client = new Client();
		
		Info = client.client(temp);
		
		return Info;
		
	}
	
	public boolean TeacherUpdatePackaging(String action,String name,String id,String acdamic,String department,String email) {
		
		boolean isSucsess = true;

		String temp = action+","+name+","
				+id+","
				+acdamic+","
				+department+","
				+email;
		
		Client client = new Client();
		
		Info = client.client(temp);
		
		if(!Info.get(0).name.equals("yes"))
		{
			isSucsess = false;
		}
		
		return isSucsess;
	}
	
	public Vector<Infomation> Packaging(String action, String userId, String standard) 
	{
		System.out.println("packaging....");
		String temp = action+","+userId+","+standard;
		
		Client client = new Client();
		
		Info = client.client(temp);
		
		return Info;
	}

	public Vector<Infomation> packaging(String action, String classId, String courseName) 
	{
		
		String temp = action+","+classId+","+courseName;
		
		Client client = new Client();
		
		Info = client.client(temp);
		
		return Info;
	}
	
	
	public boolean addAttendPackaging(String action, int sid, String cid, String attend, String date,String courseName) 
	{
		boolean isSucsess = true;
		
		String temp = action+","+sid+","+cid+","+attend+","+date+","+courseName;
		
		Client client = new Client();
		
		Info = client.client(temp);
		
		if(!Info.get(0).name.equals("yes"))
		{
			isSucsess = false;
		}
		
		return isSucsess;
		
	}

	
	public Vector<Infomation> hasAddPackaging(String action, String Sid, String Cid, String date) 
	{
		
		
		String temp = action+","+Sid+","+Cid+","+date;
		
		Client client = new Client();
		
		Info = client.client(temp);
		
		return Info;
		
	}
	
	
	
	public static void main(String[] args) {
	

	}

	

	
	

	

	

	

}
