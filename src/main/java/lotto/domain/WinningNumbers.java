package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {

    private static final String DELIMITER = ",";

    private static final int NUMBERS_RANGE_START = 1;

    private static final int NUMBERS_RANGE_END = 45;

    private final List<Integer> numbers;

    public WinningNumbers(String inputNumbers) {
        List<String> numbersInString = parse(inputNumbers);
        this.numbers = validateInteger(numbersInString);
        validateSixNumbers(numbers);
        validateRange(numbers);
        validateDuplicated(numbers);
    }

    private List<String> parse(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(DELIMITER))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }

    private List<Integer> validateInteger(List<String> numbersInString) {
        List<Integer> parsedNumbers = new ArrayList<>();
        for (String number : numbersInString) {
            try {
                parsedNumbers.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
        }
        return parsedNumbers;
    }

    private void validateSixNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new NumberFormatException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean isRange = numbers.stream()
                .allMatch(number -> number >= NUMBERS_RANGE_START && number <= NUMBERS_RANGE_END);

        if (!isRange) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        Set<Integer> validatedNumbers = new HashSet<>();

        for (Integer number : numbers) {
            if (!validatedNumbers.add(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
