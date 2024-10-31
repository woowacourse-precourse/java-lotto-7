package lotto.domain;

public class PurchaseAmount {
    private static final int LOTTO_PRICE = 1_000;

    private final int amount;

    public PurchaseAmount(int amount) {
        checkEnough(amount);
        checkDivisible(amount);
        this.amount = amount;
    }

    private void checkEnough(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 금액이 부족합니다.");
        }
    }

    private void checkDivisible(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 로또 가격과 나누어 떨어지지 않습니다.");
        }
    }
}
