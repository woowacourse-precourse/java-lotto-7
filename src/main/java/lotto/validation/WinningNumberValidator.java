package lotto.validation;

import java.util.HashSet;
import java.util.Set;
import lotto.enums.Delimiter;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoValue;

public class WinningNumberValidator {

    public static void validateWinningNumber(String input) {
        validateNull(input);
        validateSeparatorNotComma(input);
        validateSeparatorContinue(input);
        validateNoEmptyBetweenCommas(input);
        validateSixNumbers(input);
        validateStartWithZero(input);
        validateNumberDuplicate(input);
        validateRange(input);
    }

    private static void validateNull(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL.getErrorMessage());
        }
    }

    private static void validateSeparatorNotComma(String input) {
        if (!input.contains(Delimiter.COMMA.getDelimiter())) {
            throw new IllegalArgumentException(ErrorMessage.SEPARATOR_NOT_COMMA.getErrorMessage());
        }
    }

    private static void validateSeparatorContinue(String input) {
        if (input.contains(Delimiter.CONTINUE_COMMA.getDelimiter())) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_SEPARATOR_CONTINUE.getErrorMessage());
        }
    }

    private static void validateNoEmptyBetweenCommas(String input) {
        String [] values = getSplit(input);

        for (String value : values) {
            if (value.trim().isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_NUMBER_BLANK.getErrorMessage());
            }
        }
    }

    private static void validateSixNumbers(String input) {
        String [] values = getSplit(input);

        if (values.length != LottoValue.NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INPUT_SIX_NUMBERS.getErrorMessage());
        }
    }

    private static void validateStartWithZero(String input) {
        String [] values = getSplit(input);

        for (String value : values) {
            value = value.trim();
            if (value.startsWith("0")) {
                throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_START_WITH_ZERO.getErrorMessage());
            }
        }
    }

    private static void validateNumberDuplicate(String input) {
        String [] values = getSplit(input);
        Set<String> numbers = new HashSet<>();

        for (String value : values) {
            value = value.trim();
            if (!numbers.add(value)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_ALLOW_DUPLICATE_NUMBER.getErrorMessage());
            }
        }
    }

    private static void validateRange(String input) {
        String [] values = getSplit(input);

        for (String value : values) {
            int number = Integer.parseInt(value.trim());
            if (number < LottoValue.MIN_LOTTO_NUMBER_RANGE.getValue() || number > LottoValue.MAX_LOTTO_NUMBER_RANGE.getValue()) {
                throw new IllegalArgumentException(ErrorMessage.ALLOW_ONE_TO_FORTY_FIVE.getErrorMessage());
            }
        }
    }

    private static String[] getSplit(String input) {
        return input.split(Delimiter.COMMA.getDelimiter());
    }
}
