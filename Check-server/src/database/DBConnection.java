package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection
{
	  static final String driverName="com.mysql.jdbc.Driver";
	  static final String dbURL="jdbc:mysql://localhost:3306/LWCSASDB?useSSL=false&useUnicode=true&characterEncoding=utf8";
	  static String userName="root";
	  static String userPwd="920Shabaitian725";
	
	static
	{
		try
		{
			Class.forName(driverName);
			//System.out.println("mysql加载驱动成功！");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("mysql加载驱动失败！");
		}
		
	}
	
	
	
	public static Connection getConnection()
	{
		try{
			Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
			System.out.println("mysql连接成功！");
			//Statement s= dbConn.createStatement();
			return dbConn;
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.print("mysql连接失败！");
			return null;
		
		}
		
	}
	
	public static void closeConnection(ResultSet rs,Statement s,Connection con)
	{
		
		
			try 
			{
				if(s!=null)s.close();
				if(rs!=null)rs.close();
				if(con!=null)con.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public static void closeConnection(Statement s,Connection con)
	{
		
		
			try 
			{
				if(s!=null)s.close();
				
				if(con!=null)con.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public static void main(String[] args)
	{
		
	}
}
		
	
