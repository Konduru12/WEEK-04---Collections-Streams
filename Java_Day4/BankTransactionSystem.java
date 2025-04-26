class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
public class BankTransactionSystem{
    private double balance;
    public BankTransactionSystem(double initialBalance) {
        this.balance = initialBalance;
    }
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount < 0) {
            throw new IllegalArgumentException("Invalid amount");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
    }
    public static void main(String[] args) {
        BankTransactionSystem account = new BankTransactionSystem(5000);
        try {
            account.withdraw(2000);
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Transaction completed");
    }
}
