package Resultsetmetadata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Resultsetmetadatainfo {
	public static void main(String args[]) throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/servlet", "root", "Pradip@2001");

			PreparedStatement ps = con.prepareStatement("select * from register");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rss = rs.getMetaData();
			System.out.println("total columns=" + rss.getColumnCount());
			System.out.println("column names=" + rss.getColumnName(5));
			System.out.println("column types=" + rss.getColumnType(5));
			System.out.println("table names=" + rss.getTableName(1));

			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
