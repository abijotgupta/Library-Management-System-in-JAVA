package library;


import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.JLabel;
import java.awt.Color;

@SuppressWarnings("serial")
public class Splash extends JFrame implements Runnable {

	private JPanel contentPane;
	@SuppressWarnings("unused")
	private Object frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash frame = new Splash();
					frame.setVisible(true);
				
					int i,x=1;
					for(i=2; i<600; i+=5, x+=1)
					{
						frame.setLocation(750-((i+x)/2), 400-(i/2));
						frame.setSize(i+x, i);
						Thread.sleep(10);
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Splash() {
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("img/library2.jpg"));
		Image i = img1.getImage().getScaledInstance(750, 400, Image.SCALE_DEFAULT);
		ImageIcon img2 = new ImageIcon(i); 
		
		JLabel label = new JLabel(img2);
		contentPane.add(label);
		
		
		Thread t1 = new Thread(this);
		t1.start();
	}
	
	public void run()
	{
		try
		{
			Thread.sleep(5000);
			new Home().setVisible(true);
		}
		catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		this.setVisible(false);
	}
}
