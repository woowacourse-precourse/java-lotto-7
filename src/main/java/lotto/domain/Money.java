package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.exception.constants.ErrorMessage.INVALID_INPUT_TEXT;
import static lotto.exception.constants.ErrorMessage.LOTTO_PURCHASE_MONEY_LESS_THAN_1000;
import static lotto.exception.constants.ErrorMessage.LOTTO_PURCHASE_MONEY_UNIT_NOT_1000;

public class Money {

    private static final int INT_ZERO = 0;

    private final Integer amount;

    public Money(final Integer amount) {
        validateAmount(amount);

        this.amount = amount;
    }

    private void validateAmount(final Integer amount) {
        if (amount == null) {
            throw new IllegalArgumentException(INVALID_INPUT_TEXT.getMessage());
        }
        if (amount < LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(LOTTO_PURCHASE_MONEY_LESS_THAN_1000.getMessage());
        }
        if (amount % LOTTO_PRICE.getValue() != INT_ZERO) {
            throw new IllegalArgumentException(LOTTO_PURCHASE_MONEY_UNIT_NOT_1000.getMessage());
        }
    }

    public Integer getLottoCount() {
        return amount / LOTTO_PRICE.getValue();
    }

    public Integer getAmount() {
        return amount;
    }
}
