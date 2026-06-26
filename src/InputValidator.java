public class InputValidator {


    // ACCOUNT NUMBER VALIDATION

    public static boolean isValidAccountNumber(String accNumber) {

        if (accNumber == null || accNumber.isEmpty()) {
            System.out.println("Account number cannot be empty.");
            return false;
        }

        if (accNumber.length() < 5 || accNumber.length() > 12) {
            System.out.println("Account number must be between 5 and 12 digits.");
            return false;
        }

        for (int i = 0; i < accNumber.length(); i++) {
            if (!Character.isDigit(accNumber.charAt(i))) {
                System.out.println("Account number must contain only numbers.");
                return false;
            }
        }

        return true;
    }


    // PIN VALIDATION

    public static boolean isValidPin(String pin) {

        if (pin == null || pin.length() != 4) {
            System.out.println("PIN must be exactly 4 digits.");
            return false;
        }

        for (int i = 0; i < pin.length(); i++) {
            if (!Character.isDigit(pin.charAt(i))) {
                System.out.println("PIN must contain only numbers.");
                return false;
            }
        }

        if (pin.equals("0000") || pin.equals("1111") || pin.equals("1234")) {
            System.out.println("PIN is too weak.");
            return false;
        }

        return true;
    }


    // DEPOSIT VALIDATION

    public static boolean isValidDeposit(double amount) {

        if (amount < 50) {
            System.out.println("Minimum deposit amount is R50.");
            return false;
        }

        // No cents allowed
        if (amount != (int) amount) {
            System.out.println("Deposit amount cannot contain cents.");
            return false;
        }

        return true;
    }


    // WITHDRAWAL VALIDATION

    public static boolean canWithdraw(double amount, Account account) {

        if (amount < 40) {
            System.out.println("Minimum withdrawal amount is R40.");
            return false;
        }

        if (amount > 3000) {
            System.out.println("Maximum withdrawal amount is R10000.");
            return false;
        }

        if (amount > account.getBalance()) {
            System.out.println("Transaction failed: Insufficient funds.");
            return false;
        }

        return true;
    }


    // TESTING SECTION

    public static void main(String[] args) {

        System.out.println("INPUT VALIDATOR TEST ");

        Account account = new Account("tom","12345678", "5678", 1000);

        DepositTransaction deposit = new DepositTransaction();
        WithdrawTransaction withdraw = new WithdrawTransaction();

        System.out.println("Starting Balance: R" + account.getBalance());


        // Deposit Tests


        System.out.println("Deposit  R500");

        if (isValidDeposit(500)) {
            deposit.execute(account, 500);
        }

        System.out.println("Balance: R" + account.getBalance());

        System.out.println("Deposit  R30");

        if (isValidDeposit(30)) {
            deposit.execute(account, 30);
        }

        System.out.println("Balance: R" + account.getBalance());

        System.out.println("Deposit  R100.50");

        if (isValidDeposit(100.50)) {
            deposit.execute(account, 100.50);
        }

        System.out.println("Balance: R" + account.getBalance());


        // Withdrawal Tests


        System.out.println("Withdraw  R300");

        if (canWithdraw(300, account)) {
            withdraw.execute(account, 300);
        }

        System.out.println("Balance: R" + account.getBalance());

        System.out.println("Withdraw  R20");

        if (canWithdraw(20, account)) {
            withdraw.execute(account, 20);
        }

        System.out.println("Balance: R" + account.getBalance());

        System.out.println("Withdraw  R5000");

        if (canWithdraw(5000, account)) {
            withdraw.execute(account, 5000);
        }

        System.out.println("Balance: R" + account.getBalance());

        System.out.println("Withdraw R1500");

        if (canWithdraw(1500, account)) {
            withdraw.execute(account, 1500);
        }

        System.out.println("Balance: R" + account.getBalance());


        // Account Number Tests


        System.out.println("Account Number Test:");
        System.out.println(isValidAccountNumber("12345678"));
        System.out.println(isValidAccountNumber("ABC123"));


        // PIN Tests


        System.out.println("PIN Test:");
        System.out.println(isValidPin("5678"));
        System.out.println(isValidPin("1234"));
        System.out.println(isValidPin("12A4"));


    }
}