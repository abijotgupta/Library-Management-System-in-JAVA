package library;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class AdminHome extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JButton btnAddBooks, btnStatistics, btnIssueBooks, btnReturnBook, btnMembers,btnTotalFine;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
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
	public AdminHome() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1150, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(30, 144, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LIBRARY MANAGEMENT SYSTEM");
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 48));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(10, 48, 1116, 102);
		contentPane.add(btnNewButton);
		
		JLabel addBooks = new JLabel("");
		addBooks.setIcon(new ImageIcon("C:\\Users\\Abijot Gupta\\Desktop\\LIBRARY_MANAGEMENT_SYSTEM\\src\\img\\user (1).png"));
		addBooks.setBounds(39, 227, 174, 145);
		contentPane.add(addBooks);
		
		JLabel statistics = new JLabel("");
		statistics.setIcon(new ImageIcon("C:\\Users\\Abijot Gupta\\Desktop\\LIBRARY_MANAGEMENT_SYSTEM\\src\\img\\user (1).png"));
		statistics.setBounds(283, 227, 174, 145);
		contentPane.add(statistics);
		
		JLabel issueBooks = new JLabel("");
		issueBooks.setIcon(new ImageIcon("C:\\Users\\Abijot Gupta\\Desktop\\LIBRARY_MANAGEMENT_SYSTEM\\src\\img\\user (1).png"));
		issueBooks.setBounds(530, 227, 174, 145);
		contentPane.add(issueBooks);
		
		JLabel returnBook = new JLabel("");
		returnBook.setIcon(new ImageIcon("C:\\Users\\Abijot Gupta\\Desktop\\LIBRARY_MANAGEMENT_SYSTEM\\src\\img\\user (1).png"));
		returnBook.setBounds(784, 227, 192, 145);
		contentPane.add(returnBook);
		
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
		lblX.setBounds(1117, 0, 45, 35);
		contentPane.add(lblX);
		
		
		btnAddBooks = new JButton("ADD BOOKS");
		btnAddBooks.addActionListener(this);
		btnAddBooks.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 18));
		btnAddBooks.setFocusable(false);
		btnAddBooks.setForeground(new Color(30, 144, 255));
		btnAddBooks.setBackground(Color.WHITE);
		btnAddBooks.setBounds(39, 452, 174, 53);
		contentPane.add(btnAddBooks);
		
		btnStatistics = new JButton("STATISTICS");
		btnStatistics.addActionListener(this);
		btnStatistics.setForeground(new Color(30, 144, 255));
		btnStatistics.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 18));
		btnStatistics.setFocusable(false);
		btnStatistics.setBackground(Color.WHITE);
		btnStatistics.setBounds(530, 452, 174, 53);
		contentPane.add(btnStatistics);
		
		btnIssueBooks = new JButton("ISSUE BOOKS");
		btnIssueBooks.addActionListener(this);
		btnIssueBooks.setForeground(new Color(30, 144, 255));
		btnIssueBooks.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 18));
		btnIssueBooks.setFocusable(false);
		btnIssueBooks.setBackground(Color.WHITE);
		btnIssueBooks.setBounds(283, 452, 174, 53);
		contentPane.add(btnIssueBooks);
		
		btnReturnBook = new JButton("RETURN BOOK");
		btnReturnBook.addActionListener(this);
		btnReturnBook.setForeground(new Color(30, 144, 255));
		btnReturnBook.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 18));
		btnReturnBook.setFocusable(false);
		btnReturnBook.setBackground(Color.WHITE);
		btnReturnBook.setBounds(784, 452, 192, 53);
		contentPane.add(btnReturnBook);
		
		JLabel label = new JLabel("");
		label.setBounds(39, 565, 174, 145);
		contentPane.add(label);
		
		btnMembers = new JButton("MEMBERS");
		btnMembers.addActionListener(this);
		btnMembers.setForeground(new Color(30, 144, 255));
		btnMembers.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 18));
		btnMembers.setFocusable(false);
		btnMembers.setBackground(Color.WHITE);
		btnMembers.setBounds(39, 723, 174, 53);
		contentPane.add(btnMembers);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(283, 554, 174, 145);
		contentPane.add(label_1);
		
		btnTotalFine = new JButton("TOTAL FINE");
		btnTotalFine.addActionListener(this);
		btnTotalFine.setForeground(new Color(30, 144, 255));
		btnTotalFine.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 18));
		btnTotalFine.setFocusable(false);
		btnTotalFine.setBackground(Color.WHITE);
		btnTotalFine.setBounds(283, 723, 174, 53);
		contentPane.add(btnTotalFine);
		
		
		JButton btnLibraryManagementSystem = new JButton("LIBRARY MANAGEMENT SYSTEM");
		btnLibraryManagementSystem.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLibraryManagementSystem.setForeground(new Color(30, 144, 255));
		btnLibraryManagementSystem.setFocusable(false);
		btnLibraryManagementSystem.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnLibraryManagementSystem.setBackground(Color.WHITE);
	
	}
	

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == btnAddBooks)
		{
			setVisible(false);
			new AddBook().setVisible(true);		
		}
			
		if(ae.getSource() == btnStatistics)
		{
			setVisible(false);
			new Statistics().setVisible(true);		
		}
		
		if(ae.getSource() == btnIssueBooks)
		{
			setVisible(false);
			new IssueBook().setVisible(true);
		}
		
		if(ae.getSource() == btnReturnBook)
		{
			setVisible(false);
			new ReturnBook().setVisible(true);
		}
		
		if(ae.getSource() == btnMembers)
		{
			setVisible(false);
			new ListMembers().setVisible(true);
		}
		
		if(ae.getSource() == btnTotalFine)
		{
			setVisible(false);
			new FineCollection().setVisible(true);
		}
		
	}
}
