package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {
	
	byte[] buffer = new byte[256];
	String acceptstr = new String();

	public Server() {
		
		ServerSocket ss = null;
		
		
		try {
			
			ss =new ServerSocket(3335);
			System.out.println("服务器已经开启，等待客户端连接。。。。。。");
			JOptionPane.showMessageDialog(null, "服务器已经开启，等待客户端连接");
			
				while(true)
				{
					Socket tcpConnection = ss.accept();
					System.out.println("客户端已连接 IP地址："+tcpConnection.getInetAddress()+"端口号："+tcpConnection.getPort());
					
					ClientThread ct = new ClientThread(tcpConnection);
					ct.start();
				}
			}
           
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}



	public static void main(String[] args) {
		new Server();

	}

}
