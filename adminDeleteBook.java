package library;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class adminDeleteBook {
	
	
	static Scanner sc=new Scanner(System.in);	
	static String nm()
	   {
		String nme;
		return nme=sc.nextLine();
		}

	public adminDeleteBook() throws SQLException {
		
		
		
		Scanner sc=new Scanner(System.in);
			Connection con;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinelibrarymanagementsystem","root","");
      
		
		 System.out.print("Enter Book Name to Delete..");
       String name=adminDeleteBook.nm().toLowerCase();
       Statement ss=con.createStatement();
       ResultSet res1=ss.executeQuery("select * from book"); 
      	  
	  int serc=0;
	  while(res1.next())
      	{
 	        if(name.equals(res1.getString(1).toLowerCase()))
 	        {
 	   
 	        serc=1;
 	       // break;
 	        }
		  
 	           
	      }
	
     
       String sql1="delete from book where Name=?";
       PreparedStatement stmt=con.prepareStatement(sql1);
       stmt.setString(1, name);
       stmt.executeUpdate();
       
       if(serc==0)
 		  System.out.println("No Such Type of Book..");
       else
    	   System.out.println( name+" is Deleted..");
       ///OR OR OR OR OR  oR OR OR OR OR OR OR OR OR OR OR OR OR 
       
   /* Statement s=con.createStatement();
    String sql="delete from book where Name=' "+name+"'";
    s.executeUpdate(sql);
       System.out.print(name+" is deleted...");*/
       con.close();		
	}

}
