package lotto.domain;

import lotto.exception.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_COUNT = 6; // 로또 번호 개수
    private static final int MIN_NUMBER = 1; // 로또 번호 최소값
    private static final int MAX_NUMBER = 45; // 로또 번호 최대값

    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateNumbersRange(numbers);
        validateUniqueNumbers(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS_COUNT.getMessage());
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!isInRange(number)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }
    private boolean isInRange(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }
    private void validateUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBERS.getMessage());
        }
    }

}