package library;
import java.sql.SQLException;

import java.util.*;
public class onlinemanagement {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int choice;
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			
			System.out.println("1.New user  2.Login 3.exit");
			System.out.println("Enter choice");
			choice=sc.nextInt();
			if(choice==1)
			{
				new NewUser1();
				
			}
			else if(choice==2)
			{
				while(true) {
				System.out.println("1.admin 2.Normal user 3.exit ");
				System.out.println("Enter choice");
				int choice2=sc.nextInt();
				if(choice2==1)
					new admin();
				else if(choice2==2)
					new normalUser();
				if(choice2==3)
					break;}
				
			}
			
			else if(choice==3)
				System.exit(0);
		}

	}

}
