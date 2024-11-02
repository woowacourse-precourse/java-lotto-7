package lotto.validator;

import lotto.utils.ExceptionUtils;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String ERROR_MESSAGE_EMPTY_INPUT = "입력값에 공백을 허용하지 않습니다.";
    private static final String ERROR_MESSAGE_NOT_POSITIVE_NUMBER = "양의 정수가 아닌 값은 허용하지 않습니다.";
    private static final String ERROR_MESSAGE_INVALID_WIN_NUMBERS = "당첨 번호는 구분자(,)로 구분할 수 있어야 합니다.";
    private static final String ERROR_MESSAGE_TRAILING_COMMA = "입력값의 마지막에 콤마(,)가 올 수 없습니다.";
    private static final String DELIMITER = ",";
    private static final Integer ZERO = 0;
    private static final Pattern TRAILING_DELIMITER_PATTERN = Pattern.compile(".*,$");
    private static final Pattern DELIMITER_PATTERN = Pattern.compile("^([a-zA-Z가-힣\\d]+,)*[a-zA-Z가-힣\\d]+$");
    private static final Pattern POSITIVE_NUMBER_PATTERN = Pattern.compile("\\d+");

    private InputValidator() {
    }

    public static void validatePurchaseAmount(final String input) {
        checkEmptyInput(input);
        checkPositiveNumber(input);
    }

    public static void validateWinNumbers(final String input) {
        checkEmptyInput(input);
        checkSeparatedNumbers(input);
        checkTrailingComma(input);
        checkAllPositiveNumbers(input);
    }

    public static void validateBonusNumber(final String input) {
        checkEmptyInput(input);
        checkPositiveNumber(input);
    }

    private static void checkEmptyInput(final String input) {
        if (input.isBlank()) {
            ExceptionUtils.throwIllegalArgument(ERROR_MESSAGE_EMPTY_INPUT);
        }
    }

    private static void checkPositiveNumber(final String input) {
        if (!POSITIVE_NUMBER_PATTERN.matcher(input).matches() || Integer.parseInt(input) <= ZERO) {
            ExceptionUtils.throwIllegalArgument(ERROR_MESSAGE_NOT_POSITIVE_NUMBER);
        }
    }

    private static void checkTrailingComma(final String input) {
        if (TRAILING_DELIMITER_PATTERN.matcher(input).matches()) {
            ExceptionUtils.throwIllegalArgument(ERROR_MESSAGE_TRAILING_COMMA);
        }
    }

    private static void checkSeparatedNumbers(final String input) {
        if (!DELIMITER_PATTERN.matcher(input).matches()) {
            ExceptionUtils.throwIllegalArgument(ERROR_MESSAGE_INVALID_WIN_NUMBERS);
        }
    }

    private static void checkAllPositiveNumbers(final String input) {
        List<String> split = List.of(input.split(DELIMITER));
        for (String value : split) {
            checkPositiveNumber(value);
        }
    }
}
