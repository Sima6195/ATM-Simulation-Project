public class Account {

    private String accountNumber;
    private String pin;
    private String accountType;
    private double balance;
    private String userName;

    public Account(String userName, String accountNumber, String pin, double balance) {
        this.userName = userName;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.accountType = "Savings";
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }
}
