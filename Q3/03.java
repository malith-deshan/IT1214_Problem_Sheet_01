class BankAccount{
    private int accountNumber;
    private String accountHolder;
    private double balance;

    BankAccount(int accountNumber, String accountHolder, double balance){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public String getAccountHolder(){
        return accountHolder;
    }

    public double getBalance(){
        return balance;
    }

    public void setAccountNumber(int accountNumber){
        this.accountNumber=accountNumber;
    }

    public void setAccountHolder(String accountHolder){
        this.accountHolder=accountHolder;
    }

    public void setBalance(double balance){
        this.balance=balance;
    }

    public void withdraw(double amount){
        if (amount<balance){
            balance-=amount;
            return;
        }

        throw new IllegalArgumentException(accountNumber+" Insufficient Balance");
    }
}

class Bank{
    BankAccount[] account=new BankAccount[5];
    int accounts=0;

    public void addAccount(BankAccount newAccount){
        if(accounts<5){
            account[accounts]=newAccount;
            accounts++;
            return;
        }
        System.out.println("Bank Accounts are Full!");
    }

    public void withdrawMoney(int accountNumber, double amount){
        for(int i=0; i<accounts; i++){
            if(account[i].getAccountNumber()==accountNumber){
                try{
                    account[i].withdraw(amount);
                    System.out.println(accountNumber+" Withdrawal Successful.");
                }
                catch(IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
        System.out.println(accountNumber+" is not found!");
    }

    public void displayallAccounts(){
        for(int i=0; i<accounts; i++){
            System.out.println((i+1)+" Bank Account Details:");
            System.out.println("Account Number: "+account[i].getAccountNumber());
            System.out.println("Account Holder: "+account[i].getAccountHolder());
            System.out.println("Account Balance: "+account[i].getBalance());
            System.out.println();
        }
    }
}

class Main{
    public static void main(String[] args){
        Bank bank=new Bank();

        BankAccount b1=new BankAccount(1001,"Alice",5000.00);
        BankAccount b2=new BankAccount(1002,"Bob",3000.00);

        bank.addAccount(b1);
        bank.addAccount(b2);

        bank.withdrawMoney(1001,6000.00);
        bank.withdrawMoney(1002,1000.00);

        bank.displayallAccounts();
    }
}