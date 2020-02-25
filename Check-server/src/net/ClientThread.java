package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Vector;

import model.Infomation;
import operator.Operator;
import operator.Record;

public class ClientThread extends Thread{
	
	public Socket tcpConnection;
	
	byte[] buffer = new byte[256]; 
	private Vector<Infomation> Info=new Vector<Infomation>();
	
	public ClientThread(Socket tcpConnection) {

		
		this.tcpConnection = tcpConnection;
			
	
	}
	public Socket getTcpConnection() {
		return tcpConnection;
	}

	public void setTcpConnection(Socket tcpConnection) {
		this.tcpConnection = tcpConnection;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void run()
	{
		
		try{
			InputStream in = null;
			OutputStream out = null;
			in = tcpConnection.getInputStream();
			out = tcpConnection.getOutputStream();
			ObjectOutputStream os = null;  		
			while(true)
			{
				int count = in.read(buffer);
				String keywords = null;
	
		        keywords = new String(buffer,0,count);
		        
		        System.out.println("keyword:"+keywords);
	             
	            String[] temp = new String[7];
	            
	            temp = keywords.split(",");
	            
	            switch(temp[0])
	            {
	            	
	            	case"delete":System.out.println("Operation:"+temp[0]+"    Value:"+temp[1]+"    Col:"+temp[2]+"    Bookid:"+temp[3]);break;
	            	
	            	case"modify":System.out.println("Operation:"+temp[0]+"    newValue:"+temp[1]+"    Col:"+temp[2]+"    Sid:"+temp[3]);break;
	            	
	            	case"update":System.out.println("Operation:"+temp[0]+"    name:"+temp[1]+"    id:"+temp[2]+"    acdamic:"+temp[3]+"    profession:"+temp[4]+"    classes:"+temp[5]+"    email:"+temp[6]);break;
	            	
	            	case"updateT":System.out.println("Operation:"+temp[0]+"    name:"+temp[1]+"    id:"+temp[2]+"    acdamic:"+temp[3]+"    department:"+temp[4]+"    email:"+temp[5]);break;
	            	
	            	case"addAttend":System.out.println("Operation:"+temp[0]+"    Sid:"+temp[1]+"    Cid:"+temp[2]+"    attend:"+temp[3]+"    date:"+temp[4]+"    courseName:"+temp[5]);break;
	            	
	            	case"searchStudent":System.out.println("Operation:"+temp[0]+"    keyword:"+temp[1]+"    stadard:"+temp[2]);break;
	            	
	            	case"searchTeacher":System.out.println("Operation:"+temp[0]);break;
	            	
	            	case"searchTeacherT":System.out.println("Operation:"+temp[0]+"	TId:"+temp[1]);break;
	            	
	            	case"searchClass":System.out.println("Operation:"+temp[0]+"	courseName:"+temp[1]);break;
	            	
	            	case"searchClassAllStudent":System.out.println("Operation:"+temp[0]+"	ClassId:"+temp[1]+"	courseName:"+temp[2]);break;
	            	
	            	case"searchClassAttends":System.out.println("Operation:"+temp[0]+"	classId:"+temp[1]+"	courseName:"+temp[2]);break;
	            	
	            	case"searchAttends":System.out.println("Operation:"+temp[0]+"    courseId:"+temp[1]+"    userid:"+temp[2]);break;
	            	
	            	case"searchCourse":System.out.println("Operation:"+temp[0]+"    TId/SId:"+temp[1]);break;
	            	
	            	case"searchCourseT":System.out.println("Operation:"+temp[0]+"    TId:"+temp[1]);break;       	
	            	
	            	case"hasAdd":System.out.println("Operation:"+temp[0]+"    Sid:"+temp[1]+"    Cid:"+temp[2]+"    date:"+temp[3]);break;
	            	
	            	case"refresh":System.out.println("Operation:"+temp[0]+"    keyword:"+temp[1]);break;
	            	
	            	case"login":System.out.println("Operation:"+temp[0]+"    identity:"+temp[1]+"    userid:"+temp[2]);break;
	            	
	            	case"modifyPW":System.out.println("Operation:"+temp[0]+"    newPassword:"+temp[1]+"    userid:"+temp[2]);break;
	            	
	            	case"modifyPWT":System.out.println("Operation:"+temp[0]+"    newPassword:"+temp[1]+"    teacherid:"+temp[2]);break;
	            }
	            
	          
            	 switch(temp[0])
 	             {
 		           
 		            case "delete":Operator delete = new Operator();
 		            			  delete.delete(Integer.valueOf(temp[3]),Integer.valueOf(temp[2]));
 		            			
 		            			  break;
 		           case "modify":Operator modify = new Operator();
 		           				  modify.modify(Integer.valueOf(temp[2]),temp[1],Integer.valueOf(temp[3]));
				      			
				      			  break;
 		            case "update":Operator update = new Operator();
 		            			  Info = update.update(temp[1],Integer.valueOf(temp[2]),temp[3],temp[4],temp[5],temp[6],"student");
 		            			
 		            			  break;
 		           case "updateT":Operator updateT = new Operator();
				      			  Info = updateT.update(temp[1],Integer.valueOf(temp[2]),temp[3],temp[4],"empty",temp[5],"teacher");
				      			
				      			  break;
 		          case "addAttend":Operator addAttend = new Operator();
				      			  Info = addAttend.addAttend(temp[1],temp[2],temp[3],temp[4],temp[5]);
				      			
				      			  break;
 		            case "searchStudent":Operator searchS = new Operator();
 		            			  Info = searchS.search(temp[0],temp[1],temp[2]);
 		            			
 		            			  break;
 		            case "searchTeacher":Operator searchT = new Operator();
        						  Info = searchT.search(temp[0],"empty","student");
        			
        						  break;
 		           case "searchTeacherT":Operator searchTT = new Operator();
								  Info = searchTT.search("searchTeacher",temp[1],"teacher");
					
								  break;
								  
 		          case "searchClass":Operator searchClass = new Operator();
								  Info = searchClass.search("searchClass",temp[1],"teacher");
					
								  break;
 		         case "searchClassAttends":Operator searchClassAttends = new Operator();
								  Info = searchClassAttends.search("searchAttends",temp[1],temp[2]);
					
								  break;
 		        case "searchClassAllStudent":Operator searchClassAllStudent = new Operator();
								  Info = searchClassAllStudent.search("searchClassAllStudent",temp[1],temp[2]);
					
								  break;
 		           case "searchAttends":Operator searchA = new Operator();
 		           				 temp[1] = temp[1]+","+temp[2];
								  Info = searchA.search("searchAttends",temp[1],"student");
					
								  break;
 		            case "searchCourse":Operator searchC = new Operator();
								  Info = searchC.search(temp[0],temp[1],"student");
					
								  break;
 		           case "searchCourseT":Operator searchCT = new Operator();
								  Info = searchCT.search("searchCourse",temp[1],"teacher");
					
								  break;
 		          case "hasAdd":Operator hasAdd = new Operator();
								  Info = hasAdd.hasAdd(temp[1],temp[2],temp[3]);
					
								  break;
 		            case "login":Operator login = new Operator();
 		            			  Info = login.LoginCheck(temp[1],temp[2],temp[3]);
 				      			 
 				      			  break;
 		           case "modifyPW":Operator modifyPW = new Operator();
			        			  Info = modifyPW.modifyPW(temp[1],temp[2],"tudent");
				      			 
				      			  break;
 		          case "modifyPWT":Operator modifyPWT = new Operator();
				    			  Info = modifyPWT.modifyPW(temp[1],temp[2],"teacher");
				      			 
				      			  break;
 		            			  
 	             }
	            
            	  os = new ObjectOutputStream(tcpConnection.getOutputStream());  
            	 os.writeObject(Info);  
		        os.flush(); 
		
	//	        if(in!=null)in.close();
	//			if(out!=null)out.close();
	//			//if(tcpConnection!=null)tcpConnection.close();
	//			if(os!=null)os.close();
	//			System.out.println("��F�����ѹر�");
			}
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
//		finally
//		{
//			try {
//					if(in!=null)in.close();
//					if(out!=null)out.close();
//					//if(tcpConnection!=null)tcpConnection.close();
//					if(os!=null)os.close();
//					System.out.println("��F�����ѹر�");
//			   
//			
//				} catch (IOException e) {	
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
