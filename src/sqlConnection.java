
import java.sql.*;

import javax.swing.JOptionPane;

public class sqlConnection {
	
	Connection conn = null;
	
	public static Connection dbConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			//Connection conn = DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12210096", "sql12210096", "hJ3MWjNflY");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_progschool", "root", "");
			
			//JOptionPane.showMessageDialog(null, "Data Base Connected Succesfully");
			return conn;
		} 
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Internet Connection Failed");
			return null;
		}
	}
}
