package library;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;


import java.awt.SystemColor;



@SuppressWarnings("serial")
public class IssueBook extends JFrame implements ActionListener, ItemListener
{

	private JPanel contentPane;
	private JTextField txtStudent,txtBookName,txtisbn,txtStuName;
	private JButton btnIssue, btnBack ;
	private JDateChooser dateChooserIssue, dateChooserReturn;
	private Choice bookChoice, studentChoice;
	
	@SuppressWarnings("rawtypes")
	private JComboBox comboBranch,comboSemester;
	private JTextField textEdition;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame = new IssueBook();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IssueBook() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 801, 723);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(30, 144, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LIBRARY MANAGEMENT SYSTEM");
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 40));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(10, 45, 766, 78);
		contentPane.add(btnNewButton);
		
		JLabel lblBookId = new JLabel("BOOK ID");
		lblBookId.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblBookId.setBounds(39, 348, 143, 29);
		contentPane.add(lblBookId);
		
		JLabel lblName = new JLabel("BOOK NAME");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblName.setBounds(39, 393, 143, 29);
		contentPane.add(lblName);
		
		JLabel lblIsbnNo = new JLabel("ISBN NO.");
		lblIsbnNo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblIsbnNo.setBounds(39, 432, 143, 29);
		contentPane.add(lblIsbnNo);
		
		JLabel lblEdition = new JLabel("EDITION");
		lblEdition.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEdition.setBounds(39, 471, 143, 29);
		contentPane.add(lblEdition);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setForeground(new Color(30, 144, 255));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblX.setBounds(741, 0, 45, 35);
		contentPane.add(lblX);
		
		
		txtStudent = new JTextField();
		txtStudent.setBounds(212, 192, 258, 29);
		contentPane.add(txtStudent);
		txtStudent.setColumns(10);
		
		txtBookName = new JTextField();
		txtBookName.setColumns(10);
		txtBookName.setBounds(212, 393, 258, 29);
		contentPane.add(txtBookName);
		
		txtisbn = new JTextField();
		txtisbn.setColumns(10);
		txtisbn.setBounds(212, 434, 258, 29);
		contentPane.add(txtisbn);
		
		
		
		JLabel lblDateOfIssue = new JLabel("DATE OF ISSUE");
		lblDateOfIssue.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDateOfIssue.setBounds(39, 510, 143, 29);
		contentPane.add(lblDateOfIssue);
		
		JLabel lblStudentId = new JLabel("STUDENT ID");
		lblStudentId.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblStudentId.setBounds(39, 194, 143, 29);
		contentPane.add(lblStudentId);
		
		JLabel lblReturnDate = new JLabel("RETURN DATE");
		lblReturnDate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblReturnDate.setBounds(39, 549, 143, 29);
		contentPane.add(lblReturnDate);
		
		JLabel lblStudentName = new JLabel("STUDENT NAME");
		lblStudentName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblStudentName.setBounds(39, 231, 143, 29);
		contentPane.add(lblStudentName);
		
		JLabel lblBranch = new JLabel("BRANCH");
		lblBranch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblBranch.setBounds(39, 270, 143, 29);
		contentPane.add(lblBranch);
		
		JLabel lblSemester = new JLabel("SEMESTER");
		lblSemester.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblSemester.setBounds(39, 309, 143, 29);
		contentPane.add(lblSemester);
		
		txtStuName = new JTextField();
		txtStuName.setColumns(10);
		txtStuName.setBounds(212, 231, 258, 29);
		contentPane.add(txtStuName);
		
		comboBranch = new JComboBox();
		comboBranch.setModel(new DefaultComboBoxModel(new String[] {"", "CSE", "IT", "ME", "ECE", "BT", "CHE", "B.Sc AGRI"}));
		comboBranch.setBounds(212, 270, 131, 29);
		contentPane.add(comboBranch);
		
		comboSemester = new JComboBox();
		comboSemester.setModel(new DefaultComboBoxModel(new String[] {"", "Ist", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th"}));
		comboSemester.setBounds(212, 309, 131, 29);
		contentPane.add(comboSemester);
		
		btnIssue = new JButton("ISSUE");
		btnIssue.addActionListener(this);
		btnIssue.setForeground(new Color(30, 144, 255));
		btnIssue.setBackground(new Color(255, 255, 255));
		btnIssue.setHorizontalTextPosition(SwingConstants.CENTER);
		btnIssue.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnIssue.setFocusable(false);
		btnIssue.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnIssue.setBounds(74, 619, 108, 39);
		contentPane.add(btnIssue);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(this);
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setForeground(new Color(30, 144, 255));
		btnBack.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnBack.setFocusable(false);
		btnBack.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(324, 619, 108, 39);
		contentPane.add(btnBack);
		
		
		bookChoice = new Choice();
		bookChoice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		bookChoice.setFocusable(false);
		bookChoice.setForeground(Color.BLACK);
		bookChoice.setBackground(Color.WHITE);
		bookChoice.setBounds(212, 355, 131, 29);
		bookChoice.add("");
		bookChoice.addItemListener(this);
		contentPane.add(bookChoice);
		
		Conn c = new Conn();
		ResultSet rs;
		try {
			rs = c.s.executeQuery("select * from addbooks");
			while(rs.next())
			{
				bookChoice.add(rs.getString("bookID"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		studentChoice = new Choice();
		studentChoice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		studentChoice.setFocusable(false);
		studentChoice.setForeground(Color.BLACK);
		studentChoice.setBackground(Color.WHITE);
		studentChoice.setBounds(212, 355, 121, 24);
		studentChoice.add("");
		contentPane.add(studentChoice);
		
		Conn c1 = new Conn();
		ResultSet rs1;
		try {
			rs1 = c1.s.executeQuery("select * from addbooks");
			while(rs1.next())
			{
				studentChoice.add(rs1.getString("bookID"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		dateChooserIssue = new JDateChooser();
		dateChooserIssue.setBounds(212, 510, 133, 29);
		contentPane.add(dateChooserIssue);
		
		dateChooserReturn = new JDateChooser();
		dateChooserReturn.setBounds(212, 549, 133, 29);
		contentPane.add(dateChooserReturn);
		
		JLabel lblNewLabel = new JLabel("ISSUE BOOK");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 24));
		lblNewLabel.setBounds(324, 141, 227, 28);
		contentPane.add(lblNewLabel);
		
		textEdition = new JTextField();
		textEdition.setColumns(10);
		textEdition.setBounds(212, 471, 258, 29);
		contentPane.add(textEdition);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		
		
		if(ae.getSource() == btnIssue)
		{
			
			try {
				Conn con = new Conn();
				String sql = "insert into issuebooks (studentID,studentName,branch,sem,bookID,bookName,isbnNo,edition,dateOfIssue,submitDate) values(?,?,?,?,?,?,?,?,?,?) ";
				PreparedStatement st = con.c.prepareStatement(sql);
			
				st.setString(1, txtStudent.getText());
				st.setString(2, txtStuName.getText());
				st.setString(3, (String)comboBranch.getSelectedItem());	
				st.setString(4, (String)comboSemester.getSelectedItem());	
				st.setString(5, bookChoice.getSelectedItem());
				st.setString(6, txtBookName.getText());
				st.setString(7, txtisbn.getText());
				st.setString(8, textEdition.getText());
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String issuedate = sdf.format(dateChooserIssue.getDate());
				st.setString(9, issuedate);
				
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
				String returndate = sdf1.format(dateChooserReturn.getDate());
				st.setString(10, returndate);
				
				st.execute();
			
				
				
				int quantity;
				ResultSet rs2;
				String sql1 = "select quantity from addbooks ";
				
					PreparedStatement st1 = con.c.prepareStatement(sql1);
					rs2 = st1.executeQuery();
					quantity = Integer.parseInt(rs2.getString("quantity"));
				
				
				String sql2 = "update addbooks set quantity='"+(quantity-1)+"' where bookID="+bookChoice;
				PreparedStatement st2 = con.c.prepareStatement(sql2);
				st2.execute();
			
				
				JOptionPane.showMessageDialog(null, "Requested Book Has Been Issued!");

				txtStudent.setText("");
				txtStuName.setText("");
				comboBranch.setSelectedItem("");
				comboSemester.setSelectedItem("");
				//txtbookID.setText("");
				txtBookName.setText("");
				txtisbn.setText("");
				textEdition.setText("");
				dateChooserIssue.setDateFormatString("");
				dateChooserReturn.setDateFormatString("");
				
				txtStudent.requestFocus();
				
				st.close();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
				
			}
		}	
		
		
		if(ae.getSource() == btnBack)        
		{
			this.setVisible(false);
			new AdminHome().setVisible(true);		
		}
		
	}
	
	public void itemStateChanged(ItemEvent e) {
		
		Conn c = new Conn();
		try {
			ResultSet rs = c.s.executeQuery("select * from addbooks where bookID="+bookChoice.getSelectedItem());
			if(rs.next())
			{
				txtBookName.setText(rs.getString("bookName"));
				txtisbn.setText(rs.getString("isbnNo"));
				textEdition.setText(rs.getString("edition"));
				
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}