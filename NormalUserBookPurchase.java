package library;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;




public class NormalUserBookPurchase {
	static Scanner sc=new Scanner(System.in);	
	static String nm()
	   {
		String nme;
		return nme=sc.nextLine();
		}

	public NormalUserBookPurchase(String nameuser,int pssword) throws SQLException, ClassNotFoundException {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection cop=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinelibrarymanagementsystem","root","");
	 Statement ss=cop.createStatement();
		 System.out.print("Enter Book Name to Purchase");
 		  String booksearch=NormalUserBookPurchase.nm();//normalUser.nm();
 		  String bs=booksearch.toLowerCase();
 	  ResultSet res1=ss.executeQuery("select * from book");
 		  String bo="";
 		  
 		  while(res1.next())
	       	{
	  	        if(booksearch.equals(res1.getString(1).toLowerCase()))
	  	        {
	  	        bo= res1.getString(1).toLowerCase();
	  	     // System.out.println("Name                  author                  Publisher               Cla                  Quality            price                BOOK_COPies");
 			  System.out.println(res1.getString(1)+"  "+res1.getString(2)+"   "+res1.getString(3)+"  "+res1.getInt(4)+"  "+res1.getInt(5)+"  "+res1.getFloat(6)+"  "+res1.getInt(7));
	  	           break;
	  	        }
 			  
	  	           
	 	      }
 		   if(bs.equals(bo)) {
 //////////book purchase Chestaam ,so "BOOK" table lo copies colum lo 
  	  ////Value should Change so Calling updateBookCopies
 			  new updateBookCopies(bs); 
 
 			           if(updateBookCopies.matchbookcopies)
 			            {
 			                 System.out.println(" ENter Date In the Format.yyyy-month-day.");
  			             String date=NormalUserBookPurchase.nm();
 			          PreparedStatement s=cop.prepareStatement("insert into purchaseduser values(?,?,?,?)");
 			         s.setString(1,nameuser);
 			              s.setInt(2,pssword);
 			            s.setString(3,bs);
 			   			 
 			            s.setString(4,date);
 			         s.executeUpdate();
 			        System.out.print("Book Purched.");
 			            }
 			              
 			   }
 			   
 		   else
 			   System.out.println("There is no such type of book to Purchase");
 		

	cop.close();
	
	}

}



