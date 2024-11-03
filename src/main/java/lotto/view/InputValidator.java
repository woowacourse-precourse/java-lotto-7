package lotto.view;

import static lotto.global.constants.Constants.*;

public class InputValidator {

    // 현재 클래스와 관련성이 깊은 상수는 굳이 enum 클래스로 두지 않았다.
    private static final int PURCHASE_MAX_LIMIT = 100_000;
    private static final int PURCHASE_MIN_LIMIT = 1000;

    public static void validateStringTypeAmount(String input) {
        validateEmptyInput(input);
        validateNoWhiteSpaceInBetween(input);
        validateContainsOnlyCommaAndDigits(input);
    }

    public static void validateIntegerTypeAmount(int amount) {
        validateAmountInRange(amount);
        validateDivisibleByThousand(amount);
    }

    // 사용자가 아무 입력도 없이 엔터만 입력했는지 검증
    private static void validateEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_HEADER.getValue() + "입력값이 비어 있습니다. 값을 입력해 주세요.");
        }
    }

    // 입력된 문자열 사이에 공백(스페이스, 탭 등 다양한 공백)이 포함되어 있는지 검증
    private static void validateNoWhiteSpaceInBetween(String input) {
        if (input.matches(WHITESPACE_REGEX.getValue())) {
            throw new IllegalArgumentException(ERROR_HEADER.getValue() + "입력값에 공백이 포함될 수 없습니다.");
        }
    }

    // 입력된 문자에 콤마와 숫자만 담겨 있는지 검증한다.
    private static void validateContainsOnlyCommaAndDigits(String input) {
        if (!input.matches(COMMA_DIGITS_REGEX.getValue())) {
            throw new IllegalArgumentException(ERROR_HEADER.getValue() + "입력값은 숫자와 콤마만 포함해야 합니다.");
        }
    }

    // 콤마를 제거하고 정수형태로 바뀐 사용자의 입력이 1000원 이상 10만원 이하인지 검증한다.
    private static void validateAmountInRange(int input) {

        if (input < PURCHASE_MIN_LIMIT) {
            throw new IllegalArgumentException(ERROR_HEADER.getValue() + "1000원 이상부터 구매가 가능합니다.");
        }

        if (input > PURCHASE_MAX_LIMIT) {
            throw new IllegalArgumentException(ERROR_HEADER.getValue() + "10만 원을 초과해서 구매할 수 없습니다.");
        }

    }

    // 입력이 1000으로 나누어 떨어지는지
    private static void validateDivisibleByThousand(int input) {
        if (input % PURCHASE_MIN_LIMIT != 0) {
            throw new IllegalArgumentException(ERROR_HEADER.getValue() + "입력값은 1000으로 나누어 떨어져야 합니다.");
        }
    }

}
