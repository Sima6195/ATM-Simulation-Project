import java.util.List;

public class AuthenticationService {

    private List<Account> accounts;
    private Account activeAccount;

    public AuthenticationService(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Account login(String accountNumber, String pin) {

        for (Account account : accounts) {

            if (account.getAccountNumber().equals(accountNumber)) {

                if (account.getPin().equals(pin)) {

                    activeAccount = account;
                    System.out.println("Login successful!");
                    return activeAccount;

                } else {
                    System.out.println("Incorrect PIN.");
                    return null;
                }
            }
        }

        System.out.println("Account not found.");
        return null;
    }

    public void logout() {
        activeAccount = null;
        System.out.println("Logged out successfully.");
    }

    public Account getActiveAccount() {
        return activeAccount;
    }
}