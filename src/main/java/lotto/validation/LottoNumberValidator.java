package lotto.validation;

import java.util.Arrays;
import lotto.view.input.InputError;
import lotto.view.input.InvalidInputException;

public class LottoNumberValidator {
    public static void validate(String input) {
        validateNotNullOrEmpty(input);
        validateHasComma(input);
        validateCommaSeparator(input);
        validateIsInteger(input);
        validatePositiveNumber(input);
    }

    private static void validateNotNullOrEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInputException(InputError.CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    private static void validateHasComma(String input) {
        if (!input.contains(",")) {
            throw new InvalidInputException(InputError.LOTTO_NUMBER_SEPARATOR_MUST_BE_COMMA);
        }
    }

    private static void validateCommaSeparator(String input) {
        String[] inputs = input.split(",");
        long count = Arrays.stream(inputs).filter(String::isEmpty).count();
        if (count > 0) {
            throw new InvalidInputException(InputError.LOTTO_NUMBER_SEPARATOR_MUST_BE_COMMA);
        }
    }

    private static void validateIsInteger(String input) {
        String[] inputs = input.split(",");
        Arrays.stream(inputs).forEach(string -> {
            try {
                Integer.parseInt(string);
            } catch (NumberFormatException e) {
                throw new InvalidInputException(InputError.LOTTO_NUMBER_SEPARATOR_MUST_BE_COMMA);
            }
        });
    }

    private static void validatePositiveNumber(String input) {
        String[] inputs = input.split(",");
        boolean allPositive = Arrays.stream(inputs)
                .map(Integer::parseInt)
                .allMatch(number -> number > 0);
        if (!allPositive) {
            throw new InvalidInputException(InputError.LOTTO_NUMBER_SEPARATOR_MUST_BE_COMMA);
        }
    }


}
