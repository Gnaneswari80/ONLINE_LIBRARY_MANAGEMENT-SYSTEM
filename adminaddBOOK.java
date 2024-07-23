package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class adminaddBOOK {
	 static Scanner sc=new Scanner(System.in);
     static  String nm()
	   {
		String nme;
		return nme=sc.nextLine();
		}

	public adminaddBOOK() throws SQLException {

		
	//	Scanner sc=new Scanner(System.in);
		
		Connection con;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinelibrarymanagementsystem","root","");


		PreparedStatement s=con.prepareStatement("insert into book values(?,?,?,?,?,?,?)");
		System.out.print("         ");
		System.out.print("Enter Book Name");
		String  na=adminaddBOOK.nm();
		s.setString(1,na);
		System.out.print("Enter author Name");
		 na=adminaddBOOK.nm();
		s.setString(2,na);
		System.out.print("Enter Publisher Name");
		 na=adminaddBOOK.nm();
		 s.setString(3,na);
		 System.out.print("Enter cla");
		 int nk=sc.nextInt();
		 s.setInt(4, nk);
		 System.out.print("Enter Quality");
		  nk=sc.nextInt();
		 s.setInt(5, nk);
		 System.out.print("Enter price");
		  nk=sc.nextInt();
		 s.setInt(6, nk);
		 System.out.print("Enter how many Book copies");
		  nk=sc.nextInt();
		 s.setInt(7, nk);
		s.executeUpdate();
		System.out.println("Book added..");
		 con.close();

	}

}
