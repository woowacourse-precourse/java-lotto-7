package lotto.domain;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1_000;

    private final int amount;

    public PurchaseAmount(int amount) {
        checkEnough(amount);
        this.amount = amount;
    }

    private void checkEnough(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 금액이 부족합니다.");
        }
    }
}
