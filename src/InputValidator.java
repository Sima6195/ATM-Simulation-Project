public class InputValidator {


    public static boolean isValidAccountNumber(String accNumber) {

        if (accNumber == null || accNumber.isEmpty()) {
            System.out.println("Account number cannot be empty.");
            return false;
        }

        if (accNumber.length() < 5 || accNumber.length() > 12) {
            System.out.println("Account number must be 5-12 digits.");
            return false;
        }

        for (char c : accNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
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
// checks whether the pin contains only numbers

        if (!pin.matches("[0-9]+")) {
            System.out.println("PIN must contain only numbers.");
            return false;
        }

        // Prevent weak PINs
        if (pin.equals("0000") || pin.equals("1234") || pin.equals("1111")) {
            System.out.println("PIN is too weak. Choose a stronger PIN.");
            return false;
        }

        return true;
    }


    // AMOUNT VALIDATION

    public static boolean isValidAmount(double amount) {

        if (amount <= 0) {
            System.out.println("Transaction failed: Amount must be greater than 0.");
            return false;
        }

        if (amount < 10) {
            System.out.println("Minimum transaction amount is R10.");
            return false;
        }

        if (amount > 20000) {
            System.out.println("Maximum transaction limit is R20 000.");
            return false;
        }

        // prevent invalid floating precision issues
        if (Math.round(amount * 100.0) != amount * 100.0) {
            System.out.println("Invalid amount format (too many decimal places).");
            return false;
        }

        return true;
    }


    // WITHDRAWAL VALIDATION

    public static boolean canWithdraw(double amount, Account account) {

        double balance = account.getBalance();

        if (amount > balance) {
            System.out.println("Transaction failed: Insufficient funds.");
            return false;
        }

        if (amount > 2000) {
            System.out.println("Transaction failed: Daily withdrawal limit is R2000.");
            return false;
        }

        return true;
    }


    // TESTING SECTION (USES TEAM CODE)

    public static void main(String[] args) {

        System.out.println(" INPUT VALIDATOR + ATM TEST STARTED ");

        // Create team account
        Account account = new Account("12345678", "1234", 1000);

        System.out.println("Initial Balance: R" + account.getBalance());

        DepositTransaction deposit = new DepositTransaction();
        WithdrawTransaction withdraw = new WithdrawTransaction();


        //  VALID DEPOSIT

        System.out.println(" Deposit R500");

        double amount1 = 500;

        if (isValidAmount(amount1)) {
            deposit.execute(account, amount1);
        }

        System.out.println("Balance: R" + account.getBalance());



        //  INVALID DEPOSIT (LOW AMOUNT)

        System.out.println(" Deposit R5");

        double amount2 = 5;

        if (isValidAmount(amount2)) {
            deposit.execute(account, amount2);
        }

        System.out.println("Balance: R" + account.getBalance());


        //  VALID WITHDRAWAL

        System.out.println(" Withdraw R300");

        double amount3 = 300;

        if (isValidAmount(amount3) && canWithdraw(amount3, account)) {
            withdraw.execute(account, amount3);
        }

        System.out.println("Balance: R" + account.getBalance());


        //  OVER WITHDRAWAL

        System.out.println("Withdraw R5000");

        double amount4 = 5000;

        if (isValidAmount(amount4) && canWithdraw(amount4, account)) {
            withdraw.execute(account, amount4);
        }

        System.out.println("Balance: R" + account.getBalance());


        // WEAK PIN TEST

        System.out.println("PIN ");
        System.out.println(isValidPin("1234"));


        // : VALID PIN

        System.out.println(" PIN 5678");
        System.out.println(isValidPin("5678"));


    }
}