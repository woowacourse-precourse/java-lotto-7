package lotto.validator;

import lotto.LottoConstants;

public class MoneyInputValidator {

    public static final String NUMERIC_REGEX = "\\d+";
    public static final int ZERO = 0;
    public static final String ERROR_MESSAGE_MONEY_INPUT_FORMAT = "[ERROR] 구입 금액은 양의 숫자로만 입력해야 합니다.";
    public static final String ERROR_MESSAGE_MONEY_LESS_THAN_THOUSAND = "[ERROR] 구입 금액은 1000원 이상으로만 입력해야 합니다.";
    public static final String ERROR_MESSAGE_MONEY_NOT_DIVISIBLE_BY_THOUSAND = "[ERROR] 구입 금액은 1000원 단위로만 입력 가능 합니다.";

    public static void validateMoneyInput(String input) {
        CommonInputValidator.validateCommonInput(input);
        validateIsNumeric(input);
        validateIsMoreThanThousand(input);
        validateIsDivisibleByThousand(input);
    }

    private static void validateIsNumeric(String input) {
        if (isNotNumeric(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MONEY_INPUT_FORMAT);
        }
    }

    private static boolean isNotNumeric(String input) {
        return !input.matches(NUMERIC_REGEX);
    }

    private static void validateIsMoreThanThousand(String input) {
        int money = Integer.parseInt(input);
        if (isLessThanThousand(money)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MONEY_LESS_THAN_THOUSAND);
        }
    }

    private static boolean isLessThanThousand(int money) {
        return money < LottoConstants.LOTTO_PRICE.getValue();
    }

    private static void validateIsDivisibleByThousand(String input) {
        int money = Integer.parseInt(input);
        if (isNotDivisibleByThousand(money)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MONEY_NOT_DIVISIBLE_BY_THOUSAND);
        }
    }

    private static boolean isNotDivisibleByThousand(int money) {
        return money % LottoConstants.LOTTO_PRICE.getValue() != ZERO;
    }
}
