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
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_AMOUNT.getMessage());
        }
    }

    private void checkDivisible(int amount) {
        if (amount % LottoConfig.PRICE.getValue() != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE.getMessage());
        }
    }

    public int get() {
        return amount;
    }
}
