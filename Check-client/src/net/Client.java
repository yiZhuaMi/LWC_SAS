package net;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;

import model.Infomation;;

public class Client {
	
	byte[] buffer = new byte[256];
	String acceptstr = new String();
	static Socket tcpConnection = null;
	static InputStream in = null;
	static OutputStream out = null;
	static ObjectOutputStream os = null;  
   
	
	public static void main(String[] args) {
		
       new Client();

	}
	 static
		{
			System.out.println("客户端已开启");
		    try 
		    {
//		    	tcpConnection = new Socket("172.18.110.117",2556);
		    	tcpConnection = new Socket("localhost",3335);
		    	
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		    System.out.println("已连接服务器");
		}

	@SuppressWarnings("unchecked")
	public Vector<Infomation> client(String sendstr) {

		
		System.out.println("发送给服务器:"+sendstr);
		
		
        Object obj = null;
        Vector<Infomation> Info = null;
        
       
		
		try 
		{

			ObjectInputStream is = null;  
						
		    in = tcpConnection.getInputStream();
			out = tcpConnection.getOutputStream();

			out.write(sendstr.getBytes());
			System.out.println("已发送");
			out.flush();
			
			is = new ObjectInputStream(new BufferedInputStream(tcpConnection.getInputStream())); 
			try  
			{
				obj = is.readObject();
			}
			catch (ClassNotFoundException e) 
			{
				e.printStackTrace();
			}
	
			Info = (Vector<Infomation>)obj;
			
		}
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
	    {
			e.printStackTrace();
	    }
//		finally
//		{
//			try 
//			{
//				if(in!=null)in.close();
//				if(out!=null)out.close();
//				if(tcpConnection!=null)tcpConnection.close();
//				if(is!=null)is.close();
//				if(os!=null)os.close();
//				System.out.println("��K�����ѹر�");
//			}
//			catch (IOException e) 
//			{
//				e.printStackTrace();
//			}
//		
//		}
		return Info;
	
		
	}
//	public void closeconnection(InputStream in,OutputStream out,Socket tcpConnection,ObjectOutputStream os,ObjectInputStream is)
	public void closeconnection()

	{
		try 
		{
//			in = this.in;
//		
//			out = this.out;
//			os = this.os;
//
//			tcpConnection = this.tcpConnection;
			
			if(in!=null)in.close();
			if(out!=null)out.close();
			if(tcpConnection!=null)tcpConnection.close();
			if(os!=null)os.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
