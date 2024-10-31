package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoConstants;

public class WinningNumberInput {

    public static List<Integer> getWinningNumbers(String input) {
        List<Integer> numbers = parseInput(input);
        validate(numbers);

        return numbers;
    }

    private static List<Integer> parseInput(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.getMessage());
        }

        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }

        if (!areNumbersInRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private static boolean hasDuplicates(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = Set.copyOf(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    private static boolean areNumbersInRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(number -> number >= LottoConstants.LOTTO_MIN_NUMBER.getValue() &&
                        number <= LottoConstants.LOTTO_MAX_NUMBER.getValue());
    }
}
