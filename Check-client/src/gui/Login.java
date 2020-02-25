package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Infomation;
import net.Client;
import net.Package;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JRadioButton;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usrid;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;
	private JButton exitbutton;
	private JLabel lblNewLabel_2;
	private int startX;
    private int endX;
    private int startY;
    private int endY;
    private JLabel imagelabel;
    private Vector<Infomation> usertInfo=new Vector<Infomation>();
    String backupPW;
    
    
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setLocationRelativeTo(null);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		try { 
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) { 
				if ("Nimbus".equals(info.getName())) { 
				UIManager.setLookAndFeel(info.getClassName()); 
				break; 
				} 
				} 
				} catch (Exception e) { 
				// If Nimbus is not available, you can set the GUI to another look and feel. 
				}
		
		//String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";//windows���
		//String lookAndFeel = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";//motif���
		//String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
//		String lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel";
//		try {
//			UIManager.setLookAndFeel(lookAndFeel);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (UnsupportedLookAndFeelException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
	}


	public Login() {
		setBackground(Color.RED);

		setTitle("登录界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 525, 385);
		setBounds(100, 100, 420, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_2 = new JLabel("小白云牌学生考勤管理系统",JLabel.CENTER);
		lblNewLabel_2.setBounds(55, 80, 308, 54);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 24));
//		lblNewLabel_2.setFont(new Font("����С����_GBK",1,30));
//		lblNewLabel_2.setFont(new Font("������̱����μ���",1,30));
//		lblNewLabel_2.setFont(new Font("�������_GBK",1,30));
		lblNewLabel_2.setForeground(Color.white);
		
		JLabel lblNewLabel = new JLabel("学号");
		lblNewLabel.setBounds(74, 275, 30, 18);
		lblNewLabel.setFont(new Font("微软雅黑",0,15));
		lblNewLabel.setForeground(Color.gray);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("密码");
		lblNewLabel_1.setBounds(74, 311, 30, 18);
		lblNewLabel_1.setFont(new Font("微软雅黑",0,15));
		lblNewLabel_1.setForeground(Color.gray);
		contentPane.add(lblNewLabel_1);
		
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("教师登录");
		rdbtnNewRadioButton.setBounds(304, 272, 92, 23);
		rdbtnNewRadioButton.setFont(new Font("微软雅黑",0,15));
		rdbtnNewRadioButton.setForeground(Color.gray);
		contentPane.add(rdbtnNewRadioButton);
		
		final JLabel loginTip = new JLabel("",JLabel.CENTER);
		loginTip.setBounds(144, 244, 120, 16);
		loginTip.setFont(new Font("Dialog", Font.PLAIN, 14));
		loginTip.setForeground(Color.red);
		contentPane.add(loginTip);
		
		final JLabel IDTip = new JLabel("",JLabel.CENTER);
		IDTip.setBounds(276, 244, 120, 16);
		IDTip.setFont(new Font("Dialog", Font.PLAIN, 14));
		IDTip.setForeground(Color.gray);
		contentPane.add(IDTip);
		
		
		usrid = new JTextField();
		usrid.setBounds(116, 273, 187, 24);
//		usrname.setText("�û���");
		usrid.setForeground(Color.gray);
		contentPane.add(usrid);
		usrid.setColumns(10);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(116, 309, 187, 24);
		//passwordField.setText("����");
		contentPane.add(passwordField);
		
		JButton login = new JButton("登录");
		login.setForeground(SystemColor.window);
		login.setBackground(new Color(51, 153, 102));
		login.setBounds(115, 345, 190, 29);
		login.setFont(new Font("微软雅黑", Font.BOLD, 16));
		//login.setForeground(Color.blue);
		contentPane.add(login);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				loginTip.setText("");
				IDTip.setText("");
				if(!usrid.getText().equals("")&&passwordField.getPassword().length!=0)
				{
					
					String identity = null;;
					if(rdbtnNewRadioButton.isSelected())
					{
						identity= "teacher"; 
					}
					else
					{
						identity= "student"; 
					}
					
					Package pk = new Package();
					usertInfo = pk.LoginPackaging("login",identity,usrid.getText(),String.valueOf(passwordField.getPassword()));
					System.out.println("身份验证："+usertInfo.get(0).name);
					
					if(!usertInfo.get(0).name.equals("userdoesnotexist"))
					{	
						
						if(usertInfo.get(0).name.equals("yes"))
						{
							System.out.println("用户匹配成功！");
							if(usertInfo.get(0).acdamic.equals("student"))
							{
								UserInterface ui = new UserInterface(usrid.getText(),String.valueOf(passwordField.getPassword()),usertInfo.get(0).profession);
								ui.setVisible(true);
								Login.this.setVisible(false);
							}
							else
							{
								TeacherInterface ai = new TeacherInterface(usrid.getText(),String.valueOf(passwordField.getPassword()),usertInfo.get(0).profession);
								ai.setVisible(true);
								Login.this.setVisible(false);
							}
							
						}
						else
						{
							loginTip.setText("密码错误");
							System.out.println("密码错误！");
							
						}
						
					}
					else
					{
						loginTip.setText("用户不存在");
						System.out.println("用户不存在！");
						if(usrid.getText().length()==5)
						{
							IDTip.setText("教师登录在这里"
									+ "☟");
						}
											
					}
				}
				else
				{
					loginTip.setText("输入不能为空");
				}
				

			}
		});
		
		imagelabel = new JLabel("New label");
		imagelabel.setVerticalAlignment(SwingConstants.TOP);
		imagelabel.setBounds(0, 0, 420, 460);
		contentPane.add(imagelabel);
//		ImageIcon icon=new ImageIcon("/Users/mach/Documents/workspace/java/LWCBMS/20160514最终版.exe/material/login-bg.jpg");
		ImageIcon icon=new ImageIcon("src/material/login-bg4.jpg");
		icon.setImage(icon.getImage().getScaledInstance(550,200,Image.SCALE_DEFAULT));
		imagelabel.setIcon(icon);
		
		
		
	}
	
	
	 
	public String getBackupPW() {
		return backupPW;
	}



	public void setBackupPW(String backupPW) {
		this.backupPW = backupPW;
	}




}
