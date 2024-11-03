package lotto.validator;

import lotto.utils.LottoException;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.constants.ErrorMessage.ERROR_EMPTY_INPUT;
import static lotto.constants.ErrorMessage.ERROR_NOT_POSITIVE_NUMBER;
import static lotto.constants.ErrorMessage.ERROR_TRAILING_COMMA;
import static lotto.constants.ErrorMessage.ERROR_INVALID_WIN_NUMBERS;

public class InputValidator {
    private static final String DELIMITER = ",";
    private static final Integer ZERO = 0;
    private static final Pattern TRAILING_DELIMITER_PATTERN = Pattern.compile(".*,$");
    private static final Pattern DELIMITER_PATTERN = Pattern.compile("^([a-zA-Z가-힣\\d-]+,)*[a-zA-Z가-힣\\d-]+$");
    private static final Pattern POSITIVE_NUMBER_PATTERN = Pattern.compile("\\d+");

    private InputValidator() {
    }

    public static void validatePurchaseAmount(final String input) {
        checkEmptyInput(input);
        checkPositiveNumber(input);
    }

    public static void validateWinNumbers(final String input) {
        checkEmptyInput(input);
        checkTrailingComma(input);
        checkSeparatedNumbers(input);
        checkAllPositiveNumbers(input);
    }

    public static void validateBonusNumber(final String input) {
        checkEmptyInput(input);
        checkPositiveNumber(input);
    }

    private static void checkEmptyInput(final String input) {
        if (input.isBlank()) {
            throw new LottoException(ERROR_EMPTY_INPUT);
        }
    }

    private static void checkPositiveNumber(final String input) {
        if (!POSITIVE_NUMBER_PATTERN.matcher(input).matches() || Integer.parseInt(input) <= ZERO) {
            throw new LottoException(ERROR_NOT_POSITIVE_NUMBER);
        }
    }

    private static void checkTrailingComma(final String input) {
        if (TRAILING_DELIMITER_PATTERN.matcher(input).matches()) {
            throw new LottoException(ERROR_TRAILING_COMMA);
        }
    }

    private static void checkSeparatedNumbers(final String input) {
        if (!DELIMITER_PATTERN.matcher(input).matches()) {
            throw new LottoException(ERROR_INVALID_WIN_NUMBERS);
        }
    }

    private static void checkAllPositiveNumbers(final String input) {
        List<String> split = List.of(input.split(DELIMITER));
        for (String value : split) {
            checkPositiveNumber(value);
        }
    }
}
