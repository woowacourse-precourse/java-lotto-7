package lotto.validator;

import lotto.Exception.MoneyException;

import static lotto.Exception.MoneyExceptionType.*;
import static lotto.utils.LottoRules.LOTTO_PRICE;

public class MoneyValidator implements Validator {
    private static final String NUMBER_PATTERN = "-?\\d+(\\.\\d+)?";

    @Override
    public void validate(String text) throws IllegalArgumentException {
        textValidate(text);
        priceValidate(text);
    }

    private void textValidate(String text) throws MoneyException {
        if (isNullOrEmpty(text)) {
            throw new MoneyException(MONEY_EMPTY_ERROR);
        }
        if (!isNumber(text)) {
            throw new MoneyException(MONEY_NAN_ERROR);
        }
    }

    private boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private boolean isNumber(String text) {
        return text.matches(NUMBER_PATTERN);
    }

    private void priceValidate(String text) throws MoneyException {
        try {
            int price = Integer.parseInt(text);

            if (!isValidRange(price)) {
                throw new MoneyException(MONEY_RANGE_ERROR);
            }

            if (!isValidUnit(price)) {
                throw new MoneyException(MONEY_UNIT_ERROR);
            }
        } catch (NumberFormatException e) {
            throw new MoneyException(MONEY_RANGE_ERROR);
        }
    }

    private boolean isValidRange(int price) {
        return LOTTO_PRICE <= price && price <= LOTTO_PRICE * 100;
    }

    private boolean isValidUnit(int price) {
        return price % LOTTO_PRICE == 0;
    }
}
