public class WithdrawTransaction extends Transaction {
    @Override
    public boolean execute(Account account, double amount) {
        return account.withdraw(amount);
    }
}
