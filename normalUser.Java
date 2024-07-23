package library;

import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class normalUser {

	static Scanner sc=new Scanner(System.in);	
	static String	name;
	static int pss;
	static String nm()
	   {
		String nme;
		return nme=sc.nextLine();
		}
	

	public normalUser() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		Scanner sc1=new Scanner(System.in);
		
		boolean match=false;
		
		System.out.print("Enter User name:");
		name =normalUser.nm().toLowerCase();
			System.out.print("Enter pssword(mob number)");
			
			pss=sc1.nextInt();
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection cop=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinelibrarymanagementsystem","root","");
		 Statement ss=cop.createStatement();
		ResultSet res=ss.executeQuery("select * from newuser");
				
	          while(res.next())
	       	{
	  	
		
	  	           if(name.equals(res.getString(1).toLowerCase())&&pss==res.getInt(3))
		               {match=true;break;}
		           else{match=false;}
	 	      }
	          if(match)
	          {////if mtch
	        	  new IfNormalUserMatch1(name,pss);

              	 }////if mtch
                 else
  	            System.out.println("Your Not user.."); 

	       cop.close();   
	
	}
	          
     }


	
	
