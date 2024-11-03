package lotto.validation;

import static lotto.util.LottoConstants.ZERO_THRESHOLD;

import java.util.Arrays;
import lotto.view.input.InputErrorMessage;
import lotto.view.input.InvalidInputException;

public class LottoNumberValidator {
    private final static String COMMA = ",";

    public static void validateWinningNumbers(String input) {
        validateNotNullOrEmpty(input);
        validateHasComma(input);
        validateCommaSeparator(input);
        validateIsPositiveNumber(input);
    }

    public static void validateBonusNumber(String input) {
        validateNotNullOrEmpty(input);
        validateIsNumber(input);
    }

    private static void validateNotNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInputException(InputErrorMessage.CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    private static void validateHasComma(String input) {
        if (!input.contains(COMMA)) {
            throw new InvalidInputException(InputErrorMessage.LOTTO_NUMBER_SEPARATOR_MUST_BE_COMMA);
        }
    }

    private static void validateCommaSeparator(String input) {
        String[] inputs = input.split(COMMA);
        long count = Arrays.stream(inputs).filter(String::isEmpty).count();
        if (count > ZERO_THRESHOLD.getValue()) {
            throw new InvalidInputException(InputErrorMessage.LOTTO_NUMBER_SEPARATOR_MUST_BE_COMMA);
        }
    }

    private static void validateIsPositiveNumber(String input) {
        String[] inputs = input.split(COMMA);
        validateIsNumber(inputs);
        validatePositiveNumber(inputs);
    }

    private static void validateIsNumber(String[] inputs) {
        Arrays.stream(inputs).forEach(string -> {
            try {
                Integer.parseInt(string);
            } catch (NumberFormatException e) {
                throw new InvalidInputException(InputErrorMessage.LOTTO_NUMBER_SEPARATOR_MUST_BE_COMMA);
            }
        });
    }

    private static void validatePositiveNumber(String[] inputs) {
        boolean allPositive = Arrays.stream(inputs)
                .map(Integer::parseInt)
                .allMatch(number -> number > ZERO_THRESHOLD.getValue());
        if (!allPositive) {
            throw new InvalidInputException(InputErrorMessage.LOTTO_NUMBER_SEPARATOR_MUST_BE_COMMA);
        }
    }

    private static void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(InputErrorMessage.INTEGER_REQUIRED);
        }
    }

}
