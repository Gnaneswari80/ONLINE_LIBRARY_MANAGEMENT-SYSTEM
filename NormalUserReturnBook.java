package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class NormalUserReturnBook {

	
	static Scanner sc=new Scanner(System.in);	
	static String nm()
	   {
		String nme;
		return nme=sc.nextLine();
		}

	
	public NormalUserReturnBook(String name) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated constructor stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinelibrarymanagementsystem","root","");	

		 System.out.print("Enter book name to return..");
	       String bookname=NormalUserReturnBook.nm().toLowerCase();
	       Statement s=con.createStatement();
	       ResultSet res1=s.executeQuery("select * from purchaseduser"); 
	      	  
		 int serc=0;
		  while(res1.next())//to check purchased user name and book name, 
	      	{              //Both Should mach at table
	 	        if(name.equals(res1.getString(1).toLowerCase())&&bookname.equals(res1.getString(3).toLowerCase()))
	 	        {
	
	 	        serc=1;
	 	        break;
	 	        }
			  
	 	           
		      }
		
		  if(serc==1)
		  {////////////////serc===1
	       String sql1="delete from purchaseduser where Name=?";
	       PreparedStatement stmt=con.prepareStatement(sql1);
	       stmt.setString(1, name);
	       stmt.executeUpdate();
	        Statement ss=con.createStatement();
		
	        ResultSet res2=ss.executeQuery("select * from book"); 
	      	  
	   
	          int bookcopies=0;
	   	  while(res2.next())
	         	{
	    	        if(bookname.equals(res2.getString(1).toLowerCase()))
	    	        {
	    
	    	        	 bookcopies=res2.getInt(7);
	    	   
	    	        break;
	    	        }
	   		  
	    	           
	   	      }
  	 
	   	  bookcopies=bookcopies+1;//book return Chestm so increse one copy 
	   	
	   		  String sql2="update book set BOOK_copies="+bookcopies+" where Name=?";
	   	       PreparedStatement st=con.prepareStatement(sql2);
	   	       st.setString(1,bookname);
	   	       st.executeUpdate();
	   	       System.out.print("Book Returned...");
	        
		 }///////////serc===1
		  else
			  System.out.print("Some Thing Wrong, Book Not Returned..");
		  
		  con.close();
			  
	}

}
