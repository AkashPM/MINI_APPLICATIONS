import java.util.*;
public class ATM {
	static int c22,c5,c2,c1;
	static int u22,u5,u2,u1,utot;
	static String Admin="Akash";
	static String Pass="1234";
	static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer> list = new ArrayList<Integer>();
	static ArrayList<ArrayList<String>> user = new ArrayList<ArrayList<String>>();
	public static void main(String[] args) {
		display();
	}
	public static void display() {
		System.out.print("\033[H\033[2J");
		System.out.println("Welcome to ATM.....Please Select your ROLE...");
		System.out.println("\n\n 1. ADMIN");
		System.out.println("\n 2. USER");
		System.out.println("\n 3. EXIT");
		int n = sc.nextInt();
		switch(n)
		{
		case 1:
		{
			Admin();
			break;
		}
		case 2:
		{
			User_new();
			break;
		}
		case 3:
		{
			Exit();
			break;
		}
		default:
		{
			System.out.println("\n\n Enter a valid Option...");
		}
		
		
		}
	}
	public static void User_new()
	{
		System.out.print("\033[H\033[2J");
		System.out.println("\n 1. New User");
		System.out.println("\n 2. Login");
		System.out.print("\n 3. Back");
		switch(sc.nextInt())
		{
			case 1:
			{
				User();
				break;
			}
			case 2:
			{
				User_Login();
				break;
			}
			case 3:
			{
				display();
			}
		}
	}

	private static void Exit() {
		System.out.print("\033[H\033[2J");
		System.out.println("\n\n Thank You....");
		
	}
	public static void User()
	{
		System.out.print("\033[H\033[2J");
		ArrayList<String> us = new ArrayList<String>();
		System.out.println("\n SignUp Here.. ");
		System.out.println("\n\n Enter your USER NAME : ");
		String u_name = sc.next();
		System.out.println("\n\n Enter your PIN : ");
		String u_pass = sc.next();
		System.out.println("\n\n Enter your CONFIRM-PIN : ");
		String uc_pass = sc.next();
		if(u_pass.equals(uc_pass))
		{
			us.add(u_name);
			us.add(u_pass);
			user.add(us);
			display();
		}
		else{
			User();
		}
	}

	private static void User_Login() {
		System.out.print("\033[H\033[2J");
		System.out.println("\n Welcome USER...Please SignIn to Proceed... ");
		String u_name,u_pass;
		System.out.println("\n\n Enter your USER NAME : ");
		u_name = sc.next();
		System.out.println("\n\n Enter your PIN : ");
		u_pass = sc.next();
	    for(int i=0;i<user.size();i++)
		{
			for(int j=0;j<user.get(i).size();j++)
			{
				if(user.get(i).get(0).equals(u_name) && user.get(i).get(1).equals(u_pass))
				{
					User_Display();
				}
			}
		}
	}
	private static void User_Display() {
		System.out.print("\033[H\033[2J");
		int c_2000=0,c_500=0,c_200=0,c_100=0;
		
		System.out.println("\n\n Welcome to USER PANEL ");
		System.out.println("\n\n 1. Deposit Money ");
		System.out.println("\n 2. Check Balance");
		System.out.println("\n 3. Widhdraw Money ");
		System.out.println("\n 4. Mini Statement ");
		System.out.println("\n 5. Change Pin ");
		System.out.println("\n 6. Back");
		int c = sc.nextInt();
		switch(c)
		{
			case 1:
			{
				System.out.println("\n\n Enter 2000 count : ");
				c_2000 = sc.nextInt();u22 = c_2000;
				System.out.println("\n Enter 500 count : ");
				c_500 = sc.nextInt();u5 = c_500;
				System.out.println("\n Enter 200 count : ");
				c_200 = sc.nextInt();u2 = c_200;
				System.out.println("\n Enter 100 count : ");
				c_100 = sc.nextInt();u1 = c_100;
				User_Display();
			}
			case 2:
			{
				int tot = ((u22*2000)+(u5*500)+(u2*200)+(u1*100));
				utot = tot;
				System.out.println("\n\n Total Balance is = " + ((u22*2000)+(u5*500)+(u2*200)+(u1*100)));
				System.out.println("\n\n 1. Back");
                int ans = sc.nextInt();
                if(ans ==1)
                {
                    User_Display();
                }
			}
			case 3:
			{
                System.out.print("\033[H\033[2J");
				System.out.println("\n\n Enter the amount to Withdraw : ");
                int w = sc.nextInt();
                list.add(w);
				if(w<utot) {
				System.out.println("\n\n Balance After Withdraw is : " + (utot-w));
                utot = utot-w;
				}
				else
				{
					System.out.println("Insufficient Balance...!");
				}
                System.out.println("\n\n 1. Back");
                int an = sc.nextInt();
                if(an ==1)
                {
                    User_Display();
                }
                break;
			}
			case 4:
			{
                System.out.print("\033[H\033[2J");
				System.out.println("\n\n Your Statement is...");
				for(int i=0;i<list.size();i++)
				{
					System.out.println("\n You have withdrawn " + list.get(i) + "rs");
				}
                System.out.println("\n\n 1. Back");
                int ans1 = sc.nextInt();
                if(ans1 ==1)
                {
                    User_Display();
                }
                break;
			}
			case 5:
			{
                System.out.print("\033[H\033[2J");
				System.out.println("Enter your old PIN : ");
                String old=sc.next();
				for(int i=0;i<user.size();i++)
				{
					for(int j=0;j<user.get(i).size();j++)
					{
						if(user.get(i).get(1).equals(old)){
						System.out.println("\n Enter your new PIN : ");
					 	String n_pin = sc.next();
						 user.get(i).set(1,n_pin);
						}
					}
				}
				System.out.println("\n\n ---Your PIN has Successfully Changed---");
                System.out.println("\n\n 1. Back");
                int ans2 = sc.nextInt();
                if(ans2 ==1)
                {
                    User_Display();
                }
                break;
			}
			case 6:
			{
				display();
			}
		}
		
	}
	private static void Admin() {
        System.out.print("\033[H\033[2J");
		System.out.println("\n Welcome ADMIN...Please SignIn to Proceed...");
		String a_name,a_pass;
		System.out.println("\n\n Enter your ADMIN NAME : ");
		a_name = sc.next();
		System.out.println("\n\n Enter your PASSWORD : ");
		a_pass = sc.next();
		if(a_pass.equals(Pass) && a_name.equals(Admin))
		{
			Admin_Display();
		}
		
	}
	
	public static void Admin_Display()
	{
        System.out.print("\033[H\033[2J");
		int c_2000=0,c_500=0,c_200=0,c_100=0;
		System.out.println("\n Welcome to ADMIN PANEL");
		System.out.println("\n\n 1. Deposit Money in ATM");
		System.out.println("\n 2. Check Balance in ATM");
		System.out.println("\n 3. Back");
		int c = sc.nextInt();
		switch(c)
		{
		case 1:
		{
			
			System.out.println("\n\n Enter 2000 count : ");
			c_2000 = sc.nextInt();c22 = c_2000;
			System.out.println("\n Enter 500 count : ");
			c_500 = sc.nextInt();c5 = c_500;
			System.out.println("\n Enter 200 count : ");
			c_200 = sc.nextInt();c2 = c_200;
			System.out.println("\n Enter 100 count : ");
			c_100 = sc.nextInt();c1 = c_100;
			Admin_Display();
		}
		case 2:
		{
			System.out.println("\n\n Available Balance Under ");
			System.out.println("\n\n 2000rs is " + c22*2000);
			System.out.println(" 500rs is " + c5*500);
			System.out.println("200rs is " + c2*200);
			System.out.println("100rs is " + c1*100);
			System.out.println("\n\n Total Balance is = " + ((c22*2000)+(c5*500)+(c2*200)+(c1*100)));
			Admin_Display();
			
		}
		case 3:
		{
			display();
		}
		default:
			System.out.println("Enter the valid Option...");
		}
		
	}
	

}