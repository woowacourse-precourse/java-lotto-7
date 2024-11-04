package lotto.model;

public class Money {

    private final static String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "금액은 음수일 수 없습니다";
    private final long amount;

    public Money(long amount) {
        validateNonNegative(amount);
        this.amount = amount;
    }

    private void validateNonNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public boolean hasChangeWith(long price) {
        return amount % price != 0;
    }

    public long countAvailableFrom(long price) {
        return amount / price;
    }

    public long getAmount() {
        return amount;
    }

    public Money add(Money money) {
        return new Money(amount + money.amount);
    }

    public double calculateProfitRateOf(Money profit) {
        return (double) profit.amount / amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Money money = (Money) o;

        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return (int) (amount ^ (amount >>> 32));
    }
}

