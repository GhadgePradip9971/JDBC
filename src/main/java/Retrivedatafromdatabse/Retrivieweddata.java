package Retrivedatafromdatabse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Retrivieweddata {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/servlet", "root", "Pradip@2001");

		PreparedStatement ps = con.prepareStatement("select * from register");
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData rss = rs.getMetaData();
		System.out.println("The available data===");
//
//		while (rs.next()) {
//
//			// Use the correct column names from the table
//			String name = rs.getString("name");
//			String password = rs.getString("password"); // Correct column name
//			String email = rs.getString("email");
//			String gender = rs.getString("gender");
//			String address = rs.getString("address"); // Correct column name
//			System.out.println("Name: " + name + ", Password: " + password + ", Email: " + email + ", gender :" + gender
//					+ ",Address:" + address);
//		}
//		System.out.println("Not connectd");
//		

		// to print the data in table format
		// Print the table header
		System.out.println("<table border='1'>");
		System.out.println("<tr>");

		// Print column headers
		int n = rss.getColumnCount();
		for (int i = 1; i <= n; i++) {
			System.out.println("<th>" + rss.getColumnName(i) + "</th>");
		}
		System.out.println("</tr>");

		// Print each row
		while (rs.next()) {
			System.out.println("<tr>");
			for (int i = 1; i <= n; i++) {
				System.out.println("<td>" + rs.getString(i) + "</td>");
			}
			System.out.println("</tr>");
		}

		// Close the table tag
		System.out.println("</table>");

	}

}
