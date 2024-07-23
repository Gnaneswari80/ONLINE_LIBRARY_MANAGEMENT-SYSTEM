package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class admin {

	public admin() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
	
	
	
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter Name");
	String  name=NewUser1.nm();
	System.out.println();
	
	System.out.println("Enter Mobile number");
    String mob=sc.nextLine();
    if(name.equals("admin")&&mob.equals("1234567890"))
    {////if adimin match
    	
    	 while(true) {
    	
    	 System.out.println("1.View Books");
     	  System.out.println("2.Search");
     	  System.out.println("3.add Book");
     	  System.out.println("4.Delete Book");
     	  System.out.println("5.Delete all record");
     	  System.out.println("6.View orders");
     	  System.out.println("7.Exit");
     	  System.out.println("Enter option");
     	 int option=sc.nextInt();
     	 if(option==1)
     	 {
         new adminViewBooks();
      	 }
     	 if(option==2)
     	 {
         new adminSearchBook();
      	 }
     	 
     	 if(option==3)
     	 {
         new adminaddBOOK();
      	 }
     	 if(option==4)
     	 {
         new adminDeleteBook();
      	 }
     	 
    	 if(option==5)
     	 {
         new adminDeleteallRecords();
      	 }
    	 if(option==6)
     	 {
         new adminViewOrders();
      	 }
    	 if(option==7)
     	 {
         break;
      	 }
    	 }
    }//if adminmatch
    else
    	 System.out.println("You are not  a admin... ");	
    
    
    

}
}
