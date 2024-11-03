package lotto.domain;


import java.util.ArrayList;
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
        validateDuplicateNumber(numbers);
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        long result = numbers.stream()
                .distinct()
                .count();

        if (result != LOTTO_NUMBER_PICK_COUNT) {
            throw new IllegalArgumentException(NOT_MATCHED_NUMBER_COUNT
                    .getMessageWithArgs(LOTTO_NUMBER_PICK_COUNT));
        }
    }

    private void validateNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (LOTTO_NUMBER_RANGE_START > number || LOTTO_NUMBER_RANGE_END < number) {
                throw new IllegalArgumentException(OUT_OF_LOTTO_RANGE
                        .getMessageWithArgs(LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END));
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
        if (numbers.size() != LOTTO_NUMBER_PICK_COUNT) {
            throw new IllegalArgumentException(NOT_MATCHED_NUMBER_COUNT
                    .getMessageWithArgs(LOTTO_NUMBER_PICK_COUNT));
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        sortedNumbers.sort(Integer::compareTo);
        return sortedNumbers.toString();
    }
}
