package lotto;

public class Money {

    private final long amount;

    public Money(long amount) {
        validateNonNegative(amount);
        this.amount = amount;
    }

    private void validateNonNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("금액은 음수일 수 없습니다");
        }
    }

    public boolean hasChangesWith(long price) {
        return amount % price != 0;
    }
}

