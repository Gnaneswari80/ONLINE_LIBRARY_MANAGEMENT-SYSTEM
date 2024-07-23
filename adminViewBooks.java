package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class adminViewBooks {

	public adminViewBooks() throws ClassNotFoundException, SQLException {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
  		 Connection cop=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinelibrarymanagementsystem","root","");
  	 Statement ss=cop.createStatement();
  	
           ResultSet res1=ss.executeQuery("select * from book");
           
      	 /*  To get Column Names*/	  
     		ResultSetMetaData rsmd=res1.getMetaData();
     		for(int j=1;j<=rsmd.getColumnCount();j++)
     		{
     		  System.out.print(rsmd.getColumnName(j)+"\t");
     		}
     		 System.out.println();
     	  System.out.println("----------------------------------------------------------------");
     		   //  System.out.println("Name    author     Publisher     Cla  Quality  price  BOOK_COPies");
     		  while(res1.next())
   	       	{
     			
     			  for(int j=1;j<=rsmd.getColumnCount();j++)
     			  {
     				  System.out.print(res1.getString(j)+"\t");
     			  }
     			  System.out.println();
     			  //System.out.println(res1.getString(1)+"   "+res1.getString(2)+"          "+res1.getString(3)+"    "+res1.getInt(4)+"    "+res1.getInt(5)+"  "+res1.getFloat(6)+"       "+res1.getInt(7));
     			  
   	  	           
   	 	      }
   	    
  		  
  		/*int i=0;
  		  while(res1.next())
  	       	{
  			  i=1;
  	  	     
  			  System.out.println(res1.getString(1)+"  "+res1.getString(2)+"   "+res1.getString(3)+"  "+res1.getInt(4)+"     "+res1.getInt(5)+"     "+res1.getFloat(6)+"     "+res1.getInt(7));
  	  	     }
           if(i==0)
        	   System.out.print("There Is no records...");*/
           cop.close();
           
           
	}

}

