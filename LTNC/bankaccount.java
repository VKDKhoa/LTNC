class BankAccount{
    private double balance;
    private String password;

    public BankAccount(String pwd, double initBalance){
        this.balance = initBalance;
        this.password = pwd;
    }
    public double getBalance(String pwd){
        if(this.password.equals(pwd)){
            return this.balance;
        } else {
            return -1;
        }
    }
    public void deposit(String pwd, double amount){
        if(this.password.equals(pwd) && amount > 0){
            this.balance += amount;
        }
    }
    public void withdraw(String pwd, double amount){
        if(this.password.equals(pwd) && amount > 0 && amount <= this.balance){
            this.balance -= amount;
        }
    }
}