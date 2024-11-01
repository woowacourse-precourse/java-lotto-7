package lotto.model;

import java.util.regex.Pattern;

public class InputValidator {

    public static final String EMPTY_INPUT_EXCEPTION = "[ERROR] 입력된 금액이 없습니다.";
    public static final String INVALID_CHARACTER_INPUT_EXCEPTION = "[ERROR] 잘못된 구입 금액을 입력하셨습니다."
            + " 구입 금액 입력은 숫자(양의 정수)로만 이루어져야 합니다.";
    public static final String UNDER_MIN_AMOUNT_INPUT_EXCEPTION = "[ERROR] 잘못된 구입 금액을 입력하셨습니다."
            + " 최소 한장 이상 구매할 수 있는 금액을 입력하셔야 합니다. (한장 1000)";
    public static final String INVALID_AMOUNT_UNIT_EXCEPTION = "[ERROR] 잘못된 구입 금액을 입력하셨습니다."
            + " 구매 금액은 1000원 단위로 입력하셔야 합니다. (1000으로 나누어 떨어지도록)";
    public static final String EXCEED_MAX_AREA_EXCEPTION = "[ERROR] 잘못된 구입 금액을 입력하셨습니다."
            + " 구매 금액이 최대 범위를 초과하였습니다.";
    private static final String ATTEMPTS_PATTERN_REGEX = "^[0-9]+$";

    public void validateInputAmount(String input) {
        validateEmptyAmount(input);
        validateInvalidCharacter(input);
        int amount = validateExceedMaxArea(input);
        validateMinAmount(amount);
        validateAmountUnit(amount);
    }

    private void validateEmptyAmount(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_EXCEPTION);
        }
    }

    private void validateInvalidCharacter(String input) {
        if (!Pattern.matches(ATTEMPTS_PATTERN_REGEX, input)) {
            throw new IllegalArgumentException(INVALID_CHARACTER_INPUT_EXCEPTION);
        }
    }

    private int validateExceedMaxArea(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEED_MAX_AREA_EXCEPTION);
        }
    }

    private void validateMinAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException(UNDER_MIN_AMOUNT_INPUT_EXCEPTION);
        }
    }

    private void validateAmountUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_AMOUNT_UNIT_EXCEPTION);
        }
    }
}
