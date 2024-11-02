package lotto.validator;

import lotto.utils.ExceptionUtils;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.constants.ErrorMessage.*;

public class InputValidator {
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
            ExceptionUtils.throwIllegalArgument(ERROR_EMPTY_INPUT.getMessage());
        }
    }

    private static void checkPositiveNumber(final String input) {
        if (!POSITIVE_NUMBER_PATTERN.matcher(input).matches() || Integer.parseInt(input) <= ZERO) {
            ExceptionUtils.throwIllegalArgument(ERROR_NOT_POSITIVE_NUMBER.getMessage());
        }
    }

    private static void checkTrailingComma(final String input) {
        if (TRAILING_DELIMITER_PATTERN.matcher(input).matches()) {
            ExceptionUtils.throwIllegalArgument(ERROR_TRAILING_COMMA.getMessage());
        }
    }

    private static void checkSeparatedNumbers(final String input) {
        if (!DELIMITER_PATTERN.matcher(input).matches()) {
            ExceptionUtils.throwIllegalArgument(ERROR_INVALID_WIN_NUMBERS.getMessage());
        }
    }

    private static void checkAllPositiveNumbers(final String input) {
        List<String> split = List.of(input.split(DELIMITER));
        for (String value : split) {
            checkPositiveNumber(value);
        }
    }
}
