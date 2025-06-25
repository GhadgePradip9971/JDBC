package inputconsole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Secoundjdbc {
	public static void main(String args[]) throws SQLException{
		try {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the pcode=");
		String pcode=sc.nextLine();
		System.out.println("Enter the pname=");
		String pname=sc.nextLine();
		System.out.println("Enter the price=");
		float pprice=sc.nextFloat();
		System.out.println("Enter the pqty=");
		int  pqty=sc.nextInt();
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","laptop","hp");
	Statement stm=con.createStatement();
		int k=stm.executeUpdate("insert into product7 values ('"+pcode+"','"+pname+"',"+pprice+","+pqty+")");
		if(k>0) {
			System.out.println("Data inserted successfully");
		}
		con.close();
		sc.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
