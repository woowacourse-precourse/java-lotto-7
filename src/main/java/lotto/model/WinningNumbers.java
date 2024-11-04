package lotto.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lotto.model.constant.ErrorMessage;

public class WinningNumbers {
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER);
        }
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
