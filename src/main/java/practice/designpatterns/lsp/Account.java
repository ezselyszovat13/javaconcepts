package practice.designpatterns.lsp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Account {
    private int balance;
    public abstract void withdraw(int amount);
    public abstract void deposit(int amount);
}
