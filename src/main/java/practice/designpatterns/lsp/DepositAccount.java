package practice.designpatterns.lsp;

public class DepositAccount extends Account{
    //LSP Violation
    @Override
    public void withdraw(int amount) {
        throw new UnsupportedOperationException("We cannot withdraw with this Account!");
    }

    @Override
    public void deposit(int amount) {
        this.setBalance(this.getBalance() - amount);
    }
}
