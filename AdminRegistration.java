package library;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;


@SuppressWarnings("serial")
public class AdminRegistration extends JFrame implements ActionListener 
{

	private JPanel contentPane;
	private JTextField txtfirstName, txtlastName, txtre_Pwd, txtemailId, txtuserName;
	private JButton btnSubmit, btnBack;
	@SuppressWarnings("rawtypes")
	private JComboBox comboGender;
	private JPasswordField passwordField;
	JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminRegistration frame = new AdminRegistration();
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
	public AdminRegistration() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 625);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setToolTipText("");
		contentPane.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 14));
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdminRegistrationForm = new JButton("Admin REGISTRATION FORM");
		btnAdminRegistrationForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdminRegistrationForm.setBounds(10, 36, 782, 79);
		btnAdminRegistrationForm.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdminRegistrationForm.setForeground(new Color(255, 255, 255));
		btnAdminRegistrationForm.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 48));
		btnAdminRegistrationForm.setFocusable(false);
		btnAdminRegistrationForm.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnAdminRegistrationForm.setBackground(new Color(30, 144, 255));
		contentPane.add(btnAdminRegistrationForm);
		
		JLabel lblFirstName = new JLabel("FIRST NAME");
		lblFirstName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblFirstName.setBounds(61, 184, 133, 29);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblLastName.setBounds(61, 223, 133, 29);
		contentPane.add(lblLastName);
		
		JLabel lblDateOfBirth = new JLabel("DATE OF BIRTH");
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblDateOfBirth.setBounds(61, 301, 159, 29);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblEmailId = new JLabel("EMAIL ID");
		lblEmailId.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEmailId.setBounds(61, 340, 118, 29);
		contentPane.add(lblEmailId);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblGender.setBounds(61, 262, 118, 29);
		contentPane.add(lblGender);
		
		JLabel lblUserName = new JLabel("USER NAME");
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUserName.setBounds(61, 379, 133, 29);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPassword.setBounds(61, 418, 133, 29);
		contentPane.add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("RE-TYPE PASSWORD");
		lblReenterPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblReenterPassword.setBounds(61, 457, 238, 29);
		contentPane.add(lblReenterPassword);
		
	
		
		
		txtfirstName = new JTextField();
		txtfirstName.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 14));
		txtfirstName.setColumns(10);
		txtfirstName.setBounds(340, 185, 204, 29);
		contentPane.add(txtfirstName);
		
		txtlastName = new JTextField();
		txtlastName.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 14));
		txtlastName.setColumns(10);
		txtlastName.setBounds(340, 224, 204, 29);
		contentPane.add(txtlastName);
		
		
		
		txtemailId = new JTextField();
		txtemailId.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 14));
		txtemailId.setColumns(10);
		txtemailId.setBounds(340, 341, 398, 29);
		contentPane.add(txtemailId);
		
		
		
		txtuserName = new JTextField();
		txtuserName.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 14));
		txtuserName.setColumns(10);
		txtuserName.setBounds(340, 380, 204, 29);
		contentPane.add(txtuserName);
		
		
		
		txtre_Pwd = new JTextField();
		txtre_Pwd.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 14));
		txtre_Pwd.setBounds(340, 458, 204, 29);
		contentPane.add(txtre_Pwd);
		txtre_Pwd.setColumns(10);
		
		
		
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(this);
		btnSubmit.setForeground(new Color(30, 144, 255));
		btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnSubmit.setFocusable(false);
		btnSubmit.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.setBounds(61, 555, 133, 43);
		contentPane.add(btnSubmit);
		
		
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
		lblX.setBounds(761, 0, 45, 35);
		contentPane.add(lblX);
		
		
		
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(this);
		btnBack.setForeground(new Color(30, 144, 255));
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnBack.setFocusable(false);
		btnBack.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(411, 555, 133, 43);
		contentPane.add(btnBack);
		
		comboGender = new JComboBox();
		comboGender.setModel(new DefaultComboBoxModel(new String[] {"", "MALE", "FEMALE", "OTHERS"}));
		comboGender.setName("DAY");
		comboGender.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 14));
		comboGender.setBounds(340, 264, 141, 27);
		contentPane.add(comboGender);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 14));
		passwordField.setEchoChar('*');
		passwordField.setBounds(340, 419, 204, 29);
		contentPane.add(passwordField);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(340, 301, 141, 29);
		contentPane.add(dateChooser);
		
	}
		
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource() == btnSubmit)
			{
				
				try {
					Conn con = new Conn();
					
					String sql = "insert into adminaccounts (firstName,lastName,gender,dob,emailId,userName,password,rePassword) values(?,?,?,?,?,?,?,?) ";
					PreparedStatement st = con.c.prepareStatement(sql);
					
					st.setString(1, txtfirstName.getText());
					st.setString(2, txtlastName.getText());
					st.setString(3, (String)comboGender.getSelectedItem());
					st.setString(4, (String)dateChooser.getDateFormatString());	
					st.setString(5, txtemailId.getText());
					st.setString(6, txtuserName.getText());
					st.setString(7, passwordField.getText());
					st.setString(8, txtre_Pwd.getText());
					
					st.execute();
					
				
					JOptionPane.showMessageDialog(null, "Account Has Been Created!");
					
					txtfirstName.setName("");
					txtlastName.setName("");
					comboGender.setSelectedItem("");
					dateChooser.setDateFormatString("");
					txtemailId.setName("");
					txtuserName.setName("");
					passwordField.setName("");
					txtre_Pwd.setName("");
					
					st.close();
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
				}
			}	
			
			if(ae.getSource() == btnBack)        
			{
				this.setVisible(false);
				new AdminLogI().setVisible(true);		
			}
			
		}
}