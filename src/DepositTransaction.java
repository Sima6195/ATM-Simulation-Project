public class DepositTransaction  extends Transaction {
    @Override
    public boolean execute(Account account, double amount) {
        account.deposit(amount);
        return true;
    }
}
