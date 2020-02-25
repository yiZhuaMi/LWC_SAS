package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import model.Infomation;
import net.Package;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.Color;

public class AttendsUI extends JFrame {

	private JPanel contentPane;
	private JTable infoTable;
	private JButton modifyButton;
	Vector<Infomation> Info = new Vector<Infomation>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttendsUI frame = new AttendsUI(1.1,"","",1,"");
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 选择操作
	 */
	
	
	public AttendsUI(final int Tid) 
	{
		
		
		setTitle("考勤");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane js = new JScrollPane();
		js.setBounds(0, 0, 370, 298);
		contentPane.add(js);
		
		String[] headers = {"请选择操作"};
		Object[][] cellData =null;
		final DefaultTableModel model = new DefaultTableModel(cellData, headers) {
		  public boolean isCellEditable(int row, int column) {
		    return false;
		  }
		};
		
		infoTable = new JTable(model);
		infoTable.setBounds(14, 59, 479, 242);
		infoTable.setRowHeight(70);
		infoTable.setFont(new Font("Menu.font", Font.PLAIN, 25));
		js.setViewportView(infoTable);
		model.setColumnCount(1);
		model.setRowCount(0);

		RowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);  
		infoTable.setRowSorter(sorter); 
		
		
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		infoTable.setDefaultRenderer(Object.class,r);
		
		
		String[]title = {"查找与修改","录入"};
		
		for(int i = 0;i<2;i++)
		{
			Object[]str = new Object[2];
			
			str[0]=title[i];		
			
			model.addRow(str);
			
		}
		
		
		infoTable.addMouseListener(new MouseAdapter() 
		{
			   public void mouseClicked(MouseEvent e) 
			   {
				   if (e.getButton() == MouseEvent.BUTTON1) 
			   		{
					   if (e.getClickCount() == 2)
					   {
						   int row = infoTable.getSelectedRow();
						   System.out.println("row:"+(row+1));
						   String action = infoTable.getModel().getValueAt(row, 0).toString();
						   AttendsUI AUI = new AttendsUI(String.valueOf(Tid),action);
						   AUI.setVisible(true);
						   AttendsUI.this.setVisible(false);						  
						
						  
					   }
			   		}
			   }
		});
		
		
		
		JButton returnbutton = new JButton("返回");
		returnbutton.setBounds(289, 303, 75, 29);
		contentPane.add(returnbutton);
		returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				AttendsUI.this.setVisible(false);
			}
		});
	}
	/*
	 * 选择课程
	 */
	public AttendsUI(final String Tid,final String action) 
	{
		
		Package pk = new Package();
		Info = pk.packaging("searchCourseT",Tid);
		
		setTitle("考勤");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane js = new JScrollPane();
		js.setBounds(0, 0, 370, 298);
		contentPane.add(js);
		
		String[] headers = {"请选择课程名称"};
		Object[][] cellData =null;
		final DefaultTableModel model = new DefaultTableModel(cellData, headers) {
		  public boolean isCellEditable(int row, int column) {
		    return false;
		  }
		};
		
		infoTable = new JTable(model);
		infoTable.setBounds(14, 59, 479, 242);
		infoTable.setRowHeight(65);
		infoTable.setFont(new Font("Menu.font", Font.PLAIN, 25));
		js.setViewportView(infoTable);
		model.setColumnCount(1);
		model.setRowCount(0);

		RowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);  
		infoTable.setRowSorter(sorter); 
		
		
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		infoTable.setDefaultRenderer(Object.class,r);
		
		
		int count = Info.size();

		for(int i = 0;i<count;i++)
		{
			Object[]str = new Object[count];
			
			str[0]=Info.get(i).name;		
			
			model.addRow(str);
			
		}
		
		
		infoTable.addMouseListener(new MouseAdapter() 
		{
			   public void mouseClicked(MouseEvent e) 
			   {
				   if (e.getButton() == MouseEvent.BUTTON1) 
			   		{
					   if (e.getClickCount() == 2)
					   {
						   
						   int row = infoTable.getSelectedRow();
						   
						   System.out.println("row:"+(row+1));
						   String courseName =infoTable.getModel().getValueAt(row, 0).toString();
						   System.out.println("courseName:"+courseName);
						   String Cid = Info.get(row).attends;
						   System.out.println("Cid:"+Cid);
//						   model.setRowCount(0);
//						   Package pk = new Package();
//						   Info =  pk.packaging("searchClass", courseName);
						   AttendsUI AUI = new AttendsUI(Double.parseDouble(Cid),courseName,Integer.valueOf(Tid),action);
						   AUI.setVisible(true);
						   AttendsUI.this.setVisible(false);						  
						
						  
					   }
			   		}
			   }
		});
		
		
		
		JButton returnbutton = new JButton("返回");
		returnbutton.setBounds(289, 303, 75, 29);
		contentPane.add(returnbutton);
		returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				 AttendsUI AUI = new AttendsUI(Integer.valueOf(Tid));
				   AUI.setVisible(true);
				   AttendsUI.this.setVisible(false);	
			}
		});
	}
	
	/*
	 * 选择班级
	 */
	
	
	
	public AttendsUI(final Double Cid,final String courseName,final int Tid,final String action) 
	{
		//Vector<Infomation> Info = new Vector<Infomation>();
		Package pk = new Package();
		Info = pk.packaging("searchClass",courseName);
		
		setTitle("考勤");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane js = new JScrollPane();
		js.setBounds(0, 0, 370, 298);
		contentPane.add(js);
		
		String[] headers = {"请选择班级编号"};
		Object[][] cellData =null;
		final DefaultTableModel model = new DefaultTableModel(cellData, headers) {
		  public boolean isCellEditable(int row, int column) {
		    return false;
		  }
		};
		
		infoTable = new JTable(model);
		infoTable.setBounds(14, 59, 479, 242);
		infoTable.setRowHeight(65);
		infoTable.setFont(new Font("Menu.font", Font.PLAIN, 25));
		js.setViewportView(infoTable);
		model.setColumnCount(1);
		model.setRowCount(0);

		RowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);  
		infoTable.setRowSorter(sorter); 
		
		
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		infoTable.setDefaultRenderer(Object.class,r);
		
		
		int count = Info.size();

		for(int i = 0;i<count;i++)
		{
			Object[]str = new Object[count];
			
			str[0]=Info.get(i).id;		
			
			model.addRow(str);
			
		}
		
		
		infoTable.addMouseListener(new MouseAdapter() 
		{
			   public void mouseClicked(MouseEvent e) 
			   {
				   if (e.getButton() == MouseEvent.BUTTON1) 
			   		{
					   if (e.getClickCount() == 2)
					   {
						   
						   int row = infoTable.getSelectedRow();
						   System.out.println("row:"+(row+1));
						   String classid =infoTable.getModel().getValueAt(row, 0).toString();
						   System.out.println("classid:"+classid);
//						   model.setRowCount(0);
//						   Package pk = new Package();
//						   Info =  pk.packaging("searchClass", courseName);
//						  
						   if(!action.equals("录入"))
						   {
							   AttendsUI AUI = new AttendsUI(Cid,classid,courseName,Tid,action);
							   AUI.setVisible(true);
							   AttendsUI.this.setVisible(false);		
						   }
						   else
						   {
							   AttendsUI AUI = new AttendsUI(Cid,Integer.valueOf(classid),courseName,Tid,action);
							   AUI.setVisible(true);
							   AttendsUI.this.setVisible(false);		
						   }
						   				  
						   
						  
						
						  
					   }
			   		}
			   }
		});
		
		
		
		JButton returnbutton = new JButton("返回");
		returnbutton.setBounds(289, 303, 75, 29);
		contentPane.add(returnbutton);
		returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				AttendsUI SUI = new AttendsUI(String.valueOf(Tid),action);
				SUI.setVisible(true);
				AttendsUI.this.setVisible(false);
			}
		});
	}

/*
 * 查询与修改
 */
	
	
	public AttendsUI(final Double Cid,final String ClassId,final String CourseName,final int Tid,final String action) 
	{
		//Vector<Infomation> Info = new Vector<Infomation>();
		Package pk = new Package();
		Info = pk.packaging("searchClassAttends",ClassId,CourseName);
		
		setTitle(CourseName+" 考勤详情");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		final JLabel Tipslabel = new JLabel("提示：双击修改 回车确定");
//		Tipslabel.setBounds(10, 308, 100, 16);
//		Tipslabel.setFont(new Font("微软雅黑",0,15));
//		Tipslabel.setForeground(Color.gray);
//		contentPane.add(Tipslabel);
		
		
		JScrollPane js = new JScrollPane();
		js.setBounds(0, 0, 370, 298);
		contentPane.add(js);
		
		String[] headers = {"学号","姓名", "考勤详情","考勤日期"};
		Object[][] cellData =null;
		final DefaultTableModel model = new DefaultTableModel(cellData, headers) {
			public boolean isCellEditable(int row, int column) 
			  {
				    if(column!=0&&column!=1)
				    {
				    	return true;
				    }
					else
					{
						return false;
					}
				 
			  }
		};
		
		infoTable = new JTable(model);
		infoTable.setBounds(14, 59, 479, 242);
		infoTable.setRowHeight(20);
		js.setViewportView(infoTable);
		model.setColumnCount(4);
		model.setRowCount(0);

		RowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);  
		infoTable.setRowSorter(sorter); 
		
		
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		infoTable.setDefaultRenderer(Object.class,r);
		
		
		int count = Info.size();
		String[][] result =new String[count][4] ;
		for(int i = 0;i<count;i++)
		{
			result[i][0]=String.valueOf(Info.get(i).id);
			result[i][1]=Info.get(i).name;
			result[i][2]=Info.get(i).name2;
			result[i][3]=Info.get(i).date;
			
		}
		for(int i = 0;i<count;i++)
		{
			Object[]str = new Object[4*count];
			for(int j = 0;j<4;j++)
			{
				str[j]=result[i][j];		
			}
			model.addRow(str);
			
		}
		
	
	
		modifyButton = new JButton("修改");
		modifyButton.setBounds(200, 303, 75, 29);
		contentPane.add(modifyButton);
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
					final int row=infoTable.getSelectedRow();
					final int col=infoTable.getSelectedColumn()+1;
					if(col==1||col==0){JOptionPane.showMessageDialog(null, "禁止修改！");}
					else
					{
						int res = JOptionPane.showConfirmDialog(null,"确认修改？","⚠️警告",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(res==JOptionPane.YES_OPTION)
						{
							System.out.println("开始修改！");
							final Object newvalue = infoTable.getValueAt(row,col-1);
							final int Sid = Integer.parseInt(String.valueOf(infoTable.getValueAt(row,0)));
							System.out.println("ָ修改所在行:"+row);
							System.out.println("ָ修改所在列:"+col);
							System.out.println("修改所在的编号:"+Sid);
							System.out.println("新值:"+newvalue);
							try
							{
								Package pk = new Package();
								Info = pk.modifyPackaging("modify", infoTable.getValueAt(row, col-1).toString(),String.valueOf(col),String.valueOf(Sid));
								JOptionPane.showMessageDialog(null, "修改成功！");
							}
							catch(Exception f)
							{
								f.printStackTrace();
								JOptionPane.showMessageDialog(null, "修改失败！");
							}
							
						}
						else if(res==JOptionPane.NO_OPTION)
						{
							System.out.println("取消了修改！");
						}
						else if(res==JOptionPane.CLOSED_OPTION)
						{    
							System.out.println ("关闭了修改！");
						}	
					}
				}
		});
		
		JButton returnbutton = new JButton("返回");
		returnbutton.setBounds(289, 303, 75, 29);
		contentPane.add(returnbutton);
		returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				 AttendsUI AUI = new AttendsUI(Cid,CourseName,Tid,action);
				   AUI.setVisible(true);
				   AttendsUI.this.setVisible(false);			
			   AttendsUI.this.setVisible(false);	
			}
		});
	
	
		
	}
	
	/*
	 * 录入
	 */
	
	/**
	 * @wbp.parser.constructor
	 */
	public AttendsUI(final Double Cid,final int ClassId,final String CourseName,final int Tid,final String action) 
	{
		Package pk = new Package();
		Info = pk.packaging("searchClassAllStudent",String.valueOf(ClassId),CourseName);
		
		setTitle("录入 "+ClassId+"班 "+CourseName+" 考勤");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane js = new JScrollPane();
		js.setBounds(0, 0, 370, 298);
		contentPane.add(js);
		
		String[] headers = {"学号","姓名", "考勤详情","考勤日期"};
		Object[][] cellData =null;
		final DefaultTableModel model = new DefaultTableModel(cellData, headers) {
			public boolean isCellEditable(int row, int column) 
			  {
				    if(column!=0&&column!=1)
				    {
				    	return true;
				    }
					else
					{
						return false;
					}
				 
			  }
		};
		
		infoTable = new JTable(model);
		infoTable.setBounds(14, 59, 479, 242);
		infoTable.setRowHeight(20);
		js.setViewportView(infoTable);
		model.setColumnCount(4);
		model.setRowCount(0);

		RowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);  
		infoTable.setRowSorter(sorter); 
		
		
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);   
		infoTable.setDefaultRenderer(Object.class,r);
		
		
		Date dt=new Date();
	    SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd");
	    Vector<Infomation> Info1 = new Vector<Infomation>();
		int count = Info.size();
		String[][] result =new String[count][4] ;
		for(int i = 0;i<count;i++)
		{
			System.out.println("开始验证");
			Info1 = pk.hasAddPackaging("hasAdd", String.valueOf(Info.get(i).id),String.valueOf(Cid),matter1.format(dt));
			System.out.println("得到info1");
			if(Info1!=null)
			{
				System.out.println("Info1!=null");
				result[i][0]=String.valueOf(Info1.get(0).id);
				result[i][1]=Info1.get(0).name;
				result[i][2]=Info1.get(0).acdamic;
				result[i][3]=Info1.get(0).profession;
			}
			else
			{
				System.out.println("Info1==null");
				//System.out.println(String.valueOf(Info.get(i).id)+Info.get(i).name+Info.get(i).acdamic+Info.get(i).profession+Info.get(i).email+Info.get(i).department+Info.get(i).name2+Info.get(i).attends+Info.get(i).date);
				result[i][0]=String.valueOf(Info.get(i).id);
				result[i][1]=Info.get(i).name;
				result[i][2]="双击填写";
				result[i][3]=matter1.format(dt);
				
			}
			System.out.println("result赋值完成");
		}
		for(int i = 0;i<count;i++)
		{
			Object[]str = new Object[4*count];
			for(int j = 0;j<4;j++)
			{
				str[j]=result[i][j];		
			}
			model.addRow(str);
			
		}
		
		final JLabel Slabel = new JLabel("录入成功");
		Slabel.setBounds(10, 308, 61, 16);
		contentPane.add(Slabel);
		Slabel.setVisible(false);
		
		final JLabel Flabel = new JLabel("录入失败");
		Flabel.setForeground(new Color(153, 51, 0));
		Flabel.setBounds(10, 308, 61, 16);
		contentPane.add(Flabel);
		Flabel.setVisible(false);
		
		modifyButton = new JButton("录入");
		modifyButton.setBounds(200, 303, 75, 29);
		contentPane.add(modifyButton);
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Flabel.setVisible(false);
					Slabel.setVisible(false);
					final int row=infoTable.getSelectedRow();
					final int col=infoTable.getSelectedColumn()+1;
					if(col==1||col==0){JOptionPane.showMessageDialog(null, "禁止修改！");}
					else
					{
//						int res = JOptionPane.showConfirmDialog(null,"确认修改？","⚠️警告",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
//						if(res==JOptionPane.YES_OPTION)
//						{
							System.out.println("开始录入！");
							final Object newvalue = infoTable.getValueAt(row,col-1);
							final int Sid = Integer.parseInt(String.valueOf(infoTable.getValueAt(row,0)));
							final String name = String.valueOf(infoTable.getValueAt(row,1));
							final String attend = String.valueOf(infoTable.getValueAt(row,2));
							final String date = String.valueOf(infoTable.getValueAt(row,3));
						
							System.out.println("ָ录入信息：");
							System.out.println(" 学号:"+Sid);
							System.out.println(" 姓名:"+name);
							System.out.println("考情:"+attend);
							System.out.println("日期:"+date);
							try
							{
								Package pk = new Package();
								boolean isSucsess = pk.addAttendPackaging("addAttend",Sid,String.valueOf(Cid),attend,date,CourseName);
								if(isSucsess)
								{
									Slabel.setVisible(true);
								}
								else
								{
									Slabel.setVisible(true);
								}
						
							}
							catch(Exception f)
							{
								f.printStackTrace();
								JOptionPane.showMessageDialog(null, "修改失败！");
								Flabel.setVisible(true);
							}
							
						}
//						else if(res==JOptionPane.NO_OPTION)
//						{
//							System.out.println("取消了修改！");
//						}
//						else if(res==JOptionPane.CLOSED_OPTION)
//						{    
//							System.out.println ("关闭了修改！");
//						}	
					
					}
		});
		
		
		JButton returnbutton = new JButton("返回");
		returnbutton.setBounds(289, 303, 75, 29);
		contentPane.add(returnbutton);
		returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				 AttendsUI AUI = new AttendsUI(Cid,CourseName,Tid,action);
				   AUI.setVisible(true);
				   AttendsUI.this.setVisible(false);			
			   AttendsUI.this.setVisible(false);	
			}
		});
	
	
		
	}
}
