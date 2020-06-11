package library;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Cursor;
import com.toedter.calendar.JDateChooser;


@SuppressWarnings("serial")
public class StudentUpdate extends JFrame implements ActionListener, ItemListener{

	private JPanel day;
	private JTextField txtUser, txtPin, txtPwd, txtFirst, txtLast,txtEmail;
	private JButton button, btnUpdate;
	private JTextArea txtAddress;
	@SuppressWarnings("rawtypes")
	private JComboBox comboState,comboYear,comboBranch,comboGender;
	private JDateChooser dateChooser;
	private Choice choice;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentUpdate frame = new StudentUpdate();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public StudentUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 841, 750);
		day = new JPanel();
		day.setBackground(new Color(255, 255, 255));
		day.setToolTipText("");
		day.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 14));
		day.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		day.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(day);
		day.setLayout(null);
		
		JButton btnStudentRegistrationForm = new JButton("STUDENT UPDATE DETAILS");
		btnStudentRegistrationForm.setBounds(10, 0, 808, 67);
		btnStudentRegistrationForm.setHorizontalTextPosition(SwingConstants.CENTER);
		btnStudentRegistrationForm.setForeground(Color.WHITE);
		btnStudentRegistrationForm.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 44));
		btnStudentRegistrationForm.setFocusable(false);
		btnStudentRegistrationForm.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnStudentRegistrationForm.setBackground(new Color(30, 144, 255));
		day.add(btnStudentRegistrationForm);
		
		JLabel lblNewLabel = new JLabel("FIRST NAME");
		lblNewLabel.setBounds(61, 127, 133, 29);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		day.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setBounds(61, 166, 133, 29);
		lblLastName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		day.add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("DATE OF BIRTH");
		lblDateOfBirth.setBounds(61, 205, 159, 29);
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		day.add(lblDateOfBirth);
		
		JLabel lblEmailId = new JLabel("EMAIL ID");
		lblEmailId.setBounds(61, 244, 118, 29);
		lblEmailId.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		day.add(lblEmailId);
		
		JLabel lblBranch = new JLabel("BRANCH");
		lblBranch.setBounds(61, 322, 118, 29);
		lblBranch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		day.add(lblBranch);
		
		JLabel lblYear = new JLabel("YEAR");
		lblYear.setBounds(61, 283, 118, 29);
		lblYear.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		day.add(lblYear);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setBounds(61, 361, 118, 29);
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		day.add(lblGender);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setBounds(61, 400, 118, 29);
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		day.add(lblAddress);
		
		JLabel lblState = new JLabel("STATE/UT");
		lblState.setBounds(61, 488, 118, 29);
		lblState.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		day.add(lblState);
		
		JLabel lblPincode = new JLabel("PIN CODE");
		lblPincode.setBounds(61, 527, 118, 29);
		lblPincode.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		day.add(lblPincode);
		
		JLabel lblUserName = new JLabel("USER NAME");
		lblUserName.setBounds(61, 566, 133, 29);
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		day.add(lblUserName);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(61, 605, 133, 29);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		day.add(lblPassword);
		
		button = new JButton("BACK");
		button.setBounds(402, 660, 146, 41);
		button.addActionListener(this);
		button.setForeground(new Color(30, 144, 255));
		button.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		button.setFocusable(false);
		button.setBorder(new LineBorder(new Color(30, 144, 255)));
		button.setBackground(Color.WHITE);
		day.add(button);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(61, 660, 159, 41);
		btnUpdate.addActionListener(this);
		btnUpdate.setForeground(new Color(30, 144, 255));
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnUpdate.setFocusable(false);
		btnUpdate.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnUpdate.setBackground(Color.WHITE);
		day.add(btnUpdate);
		
		choice = new Choice();
		choice.setBounds(278, 88, 121, 22);
		choice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		choice.setFocusable(false);
		choice.setForeground(Color.BLACK);
		choice.setBackground(Color.WHITE);
		choice.add("");
		choice.addItemListener(this);
		day.add(choice);
		
		Conn c = new Conn();
		ResultSet rs;
		try {
			rs = c.s.executeQuery("select * from student");
			while(rs.next())
			{
				choice.add(rs.getString("studentID"));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		comboState = new JComboBox();
		comboState.setBounds(278, 489, 204, 29);
		comboState.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboState.setModel(new DefaultComboBoxModel(new String[] {"", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "MadHya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telagana", "Tripura", "Uttaranchal", "Uttar Pradesh", "West Bengal", "Andaman and Nicobar Islands", "Chandigarh", "Dadar and Nagar Haveli", "Daman and Diu", "Delhi", "Lakshadeep", "Pondicherry"}));
		day.add(comboState);
		
		comboYear = new JComboBox();
		comboYear.setBounds(278, 285, 141, 27);
		comboYear.setModel(new DefaultComboBoxModel(new String[] {"", "Ist", "2nd", "3rd", "4th"}));
		comboYear.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		day.add(comboYear);
		
		comboBranch = new JComboBox();
		comboBranch.setBounds(278, 324, 141, 27);
		comboBranch.setModel(new DefaultComboBoxModel(new String[] {"", "CSE", "ME", "IT", "BIO TECH", "CHE", "CIVIL", "BSc AG"}));
		comboBranch.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		day.add(comboBranch);
		
		comboGender = new JComboBox();
		comboGender.setBounds(278, 363, 141, 27);
		comboGender.setModel(new DefaultComboBoxModel(new String[] {"", "MALE", "FEMALE", "OTHERS"}));
		comboGender.setName("DAY");
		comboGender.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		day.add(comboGender);
		
		
		txtUser = new JTextField();
		txtUser.setBounds(278, 567, 204, 29);
		txtUser.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtUser.setColumns(10);
		day.add(txtUser);
		
		txtPin = new JTextField();
		txtPin.setBounds(278, 528, 204, 29);
		txtPin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtPin.setColumns(10);
		day.add(txtPin);
		
		txtPwd = new JTextField();
		txtPwd.setBounds(278, 606, 204, 29);
		txtPwd.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtPwd.setColumns(10);
		day.add(txtPwd);
		
		txtAddress = new JTextArea();
		txtAddress.setBounds(278, 406, 398, 73);
		txtAddress.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		day.add(txtAddress);
		
		txtFirst = new JTextField();
		txtFirst.setBounds(278, 128, 204, 29);
		txtFirst.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtFirst.setColumns(10);
		day.add(txtFirst);
		
		txtLast = new JTextField();
		txtLast.setBounds(278, 167, 204, 29);
		txtLast.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtLast.setColumns(10);
		day.add(txtLast);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(278, 245, 398, 29);
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		day.add(txtEmail);
		
	
		dateChooser = new JDateChooser();
		dateChooser.setBounds(278, 205, 141, 29);
		day.add(dateChooser);
		
		JLabel lblStudentId = new JLabel("STUDENT ID");
		lblStudentId.setBounds(61, 88, 133, 29);
		lblStudentId.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		day.add(lblStudentId);
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		Conn con = new Conn();
		
		if(ae.getSource() == btnUpdate)
		{
			String id = choice.getSelectedItem();
			String firstName = txtFirst.getText();
			String lastName = txtLast.getText();
			String email = txtEmail.getText();
			String year = (String) comboYear.getSelectedItem();
			String branch = (String) comboBranch.getSelectedItem();
			String gender = (String) comboGender.getSelectedItem();
			String address = txtAddress.getText();
			String state = (String) comboState.getSelectedItem();
			String pin = txtPin.getText();
			String user = txtUser.getText();
			String pwd = txtPwd.getText();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String dob = sdf.format(dateChooser.getDate());
			
			try {
				
				String sql = "update student set firstName='"+firstName+"',lastName='"+lastName+"',emailID='"+email+"',year='"+year+"',branch='"+branch+"',gender='"+gender+"',address='"+address+"',state='"+state+"',pincode='"+pin+"',username='"+user+"',pwd='"+pwd+"',dob='"+dob+"' where studentID="+id;
				PreparedStatement st = con.c.prepareStatement(sql);
				
				st.execute();
				
			
				JOptionPane.showMessageDialog(null, "Account Has Been Updated!");
				
				txtFirst.setText(" ");
				txtLast.setText(" ");
				dateChooser.setDateFormatString("");
				txtEmail.setText(" ");
				comboYear.setSelectedItem("");
				comboBranch.setSelectedItem("");
				comboGender.setSelectedItem("");
				txtAddress.setText(" ");
				comboState.setSelectedItem("");
				txtPin.setText(" ");
				txtUser.setText(" ");
				txtPwd.setText(" ");
				
				txtFirst.requestFocus();
				
				st.close();
				
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
			}
		}	
		
		if(ae.getSource() == button)        
		{
			this.setVisible(false);
			new StudentLogI().setVisible(true);		
		}
		
	}
	
	public void itemStateChanged(ItemEvent e) {
		
		Conn c = new Conn();
		try {
			ResultSet rs = c.s.executeQuery("select * from student where studentID="+choice.getSelectedItem());
			if(rs.next())
			{
				txtFirst.setText(rs.getString(2));
				txtLast.setText(rs.getString(3));
				dateChooser.setDateFormatString(rs.getString(4));
				txtEmail.setText(rs.getString(5));
				comboYear.setSelectedItem(rs.getString(6));
				comboBranch.setSelectedItem(rs.getString(7));
				comboGender.setSelectedItem(rs.getString(8));
				txtAddress.setText(rs.getString(9));
				comboState.setSelectedItem(rs.getString(10));
				txtPin.setText(rs.getString(11));
				txtUser.setText(rs.getString(12));
				txtPwd.setText(rs.getString(13));
				
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
