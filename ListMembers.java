package library;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class ListMembers extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListMembers frame = new ListMembers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListMembers() {
		setTitle("Employee List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1002, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"FIRST NAME", "LAST NAME", "GENDER", "DATE OF BIRTH", "EMAILID", "USERNAME"},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
	
		table.setBounds(10, 10, 966, 300);
		contentPane.add(table);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPrint.setForeground(new Color(30, 144, 255));
		btnPrint.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnPrint.setFocusable(false);
		btnPrint.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnPrint.setBackground(Color.WHITE);
		btnPrint.setBounds(328, 320, 108, 39);
		contentPane.add(btnPrint);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminHome().setVisible(true);
			}
		});
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setForeground(new Color(30, 144, 255));
		btnBack.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnBack.setFocusable(false);
		btnBack.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(544, 320, 108, 39);
		contentPane.add(btnBack);
		
		
		
		PrintData();
	
	}
	
	@SuppressWarnings("unchecked")
	public void PrintData()
	{
		int c;
		Conn con = new Conn();
		ResultSet rs;
		String sql = "select firstName,lastName,gender,dob,emailId,userName from adminaccounts ";
		try {
			PreparedStatement st = con.c.prepareStatement(sql);
			rs = st.executeQuery();
		
			java.sql.ResultSetMetaData rad= rs.getMetaData();
			c = rad.getColumnCount();
	
			DefaultTableModel d = (DefaultTableModel)table.getModel();
			d.setRowCount(2);
		
			while(rs.next())
			{
			@SuppressWarnings("rawtypes")
				Vector v2 = new Vector();
			
				for(int i=1; i<=c; i++)
				{
					v2.add(rs.getString("firstName"));
					v2.add(rs.getString("lastName"));
					v2.add(rs.getString("gender"));
					v2.add(rs.getString("dob"));
					v2.add(rs.getString("emailId"));
					v2.add(rs.getString("userName"));
				}
			d.addRow(v2);
			}
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
