package inputconsole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Bookinput {
	public static void main(String args[]) {
	
	
	try {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Bookcode=");
		String bcode=sc.nextLine();
		System.out.println("Enter the Bname=");
		String bname=sc.nextLine();
		System.out.println("Enter the Book Author Name=");
		String bauthor=sc.nextLine();
		System.out.println("Enter the book Price=");
		float bprice=sc.nextFloat();
		System.out.println("Enter the book quantity=");
		int bqty=sc.nextInt();
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","laptop","hp");
		Statement st=con.createStatement();
		int p=st.executeUpdate("insert into Book45 values('"+bcode+"','"+bname+"','"+bauthor+"','"+bprice+"','"+bqty+"')");
		if(p>0) {
			System.out.println("Book Data Inserted Sucesssfully!!");
		}
		
		con.close();
		sc.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}