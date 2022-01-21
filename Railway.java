import java.util.*;
class Railway {
    static ArrayList<String> train = new ArrayList<String>();
    static ArrayList<String> routes = new ArrayList<String>();
    static ArrayList<ArrayList<String>> station = new ArrayList<ArrayList<String>>();
    static Scanner sc = new Scanner(System.in);
    static ArrayList<ArrayList<Integer>> seats = new ArrayList<ArrayList<Integer>>();
    static ArrayList<ArrayList<Integer>> seatbo = new ArrayList<ArrayList<Integer>>();
    static ArrayList<ArrayList<Integer>> seatst = new ArrayList<ArrayList<Integer>>();
    static ArrayList<ArrayList<String>> user = new ArrayList<ArrayList<String>>();
    static ArrayList<Integer> books = new ArrayList<Integer>();
    static String Admin = "Akash";
    static String Pass = "1234";
    public static void main(String[] args) {
        display();
    }
    public static void display() {
        System.out.print("\033[H\033[2J");
        System.out.println("Welcome to RAILWAY RESERVATION SYSTEM.....Please Select your ROLE...");
        System.out.println("\n 1. ADMIN");
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
                User();
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
    private static void Exit() {
        System.out.print("\033[H\033[2J");
        System.out.println("\n ---Thank You..!!---");
    }
    private static void User() {
        System.out.print("\033[H\033[2J");
        System.out.println("\n Welcome to USER LOGIN...");
        System.out.println("\n\n 1. Login **Already Have an Account** ");
        System.out.println("\n 2.  Register **IF New** ");
        System.out.println("\n 3. Back ");
        int c = sc.nextInt();
        switch(c)
        {
            case 1:
            {
                    userLogin();
                    break;
            }
                case 2:
                {
                    register();
                    break;
                }
                case 3:
                {
                    display();
                }
                
            }
            
        }
        public static void userLogin()
        {
            System.out.print("\033[H\033[2J");
                    System.out.println("Sign In to Proceed..");
                    System.out.println("\n Enter your UserName : ");
                    String name = sc.next();
                    System.out.println("\n Enter your Password : ");
                    String pass = sc.next();
                    for(int i=0;i<user.size();i++)
                    {
                        for(int j=0;j<user.get(i).size();j++)
                        {
                            String ch1 = user.get(i).get(0);
                            String ch2 = user.get(i).get(1);
                            if(ch1.equals(name) && ch2.equals(pass))
                    {
                    view();
                    }
                    else{
                        System.out.println("\n Invalid Password..");
                        System.out.println("\n 1. Login Again");
                        int uu = sc.nextInt();
                        if(uu==1)
                        {
                            userLogin();
                        }
                    }
                        }
                    }
                    
        }
        public static void register()
        {
            System.out.print("\033[H\033[2J");
            ArrayList<String> tem = new ArrayList<String>();
                    System.out.println("Register Here...");
                    System.out.println("Enter your UserName : ");
                    String name = sc.next();
                    System.out.println("\n Enter your Password : ");
                    String pass = sc.next();
                    System.out.println("\n Enter Confirm Password : ");
                    String c_pass = sc.next();
                    if(pass.equals(c_pass))
                    {
                        System.out.println("\n Your Account has Successfully Registered...");
                        tem.add(name);
                        tem.add(pass);
                        user.add(tem);
                        User();
                    }
                    else
                    {
                        System.out.println("\n Password Mismatch...!");
                        System.out.println("\n\n 1. Register Again...");
                        int jj = sc.nextInt();
                        if(jj==1)
                        {
                            register();
                        }
                    }
                }

    public static void view()
    {
        System.out.print("\033[H\033[2J");
        System.out.println("\n\n 1. View Trains And Availability And Booking");
        System.out.println("\n 2. Back");
        int pp = sc.nextInt();
        switch(pp)
        {
            case 1:
            {
                System.out.print("\033[H\033[2J");
                System.out.println(" Available Trains ");
                System.out.println();
                for(int i=1;i<=train.size();i++)
                {
                    System.out.println(i + " " +train.get(i-1));
                }
                System.out.println("\n\n Select the train number to Check the Available Tickets...");
                int tt = sc.nextInt();
                int i=tt-1,j=0;
                int row = seats.get(i).get(j);
                int col = seats.get(i).get(j+1);
                for(int w=1;w<=(row*col);w++)
                   {
                        books.add(w);
                   }
                int[][] st = new int[row][col];
                for(int l=0;l<row;l++)
                {
                    for(int k=0;k<col;k++)
                    {
                        st[l][k]=0;
                    }
                }
                
                System.out.println("\n\n Available Seats are...");
                System.out.println("\n");
                for(int o=0;o<row;o++)
                {
                    for(int p=0;p<col;p++)
                    {
                        System.out.print(st[o][p] + " ");
                    }
                    System.out.println();
                }
                System.out.println("\n\n Enter 1 to Proceed to BOOKINGS...");
                System.out.println("\n\n Enter 2 BACK...");
                int ii = sc.nextInt();
                if(ii==1)
                {
                    System.out.println("\n\n Available Stations Are...");
                    System.out.println();
                        for(int b=1;b<=station.get(i).size();b++)
                        {
                            System.out.println(b + " " + station.get(i).get(b-1));
                        }
                    System.out.println("\n Enter the No. of Tickets..");
                    int tik = sc.nextInt();
                   for(int w=0;w<tik;w++)
                   {
                       
                       try{
                        ArrayList<Integer> stbo = new ArrayList<Integer>();
                        ArrayList<Integer> stst = new ArrayList<Integer>();
                        System.out.println("\n Enter the Boarding Station No..");
                        int b = sc.nextInt();
                        System.out.println("\n Enter the Stopping Station No..");
                        int s = sc.nextInt();
                        boolean ans = books.isEmpty();
                        if (ans == false){
                        System.out.println("\n Alloted Seat No. : ");
                        System.out.println(" " + books.get(0));
                        stbo.add(books.get(0));
                        stbo.add(b);
                        stst.add(books.get(0));
                        stst.add(s);
                        seatbo.add(stbo);
                        seatst.add(stst);
                        books.remove(0);
                    }else{
                        check_Avail(b, s);
                    } 
                 }
                   catch(Exception e)
                   {
                    
                   }
                   
                }
                System.out.println("\n 1. Back");
        if(sc.nextInt()==1)
        {
            display();
        }
                
                }
                
                else{
                    view();
                }
                break;
            }
            case 2:
            {
                User();

            }
        }
    }
    public static void check_Avail(int b,int s)
    {
        for(int i=0;i<seatbo.size();i++)
        {
        if(s<=seatbo.get(i).get(1))
        {
            System.out.println("\n Alloted Seat No. : ");
            System.out.println(seatbo.get(i).get(0));
            seatbo.remove(i);
            break;
        }
        else if(b>=seatst.get(i).get(0))
        {
            System.out.println("\n Alloted Seat No. : ");
            System.out.println(seatst.get(i).get(0));
            seatst.remove(i);
            break;
        }
        else
        {
            System.out.println("\n\n No Seats Available ");
        }
        }
        
        
    }
    private static void Admin() {
        System.out.print("\033[H\033[2J");
        System.out.println("\n Welcome to ADMIN LOGIN...");
        System.out.println("\n\n Enter your Name : ");
        String a_name = sc.next();
        System.out.println(" Enter the Password : ");
        String a_pass = sc.next();
        if(a_name.equals(Admin) && a_pass.equals(Pass))
        {
            Admin_login();
        }
        else{
            Admin();
        }
    }
    private static void Admin_login() {
        System.out.print("\033[H\033[2J");
        System.out.println("\n Welcome Admin ");
        System.out.println("\n\n 1. Add Trains, Routes, Station..");
        System.out.println("\n 2. Declare Seats Availability..");
        System.out.println("\n 3. Back");
        int ch = sc.nextInt();
        switch(ch)
        {
            case 1:
            {
                Add();
                break;
            }
            case 2:
            {
                Seats();
                break;
            }
            case 3:
            {
                display();
            }
            default:
            {
                System.out.println("\n Enter the valid Option..");
            }
        }
    }
    private static void Seats() {
        System.out.print("\033[H\033[2J");
        for(int i=0;i<train.size();i++)
        {
            System.out.println("\n\n Enter the NO. of Rows of " + train.get(i));
            int rows = sc.nextInt();
            System.out.println("\n\n Enter the NO. of Columns of " + train.get(i));
            int col = sc.nextInt();
            ArrayList<Integer> st = new ArrayList<Integer>();
            st.add(rows);
            st.add(col);
            seats.add(st);
            
        }
        display();

    }
    private static void Add() {
        System.out.print("\033[H\033[2J");
        String name,route;
        System.out.println("How many Trains You gonna add..?");
        int c = sc.nextInt();
        for(int i=0;i<c;i++)
        {
            System.out.println("\n Enter the train Name : ");
            name = sc.nextLine();
            name+=sc.nextLine();
            train.add(name);
            System.out.println("\n Enter the " + name + " route...(Where to Where)...");
            route = sc.nextLine();
            System.out.println("\n\n Enter the No. of Stations..");
            int count = sc.nextInt();
            System.out.println("\n\n Enter the Station Names..");
            ArrayList<String> stat = new ArrayList<String>();
            for(int j=0;j<count;j++)
            {
                stat.add((sc.next()));
            }
            station.add(stat);
            routes.add(route);
            
            

        }
        Admin_login();


    }

}

