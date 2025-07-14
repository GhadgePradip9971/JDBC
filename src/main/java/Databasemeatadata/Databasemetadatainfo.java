package Databasemeatadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databasemetadatainfo {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/servlet", "root", "Pradip@2001");
		DatabaseMetaData dbmd = con.getMetaData();

		System.out.println("Driver Name: " + dbmd.getDriverName());
		System.out.println("Driver Version: " + dbmd.getDriverVersion());
		System.out.println("UserName: " + dbmd.getUserName());
		System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
		System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());
		System.out.println("Database url: " + dbmd.getURL());

		con.close();
	}

}
