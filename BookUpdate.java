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
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class BookUpdate extends JFrame implements ActionListener, ItemListener 
{

	private JPanel contentPane;
	private JTextField txtBookName;
	private JTextField txtISBN;
	private JTextField txtPublisher;
	private JTextField txtPrice;
	private JTextField txtPages;
	private JTextField txtAuthorName;
	@SuppressWarnings("rawtypes")
	private JComboBox comboEdition;
	private JButton btnUpdate, btnBack;
	private Choice choice;
	private JTextField txtQuantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookUpdate frame = new BookUpdate();
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
	public BookUpdate() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 566);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(30, 144, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("UPDATE BOOK DETAILS");
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 34));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(10, 37, 549, 78);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("BOOK ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(39, 152, 131, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("BOOK NAME");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblName.setBounds(39, 192, 143, 29);
		contentPane.add(lblName);
		
		JLabel lblIsbnNo = new JLabel("ISBN NO.");
		lblIsbnNo.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblIsbnNo.setBounds(39, 231, 143, 29);
		contentPane.add(lblIsbnNo);
		
		JLabel lblEdition = new JLabel("EDITION");
		lblEdition.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEdition.setBounds(39, 270, 143, 29);
		contentPane.add(lblEdition);
		
		JLabel lblPublisher = new JLabel("PUBLISHER");
		lblPublisher.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPublisher.setBounds(39, 348, 143, 29);
		contentPane.add(lblPublisher);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPrice.setBounds(39, 387, 143, 29);
		contentPane.add(lblPrice);
		
		JLabel lblPages = new JLabel("PAGES");
		lblPages.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPages.setBounds(39, 426, 143, 29);
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
		lblX.setBounds(535, 0, 45, 35);
		contentPane.add(lblX);
		
		choice = new Choice();
		choice.setBounds(176, 152, 131, 29);
		choice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		choice.setFocusable(false);
		choice.setForeground(Color.BLACK);
		choice.setBackground(Color.WHITE);
		choice.add("");
		choice.addItemListener(this);
		contentPane.add(choice);
		
		Conn c = new Conn();
		ResultSet rs;
		try {
			rs = c.s.executeQuery("select * from addbooks");
			while(rs.next())
			{
				choice.add(rs.getString("bookID"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		txtBookName = new JTextField();
		txtBookName.setColumns(10);
		txtBookName.setBounds(176, 194, 258, 29);
		contentPane.add(txtBookName);
		
		txtISBN = new JTextField();
		txtISBN.setColumns(10);
		txtISBN.setBounds(176, 233, 258, 29);
		contentPane.add(txtISBN);
		
		txtPublisher = new JTextField();
		txtPublisher.setColumns(10);
		txtPublisher.setBounds(176, 350, 258, 29);
		contentPane.add(txtPublisher);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(176, 387, 131, 29);
		contentPane.add(txtPrice);
		
		txtPages = new JTextField();
		txtPages.setColumns(10);
		txtPages.setBounds(176, 426, 131, 29);
		contentPane.add(txtPages);
		
		comboEdition = new JComboBox();
		comboEdition.setModel(new DefaultComboBoxModel(new String[] {"", "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th", "11th", "12th", "13th", "14th", "15th", "16th"}));
		comboEdition.setBounds(176, 272, 131, 29);
		contentPane.add(comboEdition);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(this);
		btnUpdate.setForeground(new Color(30, 144, 255));
		btnUpdate.setBackground(new Color(255, 255, 255));
		btnUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUpdate.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnUpdate.setFocusable(false);
		btnUpdate.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnUpdate.setBounds(39, 512, 108, 39);
		contentPane.add(btnUpdate);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(this);
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setForeground(new Color(30, 144, 255));
		btnBack.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnBack.setFocusable(false);
		btnBack.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(326, 512, 108, 39);
		contentPane.add(btnBack);
		
		JLabel lblAuthorName = new JLabel("AUTHOR NAME");
		lblAuthorName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAuthorName.setBounds(39, 309, 143, 29);
		contentPane.add(lblAuthorName);
		
		txtAuthorName = new JTextField();
		txtAuthorName.setColumns(10);
		txtAuthorName.setBounds(176, 309, 258, 29);
		contentPane.add(txtAuthorName);
		
		JLabel lblQuantity = new JLabel("QUANTITY");
		lblQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblQuantity.setBounds(39, 465, 143, 29);
		contentPane.add(lblQuantity);
		
		txtQuantity = new JTextField();
		txtQuantity.setColumns(10);
		txtQuantity.setBounds(176, 465, 131, 29);
		contentPane.add(txtQuantity);
	}
	

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == btnUpdate)
		{
			
			String id = choice.getSelectedItem();
			String bookName = txtBookName.getText();
			String isbn = txtISBN.getText();
			String edition = (String) comboEdition.getSelectedItem();
			String author = txtAuthorName.getText();
			String publisher = txtPublisher.getText();
			String price = txtPrice.getText();
			String pages = txtPages.getText();
			String quantity = txtQuantity.getText();
			
			try {
				Conn con = new Conn();
				String sql = "update addbooks set bookName='"+bookName+"',isbnNo='"+isbn+"',edition='"+edition+"',authorName='"+author+"',publisher='"+publisher+"',price='"+price+"',pages='"+pages+"',quantity='"+quantity+"' where bookID="+id;
				PreparedStatement st = con.c.prepareStatement(sql);
				
				st.execute();
				
			
				JOptionPane.showMessageDialog(null, "Book Details Has Been Updated!");
				
				txtBookName.setText("");
				txtISBN.setText("");
				txtAuthorName.setText("");
				txtPublisher.setText("");
				txtPrice.setText("");
				txtPages.setText("");
				txtQuantity.setText("");
				comboEdition.setSelectedItem("");
				
				txtBookName.requestFocus();
			
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

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
		Conn c = new Conn();
		try {
			ResultSet rs = c.s.executeQuery("select * from addbooks where bookID="+choice.getSelectedItem());
			if(rs.next())
			{
				txtBookName.setText(rs.getString(3));
				txtISBN.setText(rs.getString(4));
				comboEdition.setSelectedItem(rs.getString(5));
				txtAuthorName.setText(rs.getString(6));
				txtPublisher.setText(rs.getString(7));
				txtPrice.setText(rs.getString(8));
				txtPages.setText(rs.getString(9));
				txtQuantity.setText(rs.getString(10));
				
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
}
