package Statementinterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstJDBC {
    public static void main(String[] args) {
        
        // Class.forName("oracle.jdbc.driver.OracleDriver"); (Not needed for modern JDBC)

        try {
            // Establish the connection
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "laptop", "hp");
            // Create a statement
            Statement stm = con.createStatement();
            // Execute the query
            ResultSet rs = stm.executeQuery("SELECT * FROM product7");
            System.out.println("Executed query. Fetching results...");
            
            // Use while loop to iterate over all rows
            while (rs.next()) {
                System.out.println("Fetching row...");
                String pcode = rs.getString(1);
                String pname = rs.getString(2);
                float pprice = rs.getFloat(3);
                int pqty = rs.getInt(4);

                System.out.println(pcode + "\t" + pname + "\t" + pprice + "\t" + pqty);
            }

            // Close the connection
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
