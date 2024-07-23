package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class adminViewOrders {

	public adminViewOrders() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		Class.forName("com.mysql.cj.jdbc.Driver");
 		 Connection cop=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinelibrarymanagementsystem","root","");
 	 Statement ss=cop.createStatement();
 	
          ResultSet res=ss.executeQuery("select * from purchaseduser");
 		  
 		int k=0;
 		  while(res.next())
 	       	{///Yevaraina purchase Chesunte ,Table lo store avuth8undi
 	  	     ///So Table lo Record Undaaya Leda,, 
 			  ///Records Ledante K value Will Be--> 0
 			 // System.out.println("Name->"+res1.getString(1)+"  MobileNo->"+res1.getInt(2)+" BookName->  "+res1.getString(3)+"  Date->"+res1.getString(4));
 			  
 			  k=1;
 			 // break;
 	  	     }

           if(k==1)
           {
        	   ResultSet res1=ss.executeQuery("select * from purchaseduser");
        	   
          ResultSetMetaData rsmd=res1.getMetaData();
   		for(int j=1;j<=rsmd.getColumnCount();j++)
   		{
   		  System.out.print(rsmd.getColumnName(j)+"\t");
   		}
   		 System.out.println();
   	  System.out.println("----------------------------------------------------------------");
   		   
   		  while(res1.next())
 	       	{
   			
   			  for(int j=1;j<=rsmd.getColumnCount();j++)
   			  {
   				  System.out.print(res1.getString(j)+"\t     ");
   			  }
   			  System.out.println();
   			     
 	 	      }
 	    
           }
           else
        	   System.out.println("No one Purchased any book");
		
           cop.close();
 		  
	}

}
