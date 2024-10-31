package lotto.domain;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(int amount) {
        checkEnough(amount);
        checkDivisible(amount);
        this.amount = amount;
    }

    public int getQuantity() {
        return amount / LottoConfig.PRICE.getValue();
    }

    private void checkEnough(int amount) {
        if (amount < LottoConfig.PRICE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 금액이 부족합니다.");
        }
    }

    private void checkDivisible(int amount) {
        if (amount % LottoConfig.PRICE.getValue() != 0) {
            throw new IllegalArgumentException("[ERROR] 금액이 로또 가격과 나누어 떨어져야 합니다.");
        }
    }
}
