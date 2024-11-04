package lotto.validator;

import lotto.exception.LottoErrorMessage;
import lotto.exception.LottoException;
import lotto.model.LottoConstants;

public class MoneyInputValidator {

    private static final String NUMERIC_REGEX = "\\d+";
    private static final int ZERO = 0;

    public static void validateMoneyInput(String input) {
        CommonInputValidator.validateCommonInput(input);
        validateIsNumeric(input);
        CommonInputValidator.validateIsInIntegerRange(input);
        validateIsMoreThanThousand(input);
        validateIsDivisibleByThousand(input);
    }

    private static void validateIsNumeric(String input) {
        if (isNotNumeric(input)) {
            throw new LottoException(LottoErrorMessage.INPUT_IS_NOT_NUMERIC);
        }
    }

    private static boolean isNotNumeric(String input) {
        return !input.matches(NUMERIC_REGEX);
    }

    private static void validateIsMoreThanThousand(String input) {
        int money = Integer.parseInt(input);
        if (isLessThanThousand(money)) {
            throw new LottoException(LottoErrorMessage.MONEY_LESS_THAN_THOUSAND);
        }
    }

    private static boolean isLessThanThousand(int money) {
        return money < LottoConstants.LOTTO_PRICE.getValue();
    }

    private static void validateIsDivisibleByThousand(String input) {
        int money = Integer.parseInt(input);
        if (isNotDivisibleByThousand(money)) {
            throw new LottoException(LottoErrorMessage.MONEY_NOT_DIVISIBLE_BY_THOUSAND);
        }
    }

    private static boolean isNotDivisibleByThousand(int money) {
        return money % LottoConstants.LOTTO_PRICE.getValue() != ZERO;
    }
}
