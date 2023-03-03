import java.util.*;
public class atm {
    public static Double balance = 10000.00;
    public static void main(String[] args) {
        UserAccount user = new UserAccount("Duncan John D. Carpiso","duncan", 1234);
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter your username");
            String user_1 = sc.nextLine();
            System.out.println("Enter your password");
            Integer user_2 =sc.nextInt();
            user.ValidateLogin(user_1, user_2);
            main_menu();
        }catch(Exception ex){
            System.err.println("no Strings in password");
        }
    }
    
        static void main_menu(){
        Scanner s = new Scanner(System.in);
        System.out.println("Choose 1-4");
        System.out.println("1. Withdrawal 2.Deposit");
        System.out.println("3. Balance Inquiry 4.Exit");
        System.out.println("Enter: ");
        
        int menu = s.nextInt();
        switch(menu){
            case 1 :
                System.out.println("Enter Amount of Withdrawal");
                double withdraw = s.nextDouble();
                Withdrawal(withdraw);
                break;
            case 2 :
                System.out.println("Enter Amount of Deposit");
                double deposit = s.nextDouble();
                Deposit(deposit);
                break;
            case 3 :
                Balance();
                break;
            case 4 :
                System.exit(menu);
                break;
        }
    }

    static double Withdrawal(double withdraw){
        
        if (balance >= withdraw){
            balance = balance - withdraw;
            System.out.println("\n you've withdraw "+ withdraw + " "+" Your balance is "+ balance +"\n");
            main_menu();
        }else{
            System.out.println("you dont have enough money");
            main_menu();
        }
        return withdraw;
    }

    static double Deposit(double deposit){
            balance = balance + deposit;
            System.out.println("\n You deposit"+ deposit+" "+" and you balance is "+ balance+"\n");
            main_menu();
	return deposit;
    }

    static void Balance(){
        System.out.println("\n The Balance of your account " + balance+"\n");
        main_menu();
    }
}

class UserAccount{
    private String full_name;
    protected String user_name;
    protected Integer user_password;

    public UserAccount(String name,String Uname,Integer pass){
        this.full_name = name;
        this.user_name = Uname;
        this.user_password = pass;
    }


    public boolean ValidateLogin(String Uname, Integer pass){
        
        if(this.user_name.equals(Uname)&&this.user_password.equals(pass)){
            System.out.println(getName());
            return true;
        }else{
            System.out.println("there's no username and password in our database");
            System.exit(0);
            return false;
        }
    }

    public String getName(){
        full_name = "\nWelcome " + full_name;
        return this.full_name;
    }
}
