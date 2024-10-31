package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_PRICE;
import static lotto.exception.constants.ErrorMessage.INVALID_NUMBER;
import static lotto.exception.constants.ErrorMessage.LOTTO_PURCHASE_MONEY_LESS_THAN_1000;
import static lotto.exception.constants.ErrorMessage.LOTTO_PURCHASE_MONEY_UNIT_NOT_1000;

import lotto.exception.LottoException;

public class Money {

    private static final int INT_ZERO = 0;

    private final Integer amount;

    public Money(final Integer amount) {
        validateNull(amount);
        validateAmount(amount);
        validateUnit(amount);

        this.amount = amount;
    }

    private void validateNull(final Integer amount) {
        if (amount == null) {
            throw new LottoException(INVALID_NUMBER.getMessage());
        }
    }

    private void validateAmount(final Integer amount) {
        if (amount < LOTTO_PRICE.getValue()) {
            throw new LottoException(LOTTO_PURCHASE_MONEY_LESS_THAN_1000.getMessage());
        }
    }

    private void validateUnit(final Integer amount) {
        if (amount % LOTTO_PRICE.getValue() != INT_ZERO) {
            throw new LottoException(LOTTO_PURCHASE_MONEY_UNIT_NOT_1000.getMessage());
        }
    }

    public Integer getLottoCount() {
        return amount / LOTTO_PRICE.getValue();
    }

    public Integer getAmount() {
        return amount;
    }
}
