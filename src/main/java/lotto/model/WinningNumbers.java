package lotto.model;

import static lotto.utils.Error.DUPLICATED_WINNING_NUMBERS;
import static lotto.utils.Error.NOT_SIX_WINNING_NUMBERS;
import static lotto.utils.Error.WINNING_NUMBERS_OUT_OF_RANGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private static final Integer VALID_LENGTH = 6;
    private static final Integer MINIMUM_NUMBER = 1;
    private static final Integer MAXIMUM_NUMBER = 45;
    private final List<Integer> numbers;

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateSixLottoNumbers(numbers);
        validateNoDuplicate(numbers);
        validateNumbersInRange(numbers);
    }

    private void validateSixLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != VALID_LENGTH) {
            throw new IllegalArgumentException(NOT_SIX_WINNING_NUMBERS.getDescription());
        }
    }

    private void validateNoDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException(DUPLICATED_WINNING_NUMBERS.getDescription());
        }
    }

    private void validateNumbersInRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < MINIMUM_NUMBER || MAXIMUM_NUMBER < number) {
                throw new IllegalArgumentException(WINNING_NUMBERS_OUT_OF_RANGE.getDescription());
            }
        });
    }
}
