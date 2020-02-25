package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import model.Infomation;
import net.Client;
import net.Package;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class SearchStudent extends JFrame {

	private JPanel contentPane;
	private JTable resulttable;
	private JTextField KWtextField;
	private Vector<Infomation> Info=new Vector<Infomation>();
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					SearchStudent frame = new SearchStudent();
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
	}

	/**
	 * Create the frame.
	 */
	public SearchStudent() 
	{
		setTitle("查找学生");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 360);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(59, 22, 87, 27);
		comboBox.addItem("学号");
		comboBox.addItem("班级");
		comboBox.addItem("姓名");
		comboBox.addItem("学院");
		comboBox.addItem("专业");
		contentPane.add(comboBox);
		comboBox.setSelectedIndex(-1);
		
				
		JScrollPane js = new JScrollPane();
		js.setBounds(6, 59, 358, 250);
		contentPane.add(js);
		
		String[] headers = {"学号","姓名","学院","专业","班级"};
		Object[][] cellData =null;
		final DefaultTableModel model = new DefaultTableModel(cellData, headers) {
		  public boolean isCellEditable(int row, int column) {
		    return false;
		  }
		};
		resulttable = new JTable(model);
		resulttable.setBounds(14, 59, 479, 242);
		resulttable.setRowHeight(20);
		js.setViewportView(resulttable);
		model.setColumnCount(5);
		model.setRowCount(0);

		RowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);  
		resulttable.setRowSorter(sorter);  
	
		
		KWtextField = new JTextField();
		KWtextField.setBounds(145, 22, 158, 26);
		contentPane.add(KWtextField);
		KWtextField.setColumns(10);
		
		JLabel KWLabel = new JLabel("查询条件");
		KWLabel.setBounds(6, 24, 52, 20);
		KWLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		contentPane.add(KWLabel);
		
		JButton returnbutton = new JButton("返回");
		returnbutton.setBounds(301, 309, 63, 27);
		contentPane.add(returnbutton);
		returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				SearchStudent.this.setVisible(false);
			}
		});
		
		
	
		
		JButton searchButton = new JButton("搜索");
		searchButton.setBounds(301, 22, 63, 27);
		contentPane.add(searchButton);
		searchButton.addActionListener(new ActionListener()
		{
				public void actionPerformed(ActionEvent arg0)
			{
				
				
					model.setRowCount(0);
					System.out.println("开始查询学生信息！");
					
					Package pk = new Package();
					String standard = null;
					if(comboBox.getSelectedIndex()==-1)
					{
						if(!KWtextField.getText().equals(""))
						{
							standard = "empty";
							System.out.println("selecteditem:empty");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "关键字不能为空");
						}
						
					}
					else
					{
						standard = comboBox.getSelectedItem().toString();
						System.out.println("selecteditem:"+standard);
					}
					Info = pk.Packaging("searchStudent", KWtextField.getText(),standard);
					
					if(Info==null){JOptionPane.showMessageDialog(null, "没有相关学生信息");}
					else
					{
					
						int count = Info.size();
						String[][] result =new String[count][5];
						for(int i = 0;i<count;i++)
						{
							result[i][0]=String.valueOf(Info.get(i).id);
							result[i][1]=Info.get(i).name;
							result[i][2]=Info.get(i).acdamic;
							result[i][3]=Info.get(i).profession;
							result[i][4]=Info.get(i).name2;
							
						}
						for(int i = 0;i<count;i++)
						{
							Object[]str = new Object[5*count];
							for(int j = 0;j<5;j++)
							{
								str[j]=result[i][j];		
							}
							model.addRow(str);
							
						}
						System.out.println("学生查询成功！");

					}
				
				
				
			}
			
			
		});
		
//		resulttable.addMouseListener(new MouseAdapter() 
//		{
//			   public void mouseClicked(MouseEvent e) 
//			   {
//				   if (e.getButton() == MouseEvent.BUTTON1) 
//			   		{
//					   if (e.getClickCount() == 2)
//					   {
//						   //int col = resulttable.getModel().getColumnCount();
//						   int row = resulttable.getSelectedRow();
//						   System.out.println("row:"+(row+1));
//						   
//						   int bookid =Integer.valueOf(resulttable.getModel().getValueAt(row, 0).toString());
//						   String name =resulttable.getModel().getValueAt(row, 1).toString();
//						   String author =resulttable.getModel().getValueAt(row, 2).toString();
//						   float price =Float.valueOf(resulttable.getModel().getValueAt(row, 3).toString());
//						   String category =resulttable.getModel().getValueAt(row, 4).toString();
//						   String remark;
//						   if(resulttable.getModel().getValueAt(row, 5)!=null)
//						   {
//							   remark =resulttable.getModel().getValueAt(row, 5).toString();
//						   }
//						   else
//						   {
//							   remark = "（空）";
//						   }
//						 //  String bookinof = resulttable.getModel().getValueAt(row, 6).toString();
//						   String bookinfo =booklist.get(row).bookinfo;
//						   Bookinfo info = new Bookinfo(bookid,name,author,price,category,remark,bookinfo);
//						   info.setVisible(true);
//					   }
//			   		}
//			   }
//		});
		
		
		
		
	}
}
