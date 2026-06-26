public abstract class Transaction {
    public abstract boolean execute(Account account, double amount);






//    ############################################################## FOR TESTING ########################################################################

    public static void main(String[] args) {

        Account account1 = new Account("tom", "109087989", "11110", 500.00);

        System.out.println("=== INITIAL ACCOUNT DETAILS ===");
        System.out.println("Account Number: " + account1.getAccountNumber());
        System.out.println("Balance: R" + account1.getBalance());

        // Deposit Test
        DepositTransaction deposit = new DepositTransaction();

        deposit.execute(account1, 200);

        System.out.println("\n=== AFTER DEPOSIT OF R200 ===");
        System.out.println("Balance: R" + account1.getBalance());

        // Withdrawal Test
        WithdrawTransaction withdraw = new WithdrawTransaction();

        boolean withdrawalSuccess = withdraw.execute(account1, 300);

        System.out.println("\n=== AFTER WITHDRAWAL OF R300 ===");
        System.out.println("Transaction Successful: " + withdrawalSuccess);
        System.out.println("Balance: R" + account1.getBalance());

        // Insufficient Funds Test
        boolean failedWithdrawal = withdraw.execute(account1, 1000);

        System.out.println("\n=== WITHDRAWAL OF R1000 ===");
        System.out.println("Transaction Successful: " + failedWithdrawal);
        System.out.println("Balance: R" + account1.getBalance());
    }
}
