package library;

import java.sql.*;
//@SuppressWarnings("serial")

public class Conn {
	
	Connection c;
	Statement s;
	public Conn() {
		try {
		//	Class.forName("com.mysql.cj.jdbc.Driver");    //.cj is new
			
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system","root","abijot125");
			//System.out.println("Connection established");
			s = c.createStatement();
			//System.out.println("Statement created");
		
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	

}
