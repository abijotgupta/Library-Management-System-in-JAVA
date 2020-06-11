package library;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AddBook extends JFrame implements ActionListener 
{

	private JPanel contentPane;
	private JTextField txtBookId;
	private JTextField txtBookName;
	private JTextField txtISBN;
	private JTextField txtPublisher;
	private JTextField txtPrice;
	private JTextField txtPages;
	private JTextField txtAuthorName;
	@SuppressWarnings("rawtypes")
	private JComboBox comboEdition;
	private JButton btnAdd, btnBack;
	private JTextField txtQuantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
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
	public AddBook() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(30, 144, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LIBRARY MANAGEMENT SYSTEM");
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 34));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(10, 37, 648, 78);
		contentPane.add(btnNewButton);
		
		JLabel labelAddBooks = new JLabel("ADD BOOKS");
		labelAddBooks.setFocusable(false);
		labelAddBooks.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 26));
		labelAddBooks.setBounds(222, 126, 205, 45);
		contentPane.add(labelAddBooks);
		
		JLabel lblNewLabel = new JLabel("BOOK ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(39, 192, 143, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("BOOK NAME");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblName.setBounds(39, 231, 143, 29);
		contentPane.add(lblName);
		
		JLabel lblIsbnNo = new JLabel("ISBN NO.");
		lblIsbnNo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblIsbnNo.setBounds(39, 270, 143, 29);
		contentPane.add(lblIsbnNo);
		
		JLabel lblEdition = new JLabel("EDITION");
		lblEdition.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEdition.setBounds(39, 309, 143, 29);
		contentPane.add(lblEdition);
		
		JLabel lblPublisher = new JLabel("PUBLISHER");
		lblPublisher.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPublisher.setBounds(39, 390, 143, 29);
		contentPane.add(lblPublisher);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPrice.setBounds(39, 429, 143, 29);
		contentPane.add(lblPrice);
		
		JLabel lblPages = new JLabel("PAGES");
		lblPages.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPages.setBounds(39, 468, 143, 29);
		contentPane.add(lblPages);
		
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
		lblX.setBounds(623, 0, 45, 35);
		contentPane.add(lblX);
		
		txtBookId = new JTextField();
		txtBookId.setBounds(180, 194, 258, 29);
		contentPane.add(txtBookId);
		txtBookId.setColumns(10);
		
		txtBookName = new JTextField();
		txtBookName.setColumns(10);
		txtBookName.setBounds(180, 231, 258, 29);
		contentPane.add(txtBookName);
		
		txtISBN = new JTextField();
		txtISBN.setColumns(10);
		txtISBN.setBounds(180, 270, 258, 29);
		contentPane.add(txtISBN);
		
		txtPublisher = new JTextField();
		txtPublisher.setColumns(10);
		txtPublisher.setBounds(180, 392, 258, 29);
		contentPane.add(txtPublisher);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(180, 429, 131, 29);
		contentPane.add(txtPrice);
		
		txtPages = new JTextField();
		txtPages.setColumns(10);
		txtPages.setBounds(180, 468, 131, 29);
		contentPane.add(txtPages);
		
		comboEdition = new JComboBox();
		comboEdition.setModel(new DefaultComboBoxModel(new String[] {"", "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th", "13th", "14th", "15th", "16th"}));
		comboEdition.setBounds(180, 309, 131, 29);
		contentPane.add(comboEdition);
		
		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(this);
		btnAdd.setForeground(new Color(30, 144, 255));
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdd.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnAdd.setFocusable(false);
		btnAdd.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnAdd.setBounds(103, 588, 108, 39);
		contentPane.add(btnAdd);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(this);
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setForeground(new Color(30, 144, 255));
		btnBack.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnBack.setFocusable(false);
		btnBack.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(370, 588, 108, 39);
		contentPane.add(btnBack);
		
		JLabel lblAuthorName = new JLabel("AUTHOR NAME");
		lblAuthorName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAuthorName.setBounds(39, 348, 143, 29);
		contentPane.add(lblAuthorName);
		
		txtAuthorName = new JTextField();
		txtAuthorName.setColumns(10);
		txtAuthorName.setBounds(180, 348, 258, 29);
		contentPane.add(txtAuthorName);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblQuantity.setBounds(39, 507, 143, 29);
		contentPane.add(lblQuantity);
		
		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(180, 507, 131, 29);
		contentPane.add(txtQuantity);
	}
	

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == btnAdd)
		{
			
			try {
				Conn con = new Conn();
				String sql = "insert into addbooks (bookID,bookName,isbnNo,edition,authorName,publisher,price,pages,quantity) values(?,?,?,?,?,?,?,?,?) ";
				PreparedStatement st = con.c.prepareStatement(sql);
				
				st.setString(1, txtBookId.getText());
				st.setString(2, txtBookName.getText());
				st.setString(3, txtISBN.getText());
				st.setString(4, (String)comboEdition.getSelectedItem());	
				st.setString(5, txtAuthorName.getText());
				st.setString(6, txtPublisher.getText());
				st.setString(7, txtPrice.getText());
				st.setString(8, txtPages.getText());
				st.setString(9, txtQuantity.getText());
				
				st.execute();
				JOptionPane.showMessageDialog(null, "New Book Has Been Added!");
				
				
				txtBookId.setText("");
				txtBookName.setText("");
				txtISBN.setText("");
				txtAuthorName.setText("");
				txtPublisher.setText("");
				txtPrice.setText("");
				txtPages.setText("");
				comboEdition.setSelectedItem("");
				txtQuantity.setText("");
				txtBookId.requestFocus();
			
				st.close();
				
			}
			catch(Exception e)
			{
				System.out.println(e);
				//JOptionPane.showMessageDialog(null, e);
			}
		}
		
		
		
		
		if(ae.getSource() == btnBack)        
		{
			this.setVisible(false);
			new AdminHome().setVisible(true);		
		}
		
	}
}
