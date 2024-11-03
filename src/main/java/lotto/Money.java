package lotto;

public class Money {
    private final int amount;

    public Money(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위이어야 합니다.");
        }
        this.amount = amount;
    }

    public int calculateLottoQuantity() {
        return amount / 1000;
    }
}
