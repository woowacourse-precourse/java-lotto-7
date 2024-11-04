package lotto.domain;

import static java.lang.String.format;
import static lotto.constant.LottoGameRule.LOTTO_COST;
import static lotto.exception.ErrorMessage.MONEY_NOT_DIVISIBLE;
import static lotto.exception.ErrorMessage.MONEY_OUT_OF_RANGE;

import lotto.exception.LottoException;
import lotto.utils.InputParser;

public class Money {
    private final int price;

    public Money(final String input) {
        int price = InputParser.parsePrice(input);
        validate(price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    private void validate(final int price) {
        validateRange(price);
        validateDivisibility(price);
    }

    private void validateRange(final int price) {
        if (isInValidRange(price)) {
            throw new LottoException(format(MONEY_OUT_OF_RANGE.getMessage(), LOTTO_COST.getValue()));
        }
    }

    private void validateDivisibility(final int price) {
        if (isNotDivisible(price)) {
            throw new LottoException(format(MONEY_NOT_DIVISIBLE.getMessage(), LOTTO_COST.getValue()));
        }
    }

    private boolean isInValidRange(final int price) {
        return price < LOTTO_COST.getValue();
    }

    private boolean isNotDivisible(final int price) {
        return price % LOTTO_COST.getValue() != 0;
    }

}
