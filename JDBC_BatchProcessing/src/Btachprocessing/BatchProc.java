package Btachprocessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchProc {
	
	public static void main(String args[]) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","laptop","hp");
			Statement stm=con.createStatement();		
			stm.addBatch("insert into Book45 values('p01','Marshal','Martin',305.56,10)");
			stm.addBatch("insert into product7 values('m7','mouse',120.00,2)");
			stm.addBatch("insert into employees values(609,3080,300,2000,'rahul')");
		
		int k[]=stm.executeBatch();
		for(int i=0;i<k.length;i++) {
			System.out.println("Data Updated ;;;;;';....");
		}
		stm.close();
		con.close();
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	}

}
