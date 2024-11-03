package lotto.model;

import static lotto.constant.ErrorMessage.NOT_DIVISIBLE_BY_LOTTO_PRICE;
import static lotto.constant.ErrorMessage.ZERO_LOTTO_MONEY;
import static lotto.constant.LottoInfo.LOTTO_PRICE;

public class LottoPurchaseMoney extends Money {
    public LottoPurchaseMoney(final int amount) {
        super(amount);
        validate(amount);
    }

    private void validate(final int amount) {
        validateNotZero(amount);
        validateDivisibleByLottoPrice(amount);
    }

    private void validateNotZero(final int amount) {
        if (amount == 0) {
            throw new IllegalArgumentException(ZERO_LOTTO_MONEY.getMessage());
        }
    }

    private void validateDivisibleByLottoPrice(final int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_BY_LOTTO_PRICE.getMessage());
        }
    }

    public int toLottoCount() {
        return this.money / LOTTO_PRICE;
    }
}
