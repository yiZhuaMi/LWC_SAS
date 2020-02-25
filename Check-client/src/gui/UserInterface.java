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

public class UserInterface extends JFrame {

	private JPanel contentPane;
	private JLabel imagelabel;
	public String userid;
	private Vector<Infomation> Info=new Vector<Infomation>();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface("2014214199","1","小白云");
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserInterface(final String userid,final String pw,String username) {
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
		label.setBounds(58, 77, 307, 49);
		label.setFont(new Font("Dialog", Font.PLAIN, 20));
		label.setBackground(Color.WHITE);
		contentPane.add(label);
				
		JLabel usernameLabel = new JLabel("欢迎您 "+username+" 同学",JLabel.CENTER);
		usernameLabel.setForeground(Color.DARK_GRAY);
		usernameLabel.setBounds(126, 229, 169, 16);
		usernameLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		contentPane.add(usernameLabel);
		
		JButton personInfoButton = new JButton("个人信息");
//		ImageIcon buttonIcon=new ImageIcon("src/material/gSButton.png");
//		buttonIcon.setImage(buttonIcon.getImage().getScaledInstance(61,61,Image.SCALE_DEFAULT));
//		personInfoButton.setIcon(buttonIcon);
		personInfoButton.setForeground(Color.DARK_GRAY);
		personInfoButton.setBackground(SystemColor.menu);
		personInfoButton.setBounds(42, 281, 140, 43);
//		personInfoButton.setBounds(42, 281, 61, 61);
		personInfoButton.setLocale(null);
		personInfoButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		contentPane.add(personInfoButton);
		personInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Package pk = new Package();
				
				Info = pk.Packaging("searchStudent",userid,"empty");
			
				PersonInfo PI = new PersonInfo( Integer.valueOf(Info.get(0).id),
												Info.get(0).name,
												Info.get(0).acdamic,
												Info.get(0).profession,
												Info.get(0).email,
												Info.get(0).name2,
												Info.get(0).date,
												pw);
				
				PI.setVisible(true);
				//UserInterface.this.setVisible(false);
			}
		});
		
		JButton teacherInfoButton = new JButton("教师信息");
		teacherInfoButton.setBounds(235, 281, 140, 43);
		teacherInfoButton.setForeground(Color.DARK_GRAY);
		teacherInfoButton.setBackground(SystemColor.menu);
		teacherInfoButton.setLocale(null);
		teacherInfoButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		contentPane.add(teacherInfoButton);
		teacherInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Package pk = new Package();
				Info = pk.SSearchTeacherpackaging("searchTeacher");
			
				STeacherInfo STI = new STeacherInfo(Info);
				STI.setVisible(true);
				//UserInterface.this.setVisible(false);
			}
		});
		
		JButton courseInfoButton = new JButton("课表信息");
		courseInfoButton.setBounds(42, 336, 140, 43);
		courseInfoButton.setForeground(Color.DARK_GRAY);
		courseInfoButton.setBackground(SystemColor.menu);
		courseInfoButton.setLocale(null);
		courseInfoButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		contentPane.add(courseInfoButton);
		courseInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Package pk = new Package();
				Info = pk.packaging("searchCourse",userid);
			
				CourseInfo STI = new CourseInfo(Info);
				STI.setVisible(true);
				//UserInterface.this.setVisible(false);
			}
		});
		
		
		JButton attendInfoButton = new JButton("考勤信息");
		attendInfoButton.setLocale((Locale) null);
		attendInfoButton.setForeground(Color.DARK_GRAY);
		attendInfoButton.setFont(new Font("Dialog", Font.PLAIN, 15));
		attendInfoButton.setBackground(Color.WHITE);
		attendInfoButton.setBounds(235, 336, 140, 43);
		contentPane.add(attendInfoButton);
		attendInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				AttendsInfo AI = new AttendsInfo(userid);
				AI.setVisible(true);
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
				UserInterface.this.setVisible(false);
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
