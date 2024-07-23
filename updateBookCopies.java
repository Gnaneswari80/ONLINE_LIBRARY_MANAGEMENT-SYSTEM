package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class updateBookCopies {
	static boolean matchbookcopies=false;

	public updateBookCopies(String bs) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinelibrarymanagementsystem","root","");			
		 Statement ss=con.createStatement();
	
		 String name=bs;
       ResultSet res1=ss.executeQuery("select * from book"); 
           int bookcopies=0;
	  while(res1.next())
      	{
 	        if(name.equals(res1.getString(1).toLowerCase()))
 	        {
 	
 	        	 bookcopies=res1.getInt(7);

 	       break;
 	        }
		  
 	           
	      }
	  if(bookcopies>0)//bookcopies >0 Vuntene Book ni, we cn buy
	  {///////>000000
	  bookcopies=bookcopies-1;//book purchse Chestm so reduce one copy 
    
		
	  matchbookcopies=true;
	
		  String sql1="update book set BOOK_copies="+bookcopies+" where Name=?";
	       PreparedStatement stmt=con.prepareStatement(sql1);
	       stmt.setString(1, name);
	       stmt.executeUpdate();
	       //System.out.print("Book Purched.");
          		 
	  }//if book copies >0
	  else {
		  System.out.print("These Book has No stock..");matchbookcopies=false;
		  } 
		 
		 
	}

}
