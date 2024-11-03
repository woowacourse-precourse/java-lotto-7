package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.NumberConstant;

import java.util.Collections;
import java.util.List;

import static lotto.constant.ErrorMessage.*;
import static lotto.constant.NumberConstant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateLottoNumbers(List<Integer> numbers) {
        validateNumberSize(numbers);
        validatePositiveNumber(numbers);
        validateNumberInRange(numbers);
    }

    private void validateNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (LOTTO_NUMBER_RANGE_START > number || LOTTO_NUMBER_RANGE_END < number) {
                throw new IllegalArgumentException(OUT_OF_LOTTO_RANGE.getMessage());
            }
        }
    }

    private void validatePositiveNumber(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number <= 0) {
                throw new IllegalArgumentException(ONLY_POSITIVE_NUMBER.getMessage());
            }
        }
    }

    private void validateNumberSize(List<Integer> numbers) {
        long result = numbers.stream()
                .distinct()
                .count();

        if (result != LOTTO_NUMBER_PICK_COUNT) {
            throw new IllegalArgumentException(NOT_MATCHED_WINNING_NUMBER_COUNT.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        numbers.sort(Integer::compareTo);
        return numbers.toString();
    }
}
