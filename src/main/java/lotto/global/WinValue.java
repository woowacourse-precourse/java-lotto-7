package lotto.global;

public enum WinValue {
    SIX(2000000000),
    FIVE_BONUS(30000000),
    FIVE(1500000),
    FOUR(50000),
    THREE(5000);

    private final int amount;

    WinValue(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

}