package lotto.util.validator;

import lotto.exception.InputErrorMessage;

public class InputValidator {
    private final static String LOTTO_RANGE_PATTERN = "([1-9]|[1-9][0-9]?|45)(,([1-9]|[1-9][0-9]?|45))*";

    private InputValidator() {}

    public static void validateInputValue(String input) {
        validateInputIsEmpty(input);
        validateNumericFormat(input);
        validateInputNumber(input);
    }

    public static void validateInputLottoValue(String input) {
        validateInputIsEmpty(input);
        validateLottoNumericFormat(input);
    }

    private static void validateInputIsEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(InputErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static void validateInputNumber(String input) {
        int amount = 0;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(InputErrorMessage.OVER_NUMERIC_FORTMAT.getMessage());
        }
    }
    
    //금액, 보너스번호 숫자검증
    private static void validateNumericFormat(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_NUMERIC_FORMAT.getMessage());
        }
    }
    
    //로또 번호 검증
    private static void validateLottoNumericFormat(String input) {
        if (!input.matches(LOTTO_RANGE_PATTERN)) {
            throw new IllegalArgumentException(InputErrorMessage.INVALID_WINNING_RANGE.getMessage());
        }
    }
}
