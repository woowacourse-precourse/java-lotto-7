package lotto;

import lotto.domain.LottoCondition;
import lotto.domain.errorMessage.InputErrorMessage;
import lotto.domain.errorMessage.LottoErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateWinnerNumberRangeAndCount(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoCondition.MAX_COUNT.getConditionNumber()) {
            throw new IllegalArgumentException(LottoErrorMessage.LOTTO_NUMBER_COUNT_ERROR.getErrorMessage());
        }
        validateDuplicateNumbers(numbers);
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        int leftPointer = 0;
        while (leftPointer < LottoCondition.MAX_COUNT.getConditionNumber()) {
            for (int rightPointer = leftPointer + 1; rightPointer < LottoCondition.MAX_COUNT.getConditionNumber(); rightPointer++) {
                if (numbers.get(leftPointer) == numbers.get(rightPointer)) {
                    throw new IllegalArgumentException(LottoErrorMessage.DUPLICATE_LOTTO_NUMBER_ERROR.getErrorMessage());
                }
            }
            leftPointer++;
        }
    }

    private void validateWinnerNumberRangeAndCount(List<Integer> numbers) {
        if (Collections.min(numbers) < LottoCondition.START_INCLUSIVE.getConditionNumber()
                || Collections.max(numbers) > LottoCondition.END_INCLUSIVE.getConditionNumber()) {
            throw new IllegalArgumentException(InputErrorMessage.WINNING_NUMBER_VALIDATION.getErrorMessage());
        }
    }
}
