package library;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class IfNormalUserMatch1 {

	
	static Scanner sc=new Scanner(System.in);	
	static String nm()
	   {
		String nme;
		return nme=sc.nextLine();
		}
	
	public IfNormalUserMatch1(String nameuser,int pssword) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated constructor stub
		
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection cop=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinelibrarymanagementsystem","root","");
	 Statement ss=cop.createStatement();
	  	  int option;
      	  System.out.println("Welcome User");
       do {
      	 
      	  System.out.println("1.View Books");
      	  System.out.println("2.Serch");
      	//  System.out.println("3.plce order");
      	  System.out.println("3.Borrow(purchase) Book");
      	  //System.out.println("5.Clculte Fine");
      	  System.out.println("4.Return Book");
      	  System.out.println("5.Exit");
      	  System.out.println("Enter option");
      	 option=sc.nextInt();
      	  if(option==1)
      	  {
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
    	    
      		  
      	  }
      	  if(option==2)	  
      	  {
      		  new NormalUserBookSearch();
      		  
            }
      	  if(option==3)	  
      	  {
      		 new NormalUserBookPurchase(nameuser, pssword); 
            }
      	if(option==4)	  
    	  {
    		 new NormalUserReturnBook(nameuser); 
          }
      	 if(option==5)
      		 break;
      		
      	  
      	      }while(option!=5);//while(true)
       
       cop.close();
       
	}

}
