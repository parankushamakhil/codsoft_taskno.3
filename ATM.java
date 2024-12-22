import java.util.Scanner;
class Useraccount{
    private double balance;
    public Useraccount(double initialbalance){
        this.balance=initialbalance;
    }
    public double getbalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
        }
        else{
            System.out.println("Invalid amount");
        }
    }
    public void withdraw(double amount){
        if(amount>0&&amount<=balance){
            balance-=amount;
        }
        else{
            System.out.println("Insufficient funds.");
        }
    }
}
public class ATM{
    private Useraccount useraccount;
    public ATM(Useraccount useraccount){
        this.useraccount=useraccount;
    }
    public void checkbalance(){
        System.out.println("Current Balance: "+useraccount.getbalance());
    }
    public void deposit(double amount){
        useraccount.deposit(amount);
        System.out.println("Successfully deposited: "+amount);
    }
    public void withdraw(double amount){
        useraccount.withdraw(amount);
        System.out.println("Successfuly withdarw: "+amount);
    }
    public static void main(String[] args) {
        int choice;
        Useraccount useraccount=new Useraccount(1000.00);
        ATM atm=new ATM(useraccount);
        Scanner s=new Scanner(System.in);
        while(true){
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("Choose an option: ");
            choice=s.nextInt();
            switch (choice) {
                case 1:
                atm.checkbalance();
                break;
                case 2:
                System.out.println("Enter deposit amount: ");
                double depositamount=s.nextDouble();
                atm.deposit(depositamount);
                break;
                case 3:
                System.out.println("Enter withdraw amount: ");
                double withdarwamount=s.nextDouble();
                atm.withdraw(withdarwamount);
                break;
                case 4:
                System.out.println("Thank you for using our ATM. Have a nice Day");
                s.close();
                return;
                default:
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}