package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.ImageView;

import model.Infomation;
import net.Client;
import net.Package;

import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.util.Locale;
import java.util.Vector;

public class TeacherInterface extends JFrame {

	private JPanel contentPane;
	private JLabel imagelabel;
	private Vector<Infomation> Info=new Vector<Infomation>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherInterface frame = new TeacherInterface("10002","920725","赵春泽");
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TeacherInterface(final String Tid,final String pw,String username) {
		setTitle("WELCOME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 460);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("欢迎来到小白云学生考勤管理系统");
		label.setForeground(Color.WHITE);
		label.setBounds(55, 80, 308, 54);
		label.setFont(new Font("Dialog", Font.PLAIN, 20));
		label.setBackground(Color.WHITE);
		contentPane.add(label);
				
		JLabel usernameLabel = new JLabel("欢迎您 "+username+" 老师",JLabel.CENTER);
		usernameLabel.setForeground(Color.DARK_GRAY);
		usernameLabel.setBounds(126, 229, 169, 16);
		usernameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		contentPane.add(usernameLabel);
		
		JButton personInfoButton = new JButton("个人信息");
		personInfoButton.setForeground(Color.DARK_GRAY);
		personInfoButton.setBackground(SystemColor.menu);
		personInfoButton.setBounds(42, 281, 140, 43);
		personInfoButton.setLocale(null);
		personInfoButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		contentPane.add(personInfoButton);
		personInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Package pk = new Package();
				Info = pk.packaging("searchTeacherT",Tid);
			
				TeacherInfo PI = new TeacherInfo(Info,pw);
				PI.setVisible(true);
				//UserInterface.this.setVisible(false);
			}
		});
		
		JButton teacherInfoButton = new JButton("查找学生");
		teacherInfoButton.setBounds(235, 281, 140, 43);
		teacherInfoButton.setForeground(Color.DARK_GRAY);
		teacherInfoButton.setBackground(SystemColor.menu);
		teacherInfoButton.setLocale(null);
		teacherInfoButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		contentPane.add(teacherInfoButton);
		teacherInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				SearchStudent ST = new SearchStudent();
				ST.setVisible(true);
				//UserInterface.this.setVisible(false);
			}
		});
		
		JButton studentAttendsButton = new JButton("考勤");
		studentAttendsButton.setBounds(42, 336, 140, 43);
		studentAttendsButton.setForeground(Color.DARK_GRAY);
		studentAttendsButton.setBackground(SystemColor.menu);
		studentAttendsButton.setLocale(null);
		studentAttendsButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		contentPane.add(studentAttendsButton);
		studentAttendsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
	
				AttendsUI SUI = new AttendsUI(Integer.valueOf(Tid));
				SUI.setVisible(true);
				
			}
		});
		
		
		JButton attendInfoButton = new JButton("功能考虑中");
		attendInfoButton.setLocale((Locale) null);
		attendInfoButton.setForeground(Color.DARK_GRAY);
		attendInfoButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		attendInfoButton.setBackground(Color.WHITE);
		attendInfoButton.setBounds(235, 336, 140, 43);
		contentPane.add(attendInfoButton);
		attendInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
//				AttendsInfo AI = new AttendsInfo(Tid);
//				AI.setVisible(true);
				//UserInterface.this.setVisible(false);
			}
		});

		
		JButton backtologinButton = new JButton("注销");
		backtologinButton.setForeground(Color.LIGHT_GRAY);
		backtologinButton.setBackground(Color.WHITE);
		backtologinButton.setBounds(169, 391, 79, 27);
		backtologinButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		contentPane.add(backtologinButton);
		backtologinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Login login = new Login();
				login.setVisible(true);
				TeacherInterface.this.setVisible(false);
			}
		});
		
		JLabel logoLabel = new JLabel("New label");
		logoLabel.setBackground(Color.LIGHT_GRAY);
		logoLabel.setBounds(176, 156, 61, 61);
		contentPane.add(logoLabel);
		ImageIcon logoicon=new ImageIcon("src/material/userlogo.png");
		logoicon.setImage(logoicon.getImage().getScaledInstance(61,61,Image.SCALE_DEFAULT));
		logoLabel.setIcon(logoicon);
		
		imagelabel = new JLabel("New label");
		imagelabel.setBackground(SystemColor.control);
		imagelabel.setVerticalAlignment(SwingConstants.TOP);
		imagelabel.setBounds(0, 0, 420, 438);
		contentPane.add(imagelabel);
		ImageIcon icon=new ImageIcon("src/material/login-bg4.jpg");
		icon.setImage(icon.getImage().getScaledInstance(550,200,Image.SCALE_DEFAULT));
		imagelabel.setIcon(icon);
		
	
		
		
		
	
	}
}
