import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account("tom","109087989", "11110", 500.00));
        accounts.add(new Account("mom","1002986511", "2222", 100.00));
        accounts.add(new Account("pom","10975324", "3333", 250.00));
        accounts.add(new Account("kom","1009864", "44841", 0.00));

        AuthenticationService auth = new AuthenticationService(accounts);
        Account activeAccount = null;

        boolean running = true;

        while (running) {

            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Login");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Logout");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.nextLine();

                    System.out.print("Enter PIN: ");
                    String pin = scanner.nextLine();

                    activeAccount = auth.login(accountNumber, pin);

                    if (activeAccount == null) {
                        System.out.println("Login failed.");
                    } else {
                        System.out.println("Login successful.");
                    }

                    break;

                case 2:

                    if (activeAccount == null) {
                        System.out.println("Please login first.");
                    } else {
                        System.out.println("Balance: R" + activeAccount.getBalance());
                    }

                    break;

                case 3:

                    if (activeAccount == null) {
                        System.out.println("Please login first.");
                        break;
                    }

                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine();

                    if (InputValidator.isValidAmount(depositAmount)) {

                        DepositTransaction deposit = new DepositTransaction();
                        deposit.execute(activeAccount, depositAmount);

                        System.out.println("Deposit successful.");
                        System.out.println("New Balance: R" + activeAccount.getBalance());

                    } else {
                        System.out.println("Invalid deposit amount.");
                    }

                    break;

                case 4:

                    if (activeAccount == null) {
                        System.out.println("Please login first.");
                        break;
                    }

                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine();

                    if (InputValidator.isValidAmount(withdrawAmount) &&
                            InputValidator.canWithdraw(withdrawAmount, activeAccount)) {

                        WithdrawTransaction withdraw = new WithdrawTransaction();
                        boolean success = withdraw.execute(activeAccount, withdrawAmount);

                        if (success) {
                            System.out.println("Withdrawal successful.");
                        } else {
                            System.out.println("Withdrawal failed.");
                        }

                        System.out.println("New Balance: R" + activeAccount.getBalance());

                    } else {
                        System.out.println("Withdrawal denied.");
                    }

                    break;

                case 5:

                    if (activeAccount != null) {
                        auth.logout();
                        activeAccount = null;
                    } else {
                        System.out.println("No user is logged in.");
                    }

                    break;

                case 6:

                    System.out.println("Thank you for using the ATM.");
                    running = false;
                    break;

                default:

                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}