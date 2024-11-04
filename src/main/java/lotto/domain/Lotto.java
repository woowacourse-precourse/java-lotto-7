package lotto.domain;

import lotto.utils.ErrorMessage;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.LOTTO_NUMBER_COUNT_INVALID);
        }
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.LOTTO_NUMBER_DUPLICATED);
        }
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.ERROR_PREFIX + ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE);
            }
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
