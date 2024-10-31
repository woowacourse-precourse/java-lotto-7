package lotto;

public class User {
    private final long moneyAmount;

    public User(String moneyAmount) {
        this.moneyAmount = Long.parseLong(moneyAmount);
    }

    public long getMoneyAmount() {
        return moneyAmount;
    }
}
