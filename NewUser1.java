package library;
import java.sql.Connection;




import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class NewUser1 {

	
	

	 static Scanner sc=new Scanner(System.in);
     static  String nm()
	   {
		String nme;
		return nme=sc.nextLine();
		}
	
	
	NewUser1() throws ClassNotFoundException, SQLException
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Name");
		String  name=NewUser1.nm();
		System.out.println();
		System.out.print("Enter Email Id");
		String  email=NewUser1.nm();
		System.out.println();
		System.out.println("Enter Mobile number");
		int mobn=sc.nextInt();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinelibrarymanagementsystem","root","");

		
		
		 Statement ss=con.createStatement();
			ResultSet res=ss.executeQuery("select * from newuser");
					int i=0;
		          while(res.next())//
		       	{//already Unna User account Create Chesthe
		  	     //ikkada i=1 Vastundi,,So he can't Create account
			//mobile no primry key
		  	           if(mobn==res.getInt(3))
			               {
		  	        	   i=1;
		  	        	   break;
		  	        	   }
			           
		 	      }

		
		if(i==0)
		{
		
		PreparedStatement s=con.prepareStatement("insert into newuser values(?,?,?)");
		s.setString(1,name);
		s.setString(2,email);
		s.setInt(3,mobn);
		s.executeUpdate();
		System.out.println(" Congratulations.. Account created");
		}
		else
			System.out.println("User already Exits..");	
		con.close();
		
		
	}
}
