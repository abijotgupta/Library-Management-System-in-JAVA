package library;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
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
public class StudentRegistration extends JFrame implements ActionListener{

	private JPanel day;
	private JTextField txtUser, txtPin, txtPwd, txtFirst, txtLast,txtEmail;
	private JButton button, btnSubmit;
	private JTextArea txtAddress;
	@SuppressWarnings("rawtypes")
	private JComboBox comboState,comboYear,comboBranch,comboGender;
	private JDateChooser dateChooser;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRegistration frame = new StudentRegistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public StudentRegistration() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 50, 816, 728);
		day = new JPanel();
		day.setBackground(new Color(255, 255, 255));
		day.setToolTipText("");
		day.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 14));
		day.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		day.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(day);
		day.setLayout(null);
		
		JButton btnStudentRegistrationForm = new JButton("STUDENT REGISTRATION FORM");
		btnStudentRegistrationForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStudentRegistrationForm.setBounds(10, 10, 796, 67);
		btnStudentRegistrationForm.setHorizontalTextPosition(SwingConstants.CENTER);
		btnStudentRegistrationForm.setForeground(Color.WHITE);
		btnStudentRegistrationForm.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 44));
		btnStudentRegistrationForm.setFocusable(false);
		btnStudentRegistrationForm.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnStudentRegistrationForm.setBackground(new Color(30, 144, 255));
		day.add(btnStudentRegistrationForm);
		
		JLabel lblNewLabel = new JLabel("FIRST NAME");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(61, 103, 133, 29);
		day.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblLastName.setBounds(61, 142, 133, 29);
		day.add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("DATE OF BIRTH");
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDateOfBirth.setBounds(61, 181, 159, 29);
		day.add(lblDateOfBirth);
		
		JLabel lblEmailId = new JLabel("EMAIL ID");
		lblEmailId.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEmailId.setBounds(61, 220, 118, 29);
		day.add(lblEmailId);
		
		JLabel lblBranch = new JLabel("BRANCH");
		lblBranch.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblBranch.setBounds(61, 293, 118, 29);
		day.add(lblBranch);
		
		JLabel lblYear = new JLabel("YEAR");
		lblYear.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblYear.setBounds(61, 259, 118, 29);
		day.add(lblYear);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblGender.setBounds(61, 328, 118, 29);
		day.add(lblGender);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAddress.setBounds(61, 367, 118, 29);
		day.add(lblAddress);
		
		JLabel lblState = new JLabel("STATE/UT");
		lblState.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblState.setBounds(61, 454, 118, 29);
		day.add(lblState);
		
		JLabel lblPincode = new JLabel("PIN CODE");
		lblPincode.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPincode.setBounds(61, 493, 118, 29);
		day.add(lblPincode);
		
		JLabel lblUserName = new JLabel("USER NAME");
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUserName.setBounds(61, 532, 133, 29);
		day.add(lblUserName);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPassword.setBounds(61, 571, 133, 29);
		day.add(lblPassword);
		
		button = new JButton("BACK");
		button.addActionListener(this);
		button.setForeground(new Color(30, 144, 255));
		button.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		button.setFocusable(false);
		button.setBorder(new LineBorder(new Color(30, 144, 255)));
		button.setBackground(Color.WHITE);
		button.setBounds(402, 660, 146, 41);
		day.add(button);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(this);
		btnSubmit.setForeground(new Color(30, 144, 255));
		btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnSubmit.setFocusable(false);
		btnSubmit.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.setBounds(61, 660, 159, 41);
		day.add(btnSubmit);
		
		
		
		comboState = new JComboBox();
		comboState.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboState.setModel(new DefaultComboBoxModel(new String[] {"", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "MadHya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telagana", "Tripura", "Uttaranchal", "Uttar Pradesh", "West Bengal", "Andaman and Nicobar Islands", "Chandigarh", "Dadar and Nagar Haveli", "Daman and Diu", "Delhi", "Lakshadeep", "Pondicherry"}));
		comboState.setBounds(278, 455, 204, 29);
		day.add(comboState);
		
		comboYear = new JComboBox();
		comboYear.setModel(new DefaultComboBoxModel(new String[] {"", "Ist", "2nd", "3rd", "4th"}));
		comboYear.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboYear.setBounds(278, 261, 141, 27);
		day.add(comboYear);
		
		comboBranch = new JComboBox();
		comboBranch.setModel(new DefaultComboBoxModel(new String[] {"", "CSE", "ME", "IT", "BIO TECH", "CHE", "CIVIL", "BSc AG"}));
		comboBranch.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboBranch.setBounds(278, 295, 141, 27);
		day.add(comboBranch);
		
		comboGender = new JComboBox();
		comboGender.setModel(new DefaultComboBoxModel(new String[] {"", "MALE", "FEMALE", "OTHERS"}));
		comboGender.setName("DAY");
		comboGender.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		comboGender.setBounds(278, 330, 141, 27);
		day.add(comboGender);
		
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtUser.setColumns(10);
		txtUser.setBounds(278, 533, 204, 29);
		day.add(txtUser);
		
		txtPin = new JTextField();
		txtPin.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtPin.setColumns(10);
		txtPin.setBounds(278, 494, 204, 29);
		day.add(txtPin);
		
		txtPwd = new JTextField();
		txtPwd.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtPwd.setColumns(10);
		txtPwd.setBounds(278, 572, 204, 29);
		day.add(txtPwd);
		
		txtAddress = new JTextArea();
		txtAddress.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtAddress.setBounds(278, 373, 398, 73);
		day.add(txtAddress);
		
		txtFirst = new JTextField();
		txtFirst.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtFirst.setColumns(10);
		txtFirst.setBounds(278, 104, 204, 29);
		day.add(txtFirst);
		
		txtLast = new JTextField();
		txtLast.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtLast.setColumns(10);
		txtLast.setBounds(278, 143, 204, 29);
		day.add(txtLast);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		txtEmail.setBounds(278, 221, 398, 29);
		day.add(txtEmail);
		
	
		dateChooser = new JDateChooser();
		dateChooser.setBounds(278, 181, 141, 29);
		day.add(dateChooser);
		
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		Conn con = new Conn();
		
		if(ae.getSource() == btnSubmit)
		{
			
			try {
				
				String sql = "insert into student (firstName,lastName,dob,emailID,year,branch,gender,address,state,pincode,username,pwd) values(?,?,?,?,?,?,?,?,?,?,?,?) ";
				PreparedStatement st = con.c.prepareStatement(sql);
				
				st.setString(1, txtFirst.getText());
				st.setString(2, txtLast.getText());
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String dob = sdf.format(dateChooser.getDate());
				st.setString(3, dob);
	
				st.setString(4, txtEmail.getText());
				st.setString(5, (String)comboYear.getSelectedItem());
				st.setString(6, (String)comboBranch.getSelectedItem());
				st.setString(7, (String)comboGender.getSelectedItem());
				st.setString(8, txtAddress.getText());
				st.setString(9, (String)comboState.getSelectedItem());
				st.setString(10, txtPin.getText());
				st.setString(11, txtUser.getText());
				st.setString(12, txtPwd.getText());
				
				st.execute();
				
			
				JOptionPane.showMessageDialog(null, "Account Has Been Created!");
				
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
}
