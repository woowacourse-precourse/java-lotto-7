package lotto.model;

import static lotto.constant.ErrorMessage.INVALID_LOTTO_MONEY_UNIT;
import static lotto.constant.ErrorMessage.ZERO_LOTTO_MONEY;
import static lotto.constant.LottoInfo.LOTTO_PRICE;

public class LottoPurchaseMoney extends Money {
    public LottoPurchaseMoney(final int money) {
        super(money);
        validate(money);
    }

    private void validate(final int money) {
        if (money == 0) {
            throw new IllegalArgumentException(ZERO_LOTTO_MONEY.getMessage());
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
