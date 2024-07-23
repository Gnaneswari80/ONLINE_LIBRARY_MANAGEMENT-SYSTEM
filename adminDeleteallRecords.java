package library;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class adminDeleteallRecords {

	public adminDeleteallRecords() throws SQLException {
		Scanner sc=new Scanner(System.in);
		 System.out.print("are you want to delete all records press 1 otherwise 2");
		 int opt=sc.nextInt();
		 if(opt==1)
		 {
		Connection con;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinelibrarymanagementsystem","root","");
        Statement s=con.createStatement();
      
        String sql="delete from book";
        s.executeUpdate(sql);
        System.out.print("  all Books are deleted...");
        con.close();
		 }
		 
	}

}
