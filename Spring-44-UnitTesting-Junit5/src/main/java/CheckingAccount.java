public class CheckingAccount {

    double balance;
    long accountNumber;
    String accountHolder;
    String type = "checking";

    public void setInfo(double pBalance, long pAccountNumber, String pAccountHolder){
        balance = pBalance;
        accountNumber = pAccountNumber;
        accountHolder = pAccountHolder;
    }

    public double deposit(double amount){
        balance += amount;
        return balance;
    }

    public double withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
        }else{
            System.out.println("insufficient fund in account");
        }
        return balance;
    }

    public double purchase(String item, double price){
        if(price <= balance){
            balance -= price;
        }else{
            balance -= (price+35);
        }
        return balance;
    }

    public void withdrawBranch(double amount, boolean branch){
        if(amount > 500 && !branch){
            throw new IllegalArgumentException();
        }
//        balance -= amount;
//        return balance;
    }


}
