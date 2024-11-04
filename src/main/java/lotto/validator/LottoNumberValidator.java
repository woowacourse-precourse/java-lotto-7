package lotto.validator;

import static lotto.constant.Constants.DELIMITER;
import static lotto.constant.Constants.LOTTO_NUMBER_LENGTH;
import static lotto.constant.Constants.LOTTO_NUMBER_RANGE_END;
import static lotto.constant.Constants.LOTTO_NUMBER_RANGE_START;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import lotto.exception.InputNumberException;

public class LottoNumberValidator {
    public static List<Integer> validateAndParse(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(InputNumberException.EMPTY_INPUT.getMessage());
        }

        if (input.trim().endsWith(DELIMITER)) {
            throw new IllegalArgumentException(InputNumberException.ENDS_WITH_COMMA.getMessage());
        }

        List<Integer> numbers;
        try {
            numbers = parseNumbers(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputNumberException.INVALID_FORMAT.getMessage());
        }

        validateLength(numbers);
        validateRange(numbers);
        validateDuplicates(numbers);
        return numbers;
    }

    private static List<Integer> parseNumbers(String input) {
        return Stream.of(input.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(InputNumberException.DUPLICATE_NUMBERS.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_NUMBER_RANGE_START || number > LOTTO_NUMBER_RANGE_END) {
                throw new IllegalArgumentException(InputNumberException.INVALID_RANGE.getMessage());
            }
        }
    }

    private static void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH) {
            throw new IllegalArgumentException(InputNumberException.INVALID_LENGTH.getMessage());
        }
    }
}
