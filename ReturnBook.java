package library;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class ReturnBook extends JFrame implements ActionListener {

	private JPanel contentPane,panel_1,panel_2;
	private JTextField txtID,txtName,txtBranch,txtSem,txtFine;
	private JButton btnReturn, btnSearch;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
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
	public ReturnBook() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1058, 489);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(30, 144, 255)));
		panel_1.setBounds(10, 84, 426, 393);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(446, 84, 603, 393);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER STUDENT DETAILS");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(30, 144, 255));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 18));
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setBounds(10, 10, 406, 44);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Student ID");
		lblNewLabel_2.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 90, 120, 31);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 14));
		lblStudentName.setBounds(10, 131, 120, 31);
		panel_1.add(lblStudentName);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 14));
		lblBranch.setBounds(10, 167, 120, 31);
		panel_1.add(lblBranch);
		
		JLabel lblSem = new JLabel("Sem");
		lblSem.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 14));
		lblSem.setBounds(10, 208, 120, 31);
		panel_1.add(lblSem);
		
		JLabel lblTotalFine = new JLabel("Total Fine");
		lblTotalFine.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 14));
		lblTotalFine.setBounds(10, 249, 120, 31);
		panel_1.add(lblTotalFine);
		
		txtID = new JTextField();
		txtID.setBounds(158, 97, 120, 19);
		panel_1.add(txtID);
		txtID.setColumns(10);
		
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBounds(158, 138, 120, 19);
		panel_1.add(txtName);
		
		txtBranch = new JTextField();
		txtBranch.setEditable(false);
		txtBranch.setColumns(10);
		txtBranch.setBounds(158, 174, 120, 19);
		panel_1.add(txtBranch);
		
		txtSem = new JTextField();
		txtSem.setEditable(false);
		txtSem.setColumns(10);
		txtSem.setBounds(158, 215, 120, 19);
		panel_1.add(txtSem);
		
		txtFine = new JTextField();
		txtFine.setEditable(false);
		txtFine.setColumns(10);
		txtFine.setBounds(158, 256, 120, 19);
		panel_1.add(txtFine);
		
		btnReturn = new JButton("RETURN");
		btnReturn.addActionListener(this);	
		btnReturn.setHorizontalTextPosition(SwingConstants.CENTER);
		btnReturn.setForeground(new Color(30, 144, 255));
		btnReturn.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnReturn.setFocusable(false);
		btnReturn.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnReturn.setBackground(Color.WHITE);
		btnReturn.setBounds(263, 331, 126, 38);
		panel_1.add(btnReturn);
		
		btnSearch = new JButton("Search");
		btnSearch.setMnemonic(KeyEvent.VK_ENTER);
		btnSearch.addActionListener(this);
		btnSearch.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSearch.setForeground(new Color(30, 144, 255));
		btnSearch.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnSearch.setFocusable(false);
		btnSearch.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(33, 331, 126, 38);
		panel_1.add(btnSearch);
		panel_2.setLayout(null);
		
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"BOOK ID", "BOOK NAME", "DATE OF ISSUE"},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
	
		table.setBounds(10, 6, 583, 377);
		panel_2.add(table);
		
		JButton btnReturnBook = new JButton("RETURN BOOK\r\n");
		btnReturnBook.setForeground(Color.WHITE);
		btnReturnBook.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 34));
		btnReturnBook.setFocusable(false);
		btnReturnBook.setBackground(new Color(30, 144, 255));
		btnReturnBook.setBounds(17, 27, 1032, 47);
		contentPane.add(btnReturnBook);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setForeground(new Color(30, 144, 255));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblX.setBounds(1013, 0, 45, 35);
		contentPane.add(lblX);
	}
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent ae)
	{
		Conn con = new Conn();
	
		if(ae.getSource() == btnSearch)        
		{
			
			String sql = "select studentName, branch,sem, dateOfIssue from issuebooks where studentID = '"+txtID.getText() + "' ";
			try {
				PreparedStatement st = con.c.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
			    Date date = new Date();  
			    String today = formatter.format(date);  
			   
				if(txtID.getText() == "" || rs == null)
				{
					JOptionPane.showMessageDialog(null, "Please Enter Valid ID");
				}
				
				while(rs.next())
				{
					String sName = rs.getString(1);
					String branch1 = rs.getString(2);
					String sem1 = rs.getString(3);
					String issue = rs.getString(4);
					 
					txtName.setText(sName);
					txtBranch.setText(branch1);
					txtSem.setText(sem1);
					
					 Date todayDate;
					try 
					{
						todayDate = formatter.parse(today);
						Date issueDate = formatter.parse(issue);
						long difference = todayDate.getTime() - issueDate.getTime();
						float daysBetween = (difference / (1000*60*60*24));
					  
						if(daysBetween <= 30)
						{
							txtFine.setText("0.0");
						}
						
						double fine = (daysBetween - 30) * 2;    //2 rupees per day
						txtFine.setText(""+fine);
					     
					}
					catch (ParseException e1) 
					{
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
				catch (SQLException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			//Display issued books on the table		
			
			int c;
			ResultSet rs;
			sql = "select bookID,bookName,dateOfIssue from issuebooks where studentID='"+txtID.getText() + "'";
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
						v2.add(rs.getString("bookID"));
						v2.add(rs.getString("bookName"));
						v2.add(rs.getString("dateOfIssue"));
					}
				d.addRow(v2);
				}
			
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		
		
		if(ae.getSource() == btnReturn)
		{
			
			try {
				
				String sql = "insert into fine (studentID, studentName, branch, sem, totalFIne,dateOfReturn) values(?,?,?,?,?,?) ";
				PreparedStatement st = con.c.prepareStatement(sql);
				
				st.setString(1, txtID.getText());
				st.setString(2, txtName.getText());
				st.setString(3, txtBranch.getText());
				st.setString(4, txtSem.getText());	
				st.setString(5, txtFine.getText());
				st.setString(6, new java.util.Date().toString());
				
				st.execute();
				st.close();
				
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
			}

			JOptionPane.showMessageDialog(null, "Fine Has been Paid"); 
			try {
				
				String sql = "delete from issuebooks where studentID ='"+txtID.getText()+"' ";
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
			
			catch(Exception e1)
			{
				System.out.println("Enter Correct Details");
			}
			
			txtID.setText("");
			txtName.setText("");
			txtBranch.setText("");
			txtSem.setText("");
			txtFine.setText("");
		}
		
		
	/*	if(ae.getSource() == btnFine)        
		{
			this.setVisible(false);
			new AdminHome().setVisible(true);		
		}
		*/
	}
}
	
