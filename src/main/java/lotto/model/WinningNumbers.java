package lotto.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lotto.model.constant.ErrorMessage;

public class WinningNumbers {
    private final List<Integer> numbers;
    private static final int MIN_NUMBER_VALUE = 1;
    private static final int MAX_NUMBER_VALUE = 45;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT);
        }
        if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
        }
        if (!isValidNumberRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    private boolean isValidNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER_VALUE || number > MAX_NUMBER_VALUE) {
                return false;
            }
        }

        return true;
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() < numbers.size();
    }

    public static WinningNumbers from(List<Integer> numbers) {
        return new WinningNumbers(numbers);
    }

    public Iterator<Integer> getNumbers() {
        return numbers.iterator();
    }
}
