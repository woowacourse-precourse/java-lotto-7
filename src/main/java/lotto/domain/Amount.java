package lotto.domain;

public class Amount {

    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    private Integer amount;

    public Amount(Integer amount) {
        validateIsMultipleOfLottoPrice(amount);
        validateIsNotZero(amount);
        this.amount = amount;
    }

    private void validateIsMultipleOfLottoPrice(int amount) {
        if (amount % LOTTO_PRICE != ZERO)
            throw new IllegalArgumentException();
    }

    private void validateIsNotZero(int amount) {
        if (amount == ZERO)
            throw new IllegalArgumentException();
    }
}
