package operator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

import model.Infomation;
import database.DBConnection;
import net.Server;

public class Operator<booklist> 
{

	private Vector<Infomation> Info=new Vector<Infomation>();
	
	
	public Operator() 
	{
		
	}

	public static void main(String[] args) 
	{
		
	}

	public Vector<Infomation> addAttend(String Sid,String Cid,String attend,String date,String courseName)
	{
		Connection conn = DBConnection.getConnection();
		Statement s=null;
		Vector<Infomation> isSucsess = new Vector<Infomation>();
		Infomation info = new Infomation(0,"yes","","","","","","","");
		isSucsess.add(info);
		System.out.println("sid"+Sid+"Cid"+Cid+"attend"+attend+"date"+date+"coursename"+courseName);
		try
		{
			s = conn.createStatement();
			String sql =null;
			sql = "insert into attendsInfo values('"+Sid+"','"+Cid+"','"+attend+"','"+date+"','"+courseName+"')";
			s.executeUpdate(sql);
			System.out.println("添加成功!");
			
			DBConnection.closeConnection( s, conn);
			
		 } 
		catch (SQLException e) 
		{
			e.printStackTrace();
			isSucsess.get(0).name = "no";
			
		}
		System.out.println("Info已返回");
		return isSucsess;
		
	}

	public void delete(int bookorder,int col)
	{
		Connection conn = DBConnection.getConnection();
		Statement s=null;
		try 
		{
			s = conn.createStatement();
			String sql =null;
			
			switch(col)
			{
				case 1:sql = "delete from booktable where bookid ="+ bookorder+"";break;
				
				case 3:sql = "update booktable set author = null where bookid = "+ bookorder+"";break;
				
				case 4:sql = "update booktable set price = null where bookid ="+ bookorder+"";break;
				
				case 5:sql = "update booktable set category = null where bookid ="+ bookorder+"";break;
				
				case 6:sql = "update booktable set remark = null where bookid ="+ bookorder+"";break;
			}
			
			s.executeUpdate(sql);
			System.out.println("修改成功!");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			
		}
		
		DBConnection.closeConnection( s, conn);
		
		
	}

	public Vector<Infomation> update(String name,int id,String acdamic,String proORdep,String classes,String email,String identity)
	{
		Connection conn = DBConnection.getConnection();
		Statement s=null;
		Vector<Infomation> isSucsess = new Vector<Infomation>();
		Infomation info = new Infomation(0,"yes","","","","","","","");
		isSucsess.add(info);
		try 
		{
			s = conn.createStatement();
			
			String sql;
			
			if(identity.equals("student"))
			{
				sql = "update studentInfo set name = '"+name+"',acdamic = '"+acdamic+"',profession = '"+proORdep+"',classes = '"+classes+"',email = '"+email+"'where Sid = "+id+"";	
			}
			else
			{
				sql = "update teacherInfo set name = '"+name+"',acdamic = '"+acdamic+"',department = '"+proORdep+"',email = '"+email+"'where Tid = "+id+"";
			}
				
			
			
			s.executeUpdate(sql);
			System.out.println("修改成功!");
		} 
		catch (SQLException e)
		{
			isSucsess.get(0).name = "no";			
			e.printStackTrace();
		}
		
		DBConnection.closeConnection( s, conn);
		return isSucsess;
		
	}
	
	
	
	public Vector<Infomation> modify(int col,Object newvalue,int Sid)
	{
		Connection conn = DBConnection.getConnection();
		Statement s=null;
		System.out.println("开始修改!");
		System.out.println("所在行："+col);
		System.out.println("新值："+newvalue);
		System.out.println("Sid："+Sid);
		try 
		{
			s = conn.createStatement();
			String sql =null;
			switch(col)
			{
				case 3 :sql = "update attendsInfo set AInfo = '"+newvalue+"'where Sid = "+Sid+"";break;
			
				case 4 :sql = "update attendsInfo set Date = '"+newvalue+"'where Sid = "+Sid+"";break;
			
			}
			
			
			s.executeUpdate(sql);
			System.out.println("修改成功!");
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBConnection.closeConnection( s, conn);
		return Info;
		
	}
	
	

	int count;

	public Vector<Infomation> search(String type,String keywords,String standard)
	{
		System.out.println("(operator.search)type:"+type+"	standard:"+standard+"	keywords:"+keywords);
		Connection conn = DBConnection.getConnection();
		
		Vector<Infomation> empty = null;
		try 
		{
		
			Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			String sql =null;
			
			if(type.equals("searchStudent"))
			{
				if(keywords.equals(""))
				{
					sql = "select * from studentInfo ";
							
//						case "学号":sql = "select * from studentInfo where Sid like'%"+keywords+"%'";break;
//							
//						case "姓名":sql = "select * from studentInfo where name like'%"+keywords+"%'";break;
//							
//						case "学院":sql = "select * from studentInfo where acdamic like'%"+keywords+"%'";break;
//							
//						case "专业":sql = "select * from studentInfo where profession like'%"+keywords+"%'";break;
//							
//						case "班级":sql = "select * from studentInfo where classes like'%"+keywords+"%'";break;
					
				}
				else
				{
					switch(standard)
					{
						case "empty":sql = "select * from studentInfo where Sid like'%"+keywords+"%'or name like'%"+keywords+"%'or acdamic like'%"+keywords+"%'or profession like'%"+keywords+"%'or email like'%"+keywords+"%'or ClassId like'%"+keywords+"%'";break;
							
						case "学号":sql = "select * from studentInfo where Sid like'%"+keywords+"%'";break;
							
						case "姓名":sql = "select * from studentInfo where name like'%"+keywords+"%'";break;
							
						case "学院":sql = "select * from studentInfo where acdamic like'%"+keywords+"%'";break;
							
						case "专业":sql = "select * from studentInfo where profession like'%"+keywords+"%'";break;
							
						case "班级":sql = "select * from studentInfo where classes like'%"+keywords+"%'";break;
					}
				}
				
					
							
				ResultSet rs1 = s.executeQuery(sql);
				rs1.last();
				count = rs1.getRow();
				ResultSet rs = s.executeQuery(sql);
				
				if(rs.next())
				{	
					Infomation st = new Infomation(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),"'empty'",rs.getString(6),"'empty'",rs.getString(7));
					getInfo().add(st);
					try 
					{
						while(rs.next())
						{	
							Infomation st1 = new Infomation(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),"'empty'",rs.getString(6),"'empty'",rs.getString(7));
							getInfo().add(st1);
					    }
					} 
					catch (SQLException e)
					{
						e.printStackTrace();
					}
				
					DBConnection.closeConnection(rs, s, conn);
					
				}
				else
				{
					System.out.println("没有相关学生信息。。。");

					DBConnection.closeConnection(rs, s, conn);
					
					return empty;
				}
				
				System.out.println("studentInfo已返回");
				
				return Info;
				
				
				
			}
			else if(type.equals("searchTeacher"))
			{
				System.out.println("saerchteacher...");
				if(standard.equals("student"))
				{
					sql = "select * from teacherInfo";
				}
				else
				{
					System.out.println("(operator.searchTeacher)standard:"+standard);
					sql = "select * from teacherInfo where Tid = '"+keywords+"'";
				}
				
				
				ResultSet rs1 = s.executeQuery(sql);
				rs1.last();
				count = rs1.getRow();
				ResultSet rs = s.executeQuery(sql);
				
				if(rs.next())
				{	
					Infomation im = new Infomation(Integer.valueOf(rs.getString(1)),rs.getString(2),rs.getString(3),"'empty'",rs.getString(5),rs.getString(4),"'empty'","'empty'",rs.getString(6));
					getInfo().add(im);
					try 
					{
						while(rs.next())
						{	
							Infomation im1 = new Infomation(Integer.valueOf(rs.getString(1)),rs.getString(2),rs.getString(3),"'empty'",rs.getString(5),rs.getString(4),"'empty'","'empty'",rs.getString(6));
							getInfo().add(im1);
					    }
					} 
					catch (SQLException e)
					{
						e.printStackTrace();
					}
				
					DBConnection.closeConnection(rs, s, conn);
					
				}
				else
				{
					System.out.println("没有相关教师信息。。。");

					DBConnection.closeConnection(rs, s, conn);
					
					return empty;
				}
				
				System.out.println("Info已返回");
				
				return Info;
			}
			else if(type.equals("searchCourse"))
			{
				System.out.println("searchCourse...");
				
				if(standard.equals("student"))
				{
					sql = "select distinct CourseTeacher.Cid,CourseTeacher.Cname,CourseTeacher.Tname,CourseTeacher.Tid from CourseTeacher,studentCourse where CourseTeacher.Cid=studentCourse.Cid and studentCourse.Sid='"+keywords+"'";
				}
				else
				{
					sql = "select Tid,Cname,Tname,Cid from CourseTeacher where Tid='"+keywords+"'";
				}
				
				
							
				ResultSet rs1 = s.executeQuery(sql);
				rs1.last();
				count = rs1.getRow();
				ResultSet rs = s.executeQuery(sql);
				
				if(rs.next())
				{	
					Infomation im = new Infomation(Integer.valueOf(rs.getString(1)),rs.getString(2),"'empty'","'empty'","'empty'","'empty'",rs.getString(3),rs.getString(4),"'empty'");
					getInfo().add(im);
					try 
					{
						while(rs.next())
						{	
							Infomation im1 = new Infomation(Integer.valueOf(rs.getString(1)),rs.getString(2),"'empty'","'empty'","'empty'","'empty'",rs.getString(3),rs.getString(4),"'empty'");
							getInfo().add(im1);
					    }
					} 
					catch (SQLException e)
					{
						e.printStackTrace();
					}
				
					DBConnection.closeConnection(rs, s, conn);
					
				}
				else
				{
					System.out.println("没有相关课程信息。。。");

					DBConnection.closeConnection(rs, s, conn);
					
					return empty;
				}
				
				
				
				
				
				System.out.println("Info已返回");
				
				return Info;
			}
			else if(type.equals("searchAttends"))
			{
				
				
				if(standard.equals("student"))
				{
					
					String [] temp = keywords.split(",");
					System.out.println("temp[0]:"+temp[0]+"   temp[1]:"+temp[1]);

					sql = "select attendsInfo.Sid,CourseTeacher.Cname,CourseTeacher.Tname,attendsInfo.Date,attendsInfo.AInfo from CourseTeacher,attendsInfo where attendsInfo.Cid=CourseTeacher.Cid and attendsInfo.Sid='"+temp[1]+"' and CourseTeacher.Cid='"+temp[0]+"'";
				}
				else
				{
					sql = "select distinct studentInfo.Sid,studentInfo.name,attendsInfo.Date,attendsInfo.AInfo,attendsInfo.Cname from studentInfo,attendsInfo where attendsInfo.Sid=studentInfo.Sid and attendsInfo.Cname='"+standard+"' and studentInfo.Classid='"+keywords+"'";

				}

				
				
				
				ResultSet rs1 = s.executeQuery(sql);
				rs1.last();
				count = rs1.getRow();
				ResultSet rs = s.executeQuery(sql);
				
				if(rs.next())
				{	
					Infomation im = new Infomation(Integer.valueOf(rs.getString(1)),rs.getString(2),"'empty'","'empty'","'empty'","'empty'",rs.getString(4),rs.getString(5),rs.getString(3));
					getInfo().add(im);
					try 
					{
						while(rs.next())
						{	
							Infomation im1 = new Infomation(Integer.valueOf(rs.getString(1)),rs.getString(2),"'empty'","'empty'","'empty'","'empty'",rs.getString(4),rs.getString(5),rs.getString(3));
							getInfo().add(im1);
					    }
					} 
					catch (SQLException e)
					{
						e.printStackTrace();
					}
				
					DBConnection.closeConnection(rs, s, conn);
					
				}
				else
				{
					System.out.println("没有相关考勤信息。。。");

					DBConnection.closeConnection(rs, s, conn);
					
					return empty;
				}
				
				System.out.println("Info已返回");
				
				return Info;
			}
			else if(type.equals("searchClassAllStudent"))
			{
										
				sql = "select distinct studentInfo.Sid,studentInfo.name from studentInfo,CourseTeacher,ClassTeacher where CourseTeacher.Tid=ClassTeacher.Tid and ClassTeacher.ClassId=studentInfo.ClassId and CourseTeacher.Cname='"+standard+"' and studentInfo.Classid='"+keywords+"'";
								
				ResultSet rs1 = s.executeQuery(sql);
				rs1.last();
				count = rs1.getRow();
				ResultSet rs = s.executeQuery(sql);
				
				if(rs.next())
				{	
					Infomation im = new Infomation(Integer.valueOf(rs.getString(1)),rs.getString(2),"'empty'","'empty'","'empty'","'empty'","'empty'","'empty'","'empty'");
					getInfo().add(im);
					try 
					{
						while(rs.next())
						{	
							Infomation im1 = new Infomation(Integer.valueOf(rs.getString(1)),rs.getString(2),"'empty'","'empty'","'empty'","'empty'","'empty'","'empty'","'empty'");
							getInfo().add(im1);
					    }
					} 
					catch (SQLException e)
					{
						e.printStackTrace();
					}
				
					DBConnection.closeConnection(rs, s, conn);
					
				}
				else
				{
					System.out.println("没有相关班级学生信息。。。");

					DBConnection.closeConnection(rs, s, conn);
					
					return empty;
				}
				
				System.out.println("Info已返回");
				
				return Info;
			}
			
			
			
			else if(type.equals("searchClass"))
			{
				

				sql = "select ClassId from CourseTeacher,ClassTeacher where CourseTeacher.Tid = ClassTeacher.Tid and CourseTeacher.Cname = '"+keywords+"'";
				
				ResultSet rs1 = s.executeQuery(sql);
				rs1.last();
				count = rs1.getRow();
				ResultSet rs = s.executeQuery(sql);
				
				if(rs.next())
				{	
					Infomation im = new Infomation(Integer.valueOf(rs.getString(1)),"'empty'","'empty'","'empty'","'empty'","'empty'","'empty'","'empty'","'empty'");
					getInfo().add(im);
					try 
					{
						while(rs.next())
						{	
							Infomation im1 = new Infomation(Integer.valueOf(rs.getString(1)),"'empty'","'empty'","'empty'","'empty'","'empty'","'empty'","'empty'","'empty'");
							getInfo().add(im1);
					    }
					} 
					catch (SQLException e)
					{
						e.printStackTrace();
					}
				
					DBConnection.closeConnection(rs, s, conn);
					
				}
				else
				{
					System.out.println("没有相关班级编号。。。");

					DBConnection.closeConnection(rs, s, conn);
					
					return empty;
				}
				
				System.out.println("Info已返回");
				
				return Info;
			}
			
				
			
			
		} 
		catch (SQLException e)
		{
			
			 e.printStackTrace();
			 
			 return empty;
		}
		return empty;
		
		
	}
	
	
	public Vector<Infomation> hasAdd(String Sid, String Cid, String Date) 
	{
	
		Connection conn = DBConnection.getConnection();
		
		Vector<Infomation> emptyInfo = null;
		
			Statement s;
			try {
					s = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
					String sql ="select attendsInfo.Sid,studentInfo.name,attendsInfo.AInfo,attendsInfo.Date from attendsInfo,studentInfo where attendsInfo.Sid=studentInfo.Sid and attendsInfo.Sid='"+Sid+"'and Cid='"+Cid+"'and Date='"+Date+"'";
					
							
					ResultSet rs1 = s.executeQuery(sql);
					rs1.last();
					count = rs1.getRow();
					ResultSet rs = s.executeQuery(sql);
					
					if(rs.next())
					{
						
						Infomation st = new Infomation(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),"'empty'","'empty'","'empty'","'empty'","'empty'");
						
						getInfo().add(st);
												
						while(rs.next())
						{	
							Infomation st1 = new Infomation(Integer.parseInt(rs.getString(1)),rs.getString(2),rs.getString(3),rs.getString(4),"'empty'","'empty'","'empty'","'empty'","'empty'");
							getInfo().add(st1);
					    }
						
						
						DBConnection.closeConnection(rs, s, conn);
						System.out.println("Info已返回");
						return Info;
					}
					else
					{
						System.out.println("没有该学生该课在该时间的考勤记录");
					
						DBConnection.closeConnection(rs, s, conn);
					
						return emptyInfo;
					}
				
				} 
				catch (SQLException e) 
				{					
					e.printStackTrace();
				}
			
			
				
				
				return Info;
				
				
				
			
	}
	
	
	
	public Vector<Infomation> LoginCheck(String identity,String id,String password)
	{
		Infomation st = new Infomation(-1,"yes","y","y","y","y","y","y","y");
		Info.add(st);
		System.out.println("id:"+id);
		System.out.println("pw:"+password);
		Connection conn = DBConnection.getConnection();
		try 
		{
			Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql;
			if(identity.equals("student"))
			{
				System.out.println("student");
				sql = "select password,username from studentList where Sid = '"+id+"'";
				Info.get(0).acdamic = "student";
			}
			else
			{
				sql = "select password,username from teacherList where Tid = '"+id+"'";
				Info.get(0).acdamic = "admin";
			}
			
			
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next())
			{	
				System.out.println("pw:"+rs.getString(1));
				if(password.equals(rs.getString(1)))
				{
					System.out.println("用户匹配成功！");
					Info.get(0).profession = rs.getString(2); 
				}
				else
				{
					System.out.println("密码错误！");
					
					Info.get(0).name = "wrongpassword";
				}
				
				DBConnection.closeConnection(rs, s, conn);
			}
			else
			{
				System.out.println("用户不存在！");
				
				Info.get(0).name = "userdoesnotexist";
			}
			
			
			DBConnection.closeConnection( s, conn);
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		return Info;
		
	}
	
	
	public Vector<Infomation> modifyPW(String newPassword,String userId,String identity)
	{
		Connection conn = DBConnection.getConnection();
		Statement s=null;
		Vector<Infomation> isSucsess = new Vector<Infomation>();
		Infomation info = new Infomation(0,"yes","","","","","","","");
		isSucsess.add(info);
		System.out.println("开始修改!");
		
		try 
		{
			s = conn.createStatement();
			String sql;
			if(identity.equals("student"))
			{
				sql = "update studentList set password = '"+newPassword+"'where Sid = '"+userId+"'";
			}
			else
			{
				sql = "update teacherList set password = '"+newPassword+"'where Tid = '"+userId+"'";
			}
			
			
			s.executeUpdate(sql);
			System.out.println("修改成功!");
		} 
		catch (SQLException e)
		{
			isSucsess.get(0).name = "no";
			e.printStackTrace();
		}
		
		DBConnection.closeConnection( s, conn);
		return isSucsess;
		
	}
	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


	public static boolean add() {
		// TODO Auto-generated method stub
		return false;
	}

	public Vector<Infomation> getInfo() {
		return Info;
	}

	public void setInfo(Vector<Infomation> studentInfo) {
		this.Info = studentInfo;
	}

	
}
