package library;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


@SuppressWarnings("serial")
public class Home extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JButton btnAdmin, btnStudent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 993, 599);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(30, 144, 255), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JButton header = new JButton("LIBRARY MANAGEMENT SYSTEM");
		header.setHorizontalTextPosition(SwingConstants.CENTER);
		header.setForeground(Color.WHITE);
		header.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 48));
		header.setFocusable(false);
		header.setBorder(new LineBorder(new Color(30, 144, 255)));
		header.setBackground(new Color(30, 144, 255));
		header.setBounds(10, 36, 954, 89);
		contentPane.add(header);
		
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
		lblX.setBounds(948, 0, 45, 35);
		contentPane.add(lblX);
		
		JLabel lblAdmin = new JLabel("");
		lblAdmin.setIcon(new ImageIcon("C:\\Users\\Abijot Gupta\\Desktop\\LIBRARY_MANAGEMENT_SYSTEM\\src\\img\\admin1.png"));
		lblAdmin.setBounds(117, 167, 261, 280);
		contentPane.add(lblAdmin);
		
		JLabel lblStudent = new JLabel("");
		lblStudent.setIcon(new ImageIcon("C:\\Users\\Abijot Gupta\\Desktop\\LIBRARY_MANAGEMENT_SYSTEM\\src\\img\\stud.png"));
		lblStudent.setBounds(674, 167, 261, 280);
		contentPane.add(lblStudent);
		
		btnAdmin = new JButton("ADMIN");
		btnAdmin.addActionListener(this);
		btnAdmin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdmin.setForeground(new Color(30, 144, 255));
		btnAdmin.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnAdmin.setFocusable(false);
		btnAdmin.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnAdmin.setBackground(Color.WHITE);
		btnAdmin.setBounds(136, 489, 184, 52);
		contentPane.add(btnAdmin);
		
		btnStudent = new JButton("STUDENT");
		btnStudent.addActionListener(this);
		btnStudent.setHorizontalTextPosition(SwingConstants.CENTER);
		btnStudent.setForeground(new Color(30, 144, 255));
		btnStudent.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 22));
		btnStudent.setFocusable(false);
		btnStudent.setBorder(new LineBorder(new Color(30, 144, 255)));
		btnStudent.setBackground(Color.WHITE);
		btnStudent.setBounds(702, 489, 184, 52);
		contentPane.add(btnStudent);
		
	}

	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource() == btnAdmin)
		{
			this.setVisible(false);
			new AdminLogIn().setVisible(true);		
		}
		
		if(ae.getSource() == btnStudent)
		{
			this.setVisible(false);
			new StudentLogI().setVisible(true);		
		}
	}
}
