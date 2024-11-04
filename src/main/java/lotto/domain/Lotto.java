package lotto.domain;

import static lotto.constant.Constants.LOTTO_NUMBER_RANGE_REGEX;
import static lotto.constant.Constants.LOTTO_NUMBER_SIZE;
import static lotto.exception.printException.throwIllegalArgException;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorMessage;

public class Lotto { // 일급컬렉션으로 사용

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throwIllegalArgException(ErrorMessage.INVALID_LOTTO_NUMS_COUNT);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(numbers);
        if (nonDuplicateNumbers.size() != LOTTO_NUMBER_SIZE) {
            throwIllegalArgException(ErrorMessage.LOTTO_NUM_DUPLICATE);
        }
    }

    public void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!number.toString().matches(LOTTO_NUMBER_RANGE_REGEX)) {
                throwIllegalArgException(ErrorMessage.LOTTO_NUM_NOT_IN_RANGE);
            }
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
