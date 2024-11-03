package lotto.model;

public class PurchaseAmount {
    private static final long MIN_UNIT_PRICE = 1_000;
    private long amount;

    public PurchaseAmount(long amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 작을 수 없습니다.");
        }
        if (amount % MIN_UNIT_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public int getBuyCount() {
        return (int) (amount / MIN_UNIT_PRICE);
    }
}
