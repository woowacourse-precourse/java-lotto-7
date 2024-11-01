package lotto.model;

import static lotto.common.LottoRule.LOTTO_END_NUMBER;
import static lotto.common.LottoRule.LOTTO_NUMBER_COUNTS;
import static lotto.common.LottoRule.LOTTO_START_NUMBER;
import static lotto.validator.ValidationMessage.DUPLICATE_NUMBERS;
import static lotto.validator.ValidationMessage.INVALID_NUMBER_COUNTS;
import static lotto.validator.ValidationMessage.INVALID_NUMBER_RANGE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.InvalidInputException;

public record WinningNumbers(List<Integer> numbers) {
    public WinningNumbers {
        validateNumberCount(numbers);
        validateNoDuplicate(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNTS.getValue()) {
            throw new InvalidInputException(INVALID_NUMBER_COUNTS.getMessage());
        }
    }

    private void validateNoDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new InvalidInputException(DUPLICATE_NUMBERS.getMessage());
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(number -> number < LOTTO_START_NUMBER.getValue() || number > LOTTO_END_NUMBER.getValue())) {
            throw new InvalidInputException(INVALID_NUMBER_RANGE.getMessage());
        }
    }
}
