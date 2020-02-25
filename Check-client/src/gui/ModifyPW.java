package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import net.Package;
import java.awt.Color;


public class ModifyPW extends JFrame {

	private JPanel contentPane;
	boolean isSucsess;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyPW frame = new ModifyPW("小白云","");
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
	public ModifyPW(final String userId,final String pw) {
		setTitle("修改密码");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("原密码");
		lblNewLabel.setBounds(34, 26, 39, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("新密码");
		lblNewLabel_1.setBounds(34, 64, 39, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("确认");
		lblNewLabel_2.setBounds(34, 103, 39, 16);
		contentPane.add(lblNewLabel_2);
		
		final JLabel USTips = new JLabel("新密码不一致");
		USTips.setForeground(new Color(153, 0, 0));
		USTips.setBounds(112, 137, 81, 16);
		contentPane.add(USTips);
		USTips.setVisible(false);
		
		final JLabel OPWTips = new JLabel("原始密码错误");
		OPWTips.setForeground(new Color(153, 0, 0));
		OPWTips.setBounds(112, 137, 81, 16);
		contentPane.add(OPWTips);
		OPWTips.setVisible(false);
		
		final JPasswordField oldPW = new JPasswordField();
		oldPW.setBounds(85, 20, 134, 28);
		contentPane.add(oldPW);
		oldPW.setColumns(10);
		
		final JPasswordField newPW = new JPasswordField();
		newPW.setBounds(85, 58, 134, 28);
		contentPane.add(newPW);
		newPW.setColumns(10);
		
		final JPasswordField confirmPW = new JPasswordField();
		confirmPW.setBounds(85, 97, 134, 28);
		contentPane.add(confirmPW);
		confirmPW.setColumns(10);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.setBounds(244, 159, 66, 29);
		contentPane.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				ModifyPW.this.setVisible(false);
			}
		});
		
		JButton modifybutton = new JButton("修改");
		modifybutton.setBounds(173, 159, 66, 29);
		contentPane.add(modifybutton);
		modifybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				if(String.valueOf(newPW.getPassword()).equals(String.valueOf(confirmPW.getPassword())))
				{
					USTips.setVisible(false);
					
					
					if(String.valueOf(oldPW.getPassword()).equals(pw))
					{
						OPWTips.setVisible(false);
						
						Package pk = new Package();
						
						isSucsess = pk.MPWpackaging("modifyPWT", String.valueOf(newPW.getPassword()), userId);
						
						if(isSucsess)
						{
							JOptionPane.showMessageDialog(null, "修改密码成功！");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "修改密码失败！");
						}
					}
					else
					{
						OPWTips.setVisible(true);
					}
						
				}
				else
				{
					USTips.setVisible(true);
				}
				
				
				
			}
		});
	}
}
