package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import net.Package;

public class PersonInfo extends JFrame {

	private JPanel contentPane;
	private JTextField nameL;
	private JTextField idL;
	private JTextField acdamicL;
	private JTextField professionL;
	private JTextField classesL;
	private JTextField emailL;
	JButton saveButton;
	JButton modifyButton;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonInfo frame = new PersonInfo(1,"","","","","","","");
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param string 
	 */
	public PersonInfo(int id,final String name,String acdamic,String profession,String email,String ClassId,String logo,final String pw)
	{
		setTitle("个人信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 360);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel name_label = new JLabel("姓名：");
		name_label.setBounds(30, 30, 39, 22);
		contentPane.add(name_label);
		
		JLabel id_label = new JLabel();
		id_label.setText("学号：");
		id_label.setBounds(30, 64, 39, 22);
		contentPane.add(id_label);
		
		JLabel acdamic_label = new JLabel();
		acdamic_label.setText("学院：");
		acdamic_label.setBounds(30, 98, 39, 22);
		contentPane.add(acdamic_label);
		
		JLabel profession_label = new JLabel();
		profession_label.setText("专业：");
		profession_label.setBounds(30, 132, 39, 22);
		contentPane.add(profession_label);
		
		JLabel classes_label = new JLabel();
		classes_label.setText("班级：");
		classes_label.setBounds(30, 166, 39, 22);
		contentPane.add(classes_label);
		
		JLabel email_label = new JLabel();
		email_label.setText("邮箱：");
		email_label.setBounds(30, 200, 39, 22);
		contentPane.add(email_label);
		
		final JLabel SSTips = new JLabel("保存成功");
		SSTips.setForeground(new Color(153, 0, 0));
		SSTips.setBounds(81, 241, 61, 24);
		contentPane.add(SSTips);
		SSTips.setVisible(false);
		
		final JLabel SFTips = new JLabel("保存失败");
		SFTips.setForeground(new Color(153, 0, 0));
		SFTips.setBounds(81, 241, 61, 24);
		contentPane.add(SFTips);
		SFTips.setVisible(false);
		
		nameL = new JTextField(name);
		nameL.setBounds(81, 33, 141, 24);
		nameL.setEditable(false);
		contentPane.add(nameL);
		final String nametext = nameL.getText();
		
		idL = new JTextField(String.valueOf(id));
		idL.setBounds(81, 67, 141, 24);
		idL.setEditable(false);
		contentPane.add(idL);
		final String idtext = idL.getText();
		
		acdamicL = new JTextField(acdamic);
		acdamicL.setBounds(81, 101, 141, 24);
		acdamicL.setEditable(false);
		contentPane.add(acdamicL);
		final String acdamictext = acdamicL.getText();
		
		professionL = new JTextField(profession);
		professionL.setBounds(81, 135, 141, 24);
		professionL.setEditable(false);
		contentPane.add(professionL);
		final String professiontext = professionL.getText();
		
		classesL = new JTextField(ClassId);
		classesL.setBounds(81, 169, 141, 24);
		classesL.setEditable(false);
		contentPane.add(classesL);
		final String classtext = classesL.getText();
		
		emailL = new JTextField(email);
		emailL.setEditable(false);
		emailL.setBounds(81, 205, 141, 24);
		contentPane.add(emailL);
		
		JButton returnbutton = new JButton("返回");
		returnbutton.setBounds(278, 303, 75, 29);
		contentPane.add(returnbutton);
		returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
//				UserInterface.setVisible(true);
				PersonInfo.this.setVisible(false);
			}
		});
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setBackground(Color.LIGHT_GRAY);
		imageLabel.setBounds(253, 33, 100, 140);
		contentPane.add(imageLabel);
		ImageIcon logoicon=new ImageIcon(logo);
		logoicon.setImage(logoicon.getImage().getScaledInstance(100,140,Image.SCALE_DEFAULT));
		imageLabel.setIcon(logoicon);
		
		modifyButton = new JButton("修改资料");
		modifyButton.setBounds(6, 303, 83, 29);
		contentPane.add(modifyButton);
		modifyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane.showMessageDialog(null, "非法操作！只有管理员有权修改");
//				System.out.println("name:"+nametext);
//				modifyButton.setVisible(false);
//				saveButton.setVisible(true);
//				nameL.setEditable(true);
//				acdamicL.setEditable(true);
//				professionL.setEditable(true);
//				emailL.setEditable(true);
			}
		});
		
		saveButton = new JButton("保存");
		saveButton.setBounds(6, 303, 83, 29);
		contentPane.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				System.out.println("name:"+nametext);
				modifyButton.setVisible(true);
				saveButton.setVisible(false);
				nameL.setEditable(false);
				acdamicL.setEditable(false);
				professionL.setEditable(false);
				classesL.setEditable(false);
				emailL.setEditable(false);
				
				Package pk = new Package();
				if(pk.StudentUpdatepackaging("update", nameL.getText(),idL.getText(),acdamicL.getText(),professionL.getText(),classesL.getText(),emailL.getText()))
				{
					SSTips.setVisible(true);
				}
				else
				{
					SFTips.setVisible(true);
				}
				
			}
		});
		
		JButton modifyPWButton = new JButton("修改密码");
		modifyPWButton.setBounds(90, 303, 83, 29);
		contentPane.add(modifyPWButton);
		modifyPWButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				ModifyPW MPW = new ModifyPW(name,pw);
				MPW.setVisible(true);
			}
		});
	}
}
