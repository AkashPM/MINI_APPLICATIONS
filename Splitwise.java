import java.util.*;
import java.util.regex.Pattern;
public class split_wise {
    static Scanner sc = new Scanner(System.in);
	static String username = "akash@gmail.com", password = "1234";
	static String name ="",a1="";
    static int a,balance=2000,balance2=1000,n=0;
    static ArrayList<String>l1=new ArrayList<>();
   static  ArrayList<String>l2=new ArrayList<>();
   static  ArrayList<String>l3=new ArrayList<>();
   static ArrayList<String>l4=new ArrayList<>();
   static ArrayList<String>l5=new ArrayList<>();
   static ArrayList<String>l6=new ArrayList<>();
   static ArrayList<String>l7=new ArrayList<>();
	static ArrayList<ArrayList<String>> login_details = new ArrayList<ArrayList<String>>();
	
	public static boolean isValid(String email)
	{
		String Reg = "^[a-zA-Z0-9_+&-]+(?:\\."+"[a-zA-Z0-9_+&-]+)*@" +"(?:[a-zA-Z0-9-]+\\.)+[a-z" +"A-Z]{2,7}$";
							
		Pattern pat = Pattern.compile(Reg);
		if (email == null || email.isEmpty())
		{
			return false;
		}
			else{
		return pat.matcher(email).matches();
	}
}
    public static void main(String[] args)
    {
		login();
		
    }
	
	public static void login()
	{
		System.out.print("\033[H\033[2J");
		System.out.println("\n 'Welcome to SplitWise Application...");
		System.out.println("\n\n 1 SIGN-In");
		System.out.println("\n 2 SIGN-UP");
		int a = sc.nextInt();
		if(a==1)
		{
			System.out.print("\033[H\033[2J");
			System.out.println("\n Enter your EMAIL ");
			String uname = sc.next();
			System.out.println("\n Enter the Password ");
			String pass = sc.next();
			boolean check = false;
			for(int i=0;i<login_details.size();i++)
			{
				try{
					if(login_details.get(i).get(0).equals(uname) && login_details.get(i).get(1).equals(pass))
					{
						check=true;
					}
				}
				catch(Exception e)
				{
				}
			}
			if(uname.equals(username) && pass.equals(password))
			{
				name = uname;
				display();
			}
			else if(check)
			{
				name = uname;
				display();
			}
			else{
				System.out.println("\n Invalid Authentication");
				System.out.println("\n 1 Back");
				if(sc.nextInt()==1)
				{
					login();
				}
			}
		}
		else if(a==2)
		{
			signup();
		}
	}
	
	public static void signup()

	{
		System.out.print("\033[H\033[2J");
			ArrayList<String> list = new ArrayList<String>();
			System.out.println("\n Enter your valid email ");
			String email = sc.next();
			System.out.println("\n Enter your Password");
			String pass = sc.next();
			if(isValid(email))
			{
				list.add(email);
				list.add(pass);
				login_details.add(list);
				System.out.println("\n Account has Successfully Created...");
				System.out.println("\n 1 Back");
				if(sc.nextInt()==1)
				{
					login();
				}
			}
			else{
				System.out.println("\n Enter the valid Email...!");
				System.out.println("\n 1 Sign-Up Again");
                System.out.println("\n 2 Back");
				if(sc.nextInt()==2)
				{
					login();
				}
				else
				{
					signup();
				}
			}
	}
	
	public static void display() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
         System.out.println("\n1.SHOP");
         System.out.println("\n2.PAY");
         System.out.println("\n3.CHECK");
         System.out.println("\n4.EXIT");
         int ll=sc.nextInt();
         if(ll==1)
         shop();
        else if(ll==2)
         pay();
         else if(ll==3)
         check();
         else
         login();
      }
      public static void shop()
      {
          System.out.print("\033[H\033[2J");
          System.out.flush();
          System.out.println("\n1.TEA SHOP");
          System.out.println("\n2.CLOTH");
          System.out.println("\n3.PARLOUR");
          System.out.println("\n4.EXIT");
          System.out.println();
          int k=sc.nextInt();
          if(k==1)
          gotoo();
          else if(k==2)
          gotoo();
          else if(k==3)
          gotoo();
          else
          login();
      }
      public static void gotoo()
      {
          System.out.print("\033[H\033[2J");
         System.out.flush();
       System.out.println("\n1.CALL FRIENDS");
       System.out.println("\n2.EXIT");
       int k=sc.nextInt();
       if(k==1)
       {
           for(int i=0;i<l1.size();i++)
           {
               System.out.println("-------------------------------------------------");
           System.out.println("id: "+l1.indexOf(l1.get(i))+" NAME : "+l1.get(i));
           }
           System.out.println();
           System.out.println("ENTER THE NUMBER OF FRIENDS ");
           int pp=sc.nextInt();
           System.out.println("ENTER THE NAME");
           for(int i=0;i<pp;i++)
           {
               String ka=sc.next();
               l3.add(ka);
           }
           System.out.println(l3);
           l1.add(a1);
           bill();
       }
       else
         login();
  
}
static int bb;
public static void bill()
{
  System.out.print("\033[H\033[2J");
  System.out.flush();
  System.out.println("\t\tTOTAL BILL IS: 1250");
  System.out.println();
  for(int i=0;i<l3.size();i++)
  {
      System.out.println("-----------------------------------------------");
      System.out.println("NAME : "+l3.get(i)+"   "+"ID : "+l4.get(i));
  }
  System.out.println("WHO WANT TO PAY THE BILL");
  String u=sc.next();
  int kp=l4.indexOf(u);
  System.out.println(kp);
  System.out.println();
  System.out.println(l3.get(kp)+" HAS PAID THE BILL");
  System.out.println();
  l6.add(l3.get(kp));
  l3.remove(kp);
  l5.addAll(l3);
  bb=1250;
  balance-=bb;
  System.out.println();
  System.out.println("\n-------ENTER TO CONTINUE------");
     sc.nextLine();
     String s=sc.nextLine();
     if(s.equals(""))
     display();
}
public static void check()
{
  System.out.print("\033[H\033[2J");
  System.out.flush();
  if(l5.contains(a1))
  {
      System.out.println("YOU HAVE TO PAY "+l6.get(0));
      System.out.println(bb/3);
  }
  else if(l6.contains(a1))
  {
      System.out.println("YOU NEED TO COLLECT THE MONEY FROM ");
      for(int i=0;i<l5.size();i++)
      {
          System.out.println(l5.get(i));
          System.out.println();
      }
      System.out.println("YOUR BALANCE IS "+balance);
      if(balance>=(bb/3)*3)
      {
          l7.addAll(l6);
          l6.clear();
          
      }
  }
  else 
  {
      if(l7.contains(a1))
      System.out.println("YOUR BALANCE IS "+balance);
      else
      System.out.println("YOUR BALANCE IS "+balance2);
  }
  System.out.println();
  System.out.println("-------ENTER TO CONTINUE------");
     sc.nextLine();
     String s=sc.nextLine();
     if(s.equals(""))
     display();
}

public static void pay(){
    System.out.print("\033[H\033[2J");
    System.out.flush();
    if(l5.contains(a1)){
    System.out.println("YOU NEED TO PAY "+l6.get(0)+" "+bb/3);
    System.out.println();
    System.out.println("ENTER THE AMOUNT");
    int amount=sc.nextInt();
    balance+=amount;
    balance2-=amount;
    int id=l5.indexOf(a1);
    l5.remove(id);
    System.out.println(l6);
    System.out.println();
    System.out.println("SUCCESSFULLY PAID");
    }
    else
    {
        System.out.println("NO NEED TO PAY");
    }
    System.out.println();
    System.out.println("-------ENTER TO CONTINUE------");
       sc.nextLine();
       String s=sc.nextLine();
       if(s.equals(""))
       display();
    
}
}
