package lotto.domain;

public class PurchaseAmount {

    public static final int LOTTO_PRICE = 1000;
    public static final int ZERO = 0;

    private final Integer amount;

    public PurchaseAmount(Integer amount) {
        validateIsMultipleOfLottoPrice(amount);
        validateIsNotZero(amount);
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    private void validateIsMultipleOfLottoPrice(int amount) {
        if (amount % LOTTO_PRICE != ZERO) {
            throw new IllegalArgumentException();
        }
    }

    private void validateIsNotZero(int amount) {
        if (amount == ZERO) {
            throw new IllegalArgumentException();
        }
    }
}
