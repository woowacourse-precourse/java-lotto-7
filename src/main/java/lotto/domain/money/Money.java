package lotto.domain.money;

public record Money(int amount) {

    private static final int MIN_AMOUNT = 0;

    public Money {
        validate(amount);
    }

    private void validate(int amount) {
        if (isOutOfRange(amount)) {
            throw new IllegalArgumentException(String.format("금액은 %,d보다 작을 수 없습니다.", MIN_AMOUNT));
        }
    }

    private boolean isOutOfRange(int amount) {
        return amount < MIN_AMOUNT;
    }

    public boolean isEnoughToBuy(int price) {
        return amount >= price;
    }

    public Money deduct(int price) {
        if (isEnoughToBuy(price)) {
            return new Money(amount - price);
        }
        throw new IllegalArgumentException("잔액이 충분하지 않습니다.");
    }

    public boolean isEmpty() {
        return this.amount == 0;
    }

}
