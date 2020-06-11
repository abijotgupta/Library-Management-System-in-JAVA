package library;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.ListSelectionModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Statistics extends JFrame implements ActionListener {

	private JPanel contentPane,panel;
	private JTable table;
	private JTextField search_bar;
	private JButton btnSearch,btnBack,btnDelete;
	private JButton btnPrint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistics frame = new Statistics();
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
	public Statistics() 
	{
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 690);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 88, 916, 581);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		table = new JTable();
		table.setFocusable(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setGridColor(new Color(30, 144, 255));
		table.setIntercellSpacing(new Dimension(4, 6));
		table.setName("");
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				search_bar.setText(table.getModel().getValueAt(row,5).toString());
				
			}
		});
		
		table.setBackground(new Color(255, 255, 255));
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"STUDENT ID", "STUDENT NAME", "BRANCH", "SEMESTER", "BOOK ID", "BOOK NAME", "ISSUE DATE", "RETURN DATE"},
			},
			new String[] {
				"STUDENT ID", "STUDENT NAME", "BRANCH", "SEMESTER", "BOOK ID", "BOOK NAME", "ISSUE DATE", "RETURN DATE"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(63);
		table.getColumnModel().getColumn(1).setPreferredWidth(98);
		table.getColumnModel().getColumn(2).setPreferredWidth(52);
		table.getColumnModel().getColumn(3).setPreferredWidth(62);
		table.getColumnModel().getColumn(5).setPreferredWidth(159);
		table.setBounds(10, 96, 896, 431);
		panel.add(table);
		
		
	
		
		btnSearch = new JButton("");
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setIcon(new ImageIcon("C:\\Users\\Abijot Gupta\\Desktop\\LIBRARY_MANAGEMENT_SYSTEM\\src\\Images\\Search.gif"));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnSearch.setBounds(582, 26, 53, 31);
		panel.add(btnSearch);
		
		btnDelete = new JButton("");
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setIcon(new ImageIcon("C:\\Users\\Abijot Gupta\\Desktop\\LIBRARY_MANAGEMENT_SYSTEM\\src\\Images\\delete.gif"));
		btnDelete.addActionListener(this);
		btnDelete.setBounds(645, 26, 49, 31);
		panel.add(btnDelete);
		
		btnBack = new JButton("BACK");
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setForeground(new Color(30, 144, 255));
		btnBack.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnBack.setFocusable(false);
		btnBack.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(492, 537, 110, 31);
		btnBack.addActionListener(this);
		panel.add(btnBack);
	
		
		search_bar = new JTextField();
		search_bar.setBounds(207, 26, 365, 31);
		panel.add(search_bar);
		search_bar.setColumns(10);
		
		btnPrint = new JButton("PRINT");
		btnPrint.setHorizontalTextPosition(SwingConstants.CENTER);
		btnPrint.setForeground(new Color(30, 144, 255));
		btnPrint.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnPrint.setFocusable(false);
		btnPrint.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnPrint.setBackground(Color.WHITE);
		btnPrint.setBounds(165, 537, 110, 31);
		btnPrint.addActionListener(this);
		panel.add(btnPrint);
		

		JButton btnIssuedBookDetails = new JButton("ISSUED BOOK DETAILS");
		btnIssuedBookDetails.setForeground(Color.WHITE);
		btnIssuedBookDetails.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 40));
		btnIssuedBookDetails.setFocusable(false);
		btnIssuedBookDetails.setBackground(new Color(30, 144, 255));
		btnIssuedBookDetails.setBounds(10, 32, 916, 68);
		contentPane.add(btnIssuedBookDetails);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setBounds(895, 0, 45, 35);
		contentPane.add(lblX);
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(new Color(30, 144, 255));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 18));
		
			
		 Category_Load();
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void Category_Load()
	{
		int c;
		Conn con = new Conn();
		ResultSet rs;
		String sql = "select studentID,studentName,branch,sem,bookID,bookName,dateOfIssue,submitDate from issuebooks ";
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
					v2.add(rs.getString("studentID"));
					v2.add(rs.getString("studentName"));
					v2.add(rs.getString("branch"));
					v2.add(rs.getString("sem"));
					v2.add(rs.getString("bookID"));
					v2.add(rs.getString("bookName"));
					v2.add(rs.getString("dateOfIssue"));
					v2.add(rs.getString("submitDate"));
				}
				
				d.addRow(v2);
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		Conn con = new Conn();
		
		if(ae.getSource() == btnDelete)
		{
			
			try {
				
				String sql = "delete from issuebooks where bookName = '"+search_bar.getText() + "' ";
				PreparedStatement st = con.c.prepareStatement(sql);
				
				JDialog.setDefaultLookAndFeelDecorated(true);
				int response = JOptionPane.showConfirmDialog(null, "Do you wish to continue ?","Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
		
				if(response == JOptionPane.YES_OPTION)
				{
					@SuppressWarnings("unused")
					int rs = st.executeUpdate();
					JOptionPane.showMessageDialog(null, "Deleted !!");
				}
			

				st.close();
				
			}
			
			catch(Exception e)
			{
				System.out.println("Enter Correct Details");
				//System.out.println(e);
				
			}
		}	
		
		if(ae.getSource() == btnSearch)        
		{

			try {
				
				String sql = "select * from issuebooks where bookName = '"+search_bar.getText() + "' ";
				PreparedStatement st = con.c.prepareStatement(sql);
			

				st.close();
				
			}
			
			catch(Exception e)
			{
				System.out.println("Enter Correct Details");
				
			}	
		}
		
		if(ae.getSource() == btnBack)        
		{
			this.setVisible(false);
			new AdminHome().setVisible(true);		
		}
		
		if(ae.getSource() == btnPrint)        
		{
			this.setVisible(false);
			try {
				table.print();
			} catch (PrinterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

