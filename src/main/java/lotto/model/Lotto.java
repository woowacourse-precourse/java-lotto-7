package lotto.model;

import java.util.List;
import lotto.exception.CustomException;
import lotto.exception.ErrorCode;

public class Lotto {
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        checkCount(numbers);
        checkRange(numbers);
        checkDuplicate(numbers);
    }

    private void checkCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new CustomException(ErrorCode.INVALID_LOTTO_SIZE);
        }
    }

    private void checkRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < MIN_NUMBER || num > MAX_NUMBER)) {
            throw new CustomException(ErrorCode.INVALID_LOTTO_RANGE);
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new CustomException(ErrorCode.DUPLICATE_LOTTO);
        }
    }
}