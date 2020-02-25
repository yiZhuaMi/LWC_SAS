package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import model.Infomation;

public class CourseInfo extends JFrame {

	private JPanel contentPane;
	private JTable infoTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vector<Infomation> Info = null;
					CourseInfo frame = new CourseInfo(Info);
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
	 */
	public CourseInfo(Vector<Infomation> Info) 
	{
		setTitle("你的课表");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 370, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane js = new JScrollPane();
		js.setBounds(5, 5, 360, 297);
		contentPane.add(js);
		
		String[] headers = {"课程编号","课程名称", "任课老师"};
		Object[][] cellData =null;
		final DefaultTableModel model = new DefaultTableModel(cellData, headers) {
		  public boolean isCellEditable(int row, int column) {
		    return false;
		  }
		};
		
		infoTable = new JTable(model);
		infoTable.setBounds(14, 59, 479, 242);
		infoTable.setRowHeight(20);
		js.setViewportView(infoTable);
		model.setColumnCount(3);
		model.setRowCount(0);

		RowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);  
		infoTable.setRowSorter(sorter);  
		
		int count = Info.size();
		String[][] result =new String[count][3] ;
		for(int i = 0;i<count;i++)
		{
			result[i][0]=String.valueOf(Info.get(i).id);
			result[i][1]=Info.get(i).name;
			result[i][2]=Info.get(i).name2;
		}
		for(int i = 0;i<count;i++)
		{
			Object[]str = new Object[3*count];
			for(int j = 0;j<3;j++)
			{
				str[j]=result[i][j];		
			}
			model.addRow(str);
			
		}
		
		JButton returnbutton = new JButton("返回");
		returnbutton.setBounds(295, 303, 75, 29);
		contentPane.add(returnbutton);
		returnbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				CourseInfo.this.setVisible(false);
			}
		});
	}

}
