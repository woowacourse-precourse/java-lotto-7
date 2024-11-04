package lotto.model;

import static lotto.enums.ErrorCode.DUPLICATE_LOTTO_NUMBER;
import static lotto.enums.ErrorCode.INVALID_LOTTO_NUMBER_COUNT;
import static lotto.enums.ErrorCode.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.enums.ErrorCode.NON_NUMERIC_LOTTO_NUMBER;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;
    private static final String DELIMITER = ",";

    private List<Integer> numbers;

    public WinningNumbers(String numbersInput) {
        List<Integer> numbers = parseNumbersInput(numbersInput);
        validateNumbers(numbers);

        this.numbers = numbers;
    }

    private List<Integer> parseNumbersInput(String input) {
        String[] splitInput = input.split(DELIMITER);
        List<Integer> numbers = new ArrayList<>();
        for (String num : splitInput) {
            checkIsNumber(num);
            numbers.add(Integer.parseInt(num));
        }
        return numbers;
    }

    private void checkIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateNumbers(List<Integer> numbers) {
        checkNumberCount(numbers);
        checkUniqueNumbers(numbers);
        checkNumberRange(numbers);
    }

    private void checkNumberCount(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void checkUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private void checkNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
