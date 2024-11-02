package domain.lotto;

import domain.error.InputErrorMessage;
import domain.error.LottoErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateWinnerNumberRangeAndCount(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoErrorMessage.LOTTO_NUMBER_COUNT.getErrorMessage());
        }
        int left = 0;
        while (left < 6) {
            for (int right = left + 1; right < 6; right++) {
                if (numbers.get(left) == numbers.get(right)) {
                    throw new IllegalArgumentException(LottoErrorMessage.DUPLICATE_LOTTO_NUMBER.getErrorMessage());
                }
            }
            left++;
        }
    }

    private void validateWinnerNumberRangeAndCount(List<Integer> numbers) {
        if (Collections.min(numbers) < LottoCondition.START_INCLUSIVE.getConditionNumber()
                || Collections.max(numbers) > LottoCondition.END_INCLUSIVE.getConditionNumber()) {
            throw new IllegalArgumentException(InputErrorMessage.WINNING_NUMBER_VALIDATION.getErrorMessage());
        }
    }
}
