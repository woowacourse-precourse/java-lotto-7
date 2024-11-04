package lotto.domain;

import lotto.common.ExceptionMessage;
import lotto.common.Limit;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateNoDuplicates(numbers);
        validateNumberRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != Limit.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBERS_COUNT);
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != Limit.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_NUMBERS);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < Limit.LOTTO_MIN_NUMBER || num > Limit.LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_OUT_OF_RANGE);
        }
    }

}
