package lotto.util.validator;

import lotto.exception.InputErrorMessage;
import lotto.util.parser.InputParser;

public class AmountValidator {
    private static final int MIN_AMOUNT = 1000; // 최소 구입 금액
    private static final int MAX_AMOUNT = 1000000; // 최대 구입 금액
    private static final int DIVISIBILITY_FACTOR = 1000; // 구입 금액의 배수 조건

    private AmountValidator() {}

    public static void convertAndValidate(String input) {
        validateNotEmpty(input);
        validateNumericFormat(input);
        int amount = InputParser.parseNumber(input);
        validateAmount(amount);
    }

    private static void validateNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(InputErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static void validateNumericFormat(String input) {
        if (!input.matches("\\d+")) {  // 숫자 형식이 아니면 예외 발생
            throw new IllegalArgumentException(InputErrorMessage.INVALID_NUMERIC_FORMAT.getMessage());
        }
    }

    public static void validateAmount(int amount) {
        validatePositiveAmount(amount);
        validateDivisibility(amount);
        validateAmountLimit(amount);
    }

    private static void validatePositiveAmount(int amount) {
        if (amount < MIN_AMOUNT) {
            throw new IllegalArgumentException(InputErrorMessage.NEGATIVE_OR_ZERO_AMOUNT.getMessage());
        }
    }

    private static void validateDivisibility(int amount) {
        if (amount % DIVISIBILITY_FACTOR != 0) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void validateAmountLimit(int amount) {
        if (amount > MAX_AMOUNT) {
            throw new IllegalArgumentException(InputErrorMessage.EXCEEDS_LIMIT_AMOUNT.getMessage());
        }
    }
}
