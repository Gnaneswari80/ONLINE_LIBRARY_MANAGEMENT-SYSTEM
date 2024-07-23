package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class NormalUserBookSearch {
	static Scanner sc=new Scanner(System.in);	
	static String nm()
	   {
		String nme;
		return nme=sc.nextLine();
		}

	public NormalUserBookSearch() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated constructor stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection cop=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinelibrarymanagementsystem","root","");
	 Statement ss=cop.createStatement();
	//  System.out.print("");
		  System.out.print("Enter Book to Search");
		 String booksearch=NormalUserBookSearch.nm();
	booksearch=booksearch.toLowerCase();
	
         ResultSet res1=ss.executeQuery("select * from book");
		  
		  int serc=0;
		  while(res1.next())
	       	{
	  	        if(booksearch.equals(res1.getString(1).toLowerCase()))
	  	        {
	  	   	//System.out.println("Name     author      Publisher               Cla            Quality            price         BOOK_COPies");
			  System.out.println("Name ->"+res1.getString(1)+" author-> "+res1.getString(2)+" Publisher->  "+res1.getString(3)+"  Cla-> "+res1.getInt(4)+"  Quality->    "+res1.getInt(5)+"   price->   "+res1.getFloat(6)+"  BOOK_COPies->   "+res1.getInt(7));
	  	        serc=1;
	  	        }
			  
	  	           
	 	      }
		  if(serc==0)
			  System.out.println("No Such Type of Book..");
		
		  cop.close();
		
	}

}
