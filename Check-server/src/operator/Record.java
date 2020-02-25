package operator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import net.ClientThread;



public class Record {
	
//	static File file = new File("operating record.txt");
	static File file = new File("operatingtext.txt");
	
	

    
    public void writeToTxt(String[] temp,Socket tcpConnection){
		
		 String str = null;
		
		 Date date=new Date();
		 DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String time=format.format(date);
		
		 System.out.println("IP地址："+tcpConnection.getInetAddress());
	
		 
		 switch(temp[0])
         {
         	case"login":str = "客户端IP地址："+tcpConnection.getInetAddress()+"    端口号："+tcpConnection.getPort()+"    time:"+time+"    Operation:"+temp[0];break;
         
         	case"add":    str = "客户端IP地址："+tcpConnection.getInetAddress()+"    端口号："+tcpConnection.getPort()+"    time:"+time+"    Operation:"+temp[0]+"       Bookname:"+temp[1]+"    Author:"+temp[2]+"    Price:"+temp[3]+"    Category:"+temp[4]+"    Remark:"+temp[5];break;
         	
         	case"delete": str = "客户端IP地址："+tcpConnection.getInetAddress()+"    端口号："+tcpConnection.getPort()+"    time:"+time+"    Operation:"+temp[0]+"    Value:"+temp[1]+"    Col:"+temp[2]+"    Bookid:"+temp[3];break;
         	
         	case"modify": str = "客户端IP地址："+tcpConnection.getInetAddress()+"    端口号："+tcpConnection.getPort()+"    time:"+time+"    Operation:"+temp[0]+"    NewValue:"+temp[1]+"    Col:"+temp[2]+"    Bookid:"+temp[3];break;
         	
         	case"search": str = "客户端IP地址："+tcpConnection.getInetAddress()+"    端口号："+tcpConnection.getPort()+"    time:"+time+"    Operation:"+temp[0]+"    keyword:"+temp[1];break;
         	
         	case"refresh":str = "客户端IP地址："+tcpConnection.getInetAddress()+"    端口号："+tcpConnection.getPort()+"    time:"+time+"    Operation:"+temp[0]+"    keyword:"+temp[1];break;
         }
        
         
         FileWriter fw = null;
         BufferedWriter writer = null;
        
       
       
         try 
         {
        	 fw = new FileWriter(file,true);
             writer = new BufferedWriter(fw);
                 
             writer.write(str);
             writer.newLine();
                
             writer.flush();
			 writer.close();
			 fw.close();
		 } 
         catch (IOException e) 
         {
			
			e.printStackTrace();
		 }
        
    }
    
}

