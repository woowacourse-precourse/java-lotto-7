package lotto.validator;

public class MoneyInputValidator {

    public static final String POSITIVE_NUMBER_REGEX = "\\d+";
    public static final int LOTTO_PRICE = 1000;
    public static final int ZERO = 0;
    public static final String ERROR_MESSAGE_MONEY_INPUT_FORMAT = "[ERROR] 구입 금액은 양의 숫자로만 입력해야 합니다.";
    public static final String ERROR_MESSAGE_MONEY_LESS_THAN_THOUSAND = "[ERROR] 구입 금액은 1000원 이상으로만 입력해야 합니다.";
    public static final String ERROR_MESSAGE_MONEY_NOT_DIVISIBLE_BY_THOUSAND = "[ERROR] 구입 금액은 1000원 단위로만 입력 가능 합니다.";

    public static void validateMoneyInput(String input) {
        CommonInputValidator.validateCommonInput(input);
        validateIsPositiveNumber(input);
        validateIsMoreThanThousand(input);
        validateIsDivisibleByThousand(input);
    }

    private static void validateIsPositiveNumber(String input) {
        if (isNotPositiveNumber(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MONEY_INPUT_FORMAT);
        }
    }

    private static boolean isNotPositiveNumber(String input) {
        return !input.matches(POSITIVE_NUMBER_REGEX);
    }

    private static void validateIsMoreThanThousand(String input) {
        int money = Integer.parseInt(input);
        if (isLessThanThousand(money)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MONEY_LESS_THAN_THOUSAND);
        }
    }

    private static boolean isLessThanThousand(int money) {
        return money < LOTTO_PRICE;
    }

    private static void validateIsDivisibleByThousand(String input) {
        int money = Integer.parseInt(input);
        if (isNotDivisibleByThousand(money)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MONEY_NOT_DIVISIBLE_BY_THOUSAND);
        }
    }

    private static boolean isNotDivisibleByThousand(int money) {
        return money % LOTTO_PRICE != ZERO;
    }
}
