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
    public String getUserName() { return userName; }
    public String getAccountNumber() { return accountNumber; }
    public String getPin() { return pin; }
    public String getAccountType() { return accountType; }
    public double getBalance() { return balance; }

//    JUST FOR TESTING
    public static void main(String[] args) {

        Account account1 = new Account("Dineo Makofane","109087989", "11110", 500.00);
        Account account2 = new Account("Nonjabula Phoswa","1002986511", "2222", 1000.00);
        Account account3 = new Account("Simamkele Mampondo","10975324", "3333", 250.00);
        Account account4 = new Account("Promise Kamanga","1009864", "44841", 750.00);


        System.out.println(account1.getUserName() + " " +
                account1.getAccountNumber() + " - " +
                account1.getAccountType() + " - PIN: " +
                account1.getPin() + " - R" +
                account1.getBalance());

        System.out.println(account2.getUserName() + " " +
                account2.getAccountNumber() + " - " +
                account2.getAccountType() + " - PIN: " +
                account2.getPin() + " - R" +
                account2.getBalance());

        System.out.println(account3.getUserName() + " " +
                account3.getAccountNumber() + " - " +
                account3.getAccountType() + " - PIN: " +
                account3.getPin() + " - R" +
                account3.getBalance());

        System.out.println(account4.getUserName() + " " +
                account4.getAccountNumber() + " - " +
                account4.getAccountType() + " - PIN: " +
                account4.getPin() + " - R" +
                account4.getBalance());
    }
}