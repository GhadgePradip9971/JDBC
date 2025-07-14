package prestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchProc2 {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","laptop","hp");
		PreparedStatement ps=con.prepareStatement("insert into book45 values (?,?,?,?,?)");
		ps.setString(1, "1001");
		ps.setString(2,"Marval");
		ps.setString(3, "Robert");
		ps.setInt(4, 1200);
		ps.setInt(5, 3);
		ps.addBatch();
		
		int k[]=ps.executeBatch();
		for(int i=0;i<k.length;i++) {
			System.out.print("Data Inserted Succesfully");
		}
		
	}

}
